# SRP + DIP — Logger estático com I/O embutido

**Contexto:** registros de auditoria.

## Código legado (errado)
```java
import java.io.*;
import java.time.*;

class AuditLogger {
    public static void log(String msg) {
        try (var fw = new FileWriter("audit.log", true)) {
            fw.write(Instant.now() + " - " + msg + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(msg); // also writes to console
    }
}
```

## Problema
Mistura formatação, roteamento e saída; uso estático dificulta testes, viola SRP e DIP.

## Tarefa
Separar `MessageFormatter`, `LogSink` (console, arquivo, http) e `AuditLogger` instanciável via DI. Permitir múltiplos sinks.

## Critérios de aceitação
- Testes sem realizar I/O real.
- Facilidade para adicionar novo destino sem editar o logger.
