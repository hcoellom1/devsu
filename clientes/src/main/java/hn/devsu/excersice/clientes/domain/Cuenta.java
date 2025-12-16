package hn.devsu.excersice.clientes.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import hn.devsu.excersice.clientes.domain.exception.NotSaldoException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cuenta {
    private int numeroCuenta;

    private String tipoCuenta;

    private double saldoInicial;

    private boolean estado;    

    private List<Movimiento> movimientos = new ArrayList<>();

    public double calcularSaldoActual(){
        return saldoInicial + Optional.ofNullable(movimientos)
                            .orElse(Collections.emptyList())
                            .stream()                            
                            .mapToDouble(Movimiento::getValor)
                            .sum();
    }

    public void registrarMovimiento(Movimiento movimiento){
        double nuevoSaldo = calcularSaldoActual() + movimiento.getValor();
        if(nuevoSaldo==0){
            throw new NotSaldoException(numeroCuenta);
        }
        movimiento.setSaldo(nuevoSaldo);
        movimientos.add(movimiento);
    }

    
}
