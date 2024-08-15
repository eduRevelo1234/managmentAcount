package com.sofka.cuenta_movimientos_service.controller;

import com.sofka.cuenta_movimientos_service.entity.Cuenta;
import com.sofka.cuenta_movimientos_service.entity.Movimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sofka.cuenta_movimientos_service.service.CuentaService;
import com.sofka.cuenta_movimientos_service.service.MovimientoService;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;


    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public List<Movimiento> getAllMovimientos() {
        return movimientoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> getMovimientoById(@PathVariable Long id) {
        Movimiento movimiento = movimientoService.findById(id);
        if (movimiento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movimiento);
    }

    @PostMapping
    public ResponseEntity<?> createMovimiento(@RequestBody Movimiento movimiento) {
        Cuenta cuenta = cuentaService.findById(movimiento.getCuenta().getId());
        if (cuenta == null || cuenta.getNumeroCuenta() == null) {
            return new ResponseEntity<>("Cuenta no encontrada o inválida", HttpStatus.BAD_REQUEST);
        }
        movimiento.setCuenta(cuenta);
        try {
            Movimiento newMovimiento = movimientoService.registrarMovimiento(movimiento);
            return new ResponseEntity<>(newMovimiento, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movimiento> updateMovimiento(@PathVariable Long id, @RequestBody Movimiento movimientoDetails) {
        Movimiento movimiento = movimientoService.findById(id);
        if (movimiento == null) {
            return ResponseEntity.notFound().build();
        }
        movimiento.setFecha(movimientoDetails.getFecha());
        movimiento.setTipoMovimiento(movimientoDetails.getTipoMovimiento());
        movimiento.setValor(movimientoDetails.getValor());
        movimiento.setSaldo(movimientoDetails.getSaldo());

        Movimiento updatedMovimiento = movimientoService.save(movimiento);
        return ResponseEntity.ok(updatedMovimiento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimiento(@PathVariable Long id) {
        Movimiento movimiento = movimientoService.findById(id);
        if (movimiento == null) {
            return ResponseEntity.notFound().build();
        }
        movimientoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}