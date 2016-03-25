package org.shadoof42.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by Shadoof on 25.03.2016.
 */
public abstract class BaseStorage {
    private final SessionFactory factory;

    public BaseStorage() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }

    public interface Command<T>{
        T process (Session session);
    }

    protected  <T> T transaction(final Command<T> command){
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            return command.process(session);
        }finally {
            tx.commit();
            session.close();
        }
    }
}
