package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.sdk.m.a0.C4138a;
import com.alipay.sdk.m.z.C4368a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.alipay.apmobilesecuritysdk.d.a */
/* loaded from: classes12.dex */
public final class C4100a {
    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        HashMap hashMap;
        synchronized (C4100a.class) {
            String a = C4368a.a(map, "appchannel", "");
            hashMap = new HashMap();
            hashMap.put("AA1", context.getPackageName());
            C4138a.a();
            hashMap.put("AA2", C4138a.a(context));
            hashMap.put("AA3", "APPSecuritySDK-ALIPAYSDK");
            hashMap.put("AA4", "3.4.0.202206130311");
            hashMap.put("AA6", a);
        }
        return hashMap;
    }
}
