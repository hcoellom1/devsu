package hn.devsu.excersice.clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.devsu.excersice.clientes.entities.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer>{
    
}
