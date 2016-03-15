package org.shadoof42.store;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.shadoof42.models.Message;
import org.shadoof42.models.Role;
import org.shadoof42.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Shadoof on 11.03.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
@WebAppConfiguration
public class StorageTest {

//    @Autowired
//    private UserStorage storage;
    @Autowired
    private Storages storages;

//    @Test
//    public void initStorage() {
//        assertNotNull(storage);
//    }

    @Test
    public void initStorages(){
        assertNotNull(storages);
    }

    /**
     * Создаем пользователя, присваиваем ему письма и роль, удаляем все.
     */
    @Test
    public void createAndDeleteUserWithRole(){
        Role test_role = new Role("test_admin");
        final int user_id = storages.userStorage.add(new User("Иванов Иван Иваныч", "ivanov@gmail.com", test_role));
        User user = storages.userStorage.get(user_id);
        System.out.println(user);
        List<Message> messages = new ArrayList<>();
        messages.add(new Message(user,"text"));
        messages.add(new Message(user,"new text"));
        user.setMessages(messages);
        storages.userStorage.edit(user);
        assertEquals(2,storages.userStorage.get(user_id).getMessages().size());
        storages.userStorage.delete(user_id);
        storages.roleStorage.delete(user.getRole().getId());
    }

    @Test
    public void findByAuthTest(){
        Role test_role = new Role("test_user");
        String login = "Иванов Иван Иваныч";
        String password = "111111";
        final int user_id = storages.userStorage.add(new User(login, "ivanov@gmail.com", test_role,password));
        User user = storages.userStorage.get(user_id);
        System.out.println(user);
        assertEquals(user.getId(), storages.userStorage.findByAuth(login,password).getId());
        storages.userStorage.delete(user_id);
        storages.roleStorage.delete(user.getRole().getId());
    }
}