package hn.devsu.excersice.clientes.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hn.devsu.excersice.clientes.entities.Cuenta;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer>{
    
    @EntityGraph(attributePaths = {"cuentas.movimientos"})
    Optional<Cuenta> findById(int id);
}
