package com.sofka.cuenta_movimientos_service.service;

import java.util.Date;
import com.sofka.cuenta_movimientos_service.entity.ReporteEstadoCuenta;

public interface ReporteService {
    ReporteEstadoCuenta generarReporte(Date fechaInicio, Date fechaFin);
}