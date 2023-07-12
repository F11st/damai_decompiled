package com.huawei.hms.aaid.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.opendevice.AbstractC5657b;
import com.huawei.hms.opendevice.AbstractC5659d;
import com.huawei.hms.opendevice.AbstractC5661e;
import com.huawei.hms.opendevice.AbstractC5674p;
import com.huawei.hms.opendevice.C5665i;
import com.huawei.hms.opendevice.C5670n;
import com.huawei.hms.support.log.HMSLog;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class BaseUtils {
    public static void clearSubjectIds(Context context) {
        C5665i.a(context).removeKey("subjectId");
    }

    public static void delLocalToken(Context context, String str) {
        C5665i.a(context).c(str);
    }

    public static void deleteAllTokenCache(Context context) {
        C5665i.a(context).a();
    }

    public static void deleteCacheData(Context context, String str) {
        C5665i.a(context).removeKey(str);
    }

    public static String getBaseUrl(Context context, String str, String str2, String str3, String str4) {
        return AbstractC5661e.a(context, str, str2, str3, str4);
    }

    public static String getCacheData(Context context, String str, boolean z) {
        if (z) {
            return C5665i.a(context).a(str);
        }
        return C5665i.a(context).getString(str);
    }

    public static String getLocalToken(Context context, String str) {
        return C5665i.a(context).b(str);
    }

    public static boolean getProxyInit(Context context) {
        return C5665i.a(context).getBoolean("_proxy_init");
    }

    public static String[] getSubjectIds(Context context) {
        String string = C5665i.a(context).getString("subjectId");
        return TextUtils.isEmpty(string) ? new String[0] : string.split(",");
    }

    public static void initSecret(Context context) {
        AbstractC5657b.a(context);
    }

    public static boolean isMainProc(Context context) {
        String a = AbstractC5674p.a(context);
        String str = context.getApplicationInfo().processName;
        HMSLog.i("BaseUtils", "main process name: " + str + ", current process name: " + a);
        return str.equals(a);
    }

    public static void reportAaidToken(Context context, String str) {
        C5670n.a(context, str);
    }

    public static boolean saveCacheData(Context context, String str, String str2, boolean z) {
        if (z) {
            return C5665i.a(context).a(str, str2);
        }
        return C5665i.a(context).saveString(str, str2);
    }

    public static void saveProxyInit(Context context, boolean z) {
        C5665i.a(context).saveBoolean("_proxy_init", z);
    }

    public static void saveToken(Context context, String str, String str2) {
        C5665i.a(context).b(str, str2);
    }

    public static String sendPostRequest(Context context, String str, String str2, Map<String, String> map) {
        return AbstractC5659d.a(context, str, str2, map);
    }
}
