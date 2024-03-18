package com.tcc;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TelaRevisarOrcamento extends JFrame {
    Font fonte1 = new Font("Trebuchet MS", Font.BOLD, 20);
    private List<ServicoProduto> dados;
    private List<ServicoProduto> dados1;

    public TelaRevisarOrcamento(List<ServicoProduto> dados,List<ServicoProduto> dados1) {
        if(dados.size()==0){
            JOptionPane.showMessageDialog(rootPane, "Adcione um Serviço/ Produto em seu Orçamento", "Aviso",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            new TelaPrincipal(dados1);
        }
        else{
        this.dados = dados;
        this.dados1 = dados1;
        initComponents();
        }
    }

    private void initComponents() {
        setTitle("Lista de Labels");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(dados.size()+1, 3, 10, 10)); // 3 colunas por linha

        for (ServicoProduto dado : dados) {
            JLabel label1 = new JLabel(dado.getNome());
            label1.setFont(fonte1);
            JLabel label2 = new JLabel("Valor R$: "+String.valueOf(dado.getValor()));
            label2.setFont(fonte1);
            JButton button = new JButton("Remover");
            button.setBackground(new Color(178,34,34)); // Vermelho
            button.setForeground(Color.WHITE);
            button.setFont(fonte1);
            button.addActionListener(e ->{
                dados.remove(dado);
                JOptionPane.showMessageDialog(rootPane,"| "+ dado.getNome()+" |"+" removido do orçamento !", "Aviso",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                new TelaRevisarOrcamento(dados,dados1);

            });
            panel.add(label1);
            panel.add(label2);
            panel.add(button);
        }

        JButton buttonFinal = new JButton("Gerar Orçamento");
        buttonFinal.setBackground(new Color(52, 152, 219)); // Azul
        buttonFinal.setForeground(Color.WHITE);
        buttonFinal.setFont(fonte1);
        buttonFinal.addActionListener(e->{
        });
        panel.add(new JLabel()); // Adiciona um espaço vazio para ocupar as duas colunas de labels
        panel.add(buttonFinal); // Adiciona o botão final
  
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        getContentPane().add(scrollPane);

        setVisible(true);
    }
}

