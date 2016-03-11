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
     * Получить пользователя
     * @return
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
     * Получить владельца письма
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
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "user=" + user +
                ", text='" + text + '\'' +
                '}';
    }
}
