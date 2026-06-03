package com.example;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class HelloServlet extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse res)
 throws ServletException, IOException {
   res.setContentType("text/html");
   PrintWriter out = res.getWriter();
   out.println("<h1>Hello Java 17 Maven Web App!</h1>");
 }
}
