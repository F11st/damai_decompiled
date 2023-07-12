package com.alibaba.motu.crashreporter.utrestapi;

import android.content.Context;
import com.alibaba.motu.crashreporter.Constants;
import com.alibaba.motu.crashreporter.LogUtil;
import com.alibaba.motu.crashreporter2.CrashReporter;
import com.alibaba.motu.tbrest.SendService;
import com.alibaba.motu.tbrest.utils.StringUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class UTRestReq {
    public static boolean sendLog(Context context, String str, int i, Object obj, Object obj2, Object obj3, Map<String, Object> map) {
        try {
            HashMap hashMap = new HashMap();
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    try {
                        hashMap.put(entry.getKey(), entry.getValue().toString());
                    } catch (Exception e) {
                        LogUtil.w("build extData", e);
                    }
                }
            }
            return sendLog(context, System.currentTimeMillis(), str, i, obj, obj2, obj3, hashMap);
        } catch (Exception e2) {
            LogUtil.e("sendLog", e2);
            return false;
        }
    }

    public static String sendLogByUrl(String str, Context context, long j, String str2, int i, Object obj, Object obj2, Object obj3, Map<String, String> map) {
        if (str == null) {
            return "url is null";
        }
        try {
            return StringUtils.isBlank(CrashReporter.getInstance().getProperty(Constants.APP_KEY)) ? "no appkey" : StringUtils.isBlank(CrashReporter.getInstance().getProperty(Constants.APP_VERSION)) ? "no appVersion" : SendService.getInstance().sendRequestByUrl(str, j, str2, i, obj, obj2, obj3, map);
        } catch (Exception e) {
            LogUtil.e("sendLogByUrl", e);
            return null;
        }
    }

    public static boolean sendLog(Context context, long j, String str, int i, Object obj, Object obj2, Object obj3, Map<String, String> map) {
        try {
            if (StringUtils.isBlank(CrashReporter.getInstance().getProperty(Constants.APP_KEY)) || StringUtils.isBlank(CrashReporter.getInstance().getProperty(Constants.APP_VERSION))) {
                return false;
            }
            return SendService.getInstance().sendRequest(null, j, str, i, obj, obj2, obj3, map).booleanValue();
        } catch (Exception e) {
            LogUtil.e("sendLog", e);
            return false;
        }
    }
}
