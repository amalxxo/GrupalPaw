package com.example.acciones;

import com.example.animales.Animal;

public class Habilidad implements Accion {

    @Override
    public void ejecutar(Animal atacante, Animal enemigo) {

        atacante.habilidadEspecial(enemigo);

    }

}