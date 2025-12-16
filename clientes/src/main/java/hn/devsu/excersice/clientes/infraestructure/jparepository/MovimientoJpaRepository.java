package hn.devsu.excersice.clientes.infraestructure.jparepository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hn.devsu.excersice.clientes.domain.Movimiento;
import hn.devsu.excersice.clientes.infraestructure.entity.MovimientoEntity;

public interface MovimientoJpaRepository extends JpaRepository<MovimientoEntity, Integer>{


    List<Movimiento> findByCuentaIdAndFechaMovimiento(Integer idCliente, 
                                                  LocalDateTime fechaInicio,
                                                  LocalDateTime fechaFin);

    @Query("""
            select coalesce(sum(m.valor),0) from Movimiento m
           where m.cuenta.id = :idCuenta
           """)
    double sumarMovimientos(@Param("idcuenta") Integer idCuenta);
}
