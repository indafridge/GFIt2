package com.example.gfit;

public class User {

    public String username;
    public String password;
    public String repassword;
    public String email;

    public User(){

    }
    public User(String username,String password, String repassword, String email){
        this.username = username;
        this.password = password;
        this.repassword = repassword;
        this.email = email;
    }
}
