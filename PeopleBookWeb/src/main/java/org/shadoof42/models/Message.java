package org.shadoof42.models;

import org.junit.Test;

/**
 * Created by Shadoof on 09.03.2016.
 * Класс-сущность письмо
 */
public class Message extends Base {
    /**
     * Пользователь - владелец письма
     */
    private User user;
    /**
     * Содержание письма
     */
    private String text;

    /**
     * Получить владельца письма
     * @return пользователь
     */
    public User getUser() {
        return user;
    }
    public Message(){
    }

    /**
     * Параметризованный конструктор
     * @param user пользователь
     * @param text содержимое
     */
    public Message(User user, String text){
        this.user=user;
        this.text=text;
    }
    /**
     * Установить владельца письма
     * @param user пользователь
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Получить содержимое письма
     * @return содержимое
     */
    public String getText() {
        return text;
    }

    /**
     * Установить текст сообщения
     * @param text текст сообщения
     */
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Сообщение{" +
                "пользователь=" + user +
                ", содержимое='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (!user.equals(message.user)) return false;
        return text.equals(message.text);

    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + text.hashCode();
        return result;
    }
}
