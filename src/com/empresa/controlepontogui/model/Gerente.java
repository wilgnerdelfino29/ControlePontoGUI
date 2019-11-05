package com.empresa.controlepontogui.model;

public class Gerente extends Funcionario{
    private String login;
    private String senha;

    public Gerente(){
        setAguardandoRegSaida(false);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String getExtra1(){
        return login;
    }

    @Override
    public String getExtra2(){
        return senha;
    }
}
