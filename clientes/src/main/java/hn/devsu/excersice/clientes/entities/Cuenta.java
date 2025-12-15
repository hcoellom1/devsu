package hn.devsu.excersice.clientes.entities;

import lombok.Data;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cuenta")
@Data
public class Cuenta {
    
    @Id
    private UUID numeroCuenta;

    private String tipoCuenta;

    private double saldoInicial;

    private boolean estado;


}
