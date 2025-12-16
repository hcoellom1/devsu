package hn.devsu.excersice.clientes.application;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import hn.devsu.excersice.clientes.application.dto.CuentaDto;
import hn.devsu.excersice.clientes.application.dto.MovimientoDto;
import hn.devsu.excersice.clientes.domain.Cliente;
import hn.devsu.excersice.clientes.domain.Cuenta;
import hn.devsu.excersice.clientes.domain.Movimiento;
import hn.devsu.excersice.clientes.domain.exception.NotClientFoundException;
import hn.devsu.excersice.clientes.domain.exception.NotCuentaFoundException;
import hn.devsu.excersice.clientes.domain.repository.ClienteRepository;
import hn.devsu.excersice.clientes.domain.repository.CuentaRepository;
import hn.devsu.excersice.clientes.domain.repository.MovimientoRepository;

import jakarta.transaction.Transactional;

@Service
public class CuentaService {

    private final CuentaRepository cuentaRepository;
    private final ClienteRepository clienteRespository;
    private final MovimientoRepository movimientoRepository;

    public CuentaService(CuentaRepository cuentaRepository,
                         ClienteRepository clienteRespository,
                         MovimientoRepository movimientoRepository){
        this.cuentaRepository = cuentaRepository;
        this.clienteRespository = clienteRespository;
        this.movimientoRepository = movimientoRepository;
    }


    public CuentaDto crearCuenta(int idCliente, CuentaDto cuentaRequest){
        Cliente cliente = clienteRespository.findById(idCliente)
        .orElseThrow(()-> new NotClientFoundException(idCliente));

        Cuenta nvaCuenta = new Cuenta();
        nvaCuenta.setEstado(cuentaRequest.isEstado());
        nvaCuenta.setSaldoInicial(cuentaRequest.getSaldoInicial());
        nvaCuenta.setTipoCuenta(cuentaRequest.getTipoCuenta());
        

        cliente.agregarCuenta(nvaCuenta);        
        
        Cliente creada = clienteRespository.save(cliente);

        return new CuentaDto(creada.getCuentas().size()-1, 
                             cuentaRequest.getTipoCuenta(), 
                             cuentaRequest.getSaldoInicial(), 
                             cuentaRequest.isEstado(), 
                             0,
                             List.of());
        
    }



    public CuentaDto obtenerCuentaPorId(int idCuenta){
        Cuenta cuenta = cuentaRepository.findById(idCuenta).orElseThrow(()->new NotCuentaFoundException(idCuenta));

        List<MovimientoDto> movimientos = Optional.ofNullable(cuenta.getMovimientos()).orElse(Collections.emptyList()).stream()
        .map(m->new MovimientoDto(cuenta.getNumeroCuenta(), 
                                  m.getFechaMovimiento(),     
                                  m.getValor(), 
                                  m.getSaldo()
                    )).toList();

        return new CuentaDto(cuenta.getNumeroCuenta(), 
                             cuenta.getTipoCuenta(), 
                             cuenta.getSaldoInicial(), 
                             cuenta.isEstado(), 
                             cuenta.calcularSaldoActual(),
                             movimientos);
        
    }

    @Transactional
    public List<CuentaDto> obtenerCuentasPorCliente(int idCliente){
        Cliente cliente = clienteRespository.findById(idCliente).orElseThrow(()-> new NotClientFoundException(idCliente));

        return cliente.getCuentas()
                        .stream()
                .map(cuenta-> {
                List<MovimientoDto> movimientoDtos = Optional.ofNullable(cuenta.getMovimientos()).orElse(Collections.emptyList()).stream()
                .map(m->new MovimientoDto(m.getId(),
                        m.getFechaMovimiento(), 
                        m.getValor(),
                        m.getSaldo()))
                .toList();

                return new CuentaDto(cuenta.getNumeroCuenta(), 
                                     cuenta.getTipoCuenta(), 
                                     cuenta.getSaldoInicial(), 
                                     cuenta.isEstado(), 
                                     cuenta.calcularSaldoActual(),
                                     movimientoDtos);
                }).toList();
            
    }

    public List<CuentaDto> obtenerTodasCuentas(){
        List<Cuenta> cuentas = cuentaRepository.findAll();

        return cuentas.stream().map(cuenta-> {
            List<MovimientoDto> movimientoDtos = Optional.ofNullable(cuenta.getMovimientos()).orElse(Collections.emptyList()).stream()
            .map(m->new MovimientoDto(m.getId(),
                    m.getFechaMovimiento(), 
                    m.getValor(),
                    m.getSaldo()))
            .toList();

            return new CuentaDto(cuenta.getNumeroCuenta(), 
                                 cuenta.getTipoCuenta(), 
                                 cuenta.getSaldoInicial(), 
                                 cuenta.isEstado(), 
                                 cuenta.calcularSaldoActual(),
                                 movimientoDtos);
            }).toList();
    }


    public String actualizarCuenta(int idCuenta, CuentaDto cuentaReqest){
        Cuenta cuenta = cuentaRepository.findById(idCuenta).orElseThrow(()-> new NotCuentaFoundException(idCuenta));

        cuenta.setEstado(cuentaReqest.isEstado());
        cuenta.setSaldoInicial(cuentaReqest.getSaldoInicial());
        cuenta.setTipoCuenta(cuentaReqest.getTipoCuenta());

        cuentaRepository.save(cuenta);

        return "Se ha actualizado la cuenta: " + cuenta.getNumeroCuenta();        
    }

    public List<CuentaDto> generarEstadoCuenta(LocalDateTime fechaInicio, LocalDateTime fechaFinal, int idCliente){

        List<Cuenta> cuentas = cuentaRepository.findByClienteId(idCliente);

        return cuentas.stream().map(cuenta-> {
            List<Movimiento> movimientosRango = movimientoRepository.findByNumeroCuentaAndFechaMovimiento(cuenta.getNumeroCuenta(), fechaInicio, fechaFinal);            

            List<MovimientoDto> movimientosDto = movimientosRango.stream().map(m->new MovimientoDto(m.getId(), m.getFechaMovimiento(), m.getValor(), m.getSaldo())).toList();

            return new CuentaDto(cuenta.getNumeroCuenta(), 
                                 cuenta.getTipoCuenta(), 
                                 cuenta.getSaldoInicial(), 
                                 cuenta.isEstado(), 
                                 cuenta.calcularSaldoActual(),
                                 movimientosDto);


        }).toList();

    }


    
}
