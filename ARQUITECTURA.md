# 📐 Arquitectura y Diseño del Sistema

## Diagrama de Clases Principal

```
┌────────────────────────────────────────────────────────────────┐
│                        GranjaFacade                            │
│  (Patrón Facade - Punto de entrada unificado)                 │
├────────────────────────────────────────────────────────────────┤
│ - alimentador: AlimentadorGlobal (Singleton)                   │
│ - controladorComandos: ControladorComandos                     │
│ - sistemaAlerta: SistemaAlerta (Observer)                      │
│ - corrales: Map<String, List<Animal>>                          │
│ - sensores: Map<String, Sensor>                                │
│ - estrategiaActual: EstrategiaAlimentacion (Strategy)          │
├────────────────────────────────────────────────────────────────┤
│ + crearCorral(nombre, tipo)                                    │
│ + agregarAnimal(corral, tipo, id, ...)                         │
│ + alimentarCorral(corral)                                      │
│ + monitorearCorral(corral)                                     │
│ + activarRiego(zona, duracion)                                 │
│ + cambiarEstrategiaAlimentacion(estrategia)                    │
│ + mostrarEstadoGranja()                                        │
└────────────────────────────────────────────────────────────────┘
```

## Jerarquía de Animales

```
                    ┌─────────────┐
                    │   Animal    │
                    │  (Abstract) │
                    └──────┬──────┘
                           │
          ┌────────────────┼────────────────┐
          │                │                │
     ┌────▼────┐      ┌────▼────┐     ┌────▼────┐
     │  Vaca   │      │  Cerdo  │     │ Gallina │
     └─────────┘      └─────────┘     └─────────┘
     - produccion     - rendimiento    - huevos
       Leche           Carne            PorSemana
```

## Patrón Factory Method

```
┌─────────────────────────────────────┐
│      AnimalFactoryImpl              │
│   (Factory Method - Creacional)     │
├─────────────────────────────────────┤
│ + crearAnimal(tipo, id, ...): Animal│
└──────────────┬──────────────────────┘
               │ crea
               ▼
     ┌──────────────────┐
     │     Animal       │
     │   Vaca/Cerdo/    │
     │    Gallina       │
     └──────────────────┘
```

## Patrón Abstract Factory

```
┌─────────────────────────────────────────┐
│    AbstractAnimalFactory (Interface)    │
│    (Abstract Factory - Creacional)      │
├─────────────────────────────────────────┤
│ + crearAnimal(): Animal                 │
│ + crearAlimento(): String               │
│ + crearEntorno(): String                │
└──────────────┬──────────────────────────┘
               │
      ┌────────┼────────┐
      │        │        │
      ▼        ▼        ▼
┌──────────┐ ┌──────────┐ ┌──────────┐
│  Vaca    │ │  Cerdo   │ │ Gallina  │
│ Lechera  │ │ Engorde  │ │Ponedora  │
│ Factory  │ │ Factory  │ │ Factory  │
└──────────┘ └──────────┘ └──────────┘
```

## Patrón Builder

```
┌─────────────────────────────────┐
│      AnimalBuilder              │
│   (Builder - Creacional)        │
├─────────────────────────────────┤
│ - id, tipo, raza, peso, edad    │
│ - historialMedico               │
│ - nivelActividad                │
├─────────────────────────────────┤
│ + setId(id): AnimalBuilder      │
│ + setTipo(tipo): AnimalBuilder  │
│ + setPeso(peso): AnimalBuilder  │
│ + build(): Animal               │
└──────────────┬──────────────────┘
               │ usado por
               ▼
     ┌────────────────────┐
     │  AnimalDirector    │
     │    (Director)      │
     ├────────────────────┤
     │+ construirVaca()   │
     │+ construirCerdo()  │
     │+ construirGallina()│
     └────────────────────┘
```

## Patrón Singleton

