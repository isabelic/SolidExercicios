package solucoes;

public class Invoice {
    private final String id;
    private final String customerEmail;
    private final String name;
    private final double total;


    public Invoice(String id, String customerEmail, String name,  double total) {
        this.id = id;
         this.customerEmail = customerEmail; 
         this.name = name;
         this.total = total;
    }
    public String getId() { 
        return id;
     }
    public String getCustomerEmail() { 
        return customerEmail; 
    }
    public double getTotal() {
         return total; 
        }
        public String getName(){
            return name;
        }
}
