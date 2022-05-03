package pl.coderslab.users;

import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserDAO {
    private static final String READ_USER_QUERY = "SELECT * FROM users WHERE id = ?;";
    private static final String FIND_ALL_USERS_QUERY = "SELECT * FROM users";
    private static final String CREATE_NEW_USER_QUERY = "INSERT INTO users(username,email, password) VALUES(?,?,?);";

    public User readUser(int id) {
        User user = new User();
        try (Connection connection = DbUtil.getConnetion()) {
            PreparedStatement preparedStatement = connection.prepareStatement(READ_USER_QUERY);
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> findAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnetion()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_USERS_QUERY);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public User createNewUser(User newUser) {
        try (Connection connection = DbUtil.getConnetion()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NEW_USER_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, newUser.getUserName());
            preparedStatement.setString(2, newUser.getEmail());
            preparedStatement.setString(3, newUser.getPassword());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next()){
                newUser.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newUser;
    }
}
