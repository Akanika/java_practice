package design_pattern.structural;

import design_pattern.structural.command.Buyer;
import design_pattern.structural.command.OrderExecutor;
import design_pattern.structural.command.Seller;
import design_pattern.structural.observer.Customer;
import design_pattern.structural.observer.Product;
import design_pattern.structural.strategy.BikerDeliveryPerson;
import design_pattern.structural.strategy.PedestrianDeliveryPerson;
import design_pattern.structural.strategy.Route;

public class StructuralMain {

    public static void main(String[] args) {

        Product product = new Product();

        Customer customer = new Customer("Aryan");
        Customer customer1 = new Customer("Arya");
        Customer customer2 = new Customer("Aryana");
        Customer customer3 = new Customer("Aryu");
        Customer customer4 = new Customer("Aru");

        product.subscribe(customer);
        product.subscribe(customer1);
        product.subscribe(customer2);
        product.subscribe(customer3);
        product.subscribe(customer4);

        customer.setAndSubscribeProduct(product);
        customer1.setAndSubscribeProduct(product);
        customer2.setAndSubscribeProduct(product);
        customer3.setAndSubscribeProduct(product);
        customer4.setAndSubscribeProduct(product);

        product.addProduct(new Product("Shoes",1,"Nike"));


        Route route = new BikerDeliveryPerson();
        route.getRoute("Delhi", "Ghaziabad");

        Route route1 = new PedestrianDeliveryPerson();
        route1.getRoute("Delhi street-5", "Delhi street-10");

        Product product1 = new Product("Shoes",2,"Puma");
        Buyer buyer = new Buyer(product1);
        Seller seller = new Seller(product1);

        OrderExecutor orderExecutor = new OrderExecutor();
        orderExecutor.placeOrder(buyer);
        orderExecutor.placeOrder(seller);

        orderExecutor.executeOrders();
    }
}
