package com.example.yuan.demomvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.yuan.demomvp.bean.User;
import com.example.yuan.demomvp.presenter.LoginPresenter;
import com.example.yuan.demomvp.view.LoginView;

/**
 * step5：Activity: 其实就是View…在new Presenter(this)时，会提示集成View接口，接口中的方法都会在Activity调用Presenter方法时候被调用。
 */
public class MainActivity extends AppCompatActivity implements LoginView
{

    private EditText usernameEditText;
    private EditText passwordEditText;

    private Button loginBtn;
    private Button clearBtn;

    private ProgressBar progressBar;

    private LoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        loginPresenter = new LoginPresenter(this);
    }

    private void initView()
    {

        usernameEditText = (EditText) findViewById(R.id.et_username);
        passwordEditText = (EditText) findViewById(R.id.et_password);
        loginBtn = (Button) findViewById(R.id.btn_login);
        clearBtn = (Button) findViewById(R.id.btn_clear);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        //点击登入
        loginBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                loginPresenter.login();
            }
        });

        //点击清除
        clearBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                loginPresenter.clear();
            }
        });

    }



    @Override
    public String getUsername()
    {
        return usernameEditText.getText().toString();
    }

    @Override
    public String getPassword()
    {
        return passwordEditText.getText().toString();
    }

    @Override
    public User getUser()
    {
        return new User(usernameEditText.getText().toString(),
                passwordEditText.getText().toString());
    }

    @Override
    public void showLoading()
    {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading()
    {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showSuccessMsg(User user)
    {
        Toast.makeText(this, "登入成功:user="+user.getUsername()+",password="+user.getPassword(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedMsg(String s)
    {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearEditText()
    {
        usernameEditText.setText("");
        passwordEditText.setText("");
    }
}
