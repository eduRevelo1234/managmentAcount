package com.sofka.cuenta_movimientos_service.service.impl;

import com.sofka.cuenta_movimientos_service.entity.Cuenta;
import com.sofka.cuenta_movimientos_service.repository.CuentaRepository;
import com.sofka.cuenta_movimientos_service.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public List<Cuenta> findAll() {
        return cuentaRepository.findAll();
    }

    @Override
    public Cuenta findById(Long id) {
        return cuentaRepository.findById(id).orElse(null);
    }

    @Override
    public Cuenta save(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public void deleteById(Long id) {
        cuentaRepository.deleteById(id);
    }
}
