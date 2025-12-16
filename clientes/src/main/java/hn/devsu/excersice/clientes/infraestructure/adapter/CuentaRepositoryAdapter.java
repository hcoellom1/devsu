package hn.devsu.excersice.clientes.infraestructure.adapter;

import java.util.List;

import hn.devsu.excersice.clientes.domain.Cuenta;
import hn.devsu.excersice.clientes.domain.helpers.CuentaMapper;
import hn.devsu.excersice.clientes.domain.repository.CuentaRepository;
import hn.devsu.excersice.clientes.infraestructure.entity.CuentaEntity;
import hn.devsu.excersice.clientes.infraestructure.jparepository.CuentaJpaRepository;

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
    public Cuenta findById(Integer idCliente) {
        CuentaEntity cuentaEntity = jpaRepository.findById(idCliente)
                                            .orElseThrow(()-> new RuntimeException("No existe cuenta"));
        return CuentaMapper.mapearAdominio(cuentaEntity);        
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
        jpaRepository.deleteById(id);
        return "Se ha eliminado la cuenta: " + id;        
    }

 



}
