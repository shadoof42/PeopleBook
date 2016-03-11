package org.shadoof42.tools;

import org.shadoof42.models.Role;
import org.shadoof42.store.Storages;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Shadoof on 10.03.2016.
 */
public class DbTool {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Storages storage = context.getBean(Storages.class);
        System.out.println(storage.roleStorage.values());
        storage.roleStorage.add(new Role("test_admin"));
    }
}
