package com.example.demo;

public class ContaBancaria {

    private String titular;
    private String numeroConta;
    private double saldo;

    public ContaBancaria(String titular, String numeroConta, double saldo) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public ContaBancaria(String titular, String numeroConta) {
        this(titular, numeroConta, 0.0);
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException(
                    "O valor do depósito deve ser maior que zero."
            );
        }

        setSaldo(getSaldo() + valor);
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException(
                    "O valor do saque deve ser maior que zero."
            );
        }

        if (valor > getSaldo()) {
            throw new IllegalArgumentException(
                    "Saldo insuficiente"
            );
        }

        setSaldo(getSaldo() - valor);
    }
}

