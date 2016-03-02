package org.shadoof42.servlets;

import org.codehaus.jackson.map.ObjectMapper;
import org.shadoof42.form.UserForm;
import org.shadoof42.logic.User;
import org.shadoof42.store.UserCache;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserCreateJsonServlet extends HttpServlet {
    private final UserCache USER_CACHE = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "application/json; charset=utf-8");
        final ServletOutputStream out = resp.getOutputStream();
        out.print(new ObjectMapper().writeValueAsString(USER_CACHE.values()));
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setCharacterEncoding("UTF-8");
//        req.setCharacterEncoding("UTF-8");
        resp.addHeader("Content-Type", "application/json; charset=utf-8");
//        System.out.println("Содержимое: " + req.);
        final UserForm form = new ObjectMapper().readValue(req.getInputStream(), UserForm.class);
//        System.out.println("Содержимое: " + form.getLogin());
        USER_CACHE.add(new User(USER_CACHE.generateId(), form.getLogin(), "",""));
        resp.getOutputStream().write("{'result' : 'true'}".getBytes());
        System.out.println("Содержимое: " + form.getLogin());
    }
}
