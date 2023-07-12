package cn.damai.tetris.component.drama.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class FilterDateBean {
    private static transient /* synthetic */ IpChange $ipChange;
    public String calendarText;
    public int dateType;
    public String endDate;
    public int index;
    public String startDate;

    public FilterDateBean() {
    }

    public static FilterDateBean defaultDateBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-375369313") ? (FilterDateBean) ipChange.ipc$dispatch("-375369313", new Object[0]) : new FilterDateBean("全部时间", 0, null, null, 0);
    }

    private boolean textEquals(String str, String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-90978583") ? ((Boolean) ipChange.ipc$dispatch("-90978583", new Object[]{this, str, str2})).booleanValue() : TextUtils.equals(str, str2);
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-831501986")) {
            return ((Boolean) ipChange.ipc$dispatch("-831501986", new Object[]{this, obj})).booleanValue();
        }
        if (obj instanceof FilterDateBean) {
            FilterDateBean filterDateBean = (FilterDateBean) obj;
            return textEquals(this.calendarText, filterDateBean.calendarText) && textEquals(this.startDate, filterDateBean.startDate) && textEquals(this.endDate, filterDateBean.endDate) && (this.dateType == filterDateBean.dateType);
        }
        return super.equals(obj);
    }

    public FilterDateBean(String str, int i, String str2, String str3, int i2) {
        this.calendarText = str;
        this.dateType = i;
        this.startDate = str2;
        this.endDate = str3;
        this.index = i2;
    }
}
