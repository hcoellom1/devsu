package hn.devsu.excersice.clientes.services;

import java.time.LocalDateTime;

import hn.devsu.excersice.clientes.dtos.MovimientoDto;
import hn.devsu.excersice.clientes.entities.Cuenta;
import hn.devsu.excersice.clientes.entities.Movimiento;
import hn.devsu.excersice.clientes.repositories.CuentaRepository;
import hn.devsu.excersice.clientes.repositories.MovimientoRepository;

public class MovimientoService {

    private final MovimientoRepository movimientoRepository;
    
    private final CuentaRepository cuentaRepository;

    public MovimientoService(MovimientoRepository movimientoRepository, CuentaRepository cuentaRepository){
        this.movimientoRepository = movimientoRepository;
        this.cuentaRepository = cuentaRepository;
    }

    public String registrarMovimiento(int idCuenta, MovimientoDto movimiento){
        Cuenta cuenta = cuentaRepository.findById(idCuenta)
                        .orElseThrow(()->new RuntimeException("No existe cuenta"));

        double saldoActual = cuenta.getMovimientos()
                        .stream()
                        .mapToDouble(Movimiento::getValor)
                        .sum();
        
        if(saldoActual == 0){
            return "No existe saldo disponible";
        }

        double nvoSaldo = cuenta.getSaldoInicial() + saldoActual;

        Movimiento nvoMovimiento = new Movimiento();
        nvoMovimiento.setFechaMovimiento(LocalDateTime.now());
        nvoMovimiento.setValor(movimiento.getValorMovimiento());
        nvoMovimiento.setSaldo(nvoSaldo);

        Movimiento movimientoGuardado = movimientoRepository.save(nvoMovimiento);

        /*return new MovimientoDto(cuenta.getNumeroCuenta(), 
                                 movimientoGuardado.getFechaMovimiento(), 
                                 movimiento.getValorMovimiento(), 
                                 nvoSaldo);*/

        return "Movimiento registrado de manera exitosa: " + movimientoGuardado.getId();


    }
    
}
