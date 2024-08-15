package com.sofka.cuenta_movimientos_service.service;
import com.sofka.cuenta_movimientos_service.entity.Cuenta;

import java.util.List;

public interface CuentaService {
    List<Cuenta> findAll();
    Cuenta findById(Long id);
    Cuenta save(Cuenta cuenta);
    void deleteById(Long id);
}
