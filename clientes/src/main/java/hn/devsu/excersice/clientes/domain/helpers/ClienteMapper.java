package hn.devsu.excersice.clientes.domain.helpers;

import hn.devsu.excersice.clientes.domain.Cliente;
import hn.devsu.excersice.clientes.domain.Persona;
import hn.devsu.excersice.clientes.infraestructure.entity.ClienteEntity;
import hn.devsu.excersice.clientes.infraestructure.entity.PersonaEntity;

public class ClienteMapper {

    private ClienteMapper(){}
    
    public static ClienteEntity mapearDominioEntidad(Cliente cliente){
        if(cliente== null) return null;

        ClienteEntity nvoCliente = new ClienteEntity();
        nvoCliente.setContrasenia(cliente.getContrasenia());
        nvoCliente.setEstado(cliente.isEstado());

        if(cliente.getPersona() != null){
            PersonaEntity nvaPersona = new PersonaEntity();
            nvaPersona.setNombre(cliente.getPersona().getNombre());
            nvaPersona.setGenero(cliente.getPersona().getGenero());
            nvaPersona.setEdad(cliente.getPersona().getEdad());
            nvaPersona.setDireccion((cliente.getPersona().getDireccion()));
            nvaPersona.setTelefono(cliente.getPersona().getTelefono());

            nvoCliente.setPersonaEntity(nvaPersona);
        }
        
        return nvoCliente;
    }

    public static Cliente mapearEntidadDominio(ClienteEntity clienteEntity){
        if(clienteEntity == null ) return null;

        Cliente nvoCliente = new Cliente();
        nvoCliente.setId(clienteEntity.getId());
        nvoCliente.setContrasenia(clienteEntity.getContrasenia());
    
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

        return nvoCliente;

    }
}
