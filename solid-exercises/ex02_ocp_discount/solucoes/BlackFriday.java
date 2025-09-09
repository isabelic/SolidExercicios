package solucoes;

public class BlackFriday implements DiscountCalculator{
    public double aplicar( double quantidade){
         return quantidade *(1- 0.3);
    }

}
