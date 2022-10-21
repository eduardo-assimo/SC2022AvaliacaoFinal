import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual a quantidade de termos que deseja exibir da sequência de Fibonacci: ");
        int qTermos = sc.nextInt();
        System.out.println();

        if(qTermos <= 0) {
            System.out.println("Apenas são aceitos números positivos.");
        } else if (qTermos > 45) {
            System.out.println("Não é possível informar mais de 45 termos.");
        } else {
            System.out.print(" 1 1 ");
            int termoN = 1, termoN1 = 1, termoAtual, x;
            for (int i = 1; i <= qTermos-2; i++) {
                termoAtual = termoN + termoN1;
                x = termoN;
                termoN = termoAtual;
                termoN1 = x;
                System.out.print(termoAtual + " ");
            }
        }
    }
}