package org.shadoof42.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.println("<html><body text=blue>");
        pw.println("<h1> Servlets Demo Using Manual Configuration </h1><hr>");
        pw.println("This is first servlet....");
        pw.println("</body></html>");
        pw.close();
    }
}
