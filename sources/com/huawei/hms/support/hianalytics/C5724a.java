package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.support.hianalytics.a */
/* loaded from: classes10.dex */
public class C5724a {
    /* JADX INFO: Access modifiers changed from: protected */
    public static Map<String, String> getMapForBi(Context context, String str) {
        HashMap hashMap = new HashMap();
        if (context != null && !TextUtils.isEmpty(str)) {
            String[] split = str.split("\\.");
            if (split.length >= 2) {
                String str2 = split[0];
                String str3 = split[1];
                hashMap.put("service", str2);
                hashMap.put("apiName", str3);
                hashMap.put("package", context.getPackageName());
                hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.4.0.302");
                hashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
            }
        }
        return hashMap;
    }
}
