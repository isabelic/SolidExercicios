# ISP + DIP — Serviço de busca com interface inchada

**Contexto:** módulo de busca e autocompletar.

## Código legado (errado)
```java
import java.util.*;

interface SearchEngine {
    List<String> index(String path);
    List<String> query(String q);
    void warmupCache();
    void rebuildAll();
}

class AutocompleteService {
    private final SearchEngine engine;
    AutocompleteService(SearchEngine engine){ this.engine = engine; }
    List<String> suggest(String prefix) {
        engine.warmupCache(); // legacy: side-effect not needed here
        return engine.query(prefix + "*");
    }
}
```

## Problema
Interface genérica demais força clientes a conhecer operações que não precisam; há uso indevido de métodos de manutenção no caminho de leitura.

## Tarefa
Segregar em interfaces focadas (`QueryEngine`, `Indexer`, `MaintenanceOps`). `AutocompleteService` deve depender apenas de `QueryEngine` via DIP.

## Critérios de aceitação
- Superfície de API menor e coesa.
- Testes de sugestão sem simular warmup/rebuild.
