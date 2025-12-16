package hn.devsu.excersice.clientes.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.devsu.excersice.clientes.application.CuentaService;
import hn.devsu.excersice.clientes.application.dto.CuentaDto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService){
        this.cuentaService = cuentaService;
    }

    @PostMapping("/crear/{idCliente}")
    public CuentaDto crearCuenta(@PathVariable int idCliente, @RequestBody CuentaDto cuenta) {
        return cuentaService.crearCuenta(idCliente, cuenta);
    }
    
    
}
