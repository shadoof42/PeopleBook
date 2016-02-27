package org.shadoof42.store;

import org.shadoof42.logic.User;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class UserCache {
    private static final UserCache ISTANCE = new UserCache();

    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<Integer, User>();

    public static UserCache getInstance(){return ISTANCE;}

    public Collection<User> values(){return this.users.values();}

    public void add(final User user){
        this.users.put(user.getId(),user);
    }

    public void edit(final User user){this.users.replace(user.getId(),user);}

    public void delete(final int id){this.users.remove(id);}

    public User get(final int index){
        return this.users.get(index);
    }

    public User user(final int id){return this.users.get(id);}

}
