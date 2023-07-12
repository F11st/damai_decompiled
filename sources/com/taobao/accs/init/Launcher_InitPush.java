package com.taobao.accs.init;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.ut.monitor.ManuMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.weex.adapter.URIAdapter;
import com.uc.webview.export.extension.UCCore;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.huawei.HuaWeiRegister;
import org.android.agoo.mezu.MeizuRegister;
import org.android.agoo.oppo.OppoRegister;
import org.android.agoo.vivo.VivoRegister;
import org.android.agoo.xiaomi.MiPushRegistar;
import tb.x6;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class Launcher_InitPush implements Serializable {
    private static final String MEIZU_APPID = "111373";
    private static final String MEIZU_APPKEY = "9c3cf30192a540eebbca03572d877ac5";
    private static final String OPPO_APPKEY = "X4PFm4rhiaASckCkqYSIIqA1";
    private static final String OPPO_APPSECRET = "6ZHzxPVPl2kLpMF8Ht2gmmfc";
    private static final String TAG = "Launcher_InitPush";
    private static final String XIAOMI_APPID = "2882303761517135997";
    private static final String XIAOMI_APPKEY = "5491713541997";
    private static final boolean isHMS;
    public static final ManuMonitor manuMonitor = new ManuMonitor();
    private static boolean reported = false;

    static {
        boolean z = false;
        String brand = Build.getBRAND();
        isHMS = (brand.equalsIgnoreCase("huawei") || brand.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_HONOR) || "tianyi".equalsIgnoreCase(brand) || "liantong".equalsIgnoreCase(brand)) ? true : true;
    }

    public static void init(Application application, HashMap<String, Object> hashMap) {
        ALog.e(TAG, UCCore.LEGACY_EVENT_INIT, new Object[0]);
        initInner(application);
    }

    private static void initHuaWei(Application application) {
        HuaWeiRegister.registerBundle(application, true);
    }

    private static void initInner(Application application) {
        monitorPush(application);
        if (isHMS) {
            initHuaWei(application);
        } else {
            initXiaoMi(application);
        }
    }

    private static void initXiaoMi(Application application) {
        MiPushRegistar.register(application, XIAOMI_APPID, XIAOMI_APPKEY);
        OppoRegister.register(application, OPPO_APPKEY, OPPO_APPSECRET);
        MeizuRegister.register(application, MEIZU_APPID, MEIZU_APPKEY);
        VivoRegister.register(application);
    }

    public static void monitorNow(Context context) {
        if (reported) {
            return;
        }
        reported = true;
        try {
            x6.b().commitStat(manuMonitor);
            context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit().putInt(Constants.KEY_TOKEN_REPORT_STATUS, 0).apply();
        } catch (Exception e) {
            ALog.e(TAG, "monitorNow err", e, new Object[0]);
        }
    }

    public static void monitorPush(final Context context) {
        ManuMonitor manuMonitor2 = manuMonitor;
        manuMonitor2.sdk = isHMS ? "huawei" : URIAdapter.OTHERS;
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SP_FILE_NAME, 0);
        if (sharedPreferences.getInt(Constants.KEY_TOKEN_REPORT_STATUS, 0) > 0) {
            x6.b().commitStat(new ManuMonitor(manuMonitor2.sdk, true));
        }
        sharedPreferences.edit().putInt(Constants.KEY_TOKEN_REPORT_STATUS, 1).apply();
        ThreadPoolExecutorFactory.getSendScheduledExecutor().schedule(new Runnable() { // from class: com.taobao.accs.init.Launcher_InitPush.1
            @Override // java.lang.Runnable
            public void run() {
                if (Launcher_InitPush.isHMS && !AdapterUtilityImpl.isTaobao(context)) {
                    Launcher_InitPush.manuMonitor.isDeviceSupport = AdapterUtilityImpl.isSupportHMS(context);
                }
                Launcher_InitPush.monitorNow(context);
            }
        }, 30L, TimeUnit.SECONDS);
    }
}
