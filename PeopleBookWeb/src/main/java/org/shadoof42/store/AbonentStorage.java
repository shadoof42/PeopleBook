package org.shadoof42.store;

import org.shadoof42.models.Abonent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Shadoof on 24.03.2016.
 */
@Repository
public class AbonentStorage implements Storage<Abonent>{

    private final HibernateTemplate template;

    @Autowired(required = false)
    public AbonentStorage(HibernateTemplate template) {
        this.template = template;
    }

    /**
     * Получить все кортежи
     *
     * @return список кортежей
     */
    @Override
    public Collection<Abonent> values() {
        return (Collection<Abonent>) this.template.find("from Abonent");
    }

    /**
     * Добавить запись
     *
     * @param abonent запись
     * @return ее id
     */
    @Override
    public int add(Abonent abonent) {
        return (int) this.template.save(abonent);
    }

    /**
     * Редактировать запись
     *
     * @param abonent запись
     */
    @Override
    public void edit(Abonent abonent) {
        this.template.update(abonent);
    }

    /**
     * Удалить запись по id
     *
     * @param id идентификатор
     */
    @Override
    public void delete(int id) {
        this.template.delete(id);
    }

    /**
     * Получить запись по ее id
     *
     * @param id идентификатор
     * @return запись-кортеж
     */
    @Override
    public Abonent get(int id) {
        return this.template.get(Abonent.class,id);
    }
}
