package main.java.task1;

public class Task1Main {
    public static void main(String[] args){
        System.out.println("Задание 1: ПОТОКИ");
        Thread evenThread = new EvenThread();
        Thread oddThread = new Thread(new Oddrunneble());

        evenThread.start();
        oddThread.start();
    }
}
