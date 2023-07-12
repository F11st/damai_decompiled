package com.youku.css.util;

import android.content.Context;
import android.util.LruCache;
import com.youku.arch.v3.data.Constants;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DimenUtils {
    private static LruCache<String, Integer> sIdCaches = new LruCache<>(32);

    public static int getIdentifier(Context context, String str) {
        String str2 = Constants.DIMEN + "&" + str;
        Integer num = sIdCaches.get(str2);
        if (num != null && num.intValue() > 0) {
            return num.intValue();
        }
        int identifier = context.getResources().getIdentifier(str, Constants.DIMEN, context.getClass().getPackage().getName());
        int identifier2 = identifier == 0 ? context.getResources().getIdentifier(str, Constants.DIMEN, context.getPackageName()) : identifier;
        if (identifier2 > 0) {
            sIdCaches.put(str2, Integer.valueOf(identifier2));
            return identifier2;
        }
        return identifier2;
    }
}
