# 🌾 Sistema de Granja Inteligente - Patrones de Diseño

## 📋 Descripción del Proyecto

Sistema completo de gestión automatizada para una granja inteligente que implementa **todos los patrones de diseño** solicitados: creacionales, estructurales y comportamentales.

El sistema automatiza la gestión de animales (vacas, cerdos, gallinas) mediante sensores, dispensadores automáticos y software de control.

---

## ✅ Patrones de Diseño Implementados

### 🏗️ Patrones Creacionales (4/4)

#### 1. **Factory Method**
- **Ubicación**: `com.grupo2.patterns.creational.factory`
- **Clases**: `AnimalFactory`, `AnimalFactoryImpl`, `VacaFactory`, `CerdoFactory`, `GallinaFactory`
- **Propósito**: Crea distintos tipos de animales (Vaca, Cerdo, Gallina) según el tipo de corral
- **Uso**: `AnimalFactoryImpl.crearAnimal(tipoCorral, id, raza, peso, edad)`

#### 2. **Abstract Factory**
- **Ubicación**: `com.grupo2.patterns.creational.factory`
- **Clases**: `AbstractAnimalFactory`, `VacaLecheraFactory`, `CerdoEngordeFactory`, `GallinaPonedoraFactory`
- **Propósito**: Crea familias de objetos compatibles (animal + alimento + entorno)
- **Ejemplo**: VacaLecheraFactory crea Holstein + Alimento Balanceado Lechero + Establo con ordeño automático

#### 3. **Builder**
- **Ubicación**: `com.grupo2.patterns.creational.builder`
- **Clases**: `AnimalBuilder`, `AnimalDirector`
- **Propósito**: Construye objetos Animal paso a paso con múltiples atributos
- **Uso**: 
```java
AnimalBuilder builder = new AnimalBuilder();
AnimalDirector director = new AnimalDirector(builder);
Animal animal = director.construirVacaLechera("V001");
```

#### 4. **Singleton**
- **Ubicación**: `com.grupo2.patterns.creational.singleton`
- **Clase**: `AlimentadorGlobal`
- **Propósito**: Sistema de alimentación central con una sola instancia global
- **Uso**: `AlimentadorGlobal.getInstancia()`

---

### 🔧 Patrones Estructurales (3/3)

#### 5. **Adapter**
- **Ubicación**: `com.grupo2.patterns.structural.adapter`
- **Clases**: `SensorAdapter`, `SensorLegacy`
- **Propósito**: Convierte datos de sensores legacy al formato del sistema actual
- **Uso**: Permite que sensores antiguos funcionen con la nueva interfaz

#### 6. **Decorator**
- **Ubicación**: `com.grupo2.patterns.structural.decorator`
- **Clases**: `AnimalDecorator`, `AnimalConGPS`, `AnimalConVacuna`, `AnimalConHistorialReproductivo`
- **Propósito**: Añade características dinámicamente (GPS, vacunación, historial reproductivo)
- **Uso**:
```java
Animal animalConGPS = new AnimalConGPS(animal);
Animal animalCompleto = new AnimalConVacuna(animalConGPS, "Fiebre Aftosa");
```

#### 7. **Facade**
- **Ubicación**: `com.grupo2.patterns.structural.facade`
- **Clase**: `GranjaFacade`
- **Propósito**: Unifica la comunicación con todos los subsistemas
- **Métodos**: `crearCorral()`, `agregarAnimal()`, `alimentarCorral()`, `monitorearCorral()`, `activarRiego()`

---

### 🎯 Patrones Comportamentales (4/4)

#### 8. **Observer**
- **Ubicación**: `com.grupo2.patterns.behavioral.observer`
- **Clases**: `Subject`, `Observer`, `SensorSubject`, `SistemaAlerta`
- **Propósito**: Sensores notifican automáticamente al sistema de alertas
- **Uso**: Los sensores detectan cambios y notifican a todos los observadores registrados

#### 9. **Strategy**
- **Ubicación**: `com.grupo2.patterns.behavioral.strategy`
- **Clases**: `EstrategiaAlimentacion`, `EstrategiaInvierno`, `EstrategiaVerano`, `EstrategiaAhorro`
- **Propósito**: Algoritmos de alimentación intercambiables según la estación
- **Ejemplo**:
  - Invierno: 3% peso × 1.5, 4 veces/día
  - Verano: 2.5% peso, 3 veces/día
  - Ahorro: 2% peso, 2 veces/día

