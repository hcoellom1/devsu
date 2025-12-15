package hn.devsu.excersice.clientes.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hn.devsu.excersice.clientes.entities.Cliente;
import java.util.Optional;


@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Integer>{
 
    @EntityGraph(attributePaths = {"persona", "cuentas", "cuentas.movimientos"})
    Optional<Cliente> findById(int id);
    
}
