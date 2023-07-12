package tb;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.entity.ENV;
import anet.channel.strategy.C0213a;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.util.ALog;
import anet.channel.util.C0241c;
import com.taobao.weex.annotation.JSMethod;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class hu0 {
    private static Context a;
    private static String e;
    private static String f;
    private static String g;
    private static ENV b = ENV.ONLINE;
    private static String c = "";
    private static String d = "";
    private static volatile boolean h = true;
    private static SharedPreferences i = null;
    private static volatile CopyOnWriteArrayList<String> j = null;

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.length() > 32 || str2.length() > 32) {
            return;
        }
        synchronized (hu0.class) {
            if (j == null) {
                j = new CopyOnWriteArrayList<>();
            }
            j.add(str);
            j.add(str2);
        }
    }

    public static CopyOnWriteArrayList<String> b() {
        return j;
    }

    public static Context c() {
        return a;
    }

    public static String d() {
        return d;
    }

    public static ENV e() {
        return b;
    }

    public static String f() {
        return e;
    }

    public static String g() {
        return f;
    }

    public static String h() {
        Context context;
        if (g == null && (context = a) != null) {
            g = C0241c.c(context);
        }
        return g;
    }

    public static boolean i() {
        if (a == null) {
            return true;
        }
        return h;
    }

    public static boolean j() {
        if (TextUtils.isEmpty(c) || TextUtils.isEmpty(d)) {
            return true;
        }
        return c.equalsIgnoreCase(d);
    }

    public static void k(boolean z) {
        h = z;
    }

    public static void l(Context context) {
        a = context;
        if (context != null) {
            if (TextUtils.isEmpty(d)) {
                d = C0241c.g(context, Process.myPid());
            }
            if (TextUtils.isEmpty(c)) {
                c = C0241c.e(context);
            }
            if (i == null) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                i = defaultSharedPreferences;
                f = defaultSharedPreferences.getString("UserId", null);
            }
            ALog.e("awcn.GlobalAppRuntimeInfo", "", null, "CurrentProcess", d, "TargetProcess", c);
        }
    }

    public static void m(String str) {
        d = str;
    }

    public static void n(ENV env) {
        b = env;
    }

    @Deprecated
    public static void o(long j2) {
    }

    public static void p(String str) {
        e = str;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int indexOf = str.indexOf(m80.DINAMIC_PREFIX_AT);
            String str2 = null;
            String substring = indexOf != -1 ? str.substring(0, indexOf) : null;
            String substring2 = str.substring(indexOf + 1);
            int lastIndexOf = substring2.lastIndexOf(JSMethod.NOT_SET);
            if (lastIndexOf != -1) {
                String substring3 = substring2.substring(0, lastIndexOf);
                str2 = substring2.substring(lastIndexOf + 1);
                substring2 = substring3;
            }
            AmdcRuntimeInfo.f(substring2, str2, substring);
        } catch (Exception unused) {
        }
    }

    public static void q(String str) {
        String str2 = f;
        if (str2 == null || !str2.equals(str)) {
            f = str;
            C0213a.a().forceRefreshStrategy(y90.a());
            SharedPreferences sharedPreferences = i;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString("UserId", str).apply();
            }
        }
    }

    public static void r(String str) {
        String str2 = g;
        if (str2 == null || !str2.equals(str)) {
            g = str;
        }
    }
}
