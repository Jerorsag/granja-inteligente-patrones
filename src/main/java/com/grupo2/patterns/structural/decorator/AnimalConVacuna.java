package com.grupo2.patterns.structural.decorator;

import com.grupo2.entity.animales.Animal;
import java.time.LocalDate;

/**
 * Decorator concreto: Agrega registro de vacunación
 */
public class AnimalConVacuna extends AnimalDecorator {
    private String tipoVacuna;
    private LocalDate fechaVacunacion;
    private LocalDate proximaDosis;
    
    public AnimalConVacuna(Animal animal, String tipoVacuna) {
        super(animal);
        this.tipoVacuna = tipoVacuna;
        this.fechaVacunacion = LocalDate.now();
        this.proximaDosis = fechaVacunacion.plusMonths(6);
    }
    
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("--- Estado de Vacunación ---");
        System.out.println("Vacuna: " + tipoVacuna);
        System.out.println("Fecha de Vacunación: " + fechaVacunacion);
        System.out.println("Próxima Dosis: " + proximaDosis);
        System.out.println("Estado: " + (necesitaRevacunacion() ? "⚠ Requiere revacunación" : "✓ Al día"));
    }
    
    public boolean necesitaRevacunacion() {
        return LocalDate.now().isAfter(proximaDosis);
    }
    
    public void revacunar() {
        this.fechaVacunacion = LocalDate.now();
        this.proximaDosis = fechaVacunacion.plusMonths(6);
        animalDecorado.agregarHistorialMedico("Revacunación: " + tipoVacuna + " - " + fechaVacunacion);
        System.out.println("💉 Animal " + getId() + " revacunado con " + tipoVacuna);
    }
    
    public String getTipoVacuna() {
        return tipoVacuna;
    }
    
    public LocalDate getProximaDosis() {
        return proximaDosis;
    }
}
