package hn.devsu.excersice.clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.devsu.excersice.clientes.entities.Persona;

public interface PersonaRepository  extends JpaRepository<Persona, Integer>{
    
}
