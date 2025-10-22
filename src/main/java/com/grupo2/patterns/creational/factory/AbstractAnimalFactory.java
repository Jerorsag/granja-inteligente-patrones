package com.grupo2.patterns.creational.factory;

import com.grupo2.entity.animales.Animal;

/**
 * Patrón Abstract Factory: Define familias de objetos relacionados
 */
public interface AbstractAnimalFactory {
    Animal crearAnimal(String id, double peso, int edad);
    String crearAlimento();
    String crearEntorno();
}
