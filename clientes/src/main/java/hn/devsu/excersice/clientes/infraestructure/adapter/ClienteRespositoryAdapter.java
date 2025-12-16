package hn.devsu.excersice.clientes.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import hn.devsu.excersice.clientes.domain.Cliente;
import hn.devsu.excersice.clientes.domain.helpers.ClienteMapper;
import hn.devsu.excersice.clientes.domain.repository.ClienteRepository;
import hn.devsu.excersice.clientes.infraestructure.entity.ClienteEntity;
import hn.devsu.excersice.clientes.infraestructure.jparepository.ClienteJpaRepository;

@Repository
public class ClienteRespositoryAdapter implements ClienteRepository{

    private final ClienteJpaRepository jpaRepository;

    public ClienteRespositoryAdapter(ClienteJpaRepository jpaRepository){
        this.jpaRepository = jpaRepository;
    }


    @Override
    public Cliente save(Cliente cliente) {
        ClienteEntity recordCliente = ClienteMapper.mapearDominioEntidad(cliente);
        ClienteEntity guardado = jpaRepository.save(recordCliente);   
        
        return ClienteMapper.mapearEntidadDominio(guardado);
        
    }

    
    @Override
    public Optional<Cliente> findById(Integer id) {
        return jpaRepository.findById(id).map(ClienteMapper::mapearEntidadDominio);
    }

    @Override
    public List<Cliente> findAll() {
        return jpaRepository.findAll()
                            .stream()
                            .map(ClienteMapper::mapearEntidadDominio)     
        .toList();
    }

    @Override
    public String delete(int idCliente) {
        jpaRepository.deleteById(idCliente);
        return "Se ha eliminado correctamente";
        
    }



    
    
}
