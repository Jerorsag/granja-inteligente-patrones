package com.grupo2;

import com.grupo2.entity.animales.Animal;
import com.grupo2.patterns.behavioral.command.*;
import com.grupo2.patterns.behavioral.state.*;
import com.grupo2.patterns.behavioral.strategy.*;
import com.grupo2.patterns.creational.builder.*;
import com.grupo2.patterns.creational.factory.*;
import com.grupo2.patterns.structural.adapter.*;
import com.grupo2.patterns.structural.decorator.*;
import com.grupo2.patterns.structural.facade.GranjaFacade;
import com.grupo2.entity.sensores.*;

/**
 * SISTEMA DE GRANJA INTELIGENTE
 * Implementación de todos los patrones de diseño solicitados
 * 
 * PATRONES IMPLEMENTADOS:
 * 
 * CREACIONALES:
 * - Factory Method: Creación dinámica de animales
 * - Abstract Factory: Familias de productos (animales + alimento + entorno)
 * - Builder: Construcción paso a paso de animales
 * - Singleton: Sistema de alimentación global único
 * 
 * ESTRUCTURALES:
 * - Adapter: Adaptación de sensores legacy
 * - Decorator: Características adicionales a animales (GPS, vacunas, historial)
 * - Facade: Interfaz simplificada para el sistema completo
 * 
 * COMPORTAMENTALES:
 * - Observer: Sensores notifican cambios al sistema de alertas
 * - Strategy: Diferentes estrategias de alimentación según estación
 * - Command: Encapsulación de operaciones (dispensar, regar, registrar)
 * - State: Estados de salud de animales (sano, enfermo, en tratamiento)
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║                                                       ║");
        System.out.println("║   🌾 SISTEMA DE GRANJA INTELIGENTE 🌾                ║");
        System.out.println("║   Demostración de Patrones de Diseño                 ║");
        System.out.println("║                                                       ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝\n");
        
        // FASE 1: INICIALIZACIÓN CON FACADE
        System.out.println("\n█████ FASE 1: INICIALIZACIÓN DEL SISTEMA █████\n");
        GranjaFacade granja = new GranjaFacade();
        
        // Crear corrales usando la facade
        granja.crearCorral("Corral-Cerdos", "carne");
        granja.crearCorral("Corral-Vacas", "lechero");
        granja.crearCorral("Corral-Gallinas", "avicola");
        
        // FASE 2: PATRONES CREACIONALES
        System.out.println("\n\n█████ FASE 2: PATRONES CREACIONALES █████\n");
        
        // 2.1 FACTORY METHOD
        System.out.println("--- 2.1 Factory Method: Creación dinámica de animales ---");
        Animal cerdo1 = granja.agregarAnimal("Corral-Cerdos", "cerdo", "C001", "Duroc", 120, 6);
        Animal cerdo2 = granja.agregarAnimal("Corral-Cerdos", "cerdo", "C002", "Landrace", 115, 5);
        
        Animal vaca1 = granja.agregarAnimal("Corral-Vacas", "vaca", "V001", "Holstein", 600, 24);
        Animal vaca2 = granja.agregarAnimal("Corral-Vacas", "vaca", "V002", "Jersey", 450, 18);
        
        Animal gallina1 = granja.agregarAnimal("Corral-Gallinas", "gallina", "G001", "Leghorn", 2.0, 5);
        Animal gallina2 = granja.agregarAnimal("Corral-Gallinas", "gallina", "G002", "Rhode Island", 2.5, 6);
        
        // 2.2 ABSTRACT FACTORY
        System.out.println("\n--- 2.2 Abstract Factory: Familias de productos ---");
        AbstractAnimalFactory vacaLecheraFactory = new VacaLecheraFactory();
        Animal vacaLechera = vacaLecheraFactory.crearAnimal("V003", 580, 20);
        System.out.println("✓ Familia Vaca Lechera creada:");
        System.out.println("  - Animal: " + vacaLechera.getTipo() + " " + vacaLechera.getRaza());
        System.out.println("  - Alimento: " + vacaLecheraFactory.crearAlimento());
        System.out.println("  - Entorno: " + vacaLecheraFactory.crearEntorno());
        
        // 2.3 BUILDER
        System.out.println("\n--- 2.3 Builder: Construcción paso a paso ---");
        AnimalBuilder builder = new AnimalBuilder();
        AnimalDirector director = new AnimalDirector(builder);
        
        Animal cerdoBuilder = director.construirCerdoEngorde("C003");
        System.out.println("✓ Cerdo construido con Builder:");
        cerdoBuilder.mostrarInfo();
        
        // 2.4 SINGLETON
        System.out.println("\n--- 2.4 Singleton: Sistema de alimentación único ---");
        System.out.println("✓ AlimentadorGlobal es único en toda la aplicación");
        
        // FASE 3: PATRONES ESTRUCTURALES
        System.out.println("\n\n█████ FASE 3: PATRONES ESTRUCTURALES █████\n");
        
        // 3.1 ADAPTER
        System.out.println("--- 3.1 Adapter: Sensor Legacy adaptado ---");
        SensorLegacy sensorAntiguo = new SensorLegacy("OLD-001", "Almacén Principal");
        SensorAdapter sensorAdaptado = new SensorAdapter(sensorAntiguo);
        sensorAdaptado.agregarObservador(granja.getSistemaAlerta());
        sensorAdaptado.tomarLectura();
        
        // 3.2 DECORATOR
        System.out.println("\n--- 3.2 Decorator: Características adicionales ---");
        Animal vacaConGPS = new AnimalConGPS(vaca1);
        Animal vacaConGPSYVacuna = new AnimalConVacuna(vacaConGPS, "Fiebre Aftosa");
        System.out.println("\n✓ Vaca decorada con GPS y Vacuna:");
        vacaConGPSYVacuna.mostrarInfo();
        
        // 3.3 FACADE
        System.out.println("\n--- 3.3 Facade: Ya en uso desde el inicio ---");
        System.out.println("✓ GranjaFacade simplifica toda la interacción con subsistemas");
        
        // FASE 4: PATRONES COMPORTAMENTALES
        System.out.println("\n\n█████ FASE 4: PATRONES COMPORTAMENTALES █████\n");
        
        // 4.1 OBSERVER
        System.out.println("--- 4.1 Observer: Sensores detectan nivel bajo ---");
        SensorNivelAlimento sensor = granja.getSensorAlimento("Corral-Cerdos");
        sensor.setNivel(15.0); // Simular nivel bajo (umbral es 20%)
        
        // 4.2 STRATEGY
        System.out.println("\n--- 4.2 Strategy: Cambiar estrategia de alimentación ---");
        
        // Estrategia de Invierno
        EstrategiaAlimentacion estrategiaInvierno = new EstrategiaInvierno();
        granja.cambiarEstrategiaAlimentacion(estrategiaInvierno);
        granja.alimentarCorral("Corral-Cerdos");
        
        // Cambiar a Estrategia de Verano
        EstrategiaAlimentacion estrategiaVerano = new EstrategiaVerano();
        granja.cambiarEstrategiaAlimentacion(estrategiaVerano);
        granja.alimentarCorral("Corral-Vacas");
        
        // Estrategia de Ahorro
        EstrategiaAlimentacion estrategiaAhorro = new EstrategiaAhorro();
        granja.cambiarEstrategiaAlimentacion(estrategiaAhorro);
        granja.alimentarCorral("Corral-Gallinas");
        
        // 4.3 COMMAND
        System.out.println("\n--- 4.3 Command: Ejecutar y deshacer comandos ---");
        ControladorComandos controlador = granja.getControladorComandos();
        
        // Programar comandos
        Command registrarEvento = new RegistrarEventoCommand("Mantenimiento de corrales", "Corral-Cerdos");
        controlador.programarComando(registrarEvento);
        
        Command activarRiego = new EncenderRiegoCommand("Zona-Norte", 30);
        controlador.programarComando(activarRiego);
        
        // Ejecutar comandos pendientes
        controlador.ejecutarComandosPendientes();
        
        // Deshacer último comando
        controlador.deshacerUltimo();
        
        // 4.4 STATE
        System.out.println("\n--- 4.4 State: Estados de salud de animales ---");
        System.out.println("\n• Animal sano:");
        cerdo1.mostrarInfo();
        
        System.out.println("\n• Cambiar a estado enfermo:");
        cerdo1.cambiarEstado(new EstadoEnfermo());
        cerdo1.alimentar(3.0);
        
        System.out.println("\n• Aplicar tratamiento:");
        cerdo1.getEstadoSalud().aplicarTratamiento(cerdo1);
        cerdo1.alimentar(3.0);
        cerdo1.alimentar(3.0);
        cerdo1.alimentar(3.0); // Completar tratamiento
        
        // FASE 5: INTEGRACIÓN PRÁCTICA - FLUJO COMPLETO
        System.out.println("\n\n█████ FASE 5: INTEGRACIÓN PRÁCTICA █████");
        System.out.println("Sistema de Alimentación Automatizada\n");
        
        System.out.println("📋 FLUJO COMPLETO:");
        System.out.println("1. Sensor detecta nivel bajo de alimento");
        System.out.println("2. Factory crea animales según tipo de corral");
        System.out.println("3. Strategy aplica algoritmo de alimentación según estación");
        System.out.println("4. Command ejecuta acción de dispensación");
        System.out.println("5. Facade coordina todo el proceso\n");
        
        // Simular flujo completo
        System.out.println("▶ Ejecutando flujo automatizado...\n");
        
        // 1. Monitorear sensores
        granja.monitorearCorral("Corral-Cerdos");
        
        // 2. Aplicar estrategia según "estación"
        System.out.println("\n▶ Aplicando estrategia de Invierno (más alimento)...");
        granja.cambiarEstrategiaAlimentacion(new EstrategiaInvierno());
        
        // 3. Alimentar usando la facade (integra todo)
        granja.alimentarCorral("Corral-Cerdos");
        
        // 4. Activar sistemas complementarios
        granja.activarRiego("Corral-Cerdos", 20);
        
        // FASE 6: RESUMEN FINAL
        System.out.println("\n\n█████ FASE 6: ESTADO FINAL DEL SISTEMA █████");
        granja.mostrarEstadoGranja();
        
        // Resumen de patrones
        System.out.println("\n\n╔═══════════════════════════════════════════════════════╗");
        System.out.println("║          ✅ PATRONES IMPLEMENTADOS ✅                  ║");
        System.out.println("╠═══════════════════════════════════════════════════════╣");
        System.out.println("║ CREACIONALES:                                         ║");
        System.out.println("║  ✓ Factory Method      - Creación de animales        ║");
        System.out.println("║  ✓ Abstract Factory    - Familias de productos       ║");
        System.out.println("║  ✓ Builder             - Construcción paso a paso    ║");
        System.out.println("║  ✓ Singleton           - Alimentador global único    ║");
        System.out.println("║                                                       ║");
        System.out.println("║ ESTRUCTURALES:                                        ║");
        System.out.println("║  ✓ Adapter             - Sensores legacy adaptados   ║");
        System.out.println("║  ✓ Decorator           - GPS, vacunas, historial     ║");
        System.out.println("║  ✓ Facade              - Interfaz simplificada       ║");
        System.out.println("║                                                       ║");
        System.out.println("║ COMPORTAMENTALES:                                     ║");
        System.out.println("║  ✓ Observer            - Sistema de alertas          ║");
        System.out.println("║  ✓ Strategy            - Estrategias de alimentación ║");
        System.out.println("║  ✓ Command             - Operaciones encapsuladas    ║");
        System.out.println("║  ✓ State               - Estados de salud            ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝");
        
        System.out.println("\n🎉 ¡Sistema de Granja Inteligente completamente funcional! 🎉\n");
    }
}