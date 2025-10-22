# Proyecto: Granja Inteligente

## Descripción general

**Granja Inteligente** es un proyecto desarrollado en **Java**, cuyo propósito es aplicar **patrones de diseño de software** (creacionales, estructurales y comportamentales) para simular los procesos de una granja moderna y automatizada.
El sistema busca integrar distintas áreas —como la gestión de animales, alimentación automatizada, sensores y control general— dentro de una **arquitectura modular, escalable y mantenible**, aplicando las mejores prácticas de **programación orientada a objetos (POO)** y **colaboración en GitHub**.

---

## Objetivos del proyecto

* Aplicar patrones de diseño creacionales, estructurales y comportamentales en un entorno práctico.
* Desarrollar una **arquitectura modular y desacoplada** que facilite la integración de nuevos componentes.
* Fomentar el trabajo colaborativo usando **ramas y Pull Requests**.
* Entregar un código **limpio, documentado y funcional** que demuestre la comprensión de los patrones.

---

## División modular del sistema

| Módulo                           | Descripción                                                                | Patrones aplicados                        |
| -------------------------------- | -------------------------------------------------------------------------- | ----------------------------------------- |
| 🐄 **Gestión de Animales**       | Define, crea y configura los animales de la granja (vaca, cerdo, gallina). | Factory Method, Builder, Abstract Factory |
| 🌾 **Alimentación Automatizada** | Controla el proceso de alimentación y sus estrategias.                     | Strategy, Command, Singleton              |
| ⚙️ **Sensores y Monitoreo**      | Simula sensores de temperatura, humedad y salud animal.                    | Observer, State                           |
| 🧱 **Interfaz de Control**       | Centraliza la interacción entre todos los subsistemas.                     | Facade, Adapter, Decorator                |

---

## Distribución de responsabilidades

| Integrante             | Módulo asignado              | Responsabilidades                                                                                      |
| ---------------------- | ---------------------------- | ------------------------------------------------------------------------------------------------------ |
| **Jerónimo Rodríguez** | 🌾 Alimentación Automatizada | Implementar Strategy, Command y Singleton. Controlar el flujo de alimentación.                         |
| **Jerónimo Vallejo**   | 🐄 Gestión de Animales       | Implementar Factory Method, Builder y Abstract Factory. Crear el sistema de instanciación de animales. |
| **Carlos Arturo**      | ⚙️ Sensores y Monitoreo      | Implementar Observer y State. Simular sensores y manejar notificaciones.                               |
| **Sebastián Ordoñez**  | 🧱 Interfaz de Control       | Implementar Facade, Adapter y Decorator. Coordinar la integración de los módulos.                      |

---

## Patrones de diseño utilizados

| Categoría          | Patrón         | Módulo              | Propósito                                                |
| ------------------ | -------------- | ------------------- | -------------------------------------------------------- |
| **Creacional**     | Factory Method | Gestión de Animales | Crear dinámicamente distintos tipos de animales.         |
| **Creacional**     | Builder        | Gestión de Animales | Construir animales con atributos personalizados.         |
| **Creacional**     | Singleton      | Alimentación        | Garantizar una única instancia global del alimentador.   |
| **Estructural**    | Adapter        | Interfaz de Control | Adaptar sensores o subsistemas con interfaces distintas. |
| **Estructural**    | Decorator      | Interfaz de Control | Añadir funcionalidades extra (monitoreo, registro).      |
| **Estructural**    | Facade         | Interfaz de Control | Unificar la interacción entre los subsistemas.           |
| **Comportamental** | Observer       | Sensores            | Notificar cambios de estado o niveles de alimento.       |
| **Comportamental** | Strategy       | Alimentación        | Aplicar estrategias según estación o tipo de animal.     |
| **Comportamental** | Command        | Alimentación        | Encapsular acciones ejecutables o reversibles.           |
| **Comportamental** | State          | Sensores            | Modelar estados de salud y sus transiciones.             |

---

## Modelo de ramas (Git Branching Model)

```
main        → Versión estable (entregable final)
develop     → Rama de integración
feature/*   → Ramas de desarrollo individual
hotfix/*    → Ramas de corrección urgente
```

### Ejemplo de flujo:

```bash
git checkout develop
git checkout -b feature/strategy-alimentacion
# ... desarrollo del módulo ...
git add .
git commit -m "Implementación del patrón Strategy en alimentación"
git push origin feature/strategy-alimentacion
```

