package org.shadoof42.store;

import org.shadoof42.models.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Shadoof on 25.03.2016.
 */
@Repository
public class PhoneStorage implements Storage<Phone> {
//    private final HibernateTemplate template;
////    @Autowired
//    public PhoneStorage(HibernateTemplate template) {
//        this.template = template;
//    }


    /**
     * Получить все кортежи
     *
     * @return список кортежей
     */
    @Override
    public Collection<Phone> values() {
        return null;
    }

    /**
     * Добавить запись
     *
     * @param phone запись
     * @return ее id
     */
    @Override
    public int add(Phone phone) {
        return 0;
    }

    /**
     * Редактировать запись
     *
     * @param phone запись
     */
    @Override
    public void edit(Phone phone) {

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
}
