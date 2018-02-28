package com.example.yuan.demomvp.presenter;

import android.os.Handler;

import com.example.yuan.demomvp.bean.User;
import com.example.yuan.demomvp.model.LoginModel;
import com.example.yuan.demomvp.model.LoginModelImpl;
import com.example.yuan.demomvp.view.LoginView;

/**
 * step4：Presenter:Presenter是用作Model和View之间交互的桥梁，在Activity中拿到Presenter对象后，实现View接口，调用Presenter方法即可
 * Created by yuan on 2018/2/28.
 */

public class LoginPresenter
{
    private LoginView loginView;
    private LoginModel loginModel;
    private Handler mHandler;

    public LoginPresenter(LoginView loginView)
    {
        this.loginView = loginView;
        loginModel = new LoginModelImpl();
        mHandler = new Handler();
    }


    public void login()
    {
        loginView.showLoading();
        loginModel.login(loginView.getUser(), new LoginModel.OnLoginListener()
        {
            @Override
            public void loginSuccess(final User user)
            {
                //模拟登录成功后，返回信息到Activity,吐出成功信息
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        loginView.showSuccessMsg(user);
                        loginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed(final String s)
            {
                //模拟登录失败后，返回信息，吐出错误信息
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        loginView.hideLoading();
                        loginView.showFailedMsg(s);
                    }
                });
            }
        });
    }

    public void clear()
    {
        loginView.clearEditText();
    }
}
