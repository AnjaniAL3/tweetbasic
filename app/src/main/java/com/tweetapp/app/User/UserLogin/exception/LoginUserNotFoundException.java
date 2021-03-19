package com.tweetapp.app.User.UserLogin.exception;

public class LoginUserNotFoundException extends Exception{
    String message;
    public LoginUserNotFoundException(String m) {
        // TODO Auto-generated constructor stub
        this.message=m;
    }
}
