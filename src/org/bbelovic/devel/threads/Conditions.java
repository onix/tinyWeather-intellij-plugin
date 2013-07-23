package org.bbelovic.devel.threads;


public class Conditions {

    public static void main(String[] args) {
        final ConditionWrapper cw = new ConditionWrapper();
        final Thread t = new Thread(cw);
        t.start();
        for (int i = 0; i < 5; i++) {
            try {
                final long sleepTime = (long)(Math.random() * 1000);
                System.out.println((i+1) + ". Sleeping for: " + sleepTime + " ms");
                Thread.sleep(sleepTime);
                System.out.println("x=" + cw.getX());
            } catch (final InterruptedException ie) {
                System.out.println("Interrupted from sleep.");
                ie.printStackTrace();
            }
        }
        cw.signal();
    }
}

