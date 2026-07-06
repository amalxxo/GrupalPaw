package com.example.acciones;

import com.example.animales.Animal;

public class Curar implements Accion {

    @Override
    public void ejecutar(Animal atacante, Animal enemigo) {

        atacante.curarse();

    }

}