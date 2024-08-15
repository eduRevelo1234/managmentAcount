package com.sofka.cuenta_movimientos_service.service.impl;

import com.sofka.cuenta_movimientos_service.entity.Cuenta;
import com.sofka.cuenta_movimientos_service.entity.Movimiento;
import com.sofka.cuenta_movimientos_service.repository.MovimientoRepository;
import com.sofka.cuenta_movimientos_service.service.CuentaService;
import com.sofka.cuenta_movimientos_service.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MovimientoServiceImpl implements MovimientoService {
    @Autowired
    private MovimientoRepository movimientoRepository;
    @Autowired
    private CuentaService cuentaService;

    @Override
    public List<Movimiento> findAll() {
        return movimientoRepository.findAll();
    }

    @Override
    public Movimiento findById(Long id) {
        return movimientoRepository.findById(id).orElse(null);
    }

    @Override
    public Movimiento save(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    @Override
    public void deleteById(Long id) {
        movimientoRepository.deleteById(id);
    }

    @Override
    public Movimiento registrarMovimiento(Movimiento movimiento) throws Exception {
        Cuenta cuenta = movimiento.getCuenta();
        if (cuenta == null) {
            throw new Exception("Cuenta no encontrada");
        }

        double nuevoSaldo = cuenta.getSaldoInicial() + movimiento.getValor();
        if (nuevoSaldo < 0) {
            throw new Exception("Saldo no disponible");
        }

        cuenta.setSaldoInicial(nuevoSaldo);
        cuentaService.save(cuenta);

        movimiento.setFecha(new Date());
        movimiento.setSaldo(nuevoSaldo);
        return movimientoRepository.save(movimiento);
    }
}
