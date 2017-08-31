package cn.mrzhqiang.testparentactivity.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.mrzhqiang.testparentactivity.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, LoginFragment.newInstance())
                    .commit();
        }
    }
}
