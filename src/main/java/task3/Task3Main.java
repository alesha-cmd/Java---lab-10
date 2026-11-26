package main.java.task3;

import main.java.task2_3.ShoeWarehouse;
import main.java.task2.Producer;
import main.java.task2.Consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task3Main {
    public static void main(String[] args){
        System.out.println("Задание 3");

        int totalOrders = 15;
        int consumersCount = 3;
        int ordersPerConsumer = 5;

        ShoeWarehouse warehouse = new ShoeWarehouse(5);
        //
         //
        ExecutorService executor = Executors.newFixedThreadPool(4);
        //

        executor.submit(new Producer(warehouse, totalOrders));

        //
        for (int i = 0; i < consumersCount; i++){
            executor.submit(new Consumer(warehouse, ordersPerConsumer));
        }

        //
        executor.shutdown();
        try{
            if (executor.awaitTermination(10, TimeUnit.SECONDS)){
                System.out.println("Все заказы успешно обработаны");
            } else {
                System.out.println("Время жидания истекло. Некоторые задачи не завершились.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}