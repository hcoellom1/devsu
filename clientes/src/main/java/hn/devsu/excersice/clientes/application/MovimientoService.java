package hn.devsu.excersice.clientes.application;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import hn.devsu.excersice.clientes.domain.Cuenta;
import hn.devsu.excersice.clientes.domain.Movimiento;
import hn.devsu.excersice.clientes.domain.repository.CuentaRepository;

@Service
public class MovimientoService {
        private final CuentaRepository cuentaRepository;

    public MovimientoService(CuentaRepository cuentaRepository)
    {        
        this.cuentaRepository = cuentaRepository;
    }

    public void registrarMovimiento(int idCuenta, double valor){
        Movimiento movimiento = new Movimiento();
        movimiento.setFechaMovimiento(LocalDateTime.now());
        movimiento.setValor(valor);
        
        Cuenta cuenta = cuentaRepository.findById(idCuenta);
        cuenta.registrarMovimiento(movimiento);

        cuentaRepository.save(cuenta);


    }
    
}
