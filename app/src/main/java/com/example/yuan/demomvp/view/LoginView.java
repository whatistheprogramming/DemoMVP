package com.example.yuan.demomvp.view;

import com.example.yuan.demomvp.bean.User;

/**
 * step3：View:view是Presenter与View交互接口，写一些方法以便在Activity中处理信息
 * Created by yuan on 2018/2/28.
 */

public interface LoginView
{
    //得到用户填写的信息
    String getUsername();
    String getPassword();

    User getUser();

    //显示和隐藏登录ProgressBar
    void showLoading();
    void hideLoading();

    //登录成功或失败后，返回信息的方法
    void showSuccessMsg(User user);
    void showFailedMsg(String s);

    //清除数据
    void clearEditText();

}
