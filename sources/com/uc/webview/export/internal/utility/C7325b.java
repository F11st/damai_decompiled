package com.uc.webview.export.internal.utility;

import com.taobao.weex.annotation.JSMethod;
import com.uc.webview.export.Build;
import com.uc.webview.export.internal.uc.startup.C7301a;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.utility.b */
/* loaded from: classes11.dex */
public final class C7325b {
    private static final AtomicBoolean a = new AtomicBoolean(false);
    private static String b = null;
    private static String c = null;
    private static int d = 0;
    private static String e = null;
    private static String f = null;

    public static String a() {
        d();
        return e;
    }

    public static String b() {
        d();
        return f;
    }

    public static void c() {
        d();
        String str = b;
        if (str != null) {
            Build.UCM_VERSION = str;
        }
        String str2 = c;
        if (str2 != null) {
            Build.UCM_SUPPORT_SDK_MIN = str2;
        }
        int i = d;
        if (i != 0) {
            Build.Version.API_LEVEL = i;
        }
        String str3 = e;
        if (str3 != null) {
            Build.CORE_VERSION = str3;
        }
        String str4 = f;
        if (str4 != null) {
            Build.CORE_TIME = str4;
        }
        C7327d.a("ucBuildVersion", String.format("ucbs %s.%s-impl %s.%s", Build.Version.NAME, Build.TIME, Build.UCM_VERSION, Build.CORE_TIME));
        com.uc.webview.export.cyclone.Log.d("BuildInfo", "updateUCMBuildInfo {\n   ucbs: " + Build.Version.NAME + JSMethod.NOT_SET + Build.TIME + "\n   impl: " + Build.UCM_VERSION + JSMethod.NOT_SET + Build.CORE_TIME + "\n   apiLevel: " + Build.Version.API_LEVEL + "\n   minSupport: " + Build.UCM_SUPPORT_SDK_MIN + "\n}");
    }

    private static void d() {
        AtomicBoolean atomicBoolean = a;
        if (atomicBoolean.get()) {
            return;
        }
        synchronized (atomicBoolean) {
            if (atomicBoolean.get()) {
                return;
            }
            Object[] objArr = (Object[]) C7301a.a(9011, null);
            if (objArr == null) {
                return;
            }
            b = (String) objArr[0];
            c = (String) objArr[1];
            d = ((Integer) objArr[2]).intValue();
            e = (String) objArr[3];
            f = (String) objArr[4];
            atomicBoolean.set(true);
        }
    }
}
