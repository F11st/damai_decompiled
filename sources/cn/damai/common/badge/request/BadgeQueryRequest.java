package cn.damai.common.badge.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class BadgeQueryRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String queryString;
    public String clientPlatform = "android";
    public String apiVersion = "1";
    public boolean eCode = true;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1015082717") ? (String) ipChange.ipc$dispatch("1015082717", new Object[]{this}) : "mtop.damai.wireless.badge.query";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2131472656") ? ((Boolean) ipChange.ipc$dispatch("-2131472656", new Object[]{this})).booleanValue() : this.eCode;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1569069932") ? ((Boolean) ipChange.ipc$dispatch("1569069932", new Object[]{this})).booleanValue() : this.eCode;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1112147856") ? (String) ipChange.ipc$dispatch("-1112147856", new Object[]{this}) : "1.0";
    }
}
