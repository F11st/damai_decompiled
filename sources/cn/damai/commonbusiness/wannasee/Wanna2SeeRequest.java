package cn.damai.commonbusiness.wannasee;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.mine.mycollect.net.MyCollectApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class Wanna2SeeRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId;
    private boolean needLogin;
    public String pageNo;
    public String pageSize;
    public String subType;
    public String targetHavanaId;
    public String type;

    public Wanna2SeeRequest(String str, int i) {
        this.pageSize = "15";
        this.cityId = z20.c();
        this.type = str;
        this.pageNo = i + "";
        this.needLogin = true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1777223119") ? (String) ipChange.ipc$dispatch("-1777223119", new Object[]{this}) : MyCollectApi.MY_COLLECT_API;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1310246428") ? ((Boolean) ipChange.ipc$dispatch("1310246428", new Object[]{this})).booleanValue() : this.needLogin;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1936291736") ? ((Boolean) ipChange.ipc$dispatch("1936291736", new Object[]{this})).booleanValue() : this.needLogin;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "390513604") ? (String) ipChange.ipc$dispatch("390513604", new Object[]{this}) : "1.4";
    }

    public Wanna2SeeRequest(String str, int i, boolean z) {
        this.pageSize = "15";
        this.cityId = z20.c();
        this.type = str;
        this.pageNo = i + "";
        this.needLogin = z;
    }

    public Wanna2SeeRequest(String str, int i, boolean z, int i2) {
        this.pageSize = "15";
        this.cityId = z20.c();
        this.type = str;
        this.pageNo = i + "";
        this.needLogin = z;
        this.subType = i2 + "";
    }
}
