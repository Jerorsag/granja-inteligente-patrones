package com.grupo2.patterns.behavioral.command;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Comando concreto: Registrar evento en el sistema
 */
public class RegistrarEventoCommand implements Command {
    private String evento;
    private String ubicacion;
    private boolean registrado;
    private String timestamp;
    private DateTimeFormatter formatter;
    
    public RegistrarEventoCommand(String evento, String ubicacion) {
        this.evento = evento;
        this.ubicacion = ubicacion;
        this.registrado = false;
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }
    
    @Override
    public void ejecutar() {
        if (!registrado) {
            timestamp = LocalDateTime.now().format(formatter);
            System.out.println("📝 Registrando evento...");
            System.out.println("   Evento: " + evento);
            System.out.println("   Ubicación: " + ubicacion);
            System.out.println("   Timestamp: " + timestamp);
            registrado = true;
            System.out.println("✓ Evento registrado exitosamente");
        } else {
            System.out.println("⚠ Este evento ya fue registrado");
        }
    }
    
    @Override
    public void deshacer() {
        if (registrado) {
            System.out.println("📝 Eliminando registro de evento: " + evento);
            registrado = false;
            System.out.println("✓ Registro eliminado");
        } else {
            System.out.println("⚠ No hay registro que eliminar");
        }
    }
    
    @Override
    public String getDescripcion() {
        return "Registrar evento: " + evento + " en " + ubicacion;
    }
}
