package com.example.acciones;

import com.example.animales.Animal;

public class Defender implements Accion {

    @Override
    public void ejecutar(Animal atacante, Animal enemigo) {

        System.out.println("\n" + atacante.getNombre() + " se preparó para defenderse.");

        atacante.curarse();

    }

}