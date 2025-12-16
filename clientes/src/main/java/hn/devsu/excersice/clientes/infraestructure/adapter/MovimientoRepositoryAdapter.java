package hn.devsu.excersice.clientes.infraestructure.adapter;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import hn.devsu.excersice.clientes.domain.Movimiento;
import hn.devsu.excersice.clientes.domain.repository.MovimientoRepository;
import hn.devsu.excersice.clientes.infraestructure.jparepository.MovimientoJpaRepository;

@Repository
public class MovimientoRepositoryAdapter implements MovimientoRepository{

    private MovimientoJpaRepository jpaRepository;

    public MovimientoRepositoryAdapter(MovimientoJpaRepository jpaRepository){
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Movimiento> findByNumeroCuentaAndFechaMovimiento(int idCliente, LocalDateTime inicio, LocalDateTime fechaFinal) {
        return jpaRepository.findByCuenta_NumeroCuentaAndFechaMovimiento(idCliente, inicio, fechaFinal);
    }

    @Override
    public double sumarMovimientos(Integer idCuenta) {
        return jpaRepository.sumarMovimientos(idCuenta);
    }
    
}
