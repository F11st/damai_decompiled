package cn.damai.commonbusiness.calendar.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class CalendarDayBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -6885182279018781882L;
    public String configText;
    public int day;
    public List<String> desc;
    public DispatchDesc dispatchDesc;
    public int hasProject;
    public int isHoliday;
    public int isWorkDay;
    public String projectId;

    public int getDay() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "152044801") ? ((Integer) ipChange.ipc$dispatch("152044801", new Object[]{this})).intValue() : this.day;
    }

    public String getDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1529504431") ? (String) ipChange.ipc$dispatch("-1529504431", new Object[]{this}) : wh2.e(this.desc) > 0 ? this.desc.get(0) : "";
    }

    public boolean hasHoliday() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-41110886") ? ((Boolean) ipChange.ipc$dispatch("-41110886", new Object[]{this})).booleanValue() : this.isHoliday == 1;
    }

    public boolean hasProject() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-889320391") ? ((Boolean) ipChange.ipc$dispatch("-889320391", new Object[]{this})).booleanValue() : this.hasProject == 1;
    }

    public boolean hasWorkDay() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-263011513") ? ((Boolean) ipChange.ipc$dispatch("-263011513", new Object[]{this})).booleanValue() : this.isWorkDay == 1;
    }
}
