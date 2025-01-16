package design_pattern.behavioral.decorator;


import design_pattern.behavioral.adapter.Feedback;

public class FeedbackWithVideos extends FeedbackDecorator {

    public FeedbackWithVideos(Feedback feedback) {
        super(feedback);
    }

    @Override
    public void writeAndShareReview(String reviewTxt, String name) {
        System.out.println("I can help you record and give you Base64 code for your video");
    }

    public String getReviewType(){
        return "Review was added with video";
    }
}
