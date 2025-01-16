package design_pattern.structural.command;

import java.util.ArrayList;
import java.util.List;

public class OrderExecutor {

    private List<Order> orderList = new ArrayList<>();

    public void placeOrder(Order order){
        orderList.add(order);
    }

    public void executeOrders(){
        for(Order order : orderList){
            order.execute();
        }
        orderList.clear();
    }
}
