import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o mês: ");
        String mes = sc.next();
        int qDias;

        switch (mes.toUpperCase()) {
            case "JANEIRO", "MARÇO", "MAIO", "JULHO", "AGOSTO", "OUTUBRO", "DEZEMBRO"  -> qDias = 31;
            case "ABRIL", "JUNHO", "SETEMBRO", "NOVEMBRO"  -> qDias = 30;
            case "FEVEREIRO" -> qDias = 28;
            default -> qDias = 0;
        }

        if(qDias == 0){
            System.out.println("\nEntrada inválida");
        } else {
            System.out.printf("\n%s tem %d dias", mes, qDias);
        }
    }
}