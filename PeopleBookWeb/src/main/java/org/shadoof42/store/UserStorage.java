package org.shadoof42.store;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.shadoof42.models.User;

import java.util.Collection;
import java.util.List;

/**
 * Created by Shadoof on 10.03.2016.
 */
public class UserStorage implements Storage {
    private final SessionFactory factory;

    public UserStorage() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }

    public interface Command<T>{
        T process (Session session);
    }

    private <T> T transaction(final Command<T> command){
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            return command.process(session);
        }finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public Collection<User> values() {
        return transaction((Session session)->session.createQuery("from User ").list());
    }

    @Override
    public int add(User user) {
        return transaction((Session session)->{
            session.save(user);
            return user.getId();
        });
    }

    @Override
    public void edit(User user) {
        transaction((Session session) -> {
            session.update(user);
            return null;
        });
    }

    @Override
    public void delete(int id) {
        transaction((Session session) -> {
            session.delete(get(id));
            return null;
        });
    }

    @Override
    public User get(int id) {
        return transaction((Session session)-> (User) session.get(User.class,id));
    }

    @Override
    public User findByLogin(String login) {
        return transaction((Session session)-> {
            final Query query = session.createQuery("from User as user where user.login=:login");
            query.setString("login",login);
            return (User) query.iterate().next();
        });
    }


    public List<User> findByRoleName(final String roleName){
        return transaction((Session session)->{
            final Query query = session.createQuery("from User as user inner join Role as role on user.role where role.name=:name");
            query.setString("name",roleName);
            return query.list();
        });
    }

    public List<User> searchByLogin(final String login){
        return transaction((Session session)->{
            final Query query = session.createQuery("from User as user where lower(user.login) like %:login% ");
            query.setString("login",login);
            return query.list();
        });
    }

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void close() {

    }
}
