package hn.devsu.excersice.clientes.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.devsu.excersice.clientes.application.MovimientoService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/movimientos")
public class MovimientosController {

    private final MovimientoService movimientoService;

    public MovimientosController(MovimientoService movimientoService){
        this.movimientoService = movimientoService;
    }

    @PostMapping("/registrar")
    public String registrarMovimiento(@RequestParam int cuenta, @RequestParam double valor) {
        return movimientoService.registrarMovimiento(cuenta, valor);        
    }
    
    
}
