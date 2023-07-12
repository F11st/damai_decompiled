package tb;

import android.text.TextUtils;
import cn.damai.commonbusiness.calendarcopy.bean.CalendarBean;
import cn.damai.commonbusiness.calendarcopy.bean.CalendarDayBean;
import cn.damai.commonbusiness.calendarcopy.bean.CalendarEntity;
import cn.damai.commonbusiness.calendarcopy.bean.CalendarMonthBean;
import cn.damai.commonbusiness.calendarcopy.bean.CalendarYearBean;
import cn.damai.commonbusiness.calendarcopy.bean.Day;
import cn.damai.commonbusiness.calendarcopy.bean.DispatchDesc;
import com.alimm.xadsdk.base.constant.AdConstants;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class of {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int AFTER_TODAY = 2;
    public static final int BEFORE_TODAY = 0;
    public static final int NOW_TODAY = 1;

    public static List<Day> a(List<CalendarEntity> list, List<CalendarYearBean> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "703755122")) {
            return (List) ipChange.ipc$dispatch("703755122", new Object[]{list, list2});
        }
        ArrayList arrayList = new ArrayList((int) AdConstants.TEMPLATE_LONG_VIDEO_INTERACTION);
        HashMap hashMap = new HashMap();
        if (!bb2.d(list2)) {
            for (CalendarYearBean calendarYearBean : list2) {
                HashMap hashMap2 = (HashMap) hashMap.get(Integer.valueOf(calendarYearBean.year));
                if (hashMap2 == null) {
                    hashMap2 = new HashMap();
                    hashMap.put(Integer.valueOf(calendarYearBean.year), hashMap2);
                }
                List<CalendarMonthBean> list3 = calendarYearBean.months;
                if (!bb2.d(list3)) {
                    for (CalendarMonthBean calendarMonthBean : list3) {
                        hashMap2.put(Integer.valueOf(calendarMonthBean.month), calendarMonthBean);
                    }
                }
            }
        }
        if (!bb2.d(list)) {
            for (CalendarEntity calendarEntity : list) {
                HashMap hashMap3 = (HashMap) hashMap.get(Integer.valueOf(calendarEntity.year));
                List<Day> c = c(calendarEntity.year, calendarEntity.month, null, !bb2.e(hashMap3) ? (CalendarMonthBean) hashMap3.get(Integer.valueOf(calendarEntity.month)) : null);
                if (!bb2.d(c)) {
                    arrayList.addAll(c);
                }
            }
        }
        return arrayList;
    }

    public static List<CalendarEntity> b(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-149792859")) {
            return (List) ipChange.ipc$dispatch("-149792859", new Object[]{Integer.valueOf(i)});
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
        if (AndroidInstantRuntime.support(ipChange, "-1507661232")) {
            return (List) ipChange.ipc$dispatch("-1507661232", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), list, calendarMonthBean});
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
            if (bb2.c(list) > 0) {
                for (int i5 = 0; i5 < list.size(); i5++) {
                    Day day2 = list.get(i5);
                    if (day2 != null && i == day2.year && i2 == day2.month && i4 == day2.day) {
                        day.selectType = day2.selectType;
                    }
                }
            }
            if (calendarMonthBean != null && bb2.c(calendarMonthBean.days) > 0) {
                for (int i6 = 0; i6 < calendarMonthBean.days.size(); i6++) {
                    CalendarDayBean calendarDayBean = calendarMonthBean.days.get(i6);
                    if (calendarDayBean != null && calendarDayBean.day == i4) {
                        day.itemId = calendarDayBean.itemId;
                        day.comboDispatchId = calendarDayBean.comboDispatchId;
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
                        if (i == p() && i2 == n()) {
                            m();
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
        if (AndroidInstantRuntime.support(ipChange, "-1292001598")) {
            return (String) ipChange.ipc$dispatch("-1292001598", new Object[]{Integer.valueOf(i)});
        }
        if (i >= 10) {
            return i + "";
        }
        return "0" + i;
    }

    public static String e(int i, int i2, CalendarBean calendarBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1131524849")) {
            return (String) ipChange.ipc$dispatch("-1131524849", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), calendarBean});
        }
        String str = "";
        if (calendarBean != null && bb2.c(calendarBean.calendar) > 0) {
            for (int i3 = 0; i3 < calendarBean.calendar.size(); i3++) {
                CalendarYearBean calendarYearBean = calendarBean.calendar.get(i3);
                if (calendarYearBean != null && calendarYearBean.year == i && bb2.c(calendarYearBean.months) > 0) {
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
        if (AndroidInstantRuntime.support(ipChange, "-1077013706")) {
            return ((Integer) ipChange.ipc$dispatch("-1077013706", new Object[]{day})).intValue();
        }
        if (day != null) {
            if (day.year == p()) {
                return (day.month - n()) + 1;
            }
            return ((day.month + 12) - n()) + 1;
        }
        return 1;
    }

    public static List<Day> g(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-677531885")) {
            return (List) ipChange.ipc$dispatch("-677531885", new Object[]{Integer.valueOf(i)});
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
        if (AndroidInstantRuntime.support(ipChange, "591064975")) {
            return ((Integer) ipChange.ipc$dispatch("591064975", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.set(i, i2 - 1, 1);
        return calendar.get(7);
    }

    private static List<Day> i(CalendarBean calendarBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1417074100")) {
            return (List) ipChange.ipc$dispatch("1417074100", new Object[]{calendarBean});
        }
        ArrayList arrayList = new ArrayList();
        if (calendarBean != null && !TextUtils.isEmpty(calendarBean.startDate)) {
            Date s = s(calendarBean.startDate);
            if (TextUtils.isEmpty(calendarBean.endDate)) {
                calendarBean.endDate = calendarBean.startDate;
            }
            Date s2 = s(calendarBean.endDate);
            if (s == null) {
                return arrayList;
            }
            int time = (int) ((s2.getTime() - s.getTime()) / 86400000);
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
            for (int i = 0; i <= time; i++) {
                calendar.setTime(s);
                calendar.add(5, i);
                arrayList.add(new Day(calendar.get(1), calendar.get(2) + 1, calendar.get(5)));
            }
        }
        return arrayList;
    }

    public static List<Day> j(CalendarBean calendarBean) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "540163336")) {
            return (List) ipChange.ipc$dispatch("540163336", new Object[]{calendarBean});
        }
        try {
            i = Integer.parseInt(calendarBean.dateType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i == 10) {
            return k();
        }
        if (i == 4) {
            return l();
        }
        if (i == 9) {
            return q();
        }
        if (i != 5) {
            if (i == 0) {
                return new ArrayList();
            }
            return null;
        }
        try {
            return i(calendarBean);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static List<Day> k() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-764581895") ? (List) ipChange.ipc$dispatch("-764581895", new Object[0]) : g(7);
    }

    public static List<Day> l() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1713162796") ? (List) ipChange.ipc$dispatch("-1713162796", new Object[0]) : g(30);
    }

    public static int m() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-299937345") ? ((Integer) ipChange.ipc$dispatch("-299937345", new Object[0])).intValue() : Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).get(5);
    }

    public static int n() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1273918737") ? ((Integer) ipChange.ipc$dispatch("1273918737", new Object[0])).intValue() : Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).get(2) + 1;
    }

    public static int o() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1693831595") ? ((Integer) ipChange.ipc$dispatch("1693831595", new Object[0])).intValue() : Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).get(7);
    }

    public static int p() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-829613886") ? ((Integer) ipChange.ipc$dispatch("-829613886", new Object[0])).intValue() : Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).get(1);
    }

    public static List<Day> q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "496627970")) {
            return (List) ipChange.ipc$dispatch("496627970", new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        if (o() != 1) {
            if (o() <= 6) {
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

    public static boolean r(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "590673634")) {
            return ((Boolean) ipChange.ipc$dispatch("590673634", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue();
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        return calendar.get(2) + 1 == i2 && calendar.get(1) == i;
    }

    public static Date s(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "859082143")) {
            return (Date) ipChange.ipc$dispatch("859082143", new Object[]{str});
        }
        try {
            return new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Day t() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1137441043")) {
            return (Day) ipChange.ipc$dispatch("1137441043", new Object[0]);
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        Day day = new Day();
        day.year = i;
        day.month = i2 + 1;
        day.day = i3;
        return day;
    }
}
