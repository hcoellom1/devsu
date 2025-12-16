package hn.devsu.excersice.clientes.application.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CuentaDto {
    
    private int numeroCuenta;

    private String tipoCuenta;

    private double saldoInicial;    

    private boolean estado;

    private double saldo;

    private List<MovimientoDto> movimientos;



}
