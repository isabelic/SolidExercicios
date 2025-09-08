class DiscountCalculator {
    double calc(String type, double amount) {
        if ("BLACK_FRIDAY".equals(type)) return amount * 0.3;
        else if ("COUPON10".equals(type)) return amount * 0.1;
        else if ("VIP".equals(type)) return amount * 0.2;
        return 0;
    }
}
