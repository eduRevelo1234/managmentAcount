package com.sofka.cuenta_movimientos_service.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import com.sofka.cuenta_movimientos_service.service.ReporteService;
import com.sofka.cuenta_movimientos_service.entity.ReporteEstadoCuenta;
@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public ResponseEntity<ReporteEstadoCuenta> generarReporte(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) {
        
        ReporteEstadoCuenta reporte = reporteService.generarReporte(fechaInicio, fechaFin);
        return new ResponseEntity<>(reporte, HttpStatus.OK);
    }
}
