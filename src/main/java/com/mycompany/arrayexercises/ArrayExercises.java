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
                case 1://opção 1: Digitar vários números e separar pares/ímpares
                    exercicioNumeros(sc);
                    break;
                case 2://opção 2: Digitar vários nomes e ordenar crescente/decrescente
                    exercicioNomes(sc);
                    break;
                case 0://opção 0: Fechará o programa
                    System.out.println("║  Encerrando programa... Obrigado!      ║");
                    break;
                default:// Mensagem de opção inválida
                    System.out.println(" Opcao invalida! Tente novamente.");
            }
            
            //Se a opção for diferente de 0 (zero), o loop dará continuidade por meio da tecla ENTER
            if (opcao != 0) {
                System.out.println("Pressione ENTER para continuar...");
                sc.nextLine();
            }
            
        } while (opcao != 0);
        
        sc.close();
    }
    
    // Exibe o menu de forma visual
    public static void exibirMenu() {
        System.out.println("      MENU DE EXERCICIOS - ARRAYS                    ");
        System.out.println("  1 - Digitar Numeros (Exibir Pares e Impares)       ");
        System.out.println("  2 - Digitar Nomes (Crescente e Decrescente)        ");
        System.out.println("  0 - Sair                                            ");
    }
    
    // EXERCÍCIO 1: Digitar vários números e exibir pares e ímpares
    public static void exercicioNumeros(Scanner sc) {
        System.out.println("      EXERCICIO 1: NUMEROS PARES E IMPARES           ");
        
        System.out.print("Quantos numeros deseja digitar? ");//mensagem
        int qtd = sc.nextInt();//variável que irá armazenar a quantidade informada pelo usuário
        sc.nextLine();//limpa o buffer
        
        int[] numeros = new int[qtd];//array que armazenará os números digitados
        
        System.out.println();
        //Loop For - lê os números do usuário
        for (int i = 0; i < qtd; i++) {// i inicia com o valor de 0 (zero), condicional, incremento
            System.out.print("Digite o numero " + (i + 1) + ": ");//mensagem
            numeros[i] = sc.nextInt();
        }
        sc.nextLine();//limpa o buffer
        
        // Exibe os números digitados
        System.out.println("\n" + "─".repeat(60));
        System.out.println("NUMEROS DIGITADOS:");
        System.out.println("─".repeat(60));
        exibirArrayNumeros(numeros);
        
        // Separa os números em pares e ímpares
        int[] pares = separarPares(numeros);
        int[] impares = separarImpares(numeros);
        
        // Exibe os números PARES
        System.out.println(" NUMEROS PARES:");
        if (pares.length > 0) {
            exibirArrayNumeros(pares);
            System.out.println("Total de numeros pares: " + pares.length);
        } else {
            System.out.println("Nenhum numero par encontrado.");
        }
        
        // Exibe os números ÍMPARES
        System.out.println(" NUMEROS IMPARES:");
        if (impares.length > 0) {
            exibirArrayNumeros(impares);
            System.out.println("Total de numeros impares: " + impares.length);
        } else {
            System.out.println("Nenhum numero impar encontrado.");
        }
    }
    
    // EXERCÍCIO 2: Digitar vários nomes e exibir em ordem crescente e decrescente
    public static void exercicioNomes(Scanner sc) {
        System.out.println("║  EXERCICIO 2: NOMES CRESCENTE E DECRESCENTE         ║");
        
        System.out.print("Quantos nomes deseja digitar? ");//mensagem
        int qtd = sc.nextInt();//armazena quantidade inserida pelo usuário
        sc.nextLine();//limpa o buffer
        
        String[] nomes = new String[qtd];//armazena nomes
        
        System.out.println();
        //Loop For - lê os nomes do usuário
        for (int i = 0; i < qtd; i++) {// i inicia com o valor de 0 (zero), condicional, incremento
            System.out.print("Digite o nome " + (i + 1) + ": ");//mensagem
            nomes[i] = sc.nextLine();
        }
        
        // Exibe os nomes digitados
        System.out.println("? NOMES DIGITADOS:");
        exibirArray(nomes);
        
        // Cria cópias do array para não perder a ordem original
        String[] nomesCrescente = Arrays.copyOf(nomes, nomes.length);
        String[] nomesDecrescente = Arrays.copyOf(nomes, nomes.length);
        
        // Ordena em ORDEM CRESCENTE (A-Z)
        Arrays.sort(nomesCrescente);
        
        // Ordena em ORDEM DECRESCENTE (Z-A)
        Arrays.sort(nomesDecrescente, Collections.reverseOrder());
        
        // Exibe nomes em ORDEM CRESCENTE
        System.out.println("️  ORDEM CRESCENTE (A-Z):");
        exibirArray(nomesCrescente);
        
        // Exibe nomes em ORDEM DECRESCENTE
        System.out.println("⬇️  ORDEM DECRESCENTE (Z-A):");
        exibirArray(nomesDecrescente);
    }
    
    // Método que separa apenas os números PARES de um array
    public static int[] separarPares(int[] numeros) {
        // Primeiro: conta quantos números pares existem
        int contador = 0;//variável contadora
        for (int i = 0; i < numeros.length; i++) {// i inicia com o valor de 0 (zero), condicional, incremento
            if (numeros[i] % 2 == 0) {// Se o resto da divisão por 2 for 0, é PAR
                contador++;
            }
        }
        
        // Segundo: cria o array com o tamanho correto
        int[] pares = new int[contador];
        
        // Terceiro: preenche o array com os números pares
        int indice = 0;
        for (int i = 0; i < numeros.length; i++) {// i inicia com o valor de 0 (zero), condicional, incremento
            if (numeros[i] % 2 == 0) {
                pares[indice] = numeros[i];//guarda o número par na posição do indice
                indice++;//avança para a próxima posição
            }
        }
        
        return pares;//retorna o array preenchido com os números pares
    }
    
    // Método que separa apenas os números ÍMPARES de um array
    public static int[] separarImpares(int[] numeros) {
        // Primeiro: conta quantos números ímpares existem
        int contador = 0;//variável contadora
        for (int i = 0; i < numeros.length; i++) {// i inicia com o valor de 0 (zero), condicional, incremento
            if (numeros[i] % 2 != 0) {// Se o resto da divisão por 2 for diferente de 0, é ÍMPAR
                contador++;
            }
        }
        
        // Segundo: cria o array com o tamanho correto
        int[] impares = new int[contador];
        
        // Terceiro: preenche o array com os números ímpares
        int indice = 0;
        for (int i = 0; i < numeros.length; i++) {// i inicia com o valor de 0 (zero), condicional, incremento
            if (numeros[i] % 2 != 0) {
                impares[indice] = numeros[i];//guarda o número ímpar na posição do indice
                indice++;//avança para a próxima posição
            }
        }
        
        return impares;//retorna o array preenchido com os números ímpares
    }
    
    // Método para exibir array de strings (nomes)
    public static void exibirArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {// i inicia com o valor de 0 (zero), condicional, incremento
            System.out.println((i + 1) + ". " + arr[i]);
        }
    }
    
    // Método para exibir array de números (mais compacto)
    public static void exibirArrayNumeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {// i inicia com o valor de 0 (zero), condicional, incremento
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