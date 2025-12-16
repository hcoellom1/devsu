package hn.devsu.excersice.clientes.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import hn.devsu.excersice.clientes.domain.Cuenta;
import hn.devsu.excersice.clientes.domain.exception.NotCuentaFoundException;
import hn.devsu.excersice.clientes.domain.helpers.CuentaMapper;
import hn.devsu.excersice.clientes.domain.repository.CuentaRepository;
import hn.devsu.excersice.clientes.infraestructure.entity.CuentaEntity;
import hn.devsu.excersice.clientes.infraestructure.jparepository.CuentaJpaRepository;

@Repository
public class CuentaRepositoryAdapter implements CuentaRepository{
    
    private final CuentaJpaRepository jpaRepository;
    
    public CuentaRepositoryAdapter(CuentaJpaRepository jpaRepository){
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Cuenta save(Cuenta cuenta) {
        CuentaEntity cuentaGuardar = CuentaMapper.mapearAentidad(cuenta);
        return  CuentaMapper.mapearAdominio(jpaRepository.save(cuentaGuardar));
    }

    @Override
    public List<Cuenta> findByClienteId(Integer idCliente) {    
        return jpaRepository.findByClienteId(idCliente)    
                    .stream()
                    .map(CuentaMapper::mapearAdominio)
                    .toList();        
    }

    @Override
    public Optional<Cuenta> findById(Integer idCliente) {
        return jpaRepository.findById(idCliente).map(CuentaMapper::mapearAdominio);        
    }

    @Override
    public List<Cuenta> findAll() {
        return jpaRepository.findAll()
                            .stream()
                            .map(CuentaMapper::mapearAdominio)
                            .toList();       

    }

    @Override
    public String deleteById(int id) {
        if(!jpaRepository.existsById(id)){
            throw new NotCuentaFoundException(id);
        }
        
        jpaRepository.deleteById(id);
        return "Se ha eliminado la cuenta: " + id;        
    }

 



}
