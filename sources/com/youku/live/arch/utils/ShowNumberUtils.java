package com.youku.live.arch.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.ui.component.WXComponent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Locale;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ShowNumberUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "ShowNumberUtils";

    public static String addComma(String str) {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "889737258")) {
            return (String) ipChange.ipc$dispatch("889737258", new Object[]{str});
        }
        String sb = new StringBuilder(str).reverse().toString();
        String str2 = "";
        int i3 = 0;
        while (true) {
            if (i3 >= sb.length()) {
                break;
            }
            if ((i3 * 3) + 3 > sb.length()) {
                str2 = str2 + sb.substring(i, sb.length());
                break;
            }
            str2 = str2 + sb.substring(i, i2) + ",";
            i3++;
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        return new StringBuilder(str2).reverse().toString();
    }

    public static String calculateGuardLeftTimeInUserCard(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1343751923")) {
            return (String) ipChange.ipc$dispatch("1343751923", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (i > 0) {
            return i + "天";
        } else if (i2 > 0) {
            return i2 + "小时";
        } else {
            return "不足1小时";
        }
    }

    public static String calculateShowTimeByMilliseconds(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "782733133")) {
            return (String) ipChange.ipc$dispatch("782733133", new Object[]{Long.valueOf(j)});
        }
        if (j > DateUtils.MILLIS_PER_HOUR) {
            String format = new DecimalFormat("#.0").format(Math.ceil((j / 3600000.0d) * 10.0d) / 10.0d);
            return format + "小时";
        }
        int i = (int) (j / DateUtils.MILLIS_PER_MINUTE);
        int i2 = i != 0 ? i : 1;
        return i2 + "分钟";
    }

    public static String calculateShowTimeBySeconds(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1816416988")) {
            return (String) ipChange.ipc$dispatch("-1816416988", new Object[]{Long.valueOf(j)});
        }
        if (j > 3600) {
            String format = new DecimalFormat("#.0").format(Math.ceil((j / 3600.0d) * 10.0d) / 10.0d);
            return format + "小时";
        }
        int i = (int) (j / 60);
        return i + "分钟";
    }

    public static int calculateTieFenLeftDay(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "627085511")) {
            return ((Integer) ipChange.ipc$dispatch("627085511", new Object[]{Long.valueOf(j)})).intValue();
        }
        if (j < 86400000) {
            return 1;
        }
        return (int) Math.ceil(j / 8.64E7d);
    }

    public static String fixCoinsShow(String str) {
        long j;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-653364224")) {
            return (String) ipChange.ipc$dispatch("-653364224", new Object[]{str});
        }
        try {
            j = StringUtils.parse2Long(str);
        } catch (Exception e) {
            e.printStackTrace();
            j = 0;
        }
        return j > 100000000 ? j % 100000000 != 0 ? String.format(Locale.ENGLISH, "%.1f 亿", Double.valueOf(j / 1.0E8d)) : String.format(Locale.ENGLISH, "%d 亿", Long.valueOf(j / 100000000)) : j >= 10000 ? j < 10000000 ? j % 10000 != 0 ? String.format(Locale.ENGLISH, "%.1f 万", Double.valueOf(j / 10000.0d)) : String.format(Locale.ENGLISH, "%d 万", Long.valueOf(j / 10000)) : j % 10000000 != 0 ? String.format(Locale.ENGLISH, "%.1f 千万", Double.valueOf(j / 1.0E7d)) : String.format(Locale.ENGLISH, "%d 千万", Long.valueOf(j / 10000000)) : j >= 0 ? str : "0";
    }

    public static String fixCoinsShow2(String str) {
        long j;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "804882324")) {
            return (String) ipChange.ipc$dispatch("804882324", new Object[]{str});
        }
        try {
            j = StringUtils.parse2Long(str);
        } catch (Exception e) {
            e.printStackTrace();
            j = 0;
        }
        return j > 100000000 ? j % 100000000 != 0 ? String.format(Locale.ENGLISH, "%.1f 亿", Double.valueOf(j / 1.0E8d)) : String.format(Locale.ENGLISH, "%d 亿", Long.valueOf(j / 100000000)) : j >= 10000 ? j % 10000 != 0 ? String.format(Locale.ENGLISH, "%.1f 万", Double.valueOf(j / 10000.0d)) : String.format(Locale.ENGLISH, "%d 万", Long.valueOf(j / 10000)) : str;
    }

    public static String formatNumber(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2144056924")) {
            return (String) ipChange.ipc$dispatch("2144056924", new Object[]{Long.valueOf(j)});
        }
        if (j <= 0) {
            return "0";
        }
        int i = (j > 10000L ? 1 : (j == 10000L ? 0 : -1));
        if (i <= 0) {
            return j + "";
        } else if (i > 0 && j < 1000000) {
            double doubleValue = new BigDecimal(j / 10000.0d).setScale(1, 1).doubleValue();
            return doubleValue + ExifInterface.LONGITUDE_WEST;
        } else if (j >= 1000000 && j < 100000000) {
            return (j / 10000) + ExifInterface.LONGITUDE_WEST;
        } else {
            double doubleValue2 = new BigDecimal(j / 1.0E8d).setScale(1, 1).doubleValue();
            return doubleValue2 + "亿";
        }
    }

    public static String getFansNumberFromLong(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1675803487")) {
            return (String) ipChange.ipc$dispatch("-1675803487", new Object[]{Long.valueOf(j)});
        }
        if (j > 100000000) {
            int i = ((j % 100000000) > 0L ? 1 : ((j % 100000000) == 0L ? 0 : -1));
            Locale locale = Locale.ENGLISH;
            Object[] objArr = new Object[1];
            if (i != 0) {
                objArr[0] = Double.valueOf(j / 1.0E8d);
                return String.format(locale, "%.1f 亿人", objArr);
            }
            objArr[0] = Long.valueOf(j / 100000000);
            return String.format(locale, "%d 亿人", objArr);
        } else if (j < 10000) {
            return j + "人";
        } else if (j < 10000000) {
            int i2 = ((j % 10000) > 0L ? 1 : ((j % 10000) == 0L ? 0 : -1));
            Locale locale2 = Locale.ENGLISH;
            Object[] objArr2 = new Object[1];
            if (i2 != 0) {
                objArr2[0] = Double.valueOf(j / 10000.0d);
                return String.format(locale2, "%.1f 万人", objArr2);
            }
            objArr2[0] = Long.valueOf(j / 10000);
            return String.format(locale2, "%d 万人", objArr2);
        } else {
            int i3 = ((j % 10000000) > 0L ? 1 : ((j % 10000000) == 0L ? 0 : -1));
            Locale locale3 = Locale.ENGLISH;
            Object[] objArr3 = new Object[1];
            if (i3 != 0) {
                objArr3[0] = Double.valueOf(j / 1.0E7d);
                return String.format(locale3, "%.1f 千万人", objArr3);
            }
            objArr3[0] = Long.valueOf(j / 10000000);
            return String.format(locale3, "%d 千万人", objArr3);
        }
    }

    public static long getFansNumberFromString(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "657859214")) {
            return ((Long) ipChange.ipc$dispatch("657859214", new Object[]{str})).longValue();
        }
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        int length = str.length();
        String substring = str.substring(0, length - 1);
        if (substring.contains("万")) {
            String substring2 = substring.substring(0, length - 2);
            if (substring2.contains("千")) {
                return (long) (StringUtils.parse2Double(str.substring(0, length - 3)) * 1.0E7d);
            }
            return (long) (StringUtils.parse2Double(substring2) * 10000.0d);
        } else if (substring.contains("亿")) {
            return (long) (StringUtils.parse2Double(substring.substring(0, length - 2)) * 1.0E8d);
        } else {
            return StringUtils.parse2Long(substring);
        }
    }

    public static String getShowWatcherNumber(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1931744950")) {
            return (String) ipChange.ipc$dispatch("-1931744950", new Object[]{Long.valueOf(j)});
        }
        if (j > 99999) {
            String format = new DecimalFormat("#.0").format(Math.ceil((j / 10000.0d) * 10.0d) / 10.0d);
            return format + WXComponent.PROP_FS_WRAP_CONTENT;
        } else if (j > 9999) {
            String format2 = new DecimalFormat("#.00").format(j / 10000.0d);
            return format2 + WXComponent.PROP_FS_WRAP_CONTENT;
        } else if (j > 999) {
            String format3 = new DecimalFormat("#.00").format(j / 1000.0d);
            return format3 + "k";
        } else {
            return String.valueOf(j);
        }
    }

    public static String getShowingTimeInMins(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2118287738")) {
            return (String) ipChange.ipc$dispatch("2118287738", new Object[]{Long.valueOf(j)});
        }
        if (j < DateUtils.MILLIS_PER_MINUTE) {
            return "1分钟前开播";
        }
        return "开播" + ((int) Math.ceil(((j / 60000.0d) * 10.0d) / 10.0d)) + "分钟";
    }

    @SuppressLint({"DefaultLocale"})
    public static String getUsercountString(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-996480387")) {
            return (String) ipChange.ipc$dispatch("-996480387", new Object[]{Long.valueOf(j)});
        }
        return j > 10000 ? String.format("%.1f万", Float.valueOf(((float) j) / 10000.0f)) : "" + j;
    }

    public static boolean todayIsBirthday(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-839972090")) {
            return ((Boolean) ipChange.ipc$dispatch("-839972090", new Object[]{Long.valueOf(j)})).booleanValue();
        }
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        int i = calendar.get(6);
        calendar.setTimeInMillis(j);
        return i == calendar.get(6);
    }

    @SuppressLint({"DefaultLocale"})
    public static String getUsercountString(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-620072427")) {
            return (String) ipChange.ipc$dispatch("-620072427", new Object[]{str});
        }
        long parse2Long = StringUtils.parse2Long(str);
        return parse2Long > 10000 ? String.format("%.1f万", Float.valueOf(((float) parse2Long) / 10000.0f)) : "" + parse2Long;
    }

    public static String fixCoinsShow2(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "640617246")) {
            return (String) ipChange.ipc$dispatch("640617246", new Object[]{Long.valueOf(j)});
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

    public static String fixCoinsShow(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1052014286")) {
            return (String) ipChange.ipc$dispatch("-1052014286", new Object[]{Long.valueOf(j)});
        }
        if (j > 100000000) {
            return j % 100000000 != 0 ? String.format(Locale.ENGLISH, "%.1f 亿", Double.valueOf(j / 1.0E8d)) : String.format(Locale.ENGLISH, "%d 亿", Long.valueOf(j / 100000000));
        } else if (j < 10000) {
            return j >= 0 ? String.valueOf(j) : "0";
        } else if (j < 10000000) {
            return j % 10000 != 0 ? String.format(Locale.ENGLISH, "%.1f 万", Double.valueOf(j / 10000.0d)) : String.format(Locale.ENGLISH, "%d 万", Long.valueOf(j / 10000));
        } else {
            int i = ((j % 10000000) > 0L ? 1 : ((j % 10000000) == 0L ? 0 : -1));
            Locale locale = Locale.ENGLISH;
            Object[] objArr = new Object[1];
            if (i != 0) {
                objArr[0] = Double.valueOf(j / 1.0E7d);
                return String.format(locale, "%.1f 千万", objArr);
            }
            objArr[0] = Long.valueOf(j / 10000000);
            return String.format(locale, "%d 千万", objArr);
        }
    }
}