```
┌─────────────────────────────────────┐
│     AlimentadorGlobal               │
│   (Singleton - Creacional)          │
├─────────────────────────────────────┤
│ - instancia: AlimentadorGlobal      │
│   (static, privado)                 │
│ - inventarioTotal: double           │
│ - dispensadores: Map                │
├─────────────────────────────────────┤
│ - AlimentadorGlobal()  (privado)    │
│ + getInstancia(): AlimentadorGlobal │
│   (static, synchronized)            │
│ + dispensarAlimento(corral, cant)   │
│ + recargarInventario(cantidad)      │
└─────────────────────────────────────┘

Garantiza una sola instancia global
```

## Patrón Adapter

```
┌──────────────────┐
│  SensorLegacy    │  (Clase antigua incompatible)
│   (Legacy)       │
├──────────────────┤
│ + realizarMedicion()  (método antiguo)
│ + obtenerDato()       (método antiguo)
└─────────┬────────┘
          │ adaptado por
          ▼
    ┌─────────────────┐
    │ SensorAdapter   │  (Patrón Adapter)
    │  (Structural)   │
    ├─────────────────┤
    │ - sensorLegacy  │
    ├─────────────────┤
    │ + tomarLectura()│  (nueva interfaz)
    └─────────────────┘
          │ implementa
          ▼
    ┌─────────────────┐
    │     Sensor      │  (Interfaz moderna)
    └─────────────────┘
```

## Patrón Decorator

```
        ┌─────────────┐
        │   Animal    │
        └──────┬──────┘
               │
        ┌──────▼──────┐
        │ Animal      │
        │ Decorator   │  (Decorator Base)
        └──────┬──────┘
               │
    ┌──────────┼──────────┐
    │          │          │
┌───▼────┐ ┌───▼────┐ ┌──▼─────┐
│Animal  │ │Animal  │ │Animal  │
│ConGPS  │ │Con     │ │Con     │
│        │ │Vacuna  │ │Historial│
└────────┘ └────────┘ └────────┘

Permite agregar funcionalidades dinámicamente
sin modificar la clase base
```

## Patrón Observer

```
┌──────────────────┐       observa      ┌────────────────┐
│     Sensor       │◄──────────────────►│    Observer    │
│   (Subject)      │      notifica      │                │
├──────────────────┤                    ├────────────────┤
│ - observadores   │                    │+ actualizar()  │
├──────────────────┤                    └────────┬───────┘
│+ agregarObserver()│                            │
│+ notificar()     │                    ┌────────▼───────┐
└────────┬─────────┘                    │ SistemaAlerta  │
         │                              │   (Concrete    │
    ┌────▼─────┐                        │   Observer)    │
    │Sensor    │                        ├────────────────┤
    │Nivel     │                        │+ actualizar()  │
    │Alimento  │                        │+ mostrar()     │
    └──────────┘                        └────────────────┘
```

## Patrón Strategy

```
┌───────────────────────────────┐
│  EstrategiaAlimentacion       │
│      (Strategy)               │
├───────────────────────────────┤
│ + calcularCantidadAlimento()  │
│ + calcularFrecuencia()        │
└──────────────┬────────────────┘
               │
      ┌────────┼────────┐
      │        │        │
      ▼        ▼        ▼
┌──────────┐ ┌──────────┐ ┌──────────┐
│Estrategia│ │Estrategia│ │Estrategia│
│ Invierno │ │  Verano  │ │  Ahorro  │
└──────────┘ └──────────┘ └──────────┘
│3% × 1.5  │ │2.5%      │ │2%        │
│4 veces/d │ │3 veces/d │ │2 veces/d │
└──────────┘ └──────────┘ └──────────┘

Permite cambiar algoritmos en tiempo de ejecución
```

## Patrón Command

