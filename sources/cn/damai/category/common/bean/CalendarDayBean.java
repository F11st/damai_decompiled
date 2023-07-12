package cn.damai.category.common.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CalendarDayBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 6648594110345421814L;
    public String configText;
    public int day;
    public List<String> desc;
    public int hasProject;
    public int isHoliday;
    public int isWorkDay;
    public String projectId;

    public int getDay() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1993935545") ? ((Integer) ipChange.ipc$dispatch("-1993935545", new Object[]{this})).intValue() : this.day;
    }

    public String getDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2086189033") ? (String) ipChange.ipc$dispatch("-2086189033", new Object[]{this}) : wh2.e(this.desc) > 0 ? this.desc.get(0) : "";
    }

    public boolean hasHoliday() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1132064800") ? ((Boolean) ipChange.ipc$dispatch("-1132064800", new Object[]{this})).booleanValue() : this.isHoliday == 1;
    }

    public boolean hasProject() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1980274305") ? ((Boolean) ipChange.ipc$dispatch("-1980274305", new Object[]{this})).booleanValue() : this.hasProject == 1;
    }

    public boolean hasWorkDay() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1353965427") ? ((Boolean) ipChange.ipc$dispatch("-1353965427", new Object[]{this})).booleanValue() : this.isWorkDay == 1;
    }
}
