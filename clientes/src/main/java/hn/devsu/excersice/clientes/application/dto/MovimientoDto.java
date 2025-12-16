package hn.devsu.excersice.clientes.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MovimientoDto {
    
    private int idMovimiento;

    private LocalDateTime fechaMovimiento;

    private double valorMovimiento;

    private double saldo;

}
