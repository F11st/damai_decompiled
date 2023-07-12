package com.youku.live.dago.widgetlib.ailpbaselib.utils;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ParseUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    public static double parse2Double(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-524852439")) {
            return ((Double) ipChange.ipc$dispatch("-524852439", new Object[]{str})).doubleValue();
        }
        if (StringUtils.isEmpty(str)) {
            return 0.0d;
        }
        try {
            return Double.valueOf(str).doubleValue();
        } catch (NumberFormatException unused) {
            return 0.0d;
        }
    }

    public static float parse2Float(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1175629574")) {
            return ((Float) ipChange.ipc$dispatch("1175629574", new Object[]{str})).floatValue();
        }
        if (StringUtils.isEmpty(str)) {
            return 0.0f;
        }
        try {
            return Float.valueOf(str).floatValue();
        } catch (NumberFormatException unused) {
            return 0.0f;
        }
    }

    public static int parse2Int(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-590912490")) {
            return ((Integer) ipChange.ipc$dispatch("-590912490", new Object[]{str})).intValue();
        }
        if (StringUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static long parse2Long(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1567803228")) {
            return ((Long) ipChange.ipc$dispatch("-1567803228", new Object[]{str})).longValue();
        }
        if (StringUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            return Long.valueOf(str).longValue();
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }
}
