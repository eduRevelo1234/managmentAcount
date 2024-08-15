package com.sofka.cliente_persona_service;

import com.sofka.cliente_persona_service.entity.Cliente;
import com.sofka.cliente_persona_service.service.ClienteService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
@TestPropertySource(locations = "classpath:application-test.properties")
public class ClienteServiceIntegrationTest {

    @Autowired
    private ClienteService clienteService;

    @Test
    public void testGuardarYRecuperarCliente() {
        // Crear un nuevo cliente
        Cliente cliente = new Cliente();
        cliente.setClienteId("12345");
        cliente.setContrasena("password123");
        cliente.setEstado(true);

        // Guardar el cliente
        clienteService.save(cliente);

        // Recuperar el cliente por clienteId
        Optional<Cliente> foundCliente =  clienteService.findByIdOptional(Long.valueOf(12345L));

        // Verificar que el cliente se guardó y recuperó correctamente
        assertTrue(foundCliente.isPresent(), "El cliente debería estar presente");
        assertEquals("12345", foundCliente.get().getClienteId());
        assertEquals("password123", foundCliente.get().getContrasena());
        assertTrue(foundCliente.get().isEstado());
    }
}