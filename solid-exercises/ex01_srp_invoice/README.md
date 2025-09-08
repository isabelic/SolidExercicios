# SRP — Faturamento “faz-tudo”

**Contexto:** serviço de faturas que calcula total, salva no banco e envia e-mail.

## Código legado (errado)
```java
class Invoice {
    private final String id;
    private final String customerEmail;
    private final double total;
    public Invoice(String id, String customerEmail, double total) {
        this.id = id; this.customerEmail = customerEmail; this.total = total;
    }
    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public double getTotal() { return total; }
}

class InvoiceService {
    double calculateTotal(java.util.List<Double> items, double tax) {
        double sum = 0;
        for (Double i : items) sum += i;
        return sum * (1 + tax);
    }
    void saveToDb(Invoice inv) {
        try (java.sql.Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/app","user","pass")) {
            var ps = conn.prepareStatement("INSERT INTO invoice(id,total) VALUES (?,?)");
            ps.setString(1, inv.getId());
            ps.setDouble(2, inv.getTotal());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); // legacy: mixes concerns and swallows exceptions
        }
    }
    void sendEmail(Invoice inv) {
        // Legacy: SMTP inline (pretend)
        System.out.println("Email sent to " + inv.getCustomerEmail());
    }
}
```

## Problema
Múltiplas razões de mudança na mesma classe (cálculo, persistência e notificação). Difícil testar e tratar falhas isoladamente.

## Tarefa
Separar em classes coesas: `InvoiceCalculator`, `InvoiceRepository`, `InvoiceNotifier`; injetar dependências via construtor em um `InvoiceService` orquestrador.

## Critérios de aceitação
- Testes unitários independentes por responsabilidade.
- `InvoiceService` não conhece JDBC nem SMTP diretamente (apenas interfaces).
- Falha de envio de e-mail não quebra o cálculo ou o save.

## Dicas
Aplique **SRP** e **DIP**. Introduza interfaces `Repository` e `Notifier`.
