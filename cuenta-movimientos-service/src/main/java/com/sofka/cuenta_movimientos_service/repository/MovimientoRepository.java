package com.sofka.cuenta_movimientos_service.repository;

import com.sofka.cuenta_movimientos_service.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByFechaBetween(Date fechaInicio, Date fechaFin);
}