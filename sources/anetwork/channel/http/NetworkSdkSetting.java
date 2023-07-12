package anetwork.channel.http;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import anet.channel.c;
import anet.channel.entity.ENV;
import anet.channel.util.ALog;
import anetwork.channel.cookie.CookieManager;
import anetwork.channel.monitor.Monitor;
import com.uc.webview.export.extension.UCCore;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.hu0;
import tb.rj1;
import tb.t9;
import tb.w70;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class NetworkSdkSetting implements Serializable {
    private static final String TAG = "anet.NetworkSdkSetting";
    private static Context context;
    public static ENV CURRENT_ENV = ENV.ONLINE;
    private static AtomicBoolean isInit = new AtomicBoolean(false);
    private static HashMap<String, Object> initParams = null;

    public static Context getContext() {
        return context;
    }

    public static void init(Context context2) {
        if (context2 == null) {
            return;
        }
        try {
            if (isInit.compareAndSet(false, true)) {
                ALog.e(TAG, "NetworkSdkSetting init", null, new Object[0]);
                context = context2;
                hu0.o(System.currentTimeMillis());
                hu0.l(context2);
                rj1.e();
                t9.f(context2);
                initTaobaoAdapter();
                Monitor.init();
                if (!t9.O()) {
                    CookieManager.n(context2);
                }
                c.y(context2);
                w70.a();
            }
        } catch (Throwable th) {
            ALog.d(TAG, "Network SDK initial failed!", null, th, new Object[0]);
        }
    }

    private static void initTaobaoAdapter() {
        try {
            anet.channel.util.c.i("anet.channel.TaobaoNetworkAdapter", UCCore.LEGACY_EVENT_INIT, new Class[]{Context.class, HashMap.class}, context, initParams);
            ALog.f(TAG, "init taobao adapter success", null, new Object[0]);
        } catch (Exception e) {
            ALog.f(TAG, "initTaobaoAdapter failed. maybe not taobao app", null, e);
        }
    }

    public static void setTtid(String str) {
        hu0.p(str);
    }

    public static void init(Application application, HashMap<String, Object> hashMap) {
        try {
            hu0.p((String) hashMap.get("ttid"));
            hu0.r((String) hashMap.get("deviceId"));
            String str = (String) hashMap.get("process");
            if (!TextUtils.isEmpty(str)) {
                hu0.m(str);
            }
            initParams = new HashMap<>(hashMap);
            init(application.getApplicationContext());
            initParams = null;
        } catch (Exception e) {
            ALog.d(TAG, "Network SDK initial failed!", null, e, new Object[0]);
        }
    }
}
