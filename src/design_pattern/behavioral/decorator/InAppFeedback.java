package design_pattern.behavioral.decorator;

import design_pattern.behavioral.adapter.Feedback;

public class InAppFeedback implements Feedback {

    @Override
    public void writeAndShareReview(String reviewTxt, String name) {
        System.out.println("You review is internal to our app");
    }

    public String getReviewType(){
       return "Review was added with image and video";
    }
}
