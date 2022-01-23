package com.example.documentsmanager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//URL CORRECTE http://localhost:8080/documentsManager-1.0-SNAPSHOT/doc

@WebServlet(name = "docServlet" ,value ="/doc")
public class DocManagerServlet extends HttpServlet
{
    /**
     * @see HttpServlet#doGet(HttpServletRequest rest, HttpServletResponse response) 
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        RequestDispatcher vue=request.getRequestDispatcher("WEB-INF/indexMaisMieux.jsp");
        vue.forward(request,response);
    }
}
