package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.request;

import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectItemDetailRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String itemId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "750241505") ? (String) ipChange.ipc$dispatch("750241505", new Object[]{this}) : (AppConfig.v() && AppConfig.g() == AppConfig.EnvMode.prepare) ? "mtop.alibaba.damai.detail.getdetail.center" : "mtop.alibaba.damai.detail.getdetail";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2054638937") ? (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("2054638937", new Object[]{this}) : DMBaseMtopRequest.HttpMethod.POST;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "311488364")) {
            return ((Boolean) ipChange.ipc$dispatch("311488364", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-92500760")) {
            return ((Boolean) ipChange.ipc$dispatch("-92500760", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1376989068")) {
            return (String) ipChange.ipc$dispatch("-1376989068", new Object[]{this});
        }
        if (AppConfig.v()) {
            AppConfig.g();
            AppConfig.EnvMode envMode = AppConfig.EnvMode.prepare;
        }
        return "1.2";
    }
}
