package hn.devsu.excersice.clientes.domain.repository;

import java.util.List;

import hn.devsu.excersice.clientes.domain.Cuenta;

public interface CuentaRepository {
    Cuenta save(Cuenta cuenta);
    List<Cuenta> findByClienteId(Integer idCliente);
    Cuenta findById(Integer idCliente);
    List<Cuenta> findAll();
    String deleteById(int id);
}
