package cn.damai.common;

import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.os.Process;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.Iterator;
import java.util.List;
import tb.cb1;
import tb.fd;
import tb.qw2;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class AppConfig {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String AUTHORITY = "cn.damai.android.envsetting.SettingProvider";
    public static final String DEBUG_TAG = "logger";
    public static final String DISCOVER_SWITCH = "discoverNative";
    public static final String ORANGE_CONFIT_IMAGE_PHENIX = "damai_image_android_phenix";
    public static final String TICKLET_LOCAL_DATA_DEFAULT = "tickletLocalSwtich";
    public static final String TICKLET_LOCAL_DATA_NAMESPACE = "ticklet_local_data_switch";
    private static String a;
    private static int b;
    private static String c;
    private static String d;
    private static String e;
    private static EnvMode f;
    private static EnvMode g;
    private static String h;
    private static String i;
    private static Boolean j;
    private static Boolean k;
    public static String[] l;
    public static String m;
    public static String n;
    private static String o;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum EnvMode {
        online,
        prepare,
        test
    }

    static {
        Uri.parse("content://cn.damai.android.envsetting.SettingProvider/informations");
        EnvMode envMode = EnvMode.online;
        f = envMode;
        g = envMode;
        j = Boolean.FALSE;
        k = Boolean.TRUE;
    }

    public static String a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1806357867")) {
            return (String) ipChange.ipc$dispatch("1806357867", new Object[]{str});
        }
        try {
            String[] split = str.split(".");
            if (split.length > 4) {
                str = split[0];
                for (int i2 = 1; i2 < 4; i2++) {
                    str = str + "." + split[i2];
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        System.out.println(str);
        return str;
    }

    public static String b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-95961777") ? (String) ipChange.ipc$dispatch("-95961777", new Object[0]) : e;
    }

    public static String c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-878653983")) {
            return (String) ipChange.ipc$dispatch("-878653983", new Object[0]);
        }
        if (!v()) {
            return h;
        }
        return d;
    }

    private static String d(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1688045918")) {
            return (String) ipChange.ipc$dispatch("1688045918", new Object[]{context});
        }
        if ("true".equals(OrangeConfigCenter.c().b("damai_oneservice_switch", "AppInfoProvider", "false"))) {
            return AppInfoProviderProxy.getVersionName();
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            Log.w("AppConfig", th);
            return null;
        }
    }

    private static int e(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1920369534")) {
            return ((Integer) ipChange.ipc$dispatch("-1920369534", new Object[]{context})).intValue();
        }
        if ("true".equals(OrangeConfigCenter.c().b("damai_oneservice_switch", "AppInfoProvider", "false"))) {
            return AppInfoProviderProxy.getVersionCode();
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Throwable th) {
            Log.w("AppConfig", th);
            return -1;
        }
    }

    public static String f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1169435793") ? (String) ipChange.ipc$dispatch("-1169435793", new Object[0]) : i;
    }

    public static EnvMode g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "903395051") ? (EnvMode) ipChange.ipc$dispatch("903395051", new Object[0]) : f;
    }

    public static EnvMode h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1046523688") ? (EnvMode) ipChange.ipc$dispatch("-1046523688", new Object[0]) : g;
    }

    public static Boolean i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "344406962") ? (Boolean) ipChange.ipc$dispatch("344406962", new Object[0]) : k;
    }

    public static String j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1675670694") ? (String) ipChange.ipc$dispatch("-1675670694", new Object[0]) : "damai_android";
    }

    public static String k() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2146950463") ? (String) ipChange.ipc$dispatch("2146950463", new Object[0]) : h;
    }

    public static String l() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1645129411") ? (String) ipChange.ipc$dispatch("-1645129411", new Object[0]) : m;
    }

    public static String m() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1584835995") ? (String) ipChange.ipc$dispatch("-1584835995", new Object[0]) : n;
    }

    public static String n(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1389043637")) {
            return (String) ipChange.ipc$dispatch("-1389043637", new Object[]{context});
        }
        String str = o;
        if (str != null && str.length() > 0) {
            return o;
        }
        if ("true".equals(OrangeConfigCenter.c().b("damai_oneservice_switch", "AppInfoProvider", "true"))) {
            o = AppInfoProviderProxy.getCurrentProcessName();
        }
        String str2 = o;
        if ((str2 == null || str2.length() == 0) && context != null) {
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == myPid) {
                        o = next.processName;
                        break;
                    }
                }
            }
        }
        return o;
    }

    private static String o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1311031304")) {
            return (String) ipChange.ipc$dispatch("1311031304", new Object[0]);
        }
        return c + "@damai_android_" + q();
    }

    public static String p() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "766964350") ? (String) ipChange.ipc$dispatch("766964350", new Object[0]) : o();
    }

    public static String q() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1869228811") ? (String) ipChange.ipc$dispatch("1869228811", new Object[0]) : a;
    }

    public static int r() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "460325115") ? ((Integer) ipChange.ipc$dispatch("460325115", new Object[0])).intValue() : b;
    }

    public static void s(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1393684769")) {
            ipChange.ipc$dispatch("1393684769", new Object[]{context});
            return;
        }
        Boolean valueOf = Boolean.valueOf(u(context));
        j = valueOf;
        cb1.a = valueOf.booleanValue();
        qw2.a = j.booleanValue();
        fd.a = j.booleanValue();
        a = a(d(context));
        b = e(context);
        c = context.getResources().getString(R$string.ttid);
        h = context.getResources().getString(R$string.appkey_release);
        i = context.getResources().getString(R$string.appkey_debug);
        String[] strArr = new String[2];
        l = strArr;
        strArr[0] = context.getResources().getString(R$string.uckey_debug);
        l[1] = context.getResources().getString(R$string.uckey_release);
        m = context.getResources().getString(R$string.passport_appid);
        n = context.getResources().getString(R$string.passport_appscret);
        d = h;
        e = d + "@android";
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void t(android.content.Context r5) {
        /*
            java.lang.String r0 = "0"
            com.android.alibaba.ip.runtime.IpChange r1 = cn.damai.common.AppConfig.$ipChange
            java.lang.String r2 = "101302098"
            boolean r3 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r1, r2)
            r4 = 0
            if (r3 == 0) goto L16
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r4] = r5
            r1.ipc$dispatch(r2, r0)
            return
        L16:
            boolean r1 = v()
            if (r1 != 0) goto L28
            java.lang.String r5 = cn.damai.common.AppConfig.h
            cn.damai.common.AppConfig.d = r5
            cn.damai.common.AppConfig$EnvMode r5 = cn.damai.common.AppConfig.EnvMode.online
            cn.damai.common.AppConfig.f = r5
            cn.damai.common.AppConfig.g = r5
            goto Lc5
        L28:
            java.lang.String r1 = "AppConfig"
            java.lang.String r2 = "initEnv: debug "
            android.util.Log.d(r1, r2)
            java.lang.String r2 = cn.damai.common.AppConfig.h
            cn.damai.common.AppConfig.d = r2
            java.lang.String r2 = "popcorn"
            android.content.SharedPreferences r5 = r5.getSharedPreferences(r2, r4)     // Catch: java.lang.Exception -> L48
            java.lang.String r2 = "env"
            java.lang.String r2 = r5.getString(r2, r0)     // Catch: java.lang.Exception -> L48
            java.lang.String r3 = "h5env"
            java.lang.String r0 = r5.getString(r3, r0)     // Catch: java.lang.Exception -> L46
            goto L4d
        L46:
            r5 = move-exception
            goto L4a
        L48:
            r5 = move-exception
            r2 = r0
        L4a:
            r5.printStackTrace()
        L4d:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r3 = "initEnv  cursor:"
            r5.append(r3)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r1, r5)
            java.lang.String r5 = "1"
            java.lang.String r3 = "2"
            if (r2 == 0) goto L8a
            boolean r4 = r3.equals(r2)
            if (r4 == 0) goto L7b
            java.lang.String r2 = cn.damai.common.AppConfig.i
            cn.damai.common.AppConfig.d = r2
            cn.damai.common.AppConfig$EnvMode r2 = cn.damai.common.AppConfig.EnvMode.test
            cn.damai.common.AppConfig.f = r2
            java.lang.String r2 = "initEnv  test"
            android.util.Log.d(r1, r2)
            goto L8a
        L7b:
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L8a
            cn.damai.common.AppConfig$EnvMode r2 = cn.damai.common.AppConfig.EnvMode.prepare
            cn.damai.common.AppConfig.f = r2
            java.lang.String r2 = "initEnv  prepare"
            android.util.Log.d(r1, r2)
        L8a:
            if (r0 == 0) goto Laf
            boolean r2 = r3.equals(r0)
            if (r2 == 0) goto L9c
            cn.damai.common.AppConfig$EnvMode r5 = cn.damai.common.AppConfig.EnvMode.test
            cn.damai.common.AppConfig.g = r5
            java.lang.String r5 = "initEnv h5env  test"
            android.util.Log.d(r1, r5)
            goto Laf
        L9c:
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Laf
            java.lang.String r5 = cn.damai.common.AppConfig.i
            cn.damai.common.AppConfig.d = r5
            cn.damai.common.AppConfig$EnvMode r5 = cn.damai.common.AppConfig.EnvMode.prepare
            cn.damai.common.AppConfig.g = r5
            java.lang.String r5 = "initEnv h5env  prepare"
            android.util.Log.d(r1, r5)
        Laf:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "initEnv: appkey "
            r5.append(r0)
            java.lang.String r0 = cn.damai.common.AppConfig.d
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r1, r5)
        Lc5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.common.AppConfig.t(android.content.Context):void");
    }

    private static boolean u(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "68134626") ? ((Boolean) ipChange.ipc$dispatch("68134626", new Object[]{context})).booleanValue() : (context.getApplicationInfo().flags & 2) != 0;
    }

    public static boolean v() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "814176788")) {
            return ((Boolean) ipChange.ipc$dispatch("814176788", new Object[0])).booleanValue();
        }
        if ("true".equals(OrangeConfigCenter.c().b("damai_oneservice_switch", "AppInfoProvider", "false"))) {
            return AppInfoProviderProxy.isDebuggable();
        }
        return j.booleanValue();
    }
}
