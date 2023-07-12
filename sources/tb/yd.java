package tb;

import android.content.Context;
import android.content.pm.PackageManager;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class yd {
    private static volatile Boolean a;

    private static synchronized boolean a(Context context) {
        boolean booleanValue;
        synchronized (yd.class) {
            if (a == null) {
                try {
                    a = Boolean.valueOf(sc2.b(context.getPackageManager().getPackageInfo(context.getPackageName(), 64), sc2.BLAZE_DEBUG_SIGNATURE, sc2.ANDROID_DEBUG_SIGNATURE, sc2.VRCORE_DEBUG_SIGNATURE));
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalStateException("Unable to find self package info", e);
                }
            }
            booleanValue = a.booleanValue();
        }
        return booleanValue;
    }

    public static boolean b(Context context) {
        return a != null ? a.booleanValue() : a(context);
    }
}
