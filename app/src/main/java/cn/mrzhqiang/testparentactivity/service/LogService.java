package cn.mrzhqiang.testparentactivity.service;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;


public class LogService extends Service {
    private static final String TAG = "LogService";

    private Application.ActivityLifecycleCallbacks callbacks = new Application.ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            Log.d(TAG, "===Created===" + activity.getLocalClassName());
        }

        @Override
        public void onActivityStarted(Activity activity) {
            Log.d(TAG, "===Started===" + activity.getLocalClassName());
        }

        @Override
        public void onActivityResumed(Activity activity) {
            Log.d(TAG, "===Resumed===" + activity.getLocalClassName());
        }

        @Override
        public void onActivityPaused(Activity activity) {
            Log.d(TAG, "===Paused===" + activity.getLocalClassName());
        }

        @Override
        public void onActivityStopped(Activity activity) {
            Log.d(TAG, "===Stopped===" + activity.getLocalClassName());
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Log.d(TAG, "===SaveInstanceState===" + activity.getLocalClassName());
        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            Log.d(TAG, "===Destroyed===" + activity.getLocalClassName());
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getApplication().registerActivityLifecycleCallbacks(callbacks);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getApplication().unregisterActivityLifecycleCallbacks(callbacks);
    }
}
