package hn.devsu.excersice.clientes.domain.helpers;

import java.util.List;

import hn.devsu.excersice.clientes.domain.Cuenta;
import hn.devsu.excersice.clientes.domain.Movimiento;
import hn.devsu.excersice.clientes.infraestructure.entity.CuentaEntity;
import hn.devsu.excersice.clientes.infraestructure.entity.MovimientoEntity;

public class CuentaMapper {
 
    private CuentaMapper(){}

    public static CuentaEntity mapearAentidad(Cuenta cuenta){
        if(cuenta==null) return null;

        CuentaEntity nvaCuentaEntity = new CuentaEntity();
        nvaCuentaEntity.setEstado(cuenta.isEstado());
        nvaCuentaEntity.setSaldoInicial(cuenta.getSaldoInicial());
        nvaCuentaEntity.setTipoCuenta(cuenta.getTipoCuenta());
        
        List<MovimientoEntity> movimientos = cuenta.getMovimientos().stream()
                                        .map(m-> {
                                            MovimientoEntity movimientoEntity = new MovimientoEntity();
                                            movimientoEntity.setFechaMovimiento(m.getFechaMovimiento());
                                            movimientoEntity.setValor(m.getValor());
                                            movimientoEntity.setSaldo(m.getSaldo());
                                            movimientoEntity.setCuenta(nvaCuentaEntity);
                                            return movimientoEntity;
                                        }).toList();
        nvaCuentaEntity.setMovimientos(movimientos);
        return nvaCuentaEntity;

    }

    public static Cuenta mapearAdominio(CuentaEntity cuenta){
        if(cuenta==null) return null;

        Cuenta nvaCuentaDominio = new Cuenta();
        nvaCuentaDominio.setEstado(cuenta.isEstado());
        nvaCuentaDominio.setSaldoInicial(cuenta.getSaldoInicial());
        nvaCuentaDominio.setNumeroCuenta(cuenta.getNumeroCuenta());

        if(!cuenta.getMovimientos().isEmpty()){
            List<Movimiento> movimientos = cuenta.getMovimientos().stream()                                
                                .map(m -> {
                                    Movimiento mov = new Movimiento();
                                    mov.setFechaMovimiento(m.getFechaMovimiento());
                                    mov.setValor(m.getValor());
                                    mov.setSaldo(m.getSaldo());
                                    return mov;
                                }).toList();

            movimientos.forEach(nvaCuentaDominio::registrarMovimiento);
                                
        }
        return nvaCuentaDominio;
    }
}
