package design_pattern.structural.strategy;

public class BikerDeliveryPerson implements Route{

    @Override
    public void getRoute(String startPoint, String endPoint) {
        System.out.println("Yayy I got nice wide route for my route ");
    }
}
