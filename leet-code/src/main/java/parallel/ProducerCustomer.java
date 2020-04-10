package parallel;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerCustomer {
    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(100);
    Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void test() {
        Customer customer = new Customer();
        Produce produce = new Produce();
        customer.start();
        produce.start();
    }

    private class Customer extends Thread {
        @Override
        public void run() {
            Customer();
        }

        private void Customer() {
            while (true) {
                try {
                    lock.lock();
                    while (priorityQueue.size() == 0) {
                        try {
                            System.out.println("Queue is empty, wait...");
                            condition.await();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    System.out.println("从队首取走一个元素： " + priorityQueue.remove() + "  size = " + priorityQueue.size());
                    condition.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private class Produce extends Thread {
        @Override
        public void run() {
            Produce();
        }

        private void Produce() {
            while (true) {
                try {
                    lock.lock();
                    while (priorityQueue.size() == 100) {
                        try {
                            System.out.println("Queue is full, wait...");
                            condition.await();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    System.out.println("加入一个元素： " + priorityQueue.add(1) + "  size = " + priorityQueue.size());
                    condition.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
