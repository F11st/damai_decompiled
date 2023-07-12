package com.youku.live.messagechannel.utils;

import android.content.Context;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MyLog {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static Context context = null;
    private static String defaultTag = "YoukuLiveMCLog";

    private MyLog() {
    }

    public static int d(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "529345434")) {
            return ((Integer) ipChange.ipc$dispatch("529345434", new Object[]{str, str2})).intValue();
        }
        if (!isDebug() || str2 == null) {
            return -1;
        }
        return Log.d(str, str2);
    }

    public static int e(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1990925433")) {
            return ((Integer) ipChange.ipc$dispatch("1990925433", new Object[]{str, str2})).intValue();
        }
        if (!isDebug() || str2 == null) {
            return -1;
        }
        return Log.e(str, str2);
    }

    private static String getLogMessage(Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1244793805")) {
            return (String) ipChange.ipc$dispatch("1244793805", new Object[]{objArr});
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
        if (AndroidInstantRuntime.support(ipChange, "1153702461")) {
            return ((Integer) ipChange.ipc$dispatch("1153702461", new Object[]{obj})).intValue();
        }
        if (!isDebug() || obj == null) {
            return -1;
        }
        return Log.i(defaultTag, obj.toString());
    }

    private static boolean isDebug() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1647227282")) {
            return ((Boolean) ipChange.ipc$dispatch("1647227282", new Object[0])).booleanValue();
        }
        Context context2 = context;
        return (context2 == null || context2.getApplicationInfo() == null || (context.getApplicationInfo().flags & 2) == 0) ? false : true;
    }

    public static void setContext(Context context2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "37120610")) {
            ipChange.ipc$dispatch("37120610", new Object[]{context2});
            return;
        }
        try {
            context = context2;
        } catch (Exception e) {
            Log.e(defaultTag, e.getMessage(), e);
        }
    }

    public static void setTag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1598221157")) {
            ipChange.ipc$dispatch("1598221157", new Object[]{str});
        } else {
            defaultTag = str;
        }
    }

    public static int v(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1067981640")) {
            return ((Integer) ipChange.ipc$dispatch("1067981640", new Object[]{str, str2})).intValue();
        }
        if (!isDebug() || str2 == null) {
            return -1;
        }
        return Log.v(str, str2);
    }

    public static int w(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1765405657")) {
            return ((Integer) ipChange.ipc$dispatch("-1765405657", new Object[]{str, str2})).intValue();
        }
        if (!isDebug() || str2 == null) {
            return -1;
        }
        return Log.w(str, str2);
    }

    public static int d(String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "119948519")) {
            return ((Integer) ipChange.ipc$dispatch("119948519", new Object[]{str, objArr})).intValue();
        }
        if (isDebug()) {
            return Log.d(str, getLogMessage(objArr));
        }
        return -1;
    }

    public static int e(String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1815711768")) {
            return ((Integer) ipChange.ipc$dispatch("-1815711768", new Object[]{str, objArr})).intValue();
        }
        if (isDebug()) {
            return Log.e(str, getLogMessage(objArr));
        }
        return -1;
    }

    public static int i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1840950229")) {
            return ((Integer) ipChange.ipc$dispatch("-1840950229", new Object[]{str})).intValue();
        }
        if (!isDebug() || str == null) {
            return -1;
        }
        return Log.i(defaultTag, str);
    }

    public static int v(String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-362198279")) {
            return ((Integer) ipChange.ipc$dispatch("-362198279", new Object[]{str, objArr})).intValue();
        }
        if (isDebug()) {
            return Log.v(str, getLogMessage(objArr));
        }
        return -1;
    }

    public static int w(String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1997108730")) {
            return ((Integer) ipChange.ipc$dispatch("1997108730", new Object[]{str, objArr})).intValue();
        }
        if (isDebug()) {
            return Log.w(str, getLogMessage(objArr));
        }
        return -1;
    }

    public static int d(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1453352609")) {
            return ((Integer) ipChange.ipc$dispatch("1453352609", new Object[]{str, str2, th})).intValue();
        }
        if (!isDebug() || str2 == null) {
            return -1;
        }
        return Log.d(str, str2, th);
    }

    public static int e(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "286656290")) {
            return ((Integer) ipChange.ipc$dispatch("286656290", new Object[]{str, str2, th})).intValue();
        }
        if (!isDebug() || str2 == null) {
            return -1;
        }
        return Log.e(str, str2, th);
    }

    public static int i(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-752689163")) {
            return ((Integer) ipChange.ipc$dispatch("-752689163", new Object[]{str, str2})).intValue();
        }
        if (!isDebug() || str2 == null) {
            return -1;
        }
        return Log.i(str, str2);
    }

    public static int v(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1927655347")) {
            return ((Integer) ipChange.ipc$dispatch("1927655347", new Object[]{str, str2, th})).intValue();
        }
        if (!isDebug() || str2 == null) {
            return -1;
        }
        return Log.v(str, str2, th);
    }

    public static int w(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "760959028")) {
            return ((Integer) ipChange.ipc$dispatch("760959028", new Object[]{str, str2, th})).intValue();
        }
        if (!isDebug() || str2 == null) {
            return -1;
        }
        return Log.w(str, str2, th);
    }

    public static int d(Object obj, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1407102676")) {
            return ((Integer) ipChange.ipc$dispatch("-1407102676", new Object[]{obj, str})).intValue();
        }
        if (isDebug()) {
            return Log.d(obj.getClass().getSimpleName(), str);
        }
        return -1;
    }

    public static int e(Object obj, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "54477323")) {
            return ((Integer) ipChange.ipc$dispatch("54477323", new Object[]{obj, str})).intValue();
        }
        if (isDebug()) {
            return Log.e(obj.getClass().getSimpleName(), str);
        }
        return -1;
    }

    public static int i(String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-968418324")) {
            return ((Integer) ipChange.ipc$dispatch("-968418324", new Object[]{str, objArr})).intValue();
        }
        if (isDebug()) {
            return Log.i(str, getLogMessage(objArr));
        }
        return -1;
    }

    public static int v(Object obj, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-868466470")) {
            return ((Integer) ipChange.ipc$dispatch("-868466470", new Object[]{obj, str})).intValue();
        }
        if (isDebug()) {
            return Log.v(obj.getClass().getSimpleName(), str);
        }
        return -1;
    }

    public static int w(Object obj, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "593113529")) {
            return ((Integer) ipChange.ipc$dispatch("593113529", new Object[]{obj, str})).intValue();
        }
        if (isDebug()) {
            return Log.w(obj.getClass().getSimpleName(), str);
        }
        return -1;
    }

    public static int i(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-85161690")) {
            return ((Integer) ipChange.ipc$dispatch("-85161690", new Object[]{str, str2, th})).intValue();
        }
        if (!isDebug() || str2 == null) {
            return -1;
        }
        return Log.i(str, str2, th);
    }

    public static int i(Object obj, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1605830023")) {
            return ((Integer) ipChange.ipc$dispatch("1605830023", new Object[]{obj, str})).intValue();
        }
        if (isDebug()) {
            return Log.i(obj.getClass().getSimpleName(), str);
        }
        return -1;
    }
}
