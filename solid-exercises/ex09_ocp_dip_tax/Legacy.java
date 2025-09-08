class TaxCalculator {
    double calculate(String countryCode, double base) {
        switch (countryCode) {
            case "BR": return base * 0.18 + base * 0.09; // ICMS+PIS/COFINS (exemplo simplificado)
            case "US": return base * 0.07; // sales tax (exemplo)
            case "DE": return base * 0.19; // VAT (exemplo)
            default: return 0;
        }
    }
}
