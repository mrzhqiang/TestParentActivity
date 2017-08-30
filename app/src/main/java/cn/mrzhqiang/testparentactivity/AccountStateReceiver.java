package cn.mrzhqiang.testparentactivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;


public class AccountStateReceiver extends BroadcastReceiver {

    public static final String ACTION_LOGOUT = "cn.mrzhqiang.test_LOGOUT";
    public static final String ACTION_LOGIN = "cn.mrzhqiang.test_LOGIN";

    private boolean hasLogout = false;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null) return;
        String action = intent.getAction();

        if (TextUtils.isEmpty(action)) return;

        switch (action) {
            case ACTION_LOGOUT:
                if (!hasLogout) {
                    Intent openLogin = new Intent(context, LoginActivity.class);
                    openLogin.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    openLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    context.startActivity(openLogin);
                    hasLogout = true;
                }
                break;
            case ACTION_LOGIN:
                if (hasLogout) {
                    hasLogout = false;
                }
                break;
        }

    }
}
