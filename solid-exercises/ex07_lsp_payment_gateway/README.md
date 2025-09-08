# LSP — Processador de pagamentos que altera pós-condições

**Contexto:** gateways de pagamento com resultados padronizados.

## Código legado (errado)
```java
class PaymentResult {
    boolean success;
    String authCode;
}

class PaymentGateway {
    PaymentResult charge(double amount) {
        PaymentResult r = new PaymentResult();
        r.success = true;
        r.authCode = "AUTH-" + System.currentTimeMillis();
        return r;
    }
}

class FreeTrialGateway extends PaymentGateway {
    @Override
    PaymentResult charge(double amount) {
        PaymentResult r = new PaymentResult();
        r.success = true;
        r.authCode = null; // breaks postcondition: success implies authCode present
        return r;
    }
}
```

## Problema
Subclasse quebra a pós-condição implícita “sucesso implica `authCode` presente”, violando LSP.

## Tarefa
Explicitar contrato em interface e separar o caso "grátis" como outro fluxo/serviço. Evitar herança quando invariantes divergem.

## Critérios de aceitação
- Clientes não precisam de `instanceof` para lidar com gateways.
- Pós-condições preservadas em substituições.
