package java.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;


public class ProducerConsumerTest {

    public static void main(String[] args) {
        //Creating BlockingQueue of size 10
//        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
//        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
        BlockingQueue<Message> queue = new PriorityBlockingQueue<Message>(10, new MessageComparator());
//        BlockingQueue<Message> queue = new SynchronousQueue<>();

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        //starting producer to produce messages in queue
        new Thread(producer).start();
        //starting consumer to consume messages from queue
        new Thread(consumer).start();
        System.out.println("Producer and Consumer has been started");
    }

}