package tb;

import android.content.Context;
import android.content.SharedPreferences;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ru1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "103849614")) {
            ipChange.ipc$dispatch("103849614", new Object[0]);
            return;
        }
        SharedPreferences f = f();
        if (f == null) {
            return;
        }
        f.edit().putString("privacy_agreement_change_index", "").commit();
    }

    public static String b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1049262171")) {
            return (String) ipChange.ipc$dispatch("1049262171", new Object[0]);
        }
        SharedPreferences f = f();
        return f == null ? "" : f.getString("privacy_agreement_change_index", "");
    }

    public static String c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1482683182")) {
            return (String) ipChange.ipc$dispatch("-1482683182", new Object[0]);
        }
        SharedPreferences f = f();
        return f == null ? "" : f.getString("home_agreement_time_json", "");
    }

    public static boolean d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "831149331")) {
            return ((Boolean) ipChange.ipc$dispatch("831149331", new Object[0])).booleanValue();
        }
        SharedPreferences f = f();
        if (f == null) {
            return false;
        }
        return f.getBoolean("privacy_dialog_agree_status", false);
    }

    public static boolean e(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2068204131")) {
            return ((Boolean) ipChange.ipc$dispatch("-2068204131", new Object[]{context})).booleanValue();
        }
        SharedPreferences g = g(context);
        if (g == null) {
            return false;
        }
        return g.getBoolean("privacy_dialog_agree_status", false);
    }

    private static SharedPreferences f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1692151922") ? (SharedPreferences) ipChange.ipc$dispatch("-1692151922", new Object[0]) : g(mu0.a());
    }

    private static SharedPreferences g(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "818237730") ? (SharedPreferences) ipChange.ipc$dispatch("818237730", new Object[]{context}) : context.getApplicationContext().getSharedPreferences("privacy_dialog", 0);
    }

    public static boolean h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1093622353")) {
            return ((Boolean) ipChange.ipc$dispatch("1093622353", new Object[0])).booleanValue();
        }
        SharedPreferences f = f();
        if (f == null) {
            return false;
        }
        return f.getBoolean("home_privacy_first", true);
    }

    public static boolean i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-133591385")) {
            return ((Boolean) ipChange.ipc$dispatch("-133591385", new Object[0])).booleanValue();
        }
        SharedPreferences f = f();
        if (f == null) {
            return false;
        }
        return f.getBoolean("specific_version_first", true);
    }

    public static void j(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1520045539")) {
            ipChange.ipc$dispatch("1520045539", new Object[]{str});
            return;
        }
        SharedPreferences f = f();
        if (f == null) {
            return;
        }
        f.edit().putString("privacy_agreement_change_index", str).commit();
    }

    public static void k(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2002510876")) {
            ipChange.ipc$dispatch("-2002510876", new Object[]{str});
            return;
        }
        SharedPreferences f = f();
        if (f == null) {
            return;
        }
        f.edit().putString("home_agreement_time_json", str).commit();
    }

    public static void l(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-89496911")) {
            ipChange.ipc$dispatch("-89496911", new Object[]{Boolean.valueOf(z)});
            return;
        }
        SharedPreferences f = f();
        if (f == null) {
            return;
        }
        f.edit().putBoolean("privacy_dialog_agree_status", z).commit();
    }

    public static void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-344285524")) {
            ipChange.ipc$dispatch("-344285524", new Object[0]);
            return;
        }
        SharedPreferences f = f();
        if (f == null) {
            return;
        }
        f.edit().putBoolean("home_privacy_first", false).commit();
    }

    public static void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "248851111")) {
            ipChange.ipc$dispatch("248851111", new Object[0]);
            return;
        }
        SharedPreferences f = f();
        if (f == null) {
            return;
        }
        f.edit().putBoolean("specific_version_first", false).commit();
    }
}
