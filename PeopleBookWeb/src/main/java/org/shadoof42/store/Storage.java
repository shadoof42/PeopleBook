package org.shadoof42.store;

import org.shadoof42.models.User;
import java.util.Collection;

public interface Storage<T> {

    public Collection<T> values();

    public int add(final T t);

    public void edit(final T t);

    public void delete(final int id);

    public User get(final int id);

    public User findByLogin(final String login) ;

    public int generateId();

    public void close();
}