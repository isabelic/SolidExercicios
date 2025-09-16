package solucoes2;

public class CupomDescontoVip implements DiscountCalculator {
    @Override
    public double calc(double quantidade) {
        return quantidade * (1 - 0.2);
    }
}
