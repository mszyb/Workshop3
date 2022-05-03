package pl.coderslab.users;

import pl.coderslab.jbcrypt.BCrypt;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final String READ_USER_QUERY = "SELECT * FROM users WHERE id = ?;";
    private static final String FIND_ALL_USERS_QUERY = "SELECT * FROM users";
    private static final String CREATE_NEW_USER_QUERY = "INSERT INTO users(username,email, password) VALUES(?,?,?);";
    private static final String DELETE_USER_QUERY = "DELETE FROM users WHERE id = ?;";
    private static final String EDIT_USER_QUERY = "UPDATE users SET username=?, email=?, password=? WHERE id=?;";

    public User readUser(long id) {
        User user = new User();
        try (Connection connection = DbUtil.getConnetion()) {
            PreparedStatement preparedStatement = connection.prepareStatement(READ_USER_QUERY);
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user.setId(rs.getLong("id"));
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
                user.setId(rs.getLong("id"));
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
            preparedStatement.setString(3, BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next()){
                newUser.setId(rs.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newUser;
    }

    public void deleteUser (long id){
        try (Connection connection = DbUtil.getConnetion()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_QUERY);
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.executeUpdate();
        }
        catch (SQLException e ){
            e.printStackTrace();
        }
    }

    public User editUser(User userToEdit, User newUser){
        try (Connection connection = DbUtil.getConnetion()) {
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_USER_QUERY);
            preparedStatement.setString(1, newUser.getUserName());
            preparedStatement.setString(2, newUser.getEmail());
            preparedStatement.setString(3, BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
            preparedStatement.setLong(4, userToEdit.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e ){
            e.printStackTrace();
        }
        return newUser;
    }
}
