package solucoes2;

public class Main {
    public static void main(String[] args) {
        DiscountCalculator blackFriday = new BlackFriday();
        DiscountCalculator cupom = new CupomDesconto();
        DiscountCalculator cupomVip = new CupomDescontoVip();

        double valor = 100.0;

        System.out.println("Preço original: " + valor);
        System.out.println("BlackFriday: " + blackFriday.calc(valor));
        System.out.println("Cupom de desconto básico: " + cupom.calc(valor));
        System.out.println("Cupom de desconto VIP: " + cupomVip.calc(valor));
    }
}
