package com.sofka.cliente_persona_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sofka.cliente_persona_service.entity.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}