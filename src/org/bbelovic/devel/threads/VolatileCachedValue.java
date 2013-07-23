package org.bbelovic.devel.threads;

/**
 * This class holds last product and last input value passed to factorial method
 * in {@link Factorial} class. This class is designed to be immutable and therefore
 * thread-safe.
 */
public class VolatileCachedValue {

    private final long lastResult;
    private final int lastInputValue;

    /**
     * Creates new instance of {@link VolatileCachedValue} with zero values.
     */
    public VolatileCachedValue() {
        this (0,0);
    }

    /**
     * Creates new instance of {@link VolatileCachedValue} with specified values.
     * @param lastResult last result obtained from {@link Factorial}'s factorial method.
     * @param lastInputValue last input value passed to {@link Factorial}'s factorial method.
     */
    public VolatileCachedValue(long lastResult, int lastInputValue) {
        this.lastResult = lastResult;
        this.lastInputValue = lastInputValue;
    }

    /**
     * Getter for last factorial value.
     * @return last value returned from {@link Factorial}'s factorial method
     */
    public long getLastResult() {
        return this.lastResult;
    }

    /**
     * Getter for last input value passed to {@link Factorial}'s factorial method
     * @return last value passed to {@link Factorial}'s factorial method
     */
    public int getLastInputValue() {
        return this.lastInputValue;
    }
}
