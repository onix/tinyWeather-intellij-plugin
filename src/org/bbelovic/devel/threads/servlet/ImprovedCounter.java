package org.bbelovic.devel.threads.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImprovedCounter extends HttpServlet {

    private static final long serialVersionUID = 2530348845822320067L;

    private final AtomicInteger counter = new AtomicInteger(0);
    
    @Override
    public synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.encodeIntoResponse(response, counter.incrementAndGet());
    }

    private void encodeIntoResponse(HttpServletResponse response, int counterValue) throws IOException {
        final PrintWriter out = response.getWriter();
        out.print(counterValue);
    }
}
