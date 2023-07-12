package com.taobao.monitor.adapter;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.taobao.login4android.api.Login;
import com.taobao.login4android.broadcast.LoginAction;
import com.taobao.login4android.broadcast.LoginBroadcastHelper;
import com.taobao.login4android.session.SessionManager;
import com.taobao.orange.OrangeConfig;
import java.io.Serializable;
import java.util.HashMap;
import tb.ho2;
import tb.hw0;
import tb.m6;
import tb.pb1;
import tb.q3;
import tb.rj2;
import tb.vm2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TBAPMAdapterLauncherPart2 implements Serializable {
    private static final float DEFAULT_SAMPLE = 1.0f;
    private static final String IS_APM = "isApm";
    private static final String TAG = "TBAPMAdapterLauncherPart2";
    private static boolean init;
    private long apmStartTime = ho2.a();

    private void configOrange() {
        q3.b().a().post(new Runnable() { // from class: com.taobao.monitor.adapter.TBAPMAdapterLauncherPart2.1
            @Override // java.lang.Runnable
            public void run() {
                OrangeConfig.getInstance().getConfigs(m6.ORANGE_NAMESPACE);
                OrangeConfig.getInstance().registerListener(new String[]{m6.ORANGE_NAMESPACE}, new m6(), true);
            }
        });
    }

    private void initAPMFunction(Application application, HashMap<String, Object> hashMap) {
        initLogin(application);
    }

    private void initLogin(final Context context) {
        vm2.d(new Runnable() { // from class: com.taobao.monitor.adapter.TBAPMAdapterLauncherPart2.2
            @Override // java.lang.Runnable
            public void run() {
                hw0.n = SessionManager.getInstance(context).getNick();
                hw0.m = SessionManager.getInstance(context).getUserId();
            }
        });
        LoginBroadcastHelper.registerLoginReceiver(context, new BroadcastReceiver(this) { // from class: com.taobao.monitor.adapter.TBAPMAdapterLauncherPart2.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (intent == null || LoginAction.valueOf(intent.getAction()) == null) {
                    return;
                }
                hw0.n = Login.getNick();
                hw0.m = Login.getUserId();
            }
        });
    }

    public void init(Application application, HashMap<String, Object> hashMap) {
        if (!init && rj2.e) {
            init = true;
            pb1.d(TAG, "init start");
            if (rj2.a) {
                initAPMFunction(application, hashMap);
            }
            configOrange();
            pb1.d(TAG, "init end");
        }
        pb1.d(TAG, "apmStartTime:" + (ho2.a() - this.apmStartTime));
    }
}
