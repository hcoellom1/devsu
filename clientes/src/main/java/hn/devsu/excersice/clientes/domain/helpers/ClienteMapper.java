package hn.devsu.excersice.clientes.domain.helpers;

import java.util.ArrayList;
import java.util.List;

import hn.devsu.excersice.clientes.domain.Cliente;
import hn.devsu.excersice.clientes.domain.Cuenta;
import hn.devsu.excersice.clientes.domain.Persona;
import hn.devsu.excersice.clientes.infraestructure.entity.ClienteEntity;
import hn.devsu.excersice.clientes.infraestructure.entity.CuentaEntity;
import hn.devsu.excersice.clientes.infraestructure.entity.PersonaEntity;

public class ClienteMapper {

    private ClienteMapper(){}
    
    public static ClienteEntity mapearDominioEntidad(Cliente cliente){
        if(cliente== null) return null;

        ClienteEntity nvoCliente = new ClienteEntity();
        nvoCliente.setId(cliente.getId());
        nvoCliente.setContrasenia(cliente.getContrasenia());
        nvoCliente.setEstado(cliente.isEstado());

        if(cliente.getPersona() != null){
            PersonaEntity nvaPersona = new PersonaEntity();
            nvaPersona.setNombre(cliente.getPersona().getNombre());
            nvaPersona.setGenero(cliente.getPersona().getGenero());
            nvaPersona.setEdad(cliente.getPersona().getEdad());
            nvaPersona.setDireccion((cliente.getPersona().getDireccion()));
            nvaPersona.setTelefono(cliente.getPersona().getTelefono());
            nvaPersona.setId(cliente.getPersona().getId());
            nvoCliente.setPersonaEntity(nvaPersona);
        }

        List<CuentaEntity> cuentas = new ArrayList<>();
        if(cliente.getCuentas()!=null){
            for(Cuenta c: cliente.getCuentas()){
                CuentaEntity ce = new CuentaEntity();
                ce.setNumeroCuenta(c.getNumeroCuenta());
                ce.setTipoCuenta(c.getTipoCuenta());
                ce.setSaldoInicial(c.getSaldoInicial());
                ce.setEstado(c.isEstado());
                ce.setCliente(nvoCliente);

                cuentas.add(ce);
            }
        }
        nvoCliente.setCuentas(cuentas);
        return nvoCliente;
    }

    public static Cliente mapearEntidadDominio(ClienteEntity clienteEntity){
        if(clienteEntity == null ) return null;

        Cliente nvoCliente = new Cliente();
        nvoCliente.setId(clienteEntity.getId());
        nvoCliente.setContrasenia(clienteEntity.getContrasenia());
        nvoCliente.setEstado(clienteEntity.isEstado());
        if(clienteEntity.getPersonaEntity()!= null){
            Persona persona = new Persona();
            persona.setId(clienteEntity.getPersonaEntity().getId());
            persona.setNombre(clienteEntity.getPersonaEntity().getNombre());
            persona.setEdad(clienteEntity.getPersonaEntity().getEdad());
            persona.setGenero(clienteEntity.getPersonaEntity().getGenero());
            persona.setTelefono(clienteEntity.getPersonaEntity().getTelefono());
            persona.setDireccion(clienteEntity.getPersonaEntity().getDireccion());

            nvoCliente.setPersona(persona);
        }

        List<Cuenta> cuentas = new ArrayList<>();
        if(clienteEntity.getCuentas()!=null){
            for(CuentaEntity ce: clienteEntity.getCuentas()){
                Cuenta c = CuentaMapper.mapearAdominio(ce);
                cuentas.add(c);
            }

        }

        nvoCliente.setCuentas(cuentas);

        return nvoCliente;

    }
}
