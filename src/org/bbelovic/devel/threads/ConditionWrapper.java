package org.bbelovic.devel.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionWrapper implements Runnable {

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private final int x = 10;

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println("Before await..");
            condition.await();
            System.out.println("After await..");
        } catch (final InterruptedException ie) {
            System.out.println("Caught interrupted exception..");
            ie.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void signal() {
        lock.lock();
        try {
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public int getX() {
        return this.x;
    }
}
