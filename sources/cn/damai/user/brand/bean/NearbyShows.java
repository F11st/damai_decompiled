package cn.damai.user.brand.bean;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class NearbyShows implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String hasMore = "0";
    public List<ProjectItemBean> nearRepresentation;

    public boolean hasMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "884076641")) {
            return ((Boolean) ipChange.ipc$dispatch("884076641", new Object[]{this})).booleanValue();
        }
        String str = this.hasMore;
        return str != null && "1".equals(str);
    }
}
