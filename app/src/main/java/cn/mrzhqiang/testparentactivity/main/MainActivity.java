package cn.mrzhqiang.testparentactivity.main;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import cn.mrzhqiang.testparentactivity.R;
import cn.mrzhqiang.testparentactivity.login.LoginActivity;
import cn.mrzhqiang.testparentactivity.other.MessageActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView)findViewById(R.id.content)).setText("打开消息页面");
        (findViewById(R.id.content)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComponentName componentName = new ComponentName(MainActivity.this, MessageActivity.class);
                Intent intent = new Intent();
                intent.setComponent(componentName);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null) return;

        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) return;

        switch (action) {
            case "accountLogout":
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
        }
    }
}
