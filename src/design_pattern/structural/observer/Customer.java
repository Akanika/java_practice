package design_pattern.structural.observer;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    String name;
    private List<Product> arrProduct = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }


    public void setAndSubscribeProduct(Product product){
       arrProduct.add(product);
    }

    public void update(){
        for(Product product : arrProduct) {
            System.out.println("Hey " + name + " New Product added" + " : " + product.productName);
        }
    }
}