Luego se crea un **Pull Request (PR)** hacia `develop` para revisión y aprobación antes del merge.

---

## Flujo de trabajo colaborativo

1. **Crear el repositorio central** en GitHub.
2. **Asignar permisos de colaboración** a los integrantes.
3. **Configurar la rama base `develop`** y las reglas de protección.
4. Cada integrante crea su rama `feature/*` y trabaja de forma independiente.
5. Al finalizar una funcionalidad, se hace un **Pull Request → develop**.
6. Tras la integración y pruebas, se realiza el **merge a `main`**.
7. Se genera una **etiqueta de versión** (`v1.0`, `v2.0`, etc.).

---

## Buenas prácticas de desarrollo

### Código

* Mantener **modularidad y bajo acoplamiento**.
* Usar convenciones estándar:

  * Clases → `PascalCase`
  * Variables y métodos → `camelCase`
* Documentar con **Javadoc** (`/** descripción */`).
* Evitar duplicar código o lógica.
* Separar responsabilidades por clases.

### Versionado

* Mensajes de commit claros y consistentes:

  ```
  feat: agregar patrón Observer en módulo sensores
  fix: corregir error en Factory de animales
  refactor: optimizar patrón Command
  ```
* No subir archivos compilados (`.class`, `target/`, `out/`).
* Revisar PRs antes de fusionar ramas.
* Etiquetar versiones estables (`v1.0`, `v2.0`).

### Colaboración

* Mantener comunicación activa en GitHub (issues, comentarios, revisiones).
* Respetar las reglas de fusión y revisiones cruzadas.
* Documentar nuevas funcionalidades en el README o Wiki.

---

## 📂 Estructura del proyecto

```
GranjaInteligente/
│
├── README.md                       → Documentación general del proyecto
├── .gitignore                      → Archivos y carpetas a excluir del repositorio
├── pom.xml / build.gradle           → (Si se usa Maven o Gradle para gestión de dependencias)
│
├── src/
│   ├── main/
│   │   └── java/com/granjaintegente/
│   │       ├── entity/             → Clases base y entidades del dominio
│   │       │   ├── animales/
│   │       │   │   ├── Animal.java
│   │       │   │   ├── Vaca.java
│   │       │   │   ├── Cerdo.java
│   │       │   │   └── Gallina.java
│   │       │   │
│   │       │   ├── sensores/
│   │       │   │   ├── Sensor.java
│   │       │   │   └── SensorNivelAlimento.java
│   │       │   │
│   │       │   └── estados/
│   │       │       ├── EstadoSalud.java
│   │       │       ├── EstadoSano.java
│   │       │       └── EstadoEnfermo.java
│   │       │
│   │       ├── patterns/           → Implementaciones de patrones de diseño
│   │       │   ├── creational/
│   │       │   │   ├── factory/
│   │       │   │   │   ├── AnimalFactory.java
│   │       │   │   │   └── AnimalFactoryImpl.java
│   │       │   │   ├── builder/
│   │       │   │   │   ├── AnimalBuilder.java
│   │       │   │   │   └── AnimalDirector.java
│   │       │   │   └── singleton/
│   │       │   │       └── AlimentadorGlobal.java
│   │       │   │
│   │       │   ├── structural/
│   │       │   │   ├── adapter/
│   │       │   │   │   ├── SensorAdapter.java
│   │       │   │   │   └── SensorLegacy.java
│   │       │   │   ├── decorator/
│   │       │   │   │   ├── AnimalDecorator.java
│   │       │   │   │   ├── AnimalConGPS.java
│   │       │   │   │   └── AnimalConVacuna.java
│   │       │   │   └── facade/
│   │       │   │       └── GranjaFacade.java
│   │       │   │
│   │       │   └── behavioral/
│   │       │       ├── observer/
│   │       │       │   ├── Observer.java
│   │       │       │   ├── Subject.java
│   │       │       │   ├── SensorSubject.java
│   │       │       │   └── SistemaAlerta.java
│   │       │       ├── strategy/
│   │       │       │   ├── EstrategiaAlimentacion.java
│   │       │       │   ├── EstrategiaInvierno.java
│   │       │       │   └── EstrategiaVerano.java
│   │       │       ├── command/
│   │       │       │   ├── Command.java
│   │       │       │   ├── DispensarAlimentoCommand.java
│   │       │       │   └── EncenderRiegoCommand.java
│   │       │       └── state/
│   │       │           ├── Estado.java
│   │       │           ├── EstadoSano.java
│   │       │           ├── EstadoEnfermo.java
│   │       │           └── EstadoEnTratamiento.java
│   │       │
│   │       ├── service/            → Lógica de negocio o control de flujo
│   │       │   ├── AlimentacionService.java
│   │       │   ├── SensorService.java
│   │       │   └── GranjaService.java
│   │       │
│   │       ├── repository/         → Clases para persistencia o simulación de datos
│   │       │   ├── AnimalRepository.java
│   │       │   ├── SensorRepository.java
│   │       │   └── RegistroRepository.java
│   │       │
│   │       ├── main/               → Punto de entrada del programa
│   │       │   └── Main.java
│   │       │
│   │       └── resources/          → Archivos de configuración o simulación
│   │           ├── config.properties
│   │           ├── data/
│   │           │   └── animales.txt
│   │           └── logs/
│   │               └── registro.log
│   │
│   └── test/                       → Pruebas unitarias y de integración
│       └── com/granjaintegente/
│           ├── AlimentacionTest.java
│           ├── SensoresTest.java
│           └── GranjaIntegrationTest.java
│
└── docs/                           → Documentación y diagramas opcionales
    └── guia_colaborativa.pdf
```

