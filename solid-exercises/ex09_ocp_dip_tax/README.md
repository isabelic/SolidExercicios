# OCP + DIP — Impostos por país via switch

**Contexto:** cálculo de impostos em vários países.

## Código legado (errado)
```java
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
```

## Problema
A cada país novo, é preciso editar o `switch`. Regras ficam espalhadas e acopladas.

## Tarefa
Criar `TaxPolicy` por país e registrar via DI/Strategy. `TaxCalculator` delega a política resolvida por `countryCode`.

## Critérios de aceitação
- Adição de país sem editar `TaxCalculator`.
- Testes por política e integração para o resolvedor.
