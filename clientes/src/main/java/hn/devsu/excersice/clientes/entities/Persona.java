package hn.devsu.excersice.clientes.entities;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="persona")
@Data
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPersona")
    private Integer id;

    private String nombre;    

    private String genero;
    
    private int edad;

    private String direccion;

    private String telefono;

}
