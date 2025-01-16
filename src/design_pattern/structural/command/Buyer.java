package design_pattern.structural.command;

import design_pattern.structural.observer.Product;

public class Buyer implements Order{

    private Product product;

    public Buyer(Product product){
        this.product = product;
    }

    @Override
    public void execute() {
        product.buyProduct();
    }
}
