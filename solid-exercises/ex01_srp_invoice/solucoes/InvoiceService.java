package solucoes;

public class InvoiceService {
    private final InvoiceCalculator invoiceCalculator;
    private final InvoiceNotifier invoiceNotifier;
    private final InvoiceRepository invoiceRepository;



    public InvoiceService(
        InvoiceCalculator invoiceCalculator,
        InvoiceNotifier invoiceNotifier,
        InvoiceRepository invoiceRepository
        
    ) {

        this.invoiceCalculator = invoiceCalculator;
        this.invoiceNotifier = invoiceNotifier;
        this.invoiceRepository = invoiceRepository;
    }



        public Invoice criarInvoice(String id,  String custumerEmail, java.util.List<Double> items,  double tax){
            double total = this.invoiceCalculator.calculateTotal(items, tax);
            Invoice invoice  = new  Invoice(id, custumerEmail, custumerEmail, total);

            invoiceRepository.salvar(invoice);

            invoiceNotifier.notificar(invoice);

            return invoice;
        }


}