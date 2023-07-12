package cn.damai.user.userhome.model;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UserDynamicRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String contentLabelList;
    public String publisherId;
    public int pageIndex = 1;
    public String pageSize = "15";
    public boolean queryRelatedInfo = true;
    public boolean queryContentLabel = true;
    public String subTypeList = "[23,32,62,65,66,75]";
    public int dataModule = 1;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "122077141") ? (String) ipChange.ipc$dispatch("122077141", new Object[]{this}) : "mtop.damai.wireless.content.card.get";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1944736520")) {
            return ((Boolean) ipChange.ipc$dispatch("-1944736520", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "633870196")) {
            return ((Boolean) ipChange.ipc$dispatch("633870196", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2005153432") ? (String) ipChange.ipc$dispatch("-2005153432", new Object[]{this}) : "1.1";
    }
}
