package com.sofka.cliente_persona_service;

import org.junit.jupiter.api.Test;

import com.sofka.cliente_persona_service.entity.Cliente;
import com.sofka.cliente_persona_service.repository.ClienteRepository;
import com.sofka.cliente_persona_service.service.ClienteService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClienteTest {

    private ClienteService clienteService;
    private ClienteRepository clienteRepository;

    // Prueba de creación básica
    @Test
    public void testCrearCliente() {
        Cliente cliente = new Cliente();
        cliente.setClienteId("12345");
        cliente.setContrasena("password123");
        cliente.setEstado(true);

        assertEquals("12345", cliente.getClienteId());
        assertEquals("password123", cliente.getContrasena());
        assertTrue(cliente.isEstado());
    }

    // Prueba de modificación
    @Test
    public void testModificarCliente() {
        Cliente cliente = new Cliente();
        cliente.setClienteId("12345");
        cliente.setContrasena("password123");
        cliente.setEstado(true);

        cliente.setEstado(false);
        assertFalse(cliente.isEstado());

        cliente.setContrasena("newpassword");
        assertEquals("newpassword", cliente.getContrasena());
    }

    // Validación de campos nulos
    @Test
    public void testClienteIdNoPuedeSerNulo() {
        Cliente cliente = new Cliente();
        assertThrows(NullPointerException.class, () -> {
            cliente.setClienteId(null);
        });
    }

    @Test
    public void testContrasenaNoPuedeSerNula() {
        Cliente cliente = new Cliente();
        assertThrows(NullPointerException.class, () -> {
            cliente.setContrasena(null);
        });
    }

    @Test
    public void testEstadoPorDefecto() {
        Cliente cliente = new Cliente();
        cliente.setEstado(true);
        assertTrue(cliente.isEstado());

        cliente.setEstado(false);
        assertFalse(cliente.isEstado());
    }

}
