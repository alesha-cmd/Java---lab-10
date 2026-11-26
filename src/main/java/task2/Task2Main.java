package main.java.task2;
import main.java.task2_3.ShoeWarehouse;

public class Task2Main {
    public static void main(String[] args){
        System.out.println("Задание 2: Свои потоки");

        int totalOrders = 15;
        int consumersCount = 3;
        int ordersPerConsumer = 5;

        ShoeWarehouse warehouse = new ShoeWarehouse(5);

        Thread producerThread = new Thread(new Producer(warehouse, totalOrders), "Producer");
        producerThread.start();

        Thread[] consumerThreads = new Thread[consumersCount];
        for (int i = 0; i < consumersCount; i++){
            consumerThreads[i] = new Thread(new Consumer(warehouse, ordersPerConsumer), "Consumer-" + (i + 1));
            consumerThreads[i].start();
        }

        try{
            producerThread.join();
            for (Thread c : consumerThreads){
                c.join();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Все заказы обработаны");
    }
}
