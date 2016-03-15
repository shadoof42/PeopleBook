package org.shadoof42.store;

import org.shadoof42.models.Role;
import org.shadoof42.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by Shadoof on 10.03.2016.
 */
@Repository
public class RoleStorage implements RoleDAO {

    private final HibernateTemplate template;

    @Autowired
    public RoleStorage(final HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public Collection<Role> values() {
        return (Collection<Role>) this.template.find("from Role");
    }

    @Transactional
    @Override
    public int add(Role role) {
        return (int) this.template.save(role);
    }
    @Transactional
    @Override
    public void edit(Role role) {
        this.template.update(role);
    }
    @Transactional
    @Override
    public void delete(int id) {
        this.template.delete(get(id));
    }

    @Override
    public Role get(int id) {
        return this.template.get(Role.class,id);
    }

//    @Override
//    public User findByLogin(String login) {
//        return null;
//    }

}
