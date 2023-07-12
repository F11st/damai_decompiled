package tb;

import android.content.Context;
import android.content.SharedPreferences;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class fu1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TICKLET_PREFERENCE_USERCODE = "ticklet_usercode";
    private static String a = "ticket";
    private static String b = "";

    public static void a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1310747404")) {
            ipChange.ipc$dispatch("-1310747404", new Object[]{context});
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(a, 0).edit();
        edit.clear();
        edit.commit();
    }

    public static String b(Context context, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-286546265")) {
            return (String) ipChange.ipc$dispatch("-286546265", new Object[]{context, str, str2});
        }
        try {
            return context.getSharedPreferences(a, 0).getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    public static String c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1218949916")) {
            return (String) ipChange.ipc$dispatch("-1218949916", new Object[0]);
        }
        String b2 = b(mu0.a(), TICKLET_PREFERENCE_USERCODE, "");
        b = b2;
        return b2;
    }

    public static void d(Context context, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "861340194")) {
            ipChange.ipc$dispatch("861340194", new Object[]{context, str, str2});
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(a, 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }
}
