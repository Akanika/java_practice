package design_pattern.behavioral.adapter;

public class DeliveryPerson{

    String reviewTxt;
    String name;
    private Feedback feedback;

    public Feedback getFeedback(){
        return feedback;
    }

    public void setFeedback(Feedback feedback){
        this.feedback = feedback;
    }

    public DeliveryPerson(String reviewTxt, String name){
        this.reviewTxt = reviewTxt;
        this.name = name;
    }

    public void writeAndShareReview() {
        feedback.writeAndShareReview(reviewTxt, name);
    }
}
