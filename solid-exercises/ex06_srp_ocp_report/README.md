# SRP + OCP — Relatórios com switch de formato

**Contexto:** geração de relatórios em PDF, CSV, XLS.

## Código legado (errado)
```java
class ReportData {
    public String title;
    public java.util.List<String> lines = new java.util.ArrayList<>();
}

class ReportService {
    byte[] generate(String format, ReportData data) {
        switch (format) {
            case "PDF":
                // legacy: render PDF inline
                return new byte[0];
            case "CSV":
                // legacy: render CSV inline
                return String.join("\n", data.lines).getBytes();
            case "XLS":
                // legacy: render XLS inline (fake)
                return new byte[0];
            default:
                throw new IllegalArgumentException("Unknown format: " + format);
        }
    }
}
```

## Problema
`ReportService` concentra regras de todos os formatos (violando SRP) e precisa ser modificado para cada formato novo (violando OCP).

## Tarefa
Separar renderizadores por formato (`ReportRenderer`) e usar Strategy/Factory para OCP. `ReportService` deve apenas orquestrar.

## Critérios de aceitação
- Adição de novo formato sem editar `ReportService`.
- Testes por formato verificando bytes/resultados.
