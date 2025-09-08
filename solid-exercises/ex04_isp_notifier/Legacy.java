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
