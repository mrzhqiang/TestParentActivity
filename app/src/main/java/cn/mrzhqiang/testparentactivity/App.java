package cn.mrzhqiang.testparentactivity;

import android.app.Application;
import android.content.Intent;

import cn.mrzhqiang.testparentactivity.service.LogService;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        startService(new Intent(this, LogService.class));
    }
}
