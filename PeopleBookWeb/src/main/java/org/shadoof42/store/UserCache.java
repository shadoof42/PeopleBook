package org.shadoof42.store;

import org.shadoof42.models.User;

import java.util.Collection;

public class UserCache implements Storage<User>{
    private static final UserCache INSTANCE = new UserCache();

    private final Storage storage = new MemoryStorage();

    public static UserCache getInstance() {
        return INSTANCE;
    }

    @Override
    public Collection<User> values() {
        return storage.values();
    }

    @Override
    public int add(final User user) {
        return this.storage.add(user);
    }

    @Override
    public void edit(final User user) {
        this.storage.edit(user);
    }

    @Override
    public void delete(final int id) {
        this.storage.delete(id);
    }

    @Override
    public User get(final int id) {
//        return this.storage.get(id);
        return null;
    }

//    @Override
    public User findByLogin(final String login) {
//        return this.storage.findByLogin(login);
        return null;
    }

//    @Override
    public int generateId() {
        return 0;
    }

//    @Override
    public void close() {
//        this.storage.close();
    }
}
