package org.shadoof42.models;

/**
 * Класс-сущность роль пользователя
 * Created by Shadoof on 09.03.2016.
 */
public class Role extends Base {
    /**
     * Имя роли
     */
    private String name;

    public Role(){}

    public Role(final String name){
        this.name = name;
    }

    /**
     * Получить имя роли
     * @return имя роли
     */
    public String getName() {
        return name;
    }

    /**
     * Сменить имя роли
     * @param name новое имя роли
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Роль{" +
                "имя='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        return name.equals(role.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}