package com.example.yuan.demomvp.model;

import com.example.yuan.demomvp.bean.User;

/**
 * Created by yuan on 2018/2/28.
 */

//实习类
public class LoginModelImpl implements LoginModel
{
    @Override
    public void login(final User user, final OnLoginListener onLoginListener)
    {
        /**
         * 模拟子线程，执行耗时操作
         */
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(3000);
                    if (user.getUsername().equals("123") && user.getPassword().equals("123"))
                    {
                        onLoginListener.loginSuccess(new User(user.getUsername(),user.getPassword()));
                    }
                    else
                    {
                        onLoginListener.loginFailed("用户名或密码错误");
                    }
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
