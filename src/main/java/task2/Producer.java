package main.java.task2;

import main.java.task2_3.Order;
import main.java.task2_3.ShoeWarehouse;
import java.util.Random;

public class Producer implements Runnable{
    private final ShoeWarehouse warehouse;
    private final int totalOrders;
    public Producer(ShoeWarehouse warehouse, int totalOrders){
        this.totalOrders = totalOrders;
        this.warehouse = warehouse;
    }

    @Override
    public void run(){
        Random random = new Random();
        for (int i = 1; i <= totalOrders; i++){
            String randomType = ShoeWarehouse.SHOE_TYPES[random.nextInt(ShoeWarehouse.SHOE_TYPES.length)];
            int qty = random.nextInt(10) + 1;
            Order order = new Order(i, randomType, qty);
            warehouse.receiveOrder(order);
            try{
                Thread.sleep(100);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
