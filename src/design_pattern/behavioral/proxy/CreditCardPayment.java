package design_pattern.behavioral.proxy;

public class CreditCardPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Payment via Credit Card done");
    }
}
