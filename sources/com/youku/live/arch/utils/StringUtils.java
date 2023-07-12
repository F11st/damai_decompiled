package com.youku.live.arch.utils;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class StringUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String EMPTY = "";

    public static void colorSpan(SpannableString spannableString, int i, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "4917519")) {
            ipChange.ipc$dispatch("4917519", new Object[]{spannableString, Integer.valueOf(i), context});
        } else {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(i)), 0, spannableString.length(), 17);
        }
    }

    public static double getLength(String str) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1410162511")) {
            return ((Double) ipChange.ipc$dispatch("-1410162511", new Object[]{str})).doubleValue();
        }
        double d = 0.0d;
        while (i < str.length()) {
            int i2 = i + 1;
            d += str.substring(i, i2).matches("[一-龥]") ? 1.0d : 0.5d;
            i = i2;
        }
        return Math.ceil(d);
    }

    public static double getLengthCH(String str) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "545888364")) {
            return ((Double) ipChange.ipc$dispatch("545888364", new Object[]{str})).doubleValue();
        }
        double d = 0.0d;
        while (i < str.length()) {
            int i2 = i + 1;
            str.substring(i, i2);
            d += 1.0d;
            i = i2;
        }
        return Math.ceil(d);
    }

    public static boolean isBlank(String str) {
        int length;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1705887463")) {
            return ((Boolean) ipChange.ipc$dispatch("-1705887463", new Object[]{str})).booleanValue();
        }
        if (str != null && (length = str.length()) != 0) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEmpty(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "10463936") ? ((Boolean) ipChange.ipc$dispatch("10463936", new Object[]{str})).booleanValue() : str == null || str.length() == 0;
    }

    public static boolean isNotBlank(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1378494920") ? ((Boolean) ipChange.ipc$dispatch("-1378494920", new Object[]{str})).booleanValue() : !isBlank(str);
    }

    public static boolean isNotEmpty(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "337856479") ? ((Boolean) ipChange.ipc$dispatch("337856479", new Object[]{str})).booleanValue() : !isEmpty(str);
    }

    public static boolean isNumeric(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-888546688")) {
            return ((Boolean) ipChange.ipc$dispatch("-888546688", new Object[]{str})).booleanValue();
        }
        if (isBlank(str)) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static float lengthZH(String str) {
        char[] charArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1674231109")) {
            return ((Float) ipChange.ipc$dispatch("-1674231109", new Object[]{str})).floatValue();
        }
        float f = 0.0f;
        if (TextUtils.isEmpty(str)) {
            return 0.0f;
        }
        for (char c : str.toCharArray()) {
            float f2 = 0.51f;
            if (c > 255 && !Character.isLowSurrogate(c) && !Character.isHighSurrogate(c)) {
                f2 = 1.0f;
            }
            f += f2;
        }
        return f;
    }

    public static double parse2Double(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1808102339")) {
            return ((Double) ipChange.ipc$dispatch("-1808102339", new Object[]{str})).doubleValue();
        }
        if (isNotBlank(str)) {
            try {
                return Double.valueOf(str).doubleValue();
            } catch (NumberFormatException unused) {
                return 0.0d;
            }
        }
        return 0.0d;
    }

    public static float parse2Float(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-943975566")) {
            return ((Float) ipChange.ipc$dispatch("-943975566", new Object[]{str})).floatValue();
        }
        if (isNotBlank(str)) {
            try {
                return Float.valueOf(str).floatValue();
            } catch (NumberFormatException unused) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    public static int parse2Int(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-199822462")) {
            return ((Integer) ipChange.ipc$dispatch("-199822462", new Object[]{str})).intValue();
        }
        if (isNotBlank(str)) {
            try {
                return Integer.valueOf(str).intValue();
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    public static long parse2Long(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1966053048")) {
            return ((Long) ipChange.ipc$dispatch("1966053048", new Object[]{str})).longValue();
        }
        if (isNotBlank(str)) {
            try {
                return Long.valueOf(str).longValue();
            } catch (NumberFormatException unused) {
                return 0L;
            }
        }
        return 0L;
    }

    public static String valueOf(Number number) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "228017601")) {
            return (String) ipChange.ipc$dispatch("228017601", new Object[]{number});
        }
        return "" + number;
    }
}
