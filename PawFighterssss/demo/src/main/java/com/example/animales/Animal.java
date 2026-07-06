package com.example.animales;

public sealed abstract class Animal {

    private static int contadorID;

    static {
        contadorID = 1;
        System.out.println("========================================");
        System.out.println("        PAW FIGHTERS");
        System.out.println("   Torneo de Animales Guerreros");
        System.out.println("========================================");
    }

    private final int id;
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int energia;
    private int experiencia;
    private int nivel;

    {
        id = contadorID++;
    }

    public Animal(String nombre, int vida, int ataque, int defensa) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.energia = 100;
        this.experiencia = 0;
        this.nivel = 1;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getEnergia() { return energia; }
    public int getNivel() { return nivel; }
    public int getExperiencia() { return experiencia; }

    public boolean estaVivo() { return vida > 0; }
    
    public void atacar(Animal enemigo) {
        enemigo.recibirDanio(ataque);
    }

    public void recibirDanio(int danio) {
        int total = danio - defensa;
        if (total <= 0) total = 1;
        vida -= total;
        if (vida < 0) vida = 0;
        System.out.println(nombre + " recibió " + total + " de daño.");
    }

    public void curarse() {
        if (energia >= 15) {
            energia -= 15;
            vida += 20;
            if (vida > 100) vida = 100;
            System.out.println(nombre + " recuperó vida.");
        } else {
            System.out.println("No hay suficiente energía.");
        }
    }

    public void ganarExperiencia() {
        experiencia += 50;
        if (experiencia >= 100) {
            experiencia = 0;
            nivel++;
            ataque += 5;
            defensa += 2;
            vida += 20;
            System.out.println("\n***************");
            System.out.println(nombre + " SUBIÓ AL NIVEL " + nivel);
            System.out.println("***************");
        }
    }

    public void mostrarEstado() {
        System.out.println("-----------------------------");
        System.out.println("ID: " + id);
        System.out.println("Animal: " + nombre);
        System.out.println("Vida: " + vida);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defensa: " + defensa);
        System.out.println("Energía: " + energia);
        System.out.println("Nivel: " + nivel);
        System.out.println("-----------------------------");
    }

    public abstract void habilidadEspecial(Animal enemigo);


    public static final class Perro extends Animal {
        public Perro() {
            super("Perro", 100, 25, 8);
        }

        @Override
        public void habilidadEspecial(Animal enemigo) {
            System.out.println("\n PERRO usa MORDIDA FEROZ");
            enemigo.recibirDanio(getAtaque() + 20);
        }
    }

    public static final class Gato extends Animal {
        public Gato() {
            super("Gato", 100, 20, 10);
        }

        @Override
        public void habilidadEspecial(Animal enemigo) {
            System.out.println("\n GATO usa ARAÑAZO DOBLE");
            enemigo.recibirDanio(getAtaque());
            enemigo.recibirDanio(getAtaque());
        }
    }

    public static final class Zorro extends Animal {
        public Zorro() {
            super("Zorro", 95, 22, 7);
        }

        @Override
        public void habilidadEspecial(Animal enemigo) {
            System.out.println("\n ZORRO usa ATAQUE SIGILOSO");
            enemigo.recibirDanio(getAtaque() + 15);
        }

        public void zarpasoAgil(Animal enemigo){
            System.out.println(" El Zorro usa ZARPASO AGIL");
            enemigo.recibirDanio(50);
        }
    }
}