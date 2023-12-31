package org.viki.repositories;

import org.viki.model.User;

import java.sql.*;

public class SignupRepository {
    public boolean saveUser(User user) {
        String username = "root";
        String pwd = "Vigneshwari@30";
        String url = "jdbc:mysql://localhost:3306/travelblog";
        boolean isInserted = false;

        String query = "Insert into user(username,firstname,lastname,phone,email,password) " +
                "values(?, ?, ?, ?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, pwd);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getPhone());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getPassword());

            statement.execute();
            isInserted = true;
        }catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return isInserted;
    }
}
