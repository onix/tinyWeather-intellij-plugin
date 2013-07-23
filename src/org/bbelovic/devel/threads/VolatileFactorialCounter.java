package org.bbelovic.devel.threads;

import static org.bbelovic.devel.threads.Factorial.factorial;

import java.math.BigInteger;

/**
 * Implementation of {@link FactorialCounter} which builts it thread safety around
 * volatile keyword.
 */
public class VolatileFactorialCounter implements FactorialCounter<BigInteger> {

    /** cache which holds previously computed factorial value for given input */
    private volatile VolatileCachedValue cachedValue;

    /**
     * {@inheritDoc}
     */
    public BigInteger compute(int inputValue) {
        if (inputValue == cachedValue.getLastInputValue()) {
            return BigInteger.valueOf(cachedValue.getLastResult());
        }
        long newValue = factorial(inputValue);
        this.cachedValue = new VolatileCachedValue(newValue, inputValue);
        return BigInteger.valueOf(newValue);
    }

}
