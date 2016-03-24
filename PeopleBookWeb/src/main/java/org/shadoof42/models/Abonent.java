package org.shadoof42.models;

import java.util.List;

/**
 * Created by Shadoof on 23.03.2016.
 * Класс Абонент
 */
public class Abonent{


    private Long id;
    /**
     * Имя
     */
    private String first_name;
    /**
     * Фамилия
     */
    private String last_name;
    /**
     * Отчество
     */
    private String second_name;
    /**
     * Адрес ЭП
     */
    private String email;
    /**
     * Пол
     */
    private boolean gender;
    /**
     * Пользователь
     */
    private User user;
    /**
     * Группа
     */
    private Group group;
    /**
     * Телефоны
     */
    private List<Phone> phones;
    /**
     * Адреса проживания
     */
    private List<Adress> adresses;
    /**
     * Дополнительная информация
     */
    private String coments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getComents() {
        return coments;
    }

    public void setComents(String coments) {
        this.coments = coments;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Adress> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adress> adresses) {
        this.adresses = adresses;
    }

    @Override
    public String toString() {
        return "Abonent{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", user=" + user +
                ", group=" + group +
                ", coments='" + coments + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Abonent abonent = (Abonent) o;

        if (gender != abonent.gender) return false;
        if (!first_name.equals(abonent.first_name)) return false;
        if (!last_name.equals(abonent.last_name)) return false;
        if (second_name != null ? !second_name.equals(abonent.second_name) : abonent.second_name != null) return false;
        if (!email.equals(abonent.email)) return false;
        return user.equals(abonent.user);

    }

    @Override
    public int hashCode() {
        int result = first_name.hashCode();
        result = 31 * result + last_name.hashCode();
        result = 31 * result + (second_name != null ? second_name.hashCode() : 0);
        result = 31 * result + email.hashCode();
        result = 31 * result + (gender ? 1 : 0);
        result = 31 * result + user.hashCode();
        return result;
    }
}
