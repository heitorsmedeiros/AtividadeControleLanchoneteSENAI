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
        
        // Variáveis do Desafio 3
        double somaAcima30 = 0.0;
        int qtdAcima30 = 0;

        // Variável do Desafio 4
        int opcaoMenu = 0;

        System.out.println("=== SISTEMA DE PEDIDOS ===");

        // Loop principal do Desafio 4 (Menu Inicial)
        while (opcaoMenu != 3) {
            System.out.println("\nMENU INICIAL:");
            System.out.println("1 - Cadastrar Pedido");
            System.out.println("2 - Exibir Relatório");
            System.out.println("3 - Encerrar Sistema");
            System.out.print("Escolha uma opção: ");
            
            opcaoMenu = scanner.nextInt();
            scanner.nextLine(); // Consome a quebra de linha deixada pelo nextInt

            if (opcaoMenu == 1) {
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
                        clienteMaiorCompra = nome; 
                    }
                    if (valor < menorCompra) {
                        menorCompra = valor;
                    }

                    // Lógica do Desafio 1
                    if (valor > 50.0) {
                        comprasAcima50++;
                    }
                    
                    // Lógica do Desafio 3
                    if (valor > 30.0) {
                        somaAcima30 += valor;
                        qtdAcima30++;
                    }

                    System.out.println("\nCadastrar novo pedido?");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");
                    continuar = scanner.nextInt();
                    scanner.nextLine(); // Consome a quebra de linha novamente
                }

            } else if (opcaoMenu == 2) {
                // Regra de Negócio: O relatório sendo exibido sob demanda através do menu.
                System.out.println("\n===== RELATÓRIO =====");
                
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
                    
                    // Exibição do Desafio 3
                    if (qtdAcima30 > 0) {
                        double mediaAcima30 = somaAcima30 / qtdAcima30;
                        System.out.printf("Média das compras acima de R$ 30,00: R$ %.2f\n", mediaAcima30);
                    }
                } else {
                    System.out.println("Nenhum pedido foi cadastrado no sistema.");
                }

            } else if (opcaoMenu == 3) {
                System.out.println("\nEncerrando o sistema...");
            } else {
                System.out.println("\nOpção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }
}