package org.bbelovic.devel.threads;

import java.util.Random;

/**
 * This class run {@link FactorialCounter} implementation in separate thread.
 */
public class FactorialRunner<T> implements Runnable {

    private static int nextID;
    private final String name;
    private final int iterationCount;
    private final FactorialCounter<T> counter;
    
    /**
     * Create new instance of {@link FactorialRunner} with a specified {@link FactorialCounter} 
     * instance and a number of iterations.
     * @param counter {@link FactorialCounter} implementation
     * @param iterationCount number of invocation for {@link FactorialCounter}'s compute method
     */
    public FactorialRunner(final FactorialCounter<T> counter, int iterationCount) {
        if (counter == null) {
            throw new NullPointerException("counter cannot be null");
        }
        if (iterationCount < 0) {
            throw new IllegalArgumentException("Iteration count cannot be negative. "+ iterationCount);
        }
        this.counter = counter;
        this.iterationCount = iterationCount;
        this.name = "FactorialRunner-"+ generateId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        final Random r = new Random();
        for (int i = 0; i < iterationCount; i++) {
            counter.compute(r.nextInt(11));
        }

        if (counter instanceof SynchronizedFactorialCounter) {
            SynchronizedFactorialCounter syncCounter = (SynchronizedFactorialCounter) counter;
            int total = syncCounter.getTotalComputations();
            int cached = syncCounter.getCachedComputations();
            String msg = "%s: total: %s, cached:";
            System.out.println(String.format(msg, name, total, cached));
        }
    }

    private synchronized int generateId() {
        return ++nextID;
    }
}
