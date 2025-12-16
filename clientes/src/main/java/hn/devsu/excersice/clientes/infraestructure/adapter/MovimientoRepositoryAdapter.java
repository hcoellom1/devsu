package hn.devsu.excersice.clientes.infraestructure.adapter;

import java.time.LocalDateTime;
import java.util.List;

import hn.devsu.excersice.clientes.domain.Movimiento;
import hn.devsu.excersice.clientes.domain.repository.MovimientoRepository;
import hn.devsu.excersice.clientes.infraestructure.jparepository.MovimientoJpaRepository;

public class MovimientoRepositoryAdapter implements MovimientoRepository{

    private MovimientoJpaRepository jpaRepository;

    public MovimientoRepositoryAdapter(MovimientoJpaRepository jpaRepository){
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Movimiento> getByClienteAndFecha(int idCliente, LocalDateTime inicio, LocalDateTime fechaFinal) {
        return jpaRepository.findByCuentaIdAndFechaMovimiento(idCliente, inicio, fechaFinal);
    }

    @Override
    public double sumarMovimientos(Integer idCuenta) {
        return jpaRepository.sumarMovimientos(idCuenta);
    }
    
}
