package com.uc.webview.export.internal.utility;

import android.os.Bundle;
import com.uc.crashsdk.export.CrashApi;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class d {
    private static Class a;
    private static Object b;
    private static Method c;
    private static Method d;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a {
        Throwable c;
        boolean a = true;
        boolean b = false;
        ArrayList<String> d = new ArrayList<>(9);
        ArrayList<String> e = new ArrayList<>(5);

        public a(String str, Throwable th) {
            a("k_ct", "exception");
            a("k_ac", str);
            this.c = th;
        }

        public final a a(String str, String str2) {
            ArrayList<String> arrayList = this.d;
            arrayList.add(str + ": " + str2);
            return this;
        }

        public final a b(String str, String str2) {
            ArrayList<String> arrayList = this.e;
            arrayList.add(str + ":\n" + str2);
            return this;
        }
    }

    public static void a(String str, String str2) {
        Method b2;
        try {
            Object a2 = a();
            if (a2 == null || (b2 = b()) == null) {
                return;
            }
            b2.invoke(a2, str, str2);
            com.uc.webview.export.cyclone.Log.d("CrashSdkUtils", "addHeaderInfo " + str + "=" + str2);
        } catch (Throwable th) {
            com.uc.webview.export.cyclone.Log.w("CrashSdkUtils", "addHeaderInfo failed", th);
        }
    }

    private static synchronized Method b() throws Exception {
        Method method;
        synchronized (d.class) {
            if (c == null) {
                c = ReflectionUtil.getMethod(a, "addHeaderInfo", String.class, String.class);
            }
            method = c;
        }
        return method;
    }

    private static synchronized Method c() throws Exception {
        Method method;
        synchronized (d.class) {
            if (d == null) {
                d = ReflectionUtil.getMethod(a, "generateCustomLog", StringBuffer.class, String.class, Bundle.class);
            }
            method = d;
        }
        return method;
    }

    public static void a(a aVar) {
        Method c2;
        try {
            Object a2 = a();
            if (a2 == null || (c2 = c()) == null) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<String> it = aVar.d.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next());
                stringBuffer.append(StringUtils.LF);
            }
            stringBuffer.append("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\nException message:\nBack traces starts.\n");
            stringBuffer.append(com.uc.webview.export.cyclone.Log.getStackTraceString(aVar.c));
            stringBuffer.append("Back traces ends.\n");
            Iterator<String> it2 = aVar.e.iterator();
            while (it2.hasNext()) {
                stringBuffer.append("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                stringBuffer.append(it2.next());
                stringBuffer.append(StringUtils.LF);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("mAddLogcat", aVar.a);
            bundle.putBoolean("mUploadNow", aVar.b);
            bundle.putBoolean("mAddThreadsDump", true);
            bundle.putBoolean("mAddBuildId", true);
            c2.invoke(a2, stringBuffer, "exception", bundle);
            com.uc.webview.export.cyclone.Log.d("CrashSdkUtils", "generateCustomeLogInfo size:" + stringBuffer.length());
        } catch (Throwable th) {
            com.uc.webview.export.cyclone.Log.rInfo("CrashSdkUtils", "generateCustomeLogInfo failed", th);
        }
    }

    private static synchronized Object a() throws Exception {
        Object obj;
        synchronized (d.class) {
            if (b == null) {
                if (a == null) {
                    int i = CrashApi.e;
                    a = CrashApi.class;
                }
                b = ReflectionUtil.invoke((Class<?>) a, "getInstance", (Class[]) null, (Object[]) null);
            }
            obj = b;
        }
        return obj;
    }
}
