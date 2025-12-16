package hn.devsu.excersice.clientes.infraestructure.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.devsu.excersice.clientes.infraestructure.entity.PersonaEntity;

public interface PersonaJpaRepository extends JpaRepository<PersonaEntity, Integer>{
    
}
