package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n---------------Desafio SC Clouds---------------");
        System.out.println("\nDigite 1 para verificar Fibonacci -- 1");
        System.out.println("Digite 2 para verificar números primos -- 2");

        int entrada;

        while (true) {

            if (scanner.hasNextInt()) {
                entrada = scanner.nextInt();

                if (entrada == 1) {
                    executaValidacoesCalculo();
                    break;
                } else if (entrada == 2) {
                    executaCalculoNumeroPrimo();
                    break;
                } else if (entrada > 2) {
                    System.out.println("Por favor, digite 1 ou 2.");
                } else {
                    System.out.println("Por favor, digite 1 ou 2.");
                }
            }else {
                System.out.println("Por favor, digite  1 ou 2.");
                scanner.next();
            }
        }
        scanner.close();
    }
    public static void executaValidacoesCalculo(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nDigite um número para calcular o seu Fibonacci: ");

            if (scanner.hasNextInt()) {

                int numeroN = scanner.nextInt();

                if (numeroN >= 0) {

                    int resultadoLinear = calculaFibonacciLinear(numeroN);
                    int resultadoRecursivo = calculaFibonacciRecursivo(numeroN);

                    System.out.println("\nResultado do cálculo de Fibonacci linear para o número " + numeroN + " é: " + resultadoLinear);
                    System.out.println("Resultado do cálculo de Fibonacci recursivo para o número " + numeroN + " é: " + resultadoRecursivo);

                    break;
                } else {
                    System.out.println("Digite um número positivo.");
                }
            } else {
                System.out.println("Valor inválido! Digite apenas números.");
                scanner.next();
            }
        }
        scanner.close();
    }

    //Função Fibonacci linear
    public static int calculaFibonacciLinear(int numeroN) {
        if(numeroN == 0){
            return 0;
        } else if (numeroN == 1){
            return 1;
        }else {
            int numeroA = 0;
            int numeroB = 1;
            int resultado = 0;

            for(int i = 2; i <= numeroN; i++){
                resultado = numeroA + numeroB;
                numeroA = numeroB;
                numeroB = resultado;
            }
            return resultado;
        }
    }
    //Função Fibonacci recursiva
    public static int calculaFibonacciRecursivo(int numeroN) {
        if (numeroN <= 1) {
            return numeroN;
        } else {
            return calculaFibonacciRecursivo(numeroN - 1) + calculaFibonacciRecursivo(numeroN - 2);
        }
    }
}