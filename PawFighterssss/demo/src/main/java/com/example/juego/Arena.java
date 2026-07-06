package com.example.juego;

import java.util.Scanner;

import com.example.acciones.Accion;
import com.example.acciones.Ataque;
import com.example.acciones.Curar;
import com.example.acciones.Defender;
import com.example.acciones.Habilidad;
import com.example.animales.Animal;
import com.example.util.Dado;
import com.example.util.Menu;
import com.example.eventos.EventoEspecial;

public class Arena {

    private Animal jugador;
    private Animal computadora;
    private Scanner scanner;

    public Arena(Animal jugador, Animal computadora) {
        this.jugador = jugador;
        this.computadora = computadora;
        scanner = new Scanner(System.in);
    }

    public Animal iniciarCombate() {

        System.out.println("\n================================");
        System.out.println(jugador.getNombre() + " VS " + computadora.getNombre());
        System.out.println("================================");

        while (jugador.estaVivo() && computadora.estaVivo()) {

            mostrarEstado();

            turnoJugador();

            if (!computadora.estaVivo()) {
                break;
            }

            turnoComputadora();

        }

        if (jugador.estaVivo()) {

    System.out.println("\n ¡Ganaste el combate!");

    jugador.ganarExperiencia();

    EventoEspecial premio = new EventoEspecial() {

        @Override
        public void activar(Animal animal) {

            System.out.println("\n EVENTO ESPECIAL ");
            System.out.println(animal.getNombre() + " recibe una bendición.");
            animal.curarse();

        }

    };

    premio.activar(jugador);

    return jugador;

        } else {

            System.out.println("\n La computadora ganó.");

            computadora.ganarExperiencia();

            return computadora;

        }

    }

    private void mostrarEstado() {

        System.out.println("\n-------------------------");
        System.out.println(jugador.getNombre() + " Vida: " + jugador.getVida());
        System.out.println(computadora.getNombre() + " Vida: " + computadora.getVida());
        System.out.println("-------------------------");

    }

    private void turnoJugador() {

        Menu.mostrarAcciones();

        int opcion = scanner.nextInt();

        Accion accion;

        switch (opcion) {

            case 1:
                accion = new Ataque();
                accion.ejecutar(jugador, computadora);
                break;

            case 2:
                accion = new Defender();
                accion.ejecutar(jugador, computadora);
                break;

            case 3:
                accion = new Curar();
                accion.ejecutar(jugador, computadora);
                break;

            case 4:
                accion = new Habilidad();
                accion.ejecutar(jugador, computadora);

                // DOWNCASTING
                if (jugador instanceof Animal.Zorro zorro) {
                    zorro.zarpasoAgil(computadora);
                }

                break;

            default:
                System.out.println("Opción inválida.");

        }

    }

    private void turnoComputadora() {

        System.out.println("\n----- Turno de la computadora -----");

        int opcion = Dado.lanzar(4);

        Accion accion;

        switch (opcion) {

            case 1:
                accion = new Ataque();
                break;

            case 2:
                accion = new Defender();
                break;

            case 3:
                accion = new Curar();
                break;

            default:
                accion = new Habilidad();

        }

        accion.ejecutar(computadora, jugador);

    }

}