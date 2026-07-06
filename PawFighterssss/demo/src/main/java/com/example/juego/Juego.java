package com.example.juego;

import java.util.Scanner;

import com.example.animales.Animal;

import com.example.util.Menu;

public class Juego {

    private Scanner teclado;

    public Juego() {
        teclado = new Scanner(System.in);
    }

    public void iniciar() {

        int opcion;

        do {

            Menu.mostrarMenuPrincipal();

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    iniciarTorneo();
                    break;

                case 2:
                    mostrarAnimales();
                    break;

                case 3:
                    Menu.mostrarReglas();
                    break;

                case 4:
                    System.out.println("\nGracias por jugar Paw Fighters.");
                    break;

                default:
                    System.out.println("Opción incorrecta.");

            }

        } while (opcion != 4);

    }

    private void mostrarAnimales() {

        System.out.println("\n===== PERSONAJES =====");

        Animal[] animales = {

                new Animal.Perro(),
                new Animal.Gato(),
                new Animal.Zorro()

        };

        for (Animal animal : animales) {

            animal.mostrarEstado();

        }

    }

    private void iniciarTorneo() {

        System.out.println("\nEscoge tu animal");

        System.out.println("1. Perro");
        System.out.println("2. Gato");
        System.out.println("3. Zorro");

        int opcion = teclado.nextInt();

        Animal jugador;

        switch (opcion) {

            case 1:
                jugador = new Animal.Perro();
                break;

            case 2:
                jugador = new Animal.Gato();
                break;

            case 3:
                jugador = new Animal.Zorro();
                break;

            default:
                jugador = new Animal.Perro();

        }

        Animal enemigo = generarEnemigo(opcion);

        Arena arena = new Arena(jugador, enemigo);

        arena.iniciarCombate();

    }

    private Animal generarEnemigo(int jugador) {

        int numero;

        do {

            numero = (int) (Math.random() * 5) + 1;

        } while (numero == jugador);

        switch (numero) {

            case 1:
                return new Animal.Perro();

            case 2:
                return new Animal.Gato();

            case 3:
                return new Animal.Zorro();

            default:
                return new Animal.Zorro();

        }

    }

}