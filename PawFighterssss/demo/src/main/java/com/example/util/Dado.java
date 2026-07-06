package com.example.util;

import java.util.Random;

public class Dado {

    private static final Random random = new Random();

    // Número entre 1 y el máximo
    public static int lanzar(int maximo) {
        return random.nextInt(maximo) + 1;
    }

    // Verdadero o falso aleatorio
    public static boolean moneda() {
        return random.nextBoolean();
    }

    // Número entre un mínimo y un máximo
    public static int numero(int minimo, int maximo) {
        return random.nextInt(maximo - minimo + 1) + minimo;
    }

}