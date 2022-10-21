import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("us", "US"));
        Scanner sc = new Scanner(System.in);
        BigDecimal amortizacao, jurosMensal, parcelaMensal, saldoDevedorAtual, totalPrestacao = BigDecimal.ZERO, totalJuros = BigDecimal.ZERO;

        System.out.print("Qual o valor do empréstimo: ");
        BigDecimal vlEmprestimo = sc.nextBigDecimal();

        System.out.print("Qual o taxa de juros do empréstimo: ");
        BigDecimal tx = sc.nextBigDecimal();

        System.out.print("Qual o tempo para pagamento: ");
        int t = sc.nextInt();

        saldoDevedorAtual = vlEmprestimo;
        amortizacao = vlEmprestimo.divide(new BigDecimal(t), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_DOWN);

        System.out.printf("\nValor fixo da amortização: R$ %.2f, Saldo devedor total: R$ %.2f com um juros de %.2f%%\n",amortizacao,vlEmprestimo,tx);
        tx = tx.divide(new BigDecimal(100));
        for(int i = 1; i <= t; i++) {
            jurosMensal = saldoDevedorAtual.multiply(tx).setScale(2, RoundingMode.HALF_DOWN);;
            parcelaMensal = amortizacao.add(jurosMensal).setScale(2, RoundingMode.HALF_DOWN);;
            saldoDevedorAtual = saldoDevedorAtual.subtract(amortizacao).setScale(2, RoundingMode.HALF_DOWN);
            totalPrestacao = totalPrestacao.add(parcelaMensal);
            totalJuros = totalJuros.add(jurosMensal);
            System.out.printf("Parcela %d | Juros: R$ %.2f | Prestação: R$ %.2f | Saldo devedor: R$ %.2f\n", i, jurosMensal, parcelaMensal, saldoDevedorAtual);
        }
        System.out.printf("Total: Prestação: R$ %.2f, Juros R$ %.2f, Amortização R$ %.2f",totalPrestacao.setScale(2, RoundingMode.HALF_DOWN),totalJuros.setScale(2, RoundingMode.HALF_DOWN),vlEmprestimo.setScale(2, RoundingMode.HALF_DOWN));
    }
}