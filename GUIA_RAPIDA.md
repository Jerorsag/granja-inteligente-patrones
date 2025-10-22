# 🎯 GUÍA RÁPIDA DE EJECUCIÓN

## ⚡ Ejecutar el Proyecto en 3 Pasos

### 1️⃣ Navega al directorio del proyecto

```bash
cd /Users/prueba/Desktop/granja-inteligente-patrones
```

### 2️⃣ Ejecuta el script

```bash
./ejecutar.sh
```

### 3️⃣ ¡Listo! 🎉

El sistema ejecutará automáticamente y mostrará:
- ✅ Inicialización del sistema
- ✅ Demostración de todos los patrones
- ✅ Flujo integrado completo
- ✅ Estadísticas finales

---

## 🔄 Comandos Útiles

### Recompilar el proyecto
```bash
./compilar.sh
```

### Limpiar archivos compilados
```bash
./limpiar.sh
```

### Ejecutar manualmente (sin script)
```bash
java -cp out/production/classes com.grupo2.Main
```

---

## 📦 ¿Qué Incluye la Ejecución?

El programa ejecuta 6 fases demostrando todos los patrones:

```
FASE 1: Inicialización del Sistema
├── Singleton (AlimentadorGlobal)
└── Creación de corrales con sensores

FASE 2: Patrones Creacionales
├── Factory Method (creación de animales)
├── Abstract Factory (familias de productos)
├── Builder (construcción personalizada)
└── Singleton (verificación de instancia única)

FASE 3: Patrones Estructurales
├── Adapter (sensor legacy)
├── Decorator (GPS, vacunas)
└── Facade (ya en uso)

FASE 4: Patrones Comportamentales
├── Observer (alertas de sensores)
├── Strategy (estrategias de alimentación)
├── Command (operaciones reversibles)
└── State (estados de salud)

FASE 5: Integración Práctica
└── Flujo automatizado completo

FASE 6: Estado Final
└── Estadísticas y resumen
```

---

## ✅ Verificación Rápida

Después de ejecutar, deberías ver:

- ✅ Mensaje de bienvenida con título ASCII
- ✅ 6 fases ejecutándose secuencialmente
- ✅ Emojis y mensajes descriptivos
- ✅ Tabla final con todos los patrones implementados
- ✅ Mensaje de éxito: "Sistema completamente funcional"

---

## 🆘 Solución de Problemas

### Error: "Permission denied"
```bash
chmod +x ejecutar.sh compilar.sh limpiar.sh
```

### Error: "java: command not found"
```bash
# Verificar instalación de Java
java --version
```

### Error: "Class not found"
```bash
# Recompilar el proyecto
./compilar.sh
```

---

## 📱 Contacto

Para dudas sobre el proyecto:
- Ver `README.md` para documentación completa
- Ver `EJECUCION_EXITOSA.md` para detalles de la última ejecución
- Ver código fuente en `src/main/java/com/grupo2/`

---

**¡El proyecto está 100% funcional y listo para usar!** ✨
