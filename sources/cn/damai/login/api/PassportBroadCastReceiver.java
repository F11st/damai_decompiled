package cn.damai.login.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.usercenter.passport.IPassport;
import tb.zb1;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class PassportBroadCastReceiver extends BroadcastReceiver {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1379617244")) {
            ipChange.ipc$dispatch("1379617244", new Object[]{this, context, intent});
            return;
        }
        try {
            String action = intent.getAction();
            if (TextUtils.equals(action, IPassport.ACTION_USER_LOGIN)) {
                Log.d("passportReceiver", "LoginManager passport_user_login");
                zb1.c().k(IPassport.ACTION_USER_LOGIN, "");
            } else if (TextUtils.equals(action, IPassport.ACTION_USER_LOOUT)) {
                Log.d("passportReceiver", "LoginManager passport_user_logout");
                zb1.c().k(IPassport.ACTION_USER_LOOUT, "");
            } else if (TextUtils.equals(action, IPassport.ACTION_EXPIRE_LOGOUT)) {
                Log.d("passportReceiver", "LoginManager passport_expire_logout");
                zb1.c().k(IPassport.ACTION_EXPIRE_LOGOUT, "");
            } else if (TextUtils.equals(action, IPassport.ACTION_TOKEN_REFRESHED)) {
                String stringExtra = intent.getStringExtra(IPassport.EXTRA_STOKEN);
                intent.getStringExtra(IPassport.EXTRA_YTID);
                Log.d("passportReceiver", "LoginManager passport_token_refreshed");
                zb1.c().k(IPassport.ACTION_TOKEN_REFRESHED, stringExtra);
            } else if (TextUtils.equals(action, IPassport.ACTION_COOKIE_REFRESHED)) {
                String stringExtra2 = intent.getStringExtra(IPassport.EXTRA_COOKIE);
                Log.d("passportReceiver", "LoginManager passport_cookie_refreshed");
                zb1.c().k(IPassport.ACTION_COOKIE_REFRESHED, stringExtra2);
            } else if (TextUtils.equals(action, IPassport.ACTION_LOGIN_CANCEL)) {
                Log.d("passportReceiver", "LoginManager passport_login_cancel");
                zb1.c().k(IPassport.ACTION_LOGIN_CANCEL, "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
