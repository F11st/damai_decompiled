package com.taobao.tlog.remote;

import android.preference.PreferenceManager;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVPluginManager;
import androidx.annotation.Keep;
import com.taobao.tao.log.TLogConstant;
import com.taobao.tao.log.TLogInitializer;
import org.json.JSONObject;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class TLogJSBridage extends WVApiPlugin {
    public static void init() {
        try {
            WVPluginManager.registerPlugin("TLogJSBridage", (Class<? extends WVApiPlugin>) TLogJSBridage.class);
            TLogDiagnose.init();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("toLogcat".equals(str)) {
            toLogcat(str2, wVCallBackContext);
            return true;
        }
        return false;
    }

    public void toLogcat(String str, WVCallBackContext wVCallBackContext) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean z = jSONObject.getBoolean("logcat");
            boolean z2 = jSONObject.getBoolean("restart");
            TLogInitializer.getInstance().setDebugMode(z);
            if (z2) {
                PreferenceManager.getDefaultSharedPreferences(TLogInitializer.getInstance().getContext().getApplicationContext()).edit().putBoolean(TLogConstant.TLOG_IS_DEBUG, z).commit();
            }
            wVCallBackContext.success();
        } catch (Exception e) {
            e.printStackTrace();
            wVCallBackContext.error();
        }
    }
}
