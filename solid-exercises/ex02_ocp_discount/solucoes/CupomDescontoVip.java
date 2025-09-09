package solucoes;

public class CupomDescontoVip implements DiscountCalculator {
    public double aplicar(double quantidade){
        return quantidade * (1- 0.2);
    }
}
