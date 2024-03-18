package com.tcc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class TelaPrincipal extends JFrame {
Font fonte1 = new Font("Trebuchet MS", Font.BOLD, 42);
private List<ServicoProduto> lista;
public TelaPrincipal(List<ServicoProduto> lista){
    if(lista.size()==0){
        List<ServicoProduto> lista1 = new ArrayList<>();
        this.lista = lista1;  
    }
    else{
        this.lista = lista;
    }
        // Configurações básicas da janela
        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        
        // Layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 0, 10));
        
        // Botões
        JButton botao1 = new JButton("Cadastrar Seviços/Produtos");
        botao1.setFont(fonte1);
        botao1.addActionListener(e->{
            new TelaCadastrar(lista);
            this.dispose();
        });
        JButton botao2 = new JButton("Construir Orçamentos");
        botao2.setFont(fonte1);
        botao2.addActionListener(e->{
            new TelaServicosProdutos(lista);
            this.dispose();
        });
        
        // Adicionando botões ao painel
        panel.add(botao1);
        panel.add(botao2);
        
        // Estilizando botões
        botao1.setBackground(new Color(52, 152, 219)); // Azul
        botao1.setForeground(Color.WHITE);
        botao2.setBackground(new Color(241, 196, 15)); // Amarelo
        botao2.setForeground(Color.WHITE);
        
        // Adicionando o painel à janela
        add(panel);
        
        setVisible(true); // Torna a janela visível
    }}