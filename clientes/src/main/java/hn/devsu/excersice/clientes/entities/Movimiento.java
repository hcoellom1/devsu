package hn.devsu.excersice.clientes.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="movimiento")
@Data
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_movimiento")
    private int id;

    private LocalDateTime fechaMovimiento;

    private double valor;

    private double saldo;

    @ManyToOne
    @JoinColumn(name="numero_cuenta", nullable = false )
    private Cuenta cuenta;


    
}
