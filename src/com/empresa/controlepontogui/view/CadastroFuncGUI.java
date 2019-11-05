package com.empresa.controlepontogui.view;

import com.empresa.controlepontogui.model.Funcionario;
import com.empresa.controlepontogui.model.Gerente;
import com.empresa.controlepontogui.model.Operador;
import com.empresa.controlepontogui.model.Secretaria;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

public class CadastroFuncGUI extends JFrame implements ActionListener, ItemListener, WindowListener {

    protected Dimension dFrame, dLabel, dTextField, dTextArea, dChoice, dButton;
    protected Color cText;
    protected Font fText;
    protected Button cmdCancelar, cmdLimpar, cmdSalvar;
    protected Label lblNome, lblEmail, lblDoc, lblCargo, lblExtra1, lblExtra2;
    protected TextField txtNome, txtEmail, txtExtra1, txtExtra2;
    protected JFormattedTextField txtDoc;
    protected MaskFormatter fmtDoc;
    protected TextArea txtLog;
    protected Choice chcCargo;
    private RegistroPontoGUI origem;

    public CadastroFuncGUI(RegistroPontoGUI origem) throws ParseException {

        this.origem = origem;

        dFrame = new Dimension(600,450);
        dLabel = new Dimension(80,20);
        dTextField = new Dimension(200,20);
        dButton = new Dimension(95,30);
        dTextArea = new Dimension(450,150);
        dChoice = new Dimension(100,20);
        fText = new Font("Ravie", 0, 13);
        cText = new Color(111, 111, 111);

        fmtDoc = new MaskFormatter("###.###.###-##");
        fmtDoc.setValidCharacters("1234567890");

        setTitle("Cadastro de funcionário");
        setSize(dFrame);
        setResizable(false);
        setLocation(380,230);
        setLayout(null);

        lblNome = new Label("Nome: ");
        lblNome.setSize(dLabel);
        lblNome.setLocation(20,50);
        lblNome.setFont(fText);
        lblNome.setAlignment(2);
        add(lblNome);

        lblEmail = new Label("Email: ");
        lblEmail.setSize(dLabel);
        lblEmail.setLocation(20,80);
        lblEmail.setFont(fText);
        lblEmail.setAlignment(2);
        add(lblEmail);

        lblDoc = new Label("CPF: ");
        lblDoc.setSize(dLabel);
        lblDoc.setLocation(20,110);
        lblDoc.setFont(fText);
        lblDoc.setAlignment(2);
        add(lblDoc);

        lblCargo = new Label("Cargo: ");
        lblCargo.setSize(dLabel);
        lblCargo.setLocation(20,140);
        lblCargo.setFont(fText);
        lblCargo.setAlignment(2);
        add(lblCargo);

        lblExtra1 = new Label("Valor / hora: ");
        lblExtra1.setSize(dLabel);
        lblExtra1.setLocation(320,50);
        lblExtra1.setFont(fText);
        lblExtra1.setAlignment(2);
        add(lblExtra1);

        lblExtra2 = new Label();
        lblExtra2.setSize(dLabel);
        lblExtra2.setLocation(320,80);
        lblExtra2.setFont(fText);
        lblExtra2.setAlignment(2);
        add(lblExtra2);
        lblExtra2.setVisible(false);

        txtNome = new TextField(null);
        txtNome.setSize(dTextField);
        txtNome.setLocation(100,50);
        txtNome.setForeground(cText);
        add(txtNome);

        txtEmail = new TextField(null);
        txtEmail.setSize(dTextField);
        txtEmail.setLocation(100,80);
        txtEmail.setForeground(cText);
        add(txtEmail);

        txtDoc = new JFormattedTextField(fmtDoc);
        txtDoc.setSize(dTextField);
        txtDoc.setLocation(100,110);
        txtDoc.setForeground(cText);
        add(txtDoc);

        chcCargo = new Choice();
        chcCargo.setSize(dChoice);
        chcCargo.setLocation(100,140);
        chcCargo.setForeground(cText);
        chcCargo.add("Operador");
        chcCargo.add("Secretária");
        chcCargo.add("Gerente");
        add(chcCargo);
        chcCargo.addItemListener(this);

        txtExtra1 = new TextField();
        txtExtra1.setSize(new Dimension(150,20));
        txtExtra1.setLocation(400,50);
        txtExtra1.setForeground(cText);
        add(txtExtra1);

        txtExtra2 = new TextField(null);
        txtExtra2.setSize(new Dimension(150,20));
        txtExtra2.setLocation(400,80);
        txtExtra2.setForeground(cText);
        add(txtExtra2);
        txtExtra2.setVisible(false);

        cmdCancelar = new Button("Cancelar");
        cmdCancelar.setSize(dButton);
        cmdCancelar.setLocation(200,200);
        cmdCancelar.setFont(new Font("Ravie", 1, 17));
        cmdCancelar.setForeground(new Color(245, 245, 245));
        cmdCancelar.setBackground(new Color(107, 112, 167));
        add(cmdCancelar);
        cmdCancelar.addActionListener(this);

        cmdLimpar = new Button("Limpar");
        cmdLimpar.setSize(dButton);
        cmdLimpar.setLocation(300,200);
        cmdLimpar.setFont(new Font("Ravie", 1, 17));
        cmdLimpar.setForeground(new Color(245, 245, 245));
        cmdLimpar.setBackground(new Color(29, 165, 167));
        add(cmdLimpar);
        cmdLimpar.addActionListener(this);

        cmdSalvar = new Button("Salvar");
        cmdSalvar.setSize(dButton);
        cmdSalvar.setLocation(450,200);
        cmdSalvar.setFont(new Font("Ravie", 1, 17));
        cmdSalvar.setForeground(new Color(245, 245, 245));
        cmdSalvar.setBackground(new Color(208, 131, 90));
        add(cmdSalvar);
        cmdSalvar.addActionListener(this);

        txtLog = new TextArea(null);
        txtLog.setSize(dTextArea);
        txtLog.setLocation(100,250);
        txtLog.setEditable(false);
        txtLog.setBackground(Color.white);
        txtLog.setForeground(new Color(111, 111, 111));
        add(txtLog);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cmdCancelar){
            this.setVisible(false);
        }

