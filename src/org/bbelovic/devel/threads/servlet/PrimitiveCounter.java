package org.bbelovic.devel.threads.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Demonstration of unsafe counter servlet as described in Java concurrency in practice.
 */
public class PrimitiveCounter extends HttpServlet {

    private static final long serialVersionUID = 3691375615588217626L;
    private int counter = 0;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ++counter;
        encodeIntoResponse(response);
    }

    private void encodeIntoResponse(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.print(counter);
    }
}
