package com.sofka.cuenta_movimientos_service.service.impl;

import com.sofka.cuenta_movimientos_service.entity.Cuenta;
import com.sofka.cuenta_movimientos_service.entity.CuentaReporte;
import com.sofka.cuenta_movimientos_service.entity.Movimiento;
import com.sofka.cuenta_movimientos_service.entity.ReporteEstadoCuenta;
import com.sofka.cuenta_movimientos_service.repository.MovimientoRepository;
import com.sofka.cuenta_movimientos_service.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReporteServiceImpl implements ReporteService {
    @Autowired
    private MovimientoRepository movimientoRepository;


    @Override
    public ReporteEstadoCuenta generarReporte(Date fechaInicio, Date fechaFin) {
        // Obtener todos los movimientos en el rango de fechas
        List<Movimiento> movimientos = movimientoRepository.findByFechaBetween(fechaInicio, fechaFin);

        // Agrupar los movimientos por cuenta
        Map<Cuenta, List<Movimiento>> movimientosPorCuenta = movimientos.stream()
                .collect(Collectors.groupingBy(Movimiento::getCuenta));

        // Crear el reporte
        ReporteEstadoCuenta reporte = new ReporteEstadoCuenta();

        // Para cada cuenta, crear un reporte con los movimientos correspondientes
        for (Map.Entry<Cuenta, List<Movimiento>> entry : movimientosPorCuenta.entrySet()) {
            Cuenta cuenta = entry.getKey();
            List<Movimiento> movimientosCuenta = entry.getValue();

            CuentaReporte cuentaReporte = new CuentaReporte();
            cuentaReporte.setNumeroCuenta(cuenta.getNumeroCuenta());
            cuentaReporte.setSaldoInicial(cuenta.getSaldoInicial());
            cuentaReporte.setMovimientos(movimientosCuenta);

            reporte.getCuentas().add(cuentaReporte);
        }

        return reporte;
    }
}
