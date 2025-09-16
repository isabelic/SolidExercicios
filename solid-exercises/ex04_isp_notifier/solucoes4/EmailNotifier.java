package solucoes4;

public class EmailNotifier implements EmailSender {
    public void sendEmail(String to, String subject, String body) {
        System.out.println("Sending Email to " + to + ": " + subject);
    }
}