```
┌─────────────────────┐
│      Command        │  (Interface)
├─────────────────────┤
│ + ejecutar()        │
│ + deshacer()        │
└──────────┬──────────┘
           │
    ┌──────┼──────┬────────────┐
    │      │      │            │
    ▼      ▼      ▼            ▼
┌─────┐ ┌─────┐ ┌──────┐ ┌──────────┐
│Disp.│ │Rie- │ │Regis-│ │Controlador│
│Ali. │ │go   │ │tro   │ │ Comandos  │
└─────┘ └─────┘ └──────┘ │ (Invoker) │
                         └───────────┘
                         - historial
                         + ejecutar()
                         + deshacer()
                         + programar()
```

## Patrón State

```
        ┌─────────────┐
        │   Animal    │
        ├─────────────┤
        │- estado     │◄───────┐
        └─────────────┘        │
                               │
        ┌──────────────────────┘
        │      tiene un
        │
    ┌───▼─────────┐
    │   Estado    │  (Interface)
    ├─────────────┤
    │+ alimentar()│
    │+ tratamient │
    └──────┬──────┘
           │
    ┌──────┼──────┬──────────┐
    │      │      │          │
    ▼      ▼      ▼          │
┌───────┐ ┌───────┐ ┌────────▼────┐
│Estado │ │Estado │ │   Estado    │
│ Sano  │ │Enfermo│ │   En Trata- │
│       │ │       │ │   miento    │
└───────┘ └───────┘ └─────────────┘

Transiciones: Sano ↔ Enfermo ↔ En Tratamiento
```

## Flujo de Integración Completa

```
┌─────────────────────────────────────────────────────────────┐
│                    FLUJO AUTOMATIZADO                       │
└─────────────────────────────────────────────────────────────┘

1. DETECCIÓN (Observer)
   ┌──────────────┐
   │   Sensor     │ ──detecta→ Nivel bajo alimento
   └──────┬───────┘
          │ notifica
          ▼
   ┌──────────────┐
   │ SistemaAlerta│ ──genera→ Alerta
   └──────────────┘

2. CREACIÓN (Factory Method)
   ┌──────────────┐
   │AnimalFactory │ ──crea→ Animales según corral
   └──────────────┘

3. CÁLCULO (Strategy)
   ┌──────────────┐
   │ Estrategia   │ ──calcula→ Cantidad alimento
   │  Invierno    │            (según estación)
   └──────────────┘

4. EJECUCIÓN (Command)
   ┌──────────────┐
   │ Dispensar    │ ──ejecuta→ Alimentación
   │ Comando      │
   └──────────────┘

5. COORDINACIÓN (Facade)
   ┌──────────────┐
   │GranjaFacade  │ ──unifica→ Todo el proceso
   └──────────────┘
```

## Principios SOLID Aplicados

### Single Responsibility (SRP)
- Cada clase tiene una única responsabilidad bien definida
- Animal solo gestiona datos del animal
- Sensor solo gestiona lecturas
- Command solo encapsula operaciones

### Open/Closed (OCP)
- Abierto a extensión: Nuevos tipos de animales sin modificar código
- Cerrado a modificación: Clases base no necesitan cambios

### Liskov Substitution (LSP)
- Todos los subtipos de Animal pueden usarse intercambiablemente
- Las estrategias son intercambiables

### Interface Segregation (ISP)
- Interfaces específicas y cohesivas (Subject, Observer, Command, Strategy)
- Los clientes no dependen de métodos que no usan

### Dependency Inversion (DIP)
- Dependencias a abstracciones, no a implementaciones concretas
- GranjaFacade depende de interfaces, no de clases concretas

---

## Beneficios de la Arquitectura

✅ **Modular**: Cada componente puede desarrollarse independientemente

✅ **Escalable**: Fácil agregar nuevos tipos de animales, sensores, comandos

✅ **Mantenible**: Cambios localizados, fácil de entender y modificar

✅ **Testeable**: Componentes independientes facilitan pruebas unitarias

✅ **Reutilizable**: Patrones aplicables a otros dominios

---

**Documento de Arquitectura - Granja Inteligente**
