package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class hm1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long NUM_QIAN = 1000;
    public static final long NUM_QIAN_WAN = 10000000;
    public static final long NUM_WAN = 10000;
    public static final long NUM_YI = 100000000;
    public static final int OND_DAY = 86400000;
    public static final int ONE_HOUR = 3600000;
    public static final int ONE_MINUTE = 60000;

    public static boolean a(String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-2038301849")) {
            return ((Boolean) ipChange.ipc$dispatch("-2038301849", new Object[]{str})).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                z = false;
            }
        }
        return z;
    }

    public static boolean b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-992298521")) {
            return ((Boolean) ipChange.ipc$dispatch("-992298521", new Object[]{str})).booleanValue();
        }
        try {
            return Pattern.compile("^.*[a-zA-Z]+.*$").matcher(str).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    public static double c(String str, double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1815050689")) {
            return ((Double) ipChange.ipc$dispatch("-1815050689", new Object[]{str, Double.valueOf(d)})).doubleValue();
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                return Double.parseDouble(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public static float d(String str, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-219839572")) {
            return ((Float) ipChange.ipc$dispatch("-219839572", new Object[]{str, Float.valueOf(f)})).floatValue();
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                return Float.parseFloat(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public static int e(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1553377983")) {
            return ((Integer) ipChange.ipc$dispatch("-1553377983", new Object[]{str, Integer.valueOf(i)})).intValue();
        }
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public static long f(String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1337011270")) {
            return ((Long) ipChange.ipc$dispatch("-1337011270", new Object[]{str, Long.valueOf(j)})).longValue();
        }
        if (TextUtils.isEmpty(str)) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        }
    }
}
