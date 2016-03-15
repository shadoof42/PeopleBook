package org.shadoof42.store;

import org.shadoof42.models.User;
import java.util.Collection;

/**
 * Единый интерфейс для методов работы с БД
 * @param <T>
 */
public interface Storage<T> {
    /**
     * Получить все кортежи
     * @return список кортежей
     */
    public Collection<T> values();

    /**
     * Добавить запись
     * @param t запись
     * @return ее id
     */
    public int add(final T t);

    /**
     * Редактировать запись
     * @param t запись
     */
    public void edit(final T t);

    /**
     * Удалить запись по id
     * @param id идентификатор
     */
    public void delete(final int id);

    /**
     * Получить запись по ее id
     * @param id идентификатор
     * @return запись-кортеж
     */
    public T get(final int id);

}