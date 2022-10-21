import java.util.Locale;
import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("us", "US"));
        Scanner sc = new Scanner(System.in);
        System.out.println("Quantas temperaturas serão transformadas? ");
        int quantTemperaturas = sc.nextInt();
        double[] temperaturas = new double[quantTemperaturas];
        double mediaTemp = 0.0, mediaConv = 0.0;
        String mOrigem, mDestino;

        for (int i = 0; i < temperaturas.length; i++) {
            System.out.println("\nInforme a temperatura: ");
            temperaturas[i] = sc.nextDouble();
        }

        do {
            System.out.println("\nQual a unidade de origem dessas temperaturas? [C, K, F]");
            mOrigem = sc.next();
        } while (!checaOpcao(mOrigem));

        do {
            System.out.println("\nQual a unidade de destino dessas temperaturas? [C, K, F]");
            mDestino = sc.next();
        } while (!checaOpcao(mDestino));

        if(mOrigem.equals(mDestino)) {
            System.out.println("\nNão é necessário conversão de valores.");
            return;
        }

        System.out.println();

        for (int i = 0; i < temperaturas.length; i++) {
            double temperatura = temperaturas[i];
            mediaTemp+=temperatura;
            double temperaturaConvertida = conversao(temperatura, mOrigem, mDestino);
            mediaConv+=temperaturaConvertida;
            System.out.printf("%.2f %s = %.2f %s%n", temperatura, mOrigem, temperaturaConvertida, mDestino);
        }
        mediaTemp = mediaTemp / temperaturas.length;
        mediaConv = mediaConv / temperaturas.length;
        System.out.printf("\nA média das temperaturas é %.2f %s = %.2f %s%n", mediaTemp, mOrigem, mediaConv, mDestino);
    }

    private static double conversao(double v, String medidaInicial, String medidaFinal) {
        double medidaOriginal = converteEntradaParaCelsius(v, medidaInicial);
        return converteCelsiusParaSaida(medidaOriginal, medidaFinal);
    }

    private static boolean checaOpcao (String opcao) {
        switch (opcao) {
            case "C":
            case "K":
            case "F":
                return true;
            default:
                System.out.printf("\nA opção %s não é válida, esperava uma das seguintes: C para Celsius, K para Kelvin ou F para Fahrenheit.\n", opcao);
                return false;
        }
    }

    private static double converteEntradaParaCelsius(double v, String entrada) {
        switch (entrada) {
            case "K":
                return kParaC(v);
            case "F":
                return fParaC(v);
            default:
                return v;
        }
    }

    private static double converteCelsiusParaSaida(double v, String saida) {
        switch (saida) {
            case "K":
                return cParaK(v);
            case "F":
                return cParaF(v);
            default:
                return v;
        }
    }

    private static double cParaK(double t) {
        return t + 273.15;
    }

    private static double cParaF(double t) {
        return (t * (9.0 / 5.0))+ 32;
    }

    private static double kParaC(double t) {
        return t - 273.15;
    }

    private static double kParaF(double t) {
        return (t - 273.15) * ((9.0 / 5.0) + 32);
    }

    private static double fParaC(double t) {
        return (t - 32) * (5.0 / 9.0);
    }

    private static double fParaK(double t) {
        return ((t - 32) * (5.0 / 9.0) + 273.15);
    }

}