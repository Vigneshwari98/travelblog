package org.viki.repositories;

import org.viki.model.User;

import java.sql.*;

public class LoginRepository {
    public User getUserDetailsByName(String name){

        String username = "root";
        String password = "Vigneshwari@30";
        String url = "jdbc:mysql://localhost:3306/travelblog";
        String query = "Select * from user where username = ?";
        User user = new User();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                user.setUsername(resultSet.getString("username"));
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setPassword(resultSet.getString("password"));
            }
        }catch (ClassNotFoundException | SQLException exception){
            exception.printStackTrace();
        }
        return user;
    }
}
