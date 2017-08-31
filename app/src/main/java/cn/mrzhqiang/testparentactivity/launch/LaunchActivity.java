package cn.mrzhqiang.testparentactivity.launch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import cn.mrzhqiang.testparentactivity.main.MainActivity;
import cn.mrzhqiang.testparentactivity.R;
import cn.mrzhqiang.testparentactivity.login.LoginActivity;

public class LaunchActivity extends AppCompatActivity {
    private static final long FUTURE = TimeUnit.SECONDS.toMillis(3);
    private static final long INTERVAL = TimeUnit.SECONDS.toMillis(1);

    private CountDownTimer timer = new CountDownTimer(FUTURE, INTERVAL) {
        @Override
        public void onTick(long millisUntilFinished) {
            content.setText(String.format(Locale.getDefault(), "倒计时：%d 秒",
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)));
        }

        @Override
        public void onFinish() {
            content.setText("准备启动..");
            SharedPreferences sp = getSharedPreferences("accountInfo", Context.MODE_PRIVATE);
            if (!sp.getBoolean("status", false)) {
                startActivity(new Intent(LaunchActivity.this, LoginActivity.class));
            } else {
                startActivity(new Intent(LaunchActivity.this, MainActivity.class));
            }
            finish();
        }
    };

    private TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        content = ((TextView) findViewById(R.id.content));
        content.setText("启动页");
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (timer != null) {
            timer.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (timer != null) {
            timer.cancel();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer = null;
        }
    }
}
