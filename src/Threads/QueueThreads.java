package Threads;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueThreads extends Thread{

    private static ConcurrentLinkedQueue<QueueObject> queue = new ConcurrentLinkedQueue<>();

    public static void add(QueueObject queueObject){
        queue.add(queueObject);
    }

    @Override
    public void run() {

        synchronized (queue){
            while(!queue.isEmpty()){

                Iterator queueIterator = queue.iterator();
                QueueObject current = (QueueObject) queueIterator.next();
                current.busyMethod();
                queue.remove(current);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
