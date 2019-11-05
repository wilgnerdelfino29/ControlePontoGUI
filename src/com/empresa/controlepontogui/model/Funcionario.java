package com.empresa.controlepontogui.model;

public abstract class Funcionario {
    private int idFunc;
    private String nome;
    private String email;
    private String documento;
    private boolean aguardandoRegSaida;

    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public boolean estaAguardandoRegSaida() {
        return aguardandoRegSaida;
    }

    public void setAguardandoRegSaida(boolean aguardandoRegSaida) {
        this.aguardandoRegSaida = aguardandoRegSaida;
    }

    public abstract String getExtra1();

    public abstract String getExtra2();

}
