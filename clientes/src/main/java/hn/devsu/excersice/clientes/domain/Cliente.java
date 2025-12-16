package hn.devsu.excersice.clientes.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    private int id;

    private String contrasenia;
    
    private boolean estado;
    
    private Persona persona;

    private List<Cuenta> cuentas;

    public void agregarCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
    }

    public void registrarMovimiento(Integer idCuenta, Movimiento movimiento){
        Cuenta cuenta = cuentas.stream().filter(c->c.getNumeroCuenta()==idCuenta)
        .findFirst()
        .orElseThrow(()->new RuntimeException("Cuenta no encontrada"));

        cuenta.registrarMovimiento(movimiento);
    }
}
