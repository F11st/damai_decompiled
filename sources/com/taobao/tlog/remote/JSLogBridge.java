package com.taobao.tlog.remote;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class JSLogBridge extends WVApiPlugin {
    private static final String GETLOGLEVEL = "getLogLevel";
    private static final String LOGD = "logd";
    private static final String LOGE = "loge";
    private static final String LOGI = "logi";
    private static final String LOGV = "logv";
    private static final String LOGW = "logw";
    private static final String tlogBridgeName = "tlogBridge";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class LogBody {
        String data;
        String module;
        String tag;

        LogBody() {
        }
    }

    private LogBody getLog(String str) {
        try {
            LogBody logBody = new LogBody();
            JSONObject jSONObject = new JSONObject(str);
            logBody.tag = jSONObject.optString("tag", "jsTag");
            logBody.data = jSONObject.optString("content", "");
            return logBody;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static void init() {
        WVPluginManager.registerPlugin(tlogBridgeName, (Class<? extends WVApiPlugin>) JSLogBridge.class, true);
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (!TextUtils.isEmpty(str) && wVCallBackContext != null) {
            if (GETLOGLEVEL.equals(str)) {
                WVResult wVResult = new WVResult();
                wVResult.addData("logLevel", AdapterForTLog.getLogLevel());
                wVCallBackContext.success(wVResult);
                return true;
            } else if (LOGV.equals(str)) {
                logv(str2, wVCallBackContext);
                return true;
            } else if (LOGD.equals(str)) {
                logd(str2, wVCallBackContext);
                return true;
            } else if (LOGI.equals(str)) {
                logi(str2, wVCallBackContext);
                return true;
            } else if (LOGW.equals(str)) {
                logw(str2, wVCallBackContext);
                return true;
            } else if (LOGE.equals(str)) {
                loge(str2, wVCallBackContext);
                return true;
            }
        }
        return false;
    }

    public void logd(String str, WVCallBackContext wVCallBackContext) {
        LogBody log = getLog(str);
        if (log != null) {
            AdapterForTLog.logd(log.tag, str);
            wVCallBackContext.success();
            return;
        }
        wVCallBackContext.error("the tag is null!");
    }

    public void loge(String str, WVCallBackContext wVCallBackContext) {
        LogBody log = getLog(str);
        if (log != null) {
            AdapterForTLog.loge(log.tag, str);
            wVCallBackContext.success();
            return;
        }
        wVCallBackContext.error("the tag is null!");
    }

    public void logi(String str, WVCallBackContext wVCallBackContext) {
        LogBody log = getLog(str);
        if (log != null) {
            AdapterForTLog.logi(log.tag, str);
            wVCallBackContext.success();
            return;
        }
        wVCallBackContext.error("the tag is null!");
    }

    public void logv(String str, WVCallBackContext wVCallBackContext) {
        LogBody log = getLog(str);
        if (log != null) {
            AdapterForTLog.logv(log.tag, str);
            wVCallBackContext.success();
            return;
        }
        wVCallBackContext.error("the tag is null!");
    }

    public void logw(String str, WVCallBackContext wVCallBackContext) {
        LogBody log = getLog(str);
        if (log != null) {
            AdapterForTLog.logw(log.tag, str);
            wVCallBackContext.success();
            return;
        }
        wVCallBackContext.error("the tag is null!");
    }
}
