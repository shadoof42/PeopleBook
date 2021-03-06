package org.shadoof42.servlets;

import org.shadoof42.store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserViewServlet extends HttpServlet {
    private final UserCache USER_CACHE = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "application/json; charset=utf-8");
        req.setAttribute("users", this.USER_CACHE.values());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/ViewUser.jsp");
        dispatcher.forward(req, resp);
    }

}
