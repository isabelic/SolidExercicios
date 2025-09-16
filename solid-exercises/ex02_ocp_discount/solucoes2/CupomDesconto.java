package solucoes2;

public class CupomDesconto  implements DiscountCalculator{
    public double calc(double quantidade){
        return quantidade * (1 - 0.1);
    }
    
}
