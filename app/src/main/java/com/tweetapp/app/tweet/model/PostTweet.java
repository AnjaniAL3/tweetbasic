package com.tweetapp.app.tweet.model;

public class PostTweet {

    private Long userId;
    private String userName;
    private String tweet;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getTweet() {
        return tweet;
    }
    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public PostTweet() {
        // TODO Auto-generated constructor stub
    }
    public PostTweet(Long userId, String userName, String tweet) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.tweet = tweet;
    }

    public PostTweet(String tweet) {
        super();
        this.tweet = tweet;
    }
    @Override
    public String toString() {
        return "PostTweet [userName=" + userName + ", tweet=" + tweet + "]";
    }
}
