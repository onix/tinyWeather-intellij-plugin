package org.bbelovic.devel.threads.clients;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable {

    private static final Object lock = new Object();
    private static final String URI_PATH = "/counter-example/synchronizedcounter";
    private static int instanceCounter = 0;
    private final String url;
    private final String name;
    private final int iterations;
    
    
    public Client(String url, int iterations) {
        this.url = url;
        this.iterations = iterations;
        this.name = "Client-"+ nextID();
    }

    @Override
    public void run() {
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            
            for (int i = 0; i < iterations; i++) {
                socket = new Socket(url, 8080);
                synchronized (lock) {
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    out = new PrintWriter(socket.getOutputStream(), true);
                    out.print("GET "+ URI_PATH +" \r\n");
                    out.print("\r\n");
                    out.flush();
                
                    System.out.println(name + ": " +in.readLine());
                }
                close(out);
                close(in);
            }
            
        } catch (final IOException ioe) {
            System.out.println("Error in socket communication: " + ioe.getMessage());
        } 
    }
    
    private void close(Closeable c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (final IOException ioe) {
            System.out.println("Error when closing streams: "+ ioe.getMessage());
        }
    }
    
    private static synchronized int nextID() {
        return instanceCounter++;
    }
}
