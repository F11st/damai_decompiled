package tb;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class jm1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long NUM_QIAN = 1000;
    public static final long NUM_QIAN_WAN = 10000000;
    public static final long NUM_WAN = 10000;
    public static final long NUM_YI = 100000000;
    public static final int OND_DAY = 86400000;
    public static final int ONE_HOUR = 3600000;
    public static final int ONE_MINUTE = 60000;

    public static void a(SpannableStringBuilder spannableStringBuilder, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1993809864")) {
            ipChange.ipc$dispatch("-1993809864", new Object[]{spannableStringBuilder, str, Integer.valueOf(i)});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i), length, spannableStringBuilder.length(), 18);
        }
    }

    public static void b(long[] jArr, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1082113085")) {
            ipChange.ipc$dispatch("-1082113085", new Object[]{jArr, Long.valueOf(j)});
        } else if (jArr == null || jArr.length != 4) {
        } else {
            long j2 = j / 86400000;
            long j3 = (j % 86400000) / DateUtils.MILLIS_PER_HOUR;
            long j4 = j % DateUtils.MILLIS_PER_HOUR;
            long j5 = j4 / DateUtils.MILLIS_PER_MINUTE;
            jArr[0] = j2;
            jArr[1] = j3;
            jArr[2] = j5;
            jArr[3] = (j4 % DateUtils.MILLIS_PER_MINUTE) / 1000;
        }
    }

    public static SpannableStringBuilder c(String str, int i, String str2, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "655866350")) {
            return (SpannableStringBuilder) ipChange.ipc$dispatch("655866350", new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2)});
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        a(spannableStringBuilder, str, i);
        a(spannableStringBuilder, str2, i2);
        return spannableStringBuilder;
    }

    public static void d(String[] strArr, long[] jArr) {
        String str;
        String str2;
        String str3;
        String str4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1630220310")) {
            ipChange.ipc$dispatch("-1630220310", new Object[]{strArr, jArr});
        } else if (strArr == null || strArr.length != 4 || jArr == null || jArr.length != 4) {
        } else {
            long j = jArr[0];
            long j2 = jArr[1];
            long j3 = jArr[2];
            long j4 = jArr[3];
            if (j >= 10) {
                str = String.valueOf(j);
            } else {
                str = "0" + j;
            }
            if (j2 >= 10) {
                str2 = String.valueOf(j2);
            } else {
                str2 = "0" + j2;
            }
            if (j3 >= 10) {
                str3 = String.valueOf(j3);
            } else {
                str3 = "0" + j3;
            }
            if (j4 >= 10) {
                str4 = String.valueOf(j4);
            } else {
                str4 = "0" + j4;
            }
            strArr[0] = str;
            strArr[1] = str2;
            strArr[2] = str3;
            strArr[3] = str4;
        }
    }

    @Nullable
    public static SpannableStringBuilder e(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1402081829") ? (SpannableStringBuilder) ipChange.ipc$dispatch("1402081829", new Object[]{str}) : f(str, Color.parseColor("#FF993A"), Color.parseColor("#9C9CA5"));
    }

    public static SpannableStringBuilder f(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1165112827")) {
            return (SpannableStringBuilder) ipChange.ipc$dispatch("-1165112827", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        try {
            if (TextUtils.isEmpty(str)) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                a(spannableStringBuilder, "人气飙升", i2);
                return spannableStringBuilder;
            } else if (wh2.h(str)) {
                long k = k(str, -1L);
                if (k < 10000) {
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                    a(spannableStringBuilder2, "人气飙升", i2);
                    return spannableStringBuilder2;
                }
                return c(g(k), i, "人想看", i2);
            } else {
                return new SpannableStringBuilder(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String g(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-508503196")) {
            return (String) ipChange.ipc$dispatch("-508503196", new Object[]{Long.valueOf(j)});
        }
        long j2 = j / 100000000;
        if (j2 > 0) {
            return j2 + "." + ((j % 100000000) / 10000000) + "亿";
        }
        long j3 = j / 10000;
        if (j3 > 0) {
            return j3 + "." + ((j % 10000) / 1000) + "万";
        }
        return j + "";
    }

    public static double h(String str, double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2138598532")) {
            return ((Double) ipChange.ipc$dispatch("2138598532", new Object[]{str, Double.valueOf(d)})).doubleValue();
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

    public static float i(String str, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-785039161")) {
            return ((Float) ipChange.ipc$dispatch("-785039161", new Object[]{str, Float.valueOf(f)})).floatValue();
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

    public static int j(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-383017700")) {
            return ((Integer) ipChange.ipc$dispatch("-383017700", new Object[]{str, Integer.valueOf(i)})).intValue();
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

    public static long k(String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "584419135")) {
            return ((Long) ipChange.ipc$dispatch("584419135", new Object[]{str, Long.valueOf(j)})).longValue();
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
