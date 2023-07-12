package cn.damai.commonbusiness.seatbiz.promotion.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CreditsExchangeRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String asac;
    public String exchange4Dm;
    public String lotteryMixId;
    public String platform;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1895569198") ? (String) ipChange.ipc$dispatch("-1895569198", new Object[]{this}) : "mtop.film.MtopLuckyDrawAPI.newLotteryDraw";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1833660232") ? (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("1833660232", new Object[]{this}) : DMBaseMtopRequest.HttpMethod.POST;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-359839333")) {
            return ((Boolean) ipChange.ipc$dispatch("-359839333", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-993323177")) {
            return ((Boolean) ipChange.ipc$dispatch("-993323177", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "272167525") ? (String) ipChange.ipc$dispatch("272167525", new Object[]{this}) : "9.0";
    }
}
