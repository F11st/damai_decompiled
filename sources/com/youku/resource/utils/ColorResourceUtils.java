package com.youku.resource.utils;

import android.content.Context;
import android.graphics.Color;
import androidx.collection.LruCache;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ColorResourceUtils {
    public static int color_99000000 = Color.parseColor("#99000000");
    public static int color_e6f92253 = Color.parseColor("#e6f92253");
    private static LruCache<Integer, Integer> sColors = new LruCache<>(100);
    private static int DefColor = Color.parseColor("#66000000");

    public static int getColorByDef(Context context, int i) {
        return getColorByDef(context, i, DefColor);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r0.intValue() == 0) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getColorByDef(android.content.Context r2, int r3, int r4) {
        /*
            if (r2 != 0) goto L3
            return r4
        L3:
            androidx.collection.LruCache<java.lang.Integer, java.lang.Integer> r0 = com.youku.resource.utils.ColorResourceUtils.sColors
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            java.lang.Object r0 = r0.get(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 == 0) goto L17
            int r1 = r0.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L33
            if (r1 != 0) goto L23
        L17:
            android.content.res.Resources r2 = r2.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L33
            int r2 = r2.getColor(r3)     // Catch: android.content.res.Resources.NotFoundException -> L33
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)     // Catch: android.content.res.Resources.NotFoundException -> L33
        L23:
            int r2 = r0.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L33
            if (r2 == 0) goto L3b
            androidx.collection.LruCache<java.lang.Integer, java.lang.Integer> r2 = com.youku.resource.utils.ColorResourceUtils.sColors     // Catch: android.content.res.Resources.NotFoundException -> L33
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.content.res.Resources.NotFoundException -> L33
            r2.put(r3, r0)     // Catch: android.content.res.Resources.NotFoundException -> L33
            goto L3b
        L33:
            r2 = move-exception
            r2.printStackTrace()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
        L3b:
            int r2 = r0.intValue()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.resource.utils.ColorResourceUtils.getColorByDef(android.content.Context, int, int):int");
    }
}
