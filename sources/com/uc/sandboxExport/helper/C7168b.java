package com.uc.sandboxExport.helper;

import android.os.Process;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* renamed from: com.uc.sandboxExport.helper.b */
/* loaded from: classes11.dex */
public final class C7168b {
    private static boolean a;
    private static boolean b;
    private static final Object c = new Object();

    public static boolean a() {
        if (!b) {
            synchronized (c) {
                if (!b) {
                    a = b();
                    b = true;
                }
            }
        }
        return a;
    }

    private static boolean b() {
        try {
            Method declaredMethod = Process.class.getDeclaredMethod("isIsolated", new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                if (invoke != null && (invoke instanceof Boolean)) {
                    return ((Boolean) invoke).booleanValue();
                }
            }
        } catch (Throwable unused) {
        }
        int myUid = Process.myUid() % 100000;
        return myUid >= 99000 && myUid <= 99999;
    }
}
