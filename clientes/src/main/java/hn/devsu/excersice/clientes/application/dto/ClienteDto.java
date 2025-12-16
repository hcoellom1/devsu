package hn.devsu.excersice.clientes.application.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClienteDto {
    private Integer codigoCliente;
    
    private String nombre;

    private String genero;

    private int edad;

    private String direccion;

    private String telefono;

    private String contrasenia;

    private boolean estado;

    private List<CuentaDto> cuentas;

}
