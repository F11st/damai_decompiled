package cn.damai.projectfilter.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class FilterResponse implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public FilterPrimaryBean primary;
    public List<FilterGroupBean> secondary;

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1255583560") ? ((Boolean) ipChange.ipc$dispatch("1255583560", new Object[]{this})).booleanValue() : this.primary != null;
    }
}
