package org.shadoof42.models;

/**
 * Created by Shadoof on 09.03.2016.
 * Базовый класс для сущностей
 *
 */
public abstract class Base {
    /**
     * Идентификатор
     */
    protected int id;

    /**
     * Получить идентификатор
     * @return идентификатор
     */
    public int getId() {
        return id;
    }

    /**
     * Сменить идентификатор
     * @param id новый идентификатор
     */
    public void setId(int id) {
        this.id = id;
    }
}
