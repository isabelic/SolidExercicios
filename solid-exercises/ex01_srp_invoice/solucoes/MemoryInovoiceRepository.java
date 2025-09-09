package solucoes;

import java.util.ArrayList;
import java.util.List;

public class MemoryInovoiceRepository  implements InvoiceRepository {
     
    List<Invoice> invoices = new ArrayList<>();

    @Override
    public void salvar(Invoice invoice) {
        invoices.add(invoice);
        System.out.println("[Mock] Fatura salva em memória: ID=" + invoice.getId() + ", total=" + invoice.getTotal());
    }
}
