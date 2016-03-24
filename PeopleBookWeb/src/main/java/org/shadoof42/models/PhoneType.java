package org.shadoof42.models;

/**
 * Created by Shadoof on 23.03.2016.
 * Класс Тип телефона
 */
public class PhoneType extends Base {
    /**
     * Наименование
     */
    private String name;

//    public PhoneType(String name) {
//        this.name = name;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneType phoneType = (PhoneType) o;

        return !(name != null ? !name.equals(phoneType.name) : phoneType.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PhoneType{" +
                "name='" + name + '\'' +
                '}';
    }
}
