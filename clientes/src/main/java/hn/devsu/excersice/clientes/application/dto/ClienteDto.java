package hn.devsu.excersice.clientes.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClienteDto {
    private int codigoCliente;
    
    private String nombre;

    private String genero;

    private int edad;

    private String direcion;

    private String telefono;

    private String contrasenia;

    private boolean estado;

    private List<CuentaDto> cuentas;

}