        if(e.getSource()==cmdLimpar){
            for (int i=0; i < getContentPane().getComponentCount(); i++) {
                Component c = getContentPane().getComponent(i);
                if (c instanceof JFormattedTextField) {
                    JFormattedTextField field = (JFormattedTextField) c;
                    field.setText(" ");
                    field.setText("");
                }
                if (c instanceof TextField) {
                    TextField field = (TextField) c;
                    field.setText(" ");
                    field.setText("");
                }
            }
        }

        if(e.getSource()==cmdSalvar){
            boolean estaVazio = false;
            // ** Considerando que os campos informados sao validos **
            // ** em relação ao tipo de dado **

            //Verificar se todos os campos foram preenchidos
            for (int i=0; i < getContentPane().getComponentCount(); i++) {
                Component c = getContentPane().getComponent(i);
                if (c instanceof JFormattedTextField) {
                    JFormattedTextField field = (JFormattedTextField) c;
                    for(int j=0;j<field.getText().length();j++){
                        char car = field.getText().charAt(j);
                        if(car==' '){
                            estaVazio=true;
                            break;
                        }
                    }
                }
                if (c instanceof TextField) {
                    TextField field = (TextField) c;
                    if(field.getText()==""){
                        estaVazio=true;
                    }else{
                        for(int j=0;j<field.getText().length();j++){
                            char car = field.getText().charAt(j);
                            if(car==' '){
                                estaVazio=true;
                            }else{
                                estaVazio=false;
                                break;
                            }
                        }
                    }
                }
                if(estaVazio){
                    txtLog.append("Preencha todos os campos \n");
                    break;
                }
            }
            //criar funcionario
            if(!estaVazio) {
                Funcionario f = null;
                if (chcCargo.getSelectedItem().equals("Operador")) {
                    Operador o = new Operador();
                    o.setValorHora(Double.parseDouble(txtExtra1.getText()));
                    f = o;
                } else if (chcCargo.getSelectedItem().equals("Secretária")) {
                    Secretaria s = new Secretaria();
                    s.setTelefone(txtExtra1.getText());
                    s.setRamal(txtExtra2.getText());
                    f = s;
                } else {
                    Gerente g = new Gerente();
                    g.setLogin(txtExtra1.getText());
                    g.setSenha(txtExtra2.getText());
                    f = g;
                }
                f.setIdFunc(origem.getDefIdFunc());
                f.setNome(txtNome.getText());
                f.setEmail(txtEmail.getText());
                f.setDocumento(txtDoc.getText());
                //Enviar dados para a List do Registro
                origem.getFuncionarios().add(f);
                origem.setDefIdFunc(f.getIdFunc() + 1);
                //Encerrar janela
                this.setVisible(false);
                origem.txtLog.append("Funcionário cadastrado com sucesso. ID: " + f.getIdFunc() + " \n");
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == chcCargo){
            if(chcCargo.getSelectedItem().equals("Operador")){
                lblExtra1.setText("Valor / hora: ");
                lblExtra2.setVisible(false);
                txtExtra2.setVisible(false);
            }else{
                if(chcCargo.getSelectedItem().equals("Secretária")){
                    lblExtra1.setText("Telefone: ");
                    lblExtra2.setText("Ramal: ");
                }else{
                    lblExtra1.setText("Login: ");
                    lblExtra2.setText("Senha: ");
                }
                lblExtra2.setVisible(true);
                txtExtra2.setVisible(true);
            }
            txtExtra1.setText(" ");
            txtExtra1.setText("");
            txtExtra2.setText(" ");
            txtExtra2.setText("");
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        dispose();
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
