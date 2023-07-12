package cn.damai.commonbusiness.calendarcopy.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.nm1;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class CalendarBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int DATETYPE_ALL = 0;
    public static final int DATETYPE_FREE = 5;
    public static final int DATETYPE_MONTH = 4;
    public static final int DATETYPE_WEEK = 10;
    public static final int DATETYPE_WEEKEND = 9;
    public static final String NAME_DEFAULT_ALLTIME = "全部时间";
    private static final long serialVersionUID = 6338030185011755282L;
    public List<CalendarYearBean> calendar;
    public String dateType;
    public String endDate;
    public String name;
    public String startDate;

    public CalendarBean() {
    }

    public static CalendarBean defaultAllTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2020947497") ? (CalendarBean) ipChange.ipc$dispatch("2020947497", new Object[0]) : new CalendarBean("全部时间", "0");
    }

    public static CalendarBean friday2SunDay() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "677251923") ? (CalendarBean) ipChange.ipc$dispatch("677251923", new Object[0]) : new CalendarBean("本周末", "9");
    }

    public static CalendarBean to30Days() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "936128555") ? (CalendarBean) ipChange.ipc$dispatch("936128555", new Object[0]) : new CalendarBean("一月内", "4");
    }

    public static CalendarBean to7days() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-181570557") ? (CalendarBean) ipChange.ipc$dispatch("-181570557", new Object[0]) : new CalendarBean("一周内", "10");
    }

    public static CalendarBean transfer2ConstantCalendarBeanIfCann(CalendarBean calendarBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1976837105")) {
            return (CalendarBean) ipChange.ipc$dispatch("-1976837105", new Object[]{calendarBean});
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(defaultAllTime());
        arrayList.add(to7days());
        arrayList.add(to30Days());
        arrayList.add(friday2SunDay());
        int indexOf = arrayList.indexOf(calendarBean);
        return indexOf >= 0 ? (CalendarBean) arrayList.get(indexOf) : calendarBean;
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-442244400")) {
            return ((Boolean) ipChange.ipc$dispatch("-442244400", new Object[]{this, obj})).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CalendarBean calendarBean = (CalendarBean) obj;
        return nm1.a(this.dateType, calendarBean.dateType) && nm1.a(this.startDate, calendarBean.startDate) && nm1.a(this.endDate, calendarBean.endDate);
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-881887609") ? ((Integer) ipChange.ipc$dispatch("-881887609", new Object[]{this})).intValue() : nm1.b(this.dateType, this.startDate, this.endDate);
    }

    public CalendarBean(String str, String str2) {
        this.name = str;
        this.dateType = str2;
    }
}
