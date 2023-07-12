package tb;

import android.os.SystemClock;
import android.text.TextUtils;
import cn.damai.commonbusiness.calendar.bean.CalendarBean;
import cn.damai.commonbusiness.calendar.bean.CalendarDayBean;
import cn.damai.commonbusiness.calendar.bean.CalendarEntity;
import cn.damai.commonbusiness.calendar.bean.CalendarMonthBean;
import cn.damai.commonbusiness.calendar.bean.CalendarYearBean;
import cn.damai.commonbusiness.calendar.bean.Day;
import cn.damai.commonbusiness.calendar.bean.DispatchDesc;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class nf {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int AFTER_TODAY = 2;
    public static final int BEFORE_TODAY = 0;
    public static final int NOW_TODAY = 1;

    public static String a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-662897181")) {
            return (String) ipChange.ipc$dispatch("-662897181", new Object[0]);
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.set(1, calendar.get(1) + 1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT, Locale.CHINA);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        return simpleDateFormat.format(calendar.getTime());
    }

    public static List<CalendarEntity> b(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1950667770")) {
            return (List) ipChange.ipc$dispatch("1950667770", new Object[]{Integer.valueOf(i)});
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

    public static List<Day> c(int i, int i2, List<Day> list, CalendarMonthBean calendarMonthBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-716976912")) {
            return (List) ipChange.ipc$dispatch("-716976912", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), list, calendarMonthBean});
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
                        if (!TextUtils.isEmpty(calendarDayBean.getDesc())) {
                            day.tag = calendarDayBean.getDesc();
                        }
                        DispatchDesc dispatchDesc = calendarDayBean.dispatchDesc;
                        if (dispatchDesc != null && !TextUtils.isEmpty(dispatchDesc.desc)) {
                            DispatchDesc dispatchDesc2 = calendarDayBean.dispatchDesc;
                            day.tip = dispatchDesc2.desc;
                            day.tipBg = DispatchDesc.TYPE.fromTypeName(dispatchDesc2.color);
                        }
                        if (calendarDayBean.hasWorkDay()) {
                            day.dayType = 1;
                        } else if (calendarDayBean.hasHoliday()) {
                            day.dayType = 2;
                        } else {
                            day.dayType = 0;
                        }
                        if (i == o() && i2 == m()) {
                            k();
                        }
                    }
                }
            }
            arrayList.add(day);
        }
        return arrayList;
    }

    public static String d(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "152061517")) {
            return (String) ipChange.ipc$dispatch("152061517", new Object[]{Integer.valueOf(i)});
        }
        if (i >= 10) {
            return i + "";
        }
        return "0" + i;
    }

    public static String e(int i, int i2, CalendarBean calendarBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-641221841")) {
            return (String) ipChange.ipc$dispatch("-641221841", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), calendarBean});
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

    public static int f(Day day) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "50921238")) {
            return ((Integer) ipChange.ipc$dispatch("50921238", new Object[]{day})).intValue();
        }
        if (day != null) {
            if (day.year == o()) {
                return (day.month - m()) + 1;
            }
            return ((day.month + 12) - m()) + 1;
        }
        return 1;
    }

    public static List<Day> g(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1514688616")) {
            return (List) ipChange.ipc$dispatch("1514688616", new Object[]{Integer.valueOf(i)});
        }
        ArrayList arrayList = new ArrayList();
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        arrayList.add(new Day(calendar.get(1), calendar.get(2) + 1, calendar.get(5)));
        for (int i2 = 0; i2 < i - 1; i2++) {
            calendar.add(6, 1);
            arrayList.add(new Day(calendar.get(1), calendar.get(2) + 1, calendar.get(5)));
        }
        return arrayList;
    }

    public static int h(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1652919132")) {
            return ((Integer) ipChange.ipc$dispatch("-1652919132", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.set(i, i2 - 1, 1);
        return calendar.get(7);
    }

    public static List<Day> i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1596339580") ? (List) ipChange.ipc$dispatch("-1596339580", new Object[0]) : g(7);
    }

    public static List<Day> j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1727847255") ? (List) ipChange.ipc$dispatch("-1727847255", new Object[0]) : g(30);
    }

    public static int k() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1075654390") ? ((Integer) ipChange.ipc$dispatch("-1075654390", new Object[0])).intValue() : Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).get(5);
    }

    public static String l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1617525193")) {
            return (String) ipChange.ipc$dispatch("-1617525193", new Object[0]);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT, Locale.CHINA);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        return simpleDateFormat.format(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).getTime());
    }

    public static int m() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1400753318") ? ((Integer) ipChange.ipc$dispatch("1400753318", new Object[0])).intValue() : Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).get(2) + 1;
    }

    public static int n() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1627212938") ? ((Integer) ipChange.ipc$dispatch("-1627212938", new Object[0])).intValue() : Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).get(7);
    }

    public static int o() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "144308877") ? ((Integer) ipChange.ipc$dispatch("144308877", new Object[0])).intValue() : Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).get(1);
    }

    public static List<Day> p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1608412905")) {
            return (List) ipChange.ipc$dispatch("-1608412905", new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        if (n() != 1) {
            if (n() <= 6) {
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
                calendar.set(7, 6);
                arrayList.add(new Day(calendar.get(1), calendar.get(2) + 1, calendar.get(5)));
            }
            Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
            calendar2.set(7, 7);
            arrayList.add(new Day(calendar2.get(1), calendar2.get(2) + 1, calendar2.get(5)));
        }
        Calendar calendar3 = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar3.setFirstDayOfWeek(2);
        calendar3.set(7, 1);
        arrayList.add(new Day(calendar3.get(1), calendar3.get(2) + 1, calendar3.get(5)));
        return arrayList;
    }

    public static String q(long j, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1619410400")) {
            return (String) ipChange.ipc$dispatch("-1619410400", new Object[]{Long.valueOf(j), Long.valueOf(j2)});
        }
        long elapsedRealtime = j + (SystemClock.elapsedRealtime() - jo2.a);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM.dd ", Locale.CHINA);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
        calendar.setTimeInMillis(elapsedRealtime);
        calendar.set(10, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
        calendar2.setTimeInMillis(j2);
        calendar2.set(10, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        int timeInMillis = (int) (((calendar2.getTimeInMillis() - calendar.getTimeInMillis()) + DanmakuFactory.DEFAULT_DANMAKU_DURATION_V) / 86400000);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm", Locale.CHINA);
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String format = simpleDateFormat2.format(Long.valueOf(j2));
        if (timeInMillis == 0) {
            return "今天 " + format;
        } else if (timeInMillis == 1) {
            return "明天 " + format;
        } else {
            String str = calendar2.get(7) == 7 ? "周六" : "";
            if (calendar2.get(7) == 1) {
                str = "周日";
            }
            if (calendar2.get(7) == 2) {
                str = "周一";
            }
            if (calendar2.get(7) == 3) {
                str = "周二";
            }
            if (calendar2.get(7) == 4) {
                str = "周三";
            }
            if (calendar2.get(7) == 5) {
                str = "周四";
            }
            if (calendar2.get(7) == 6) {
                str = "周五";
            }
            return simpleDateFormat.format(Long.valueOf(j2)) + str;
        }
    }

    public static boolean r(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1512073161")) {
            return ((Boolean) ipChange.ipc$dispatch("-1512073161", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue();
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        return calendar.get(2) + 1 == i2 && calendar.get(1) == i;
    }

    public static Date s(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1092360972")) {
            return (Date) ipChange.ipc$dispatch("-1092360972", new Object[]{str});
        }
        try {
            return new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
