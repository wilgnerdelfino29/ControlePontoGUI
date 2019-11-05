package com.empresa.controlepontogui.view;

import com.empresa.controlepontogui.model.Funcionario;
import com.empresa.controlepontogui.model.Gerente;
import com.empresa.controlepontogui.model.Operador;
import com.empresa.controlepontogui.model.Secretaria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ConsultaFuncGUI extends JFrame implements ActionListener, WindowListener {

    protected Dimension dFrame, dLabel,dTextField, dTextArea, dButton;
    protected Color cText;
    protected Font fText;
    protected Button cmdCancelar, cmdBuscar;
    protected Label lblId, lblNome, lblEmail, lblDoc, lblCargo, lblExtra1, lblExtra2;
    protected TextField txtId, txtNome, txtEmail, txtDoc, txtCargo, txtExtra1, txtExtra2;
    protected TextArea txtLog;
    private RegistroPontoGUI origem;

    public ConsultaFuncGUI(RegistroPontoGUI origem){

        this.origem = origem;

        dFrame = new Dimension(600,450);
        dLabel = new Dimension(80,20);
        dTextField = new Dimension(200,20);
        dButton = new Dimension(95,30);
        dTextArea = new Dimension(450,150);
        fText = new Font("Ravie", 0, 13);
        cText = new Color(88, 88, 88);

        setTitle("Consulta de funcionário");
        setSize(dFrame);
        setResizable(false);
        setLocation(380,230);
        setLayout(null);

        lblId = new Label("ID: ");
        lblId.setSize(dLabel);
        lblId.setLocation(20,50);
        lblId.setFont(fText);
        lblId.setAlignment(2);
        add(lblId);

        txtId = new TextField(null);
        txtId.setSize(new Dimension(50,20));
        txtId.setLocation(100,50);
        txtId.setForeground(cText);
        add(txtId);

        lblNome = new Label("Nome: ");
        lblNome.setSize(dLabel);
        lblNome.setLocation(20,110);
        lblNome.setFont(fText);
        lblNome.setAlignment(2);
        add(lblNome);

        lblEmail = new Label("Email: ");
        lblEmail.setSize(dLabel);
        lblEmail.setLocation(20,140);
        lblEmail.setFont(fText);
        lblEmail.setAlignment(2);
        add(lblEmail);

        lblDoc = new Label("CPF: ");
        lblDoc.setSize(dLabel);
        lblDoc.setLocation(20,170);
        lblDoc.setFont(fText);
        lblDoc.setAlignment(2);
        add(lblDoc);

        lblCargo = new Label("Cargo: ");
        lblCargo.setSize(dLabel);
        lblCargo.setLocation(20,200);
        lblCargo.setFont(fText);
        lblCargo.setAlignment(2);
        add(lblCargo);

        lblExtra1 = new Label("Extra 1: ");
        lblExtra1.setSize(dLabel);
        lblExtra1.setLocation(320,110);
        lblExtra1.setFont(fText);
        lblExtra1.setAlignment(2);
        add(lblExtra1);
        lblExtra1.setVisible(false);

        lblExtra2 = new Label("Extra 2: ");
        lblExtra2.setSize(dLabel);
        lblExtra2.setLocation(320,140);
        lblExtra2.setFont(fText);
        lblExtra2.setAlignment(2);
        add(lblExtra2);
        lblExtra2.setVisible(false);

        txtNome = new TextField(null);
        txtNome.setSize(dTextField);
        txtNome.setLocation(100,110);
        txtNome.setForeground(cText);
        txtNome.setEditable(false);
        add(txtNome);

        txtEmail = new TextField(null);
        txtEmail.setSize(dTextField);
        txtEmail.setLocation(100,140);
        txtEmail.setForeground(cText);
        txtEmail.setEditable(false);
        add(txtEmail);

        txtDoc = new TextField(null);
        txtDoc.setSize(dTextField);
        txtDoc.setLocation(100,170);
        txtDoc.setForeground(cText);
        txtDoc.setEditable(false);
        add(txtDoc);

        txtCargo = new TextField(null);
        txtCargo.setSize(dTextField);
        txtCargo.setLocation(100,200);
        txtCargo.setForeground(cText);
        txtCargo.setEditable(false);
        add(txtCargo);

        txtExtra1 = new TextField(null);
        txtExtra1.setSize(new Dimension(150,20));
        txtExtra1.setLocation(400,110);
        txtExtra1.setForeground(cText);
        txtExtra1.setEditable(false);
        add(txtExtra1);
        txtExtra1.setVisible(false);

        txtExtra2 = new TextField(null);
        txtExtra2.setSize(new Dimension(150,20));
        txtExtra2.setLocation(400,140);
        txtExtra2.setForeground(cText);
        txtExtra2.setEditable(false);
        add(txtExtra2);
        txtExtra2.setVisible(false);

        cmdCancelar = new Button("Cancelar");
        cmdCancelar.setSize(dButton);
        cmdCancelar.setLocation(320,50);
        cmdCancelar.setFont(new Font("Ravie", 1, 17));
        cmdCancelar.setForeground(new Color(245, 245, 245));
        cmdCancelar.setBackground(new Color(107, 112, 167));
        add(cmdCancelar);
        cmdCancelar.addActionListener(this);

        cmdBuscar = new Button("Buscar");
        cmdBuscar.setSize(dButton);
        cmdBuscar.setLocation(450,50);
        cmdBuscar.setFont(new Font("Ravie", 1, 17));
        cmdBuscar.setForeground(new Color(245, 245, 245));
        cmdBuscar.setBackground(new Color(29, 165, 167));
        add(cmdBuscar);
        cmdBuscar.addActionListener(this);

        txtLog = new TextArea(null);
        txtLog.setSize(dTextArea);
        txtLog.setLocation(100,250);
        txtLog.setEditable(false);
        txtLog.setBackground(Color.white);
        txtLog.setForeground(new Color(111, 111, 111));
        add(txtLog);


        addWindowListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cmdCancelar){
            this.setVisible(false);
        }
        if(e.getSource()==cmdBuscar){
            boolean vazio = txtId.getText().trim().isEmpty();

            // verifica se campo id esta vazio
            if(!vazio) {
                // trata o erro causado pelo tipo de dado informado
                try {
                    int idFunc = Integer.parseInt(txtId.getText());
                    Funcionario funcEncontrado = null;

                    for (int i=0; i < getContentPane().getComponentCount(); i++) {
                        Component c = getContentPane().getComponent(i);
                        if (c instanceof TextField) {
                            TextField field = (TextField) c;
                            if(!((TextField) c).isEditable()) {
                                field.setText(" ");
                                field.setText("");
                            }
                        }
                    }

                    //procura funcionario pelo id
                    for (Funcionario f : origem.getFuncionarios()) {
                        if (f.getIdFunc() == idFunc) {
                            funcEncontrado = f;
                            break;
                        }
                    }

                    //se encontrado, mostra os dados atualizando os campos
                    if(funcEncontrado!=null) {
                        txtLog.append("Funcionário encontrado\n");
                        txtNome.setText(funcEncontrado.getNome());
                        txtEmail.setText(funcEncontrado.getEmail());
                        txtDoc.setText(funcEncontrado.getDocumento());
                        txtCargo.setText(funcEncontrado.getClass().getSimpleName());

                        txtExtra1.setVisible(true);
                        lblExtra1.setVisible(true);
                        txtExtra1.setText(funcEncontrado.getExtra1());
                        if(txtCargo.getText().equals("Operador")){
                            lblExtra1.setText("Valor / hora: ");
                            lblExtra2.setVisible(false);
                            txtExtra2.setVisible(false);
                        }else{
                            txtExtra2.setText(funcEncontrado.getExtra2());
                            if(txtCargo.getText().equals("Secretaria")){
                                lblExtra1.setText("Telefone: ");
                                lblExtra2.setText("Ramal: ");

                            }else{
                                lblExtra1.setText("Login: ");
                                lblExtra2.setText("Senha: ");
                            }
                            lblExtra2.setVisible(true);
                            txtExtra2.setVisible(true);
                        }
                    }else{
                        txtLog.append("Funcionário inexistente..\n");
                    }
                }
                catch(NumberFormatException r)
                {
                    txtLog.append("O ID deve ser um numero inteiro..\n");
                }

            }else{
                for (int i=0; i < getContentPane().getComponentCount(); i++) {
                    Component c = getContentPane().getComponent(i);
                    if (c instanceof TextField) {
                        TextField field = (TextField) c;
                        if(!((TextField) c).isEditable()) {
                            field.setText(" ");
                            field.setText("");
                        }
                    }
                }
                lblExtra1.setVisible(false);
                txtExtra1.setVisible(false);
                lblExtra2.setVisible(false);
                txtExtra2.setVisible(false);
                txtLog.append("Informe o ID do funcionario..\n");
            }

            txtId.setText(null);
            txtId.requestFocus();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        txtId.requestFocus();
    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
