package hn.devsu.excersice.clientes.infraestructure.jparepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hn.devsu.excersice.clientes.domain.Cliente;
import hn.devsu.excersice.clientes.infraestructure.entity.ClienteEntity;

@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, Integer>{ 
    @EntityGraph(attributePaths = {"persona", "cuentas", "cuentas.movimientos"})
    Optional<Cliente> findById(int id);
}
