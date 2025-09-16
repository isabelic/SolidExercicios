package solucoes2;

public class BlackFriday implements DiscountCalculator{
    public double calc( double quantidade){
         return quantidade *(1- 0.3);
    }

}
