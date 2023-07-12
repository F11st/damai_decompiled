package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class x30 {
    private static transient /* synthetic */ IpChange $ipChange;
    public static long a;

    public static long a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1088396012")) {
            return ((Long) ipChange.ipc$dispatch("1088396012", new Object[0])).longValue();
        }
        try {
            return System.currentTimeMillis() + a;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long b(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-619431232")) {
            return ((Long) ipChange.ipc$dispatch("-619431232", new Object[]{Long.valueOf(j)})).longValue();
        }
        try {
            return j + a;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1493278814")) {
            return (String) ipChange.ipc$dispatch("1493278814", new Object[]{str});
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Long valueOf = Long.valueOf(Long.parseLong(str));
            long longValue = valueOf.longValue() / 86400000;
            long longValue2 = valueOf.longValue();
            Long.signum(longValue);
            long j = 86400000 * longValue;
            long j2 = (longValue2 - j) / DateUtils.MILLIS_PER_HOUR;
            long j3 = DateUtils.MILLIS_PER_HOUR * j2;
            long longValue3 = ((valueOf.longValue() - j) - j3) / DateUtils.MILLIS_PER_MINUTE;
            long longValue4 = (((valueOf.longValue() - j) - j3) - (DateUtils.MILLIS_PER_MINUTE * longValue3)) / 1000;
            if (longValue > 0) {
                return ((longValue * 24) + j2) + ":" + longValue3 + ":" + longValue4;
            }
            return j2 + ":" + longValue3 + ":" + longValue4;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void d(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1766462076")) {
            ipChange.ipc$dispatch("1766462076", new Object[]{Long.valueOf(j)});
        } else if (j <= 0) {
        } else {
            a = j - System.currentTimeMillis();
        }
    }

    public static String e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1172034095")) {
            return (String) ipChange.ipc$dispatch("1172034095", new Object[]{str});
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmm");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            return simpleDateFormat.format(new Date(Long.parseLong(str)));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String f(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-765594552")) {
            return (String) ipChange.ipc$dispatch("-765594552", new Object[]{Long.valueOf(j)});
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            return simpleDateFormat.format(Long.valueOf(j));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String g(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1038273541")) {
            return (String) ipChange.ipc$dispatch("-1038273541", new Object[]{Long.valueOf(j)});
        }
        try {
            return new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(Long.valueOf(j));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String h(Long l, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1455892429")) {
            return (String) ipChange.ipc$dispatch("1455892429", new Object[]{l, str});
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return simpleDateFormat.format(new Date(l.longValue()));
    }
}
