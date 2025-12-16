package hn.devsu.excersice.clientes.domain.repository;

import java.util.List;
import java.util.Optional;

import hn.devsu.excersice.clientes.domain.Cliente;

public interface ClienteRepository {
    Cliente save(Cliente cliente);
    Optional<Cliente> findById(Integer id);
    List<Cliente> findAll();    
    String delete(int idCliente);    
    
}
