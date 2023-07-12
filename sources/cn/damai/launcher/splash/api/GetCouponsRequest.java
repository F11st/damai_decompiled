package cn.damai.launcher.splash.api;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class GetCouponsRequest extends DMBaseMtopRequest implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1394940021") ? (String) ipChange.ipc$dispatch("-1394940021", new Object[]{this}) : "mtop.damai.wireless.guide.dispatchdata.get";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1593192446")) {
            return ((Boolean) ipChange.ipc$dispatch("-1593192446", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-834691074")) {
            return ((Boolean) ipChange.ipc$dispatch("-834691074", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "772796702") ? (String) ipChange.ipc$dispatch("772796702", new Object[]{this}) : "1.0";
    }
}
