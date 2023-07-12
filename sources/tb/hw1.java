package tb;

import android.content.SharedPreferences;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class hw1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String a = "true";

    public static String a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1263033240") ? (String) ipChange.ipc$dispatch("-1263033240", new Object[0]) : a;
    }

    public static boolean b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "902987844")) {
            return ((Boolean) ipChange.ipc$dispatch("902987844", new Object[0])).booleanValue();
        }
        SharedPreferences c = c("project_config", 0);
        if (c != null) {
            return c.getBoolean("has_network", false);
        }
        return false;
    }

    private static SharedPreferences c(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "683113764")) {
            return (SharedPreferences) ipChange.ipc$dispatch("683113764", new Object[]{str, Integer.valueOf(i)});
        }
        if (str == null) {
            str = "error";
        }
        if (mu0.a() != null) {
            return mu0.a().getApplicationContext().getSharedPreferences(str, i);
        }
        return null;
    }

    public static void d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1175364622")) {
            ipChange.ipc$dispatch("1175364622", new Object[]{str});
        } else {
            a = str;
        }
    }

    public static void e(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "464108704")) {
            ipChange.ipc$dispatch("464108704", new Object[]{Boolean.valueOf(z)});
            return;
        }
        SharedPreferences c = c("project_config", 0);
        if (c != null) {
            c.edit().putBoolean("has_network", z).commit();
        }
    }

    public static void f(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "125201020")) {
            ipChange.ipc$dispatch("125201020", new Object[]{Boolean.valueOf(z)});
            return;
        }
        SharedPreferences c = c("project_config", 0);
        if (c != null) {
            c.edit().putBoolean("show_perform_info_guide", z).commit();
        }
    }
}
