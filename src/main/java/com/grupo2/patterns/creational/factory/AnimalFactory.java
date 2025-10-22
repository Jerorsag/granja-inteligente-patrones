package com.grupo2.patterns.creational.factory;

import com.grupo2.entity.animales.Animal;

/**
 * Patrón Factory Method: Define una interfaz para crear objetos Animal
 */
public interface AnimalFactory {
    Animal crearAnimal(String id, String raza, double peso, int edad);
    String getTipoAnimal();
}
