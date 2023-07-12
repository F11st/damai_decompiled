package cn.damai.launcher.splash.api;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class GuideRequest extends DMBaseMtopRequest implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2124460522") ? (String) ipChange.ipc$dispatch("-2124460522", new Object[]{this}) : "mtop.damai.wireless.guide.user.interest.get";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1134855383")) {
            return ((Boolean) ipChange.ipc$dispatch("1134855383", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "889222035")) {
            return ((Boolean) ipChange.ipc$dispatch("889222035", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "43276201") ? (String) ipChange.ipc$dispatch("43276201", new Object[]{this}) : "1.0";
    }
}
