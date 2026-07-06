package com.example.juego;

import com.example.animales.Animal;

public class Torneo {

    // Arreglo asimétrico (irregular)
    private Animal[][] rondas;

    public Torneo() {

        rondas = new Animal[3][];

        // Primera ronda: 2 peleas
        rondas[0] = new Animal[]{
                new Animal.Perro(),
                new Animal.Gato()
        };

        // Segunda ronda: 3 peleas
        rondas[1] = new Animal[]{
                new Animal.Zorro(),
                new Animal.Perro(),
                new Animal.Gato()
        };

        // Final: 1 pelea
        rondas[2] = new Animal[]{
                new Animal.Zorro()
        };

    }

    public void mostrarTorneo() {

        System.out.println("\n=========== TORNEO ===========");

        for (int i = 0; i < rondas.length; i++) {

            System.out.println("\nRonda " + (i + 1));

            for (Animal animal : rondas[i]) {

                System.out.println("- " + animal.getNombre());

            }

        }

    }

}