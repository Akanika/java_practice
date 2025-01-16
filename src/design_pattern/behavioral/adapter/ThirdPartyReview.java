package design_pattern.behavioral.adapter;

public class ThirdPartyReview {

    void shareAndWriteReviewOnAllPlatform(String review, String name){
        System.out.println( "The user "  +  name + " has added " + review + " and shared on all social platforms");
    }

    void shareAndWriteReviewOnFacebook(String review){
        System.out.println("Review added for app and shared on facebook");
    }

    void shareAndWriteReviewOnWhatsapp(String review){
        System.out.println("Review added for app and shared on whatsapp");
    }

    void shareAndWriteReviewOnTwitter(String review){
        System.out.println("Review added for app and shared on twitter");
    }

}
