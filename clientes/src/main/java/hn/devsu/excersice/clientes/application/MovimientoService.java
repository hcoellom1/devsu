package hn.devsu.excersice.clientes.application;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import hn.devsu.excersice.clientes.domain.Cuenta;
import hn.devsu.excersice.clientes.domain.Movimiento;
import hn.devsu.excersice.clientes.domain.exception.NotCuentaFoundException;
import hn.devsu.excersice.clientes.domain.repository.CuentaRepository;

@Service
public class MovimientoService {
        private final CuentaRepository cuentaRepository;

    public MovimientoService(CuentaRepository cuentaRepository)
    {        
        this.cuentaRepository = cuentaRepository;
    }

    public String registrarMovimiento(int idCuenta, double valor){
        Cuenta cuenta = cuentaRepository.findById(idCuenta).orElseThrow(() -> new NotCuentaFoundException(idCuenta));

        Movimiento movimiento = new Movimiento();
        movimiento.setFechaMovimiento(LocalDateTime.now());
        movimiento.setValor(valor);
        
        
        cuenta.registrarMovimiento(movimiento);
        

        cuentaRepository.save(cuenta);

        return "El nuevo saldo de la cuenta es: " + cuenta.calcularSaldoActual();


    }
    
}
