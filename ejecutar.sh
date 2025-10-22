#!/bin/bash
# Script para ejecutar el proyecto Granja Inteligente

echo "🌾 Ejecutando Granja Inteligente..."
echo "===================================="
echo ""

# Verificar si está compilado
if [ ! -d "out/production/classes" ]; then
    echo "⚠️  El proyecto no está compilado."
    echo "Ejecutando compilación automática..."
    ./compilar.sh
    echo ""
fi

# Ejecutar el programa
java -cp out/production/classes com.grupo2.Main

echo ""
echo "===================================="
echo "✅ Ejecución completada"
