package com.tcc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class TelaCadastrar extends JFrame {
    Font fonte1 = new Font("Trebuchet MS", Font.BOLD, 16);
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton buttonLeft;
    private JButton buttonRight;

    public TelaCadastrar(List<ServicoProduto> lista) {
        super("Cadastrar Serviços/Produtos");

        // Inicialização dos componentes
        label1 = new JLabel("Digite o serviço/produto:");
        label1.setFont(fonte1);
        textField1 = new JTextField(20);
        textField1.setFont(fonte1);
        label2 = new JLabel("Digite o valor:");
        label2.setFont(fonte1);
        textField2 = new JTextField(10);
        textField2.setFont(fonte1);
        buttonLeft = new JButton("Botão Esquerdo");
        buttonLeft.setFont(fonte1);
        buttonRight = new JButton("Botão Direito");
        buttonRight.setFont(fonte1);

        // Layout da tela
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento
        add(label1, gbc);
 
        gbc.gridx = 1;
        add(textField1, gbc);
 
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(label2, gbc);
 
        gbc.gridx = 1;
        add(textField2, gbc);
 
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonLeft.setText("Voltar");
        buttonLeft.setBackground(new Color(255,165,0)); // Orange
        buttonLeft.setForeground(Color.WHITE);
        buttonLeft.addActionListener(e ->{
            new TelaPrincipal(lista);
            this.dispose();
        });
        buttonRight.setText("Cadastrar");
        buttonRight.setBackground(new Color(52, 152, 219)); // Azul
        buttonRight.setForeground(Color.WHITE);
        buttonRight.addActionListener(e ->{
            if(textField1.getText().equals("") || textField2.getText().equals("") ){
                JOptionPane.showMessageDialog(rootPane,"Preencha os campos !", "Aviso",JOptionPane.INFORMATION_MESSAGE);
                
            }
            else{
            lista.add(new ServicoProduto(textField1.getText(),Double.valueOf(textField2.getText())));
            JOptionPane.showMessageDialog(rootPane," | "+textField1.getText()+" | "+"Adcionado com sucesso!", "Aviso",JOptionPane.INFORMATION_MESSAGE);
            textField1.setText("");
            textField2.setText("");
            }
        });
        buttonPanel.add(buttonLeft);
        buttonPanel.add(buttonRight);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(buttonPanel, gbc);
 
        // Configurações da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setVisible(true);
    }
}

