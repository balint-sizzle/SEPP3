package main.external;

public class MockPaymentSystem implements PaymentSystem {
    public boolean processPayment(String buyerAccountEmail,
                                  String sellerAccountEmail,
                                  double transactionAmount) {
        return true;
    }

    public boolean processRefund(String buyerAccountEmail,
                                 String sellerAccountEmail,
                                 double transactionAmount) {
        return true;
    }
}
