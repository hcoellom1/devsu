package hn.devsu.excersice.clientes.api;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.devsu.excersice.clientes.application.ClienteService;
import hn.devsu.excersice.clientes.application.dto.ClienteDto;
import hn.devsu.excersice.clientes.domain.Cliente;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @PostMapping("/crear")
    public Cliente crearCliente(@RequestBody ClienteDto cliente){
        return clienteService.crearCliente(cliente);
    }

    @PutMapping("/actualizar/{id}")
    public Cliente actualizarCliente(@PathVariable int id, @RequestBody ClienteDto cliente) {        
        return clienteService.actualizarCliente(id, cliente);        
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable int id){
        return clienteService.eliminarCliente(id);
    }

    @GetMapping("/obtener/{id}")
    public ClienteDto obtenerClientePorId(@PathVariable int id) {
        return clienteService.obtenerClientePorId(id);
    }

    @GetMapping("/obtener/todos")
    public List<ClienteDto> obtenerTodosClientes() {
        return clienteService.obtenerTodosCliente();
    }
    
    

}
