package com.sofka.cuenta_movimientos_service.entity;

import java.util.List;
import java.util.ArrayList;

public class ReporteEstadoCuenta {
    private List<CuentaReporte> cuentas = new ArrayList<>();

    // Getters y Setters
    public List<CuentaReporte> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<CuentaReporte> cuentas) {
        this.cuentas = cuentas;
    }
}