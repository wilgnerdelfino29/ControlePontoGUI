package com.empresa.controlepontogui.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RegistroPonto {
    private int idRegPonto;
    private Funcionario func;
    private LocalDate dataRegistro;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;

    public RegistroPonto(int idRegPonto, Funcionario func) {
        this.idRegPonto = idRegPonto;
        this.func = func;
        this.dataRegistro = LocalDate.now();
        this.horaEntrada = LocalDateTime.now();
        this.horaSaida = null;
    }

    public long getIdRegPonto() {
        return idRegPonto;
    }

    public void setIdRegPonto(int idRegPonto) {
        this.idRegPonto = idRegPonto;
    }

    public Funcionario getFunc() {
        return func;
    }

    public void setFunc(Funcionario func) {
        this.func = func;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida() {
        this.horaSaida = LocalDateTime.now();
    }

}