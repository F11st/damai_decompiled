package com.youku.live.dago.widgetlib.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import cn.damai.common.util.ACache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.timepicker.TimeModel;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Util {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String JSAPIVersion = "1.0";
    public static final String LIVESDKVersion = "1.0";
    public static final int LiveVideo_Null = -1;
    public static final int LiveVideo_Playback = 2;
    public static final int LiveVideo_Playing = 1;
    public static final int LiveVideo_Waiting = 3;
    public static final String LiveVideosharePreferences = "LiveVideoSharePreferences";
    public static final String SubscribeCalendar = "预约日历beta1";
    private static final int TODAY_FLAG = 1;
    private static final int TOMORROW_FLAG = 2;
    private static final String laifengUserPic1 = "0A02000015398E8001A1C016DE9594D4";
    private static final String laifengUserPic2 = "0A02000015398E800587D4AB68BDB638";
    private static final String laifengUserPic3 = "0A02000015398E80081963D35BB1C3F1";
    private static final String laifengUserPic4 = "0A02000015398E800A7213E88EDAB725";
    private static final String laifengUserPic5 = "0A02000015398E800FB6E8D69E797A88";
    private static final String userpic1 = "http://r1.ykimg.com/05100000582AF2EC67BC3D0424093D45";
    private static final String userpic2 = "http://r2.ykimg.com/05100000582AF2EC67BC3D042006B178";
    private static final String userpic3 = "http://r2.ykimg.com/05100000582AF2ED67BC3D042C03AD53";
    private static final String userpic4 = "http://r1.ykimg.com/05100000582AF2EC67BC3D43590B2C10";
    private static final ArrayList<String> userpics = new ArrayList<String>() { // from class: com.youku.live.dago.widgetlib.util.Util.1
        {
            add(Util.userpic1);
            add(Util.userpic2);
            add(Util.userpic3);
            add(Util.userpic4);
        }
    };
    private static long miLastClicktime = 0;
    private static int miClickCount = 0;

    public static int Dp2Px(Context context, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-863587676") ? ((Integer) ipChange.ipc$dispatch("-863587676", new Object[]{context, Float.valueOf(f)})).intValue() : (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String[] FormatLeftTime2(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1980687091")) {
            return (String[]) ipChange.ipc$dispatch("1980687091", new Object[]{Long.valueOf(j)});
        }
        int i = (int) (j / 86400);
        long j2 = j - (86400 * i);
        int i2 = ((int) j2) / ACache.TIME_HOUR;
        long j3 = j2 - (i2 * ACache.TIME_HOUR);
        int i3 = ((int) j3) / 60;
        return new String[]{String.valueOf(i), String.valueOf(i2), String.valueOf(i3), String.valueOf((int) (j3 - (i3 * 60)))};
    }

    public static String FormatLeftTimeToString(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "158356872")) {
            return (String) ipChange.ipc$dispatch("158356872", new Object[]{Long.valueOf(j)});
        }
        long j2 = j - 0;
        int i = ((int) j2) / ACache.TIME_HOUR;
        long j3 = j2 - (i * ACache.TIME_HOUR);
        int i2 = ((int) j3) / 60;
        return String.format(i >= 100 ? "%d:%02d:%02d" : "%02d:%02d:%02d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(Math.round((float) (j3 - (i2 * 60)))));
    }

    public static String[] FormatLeftTimeToStrings(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1057454744")) {
            return (String[]) ipChange.ipc$dispatch("-1057454744", new Object[]{Long.valueOf(j)});
        }
        int i = (int) (j / 86400);
        long j2 = j - (86400 * i);
        int i2 = ((int) j2) / ACache.TIME_HOUR;
        long j3 = j2 - (i2 * ACache.TIME_HOUR);
        int i3 = ((int) j3) / 60;
        return new String[]{String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i)), String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2)), String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3)), String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf((int) (j3 - (i3 * 60))))};
    }

    public static String FormatMinmsTimeToString(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1093281065")) {
            return (String) ipChange.ipc$dispatch("1093281065", new Object[]{Long.valueOf(j)});
        }
        long j2 = j - 0;
        int i = ((int) j2) / 60;
        return String.format("%02d:%02d", Integer.valueOf(i), Integer.valueOf((int) (j2 - (i * 60))));
    }

    public static String GetVersionName(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "494119054")) {
            return (String) ipChange.ipc$dispatch("494119054", new Object[]{context});
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 128).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static int GetVideoType(long j, long j2, long j3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1468423021")) {
            return ((Integer) ipChange.ipc$dispatch("-1468423021", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})).intValue();
        }
        if (j < j2) {
            return 3;
        }
        return j > j3 ? 2 : 1;
    }

    public static Date ParserDate(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "794746327") ? (Date) ipChange.ipc$dispatch("794746327", new Object[]{str}) : new Date(Integer.parseInt(str) * 1000);
    }

    public static void StartAutoCheckActivity(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1748797707")) {
            ipChange.ipc$dispatch("1748797707", new Object[]{context});
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), "com.youku.livesdk.AutoCheckActivity");
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static String URLEncode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-28596012")) {
            return (String) ipChange.ipc$dispatch("-28596012", new Object[]{str});
        }
        if (str != null && !str.isEmpty()) {
            try {
                return URLEncoder.encode(new String(str.getBytes(), "UTF-8"), "UTF-8");
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String formatNumber(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1586458605") ? (String) ipChange.ipc$dispatch("-1586458605", new Object[]{str}) : new DecimalFormat("#,###").format(Long.valueOf(Long.parseLong(str)));
    }

    public static String formatNumber2(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1199156529")) {
            return (String) ipChange.ipc$dispatch("1199156529", new Object[]{Long.valueOf(j)});
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

    public static String getLiveId(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-125847422") ? (String) ipChange.ipc$dispatch("-125847422", new Object[]{context}) : context != null ? context.getSharedPreferences(LiveVideosharePreferences, 0).getString("carouselLiveId", "") : "";
    }

    public static String getRandomUserPic(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-952609937")) {
            return (String) ipChange.ipc$dispatch("-952609937", new Object[]{str, str2});
        }
        if (str == null) {
            return "";
        }
        if (str.isEmpty() || str.contains(laifengUserPic1) || str.contains(laifengUserPic2) || str.contains(laifengUserPic3) || str.contains(laifengUserPic4) || str.contains(laifengUserPic5)) {
            return userpics.get((str2.length() >= 1 ? str2.charAt(str2.length() - 1) : (char) 0) % 4);
        }
        return str;
    }

    public static int getSpaceChineseCount(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1800147950")) {
            return ((Integer) ipChange.ipc$dispatch("1800147950", new Object[]{str})).intValue();
        }
        Matcher matcher = Pattern.compile("[\\u4e00-\\u9fa5]").matcher(str);
        int i = 0;
        while (matcher.find()) {
            for (int i2 = 0; i2 <= matcher.groupCount(); i2++) {
                i++;
            }
        }
        return i;
    }

    public static int getSpaceCount(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-630873819")) {
            return ((Integer) ipChange.ipc$dispatch("-630873819", new Object[]{str})).intValue();
        }
        if (str == null) {
            return 0;
        }
        return str.length() + getSpaceChineseCount(str);
    }

    public static String getSpaceSubString(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1021447181")) {
            return (String) ipChange.ipc$dispatch("1021447181", new Object[]{str, Integer.valueOf(i)});
        }
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            String substring = str.substring(0, i2);
            i2++;
            if (i2 < length) {
                if (getSpaceCount(substring) >= i - 1 && getSpaceCount(str.substring(0, i2)) <= i) {
                    return substring;
                }
            } else if (getSpaceCount(substring) >= i - 1) {
                return substring;
            }
        }
        return str;
    }

    public static int isTodayOrTomorrow(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-825205425")) {
            return ((Integer) ipChange.ipc$dispatch("-825205425", new Object[]{Long.valueOf(j)})).intValue();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis()));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date(j));
        if (calendar2.get(1) == calendar.get(1)) {
            int i = calendar2.get(6) - calendar.get(6);
            if (i == 0) {
                return 1;
            }
            if (i == 1) {
                return 2;
            }
        }
        return 0;
    }

    public static void onClickTitle(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "866141780")) {
            ipChange.ipc$dispatch("866141780", new Object[]{context});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (miLastClicktime == 0) {
            miLastClicktime = currentTimeMillis;
        }
        if (currentTimeMillis - miLastClicktime >= 2000) {
            miLastClicktime = currentTimeMillis;
            miClickCount = 0;
        }
        int i = miClickCount + 1;
        miClickCount = i;
        if (i >= 5) {
            miClickCount = 0;
            miLastClicktime = 0L;
            StartAutoCheckActivity(context);
        }
    }

    public static void saveLiveId(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "511173875")) {
            ipChange.ipc$dispatch("511173875", new Object[]{context, str});
        } else if (context == null || TextUtils.isEmpty(str)) {
        } else {
            context.getSharedPreferences(LiveVideosharePreferences, 0).edit().putString("carouselLiveId", str).apply();
        }
    }

    public static Date ParserDate(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1744901398") ? (Date) ipChange.ipc$dispatch("-1744901398", new Object[]{Integer.valueOf(i)}) : new Date(i * 1000);
    }

    public static String formatNumber(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-202712897")) {
            return (String) ipChange.ipc$dispatch("-202712897", new Object[]{Long.valueOf(j)});
        }
        DecimalFormat decimalFormat = new DecimalFormat(".#");
        if (j < 10000) {
            return j + "";
        } else if (j < 99999500) {
            String format = decimalFormat.format(j / 10000.0d);
            return format + "万";
        } else {
            String format2 = decimalFormat.format(j / 1.0E8d);
            return format2 + "亿";
        }
    }
}
