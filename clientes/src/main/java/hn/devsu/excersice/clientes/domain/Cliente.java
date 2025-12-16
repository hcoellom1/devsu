package hn.devsu.excersice.clientes.domain;

import java.util.ArrayList;
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

    private List<Cuenta> cuentas = new ArrayList<Cuenta>() {
        
    };

    public void agregarCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
    }

    
}
