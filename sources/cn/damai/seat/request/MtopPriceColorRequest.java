package cn.damai.seat.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class MtopPriceColorRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId;
    public String performanceId;
    public String projectId;
    public String standIds;
    public String datasource = "3";
    public String channel = "1001000100020002";
    public String dmChannel = "*@damai_android_*";

    public MtopPriceColorRequest(long j, long j2, String str) {
        this.projectId = j + "";
        this.performanceId = j2 + "";
        this.cityId = str;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1266305356") ? (String) ipChange.ipc$dispatch("-1266305356", new Object[]{this}) : "mtop.damai.wireless.seat.querypricecolor";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-654724103")) {
            return ((Boolean) ipChange.ipc$dispatch("-654724103", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-909745611")) {
            return ((Boolean) ipChange.ipc$dispatch("-909745611", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "901431367") ? (String) ipChange.ipc$dispatch("901431367", new Object[]{this}) : "1.2";
    }

    public MtopPriceColorRequest(String str, String str2, String str3, String str4) {
        this.projectId = str;
        this.performanceId = str2;
        this.cityId = str3;
        this.standIds = str4;
    }
}
