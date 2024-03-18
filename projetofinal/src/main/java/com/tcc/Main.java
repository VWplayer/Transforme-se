package com.tcc;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ServicoProduto> listateste = new ArrayList<>();
        listateste.add(new ServicoProduto("Pintura", 500));
        listateste.add(new ServicoProduto("Visita Técnica", 200));
        listateste.add(new ServicoProduto("Instalação de Tv", 300));
        listateste.add(new ServicoProduto("Troca de tomada", 500));
        TelaPrincipal tela1 = new TelaPrincipal(listateste);
        // TelaCadastrar tela2 = new TelaCadastrar();
        // TelaServicosProdutos tela3 = new TelaServicosProdutos(listateste);
        // TelaRevisarOrcamento tela4 = new TelaRevisarOrcamento(listateste);
    }
}