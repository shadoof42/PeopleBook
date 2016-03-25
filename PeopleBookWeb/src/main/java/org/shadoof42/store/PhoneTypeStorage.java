package org.shadoof42.store;

import org.hibernate.cfg.Configuration;
import org.shadoof42.models.PhoneType;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Shadoof on 25.03.2016.
 */
@Repository
public class PhoneTypeStorage extends BaseStorage implements Storage<PhoneType>{


    /**
     * Получить все кортежи
     *
     * @return список кортежей
     */
    @Override
    public Collection<PhoneType> values() {
        return transaction(session -> session.createQuery("from PhoneType as phoneType order by phoneType.id").list());
    }

    /**
     * Добавить запись
     *
     * @param phoneType запись
     * @return ее id
     */
    @Override
    public int add(PhoneType phoneType) {
        return transaction(session -> {
            session.save(phoneType);
            return phoneType.getId();
        });
    }

    /**
     * Редактировать запись
     *
     * @param phoneType запись
     */
    @Override
    public void edit(PhoneType phoneType) {
        transaction(session -> {
            session.update(phoneType);
            return null;
        });
    }

    /**
     * Удалить запись по id
     *
     * @param id идентификатор
     */
    @Override
    public void delete(int id) {
        transaction(session -> {
            session.delete(PhoneTypeStorage.this.get(id));
            return null;
        });
    }

    /**
     * Получить запись по ее id
     *
     * @param id идентификатор
     * @return запись-кортеж
     */
    @Override
    public PhoneType get(int id) {
        return transaction(session -> (PhoneType) session.get(PhoneType.class, id));
    }
//    /**
//     * Получить все кортежи
//     *
//     * @return список кортежей
//     */
//    private final HibernateTemplate template;
//    @Autowired
//    public PhoneTypeStorage(HibernateTemplate template) {
//        this.template = template;
//    }
//
//    @Override
//    public Collection<PhoneType> values() {
//        return (Collection<PhoneType>) this.template.find("from PhoneType ");
//    }
//
//    /**
//     * Добавить запись
//     *
//     * @param phoneType запись
//     * @return ее id
//     */
//    @Override
//    public int add(PhoneType phoneType) {
//        return 0;
//    }
//
//    /**
//     * Редактировать запись
//     *
//     * @param phoneType запись
//     */
//    @Override
//    public void edit(PhoneType phoneType) {
//
//    }
//
//    /**
//     * Удалить запись по id
//     *
//     * @param id идентификатор
//     */
//    @Override
//    public void delete(int id) {
//
//    }
//
//    /**
//     * Получить запись по ее id
//     *
//     * @param id идентификатор
//     * @return запись-кортеж
//     */
//    @Override
//    public PhoneType get(int id) {
//        return null;
//    }
}
