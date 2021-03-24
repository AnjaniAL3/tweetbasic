package com.tweetapp.app;

import com.tweetapp.app.AccountSettings.PasswordReset.PasswordResetSql;
import com.tweetapp.app.User.UserLogin.dao.UserLoginSql;
import com.tweetapp.app.User.UserLogin.modal.UserLogin;
import com.tweetapp.app.User.UserRegistration.dao.UserRegistrationSql;
import com.tweetapp.app.User.UserRegistration.modal.UserRegistration;
import com.tweetapp.app.tweet.dao.PostTweetSql;
import com.tweetapp.app.tweet.model.PostTweet;

import java.text.SimpleDateFormat;
import java.util.*;

public class TweetApp {

    int ch = 0;
    String currentloggedInUser;
    Scanner sc = new Scanner(System.in);

    void welcome(){
        System.out.println("----------------Tweet App.----------------------");
        System.out.println("1.Login");
        System.out.println("2.Register");
        System.out.println("6.Forgot Password");
        System.out.println("Enter your choice");
        ch = Integer.parseInt(sc.nextLine());
        App(ch);
    }

    void loggedIn(){
        System.out.println("What Do You Want To Do?");
        System.out.println("Menu");
        System.out.println("Choose your option");
        System.out.println("3.Post Tweet");
        System.out.println("4.View Tweet");
        System.out.println("5.View All Tweets");
        System.out.println("6.Reset Password");
        System.out.println("7.Logout");
        System.out.println("8.Exit Program");
        System.out.println("Enter your choice");
        ch = Integer.parseInt(sc.nextLine());
        App(ch);
    }

    void App(int choice) {

        switch (choice) {

            case 1:
                UserLogin ul = new UserLogin();
                System.out.println("Enter your user name");
                String username = sc.nextLine();
                System.out.println("Enter your password");
                String password = sc.nextLine();
                ul.setUsername(username);
                ul.setPassword(password);
                UserRegistration ur = null;
                try {
                    UserLoginSql uls = new UserLoginSql();
                    ur=uls.getUser(username);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                if(ur.geteMail().equals(username) && ur.getPassword().equals(password)) {
                    currentloggedInUser=username;
                    loggedIn();
                }
                else
                {
                    System.out.println("User not found. Please Register");
                    welcome();
                }

                break;
            case 2:
                UserRegistration user = new UserRegistration();
                System.out.println("Enter your firstname");
                String fn=sc.nextLine();
                user.setFirstName(fn);
                System.out.println("Enter your Last name");
                String ln= sc.nextLine();
                user.setLastName(ln);
                System.out.println("Enter you Gender");
                String gender=sc.nextLine();
                user.setGender(gender);
                System.out.println("Enter your dob (dd/MM/yyyy)");
                String dob=sc.nextLine();
                Date date1 =null;
                try {
                    date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
                }
                catch(Exception e){
                    System.out.println("Please enter valid date dd/MM/yyyy");
                }
                user.setDateOfBirth(date1);
                System.out.println("Enter your email id which will be username");
                String email=sc.nextLine();
                user.seteMail(email);
                System.out.println("Enter your password");
                String pw=sc.nextLine();
                user.setPassword(pw);
                try {
                    UserRegistrationSql urs=new UserRegistrationSql();
                    urs.registerUser(user);
                }catch(Exception e) {
                    e.printStackTrace();

                }
                welcome();
                break;
            case 3:

                PostTweet pTweet = new PostTweet();
                pTweet.setUserName(currentloggedInUser);
                System.out.println("Type in your tweet");
                String twt=sc.nextLine();
                pTweet.setTweet(twt);

                try {
                    PostTweetSql pts=new PostTweetSql();
                    pts.postTweet(pTweet);
                }catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
                loggedIn();
                break;
            case 4:
                String currentuser = currentloggedInUser;
                PostTweetSql vt = new PostTweetSql();
                List<PostTweet> tweetsList= vt.getTweetById(currentuser);
                for(PostTweet p:tweetsList)
                {
                    System.out.println(tweetsList);
                }
                loggedIn();
                break;
            case 5:
                PostTweetSql vat = new PostTweetSql();
                List<PostTweet> alltweetsList = vat.getAllTweets();
                for (PostTweet p : alltweetsList){
                    System.out.println(alltweetsList);
                }
                loggedIn();
                break;
            case 6:
                if(currentloggedInUser.isEmpty()){
                    System.out.println("Enter your user name");
                    currentloggedInUser=sc.nextLine();
                }
                String newpassword;
                System.out.println("Enter your new password");
                newpassword=sc.nextLine();


                PasswordResetSql prs=new PasswordResetSql();
                try {
                    prs.resetPassword(currentloggedInUser, newpassword);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            case 7:
                welcome();
                break;
            case 8:
                System.exit(0);
                break;
            default:
                System.out.println("Enter valid input");
        }
    }
    public static void main(String[] args){
        TweetApp tw=new TweetApp();
        tw.welcome();
    }
}
