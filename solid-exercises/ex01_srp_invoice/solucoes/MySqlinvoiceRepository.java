package solucoes;

public class MySqlinvoiceRepository implements InvoiceRepository {

    @Override
    public void salvar(Invoice invoice) {
        try (java.sql.Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/app","user","pass")) {
            var ps = conn.prepareStatement("INSERT INTO invoice(id,total) VALUES (?,?)");
            ps.setString(1, invoice.getId());
            ps.setDouble(2, invoice.getTotal());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Failed to persist invoice " + invoice.getId(), e);
        }
    }
}