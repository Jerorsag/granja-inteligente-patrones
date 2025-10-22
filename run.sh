#!/bin/bash

echo "╔═══════════════════════════════════════════════════════╗"
echo "║   🌾 GRANJA INTELIGENTE - COMPILAR Y EJECUTAR 🌾     ║"
echo "╚═══════════════════════════════════════════════════════╝"
echo ""

# Crear directorio de compilación si no existe
mkdir -p target/classes

echo "📦 Compilando proyecto..."
echo ""

# Compilar todos los archivos Java
find src/main/java -name "*.java" > sources.txt
javac -d target/classes @sources.txt

if [ $? -eq 0 ]; then
    echo "✅ Compilación exitosa!"
    echo ""
    echo "🚀 Ejecutando Main..."
    echo ""
    echo "═══════════════════════════════════════════════════════"
    echo ""
    
    # Ejecutar el programa
    java -cp target/classes com.grupo2.Main
    
    echo ""
    echo "═══════════════════════════════════════════════════════"
    echo ""
    echo "✅ Ejecución completada!"
else
    echo "❌ Error en la compilación"
    exit 1
fi

# Limpiar archivo temporal
rm sources.txt
