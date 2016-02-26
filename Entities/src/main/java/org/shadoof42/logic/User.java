package org.shadoof42.logic;

/**
 * Класс Пользователь
 */
public class User {
    /**
     * Идентификатор пользователя
     */
    private final int id;
    /**
     * Имя пользователя
     */
    private final String name;
    /**
     * Пароль пользователя
     */
    private String passwd;
    /**
     * Почтовый адрес пользователя
     */
    private String email;
    /**
     * Конструктор
     * @param id идентификатор пользователя
     * @param name имя пользователя
     * @param passwd пароль пользователя
     */
    public User(int id, final String name, final String passwd) {
        this.id = id;
        this.name = name;
        if (passwd!=null)this.passwd = passwd;
    }

    /**
     * Сменить почтовый адрес пользователя
     * @param email новый почтовый адрес
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Получить почтовый адрес
     * @return почтовый адрес
     */
    public String getEmail() {
        return email;
    }

    /**
     * Получить имя пользователя
     * @return имя пользователя
     */
    public String getName(){
        return this.name;
    }

    /**
     * Установить пароль для пользователя
     * @param passwd новый пароль
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * Активен ли пользователь?
     * @return активность
     */
    public boolean isActive(){
        return !this.passwd.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!email.equals(user.email)) return false;
        if (!name.equals(user.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }
}
