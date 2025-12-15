package hn.devsu.excersice.clientes.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/movimientos")
public class MovimientosController {

    @PostMapping("/crear")
    public String crearMovimiento(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;    
    }

    @GetMapping("/obtener/{id}")
    public String obtenerMovimientoPorId(@RequestParam String param) {
        return new String();
    }

    @GetMapping("/obtener/todos")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }

    @PutMapping("path/{id}")
    public String actualizarMovimiento(@PathVariable String id, @RequestBody String entity) {
        //TODO: process PUT request
        
        return entity;
    }
    
    
    
    
}
