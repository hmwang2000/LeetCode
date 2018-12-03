package java.concurrent;

import java.util.concurrent.Semaphore;;

public class SemaphoreTest {
    public static void main(String[] args) {
        int N = 8;            //Thread number
        Semaphore semaphore = new Semaphore(5); //Resource number
        for(int i=0;i<N;i++)
            new Worker(i,semaphore).start();
    }
 
    static class Worker extends Thread{
        private int num;
        private Semaphore semaphore;
        public Worker(int num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }
 
        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("Thread-"+this.num+" using one resource");
                Thread.sleep(2000);
                System.out.println("Tread-"+this.num+" releases one resource");
                semaphore.release();           
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}