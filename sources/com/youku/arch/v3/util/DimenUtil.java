package com.youku.arch.v3.util;

import android.content.Context;
import androidx.annotation.DimenRes;
import androidx.collection.LruCache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class DimenUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final LruCache<Integer, Integer> sDimens = new LruCache<>(100);
    private static final LruCache<String, Integer> sIdCaches = new LruCache<>(32);

    private DimenUtil() {
    }

    public static int getDimensionPixelSize(Context context, @DimenRes int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1461883111") ? ((Integer) ipChange.ipc$dispatch("-1461883111", new Object[]{context, Integer.valueOf(i)})).intValue() : getDimensionPixelSize(context, i, 0);
    }

    public static int getIdentifier(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1295055166")) {
            return ((Integer) ipChange.ipc$dispatch("-1295055166", new Object[]{context, str})).intValue();
        }
        String str2 = Constants.DIMEN + "&" + str;
        LruCache<String, Integer> lruCache = sIdCaches;
        Integer num = lruCache.get(str2);
        if (num != null && num.intValue() > 0) {
            return num.intValue();
        }
        int identifier = context.getResources().getIdentifier(str, Constants.DIMEN, context.getClass().getPackage().getName());
        int identifier2 = identifier == 0 ? context.getResources().getIdentifier(str, Constants.DIMEN, context.getPackageName()) : identifier;
        if (identifier2 > 0) {
            lruCache.put(str2, Integer.valueOf(identifier2));
            return identifier2;
        }
        return identifier2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
        if (r1.intValue() == 0) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getDimensionPixelSize(android.content.Context r4, @androidx.annotation.DimenRes int r5, int r6) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.arch.v3.util.DimenUtil.$ipChange
            java.lang.String r1 = "1926293648"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L29
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            r4 = 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r2[r4] = r5
            r4 = 2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            r2[r4] = r5
            java.lang.Object r4 = r0.ipc$dispatch(r1, r2)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            return r4
        L29:
            if (r4 != 0) goto L2c
            return r6
        L2c:
            androidx.collection.LruCache<java.lang.Integer, java.lang.Integer> r0 = com.youku.arch.v3.util.DimenUtil.sDimens
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            java.lang.Object r1 = r0.get(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            if (r1 == 0) goto L40
            int r2 = r1.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L5a
            if (r2 != 0) goto L4c
        L40:
            android.content.res.Resources r4 = r4.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L5a
            int r4 = r4.getDimensionPixelSize(r5)     // Catch: android.content.res.Resources.NotFoundException -> L5a
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch: android.content.res.Resources.NotFoundException -> L5a
        L4c:
            int r4 = r1.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L5a
            if (r4 == 0) goto L62
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch: android.content.res.Resources.NotFoundException -> L5a
            r0.put(r4, r1)     // Catch: android.content.res.Resources.NotFoundException -> L5a
            goto L62
        L5a:
            r4 = move-exception
            r4.printStackTrace()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
        L62:
            int r4 = r1.intValue()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.v3.util.DimenUtil.getDimensionPixelSize(android.content.Context, int, int):int");
    }
}
