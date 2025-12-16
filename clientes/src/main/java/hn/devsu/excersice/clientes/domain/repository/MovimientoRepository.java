package hn.devsu.excersice.clientes.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.query.Param;

import hn.devsu.excersice.clientes.domain.Movimiento;

public interface MovimientoRepository {
    
    List<Movimiento> getByClienteAndFecha(int idCliente, LocalDateTime inicio, LocalDateTime fechaFinal);

    double sumarMovimientos(@Param("idcuenta") Integer idCuenta);
}
