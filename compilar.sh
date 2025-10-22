#!/bin/bash
# Script para compilar el proyecto Granja Inteligente

echo "🔨 Compilando Granja Inteligente..."
echo "===================================="

# Crear directorio de salida
mkdir -p out/production/classes

# Compilar todos los archivos Java
javac -d out/production/classes -encoding UTF-8 $(find src/main/java -name "*.java")

if [ $? -eq 0 ]; then
    echo "✅ Compilación exitosa!"
    echo ""
    echo "Para ejecutar el proyecto, usa: ./ejecutar.sh"
else
    echo "❌ Error en la compilación"
    exit 1
fi
