package com.youku.asyncview.utils;

import android.os.Looper;
import java.lang.reflect.Field;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class ThreadUtil {
    public static void forceSetMainLoop() {
        try {
            Field declaredField = Looper.class.getDeclaredField("sThreadLocal");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(Looper.getMainLooper());
            if (obj instanceof ThreadLocal) {
                ((ThreadLocal) obj).set(Looper.getMainLooper());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
