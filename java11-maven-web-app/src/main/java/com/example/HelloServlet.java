package com.example;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {
 protected void doGet(HttpServletRequest req,HttpServletResponse res)
 throws ServletException, IOException {
   res.setContentType("text/html");
   PrintWriter out = res.getWriter();
   out.println("<h1>Hello Java 11 Maven Web App!</h1>");
 }
}
