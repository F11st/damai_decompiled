package tb;

import cn.damai.common.util.ACache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ts {
    private static transient /* synthetic */ IpChange $ipChange;

    public static long a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1419594379")) {
            return ((Long) ipChange.ipc$dispatch("1419594379", new Object[]{str})).longValue();
        }
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            cb1.b("DMTimeCountDownUitl", e.getMessage());
            return 0L;
        }
    }

    public static String[] b(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1857184703")) {
            return (String[]) ipChange.ipc$dispatch("1857184703", new Object[]{Long.valueOf(j)});
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

    public static long c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-9921373")) {
            return ((Long) ipChange.ipc$dispatch("-9921373", new Object[]{str})).longValue();
        }
        long j = 0;
        try {
            j = Long.parseLong(str);
        } catch (Exception e) {
            cb1.b("DMTimeCountDownUitl", e.getMessage());
        }
        return j / 1000;
    }

    private static String d(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-583937968")) {
            return (String) ipChange.ipc$dispatch("-583937968", new Object[]{Integer.valueOf(i)});
        }
        if (i >= 0 && i < 10) {
            return "0" + Integer.toString(i);
        }
        return "" + i;
    }
}
