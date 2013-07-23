package org.bbelovic.devel.threads;

import static org.bbelovic.devel.threads.Factorial.factorial;

import java.math.BigInteger;

/**
 * Implementation of {@link FactorialCounter} which builds its thread safety around Java monitor pattern.
 */
public class SynchronizedFactorialCounter implements FactorialCounter<BigInteger> {

    /** input value from previous computation */
    private int lastInputValue;
    /** previous factorial value */
    private BigInteger lastValue;

    /** total number factorial computations */
    private int totalComputations = 0;
    /** number of cached computations */
    private int cachedComputations = 0;
    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized BigInteger compute(final int inputValue) {
        totalComputations++;
            if (lastInputValue == inputValue) {
                System.out.println("lastInputValue = "+ lastInputValue + ", inputValue = "+ inputValue);
                cachedComputations++;
                return lastValue;
            } else {
                final long newValue = factorial(inputValue);
                lastInputValue = inputValue;
                lastValue = BigInteger.valueOf(newValue);
                return lastValue;
            }
    }

    public synchronized int getTotalComputations() {
        return totalComputations;
    }

    public  synchronized int getCachedComputations() {
        return cachedComputations;
    }
    
}
