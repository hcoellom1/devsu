package hn.devsu.excersice.clientes.controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.devsu.excersice.clientes.services.CuentaService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/cuentas")
public class CuentasController {

    private final CuentaService cuentaService;

    public CuentasController(CuentaService cuentaService){
        this.cuentaService = cuentaService;
    }


    @GetMapping("/estado-cuenta/generar")
    public String generarEstadoCuenta(@RequestParam LocalDateTime fechaInicial, @RequestParam LocalDateTime fechaFinal, @RequestParam int idCliente) {
        return new String();
    }
    
    
}
