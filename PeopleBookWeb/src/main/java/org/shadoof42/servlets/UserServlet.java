package org.shadoof42.servlets;

import org.shadoof42.logic.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserServlet extends HttpServlet {
    final List<User> pets = new CopyOnWriteArrayList<User>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.append(
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "     <title>People Book</title>" +
                        "</head>" +
                        "<body>" +
                        "     <form action='"+req.getContextPath()+"/' method='post'>" +
                        "         Name : <input type='text' name='login'>"+
                        "         <input type='submit' value='Submit'>"+
                        "     <form>"+
                        this.viewPets() +
                        "</body>" +
                        "</html>"
        );
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.pets.add(new User(1,req.getParameter("login"),"user@email",""));
        doGet(req, resp);
    }

    private String viewPets() {
        StringBuilder sb = new StringBuilder();
        sb.append("<p>Users</p>");
        sb.append("<table style='border : 1px solid black'>");
        for (User item : this.pets) {
            sb.append("<tr><td style='border : 1px solid black'>").append(item.getLogin()).append("</td></tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }
}
