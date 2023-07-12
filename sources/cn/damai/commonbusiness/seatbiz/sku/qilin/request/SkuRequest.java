package cn.damai.commonbusiness.seatbiz.sku.qilin.request;

import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SkuRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String itemId;
    public String bizCode = "ali.china.damai";
    public String scenario = "itemsku";
    public SkuItem exParams = new SkuItem();

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-692005514") ? (String) ipChange.ipc$dispatch("-692005514", new Object[]{this}) : (AppConfig.v() && AppConfig.g() == AppConfig.EnvMode.prepare) ? "mtop.alibaba.detail.subpage.getdetail.center" : "mtop.alibaba.detail.subpage.getdetail";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1240389257")) {
            return ((Boolean) ipChange.ipc$dispatch("-1240389257", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1093242829")) {
            return ((Boolean) ipChange.ipc$dispatch("-1093242829", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1475731209")) {
            return (String) ipChange.ipc$dispatch("1475731209", new Object[]{this});
        }
        if (AppConfig.v()) {
            AppConfig.g();
            AppConfig.EnvMode envMode = AppConfig.EnvMode.prepare;
        }
        return "2.0";
    }
}
