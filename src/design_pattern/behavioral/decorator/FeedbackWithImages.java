package design_pattern.behavioral.decorator;

import design_pattern.behavioral.adapter.Feedback;

public class FeedbackWithImages extends FeedbackDecorator {

    public FeedbackWithImages(Feedback feedback) {
        super(feedback);
    }

    @Override
    public void writeAndShareReview(String reviewTxt, String name) {
        System.out.println("I can help you click and give you Base64 code for your image");
    }

    public String getReviewType(){
        return "Review was added with image";
    }
}
