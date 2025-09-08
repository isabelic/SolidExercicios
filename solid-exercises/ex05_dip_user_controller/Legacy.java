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
