package org.shadoof42.models;

/**
 * Created by Shadoof on 09.03.2016.
 */
public class Message extends Base {
    private User user;
    private String text;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

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
