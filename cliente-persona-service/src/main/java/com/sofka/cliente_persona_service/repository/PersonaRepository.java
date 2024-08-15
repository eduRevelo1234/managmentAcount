package com.sofka.cliente_persona_service.repository;

import com.sofka.cliente_persona_service.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}