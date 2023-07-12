package cn.damai.search.model;

import cn.damai.common.net.mtop.netfit.YouKuBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchSugWordRequest extends YouKuBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String keyword;
    public String appScene = "product_sug";
    public String appCaller = "da_mai_new";
    public String sdkver = "0";

    public SearchSugWordRequest(String str) {
        this.keyword = str;
    }

    @Override // cn.damai.common.net.mtop.netfit.YouKuBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1100165952") ? (String) ipChange.ipc$dispatch("1100165952", new Object[]{this}) : "mtop.youku.soku.yksearch";
    }

    @Override // cn.damai.common.net.mtop.netfit.YouKuBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1747726573")) {
            return ((Boolean) ipChange.ipc$dispatch("1747726573", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.YouKuBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1447916073")) {
            return ((Boolean) ipChange.ipc$dispatch("1447916073", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.YouKuBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1027064621") ? (String) ipChange.ipc$dispatch("-1027064621", new Object[]{this}) : "2.0";
    }
}
