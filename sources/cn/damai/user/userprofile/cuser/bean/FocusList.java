package cn.damai.user.userprofile.cuser.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class FocusList {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<Feeds> data;
    private boolean hasNext;

    public List<Feeds> getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1882274116") ? (List) ipChange.ipc$dispatch("1882274116", new Object[]{this}) : this.data;
    }

    public boolean getHasNext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2031777388") ? ((Boolean) ipChange.ipc$dispatch("-2031777388", new Object[]{this})).booleanValue() : this.hasNext;
    }

    public void setData(List<Feeds> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2032145656")) {
            ipChange.ipc$dispatch("-2032145656", new Object[]{this, list});
        } else {
            this.data = list;
        }
    }

    public void setHasNext(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-332280136")) {
            ipChange.ipc$dispatch("-332280136", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.hasNext = z;
        }
    }
}
