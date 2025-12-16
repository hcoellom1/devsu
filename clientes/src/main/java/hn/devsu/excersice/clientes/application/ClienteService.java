package hn.devsu.excersice.clientes.application;

import java.util.List;

import org.springframework.stereotype.Service;

import hn.devsu.excersice.clientes.application.dto.ClienteDto;
import hn.devsu.excersice.clientes.application.dto.CuentaDto;
import hn.devsu.excersice.clientes.application.dto.MovimientoDto;
import hn.devsu.excersice.clientes.domain.Cliente;
import hn.devsu.excersice.clientes.domain.Persona;
import hn.devsu.excersice.clientes.domain.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public Cliente crearCliente(ClienteDto cliente){
        
        Persona nvaPersona = new Persona();
        nvaPersona.setNombre(cliente.getNombre());
        nvaPersona.setEdad(cliente.getEdad());
        nvaPersona.setGenero(cliente.getGenero());
        nvaPersona.setDireccion(cliente.getDirecion());
        nvaPersona.setTelefono(cliente.getTelefono());

        Cliente nvoCliente = new Cliente();
        nvoCliente.setContrasenia(cliente.getContrasenia());
        nvoCliente.setEstado(cliente.isEstado());
        nvoCliente.setPersona(nvaPersona);

        return clienteRepository.save(nvoCliente);
    }

    public ClienteDto obtenerClientePorId(int id){
        Cliente clienteBuscar = clienteRepository
                                    .findById(id)
                                    .orElseThrow(() -> new RuntimeException("Cliente no existe"));

        List<CuentaDto> cuentasDto = clienteBuscar.getCuentas()
                                                  .stream()
            .map(cuenta-> {
                List<MovimientoDto> movimientoDtos = cuenta.getMovimientos().stream()
                        .map(m->new MovimientoDto(m.getId(),
                                                  m.getFechaMovimiento(), 
                                                  m.getValor(),
                                                  m.getSaldo()))
                        .toList();

                return new CuentaDto(cuenta.getNumeroCuenta(), cuenta.getTipoCuenta(), cuenta.getSaldoInicial(), cuenta.isEstado(), cuenta.calcularSaldoActual(), movimientoDtos);
            }).toList();

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
                .toList();    
                
                return new CuentaDto(cuenta.getNumeroCuenta(), 
                                     cuenta.getTipoCuenta(), 
                                     cuenta.getSaldoInicial(), 
                                     cuenta.isEstado(), 
                                     cuenta.calcularSaldoActual(),
                                     movimientoDtos); 

            }).toList();

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
        }).toList();



    }

    public String eliminarCliente(int id){
         clienteRepository.delete(id);
         return "Se ha eliminado el cliente: " + id;
    }
    

    public Cliente actualizarCliente(int idCliente, ClienteDto cliente){
        Cliente clienteActualizar = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no existe"));

        clienteActualizar.getPersona().setNombre(cliente.getNombre());
        clienteActualizar.getPersona().setTelefono(cliente.getTelefono());
        clienteActualizar.getPersona().setDireccion(cliente.getDirecion());
        clienteActualizar.getPersona().setEdad(cliente.getEdad());
        clienteActualizar.setContrasenia(cliente.getContrasenia());
        clienteActualizar.setEstado(cliente.isEstado());

        clienteRepository.save(clienteActualizar);

        return clienteActualizar;

    }
}
