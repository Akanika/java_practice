package design_pattern.behavioral.adapter;

public class FeedbackAdapter implements Feedback {

    ThirdPartyReview thirdPartyReview = new ThirdPartyReview();

    @Override
    public void writeAndShareReview(String reviewTxt, String name) {
       thirdPartyReview.shareAndWriteReviewOnAllPlatform(reviewTxt, name);
    }
}
