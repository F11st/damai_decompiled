package cn.damai.commonbusiness.calendarcopy.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.bb2;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class CalendarDayBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -6885182279018781882L;
    public String comboDispatchId;
    public String configText;
    public int day;
    public List<String> desc;
    public DispatchDesc dispatchDesc;
    public int hasProject;
    public int isHoliday;
    public int isWorkDay;
    public String itemId;
    public String projectId;

    public int getDay() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "731257260") ? ((Integer) ipChange.ipc$dispatch("731257260", new Object[]{this})).intValue() : this.day;
    }

    public String getDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "575536444") ? (String) ipChange.ipc$dispatch("575536444", new Object[]{this}) : bb2.a(this.desc) > 0 ? this.desc.get(0) : "";
    }

    public boolean hasHoliday() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1873643067") ? ((Boolean) ipChange.ipc$dispatch("-1873643067", new Object[]{this})).booleanValue() : this.isHoliday == 1;
    }

    public boolean hasProject() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1573114724") ? ((Boolean) ipChange.ipc$dispatch("1573114724", new Object[]{this})).booleanValue() : this.hasProject == 1;
    }

    public boolean hasWorkDay() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2095543694") ? ((Boolean) ipChange.ipc$dispatch("-2095543694", new Object[]{this})).booleanValue() : this.isWorkDay == 1;
    }
}