#### 10. **Command**
- **Ubicación**: `com.grupo2.patterns.behavioral.command`
- **Clases**: `Command`, `DispensarAlimentoCommand`, `EncenderRiegoCommand`, `RegistrarEventoCommand`, `ControladorComandos`
- **Propósito**: Encapsula operaciones como objetos (ejecutar, deshacer, programar)
- **Uso**:
```java
Command comando = new DispensarAlimentoCommand("Corral-1", 50.0);
controlador.ejecutarComando(comando);
controlador.deshacerUltimo();
```

#### 11. **State**
- **Ubicación**: `com.grupo2.patterns.behavioral.state`
- **Clases**: `Estado`, `EstadoSano`, `EstadoEnfermo`, `EstadoEnTratamiento`
- **Propósito**: Los animales cambian comportamiento según su estado de salud
- **Transiciones**: Sano → Enfermo → En Tratamiento → Sano

---

## 🔄 Flujo de Integración Práctica

### Sistema de Alimentación Automatizada

1. **Sensor (Observer)** detecta que el nivel de alimento está bajo
2. **Factory Method** crea los animales según el tipo de corral
3. **Strategy** aplica algoritmo de alimentación según la estación
4. **Command** ejecuta la acción de dispensación
5. **Facade** coordina todo el proceso simplificadamente

---

## 📁 Estructura del Proyecto

```
src/main/java/com/grupo2/
├── Main.java                          # Punto de entrada con demostración completa
├── entity/
│   ├── animales/
│   │   ├── Animal.java                # Clase base de animales
│   │   ├── Vaca.java
│   │   ├── Cerdo.java
│   │   └── Gallina.java
│   └── sensores/
│       ├── Sensor.java                # Clase base de sensores
│       ├── SensorNivelAlimento.java
│       ├── SensorTemperatura.java
│       └── SensorHumedad.java
├── patterns/
│   ├── creational/
│   │   ├── factory/
│   │   │   ├── AnimalFactory.java
│   │   │   ├── AnimalFactoryImpl.java
│   │   │   ├── AbstractAnimalFactory.java
│   │   │   ├── VacaLecheraFactory.java
│   │   │   ├── CerdoEngordeFactory.java
│   │   │   └── GallinaPonedoraFactory.java
│   │   ├── builder/
│   │   │   ├── AnimalBuilder.java
│   │   │   └── AnimalDirector.java
│   │   └── singleton/
│   │       └── AlimentadorGlobal.java
│   ├── structural/
│   │   ├── adapter/
│   │   │   ├── SensorAdapter.java
│   │   │   └── SensorLegacy.java
│   │   ├── decorator/
│   │   │   ├── AnimalDecorator.java
│   │   │   ├── AnimalConGPS.java
│   │   │   ├── AnimalConVacuna.java
│   │   │   └── AnimalConHistorialReproductivo.java
│   │   └── facade/
│   │       └── GranjaFacade.java
│   └── behavioral/
│       ├── observer/
│       │   ├── Subject.java
│       │   ├── Observer.java
│       │   ├── SensorSubject.java
│       │   └── SistemaAlerta.java
│       ├── strategy/
│       │   ├── EstrategiaAlimentacion.java
│       │   ├── EstrategiaInvierno.java
│       │   ├── EstrategiaVerano.java
│       │   └── EstrategiaAhorro.java
│       ├── command/
│       │   ├── Command.java
│       │   ├── DispensarAlimentoCommand.java
│       │   ├── EncenderRiegoCommand.java
│       │   ├── RegistrarEventoCommand.java
│       │   └── ControladorComandos.java
│       └── state/
│           ├── Estado.java
│           ├── EstadoSano.java
│           ├── EstadoEnfermo.java
│           └── EstadoEnTratamiento.java
└── service/
    ├── AlimentacionService.java
    ├── GranjaService.java
    └── SensorService.java
```

---

## 🚀 Cómo Ejecutar

### Opción 1: Con Maven

```bash
# Compilar
mvn clean compile

# Ejecutar
mvn exec:java -Dexec.mainClass="com.grupo2.Main"
```

### Opción 2: Con Java directamente

