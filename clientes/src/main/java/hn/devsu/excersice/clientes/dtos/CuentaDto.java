package hn.devsu.excersice.clientes.dtos;

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

    private List<MovimientoDto> movimientos;



}
