package com.youku.live.dago.widgetlib.interactive.utils;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NumUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String fixCoinsShow(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1806777882")) {
            return (String) ipChange.ipc$dispatch("-1806777882", new Object[]{Long.valueOf(j)});
        }
        if (j > 100000000) {
            int i = ((j % 100000000) > 0L ? 1 : ((j % 100000000) == 0L ? 0 : -1));
            Locale locale = Locale.ENGLISH;
            Object[] objArr = new Object[1];
            if (i != 0) {
                objArr[0] = Double.valueOf(j / 1.0E8d);
                return String.format(locale, "%.1f 亿", objArr);
            }
            objArr[0] = Long.valueOf(j / 100000000);
            return String.format(locale, "%d 亿", objArr);
        } else if (j < 10000) {
            return j >= 0 ? String.valueOf(j) : "0";
        } else {
            int i2 = ((j % 10000) > 0L ? 1 : ((j % 10000) == 0L ? 0 : -1));
            Locale locale2 = Locale.ENGLISH;
            Object[] objArr2 = new Object[1];
            if (i2 != 0) {
                objArr2[0] = Double.valueOf(j / 10000.0d);
                return String.format(locale2, "%.1f 万", objArr2);
            }
            objArr2[0] = Long.valueOf(j / 10000);
            return String.format(locale2, "%d 万", objArr2);
        }
    }
}