```bash
# Navegar al directorio del proyecto
cd /Users/prueba/Desktop/granja-inteligente-patrones

# Compilar todos los archivos
find src/main/java -name "*.java" | xargs javac -d target/classes -cp src/main/java

# Ejecutar
java -cp target/classes com.grupo2.Main
```

### Opción 3: Desde IDE (Eclipse, IntelliJ, VSCode)

1. Abrir el proyecto
2. Ejecutar `Main.java`

---

## 📊 Salida del Programa

El programa ejecuta una demostración completa dividida en 6 fases:

1. **Inicialización del Sistema**: Creación de la granja con Facade
2. **Patrones Creacionales**: Factory, Abstract Factory, Builder, Singleton
3. **Patrones Estructurales**: Adapter, Decorator, Facade
4. **Patrones Comportamentales**: Observer, Strategy, Command, State
5. **Integración Práctica**: Flujo completo automatizado
6. **Estado Final**: Estadísticas y resumen

---

## 🎓 Ventajas de los Patrones Aplicados

### Modularidad
- Cada patrón encapsula una responsabilidad específica
- Cambios localizados no afectan al resto del sistema

### Escalabilidad
- Fácil agregar nuevos tipos de animales (Factory)
- Nuevas estrategias de alimentación sin modificar código existente (Strategy)
- Características adicionales sin cambiar clases base (Decorator)

### Mantenibilidad
- Código organizado y fácil de entender
- Separación clara de responsabilidades
- Facilita testing unitario

### Reutilización
- Componentes independientes reutilizables
- Patrones probados y documentados

---

## 📝 Decisiones de Diseño

### ¿Por qué Facade?
Simplifica la interacción con múltiples subsistemas complejos (sensores, alimentación, comandos, observadores).

### ¿Por qué Strategy?
Las condiciones ambientales cambian frecuentemente, necesitamos cambiar algoritmos en tiempo de ejecución.

### ¿Por qué Observer?
Los sensores deben notificar cambios inmediatamente sin acoplamiento fuerte.

### ¿Por qué Command?
Necesitamos historial de operaciones, deshacer acciones y programar tareas.

### ¿Por qué State?
El comportamiento de los animales varía significativamente según su estado de salud.

---

## 👥 Equipo de Desarrollo

- Grupo 2
- Curso: Programación Orientada a Objetos y Patrones de Diseño

---

## 📚 Referencias

- Gang of Four - Design Patterns: Elements of Reusable Object-Oriented Software
- Head First Design Patterns
- Refactoring Guru - Design Patterns

---

## ✨ Características Destacadas

- ✅ **11 patrones de diseño** implementados completamente
- ✅ **Integración coherente** entre todos los patrones
- ✅ **Código documentado** con JavaDoc
- ✅ **Demostración funcional** completa en Main
- ✅ **Arquitectura escalable** y mantenible
- ✅ **Principios SOLID** aplicados

---

## 🏆 Cumplimiento de Requisitos

| Requisito | Estado | Implementación |
|-----------|--------|----------------|
| Factory Method | ✅ | AnimalFactoryImpl |
| Abstract Factory | ✅ | VacaLecheraFactory, CerdoEngordeFactory, GallinaPonedoraFactory |
| Builder | ✅ | AnimalBuilder + AnimalDirector |
| Singleton | ✅ | AlimentadorGlobal |
| Adapter | ✅ | SensorAdapter para sensores legacy |
| Decorator | ✅ | AnimalConGPS, AnimalConVacuna, AnimalConHistorialReproductivo |
| Facade | ✅ | GranjaFacade |
| Observer | ✅ | Sensores + SistemaAlerta |
| Strategy | ✅ | EstrategiaInvierno, EstrategiaVerano, EstrategiaAhorro |
| Command | ✅ | DispensarAlimentoCommand, EncenderRiegoCommand, RegistrarEventoCommand |
| State | ✅ | EstadoSano, EstadoEnfermo, EstadoEnTratamiento |
| Integración | ✅ | Flujo completo en Main.java |
| Documentación | ✅ | README.md + JavaDoc |

---

## 📞 Contacto

Para consultas sobre el proyecto, contactar al equipo de desarrollo.

---

**© 2025 - Granja Inteligente - Laboratorio de Patrones de Diseño**
