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
