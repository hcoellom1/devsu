package hn.devsu.excersice.clientes.entities;

import lombok.Data;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente")
@Data
public class Cliente{    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private int id;

    private String contrasenia;

    private boolean estado;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="id_persona", nullable = false)
    private Persona persona;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Cuenta> cuentas;
    
}
