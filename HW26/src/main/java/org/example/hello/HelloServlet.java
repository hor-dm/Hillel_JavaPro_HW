package org.example.hello;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class HelloServlet extends HttpServlet {
    private String message;

    @Override
    public void init() {
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter printWriterOut = response.getWriter();
        printWriterOut.println("""
                <html>
                    <body>
                        Hello, World!
                    </body>
                </html>
                """);
    }

    @Override
    public void destroy() {
    }
}
