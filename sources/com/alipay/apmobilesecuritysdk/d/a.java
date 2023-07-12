package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class a {
    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        HashMap hashMap;
        synchronized (a.class) {
            String a = com.alipay.sdk.m.z.a.a(map, "appchannel", "");
            hashMap = new HashMap();
            hashMap.put("AA1", context.getPackageName());
            com.alipay.sdk.m.a0.a.a();
            hashMap.put("AA2", com.alipay.sdk.m.a0.a.a(context));
            hashMap.put("AA3", "APPSecuritySDK-ALIPAYSDK");
            hashMap.put("AA4", "3.4.0.202206130311");
            hashMap.put("AA6", a);
        }
        return hashMap;
    }
}
