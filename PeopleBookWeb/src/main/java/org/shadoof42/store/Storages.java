package org.shadoof42.store;

import org.shadoof42.models.Abonent;
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
//    public final PhoneStorage phoneStorage;
//    public final AbonentStorage abonentStorage;

    @Autowired
    public Storages(final UserStorage userStorage, final RoleDAO roleStorage, final MessageStorage messageStorage) {
        this.userStorage = userStorage;
        this.roleStorage = roleStorage;
        this.messageStorage = messageStorage;
//        this.phoneStorage = phoneStorage;
//        this.phoneStorage = phoneStorage;
//        this.abonentStorage = abonentStorage;
    }
}
