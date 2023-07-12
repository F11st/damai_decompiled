package com.alient.resource.util;

import android.content.Context;
import android.util.LruCache;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ResUtil {
    private static final LruCache<String, Integer> sIdCaches = new LruCache<>(32);

    public static int getIdentifier(Context context, String str, String str2) {
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
