package com.taobao.login4android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ali.user.mobile.service.NumberAuthService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.NetworkUtil;
import com.taobao.login4android.Login;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.log.LoginTLogAdapter;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class StatusReceiver extends BroadcastReceiver {
    public static final String TAG = "login.status";
    private long mLastHandleTime;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            String action = intent.getAction();
            LoginTLogAdapter.d(TAG, "StatusReceiver onReceive action:" + action);
            if (!ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(action) || (System.currentTimeMillis() - this.mLastHandleTime >= DateUtils.MILLIS_PER_MINUTE && NetworkUtil.isNetworkConnected())) {
                this.mLastHandleTime = System.currentTimeMillis();
                if (LoginSwitch.getSwitch("enable_auth_prefetch", "true") && ServiceFactory.getService(NumberAuthService.class) != null && ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).needPrefetch() && TextUtils.isEmpty(Login.getLoginToken())) {
                    LoginTLogAdapter.d(TAG, "doPrefetch");
                    ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).preFecth("networkConnected");
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
