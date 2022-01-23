package com.example.documentsmanager;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
//URL CORRECTE http://localhost:8080/documentsManager-1.0-SNAPSHOT/hello-servlet
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        DbManager d= new DbManager();
        try
        {
            Connection c=d.getConnection();

        }
        catch (SQLException e)
        {
            out.println(e.getMessage());
        }
    }

    public void destroy() {
    }
}