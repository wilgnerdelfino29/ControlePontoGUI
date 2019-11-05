package com.empresa.controlepontogui.model;

public class Secretaria extends Funcionario {
    private String telefone;
    private String ramal;

    public Secretaria(){
        setAguardandoRegSaida(false);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    @Override
    public String getExtra1(){
        return telefone;
    }

    @Override
    public String getExtra2(){
        return ramal;
    }
}
