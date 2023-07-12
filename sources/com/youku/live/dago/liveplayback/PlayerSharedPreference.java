package com.youku.live.dago.liveplayback;

import android.content.SharedPreferences;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplugin.AlixPlayerContext;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PlayerSharedPreference {
    private static transient /* synthetic */ IpChange $ipChange;
    private static SharedPreferences.Editor sEditor;
    private static SharedPreferences sSharedPreferences;

    private PlayerSharedPreference() {
    }

    public static boolean commitPreference(AlixPlayerContext alixPlayerContext, String str, Boolean bool) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "805458053") ? ((Boolean) ipChange.ipc$dispatch("805458053", new Object[]{alixPlayerContext, str, bool})).booleanValue() : getSpe(alixPlayerContext).putBoolean(str, bool.booleanValue()).commit();
    }

    public static boolean contains(AlixPlayerContext alixPlayerContext, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2036030403") ? ((Boolean) ipChange.ipc$dispatch("2036030403", new Object[]{alixPlayerContext, str})).booleanValue() : getSp(alixPlayerContext).contains(str);
    }

    public static String getPreference(AlixPlayerContext alixPlayerContext, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2126517409") ? (String) ipChange.ipc$dispatch("-2126517409", new Object[]{alixPlayerContext, str}) : getSp(alixPlayerContext).getString(str, "");
    }

    public static boolean getPreferenceBoolean(AlixPlayerContext alixPlayerContext, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1854713397") ? ((Boolean) ipChange.ipc$dispatch("-1854713397", new Object[]{alixPlayerContext, str})).booleanValue() : getSp(alixPlayerContext).getBoolean(str, false);
    }

    public static int getPreferenceInt(AlixPlayerContext alixPlayerContext, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1594046765") ? ((Integer) ipChange.ipc$dispatch("-1594046765", new Object[]{alixPlayerContext, str})).intValue() : getSp(alixPlayerContext).getInt(str, 0);
    }

    public static long getPreferenceLong(AlixPlayerContext alixPlayerContext, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1493687737") ? ((Long) ipChange.ipc$dispatch("1493687737", new Object[]{alixPlayerContext, str})).longValue() : getSp(alixPlayerContext).getLong(str, 0L);
    }

    public static Set<String> getPreferenceStringSet(AlixPlayerContext alixPlayerContext, String str, Set<String> set) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "526270192") ? (Set) ipChange.ipc$dispatch("526270192", new Object[]{alixPlayerContext, str, set}) : getSp(alixPlayerContext).getStringSet(str, set);
    }

    public static SharedPreferences getSp(AlixPlayerContext alixPlayerContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "703874601")) {
            return (SharedPreferences) ipChange.ipc$dispatch("703874601", new Object[]{alixPlayerContext});
        }
        if (sSharedPreferences == null) {
            sSharedPreferences = alixPlayerContext.getContext().getApplicationContext().getSharedPreferences("dago_sp", 0);
        }
        return sSharedPreferences;
    }

    public static SharedPreferences.Editor getSpe(AlixPlayerContext alixPlayerContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1657296209")) {
            return (SharedPreferences.Editor) ipChange.ipc$dispatch("-1657296209", new Object[]{alixPlayerContext});
        }
        if (sEditor == null) {
            sEditor = getSp(alixPlayerContext).edit();
        }
        return sEditor;
    }

    public static void savePreference(AlixPlayerContext alixPlayerContext, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1890631152")) {
            ipChange.ipc$dispatch("-1890631152", new Object[]{alixPlayerContext, str, str2});
        } else {
            getSpe(alixPlayerContext).putString(str, str2).apply();
        }
    }

    public static boolean commitPreference(AlixPlayerContext alixPlayerContext, String str, String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-5000678") ? ((Boolean) ipChange.ipc$dispatch("-5000678", new Object[]{alixPlayerContext, str, str2})).booleanValue() : getSpe(alixPlayerContext).putString(str, str2).commit();
    }

    public static String getPreference(AlixPlayerContext alixPlayerContext, String str, String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-834945771") ? (String) ipChange.ipc$dispatch("-834945771", new Object[]{alixPlayerContext, str, str2}) : getSp(alixPlayerContext).getString(str, str2);
    }

    public static boolean getPreferenceBoolean(AlixPlayerContext alixPlayerContext, String str, boolean z) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1661494799") ? ((Boolean) ipChange.ipc$dispatch("-1661494799", new Object[]{alixPlayerContext, str, Boolean.valueOf(z)})).booleanValue() : getSp(alixPlayerContext).getBoolean(str, z);
    }

    public static int getPreferenceInt(AlixPlayerContext alixPlayerContext, String str, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2124187670") ? ((Integer) ipChange.ipc$dispatch("2124187670", new Object[]{alixPlayerContext, str, Integer.valueOf(i)})).intValue() : getSp(alixPlayerContext).getInt(str, i);
    }

    public static void savePreference(AlixPlayerContext alixPlayerContext, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "312503805")) {
            ipChange.ipc$dispatch("312503805", new Object[]{alixPlayerContext, str, Integer.valueOf(i)});
        } else {
            getSpe(alixPlayerContext).putInt(str, i).apply();
        }
    }

    public static void savePreference(AlixPlayerContext alixPlayerContext, String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "312504766")) {
            ipChange.ipc$dispatch("312504766", new Object[]{alixPlayerContext, str, Long.valueOf(j)});
        } else {
            getSpe(alixPlayerContext).putLong(str, j).apply();
        }
    }

    public static void savePreference(AlixPlayerContext alixPlayerContext, String str, Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1814511673")) {
            ipChange.ipc$dispatch("-1814511673", new Object[]{alixPlayerContext, str, bool});
        } else {
            getSpe(alixPlayerContext).putBoolean(str, bool.booleanValue()).apply();
        }
    }

    public static void savePreference(AlixPlayerContext alixPlayerContext, String str, Set<String> set) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-651076551")) {
            ipChange.ipc$dispatch("-651076551", new Object[]{alixPlayerContext, str, set});
        } else {
            getSpe(alixPlayerContext).putStringSet(str, set).apply();
        }
    }
}
