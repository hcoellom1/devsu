package hn.devsu.excersice.clientes.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class CuentaTest {

    @Test
    void registrarMovimiento(){

        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta(101190);
        cuenta.setTipoCuenta("Ahorro");
        cuenta.setEstado(true);
        cuenta.setSaldoInicial(100);

        Movimiento movimiento = new Movimiento();
        movimiento.setId(1);
        movimiento.setFechaMovimiento(LocalDateTime.now());
        movimiento.setValor(100);

        cuenta.registrarMovimiento(movimiento);


        assertEquals(1, cuenta.getMovimientos().size());
        assertEquals(200, cuenta.calcularSaldoActual());

    }

}
