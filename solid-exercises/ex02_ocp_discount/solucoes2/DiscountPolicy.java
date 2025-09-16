package solucoes2;

public class DiscountPolicy {

  
    public static double applyDiscount(DiscountCalculator calculator, double valor) {
        return calculator.calc(valor);
    }
}
