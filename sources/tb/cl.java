package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class cl {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1159637782")) {
            return (String) ipChange.ipc$dispatch("1159637782", new Object[]{Integer.valueOf(i)});
        }
        if (i <= 999) {
            return String.valueOf(i);
        }
        if (i <= 9999) {
            DecimalFormat decimalFormat = new DecimalFormat();
            decimalFormat.setMaximumFractionDigits(1);
            decimalFormat.setGroupingSize(0);
            decimalFormat.setRoundingMode(RoundingMode.FLOOR);
            return decimalFormat.format(i / 1000.0d) + "千";
        }
        DecimalFormat decimalFormat2 = new DecimalFormat();
        decimalFormat2.setMaximumFractionDigits(1);
        decimalFormat2.setGroupingSize(0);
        decimalFormat2.setRoundingMode(RoundingMode.FLOOR);
        return decimalFormat2.format(i / 10000.0d) + "万";
    }

    public static long b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "131432660")) {
            return ((Long) ipChange.ipc$dispatch("131432660", new Object[]{str})).longValue();
        }
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
