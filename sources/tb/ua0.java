package tb;

import android.content.Context;
import android.content.SharedPreferences;
import cn.damai.common.OrangeConfigCenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.kvdata.SPProviderProxy;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ua0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean a(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1367491884") ? ((Boolean) ipChange.ipc$dispatch("-1367491884", new Object[]{context})).booleanValue() : e(context).getBoolean("dm_sp_is_seat", false);
    }

    public static long b(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-681096349") ? ((Long) ipChange.ipc$dispatch("-681096349", new Object[]{context})).longValue() : e(context).getLong("dm_sp_item_id", 0L);
    }

    public static String c(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1024509784") ? (String) ipChange.ipc$dispatch("1024509784", new Object[]{context}) : e(context).getString("dm_sp_promotion_type", "");
    }

    public static String d(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1733499709") ? (String) ipChange.ipc$dispatch("1733499709", new Object[]{context}) : e(context).getString("dm_sp_promotion_type_id", "");
    }

    private static SharedPreferences e(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2117422381")) {
            return (SharedPreferences) ipChange.ipc$dispatch("-2117422381", new Object[]{context});
        }
        if (context == null) {
            return null;
        }
        if ("true".equals(OrangeConfigCenter.c().b("damai_oneservice_switch", "SPProvider", "false"))) {
            return SPProviderProxy.getSharedPreferences("ultron_sharedpreferences");
        }
        return context.getSharedPreferences("ultron_sharedpreferences", 4);
    }

    public static void f(Context context, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1323718280")) {
            ipChange.ipc$dispatch("-1323718280", new Object[]{context, Boolean.valueOf(z)});
            return;
        }
        SharedPreferences e = e(context);
        if (e == null) {
            return;
        }
        e.edit().putBoolean("dm_sp_is_seat", z).commit();
    }

    public static void g(Context context, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1520308055")) {
            ipChange.ipc$dispatch("-1520308055", new Object[]{context, Long.valueOf(j)});
            return;
        }
        SharedPreferences e = e(context);
        if (e == null) {
            return;
        }
        e.edit().putLong("dm_sp_item_id", j).commit();
    }

    public static void h(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1528446074")) {
            ipChange.ipc$dispatch("-1528446074", new Object[]{context, str});
            return;
        }
        SharedPreferences e = e(context);
        if (e == null) {
            return;
        }
        e.edit().putString("dm_sp_promotion_type", str).commit();
    }

    public static void i(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1878941505")) {
            ipChange.ipc$dispatch("1878941505", new Object[]{context, str});
            return;
        }
        SharedPreferences e = e(context);
        if (e == null) {
            return;
        }
        e.edit().putString("dm_sp_promotion_type_id", str).commit();
    }
}
