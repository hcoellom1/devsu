package hn.devsu.excersice.clientes.entities;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@Table(name="cliente")
@PrimaryKeyJoinColumn(name="id")
@Data
public class Cliente extends Persona{
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contrasenia;

    private boolean estado;
    
}
