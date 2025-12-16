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
public class Cuenta {
    private int numeroCuenta;

    private String tipoCuenta;

    private double saldoInicial;

    private boolean estado;    

    private List<Movimiento> movimientos;

    public double calcularSaldoActual(){
        return saldoInicial + movimientos
                            .stream()
                            .mapToDouble(Movimiento::getValor)
                            .sum();
    }

    public void registrarMovimiento(Movimiento movimiento){
        double nuevoSaldo = calcularSaldoActual() + movimiento.getValor();
        if(nuevoSaldo==0){
            new IllegalStateException("No hay saldo disponible");
        }
        movimiento.setSaldo(nuevoSaldo);
        movimientos.add(movimiento);
    }

    
}
