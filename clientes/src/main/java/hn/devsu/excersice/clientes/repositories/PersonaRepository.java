package hn.devsu.excersice.clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hn.devsu.excersice.clientes.entities.Persona;


@Repository
public interface PersonaRepository  extends JpaRepository<Persona, Integer>{
    
}
