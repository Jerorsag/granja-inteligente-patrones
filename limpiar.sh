#!/bin/bash
# Script para limpiar archivos compilados

echo "🧹 Limpiando archivos compilados..."

rm -rf out/production/classes
rm -rf target

echo "✅ Limpieza completada"
