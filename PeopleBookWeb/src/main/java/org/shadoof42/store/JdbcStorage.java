package org.shadoof42.store;

import org.shadoof42.logic.User;
import org.shadoof42.service.Settings;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JdbcStorage implements Storage {
    private final Connection connection;

    public JdbcStorage(){
        final Settings settings = Settings.getInstance();
        try {
            this.connection = DriverManager.getConnection(settings.value("jdbc.url"),settings.value("jdbc.username"),settings.value("jdbc.password"));
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Collection<User> values() {
        final List<User> users = new ArrayList<>();
        try(final Statement statement = this.connection.createStatement();) {
            final ResultSet rs = statement.executeQuery("SELECT * FROM  user");
            while (rs.next()){
                users.add(new User(rs.getInt("id"),rs.getString("login"),rs.getString("email"),rs.getString("passwd")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public int add(User user) {
        try ( final PreparedStatement statement = this.connection.prepareStatement("INSERT INTO  user (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);){
            statement.setString(1,user.getLogin());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public User findByLogin(String login) {
        return null;
    }

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
