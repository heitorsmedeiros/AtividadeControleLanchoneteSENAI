package com.example;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.forLanguageTag("pt-BR"));

        int totalPedidos = 0;
        double valorTotal = 0.0;
        double maiorCompra = 0.0;
        double menorCompra = Double.MAX_VALUE;
        
        // Variável do Desafio 1
        int comprasAcima50 = 0;
        
        // Variável do Desafio 2
        String clienteMaiorCompra = "";

        System.out.println("=== SISTEMA DE PEDIDOS ===");

        int continuar = 1;

        // Regra de Negócio: O sistema deve permitir o cadastro de vários pedidos e 
        // só deve encerrar quando o usuário informar que não deseja mais cadastrar pedidos (opção diferente de 1).
        while (continuar == 1) {
            System.out.print("\nNome do cliente: ");
            String nome = scanner.nextLine();

            double valor = 0;
            
            // Regra de Negócio: O valor da compra deve ser maior que zero.
            while (valor <= 0) {
                System.out.print("Valor da compra: ");
                valor = scanner.nextDouble();
                if (valor <= 0) {
                    System.out.println("Erro: O valor da compra deve ser maior que zero!");
                }
            }

            totalPedidos++; 
            valorTotal += valor; 

            // Atualizado para o Desafio 2
            if (valor > maiorCompra) {
                maiorCompra = valor;
                clienteMaiorCompra = nome; 
            }
            if (valor < menorCompra) {
                menorCompra = valor;
            }

            // Lógica do Desafio 1
            if (valor > 50.0) {
                comprasAcima50++;
            }

            System.out.println("\nCadastrar novo pedido?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            continuar = scanner.nextInt();
            scanner.nextLine();
        }

        // Regra de Negócio: O relatório deve ser exibido apenas ao final do processamento.
        System.out.println("\n===== RELATÓRIO FINAL =====");
        
        if (totalPedidos > 0) {
            double ticketMedio = valorTotal / totalPedidos;

            System.out.printf("Quantidade de pedidos: %d\n", totalPedidos);
            System.out.printf("Valor total vendido: R$ %.2f\n", valorTotal);
            System.out.printf("Ticket médio: R$ %.2f\n", ticketMedio);
            System.out.printf("Maior compra: R$ %.2f\n", maiorCompra);
            System.out.printf("Menor compra: R$ %.2f\n", menorCompra);
            
            // Exibição do Desafio 1
            System.out.printf("Compras superiores a R$ 50,00: %d\n", comprasAcima50);
            
            // Exibição do Desafio 2
            System.out.printf("Cliente da maior compra: %s\n", clienteMaiorCompra);
        } else {
            System.out.println("Nenhum pedido foi cadastrado no sistema.");
        }

        scanner.close();
    }
}