package main.java.task2;
import main.java.task2_3.ShoeWarehouse;

public class Consumer implements Runnable{
    private final ShoeWarehouse warehouse;
    private final int ordersToFulfill;

    public Consumer(ShoeWarehouse warehouse, int ordersToFulfill){
        this.warehouse = warehouse;
        this.ordersToFulfill = ordersToFulfill;
    }

    @Override
    public void run(){
        for (int i = 0; i < ordersToFulfill; i++){
            warehouse.fulfillOrder();
            try{
                Thread.sleep(100);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
