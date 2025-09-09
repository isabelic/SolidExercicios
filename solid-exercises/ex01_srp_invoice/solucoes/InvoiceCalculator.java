package solucoes;

public class InvoiceCalculator {
    double calculateTotal(java.util.List<Double> items, double tax) {
        double sum = 0;
        for (Double i : items) sum += i;
        return sum * (1 + tax);
    }
}
