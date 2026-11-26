package main.java.task1;

public class Oddrunneble implements Runnable{
    @Override
    public void run(){
        for (int i = 1; i <=9; i += 2){
            System.out.println("Нечетный поток: " + i);
            try{
                Thread.sleep(100);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
