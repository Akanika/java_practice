package design_pattern.behavioral.adapter;

import design_pattern.behavioral.proxy.Payment;

public class Customer{

    String reviewTxt;
    String name;
    private Feedback feedback;

    public Feedback getFeedback(){
        return feedback;
    }

    public void setFeedback(Feedback feedback){
        this.feedback = feedback;
    }

    public Customer(String reviewTxt, String name){
        this.reviewTxt = reviewTxt;
        this.name = name;
    }

    public void writeAndShareReview() {
        feedback.writeAndShareReview(reviewTxt, name);
    }

    public void payForGoods(Payment p, double amount) {
        p.pay(amount);
    }
}
