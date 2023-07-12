package cn.damai.commonbusiness.wannasee.model;

import cn.damai.commonbusiness.seatbiz.utils.RequestHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class AbsModel {
    private static transient /* synthetic */ IpChange $ipChange;
    protected RequestHolder mHolder = new RequestHolder();

    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1377407508")) {
            ipChange.ipc$dispatch("-1377407508", new Object[]{this});
        } else {
            this.mHolder.c();
        }
    }
}
