package com.tweetapp.app.User.UserRegistration.dao;

import com.tweetapp.app.DB.DBHandler;
import com.tweetapp.app.User.UserRegistration.modal.UserRegistration;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class UserRegistrationSql {
    int flag=0;
    public void registerUser(UserRegistration user) throws Exception {
        String INSERT_USERS_SQL = "INSERT INTO user" +
                "  (us_first_name, us_last_name, us_gender, us_dob, us_email, us_password) VALUES " +
                " (?, ?, ?, ?, ?,?);";


        Connection connection = DBHandler.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL) ;

        preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(2, user.getLastName());
        preparedStatement.setString(3, user.getGender());
        preparedStatement.setDate(4, new Date(user.getDateOfBirth().getTime()));
        preparedStatement.setString(5, user.geteMail());
        preparedStatement.setString(6, user.getPassword());

        //System.out.println(preparedStatement);

        preparedStatement.executeUpdate();

    }


}
