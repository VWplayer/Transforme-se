package com.tcc;

public class ServicoProduto {
    private String nome;
    private double valor;
    public ServicoProduto(String nome, double valor){
        this.nome = nome;
        this.valor = valor;
    }
    // Getter para o atributo 'nome'
    public String getNome() {
        return nome;
    }

    // Setter para o atributo 'nome'
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para o atributo 'valor'
    public double getValor() {
        return valor;
    }

    // Setter para o atributo 'valor'
    public void setValor(double valor) {
        this.valor = valor;
    }
}
