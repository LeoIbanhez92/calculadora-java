import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int operacao = -1;
        while (operacao != 0) {

            ArrayList<Double> numeros = new ArrayList<>();

            System.out.println("Digite os números desejados (digite 0 para parar):");
            while (true) {
                double num = scanner.nextDouble();
                if (num == 0)
                    break;

                if (num < 0) {
                    System.out.println("Número negativo não é permitido. Tente novamente.");
                    continue;
                }
                numeros.add(num);
            }

            if (numeros.size() < 2) {
                System.out.println("Você precisa inserir pelo menos dois números para realizar operações.");
                scanner.close();
                return;
            }

            System.out.println("Escolha uma operação:");
            System.out.println("1 - Somar");
            System.out.println("2 - Subtrair");
            System.out.println("3 - Multiplicar");
            System.out.println("4 - Dividir");

            operacao = scanner.nextInt();

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
                    System.out.println("A divisão é: " + resultado);
                    break;
                case 0:
                    System.out.println("Encerrando a calculadora.");
                    break;

                default:
                    System.out.println("Operação inválida. Tente novamente.");
                    break;
            }

            if (operacao != 0) {
                System.out.println("Deseja realizar outra operação? (s/n)");
                String resposta = scanner.next();
                if (!respostaValida(resposta)) {
                    System.out.println("Resposta inválida. Encerrando a calculadora.");
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
                return 0; // Retorna NaN para indicar erro
            }
            resultado /= numeros.get(i);
        }
        return resultado;
    }

    private static boolean respostaValida(String resposta) {
        return resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("n");
    }

}
