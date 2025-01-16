package design_pattern.behavioral.decorator;

import design_pattern.behavioral.adapter.Feedback;

public class FeedbackDecorator implements Feedback {

    protected Feedback feedback;

    public FeedbackDecorator(Feedback feedback){
        this.feedback = feedback;
    }

    @Override
    public void writeAndShareReview(String reviewTxt, String name) {
        System.out.println("I can help you to write review");
    }
}
