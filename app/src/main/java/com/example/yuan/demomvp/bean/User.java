package com.example.yuan.demomvp.bean;

/**
 * step1:bean类：
 * Created by yuan on 2018/2/28.
 */

public class User
{
    private String username;
    private String password;

    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }


    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
