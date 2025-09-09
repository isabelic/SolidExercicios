package solucoes;

public class CupomDesconto  implements DiscountCalculator{
    public double aplicar(double quantidade){
        return quantidade * (1 - 0.1);
    }
    
}
