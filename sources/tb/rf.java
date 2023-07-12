package tb;

import android.text.TextUtils;
import cn.damai.category.calendar.bean.CalendarEntity;
import cn.damai.category.calendar.bean.CalendarPerformEntity;
import cn.damai.category.calendar.bean.Day;
import cn.damai.category.common.bean.CalendarBean;
import cn.damai.category.common.bean.CalendarDayBean;
import cn.damai.category.common.bean.CalendarMonthBean;
import cn.damai.category.common.bean.CalendarYearBean;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class rf {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int AFTER_TODAY = 2;
    public static final int BEFORE_TODAY = 0;
    public static final int NOW_TODAY = 1;

    public static String a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "675478365")) {
            return (String) ipChange.ipc$dispatch("675478365", new Object[0]);
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.set(1, calendar.get(1) + 1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT, Locale.CHINA);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        return simpleDateFormat.format(calendar.getTime());
    }

    public static List<CalendarEntity> b(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-4140480")) {
            return (List) ipChange.ipc$dispatch("-4140480", new Object[]{Integer.valueOf(i)});
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        ArrayList arrayList = new ArrayList();
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        for (int i4 = i3; i4 <= 12; i4++) {
            CalendarEntity calendarEntity = new CalendarEntity();
            calendarEntity.year = i2;
            calendarEntity.month = i4;
            arrayList.add(calendarEntity);
        }
        int i5 = (12 - i3) + 1;
        for (int i6 = 1; i6 <= 12 - i5; i6++) {
            CalendarEntity calendarEntity2 = new CalendarEntity();
            calendarEntity2.year = i2 + 1;
            calendarEntity2.month = i6;
            arrayList.add(calendarEntity2);
        }
        return arrayList;
    }

    public static String c(Day day) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1796394610")) {
            return (String) ipChange.ipc$dispatch("1796394610", new Object[]{day});
        }
        if (day != null) {
            String str = day.month + "";
            if (day.month < 10) {
                str = "0" + day.month;
            }
            String str2 = day.day + "";
            if (day.day < 10) {
                str2 = "0" + str2;
            }
            return day.year + "-" + str + "-" + str2;
        }
        return null;
    }

    public static List<Day> d(int i, int i2, List<Day> list, CalendarMonthBean calendarMonthBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "834445488")) {
            return (List) ipChange.ipc$dispatch("834445488", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), list, calendarMonthBean});
        }
        ArrayList arrayList = new ArrayList();
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.set(i, i2, 0);
        int i3 = calendar.get(5);
        for (int i4 = 1; i4 <= i3; i4++) {
            Day day = new Day();
            day.year = i;
            day.month = i2;
            day.day = i4;
            if (wh2.e(list) > 0) {
                for (int i5 = 0; i5 < list.size(); i5++) {
                    Day day2 = list.get(i5);
                    if (day2 != null && i == day2.year && i2 == day2.month && i4 == day2.day) {
                        day.selectType = day2.selectType;
                    }
                }
            }
            if (calendarMonthBean != null && wh2.e(calendarMonthBean.days) > 0) {
                for (int i6 = 0; i6 < calendarMonthBean.days.size(); i6++) {
                    CalendarDayBean calendarDayBean = calendarMonthBean.days.get(i6);
                    if (calendarDayBean != null && calendarDayBean.day == i4) {
                        if (calendarDayBean.isHoliday == 1) {
                            day.tag = "休";
                        }
                        if (calendarDayBean.isWorkDay == 1) {
                            day.tag = "班";
                        }
                        if (wh2.e(calendarDayBean.desc) > 0 && calendarDayBean.desc.get(0) != null) {
                            day.tag = calendarDayBean.desc.get(0);
                        }
                        if ((i != q() || i2 != p() || calendarDayBean.day > n()) && !TextUtils.isEmpty(calendarDayBean.configText) && !TextUtils.isEmpty(calendarDayBean.projectId)) {
                            day.projectName = calendarDayBean.configText;
                            day.projectId = calendarDayBean.projectId;
                            day.project = day.projectName + "|" + day.projectId;
                        }
                    }
                }
            }
            arrayList.add(day);
        }
        return arrayList;
    }

    public static String e(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-78947769")) {
            return (String) ipChange.ipc$dispatch("-78947769", new Object[]{Integer.valueOf(i)});
        }
        if (i >= 10) {
            return i + "";
        }
        return "0" + i;
    }

    public static String f(int i, int i2, CalendarBean calendarBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1759979025")) {
            return (String) ipChange.ipc$dispatch("-1759979025", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), calendarBean});
        }
        String str = "";
        if (calendarBean != null && wh2.e(calendarBean.calendar) > 0) {
            for (int i3 = 0; i3 < calendarBean.calendar.size(); i3++) {
                CalendarYearBean calendarYearBean = calendarBean.calendar.get(i3);
                if (calendarYearBean != null && calendarYearBean.year == i && wh2.e(calendarYearBean.months) > 0) {
                    for (int i4 = 0; i4 < calendarYearBean.months.size(); i4++) {
                        CalendarMonthBean calendarMonthBean = calendarYearBean.months.get(i4);
                        if (calendarMonthBean != null && calendarMonthBean.month == i2) {
                            str = calendarMonthBean.desc;
                        }
                    }
                }
            }
        }
        return str;
    }

    public static int g(Day day) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2054176809")) {
            return ((Integer) ipChange.ipc$dispatch("2054176809", new Object[]{day})).intValue();
        }
        if (day != null) {
            if (day.year == q()) {
                return (day.month - p()) + 1;
            }
            return ((day.month + 12) - p()) + 1;
        }
        return 1;
    }

    public static int h(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1741798038")) {
            return ((Integer) ipChange.ipc$dispatch("-1741798038", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.set(i, i2 - 1, 1);
        return calendar.get(7);
    }

    public static List<Day> i(CalendarPerformEntity calendarPerformEntity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1649674771")) {
            return (List) ipChange.ipc$dispatch("-1649674771", new Object[]{calendarPerformEntity});
        }
        if (calendarPerformEntity == null) {
            return null;
        }
        int i = calendarPerformEntity.index;
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return m();
        }
        return k();
    }

    public static String j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-470525239")) {
            return (String) ipChange.ipc$dispatch("-470525239", new Object[0]);
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.set(6, calendar.get(6) + 6);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT, Locale.CHINA);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        return simpleDateFormat.format(calendar.getTime());
    }

    public static List<Day> k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1673693058")) {
            return (List) ipChange.ipc$dispatch("-1673693058", new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        int i = calendar.get(6);
        for (int i2 = 0; i2 < 7; i2++) {
            calendar.set(6, i + i2);
            arrayList.add(new Day(calendar.get(1), calendar.get(2) + 1, calendar.get(5)));
        }
        return arrayList;
    }

    public static String l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1759173560")) {
            return (String) ipChange.ipc$dispatch("1759173560", new Object[0]);
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.set(6, calendar.get(6) + 29);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT, Locale.CHINA);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        return simpleDateFormat.format(calendar.getTime());
    }

    public static List<Day> m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "169162223")) {
            return (List) ipChange.ipc$dispatch("169162223", new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        int i = calendar.get(6);
        for (int i2 = 0; i2 < 30; i2++) {
            calendar.set(6, i + i2);
            arrayList.add(new Day(calendar.get(1), calendar.get(2) + 1, calendar.get(5)));
        }
        return arrayList;
    }

    public static int n() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1118431620") ? ((Integer) ipChange.ipc$dispatch("1118431620", new Object[0])).intValue() : Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).get(5);
    }

    public static String o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "342449661")) {
            return (String) ipChange.ipc$dispatch("342449661", new Object[0]);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT, Locale.CHINA);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        return simpleDateFormat.format(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).getTime());
    }

    public static int p() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "966062188") ? ((Integer) ipChange.ipc$dispatch("966062188", new Object[0])).intValue() : Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).get(2) + 1;
    }

    public static int q() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "684475911") ? ((Integer) ipChange.ipc$dispatch("684475911", new Object[0])).intValue() : Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).get(1);
    }

    public static boolean r(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2004272003")) {
            return ((Boolean) ipChange.ipc$dispatch("-2004272003", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue();
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        return calendar.get(2) + 1 == i2 && calendar.get(1) == i;
    }
}
