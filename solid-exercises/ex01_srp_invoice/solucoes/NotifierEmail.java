package solucoes;

public class NotifierEmail implements InvoiceNotifier {

    @Override
    public void notificar(Invoice invoice) {
        System.out.println("Email sent to: " + invoice.getCustomerEmail() + ", invoice=" + invoice.getId() + ", total="
                + invoice.getTotal());
    }
    
}
