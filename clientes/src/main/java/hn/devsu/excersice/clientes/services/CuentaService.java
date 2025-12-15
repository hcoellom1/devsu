package hn.devsu.excersice.clientes.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hn.devsu.excersice.clientes.dtos.CuentaDto;
import hn.devsu.excersice.clientes.dtos.MovimientoDto;
import hn.devsu.excersice.clientes.entities.Cliente;
import hn.devsu.excersice.clientes.entities.Cuenta;
import hn.devsu.excersice.clientes.repositories.ClienteRepository;
import hn.devsu.excersice.clientes.repositories.CuentaRepository;
import jakarta.transaction.Transactional;

@Service
public class CuentaService {

    private final CuentaRepository cuentaRepository;
    private final ClienteRepository clienteRepository;

    public CuentaService(CuentaRepository cuentaRepository, ClienteRepository clienteRepository){
        this.cuentaRepository = cuentaRepository;
        this.clienteRepository = clienteRepository;
    }

    public CuentaDto crearCuenta(int idCliente, CuentaDto cuentaRequest){
        Cliente cliente = clienteRepository.findById(idCliente)
        .orElseThrow(()-> new RuntimeException("No existe el cliente"));

        Cuenta nvaCuenta = new Cuenta();
        nvaCuenta.setEstado(cuentaRequest.isEstado());
        nvaCuenta.setSaldoInicial(cuentaRequest.getSaldoInicial());
        nvaCuenta.setCliente(cliente);
        
        Cuenta creada = cuentaRepository.save(nvaCuenta);

        return new CuentaDto(creada.getNumeroCuenta(), 
                             cuentaRequest.getTipoCuenta(), 
                             cuentaRequest.getSaldoInicial(), 
                             cuentaRequest.isEstado(), List.of());
        
    }

    public CuentaDto obtenerCuentaPorId(int idCuenta){
        Cuenta cuenta = cuentaRepository
        .findById(idCuenta)
        .orElseThrow(()->new RuntimeException("No existe la cuenta"));

        List<MovimientoDto> movimientos = cuenta.getMovimientos().stream()
        .map(m->new MovimientoDto(cuenta.getNumeroCuenta(), 
                                  m.getFechaMovimiento(),     
                                  m.getValor(), 
                                  m.getSaldo()
                    )).collect(Collectors.toList());

        return new CuentaDto(cuenta.getNumeroCuenta(), cuenta.getTipoCuenta(), cuenta.getSaldoInicial(), cuenta.isEstado(), movimientos);
        
    }

    @Transactional
    public List<CuentaDto> obtenerCuentasPorCliente(int idCliente){
        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(()-> new RuntimeException("No existe cliente"));

        return cliente.getCuentas()
                        .stream()
                .map(cuenta-> {
                List<MovimientoDto> movimientoDtos = cuenta.getMovimientos().stream()
                .map(m->new MovimientoDto(m.getId(),
                        m.getFechaMovimiento(), 
                        m.getValor(),
                        m.getSaldo()))
                .collect(Collectors.toList());

                return new CuentaDto(cuenta.getNumeroCuenta(), cuenta.getTipoCuenta(), cuenta.getSaldoInicial(), cuenta.isEstado(), movimientoDtos);
                }).collect(Collectors.toList());
            
    }

    public List<CuentaDto> obtenerTodasCuentas(){
        List<Cuenta> cuentas = cuentaRepository.findAll();

        return cuentas.stream().map(cuenta-> {
            List<MovimientoDto> movimientoDtos = cuenta.getMovimientos().stream()
            .map(m->new MovimientoDto(m.getId(),
                    m.getFechaMovimiento(), 
                    m.getValor(),
                    m.getSaldo()))
            .collect(Collectors.toList());

            return new CuentaDto(cuenta.getNumeroCuenta(), cuenta.getTipoCuenta(), cuenta.getSaldoInicial(), cuenta.isEstado(), movimientoDtos);
            }).collect(Collectors.toList());
    }


    public String actualizarCuenta(int idCuenta, CuentaDto cuentaReqest){
        Cuenta cuenta = cuentaRepository.findById(idCuenta).orElseThrow(()-> new RuntimeException("No existe la cuenta"));

        cuenta.setEstado(cuentaReqest.isEstado());
        cuenta.setSaldoInicial(cuentaReqest.getSaldoInicial());
        cuenta.setTipoCuenta(cuentaReqest.getTipoCuenta());

        cuentaRepository.save(cuenta);

        return "Se ha actualizado la cuenta: " + cuenta.getNumeroCuenta();
        
    }
    
}
