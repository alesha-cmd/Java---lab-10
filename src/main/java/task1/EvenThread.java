package main.java.task1;

public class EvenThread extends Thread{
    @Override
    public void run(){
        for (int i = 2; i <= 10; i+= 2){
            System.out.println("Четный поток: " + i);
            try{
                Thread.sleep(100);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
