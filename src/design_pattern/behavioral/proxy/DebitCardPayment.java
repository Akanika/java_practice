package design_pattern.behavioral.proxy;

public class DebitCardPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Payment via Debit Card done");
    }
}
