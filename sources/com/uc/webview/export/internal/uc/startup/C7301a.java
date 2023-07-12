package com.uc.webview.export.internal.uc.startup;

import android.content.Context;
import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.internal.interfaces.InvokeObject;
import com.uc.webview.export.internal.setup.af;
import com.uc.webview.export.internal.uc.CoreFactory;
import com.uc.webview.export.internal.utility.C7329e;
import com.uc.webview.export.internal.utility.C7343m;
import com.uc.webview.export.internal.utility.C7345n;
import com.uc.webview.export.internal.utility.ReflectionUtil;
import java.util.HashMap;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.uc.startup.a */
/* loaded from: classes11.dex */
public final class C7301a implements InvokeObject {
    private static final C7301a a = new C7301a();
    private static InvokeObject b = null;

    public static synchronized void a() {
        synchronized (C7301a.class) {
            if (b != null) {
                return;
            }
            b = (InvokeObject) ReflectionUtil.invoke(Class.forName("com.uc.sdk_glue.StartupBridge", true, af.e()), "doBridge", new Class[]{InvokeObject.class}, new Object[]{a});
            if (b()) {
                C7329e.a();
            }
        }
    }

    public static boolean b() {
        return b != null;
    }

    @Override // com.uc.webview.export.internal.interfaces.InvokeObject
    public final Object invoke(int i, Object[] objArr) {
        try {
            switch (i) {
                case 9100:
                    C7345n.a((Runnable) objArr[0]);
                    break;
                case 9101:
                    a((String) objArr[0], (String) objArr[1], (Throwable) objArr[2]);
                    break;
                case 9102:
                    Integer num = (Integer) objArr[0];
                    if (objArr.length == 1) {
                        C7302b.a(num.intValue());
                        break;
                    } else {
                        C7302b.a(num.intValue(), (String) objArr[1]);
                        break;
                    }
                case 9103:
                    return C7302b.c();
                case 9104:
                    Integer num2 = (Integer) objArr[0];
                    if (num2 != null) {
                        af.a(num2.intValue());
                        break;
                    }
                    break;
                case 9105:
                case 9106:
                    if (af.c != null) {
                        Log.i("sdk.StartupBridge", "UCMPackageInfo:" + af.c.toString());
                    }
                    Log.i("sdk.StartupBridge", "QuickPathInfo:" + C7343m.a(af.a));
                    Log.printAndFlushCachedLogs();
                    break;
                default:
                    a("sdk.StartupBridge", "error methodID:" + i, null);
                    break;
            }
            return null;
        }
    }

    private static Object b(int i, Object[] objArr) {
        try {
            if (i != 9002) {
                a("sdk.StartupBridge", "fallback error no fallback methodID:" + i, null);
            } else {
                a("sdk.StartupBridge", "fallback to corefactroy methodID:" + i, null);
                CoreFactory.initUCMobileWebkitCoreSoEnv((Context) objArr[0], (HashMap) objArr[1]);
            }
        } catch (Throwable unused) {
            a("sdk.StartupBridge", "fallback to corefactroy error. methodID:" + i, null);
        }
        return null;
    }

    public static Object a(int i, Object[] objArr) {
        a("sdk.StartupBridge", "StartupBridge call methodID:" + i, null);
        if (!b()) {
            a("sdk.StartupBridge", "StartupBridge not enable. fallback to corefactroy methodID:" + i, null);
            return b(i, objArr);
        }
        return b.invoke(i, objArr);
    }

    private static void a(String str, String str2, Throwable th) {
        Thread currentThread = Thread.currentThread();
        Log.i("sdk.StartupBridge", jn1.BRACKET_START_STR + currentThread.getId() + " " + currentThread.getName() + ") " + str + "." + str2, th);
    }
}
