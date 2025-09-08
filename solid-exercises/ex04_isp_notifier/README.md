# ISP — Interface de notificações gorda

**Contexto:** serviço que envia e-mail, SMS e push.

## Código legado (errado)
```java
interface Notifier {
    void sendEmail(String to, String subject, String body);
    void sendSms(String phone, String text);
    void sendPush(String deviceToken, String msg);
}

class SmsOnlyNotifier implements Notifier {
    public void sendEmail(String to, String subject, String body) {
        throw new UnsupportedOperationException("SMS only");
    }
    public void sendSms(String phone, String text) {
        System.out.println("Sending SMS to " + phone + ": " + text);
    }
    public void sendPush(String deviceToken, String msg) {
        throw new UnsupportedOperationException("SMS only");
    }
}
```

## Problema
Implementações são forçadas a métodos que não fazem sentido, levando a `UnsupportedOperationException` por design (violação de ISP).

## Tarefa
Segregar a interface em `EmailSender`, `SmsSender`, `PushSender`. Criar orquestradores que dependem apenas do que usam.

## Critérios de aceitação
- Sem `UnsupportedOperationException` por design.
- Dependências mais finas, melhor testabilidade.
