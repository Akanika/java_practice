package design_pattern.behavioral.proxy;

public class UPIPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Payment via UPI done");
    }
}
