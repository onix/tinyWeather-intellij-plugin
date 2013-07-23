package org.bbelovic.devel.threads;

/**
 * Represents a worker instance which executes given instance
 * in a separate thread.
 */
public class ThreadWorker implements Runnable {

    private final UnsafeCounter unsafeCounter;

    public ThreadWorker(UnsafeCounter unsafeCounter) {
        this.unsafeCounter = unsafeCounter;
    }

    @Override
    public void run() {
        unsafeCounter.doIt();
    }

}
