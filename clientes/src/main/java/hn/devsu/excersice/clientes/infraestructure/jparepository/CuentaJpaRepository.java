package hn.devsu.excersice.clientes.infraestructure.jparepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import hn.devsu.excersice.clientes.domain.Cuenta;
import hn.devsu.excersice.clientes.infraestructure.entity.CuentaEntity;

public interface CuentaJpaRepository extends JpaRepository<CuentaEntity, Integer>{

    List<CuentaEntity> findByClienteId(int clienteId);

    @EntityGraph(attributePaths = {"cuentas.movimientos"})
    Optional<Cuenta> findById(int id);

    
}
