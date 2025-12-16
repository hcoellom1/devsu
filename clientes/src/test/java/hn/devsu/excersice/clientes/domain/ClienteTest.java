package hn.devsu.excersice.clientes.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ClienteTest {
    
    @Test
    void testCrearCuenta(){
        Cliente cliente = new Cliente();
        cliente.setId(1);

        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta(333);

        cliente.agregarCuenta(cuenta);

        assertEquals(1, cliente.getCuentas().size());
        assertTrue(cliente.getCuentas().contains(cuenta));
    }

}
