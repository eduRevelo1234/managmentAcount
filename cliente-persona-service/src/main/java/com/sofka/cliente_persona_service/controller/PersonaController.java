package com.sofka.cliente_persona_service.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sofka.cliente_persona_service.entity.Persona;
import com.sofka.cliente_persona_service.service.PersonaService;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
        Persona persona = personaService.findById(id);
        if (persona == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persona);
    }

    @PostMapping
    public Persona createPersona(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable Long id, @RequestBody Persona personaDetails) {
        Persona persona = personaService.findById(id);
        if (persona == null) {
            return ResponseEntity.notFound().build();
        }
        persona.setNombre(personaDetails.getNombre());
        persona.setGenero(personaDetails.getGenero());
        persona.setEdad(personaDetails.getEdad());
        persona.setIdentificacion(personaDetails.getIdentificacion());
        persona.setDireccion(personaDetails.getDireccion());
        persona.setTelefono(personaDetails.getTelefono());

        Persona updatedPersona = personaService.save(persona);
        return ResponseEntity.ok(updatedPersona);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
        Persona persona = personaService.findById(id);
        if (persona == null) {
            return ResponseEntity.notFound().build();
        }
        personaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}