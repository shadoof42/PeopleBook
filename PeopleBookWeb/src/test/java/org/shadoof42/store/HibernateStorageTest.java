package org.shadoof42.store;

import junit.framework.TestCase;
import org.junit.Test;
import org.shadoof42.models.Message;
import org.shadoof42.models.Role;
import org.shadoof42.models.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Shadoof on 09.03.2016.
 */
public class HibernateStorageTest {
    @Test
    public void testCreate() throws Exception {
        final HibernateStorage storage = new HibernateStorage();
        final int id = storage.add(new User(-1, "hibenate", null));
        final User user = storage.get(id);
        assertEquals(id, user.getId());
        assertEquals(id, storage.findByLogin("hibenate").getId());
        storage.delete(id);
        assertNull(storage.get(id));
        storage.close();
    }
    @Test
    public void createUser() throws Exception{
        final HibernateStorage storage = new HibernateStorage();
        Role role = new Role();
        role.setName("admin");
        User user = new User();
        user.setLogin("test");
        user.setEmail("test@test");
        user.setRole(role);
        final int id = storage.add(user);
        user = storage.get(id);
        Message message = new Message();
        message.setUser(user);
        message.setText("text");
        List<Message> messages = new ArrayList<>();
        messages.add(message);
        user.setMessages(messages);
        storage.edit(user);
        assertEquals(1,storage.get(id).getMessages().size());
        storage.delete(id);
        storage.close();
    }
}