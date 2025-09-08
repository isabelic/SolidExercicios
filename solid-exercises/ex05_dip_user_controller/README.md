# DIP — Controller acoplado a infraestrutura

**Contexto:** API de usuários com dependências concretas embutidas.

## Código legado (errado)
```java
class User {
    private final String email;
    public User(String email) { this.email = email; }
    public String getEmail() { return email; }
}

class MySqlUserRepository {
    void save(User u) {
        // legacy: inline JDBC
        System.out.println("Saving user " + u.getEmail() + " to MySQL");
    }
}

class SmtpEmailService {
    void sendWelcome(String email) {
        // legacy: inline SMTP
        System.out.println("Sending welcome to " + email);
    }
}

class UserController {
    private final MySqlUserRepository repo = new MySqlUserRepository();
    private final SmtpEmailService email = new SmtpEmailService();

    public void register(User u) {
        repo.save(u);
        email.sendWelcome(u.getEmail());
    }
}
```

## Problema
Alto acoplamento a implementações concretas (repositório e e-mail). Dificulta testes e troca de infraestrutura.

## Tarefa
Inverter dependências: `UserController` deve depender de interfaces (`UserRepository`, `EmailService`) injetadas via construtor.

## Critérios de aceitação
- Controller testável com dublês sem acessar banco/e-mail reais.
- Implementações concretas ficam na camada de infraestrutura.
