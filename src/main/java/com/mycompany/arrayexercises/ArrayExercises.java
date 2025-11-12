
package com.mycompany.arrayexercises;

//importação de bibliotecas
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayExercises {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;//variável que armazenará a opção selecionada pelo usuário
        
        //Menu feito com um loop Do-While
        do {
            exibirMenu();
            System.out.print("Escolha uma opcao: ");//mensagem
            opcao = sc.nextInt();
            sc.nextLine(); //limpa o buffer
            
            // Bloco Switch Case, responsável pelo menu
            switch (opcao) {
                case 1://opção 1: Nomes em ordem crescente
                    nomesOrdemCrescente(sc);
                    break;
                case 2://opção 2: Nomes em ordem decrescente
                    nomesOrdemDecrescente(sc);
                    break;
                case 3://opção 3: Números ímpares
                    numerosImpares();
                    break;
                case 4://opção 4: Números pares
                    numerosPares();
                    break;
                case 0://opção 0: Fechará o programa
                    System.out.println("Encerrando programa... Obrigado!");
                    break;
                default:// Mensagem de opção inválida
                    System.out.println("❌ Opcao invalida! Tente novamente.");
            }
            
            //Se a opção for diferente de 0 (zero), o loop dará continuidade por meio da tecla ENTER
            if (opcao != 0) {
                System.out.println("\n" + "=".repeat(50) + "\n");
                System.out.println("Pressione ENTER para continuar...");
                sc.nextLine();
            }
            
        } while (opcao != 0);
        
        sc.close();
    }
    
    // Exibe o menu de forma visual
    public static void exibirMenu() {
        System.out.println("=== MENU DE EXERCICIOS - ARRAYS ===");
        System.out.println("1 - Nomes em Ordem Crescente (A-Z)");
        System.out.println("2 - Nomes em Ordem Decrescente (Z-A)");
        System.out.println("3 - Numeros Impares de 0 a 100");
        System.out.println("4 - Numeros Pares de 0 a 100");
        System.out.println("0 - Sair");
    }
    
    // Exercício 1: Nomes em ordem crescente
    public static void nomesOrdemCrescente(Scanner sc) {
        System.out.println("EXERCICIO 1: Nomes em Ordem Crescente\n");
        
        System.out.print("Quantos nomes deseja ordenar? ");//mensagem
        int qtd = sc.nextInt();//variável que irá armazenar a quantidade informada pelo usuário
        sc.nextLine();
        
        String[] nomes = new String[qtd];//variável que armazenará os nomes informados
        
        System.out.println();
        //Loop For
        for (int i = 0; i < qtd; i++) {// i inicia com o valor de 0 (zero), condicional, incremento
            System.out.print("Digite o nome " + (i + 1) + ": ");//mensagem
            nomes[i] = sc.nextLine();
        }
        
        System.out.println("\n--- Nomes Originais ---");//exibe os nomes inseridos 
        exibirArray(nomes);
        
        Arrays.sort(nomes);//é essa linha que organiza os nomes em ordem crescente
        
        //Exibe o resultado final
        System.out.println("\n Nomes em Ordem CRESCENTE (A-Z) ---");
        exibirArray(nomes);
    }
    
    // Exercício 2: Nomes em ordem decrescente
    public static void nomesOrdemDecrescente(Scanner sc) {
        System.out.println("EXERCICIO 2: Nomes em Ordem Decrescente\n");
        
        System.out.print("Quantos nomes deseja ordenar? ");//mensagem
        int qtd = sc.nextInt();//armazena quantidade inserida pelo usuário
        sc.nextLine();
        
        String[] nomes = new String[qtd];//armazena nomes
        
        System.out.println();
        //Loop For
        for (int i = 0; i < qtd; i++) {// i inicia com o valor de 0 (zero), condicional, incremento
            System.out.print("Digite o nome " + (i + 1) + ": ");//mensagem
            nomes[i] = sc.nextLine();
        }
        
        System.out.println("\n--- Nomes Originais ---");//exibe nomes inseridos inicialmente
        exibirArray(nomes);
        
        Arrays.sort(nomes, Collections.reverseOrder());//aqui é a linha responsável por organizar os nomes em ordem descrescente
        
        //exibição do resultado final
        System.out.println("\nNomes em Ordem DECRESCENTE (Z-A) ---");
        exibirArray(nomes);
    }
    
    // Exercício 3: Números ímpares de 0 a 100
    public static void numerosImpares() {
        System.out.println(" EXERCICIO 3: Numeros Impares de 0 a 100\n");
        
        // Conta quantos ímpares existem de 0 a 100
        int contador = 0;//variável contadora
        //Loop For
        for (int i = 0; i <= 100; i++) {// i inicia com o valor de 0 (zero), condicional, incremento
            //aqui só conta
            if (i % 2 != 0) {
                contador++;
            }
        }
        
        // Cria o array com o tamanho correto
        int[] impares = new int[contador];//o indice guarda os números que foram contados pela variável contador
        
        int indice = 0;
        for (int i = 0; i <= 100; i++) {// i inicia com o valor de 0 (zero), condicional, incremento
             // e aqui preenche o array com os números ímpares
            if (i % 2 != 0) {
                impares[indice] = i;
                indice++;
            }
        }
        
        System.out.println(" Total de numeros impares: " + impares.length);//exibe mensagem do total
        System.out.println("\n--- Numeros Impares ---");
        exibirArrayNumeros(impares);
    }
    
    // Exercício 4: Números pares de 0 a 100
    public static void numerosPares() {
        System.out.println(" EXERCICIO 4: Numeros Pares de 0 a 100\n");
        
        // Conta quantos pares existem de 0 a 100
        int contador = 0;//variável contadora
        for (int i = 0; i <= 100; i++) {// i inicia com o valor de 0 (zero), condicional, incremento
            //conta
            if (i % 2 == 0) {
                contador++;
            }
        }
        
        // Cria o array com o tamanho correto
        int[] pares = new int[contador];
        
        // preenche o array com os números pares
        int indice = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                pares[indice] = i;
                indice++;
            }
        }
        
        System.out.println("\n--- Numeros Pares ---");//exibição
        exibirArrayNumeros(pares);
    }
    
    // Método para exibir array de strings
    public static void exibirArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println((i + 1) + ". " + arr[i]);
        }
    }
    
    // Método para exibir array de números (mais compacto)
    public static void exibirArrayNumeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
            // Quebra linha a cada 10 números para melhor visualização
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println(); // Linha final
    }
}