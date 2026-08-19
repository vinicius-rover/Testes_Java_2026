package com.example.demo;

public class Circulo {

    private double raio;

    public Circulo(double raio) {
        if (raio <= 0) {
            throw new IllegalArgumentException(
                    "O raio deve ser maior que zero."
            );
        }

        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public double calcularArea() {
        return Math.PI * raio * raio;
    }

    public boolean ehMaiorQue(Circulo outro) {
        return this.calcularArea() > outro.calcularArea();
    }
}
