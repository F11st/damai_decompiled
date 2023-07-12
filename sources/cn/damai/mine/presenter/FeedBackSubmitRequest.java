package cn.damai.mine.presenter;

import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.e80;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class FeedBackSubmitRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String bizIdentifiers;
    public String content;
    public String extra;
    public String fromPage;
    public String imageAddrs;
    public String module;
    public String resolution;
    public String mpopKey = AppConfig.c();
    public String mpopType = "damai_android";
    public String osVersion = e80.e();
    public String model = e80.b();
    public String loginKey = z20.q();
    public String city = z20.d();

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1875523384") ? (String) ipChange.ipc$dispatch("-1875523384", new Object[]{this}) : "mtop.damai.wireless.user.feedback.add";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1649263515")) {
            return ((Boolean) ipChange.ipc$dispatch("-1649263515", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1115586465")) {
            return ((Boolean) ipChange.ipc$dispatch("1115586465", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "292213339") ? (String) ipChange.ipc$dispatch("292213339", new Object[]{this}) : "1.0";
    }
}
