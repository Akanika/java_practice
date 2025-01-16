package design_pattern.behavioral.adapter;

public interface Feedback {

    void writeAndShareReview(String reviewTxt, String name);

    default String getReviewType(){
       return "get review type";
    }
}
