package com.sofka.cliente_persona_service.entity;

import jakarta.persistence.*;


@Entity
public class Cliente extends Persona {

    @Column(nullable = false, unique = true)
    private String clienteId;

    @Column(nullable = false)
    private String contrasena;

    @Column(nullable = false)
    private boolean estado;

    // Getters and Setters
    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        if (clienteId == null) {
            throw new NullPointerException("El clienteId no puede ser nulo");
        }
        this.clienteId = clienteId;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        if (contrasena == null) {
            throw new NullPointerException("La contraseña no puede ser nula");
        }
        this.contrasena = contrasena;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
