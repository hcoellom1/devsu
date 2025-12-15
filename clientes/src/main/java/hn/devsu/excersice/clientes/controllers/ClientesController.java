package hn.devsu.excersice.clientes.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/clientes")

public class ClientesController {
    

    @PostMapping("/crear")
    public String crearCliente(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;        
    }

    @GetMapping("/obtener/{id}")
    public String obtenerClientePorId(@RequestParam String param) {
        return new String();
    }

    @GetMapping("obtener/todos")
    public String obtenerTodosClientes(@RequestParam String param) {
        return new String();
    }

    @PutMapping("actualizar/{id}")
    public String actualizarCliente(@PathVariable String id, @RequestBody String entity) {
        //TODO: process PUT request
        
        return entity;
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable String id){
        return "";
    }

    
    
    

}
