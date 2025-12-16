package hn.devsu.excersice.clientes.infraestructure.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="movimiento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_movimiento")
    private int id;

    @Column(name="fecha_movimiento")
    private LocalDateTime fechaMovimiento;

    private double valor;

    private double saldo;

    @ManyToOne
    @JoinColumn(name="numero_cuenta", nullable = false )
    private CuentaEntity cuenta;
    
}
