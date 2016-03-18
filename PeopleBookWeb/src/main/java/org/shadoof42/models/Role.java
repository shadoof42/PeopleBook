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

    /**
     * Признак сокрытости
     */
    private Boolean hidden;

    public Role(){hidden=false;}

    /**
     * Параметризированный конструктор роли
     * @param name имя роли
     */
    public Role(final String name){
        this.name = name;hidden=false;
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

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
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

        return name.equals(role.name) && id==id;

    }

    @Override
    public int hashCode() {
        return name.hashCode()+31*Integer.hashCode(id);
    }
}