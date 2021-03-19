package com.tweetapp.app.tweet.dao;

import com.tweetapp.app.DB.DBHandler;
import com.tweetapp.app.tweet.model.PostTweet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PostTweetSql {

    //LoginDaoSqlImpl loginDaoSqlImpl =new LoginDaoSqlImpl();

    String INSERT_TWEET_SQL = "INSERT INTO tweet" +
            "  (tweet_us_email, tweet_message) VALUES " +
            " (?, ?);";
    String VIEW_TWEET_SQL = "select * from tweet";

    String VIEW_TWEET_BY_USER_SQL = "select * from tweet where tweet_us_email=? ";

    public void postTweet(PostTweet tweet) {
        // TODO Auto-generated method stub
        try {
            Connection connection =  DBHandler.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TWEET_SQL);
//			 System.out.println(tweet.getUserName());

            preparedStatement.setString(1,tweet.getUserName() );
            preparedStatement.setString(2, tweet.getTweet());
//			 System.out.println(tweet.getTweet());
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public List<PostTweet> getAllTweets() {
        // TODO Auto-generated method stub
        List<PostTweet> tweetsList= new ArrayList();

        try {
            Connection connection =  DBHandler.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(VIEW_TWEET_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
//			 System.out.println(tweet.getUserName());
            while(resultSet.next()) {
                Long id=resultSet.getLong("tweet_id");
                String uName=resultSet.getString("tweet_us_email");
                String uTweet = resultSet.getString("tweet_message");
                System.out.println(uTweet);
                PostTweet postTweet = new PostTweet(id,uName,uTweet);
                tweetsList.add(postTweet);

            }

        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return tweetsList;

    }
    public List<PostTweet> getTweetById(String user) {
        // TODO Auto-generated method stub
        List<PostTweet> tweetsList= new ArrayList();

        try {
            Connection connection =  DBHandler.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(VIEW_TWEET_BY_USER_SQL);
            preparedStatement.setString(1, user);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println(resultSet.toString());
//			 System.out.println(tweet.getUserName());
            while(resultSet.next()) {


                String uTweet = resultSet.getString("tweet_message");

                PostTweet postTweet = new PostTweet(uTweet);
                tweetsList.add(postTweet);


            }

        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return tweetsList;

    }
}
