package org.shadoof42.store;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.shadoof42.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

/**
 * Created by Shadoof on 10.03.2016.
 */
@Repository
public class UserStorage implements Storage<User> {

//    private final HibernateTemplate template;
//
//    @Autowired
//    public UserStorage(final HibernateTemplate template) {
//        this.template = template;
//    }
//
//
//
//    /**
//     * Получить все кортежи
//     *
//     * @return список кортежей
//     */
//    @Override
//    public Collection<User> values() {
//        return (Collection<User>) this.template.find("from User");
//    }
//
//    /**
//     * Добавить запись
//     *
//     * @param user запись
//     * @return ее id
//     */
//    @Transactional
//    @Override
//    public int add(final User user) {
//        return (int)this.template.save(user);
//    }
//
//    /**
//     * Редактировать запись
//     *
//     * @param user запись
//     */
//    @Transactional
//    @Override
//    public void edit(final User user) {
//        this.template.update(user);
//    }
//
//    /**
//     * Удалить запись по id
//     *
//     * @param id идентификатор
//     */
//    @Transactional
//    @Override
//    public void delete(final int id) {
//        this.template.delete(get(id));
//    }
//
//    /**
//     * Получить запись по ее id
//     *
//     * @param id идентификатор
//     * @return запись-кортеж
//     */
//    @Override
//    public User get(final int id) {
//        return this.template.get(User.class,id);
//    }
//
//    /**
//     * Найти пользователя по данным аутентификации
//     * @param login логин
//     * @param password пароль
//     * @return пользователь
//     */
//    public User findByAuth(final String login,final String password){
//        return (User) this.template.find("from User where login = ? and password = ?", new Object[]{login,password}).get(0);
//    }
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
        return transaction(session -> session.createQuery("from User as user order by user.id").list());
    }

    @Override
    public int add(final User user) {
        return transaction(session -> {
            session.save(user);
            return user.getId();
        });
    }

    @Override
    public void edit(final User user) {
        transaction(session -> {
            session.update(user);
            return null;
        });
    }

    @Override
    public void delete(final int id) {
        transaction(session -> {
            session.delete(UserStorage.this.get(id));
            return null;
        });
    }

    @Override
    public User get(final int id) {
        return transaction(session -> (User) session.get(User.class, id));
    }

//    @Override
    public User findByLogin(final String login) {
        return transaction(session -> {
            final Query query = session.createQuery("from User as user where user.login=:login");
            query.setString("login", login);
            return (User) query.iterate().next();
        });
    }

    public User findByAuth(final String login, final String password){
        return transaction(session -> {
            final Query query = session.createQuery("from User as user where user.login=:login and user.password=:password");
            query.setString("login", login);
            query.setString("password", password);
            List<User> users = query.list();
            return users.isEmpty() ? null: users.iterator().next();
        });
    }
    public List<User> findByRoleName(final String roleName){
        return transaction(session -> {
            final Query query = session.createQuery("from User as user inner join Role as role on user.role where role.name=:name");
            query.setString("name", roleName);
            return query.list();
        });
    }

    public List<User> searchByLogin(final String login){
        return transaction(session -> {
            final Query query = session.createQuery("from User as user where lower(user.login) like %:login% ");
            query.setString("login", login);
            return query.list();
        });
    }

}
