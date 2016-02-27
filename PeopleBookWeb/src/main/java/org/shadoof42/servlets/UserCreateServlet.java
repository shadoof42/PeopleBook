package org.shadoof42.servlets;

import org.shadoof42.logic.User;
import org.shadoof42.store.UserCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class UserCreateServlet extends HttpServlet {
    final AtomicInteger ids = new AtomicInteger();

    private final UserCache USER_CASHE = UserCache.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.USER_CASHE.add(new User(this.ids.incrementAndGet(),req.getParameter("login"), req.getParameter("email"),""));
        resp.sendRedirect(String.format("%s%s",req.getContextPath(),"/user/view"));
    }
}
