package design_pattern.structural.observer;

import java.util.ArrayList;
import java.util.List;

public class Product {

    int productId;
    String productName;
    String productCompany;
    List<Customer> arrCustomer = new ArrayList<>();

    public Product(){

    }

    public Product(String productName, int productId, String productCompany) {
        this.productName = productName;
        this.productId = productId;
        this.productCompany = productCompany;
    }

    public void subscribe(Customer customer){
        arrCustomer.add(customer);
    }

    public void unSubscribe(Customer customer){
       arrCustomer.remove(customer);
    }

    public void notifyCustomers(){
        for(Customer cust : arrCustomer){
            cust.update();
        }
    }

    public void addProduct(Product product){
        this.productId = product.productId;
        this.productName = product.productName;
        this.productCompany = product.productCompany;
        notifyCustomers();
    }

    public void buyProduct(){
        System.out.println("I want to buy" + productName);
    }

    public void sellProduct(){
        System.out.println("I want to sell" + productName);
    }
}
