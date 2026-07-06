package com.example.acciones;

import com.example.animales.Animal;

public class Ataque implements Accion {

    @Override
    public void ejecutar(Animal atacante, Animal enemigo) {

        System.out.println("\n" + atacante.getNombre() + " atacó.");

        atacante.atacar(enemigo);

    }

}
