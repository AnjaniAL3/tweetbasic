package com.tweetapp.app.AccountSettings.PasswordReset;

import com.tweetapp.app.DB.DBHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PasswordResetSql {
    public void resetPassword(String username, String password) throws ClassNotFoundException, SQLException {
        String RESET ="UPDATE user set us_password=? where us_email=?;";


        Connection connection = DBHandler.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(RESET) ;

        preparedStatement.setString(1, password);
        preparedStatement.setString(2, username);


        //System.out.println(preparedStatement);

        preparedStatement.executeUpdate();
    }
}
