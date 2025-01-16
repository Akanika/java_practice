package design_pattern.structural.strategy;

public class PedestrianDeliveryPerson implements Route{


    @Override
    public void getRoute(String startPoint, String endPoint) {
        System.out.println("I got narrow streets route to deliver fast.");

    }
}
