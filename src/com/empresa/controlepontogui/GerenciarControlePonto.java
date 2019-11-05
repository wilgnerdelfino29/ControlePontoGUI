package com.empresa.controlepontogui;

import com.empresa.controlepontogui.model.*;
import com.empresa.controlepontogui.view.RegistroPontoGUI;

import java.util.ArrayList;
import java.util.List;

public class GerenciarControlePonto {

    private int defIdFunc = 1;

    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        GerenciarControlePonto g = new GerenciarControlePonto();

        //Cadastro dos funcionarios
        Gerente ger1 = new Gerente();
        ger1.setIdFunc(g.defIdFunc++);
        ger1.setNome("Roberto Magalhães");
        ger1.setEmail("contato@rmagalhaes.com");
        ger1.setDocumento("842.742.950-15");
        ger1.setLogin("rmagal");
        ger1.setSenha("123654");

        Secretaria sec1 = new Secretaria();
        sec1.setIdFunc(g.defIdFunc++);
        sec1.setNome("Ana Julia");
        sec1.setEmail("anajulia.contato@outlook.com");
        sec1.setDocumento("403.235.145-12");
        sec1.setRamal("22");
        sec1.setTelefone("38311800");

        Operador ope1 = new Operador();
        ope1.setIdFunc(g.defIdFunc++);
        ope1.setNome("Carlos Nascimento");
        ope1.setEmail("carlinhosnsc.02@gmail.com");
        ope1.setDocumento("395.893.849-09");
        ope1.setValorHora(30.00);

        funcionarios.add(ger1);
        funcionarios.add(sec1);
        funcionarios.add(ope1);

        //cria tela de registro
        RegistroPontoGUI telaRegistro = new RegistroPontoGUI(funcionarios);
        telaRegistro.setVisible(true);

    }

}
