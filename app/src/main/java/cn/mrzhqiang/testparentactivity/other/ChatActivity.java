package cn.mrzhqiang.testparentactivity.other;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import cn.mrzhqiang.testparentactivity.R;
import cn.mrzhqiang.testparentactivity.main.MainActivity;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TextView)findViewById(R.id.content)).setText("退出登录");
        (findViewById(R.id.content)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSharedPreferences("accountInfo", Context.MODE_PRIVATE)
                        .edit().putBoolean("status", false).apply();
                Intent intent = new Intent(ChatActivity.this, MainActivity.class);
                intent.setAction("accountLogout");
                startActivity(intent);
            }
        });
    }
}
