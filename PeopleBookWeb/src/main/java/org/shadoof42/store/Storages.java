package org.shadoof42.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Shadoof on 10.03.2016.
 */
@Service
public class Storages {
    public final UserStorage userStorage;
    public final RoleDAO roleStorage;
    public final MessageStorage messageStorage;

    @Autowired
    public Storages(final UserStorage userStorage,final RoleDAO roleStorage,final MessageStorage messageStorage) {
        this.userStorage = userStorage;
        this.roleStorage = roleStorage;
        this.messageStorage = messageStorage;
    }
}
