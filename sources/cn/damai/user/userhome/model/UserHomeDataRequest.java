package cn.damai.user.userhome.model;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UserHomeDataRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean mySelf = false;
    public String targetHavanaId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-662691743") ? (String) ipChange.ipc$dispatch("-662691743", new Object[]{this}) : "mtop.damai.wireless.user.my.content.get";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-380582420")) {
            return ((Boolean) ipChange.ipc$dispatch("-380582420", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "547406696")) {
            return ((Boolean) ipChange.ipc$dispatch("547406696", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1505044980") ? (String) ipChange.ipc$dispatch("1505044980", new Object[]{this}) : "1.2";
    }
}
