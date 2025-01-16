package design_pattern.behavioral;

import design_pattern.behavioral.adapter.Customer;
import design_pattern.behavioral.adapter.DeliveryPerson;
import design_pattern.behavioral.adapter.Feedback;
import design_pattern.behavioral.adapter.FeedbackAdapter;
import design_pattern.behavioral.decorator.FeedbackWithImages;
import design_pattern.behavioral.decorator.FeedbackWithVideos;
import design_pattern.behavioral.decorator.InAppFeedback;
import design_pattern.behavioral.proxy.CreditCardPayment;
import design_pattern.behavioral.proxy.Payment;

public class BehavioralMain {

    public static void main(String[] args) {

        Feedback feedback = new FeedbackAdapter();

       Customer customer = new Customer("App is not satisfactory", "Rahi");
       customer.setFeedback(feedback);
       DeliveryPerson deliveryPerson = new DeliveryPerson("App is satisfactory", "Ishu");
       deliveryPerson.setFeedback(feedback);

       customer.writeAndShareReview();
       deliveryPerson.writeAndShareReview();

       Feedback feedback1 = new InAppFeedback();
       System.out.println(feedback1.getReviewType());

       feedback1 = new FeedbackWithImages(feedback1);
       System.out.println(feedback1.getReviewType());

        feedback1 = new FeedbackWithVideos(feedback1);
        System.out.println(feedback1.getReviewType());

        Payment payment = new CreditCardPayment();
        customer.payForGoods(payment,1000);

    }
}
