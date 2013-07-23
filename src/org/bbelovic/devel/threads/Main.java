package org.bbelovic.devel.threads;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        FactorialCounter<BigInteger> counter = new SynchronizedFactorialCounter();
        
        List<FactorialRunner<BigInteger>> runners = factorialRunners(counter, 100);
        for (FactorialRunner<BigInteger> runner: runners) {
            new Thread(runner).start();
        }
    }
    
    private static <T> List<FactorialRunner<T>> factorialRunners(FactorialCounter<T> counter, int iterationCount) {
        final List<FactorialRunner<T>> runners = new ArrayList<FactorialRunner<T>>();
        for (int i = 0; i < 10; i++) {
            runners.add(new FactorialRunner<T>(counter, iterationCount));
        }
        return runners;
    }
}
