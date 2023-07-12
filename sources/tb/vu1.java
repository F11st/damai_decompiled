package tb;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.android.tlog.protocol.Constants;
import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class vu1 {
    private static boolean a;

    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a() {
        /*
            r0 = 0
            java.lang.String r1 = "android.os.SystemProperties"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Exception -> L31
            java.lang.String r2 = "get"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch: java.lang.Exception -> L31
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r6 = 0
            r4[r6] = r5     // Catch: java.lang.Exception -> L31
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch: java.lang.Exception -> L31
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L31
            java.lang.String r4 = "ro.yunos.version"
            r2[r6] = r4     // Catch: java.lang.Exception -> L31
            java.lang.Object r2 = r1.invoke(r0, r2)     // Catch: java.lang.Exception -> L31
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> L31
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L2f
            java.lang.String r4 = "java.vm.name"
            r3[r6] = r4     // Catch: java.lang.Exception -> L2f
            java.lang.Object r1 = r1.invoke(r0, r3)     // Catch: java.lang.Exception -> L2f
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> L2f
            r0 = r1
            goto L36
        L2f:
            r1 = move-exception
            goto L33
        L31:
            r1 = move-exception
            r2 = r0
        L33:
            r1.printStackTrace()
        L36:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L41
            tb.hw0.l = r2
            tb.hw0.k = r0
            goto L54
        L41:
            boolean r0 = d()
            if (r0 == 0) goto L4a
            java.lang.String r0 = "harmony"
            goto L4c
        L4a:
            java.lang.String r0 = "android"
        L4c:
            tb.hw0.k = r0
            java.lang.String r0 = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.VERSION.getRELEASE()
            tb.hw0.l = r0
        L54:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.vu1.a():void");
    }

    public static void b(Context context, Map<String, Object> map) {
        if (a) {
            return;
        }
        a = true;
        uu1.d().e(context);
        c(context, map);
        wu1 wu1Var = wu1.b;
        dq1 dq1Var = uu1.PROCEDURE_MANAGER;
        wu1Var.a(dq1Var);
        aq1.a.a(dq1Var);
        tu1.b.a(uu1.PROCEDURE_FACTORY);
    }

    private static void c(Context context, Map<String, Object> map) {
        hw0.b = context.getPackageName();
        hw0.c = g(map.get("onlineAppKey"), "12278902");
        hw0.d = g(map.get(Constants.KEY_APP_BUILD), "");
        hw0.e = e(map);
        hw0.f = g(map.get("appPatch"), "");
        hw0.g = g(map.get("channel"), "");
        hw0.h = g(map.get("deviceId"), "");
        hw0.i = Build.getBRAND();
        hw0.j = Build.getMODEL();
        a();
        hw0.p = f(map);
        hw0.o = String.valueOf(System.currentTimeMillis());
        hw0.q = g(map.get("ttid"), "");
    }

    public static boolean d() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Method method = cls.getMethod("getOsBrand", new Class[0]);
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader == null || classLoader.getParent() != null) {
                return false;
            }
            return "harmony".equals(method.invoke(cls, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    private static String e(Map<String, Object> map) {
        Object obj = map.get("appVersion");
        if (obj instanceof String) {
            String str = (String) obj;
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        Context a2 = uu1.d().a();
        try {
            return a2.getPackageManager().getPackageInfo(a2.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "unknown";
        }
    }

    private static String f(Map<String, Object> map) {
        Object obj = map.get("process");
        if (obj instanceof String) {
            String str = (String) obj;
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return av1.a();
    }

    private static String g(Object obj, String str) {
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        return str;
    }
}
