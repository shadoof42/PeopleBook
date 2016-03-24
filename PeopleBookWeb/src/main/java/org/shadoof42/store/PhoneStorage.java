package org.shadoof42.store;

import org.shadoof42.models.Phone;
import org.shadoof42.models.PhoneType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by Shadoof on 24.03.2016.
 */
@Repository
public class PhoneStorage implements Storage<Phone> {
    private final HibernateTemplate template;

    @Autowired
    public PhoneStorage(HibernateTemplate template) {
        this.template = template;
    }

    /**
     * Получить все кортежи
     *
     * @return список кортежей
     */
    @Override
    public Collection<Phone> values() {
        return (Collection<Phone>) this.template.find("from Phone");
    }

    /**
     * Добавить запись
     *
     * @param phone запись
     * @return ее id
     */
    @Transactional
    @Override
    public int add(Phone phone) {
        return (int) this.template.save(phone);
    }

    /**
     * Редактировать запись
     *
     * @param phone запись
     */
    @Transactional
    @Override
    public void edit(Phone phone) {
        this.template.update(phone);
    }

    /**
     * Удалить запись по id
     *
     * @param id идентификатор
     */
    @Override
    public void delete(int id) {

    }

    /**
     * Получить запись по ее id
     *
     * @param id идентификатор
     * @return запись-кортеж
     */
    @Override
    public Phone get(int id) {
        return null;
    }

    /**
     * Удалить запись по id
     *
     * @param id идентификатор
     */
    @Transactional
    public void delete(long id) {
        this.template.delete(this.get(id));
    }

    /**
     * Получить запись по ее id
     *
     * @param id идентификатор
     * @return запись-кортеж
     */
    public Phone get(long id) {
        return this.template.get(Phone.class,id);
    }
    @Transactional
    public int saveType(PhoneType type){
        return (int) this.template.save(type);
    }
}
