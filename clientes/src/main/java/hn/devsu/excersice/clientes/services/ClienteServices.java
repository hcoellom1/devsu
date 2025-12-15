package hn.devsu.excersice.clientes.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hn.devsu.excersice.clientes.dtos.ClienteDto;
import hn.devsu.excersice.clientes.dtos.CuentaDto;
import hn.devsu.excersice.clientes.dtos.MovimientoDto;
import hn.devsu.excersice.clientes.entities.Cliente;
import hn.devsu.excersice.clientes.entities.Persona;
import hn.devsu.excersice.clientes.repositories.ClienteRepository;

@Service
public class ClienteServices {
    
    private final ClienteRepository clienteRepository;

    public ClienteServices(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public String crearCliente(ClienteDto nvoCliente){
        
        Persona persona = new Persona();        
        persona.setNombre(nvoCliente.getNombre());
        persona.setGenero(nvoCliente.getGenero());
        persona.setEdad(nvoCliente.getEdad());
        persona.setDireccion(nvoCliente.getDirecion());
        persona.setTelefono(nvoCliente.getTelefono());

        Cliente cliente = new Cliente();
        cliente.setContrasenia(nvoCliente.getContrasenia());
        cliente.setEstado(true);

        clienteRepository.save(cliente);

        return "Se ha creado el cliente: " + clienteRepository.save(cliente).getId();

    }
    
    public List<ClienteDto> obtenerTodosCliente(){
        return clienteRepository.findAll().stream()
        .map(cliente -> {
            List<CuentaDto> cuentasDto = cliente.getCuentas().stream()
            .map(cuenta -> {
                List<MovimientoDto> movimientoDtos = cuenta.getMovimientos().stream()
                .map(m-> new MovimientoDto(m.getId(), 
                                           m.getFechaMovimiento(), 
                                           m.getValor(), 
                                           m.getSaldo()))
                .collect(Collectors.toList());    
                
                return new CuentaDto(cuenta.getNumeroCuenta(), 
                                     cuenta.getTipoCuenta(), 
                                     cuenta.getSaldoInicial(), 
                                     cuenta.isEstado(), 
                                     movimientoDtos); 

            }).collect(Collectors.toList());

            var persona = cliente.getPersona();

            return new ClienteDto(cliente.getId(), 
                                  persona.getNombre(), 
                                  persona.getGenero(), 
                                  persona.getEdad(), 
                                  persona.getDireccion(), 
                                  persona.getTelefono(), 
                                  cliente.getContrasenia(), 
                                  cliente.isEstado(),
                                  cuentasDto );
        }).collect(Collectors.toList());
        
    }

    public ClienteDto obtenerPorId(int idCliente){
        Cliente clienteBuscar = clienteRepository
                                    .findById(idCliente)
                                    .orElseThrow(() -> new RuntimeException("Cliente no existe"));

        List<CuentaDto> cuentasDto = clienteBuscar.getCuentas()
                                                  .stream()
            .map(cuenta-> {
                List<MovimientoDto> movimientoDtos = cuenta.getMovimientos().stream()
                        .map(m->new MovimientoDto(m.getId(),
                                                  m.getFechaMovimiento(), 
                                                  m.getValor(),
                                                  m.getSaldo()))
                        .collect(Collectors.toList());

                return new CuentaDto(cuenta.getNumeroCuenta(), cuenta.getTipoCuenta(), cuenta.getSaldoInicial(), cuenta.isEstado(), movimientoDtos);
            }).collect(Collectors.toList());

            var persona = clienteBuscar.getPersona();

            return new ClienteDto(clienteBuscar.getId(), 
                                  persona.getNombre(), 
                                  persona.getGenero(), 
                                  persona.getEdad(), 
                                  persona.getDireccion(), 
                                  persona.getTelefono(), 
                                  clienteBuscar.getContrasenia(), 
                                  clienteBuscar.isEstado(),
                                  cuentasDto);

        
    }

    public String eliminarClientePorId(int idCliente){
        clienteRepository.deleteById(idCliente);
        return "Se ha eliminado el cliente: " + idCliente;
    }


    public String actualizarCliente(int idCliente, ClienteDto cliente){
        Cliente clienteActualizar = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no existe"));

        clienteActualizar.getPersona().setNombre(cliente.getNombre());
        clienteActualizar.getPersona().setTelefono(cliente.getTelefono());
        clienteActualizar.getPersona().setDireccion(cliente.getDirecion());
        clienteActualizar.getPersona().setEdad(cliente.getEdad());
        clienteActualizar.setContrasenia(cliente.getContrasenia());
        clienteActualizar.setEstado(cliente.isEstado());

        clienteRepository.save(clienteActualizar);
        
        return "Se ha actualizado el cliente: " +clienteActualizar.getId();

    }
    

}
