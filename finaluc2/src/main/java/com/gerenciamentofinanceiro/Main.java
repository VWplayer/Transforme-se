package com.gerenciamentofinanceiro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);
    while(true){
        System.out.println("Escolha uma das opções: ");
        mostrarOpç1();
        int opcao = leitor.nextInt();
        switch (opcao) {
            case 1:
            System.out.println("Digite o tipo da despesa gasta: ");
            String tipodespesa = leitor.next();
            System.out.println("Digite o valor da despesa: ");
            double valordespesa = leitor.nextDouble();
            inserirDespesa(tipodespesa, valordespesa);
                break;
            case 2:
                System.out.println("Digite o id da despesa que deseja excluir");
                int iddespesa = leitor.nextInt();
                removerDespesa(iddespesa);
                break;
            case 3:
                while(true){
                System.out.println("Escolha uma opção ou 0 para sair: ");
                mostrarOpç2();
                int a = leitor.nextInt();
                if(a == 1){
                    System.out.println("Digite o novo tipo de despesa: ");
                    String novadespesa = leitor.next();
                    System.out.println("Digite o id da despesa: ");
                    int iddespesa2 = leitor.nextInt();
                    editarTipoDespesa(novadespesa, iddespesa2);
                    continue;
                }
                else if(a==2){
                    System.out.println("Digite o novo valor da despesa: ");
                    int novoValordespesa = leitor.nextInt();
                    System.out.println("Digite o id da despesa: ");
                    int iddespesa3 = leitor.nextInt();
                    editarValorDespesa(novoValordespesa, iddespesa3);
                    continue;  
                }
                else if(a==2){
                    System.out.println("Digite o novo valor da despesa: ");
                    String novaDataDespesa = leitor.next();
                    System.out.println("Digite o id da despesa: ");
                    int iddespesa4 = leitor.nextInt();
                    editarDataDespesa(novaDataDespesa, iddespesa4);  
                    continue;
                }
                else if(a == 0){
                    break;
                }
                }
            default:
                System.out.println("Opção inválida");
        }    
    }
}

    public static void inserirDespesa(String tipodespesa, double valordespesa) {
        String url = "jdbc:mysql://localhost:3306/gfinanceiro";
        String username = "root";
        String password = "Aluno";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement consulta = conn.prepareStatement("INSERT INTO despesas VALUES (default, ?, ?, CURRENT_TIMESTAMP)");

            consulta.setString(1, tipodespesa);

            consulta.setDouble(2, valordespesa);

            consulta.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void removerDespesa(int iddespesa) {
        String url = "jdbc:mysql://localhost:3306/gfinanceiro";
        String username = "root";
        String password = "Aluno";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement consulta = conn.prepareStatement("DELETE FROM despesas WHERE idpaciente = ?;");

            consulta.setInt(1, iddespesa);

            consulta.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void editarTipoDespesa(String tipodespesa,int iddespesa) {
        String url = "jdbc:mysql://localhost:3306/gfinanceiro";
        String username = "root";
        String password = "Aluno";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement consulta = conn.prepareStatement("UPDATE despesas SET tipodespesa = ? WHERE iddespesa = ?");

            consulta.setString(1, tipodespesa);

            consulta.setInt(2, iddespesa);

            consulta.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void editarValorDespesa(int valordespesa,int iddespesa) {
        String url = "jdbc:mysql://localhost:3306/gfinanceiro";
        String username = "root";
        String password = "Aluno";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement consulta = conn.prepareStatement("UPDATE despesas SET valordespesa = ? WHERE iddespesa = ?");

            consulta.setInt(1, valordespesa);

            consulta.setInt(2, iddespesa);

            consulta.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void editarDataDespesa(String datadespesa,int iddespesa) {
        String url = "jdbc:mysql://localhost:3306/gfinanceiro";
        String username = "root";
        String password = "Aluno";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement consulta = conn.prepareStatement("UPDATE despesas SET datadespesa = ?, WHERE iddespesa = ?");

            consulta.setString(1, datadespesa);

            consulta.setInt(2, iddespesa);

            consulta.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void mostrarOpç1(){
        System.out.println("1. Inserir Despesa: ");
        System.out.println();
        System.out.println("2. Remover Despesa: ");
        System.out.println();
        System.out.println("3. Editar Despesa: ");
        System.out.println();
    }

    public static void mostrarOpç2(){
        System.out.println("1. Editar nome da despesa: ");
        System.out.println();
        System.out.println("2. Editar valor da despesa: ");
        System.out.println();
        System.out.println("3. Editar data da despesa: ");
        System.out.println();
        System.out.println("0. Sair");
    }
}