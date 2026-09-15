package com.example;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(new Locale("pt", "BR"));

        int totalPedidos = 0;
        double valorTotal = 0.0;
        double maiorCompra = 0.0;
        double menorCompra = Double.MAX_VALUE;

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

            if (valor > maiorCompra) {
                maiorCompra = valor;
            }
            if (valor < menorCompra) {
                menorCompra = valor;
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
        } else {
            System.out.println("Nenhum pedido foi cadastrado no sistema.");
        }

        scanner.close();
    }
}