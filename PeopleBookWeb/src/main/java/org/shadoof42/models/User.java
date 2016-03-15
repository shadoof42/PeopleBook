package org.shadoof42.models;


import java.util.List;
/**
 * Класс-сущность пользователь
 * Created by Shadoof on 09.03.2016.
 */
public class User extends Base {
    /**
     * Логин пользователя
     */
    private String login;
    /**
     * Адрес электронной почты
     */
    private String email;
    /**
     * Роль пользователя
     */
    private Role role;
    /**
     * Пароль пользователя
     */
    private String password;

    /**
     * Список сообщений пользователя
     */
    private List<Message> messages;

    public User() {
    }

    /**
     * Параметризированный конструктор пользователя
     * @param login логин
     * @param email адрес ЭП
     * @param role роль
     */
    public User(final String login, final String email, final Role role) {
        this.login = login;
        this.email = email;
        this.role = role;
    }

    /**
     * Параметризированный конструктор пользователя
     * @param login логин
     * @param email адрес ЭП
     * @param role роль
     * @param password пароль
     */
    public User(final String login, final String email, final Role role, final String password) {
        this.login = login;
        this.email = email;
        this.role = role;
        this.password = password;
    }
    /**
     * Конструктор с параметрами
     * @param id идентификатор
     * @param login логин
     * @param email адрес ЭП
     */
    public User(final int id, final String login, final String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }

    /**
     * Получить роль пользователя
     * @return роль пользователя
     */
    public Role getRole() {
        return role;
    }

    /**
     * Сменить роль пользователя
     * @param role новая роль пользователя
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Получить список сообщений
     * @return список сообщений
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Назначить пользователя список сообщений
     * @param messages список сообщений
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * Получить логин пользователя
     * @return логин
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * Получить адрес ЭП
     * @return адрес ЭП
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Сменить логин
     * @param login новый логин
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Сменить адрес ЭП
     * @param email новый адрес ЭП
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Получить пароль
     * @return пароль
     */
    public String getPassword() {
        return password;
    }
    /**
     * Сменить пароль
     * @param password новый пароль
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Пользователь{" +
                "логин='" + login + '\'' +
                ", email='" + email + '\'' +
                ", роль=" + role +
                ", сообщения=" + messages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        if (id!=user.getId()) return false;
        if (!login.equals(user.login)) return false;
        if (!email.equals(user.email)) return false;
        return role.equals(user.role);

    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }
}