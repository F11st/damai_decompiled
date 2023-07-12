package com.taobao.mtop.wvplugin;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.taobao.windvane.jsbridge.WindVaneInterface;
import mtopsdk.common.util.TBSdkLog;
import tb.C10007z;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MtopWVPlugin extends WVApiPlugin {
    public static final String API_SERVER_NAME = "MtopWVPlugin";
    public static final String ERR_SID_INVALID = "ERR_SID_INVALID";
    public static final String FAIL = "HY_FAILED";
    public static final String PARAM_ERR = "HY_PARAM_ERR";
    private static final String TAG = "mtopsdk.MtopWVPlugin";
    public static final String TIME_OUT = "MP_TIME_OUT";
    private MtopBridge mtopBridge = new MtopBridge(this);
    private C10007z aNetBridge = new C10007z();

    public static void register() {
        WVPluginManager.registerPlugin(API_SERVER_NAME, (Class<? extends WVApiPlugin>) MtopWVPlugin.class);
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, "register MtopWVPlugin succeed!");
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("send".equals(str)) {
            send(wVCallBackContext, str2);
            return true;
        } else if ("sendANet".equals(str)) {
            this.aNetBridge.d(wVCallBackContext, str2);
            return true;
        } else {
            return false;
        }
    }

    public String getCurrentUrl() {
        try {
            return this.mWebView.getUrl();
        } catch (Exception unused) {
            return "";
        }
    }

    public String getUserAgent() {
        try {
            return this.mWebView.getUserAgentString();
        } catch (Exception unused) {
            return "";
        }
    }

    @WindVaneInterface
    public void send(WVCallBackContext wVCallBackContext, String str) {
        this.mtopBridge.i(wVCallBackContext, str);
    }

    public void wvCallback(C6824b c6824b) {
        if (c6824b.d()) {
            c6824b.c().success(c6824b.toString());
        } else {
            c6824b.c().error(c6824b.toString());
        }
        c6824b.f(null);
    }
}
