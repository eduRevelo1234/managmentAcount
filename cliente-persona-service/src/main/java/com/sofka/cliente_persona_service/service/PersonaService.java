package com.sofka.cliente_persona_service.service;
import com.sofka.cliente_persona_service.entity.Persona;

import java.util.List;

public interface PersonaService {
    List<Persona> findAll();
    Persona findById(Long id);
    Persona save(Persona persona);
    void deleteById(Long id);
}
