package org.shadoof42.store;

import junit.framework.TestCase;
import org.junit.Test;
import org.shadoof42.models.Message;
import org.shadoof42.models.Role;
import org.shadoof42.models.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Shadoof on 10.03.2016.
 */
public class UserStorageTest {
    @Test
    public void CreateUser()throws Exception{
        final UserStorage storage = new UserStorage();
        Role role = new Role();
        role.setName("test_admin");
        User user = new User();
        user.setLogin("lalka");
        user.setEmail("lalka@gmail.com");
        user.setRole(role);
        final int id = storage.add(user);
        user = storage.get(id);
        List<Message> messages = new ArrayList<>();
        Message message=new Message();
        message.setText("text");
        message.setUser(user);
        messages.add(message);
        user.setMessages(messages);
        storage.edit(user);
        assertEquals(1,storage.get(id).getMessages().size());
        storage.delete(id);
        storage.close();

    }
}