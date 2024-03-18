package com.tcc;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TelaServicosProdutos extends JFrame {
    Font fonte1 = new Font("Trebuchet MS", Font.BOLD, 20);
    Font fonte2 = new Font("Trebuchet MS", Font.BOLD, 16);
    private List<ServicoProduto> dados;
    private List<ServicoProduto> dados1;

    public TelaServicosProdutos(List<ServicoProduto> dados) {
        this.dados = dados;
        this.dados1 = new ArrayList<ServicoProduto>();
        initComponents();
    }

    private void initComponents() {
        setTitle("Construção de Orçamentos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1+dados.size(), 3, 10, 10)); // 3 colunas por linha

        for (ServicoProduto dado : dados) {
            JLabel label1 = new JLabel("  "+dado.getNome());
            label1.setFont(fonte1);
            JLabel label2 = new JLabel("Valor R$: "+String.valueOf(dado.getValor()));
            label2.setFont(fonte1);
            JButton button = new JButton("Adcionar");
            button.setBackground(new Color(50,205,50));
            button.setFont(fonte1);
            button.addActionListener(e ->{
                dados1.add(dado);
                JOptionPane.showMessageDialog(rootPane,"| "+ dado.getNome()+" |"+" adcionado ao orçamento !", "Aviso",JOptionPane.INFORMATION_MESSAGE);
            });
            panel.add(label1);
            panel.add(label2);
            panel.add(button);
        }
        
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBackground(new Color(255,165,0)); // Laranja
        botaoVoltar.setForeground(Color.WHITE);
        botaoVoltar.setFont(fonte1);
        botaoVoltar.addActionListener(e ->{
            new TelaPrincipal(dados);
            this.dispose();
        });

        JButton botaoRevisar = new JButton("Revisar Orçamento");
        botaoRevisar.setBackground(new Color(52, 152, 219)); // Azul
        botaoRevisar.setForeground(Color.WHITE);
        botaoRevisar.setFont(fonte2);
        botaoRevisar.addActionListener(e ->{
            new TelaRevisarOrcamento(dados1,dados);
            this.dispose();
        });


        panel.add(botaoVoltar);
        panel.add(new JLabel());
        panel.add(botaoRevisar);
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        getContentPane().add(scrollPane);

        setVisible(true);
    }
}
