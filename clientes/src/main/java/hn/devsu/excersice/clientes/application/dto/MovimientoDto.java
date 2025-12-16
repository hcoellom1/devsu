package hn.devsu.excersice.clientes.application.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MovimientoDto {
    
    private Integer idMovimiento;

    private LocalDateTime fechaMovimiento;

    private double valorMovimiento;

    private double saldo;

}
