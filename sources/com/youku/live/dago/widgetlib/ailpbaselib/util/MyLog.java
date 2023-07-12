package com.youku.live.dago.widgetlib.ailpbaselib.util;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class MyLog {
    private static transient /* synthetic */ IpChange $ipChange;
    private static boolean isDebug = DebugHelp.isDebugBuild();
    private static String defaultTag = "YoukuLog";

    private MyLog() {
    }

    public static int d(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-824667171")) {
            return ((Integer) ipChange.ipc$dispatch("-824667171", new Object[]{str, str2})).intValue();
        }
        if (!isDebug || str2 == null) {
            return -1;
        }
        return Log.d(str, str2);
    }

    public static int e(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "636912828")) {
            return ((Integer) ipChange.ipc$dispatch("636912828", new Object[]{str, str2})).intValue();
        }
        if (!isDebug || str2 == null) {
            return -1;
        }
        return Log.e(str, str2);
    }

    private static String getLogMessage(Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "132917136")) {
            return (String) ipChange.ipc$dispatch("132917136", new Object[]{objArr});
        }
        if (objArr == null || objArr.length <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            }
        }
        return sb.toString();
    }

    public static int i(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-676651712")) {
            return ((Integer) ipChange.ipc$dispatch("-676651712", new Object[]{obj})).intValue();
        }
        if (!isDebug || obj == null) {
            return -1;
        }
        return Log.i(defaultTag, obj.toString());
    }

    public static void setTag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1469820350")) {
            ipChange.ipc$dispatch("-1469820350", new Object[]{str});
        } else {
            defaultTag = str;
        }
    }

    public static int v(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-286030965")) {
            return ((Integer) ipChange.ipc$dispatch("-286030965", new Object[]{str, str2})).intValue();
        }
        if (!isDebug || str2 == null) {
            return -1;
        }
        return Log.v(str, str2);
    }

    public static int w(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1175549034")) {
            return ((Integer) ipChange.ipc$dispatch("1175549034", new Object[]{str, str2})).intValue();
        }
        if (!isDebug || str2 == null) {
            return -1;
        }
        return Log.w(str, str2);
    }

    public static int d(String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1095230724")) {
            return ((Integer) ipChange.ipc$dispatch("1095230724", new Object[]{str, objArr})).intValue();
        }
        if (isDebug) {
            return Log.d(str, getLogMessage(objArr));
        }
        return -1;
    }

    public static int e(String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-840429563")) {
            return ((Integer) ipChange.ipc$dispatch("-840429563", new Object[]{str, objArr})).intValue();
        }
        if (isDebug) {
            return Log.e(str, getLogMessage(objArr));
        }
        return -1;
    }

    public static int i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "623662894")) {
            return ((Integer) ipChange.ipc$dispatch("623662894", new Object[]{str})).intValue();
        }
        if (!isDebug || str == null) {
            return -1;
        }
        return Log.i(defaultTag, str);
    }

    public static int v(String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "613083926")) {
            return ((Integer) ipChange.ipc$dispatch("613083926", new Object[]{str, objArr})).intValue();
        }
        if (isDebug) {
            return Log.v(str, getLogMessage(objArr));
        }
        return -1;
    }

    public static int w(String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1322576361")) {
            return ((Integer) ipChange.ipc$dispatch("-1322576361", new Object[]{str, objArr})).intValue();
        }
        if (isDebug) {
            return Log.w(str, getLogMessage(objArr));
        }
        return -1;
    }

    public static int d(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1023792702")) {
            return ((Integer) ipChange.ipc$dispatch("1023792702", new Object[]{str, str2, th})).intValue();
        }
        if (!isDebug || str2 == null) {
            return -1;
        }
        return Log.d(str, str2, th);
    }

    public static int e(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-142903617")) {
            return ((Integer) ipChange.ipc$dispatch("-142903617", new Object[]{str, str2, th})).intValue();
        }
        if (!isDebug || str2 == null) {
            return -1;
        }
        return Log.e(str, str2, th);
    }

    public static int i(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2106701768")) {
            return ((Integer) ipChange.ipc$dispatch("-2106701768", new Object[]{str, str2})).intValue();
        }
        if (!isDebug || str2 == null) {
            return -1;
        }
        return Log.i(str, str2);
    }

    public static int v(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1498095440")) {
            return ((Integer) ipChange.ipc$dispatch("1498095440", new Object[]{str, str2, th})).intValue();
        }
        if (!isDebug || str2 == null) {
            return -1;
        }
        return Log.v(str, str2, th);
    }

    public static int w(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "331399121")) {
            return ((Integer) ipChange.ipc$dispatch("331399121", new Object[]{str, str2, th})).intValue();
        }
        if (!isDebug || str2 == null) {
            return -1;
        }
        return Log.w(str, str2, th);
    }

    public static int d(Object obj, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1533852015")) {
            return ((Integer) ipChange.ipc$dispatch("1533852015", new Object[]{obj, str})).intValue();
        }
        if (isDebug) {
            return Log.d(obj.getClass().getSimpleName(), str);
        }
        return -1;
    }

    public static int e(Object obj, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1299535282")) {
            return ((Integer) ipChange.ipc$dispatch("-1299535282", new Object[]{obj, str})).intValue();
        }
        if (isDebug) {
            return Log.e(obj.getClass().getSimpleName(), str);
        }
        return -1;
    }

    public static int i(String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "6863881")) {
            return ((Integer) ipChange.ipc$dispatch("6863881", new Object[]{str, objArr})).intValue();
        }
        if (isDebug) {
            return Log.i(str, getLogMessage(objArr));
        }
        return -1;
    }

    public static int v(Object obj, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2072488221")) {
            return ((Integer) ipChange.ipc$dispatch("2072488221", new Object[]{obj, str})).intValue();
        }
        if (isDebug) {
            return Log.v(obj.getClass().getSimpleName(), str);
        }
        return -1;
    }

    public static int w(Object obj, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-760899076")) {
            return ((Integer) ipChange.ipc$dispatch("-760899076", new Object[]{obj, str})).intValue();
        }
        if (isDebug) {
            return Log.w(obj.getClass().getSimpleName(), str);
        }
        return -1;
    }

    public static int i(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-514721597")) {
            return ((Integer) ipChange.ipc$dispatch("-514721597", new Object[]{str, str2, th})).intValue();
        }
        if (!isDebug || str2 == null) {
            return -1;
        }
        return Log.i(str, str2, th);
    }

    public static int i(Object obj, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "251817418")) {
            return ((Integer) ipChange.ipc$dispatch("251817418", new Object[]{obj, str})).intValue();
        }
        if (isDebug) {
            return Log.i(obj.getClass().getSimpleName(), str);
        }
        return -1;
    }
}
