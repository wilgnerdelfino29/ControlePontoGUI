package com.empresa.controlepontogui.model;

public class Operador extends Funcionario {
    private double valorHora;

    public Operador(){
        setAguardandoRegSaida(false);
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public String getExtra1(){
        return String.valueOf(valorHora);
    }

    public String getExtra2() { return ""; }
}
