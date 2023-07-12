package cn.damai.commonbusiness.calendarcopy.bean;

import androidx.annotation.Nullable;
import cn.damai.commonbusiness.calendarcopy.bean.DispatchDesc;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class Day implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int DAYTYPE_DEFAULT = 0;
    public static final int DAYTYPE_HOLIDAY = 2;
    public static final int DAYTYPE_WORKDAY = 1;
    public static final int SELECTTYPE_DEFAULT = 0;
    public static final int SELECTTYPE_END = 3;
    public static final int SELECTTYPE_MIDDLE = 4;
    public static final int SELECTTYPE_SINGLE = 1;
    public static final int SELECTTYPE_START = 2;
    private static final long serialVersionUID = -5927147184520542346L;
    public String comboDispatchId;
    public int day;
    public int dayType;
    public String itemId;
    public int month;
    public String project;
    public String projectId;
    public String projectName;
    public String tag;
    public String tip;
    public DispatchDesc.TYPE tipBg;
    public String weekStr;
    public int year;
    public int selectType = 0;
    public int showType = 0;
    public boolean isToday = false;

    public Day() {
    }

    private String for2L(int i) {
        StringBuilder sb;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2081294199")) {
            return (String) ipChange.ipc$dispatch("2081294199", new Object[]{this, Integer.valueOf(i)});
        }
        if ((i + "").length() == 1) {
            sb = new StringBuilder();
            sb.append("0");
            sb.append(i);
        } else {
            sb = new StringBuilder();
            sb.append(i);
            sb.append("");
        }
        return sb.toString();
    }

    public boolean equals(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "131538542")) {
            return ((Boolean) ipChange.ipc$dispatch("131538542", new Object[]{this, obj})).booleanValue();
        }
        if (obj instanceof Day) {
            Day day = (Day) obj;
            return this.year == day.year && this.month == day.month && this.day == day.day;
        }
        return super.equals(obj);
    }

    public String getWeekStr() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1709433338")) {
            return (String) ipChange.ipc$dispatch("1709433338", new Object[]{this});
        }
        String str = this.weekStr;
        if (str != null) {
            return str;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(this.year, this.month - 1, this.day);
        switch (calendar.get(7)) {
            case 1:
                this.weekStr = "周日";
                break;
            case 2:
                this.weekStr = "周一";
                break;
            case 3:
                this.weekStr = "周二";
                break;
            case 4:
                this.weekStr = "周三";
                break;
            case 5:
                this.weekStr = "周四";
                break;
            case 6:
                this.weekStr = "周五";
                break;
            default:
                this.weekStr = "周六";
                break;
        }
        return this.weekStr;
    }

    public boolean isAfterDay(Day day) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1701105138")) {
            return ((Boolean) ipChange.ipc$dispatch("1701105138", new Object[]{this, day})).booleanValue();
        }
        if (day == null) {
            return false;
        }
        int i = this.year;
        int i2 = day.year;
        if (i > i2) {
            return true;
        }
        if (i != i2 || this.month <= day.month) {
            return i == i2 && this.month == day.month && this.day > day.day;
        }
        return true;
    }

    @Deprecated
    public String toShortDateString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "456478595")) {
            return (String) ipChange.ipc$dispatch("456478595", new Object[]{this});
        }
        return for2L(this.month) + for2L(this.day);
    }

    public Date toSimpleDate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "947533317")) {
            return (Date) ipChange.ipc$dispatch("947533317", new Object[]{this});
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT);
        try {
            return simpleDateFormat.parse(this.year + "-" + this.month + "-" + this.day);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toSimpleDateString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "229973343")) {
            return (String) ipChange.ipc$dispatch("229973343", new Object[]{this});
        }
        return this.year + "-" + this.month + "-" + this.day;
    }

    public String toSimpleShortDateString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1924880049")) {
            return (String) ipChange.ipc$dispatch("1924880049", new Object[]{this});
        }
        return "" + this.month + "." + this.day;
    }

    public Day(int i, int i2, int i3) {
        this.year = i;
        this.month = i2;
        this.day = i3;
    }
}
