# OCP — Descontos por tipo via if-else

**Contexto:** e-commerce com diferentes políticas de desconto.

## Código legado (errado)
```java
class DiscountCalculator {
    double calc(String type, double amount) {
        if ("BLACK_FRIDAY".equals(type)) return amount * 0.3;
        else if ("COUPON10".equals(type)) return amount * 0.1;
        else if ("VIP".equals(type)) return amount * 0.2;
        return 0;
    }
}
```

## Problema
Cada novo desconto exige modificar a classe e mexer no `if-else` central, violando o OCP.

## Tarefa
Aplicar **Strategy**: criar `DiscountPolicy` e políticas concretas registradas via composição/factory. O `DiscountCalculator` delega para a política correta.

## Critérios de aceitação
- Adição de novos descontos sem alterar `DiscountCalculator`.
- Testes de unidade para cada política.
