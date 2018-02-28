package com.example.yuan.demomvp.model;

import com.example.yuan.demomvp.bean.User;

/**
 * step2：Model:Model里写真正处理信息的操作，比如请求网络，再次以子线程进行模拟。首先写接口类，然后写实现类
 * Created by yuan on 2018/2/28.
 */

//接口类
public interface LoginModel
{
    void login(User user,OnLoginListener onLoginListener);


    //登入后的回调
    interface OnLoginListener
    {
        void loginSuccess(User user);

        void loginFailed(String s);
    }

}
