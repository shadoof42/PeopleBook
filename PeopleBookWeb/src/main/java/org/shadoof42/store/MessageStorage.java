package org.shadoof42.store;

import org.shadoof42.models.Message;
import org.shadoof42.models.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Shadoof on 10.03.2016.
 */
@Repository
public class MessageStorage implements Storage<Message> {
    @Override
    public Collection<Message> values() {
        return null;
    }

    @Override
    public int add(Message message) {
        return 0;
    }

    @Override
    public void edit(Message message) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public User findByLogin(String login) {
        return null;
    }

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void close() {

    }
}
