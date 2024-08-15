package com.sofka.cuenta_movimientos_service.service;

import java.util.List;
import com.sofka.cuenta_movimientos_service.entity.Movimiento;

public interface MovimientoService {
    List<Movimiento> findAll();
    Movimiento findById(Long id);
    Movimiento save(Movimiento movimiento);
    void deleteById(Long id);
    Movimiento registrarMovimiento(Movimiento movimiento) throws Exception;
}
