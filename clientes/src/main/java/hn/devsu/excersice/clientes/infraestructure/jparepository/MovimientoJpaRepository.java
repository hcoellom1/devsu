package hn.devsu.excersice.clientes.infraestructure.jparepository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hn.devsu.excersice.clientes.domain.Movimiento;
import hn.devsu.excersice.clientes.infraestructure.entity.MovimientoEntity;

public interface MovimientoJpaRepository extends JpaRepository<MovimientoEntity, Integer>{


    List<Movimiento> findByCuenta_NumeroCuentaAndFechaMovimiento(Integer idCliente, 
                                                  LocalDateTime fechaInicio,
                                                  LocalDateTime fechaFin);

    @Query("""
            select coalesce(sum(m.valor),0)
            from MovimientoEntity m
            where m.cuenta.numeroCuenta = :idCuenta
            """)
    double sumarMovimientos(@Param("idCuenta")Integer idCuenta);
}
