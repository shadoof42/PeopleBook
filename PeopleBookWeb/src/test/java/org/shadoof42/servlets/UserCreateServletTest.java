package org.shadoof42.servlets;

import junit.framework.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.shadoof42.store.UserCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserCreateServletTest extends Mockito {

    final UserCache cache = UserCache.getInstance();

    @Test
    public void createUser() throws ServletException, IOException {
        HttpServletRequest requset = mock(HttpServletRequest.class);
        HttpServletResponse responce = mock(HttpServletResponse.class);

        when(requset.getParameter("login")).thenReturn("test");
        when(requset.getParameter("email")).thenReturn("test");

        Assert.assertTrue(cache.values().isEmpty());

        new UserCreateServlet().doPost(requset,responce);

        verify(requset,atLeast(1)).getParameter("login");
        verify(requset,atLeast(1)).getParameter("email");
        Assert.assertFalse(cache.values().isEmpty());

        cache.delete(cache.findByLogin("test").getId());

    }

}