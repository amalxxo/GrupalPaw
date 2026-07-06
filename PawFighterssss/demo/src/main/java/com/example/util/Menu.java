package com.example.util;

public class Menu {

    public static void mostrarMenuPrincipal() {

        System.out.println("\n======================================");
        System.out.println("         PAW FIGHTERS");
        System.out.println("======================================");
        System.out.println("1. Iniciar Torneo");
        System.out.println("2. Ver Animales");
        System.out.println("3. Reglas");
        System.out.println("4. Salir");
        System.out.println("======================================");
        System.out.print("Seleccione una opción: ");

    }

    public static void mostrarAnimales() {

        System.out.println("\n===== ANIMALES =====");
        System.out.println("1. Perro");
        System.out.println("2. Gato");
        System.out.println("3. Conejo");
        System.out.println("4. Zorro");
        System.out.println("5. Panda");
    }

    public static void mostrarAcciones() {

        System.out.println("\n----- ACCIONES -----");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");
        System.out.println("3. Curarse");
        System.out.println("4. Habilidad Especial");
        System.out.print("Elija una acción: ");

    }

    public static void mostrarReglas() {

        System.out.println("\n========== REGLAS ==========");
        System.out.println(" Cada animal inicia con vida completa.");
        System.out.println(" El combate es por turnos.");
        System.out.println(" Gana quien deje sin vida al rival.");
        System.out.println(" Cada victoria da experiencia.");
        System.out.println(" Al subir de nivel aumenta el ataque.");
        System.out.println("============================");

    }

}