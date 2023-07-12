package cn.damai.common.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.v30;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class CustomDate implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    public int day;
    public int month;
    public int week;
    public int year;

    public CustomDate(int i, int i2, int i3) {
        if (i2 > 12) {
            i++;
            i2 = 1;
        } else if (i2 < 1) {
            i--;
            i2 = 12;
        }
        this.year = i;
        this.month = i2;
        this.day = i3;
    }

    public static CustomDate modifiDayForObject(CustomDate customDate, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1121999934") ? (CustomDate) ipChange.ipc$dispatch("-1121999934", new Object[]{customDate, Integer.valueOf(i)}) : new CustomDate(customDate.year, customDate.month, i);
    }

    public int getDay() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1413465616") ? ((Integer) ipChange.ipc$dispatch("1413465616", new Object[]{this})).intValue() : this.day;
    }

    public int getMonth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1066521684") ? ((Integer) ipChange.ipc$dispatch("-1066521684", new Object[]{this})).intValue() : this.month;
    }

    public int getWeek() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "648502192") ? ((Integer) ipChange.ipc$dispatch("648502192", new Object[]{this})).intValue() : this.week;
    }

    public int getYear() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1874943289") ? ((Integer) ipChange.ipc$dispatch("-1874943289", new Object[]{this})).intValue() : this.year;
    }

    public void setDay(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1490371078")) {
            ipChange.ipc$dispatch("-1490371078", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.day = i;
        }
    }

    public void setMonth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1448378658")) {
            ipChange.ipc$dispatch("-1448378658", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.month = i;
        }
    }

    public void setWeek(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1459818510")) {
            ipChange.ipc$dispatch("-1459818510", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.week = i;
        }
    }

    public void setYear(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1917750203")) {
            ipChange.ipc$dispatch("1917750203", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.year = i;
        }
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-328927575")) {
            return (String) ipChange.ipc$dispatch("-328927575", new Object[]{this});
        }
        return this.year + "-" + this.month + "-" + this.day;
    }

    public CustomDate() {
        this.year = v30.c();
        this.month = v30.b();
        this.day = v30.a();
    }
}
