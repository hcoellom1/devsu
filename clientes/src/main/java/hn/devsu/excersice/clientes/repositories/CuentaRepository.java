package hn.devsu.excersice.clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.devsu.excersice.clientes.entities.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer>{
    
}
