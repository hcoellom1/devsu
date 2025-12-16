package hn.devsu.excersice.clientes.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.devsu.excersice.clientes.application.MovimientoService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("api/movimientos")
public class MovimientosController {

    private final MovimientoService movimientoService;

    public MovimientosController(MovimientoService movimientoService){
        this.movimientoService = movimientoService;
    }

    @PostMapping("/regitrar")
    public void registrarMovimiento(@RequestParam("idCuenta") int idCuenta, @RequestParam("valor") double valor) {
        movimientoService.registrarMovimiento(idCuenta, valor);        
    }
    
    
}
