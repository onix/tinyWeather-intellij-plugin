package org.bbelovic.devel.threads;

/**
 * Interface for creating various implementations of factorial computer.
 *
 * @param <T> type of value returned from compute method e.g. Integer of BigInteger.
 */
public interface FactorialCounter<T> {

    /**
     * Method computes factorial value for given integer.
     * @param inputValue input integer for factorial computation
     * @return factorial for given integer.
     */
    public T compute(int inputValue);
}
