package com.empresa.controlepontogui.view;

import com.empresa.controlepontogui.model.Funcionario;
import com.empresa.controlepontogui.model.RegistroPonto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RegistroPontoGUI extends JFrame implements ActionListener, WindowListener {

    protected Dimension dFrame, dLabel, dTextField, dTextArea, dButton;
    protected Button cmdEntrada, cmdSaida;
    protected Label lblId;
    protected TextField txtId;
    protected TextArea txtLog;
    protected JMenuBar mb;
    protected JMenu opcoes, menuFunc;
    protected JMenuItem i1, i2;
    private List<RegistroPonto> registros = new ArrayList<>();
    private List<Funcionario> funcionarios;
    private int defIdRegistro = 1;
    private int defIdFunc;
    private CadastroFuncGUI telaCadFunc;
    private ConsultaFuncGUI telaConsFunc;

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public int getDefIdFunc() {
        return defIdFunc;
    }

    public void setDefIdFunc(int defIdFunc) {
        this.defIdFunc = defIdFunc;
    }

    public RegistroPontoGUI(List funcionarios){

        this.funcionarios = funcionarios;
        this.defIdFunc = funcionarios.size() +1;

        dFrame = new Dimension(600,350);
        dLabel = new Dimension(40,20);
        dTextField = new Dimension(50,20);
        dButton = new Dimension(95,30);
        dTextArea = new Dimension(450,180);

        setTitle("Controle de Registro de Ponto");
        setSize(dFrame);
        setResizable(false);
        setLocation(350,200);
        setLayout(null);

        mb=new JMenuBar();
        opcoes=new JMenu("Opções");
        menuFunc=new JMenu("Funcionário");
        i1=new JMenuItem("Cadastro");
        i2=new JMenuItem("Consulta");

        i1.addActionListener(this);
        i2.addActionListener(this);

        menuFunc.add(i1);
        menuFunc.add(i2);
        opcoes.add(menuFunc);

        mb.add(opcoes);
        setJMenuBar(mb);

        lblId = new Label("ID: ");
        lblId.setSize(dLabel);
        lblId.setLocation(50,50);
        lblId.setFont(new Font("Ravie", 0, 13));
        add(lblId);

        txtId = new TextField(null);
        txtId.setSize(dTextField);
        txtId.setLocation(100,50);
        txtId.setForeground(new Color(111, 111, 111));
        add(txtId);

        cmdEntrada = new Button("Entrada");
        cmdEntrada.setSize(dButton);
        cmdEntrada.setLocation(320,50);
        cmdEntrada.setFont(new Font("Ravie", 1, 17));
        cmdEntrada.setForeground(new Color(245, 245, 245));
        cmdEntrada.setBackground(new Color(29, 165, 167));
        add(cmdEntrada);
        cmdEntrada.addActionListener(this);

        cmdSaida = new Button("Saida");
        cmdSaida.setSize(dButton);
        cmdSaida.setLocation(450,50);
        cmdSaida.setFont(new Font("Ravie", 1, 17));
        cmdSaida.setForeground(new Color(245, 245, 245));
        cmdSaida.setBackground(new Color(208, 131, 90));
        add(cmdSaida);
        cmdSaida.addActionListener(this);

        txtLog = new TextArea(null);
        txtLog.setSize(dTextArea);
        txtLog.setLocation(100,100);
        txtLog.setEditable(false);
        txtLog.setBackground(Color.white);
        txtLog.setForeground(new Color(111, 111, 111));
        add(txtLog);

        addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // verifica a origem do evento
        if(e.getSource()==cmdEntrada){
            // verifica se campo id esta vazio
            if(!txtId.getText().trim().isEmpty()) {
                // trata o erro causado pelo tipo de dado informado
                try {
                    int idFunc = Integer.parseInt(txtId.getText());
                    Funcionario funcEncontrado = null;

                    //procura funcionario pelo id
                    for (Funcionario f : funcionarios) {
                        if (f.getIdFunc() == idFunc) {
                            funcEncontrado = f;
                            break;
                        }
                    }
                    if(funcEncontrado!=null) {
                        if (!funcEncontrado.estaAguardandoRegSaida()) {
                            //novo registro
                            funcEncontrado.setAguardandoRegSaida(true);
                            RegistroPonto reg = new RegistroPonto(defIdRegistro++, funcEncontrado);
                            registros.add(reg);
                            //mensagem
                            DateTimeFormatter dataPadrao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            DateTimeFormatter horaPadrao = DateTimeFormatter.ofPattern("HH:mm:ss");
                            txtLog.append(reg.getFunc().getClass().getSimpleName() + " " + reg.getFunc().getNome() +
                                    " registrou entrada às " + reg.getHoraEntrada().format(horaPadrao) +
                                    " do dia " + reg.getDataRegistro().format(dataPadrao) + "\n");
                        } else {
                            txtLog.append("Registre a saída do mesmo antes de uma nova entrada..\n");
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
                txtLog.append("Informe o ID do funcionario..\n");
            }

            txtId.setText(null);
            txtId.requestFocus();
        }

        if(e.getSource()==cmdSaida) {
            // verifica se campo id esta vazio
            if(!txtId.getText().trim().isEmpty()) {
                // trata o erro causado pelo tipo de dado informado
                try {
                    int idFunc = Integer.parseInt(txtId.getText());
                    Funcionario funcEncontrado = null;

                    //procura funcionario pelo id
                    for (Funcionario f : funcionarios) {
                        if (f.getIdFunc() == idFunc) {
                            funcEncontrado = f;
                            break;
                        }
                    }

                    if(funcEncontrado!=null) {
                        if (funcEncontrado.estaAguardandoRegSaida()) {
                            //encontra registro a finalizar
                            RegistroPonto reg = null;

                            for (RegistroPonto r:registros) {
                                if(r.getFunc().getIdFunc() == funcEncontrado.getIdFunc()){
                                    reg = r;
                                    break;
                                }
                            }

                            //finaliza registro
                            reg.setHoraSaida();
                            funcEncontrado.setAguardandoRegSaida(false);

                            //mensagem
                            DateTimeFormatter dataPadrao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            DateTimeFormatter horaPadrao = DateTimeFormatter.ofPattern("HH:mm:ss");
                            txtLog.append(reg.getFunc().getClass().getSimpleName() + " " + reg.getFunc().getNome() +
                                    " registrou saída às " + reg.getHoraSaida().format(horaPadrao) +
                                    " do dia " + reg.getDataRegistro().format(dataPadrao) + "\n");
                        } else {
                            txtLog.append("Registre a entrada do mesmo antes de uma nova saída..\n");
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
                txtLog.append("Informe o ID do funcionario..\n");
            }

            txtId.setText(null);
            txtId.requestFocus();
        }

        //feature extra
        if(e.getSource()==i1){
            //abrir janela nova de cadastro de funcionario
            if(telaCadFunc==null) {
                try {
                    telaCadFunc = new CadastroFuncGUI(this);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                telaCadFunc.setVisible(true);
            }else{
                if(!telaCadFunc.isVisible()){
                    try {
                        telaCadFunc = new CadastroFuncGUI(this);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    telaCadFunc.setVisible(true);
                }
                telaCadFunc.setExtendedState(0);
                telaCadFunc.requestFocus();
            }
        }
        if(e.getSource()==i2){
            //abrir janela nova de consulta de funcionario
            if(telaConsFunc==null) {
                telaConsFunc = new ConsultaFuncGUI(this);
                telaConsFunc.setVisible(true);
            }else{
                if(!telaConsFunc.isVisible()){
                    telaConsFunc = new ConsultaFuncGUI(this);
                    telaConsFunc.setVisible(true);
                }
                telaConsFunc.setExtendedState(0);
                telaConsFunc.requestFocus();
            }
        }
    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
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
