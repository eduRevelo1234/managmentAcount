package com.sofka.cliente_persona_service.service;
import com.sofka.cliente_persona_service.entity.Cliente;

import java.util.List;

import java.util.Optional;

public interface ClienteService {
    List<Cliente> findAll();
    Cliente findById(Long id);
    Cliente save(Cliente cliente);
    Optional<Cliente> findByIdOptional(Long id);
    void deleteById(Long id);
}
