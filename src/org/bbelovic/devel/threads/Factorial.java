package org.bbelovic.devel.threads;

/**
 * This class encapsulates various algorithms for factorial computation.
 */
public class Factorial {

    private Factorial() {
        // this is an utility class
    }

    /**
     * Computes a factorial for given integer
     * @param n input value for factorial computation 
     * @return factorial value
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial for negative input is not defined.");
        }
        if (n == 0 || n == 1) {
            return 1L;
        } else {
            long pom = 1L;
            for (int i = 2; i <= n; i++) {
                pom *= i;
            }
            return pom;
        }
    }
}
