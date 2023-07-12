package com.youku.arch.v3.util;

import android.content.Context;
import android.util.LruCache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ResUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final LruCache<String, Integer> sIdCaches = new LruCache<>(32);

    public static int getIdentifier(Context context, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "454971835")) {
            return ((Integer) ipChange.ipc$dispatch("454971835", new Object[]{context, str, str2})).intValue();
        }
        String str3 = str2 + "&" + str;
        LruCache<String, Integer> lruCache = sIdCaches;
        Integer num = lruCache.get(str3);
        if (num != null && num.intValue() > 0) {
            return num.intValue();
        }
        int identifier = context.getResources().getIdentifier(str, str2, context.getClass().getPackage().getName());
        int identifier2 = identifier == 0 ? context.getResources().getIdentifier(str, str2, context.getPackageName()) : identifier;
        if (identifier2 > 0) {
            lruCache.put(str3, Integer.valueOf(identifier2));
            return identifier2;
        }
        return identifier2;
    }
}
