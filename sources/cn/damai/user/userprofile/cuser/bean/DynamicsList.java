package cn.damai.user.userprofile.cuser.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class DynamicsList {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<Feeds> data;
    private boolean hasNext;
    public int pageNo;

    public List<Feeds> getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1451370640") ? (List) ipChange.ipc$dispatch("-1451370640", new Object[]{this}) : this.data;
    }

    public boolean getHasNext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "283969984") ? ((Boolean) ipChange.ipc$dispatch("283969984", new Object[]{this})).booleanValue() : this.hasNext;
    }

    public void setData(List<Feeds> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1999049308")) {
            ipChange.ipc$dispatch("1999049308", new Object[]{this, list});
        } else {
            this.data = list;
        }
    }

    public void setHasNext(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1558555636")) {
            ipChange.ipc$dispatch("-1558555636", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.hasNext = z;
        }
    }
}
