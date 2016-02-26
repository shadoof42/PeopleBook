package org.shadoof42.logic;

import org.junit.Test;

public class UserTest {
    @Test
    public void testIsActive() throws Exception {
        User user1 = new User(id, "Павловский","111111");
        User user2 = new User(id, "Жуковский","");
        System.out.println(user1 + " " + user2);
        System.out.println(user1.isActive());
        System.out.println(user2.isActive());
    }
}