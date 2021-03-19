package com.tweetapp.app.User.UserLogin.dao;

import com.tweetapp.app.DB.DBHandler;
import com.tweetapp.app.User.UserLogin.exception.LoginUserNotFoundException;
import com.tweetapp.app.User.UserRegistration.modal.UserRegistration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginSql {
    public UserRegistration getUser(String Username) throws ClassNotFoundException, SQLException, LoginUserNotFoundException {
        String SELECT_USER = "select us_email,us_password from user where us_email =?";



        UserRegistration user = new UserRegistration();

        try {
            Connection connection =  DBHandler.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER);
            preparedStatement.setString(1, Username);

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("before result ");

            System.out.println("*********"+resultSet.toString());
            while(resultSet.next()) {

                System.out.println("before result set email");
                System.out.println(resultSet.getString("us_email"));
                user.seteMail(resultSet.getString("us_email"));


                user.setPassword(resultSet.getString("us_password"));
            }

        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        }
        return user;

    }
}
