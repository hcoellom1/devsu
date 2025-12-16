package hn.devsu.excersice.clientes.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movimiento {
 
    private int id;

    private LocalDateTime fechaMovimiento;

    private double valor;

    private double saldo;
}
