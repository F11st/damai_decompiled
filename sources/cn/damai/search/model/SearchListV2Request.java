package cn.damai.search.model;

import cn.damai.common.net.mtop.netfit.YouKuBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.net.URLEncoder;
import java.util.HashMap;
import tb.m61;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchListV2Request extends YouKuBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String aaid;
    public String categories;
    public String extentionParameters;
    public String keyword;
    public int pg;
    public int pz = 15;
    public String cityId = z20.c();
    public String longitude = "";
    public String latitude = "";
    public String appScene = "da_mai_new";
    public String appCaller = "da_mai_new";
    public String sdkVersion = "2";

    public SearchListV2Request() {
        HashMap hashMap = new HashMap();
        hashMap.put("withdraw_recall_flag", "1");
        try {
            this.extentionParameters = URLEncoder.encode(m61.e(hashMap), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // cn.damai.common.net.mtop.netfit.YouKuBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1239185943") ? (String) ipChange.ipc$dispatch("1239185943", new Object[]{this}) : "mtop.youku.soku.yksearch";
    }

    @Override // cn.damai.common.net.mtop.netfit.YouKuBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-715196682")) {
            return ((Boolean) ipChange.ipc$dispatch("-715196682", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.YouKuBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1105648114")) {
            return ((Boolean) ipChange.ipc$dispatch("1105648114", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.YouKuBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-888044630") ? (String) ipChange.ipc$dispatch("-888044630", new Object[]{this}) : "2.0";
    }
}