---

## Descripción de directorios principales

| Carpeta         | Descripción                                                                                                                |
| --------------- | -------------------------------------------------------------------------------------------------------------------------- |
| **entity/**     | Contiene las clases del dominio (animales, sensores, etc.). Representan los objetos reales del sistema.                    |
| **patterns/**   | Incluye las implementaciones de los patrones de diseño divididos por tipo: creacionales, estructurales y comportamentales. |
| **repository/** | Simula la persistencia de datos (listados, colecciones o archivos).                                                        |
| **service/**    | Gestiona la lógica de negocio y coordina el flujo entre entidades y patrones.                                              |
| **listeners/**  | Contiene clases que responden a eventos del sistema (por ejemplo, cambios de estado o alertas).                            |
| **main/**       | Punto de entrada de la aplicación (`Main.java`) donde se inicializa la simulación.                                         |
| **resources/**  | Archivos de configuración, datos simulados y logs del sistema.                                                             |
| **test/**       | Pruebas unitarias para validar la funcionalidad de los servicios y patrones.                                               |

---

## Flujo del sistema en consola (ejemplo visual)

Este es el flujo esperado de ejecución, tal como lo verá tu profesora al correr Main.java:

▶️ Ejecución:
===== SISTEMA DE GRANJA INTELIGENTE =====

Creando animales en la granja...
[Factory] Se ha creado un animal de tipo: Vaca
[Factory] Se ha creado un animal de tipo: Cerdo
[Factory] Se ha creado un animal de tipo: Gallina

Total de animales registrados: 3

Seleccionando estrategia de alimentación...
[Strategy] Estrategia actual: Verano

Iniciando alimentador global...
[Singleton] Alimentador global iniciado correctamente.

Procesando alimentación de animales...
[Vaca] recibe 4 kg de pasto.
[Cerdo] recibe 3 kg de concentrado.
[Gallina] recibe 0.5 kg de maíz.

[Facade] Alimentación finalizada con éxito.

----------------------------------------
Cambiar estrategia a Invierno...

[Strategy] Estrategia actual: Invierno

[Vaca] recibe 6 kg de pasto adicional.
[Cerdo] recibe 5 kg de concentrado adicional.
[Gallina] recibe 1 kg de maíz adicional.

[Facade] Alimentación finalizada con éxito.

----------------------------------------
Estado general:
- Total animales: 3
- Estrategia actual: Invierno
- Alimentador global en funcionamiento ✅

===== FIN DE LA SIMULACIÓN =====

---

## Entregables finales

* 📦 **Repositorio GitHub** con ramas activas (`develop`, `feature/*`, `main`).
* 💻 **Código Java funcional y modular**, aplicando patrones de diseño.
* 📘 **README.md documentado**, explicando arquitectura y autores.
* ⚙️ **Simulación funcional** en consola de la granja inteligente.
