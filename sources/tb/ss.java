package tb;

import android.util.Log;
import cn.damai.common.util.ACache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.timepicker.TimeModel;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ss {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String[] a(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-275753436")) {
            return (String[]) ipChange.ipc$dispatch("-275753436", new Object[]{Long.valueOf(j)});
        }
        if (j <= 0) {
            return new String[]{"00", "00", "00"};
        }
        long j2 = j / 86400;
        long j3 = 24 * j2 * 60 * 60;
        long j4 = (j - j3) / 3600;
        long j5 = (j - ((j4 * 60) * 60)) - j3;
        long j6 = j5 / 60;
        return new String[]{j2 + "", String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Long.valueOf(j4)), String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Long.valueOf(j6)), String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Long.valueOf(j5 - (60 * j6)))};
    }

    public static long b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "387527974")) {
            return ((Long) ipChange.ipc$dispatch("387527974", new Object[]{str})).longValue();
        }
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            Log.d("DMTimeCountDownUitl", e.getMessage());
            return 0L;
        }
    }

    public static String[] c(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2116152422")) {
            return (String[]) ipChange.ipc$dispatch("-2116152422", new Object[]{Long.valueOf(j)});
        }
        String[] strArr = new String[3];
        if (j <= 0) {
            strArr[0] = "00";
            strArr[1] = "00";
            strArr[2] = "00";
            return strArr;
        }
        int i = (int) (j / 60);
        if (i < 60) {
            strArr[0] = "00";
            strArr[1] = d(i);
            strArr[2] = d((int) (j % 60));
        } else {
            int i2 = i / 60;
            int i3 = i % 60;
            int i4 = (int) ((j - (i2 * ACache.TIME_HOUR)) - (i3 * 60));
            strArr[0] = d(i2);
            strArr[1] = d(i3);
            strArr[2] = d(i4);
        }
        return strArr;
    }

    private static String d(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1781741845")) {
            return (String) ipChange.ipc$dispatch("1781741845", new Object[]{Integer.valueOf(i)});
        }
        if (i >= 0 && i < 10) {
            return "0" + Integer.toString(i);
        }
        return "" + i;
    }
}
