package design_pattern.structural.command;

import design_pattern.structural.observer.Product;

public class Seller implements Order{
    private Product product;

    public Seller(Product product){
        this.product = product;
    }

    @Override
    public void execute(){
        product.sellProduct();
    }
}
