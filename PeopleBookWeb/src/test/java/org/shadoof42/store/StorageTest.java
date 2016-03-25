package org.shadoof42.store;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.shadoof42.models.Message;
import org.shadoof42.models.PhoneType;
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


    @Test
    public void createPhone(){
        final int id = storages.phoneTypeStorage.add(new PhoneType("Тестовый тип"));
        PhoneType phoneType = storages.phoneTypeStorage.get(id);
        phoneType.setName("Тестовый");
        System.out.println(phoneType.getName());
        storages.phoneTypeStorage.edit(phoneType);
        storages.phoneTypeStorage.delete(id);
    }

    /**
     * Создаем пользователя, присваиваем ему письма и роль, удаляем все.
     */
    @Test
    public void createAndDeleteUserWithRole(){
        final int role_id  = storages.roleStorage.add(new Role("test_admin"));
        Role test_role = storages.roleStorage.get(role_id);
        final int user_id = storages.userStorage.add(new User("Иванов Иван Иваныч", "ivanov@gmail.com", test_role));
        User user = storages.userStorage.get(user_id);
        System.out.println(user);
        List<Message> messages = new ArrayList<>();
        messages.add(new Message(user,"text"));
        messages.add(new Message(user,"new text"));
        user.setMessages(messages);
        storages.userStorage.edit(user);
        storages.userStorage.delete(user_id);
        storages.roleStorage.delete(user.getRole().getId());
    }
//
//    @Test
//    public void findByAuthTest(){
//        Role test_role = new Role("test_user");
//        String login = "Иванов Иван Иваныч";
//        String password = "111111";
//        final int user_id = storages.userStorage.add(new User(login, "ivanov@gmail.com", test_role,password));
//        User user = storages.userStorage.get(user_id);
//        System.out.println(user);
//        assertEquals(user.getId(), storages.userStorage.findByAuth(login,password).getId());
//        storages.userStorage.delete(user_id);
//        storages.roleStorage.delete(user.getRole().getId());
//    }
//    @Test
//    public void updateRole(){
//        Role role = new Role("test_role");
//        final int role_id = storages.roleStorage.add(role);
//        role = storages.roleStorage.get(role_id);
//        System.out.println(role_id);
//        role.setName("test_role1");
//        storages.roleStorage.edit(role);
//        Role same_role=storages.roleStorage.get(role_id);
//        System.out.println(same_role + " " + same_role.getId());
//        storages.roleStorage.delete(same_role.getId());
//
//    }
//    @Test
//    public void vieRole(){
//        List<Role> role_list = (List<Role>) storages.roleStorage.values();
//        System.out.println(role_list.size());
//
//    }

}