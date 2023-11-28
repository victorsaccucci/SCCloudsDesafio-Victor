package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int OPCAO_FIBONACCI = 1;
    private static final int OPCAO_PRIMOS = 2;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n---------------Desafio SC Clouds---------------");
        System.out.println("\nDigite " + OPCAO_FIBONACCI + " para verificar Fibonacci");
        System.out.println("Digite " + OPCAO_PRIMOS + " para verificar números primos");

        int entrada;

        while (true) {
            if (scanner.hasNextInt()) {
                entrada = scanner.nextInt();
                if (entrada == OPCAO_FIBONACCI || entrada == OPCAO_PRIMOS) {
                    executaValidacoes(entrada);
                    break;
                } else {
                    System.out.println("Por favor, digite " + OPCAO_FIBONACCI + " ou " + OPCAO_PRIMOS + ".");
                }
            } else {
                System.out.println("Por favor, digite " + OPCAO_FIBONACCI + " ou " + OPCAO_PRIMOS + ".");
                scanner.next();
            }
        }
        scanner.close();
    }

    private static void executaValidacoes(int opcao) {
        if (opcao == OPCAO_FIBONACCI) {
            executaValidacoesCalculo();
        } else if (opcao == OPCAO_PRIMOS) {
            executaValidacoesPrimo();
        }
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

    //Função Fibonacci linear.
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
    //Função Fibonacci recursiva.
    public static int calculaFibonacciRecursivo(int numeroN) {
        if (numeroN <= 1) {
            return numeroN;
        } else {
            return calculaFibonacciRecursivo(numeroN - 1) + calculaFibonacciRecursivo(numeroN - 2);
        }
    }

    public static void executaValidacoesPrimo(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nDigite um número para verificar seus antecedentes primos: ");

            if (scanner.hasNextInt()) {

                int numeroN = scanner.nextInt();

                if (numeroN >= 1) {
                    List<Integer> listaPrimosLinear = encontrarPrimosLinear(numeroN);
                    List<Integer> listaPrimosRecursiva = encontrarPrimosRecursivo(numeroN);

                    System.out.println("Lista de números primos utlizando função linear que antecedem " + numeroN + " é: " + listaPrimosLinear);
                    System.out.println("Lista de números primos utlizando função recursiva que antecedem " + numeroN + " é: " + listaPrimosRecursiva);

                    break;
                } else {
                    System.out.println("Digite um número positivo ou diferente de 0.");
                }
            } else {
                System.out.println("Valor inválido! Digite apenas números.");
                scanner.next();
            }
        }
        scanner.close();
    }

    //Função linear para números primos.
        private static List<Integer> encontrarPrimosLinear(int numeroN) {
            List<Integer> listaPrimos = new ArrayList<>();
            for (int i = 2; i <= numeroN; i++) {
                if (verificaPrimo(i, 2)) {
                    listaPrimos.add(i);
                }
            }
            return listaPrimos;
    }

    //Função recursiva para números primos.
    private static List<Integer> encontrarPrimosRecursivo(int numeroN) {
        List<Integer> listaPrimos = new ArrayList<>();
        encontrarPrimosLimite(2, numeroN, listaPrimos);
        return listaPrimos;
    }
    private static void encontrarPrimosLimite(int base, int limite, List<Integer> listPrimos) {
        if (base <= limite) {
            if (verificaPrimo(base, 2)) {
                listPrimos.add(base);
            }
            encontrarPrimosLimite(base + 1, limite, listPrimos);
        }
    }

    //Função para verificar se o número é primo.
    public static boolean verificaPrimo(int numeroN, int divisor){
        if(numeroN < 2){
            return false;
        }
        if(divisor <= Math.sqrt(numeroN)){
            if(numeroN % divisor == 0){
                return false;
            }
            return verificaPrimo(numeroN, divisor + 1);
        }
        return true;
    }
}