package main.java.task2_3;

import java.security.PublicKey;
import java.util.LinkedList;
import java.util.Queue;

public class ShoeWarehouse {
    public static final String[] SHOE_TYPES = {"Nike", "Adidas", "Puma", "Reebok", "New Balance"};
    private final Queue<Order> ordersQueue = new LinkedList<>();
    private final int capacity;

    public ShoeWarehouse(int capacity){
        this.capacity = capacity;
    }
    public synchronized void receiveOrder(Order order){
        while (ordersQueue.size() >= capacity){
            try{
                System.out.println("Склад заполнен. Производитель ждет...");
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        ordersQueue.add(order);
        System.out.println("Принят заказ #" + order.id() + " (" + order.shoeType() + ", " + order.quantity() + " шт.)");
        notifyAll();
    }
    public synchronized Order fulfillOrder(){
        while (ordersQueue.isEmpty()){
            try{
                System.out.println("Склад пуст. Потребитель ждет...");
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        Order order = ordersQueue.poll();
        System.out.println("Выполнен заказ #" + order.id() + " (" + order.shoeType() + ", " + order.quantity() + " шт.)");
        notifyAll();
        return order;
    }
}
