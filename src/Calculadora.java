import java.util.ArrayList;
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int operacao = -1;
        while (operacao != 0) {

            ArrayList<Double> numeros = new ArrayList<>();

            System.out.println("Digite os números desejados (digite 0 para parar):");
            while (true) {
                if (scanner.hasNextDouble()) {
                    double numero = scanner.nextDouble();
                    if (numero == 0)
                        break;

                    if (numero < 0) {
                        System.out.println("Número negativo não é permitido. Tente novamente.");
                        continue;
                    }

                    numeros.add(numero);

                } else {
                    System.out.println("Entrada inválida. Por favor, insira um número.");
                    scanner.next(); // Limpa a entrada inválida
                }

            }

            if (numeros.size() < 2) {
                System.out.println("Você precisa inserir pelo menos dois números para realizar operações.");
                continue; // Volta para o início do laço principal
            }
            int operacaoEscolhida = -1;

            while (true) {
                System.out.println("Escolha uma operação(digite 0 para sair):");
                System.out.println("1 - Somar");
                System.out.println("2 - Subtrair");
                System.out.println("3 - Multiplicar");
                System.out.println("4 - Dividir");

                if (scanner.hasNextInt()) {
                    operacaoEscolhida = scanner.nextInt();
                    if (operacaoEscolhida == 0 || (operacaoEscolhida >= 1 && operacaoEscolhida <= 4)) {
                        break;

                    } else {
                        System.out.println("Operação inválida. Tente novamente.");
                    }
                } else {
                    System.out.println("Entrada inválida. Por favor, insira um número entre 0 e 4.");
                    scanner.next(); // Limpa a entrada inválida
                }
            }

            operacao = operacaoEscolhida;

            switch (operacao) {
                case 1:
                    double resultado = somar(numeros);
                    System.out.println("A soma é: " + resultado);

                    break;
                case 2:
                    resultado = subtrair(numeros);
                    System.out.println("A subtração é: " + resultado);
                    break;
                case 3:
                    resultado = multiplicar(numeros);
                    System.out.println("A multiplicação é: " + resultado);
                    break;
                case 4:
                    resultado = dividir(numeros);
                    if (Double.isNaN(resultado)) {
                        // Mensagem já exibida no método dividir
                    } else {
                        System.out.println("A divisão é: " + resultado);
                    }
                    break;
                case 0:
                    System.out.println("Encerrando a calculadora.");
                    break;

            }

            if (operacao != 0) {
                System.out.println("Deseja realizar outra operação? (s/n)");
                String resposta = scanner.next();
                if (!respostaValida(resposta)) {
                    System.out.println("Resposta inválida. Encerrando a calculadora.");
                    break;
                }

                if (resposta.equalsIgnoreCase("n")) {
                    System.out.println("Encerrando a calculadora.");
                    break;
                }

            }

        }
        scanner.close();
    }

    private static double somar(ArrayList<Double> numeros) {
        double soma = 0;
        for (double num : numeros)
            soma += num;
        return soma;
    }

    private static double subtrair(ArrayList<Double> numeros) {
        double resultado = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++)
            resultado -= numeros.get(i);

        return resultado;
    }

    private static double multiplicar(ArrayList<Double> numeros) {
        double resultado = 1;
        for (double num : numeros)
            resultado *= num;
        return resultado;
    }

    private static double dividir(ArrayList<Double> numeros) {
        double resultado = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            if (numeros.get(i) == 0) {
                System.out.println("Divisão por zero não é permitida.");
                return Double.NaN; // Retorna NaN para indicar erro
            }
            resultado /= numeros.get(i);
        }
        return resultado;
    }

    private static boolean respostaValida(String resposta) {
        return resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("n");
    }

}
