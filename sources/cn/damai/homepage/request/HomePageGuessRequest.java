package cn.damai.homepage.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class HomePageGuessRequest extends DMBaseMtopRequest implements IHomeFeedReq {
    private static transient /* synthetic */ IpChange $ipChange;
    public String apiVersion = "2.0";
    public String cityId;
    public String latitude;
    public String longitude;
    public String offset;
    public int pageNum;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1877718930") ? (String) ipChange.ipc$dispatch("-1877718930", new Object[]{this}) : "mtop.damai.wireless.home.guess.get";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1364534655")) {
            return ((Boolean) ipChange.ipc$dispatch("1364534655", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1727296965")) {
            return ((Boolean) ipChange.ipc$dispatch("-1727296965", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "290017793") ? (String) ipChange.ipc$dispatch("290017793", new Object[]{this}) : "2.2";
    }

    @Override // cn.damai.homepage.request.IHomeFeedReq
    public void setCityId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1887087445")) {
            ipChange.ipc$dispatch("-1887087445", new Object[]{this, str});
        } else {
            this.cityId = str;
        }
    }

    @Override // cn.damai.homepage.request.IHomeFeedReq
    public void setLatitude(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-139272347")) {
            ipChange.ipc$dispatch("-139272347", new Object[]{this, str});
        } else {
            this.latitude = str;
        }
    }

    @Override // cn.damai.homepage.request.IHomeFeedReq
    public void setLongitude(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "282396574")) {
            ipChange.ipc$dispatch("282396574", new Object[]{this, str});
        } else {
            this.longitude = str;
        }
    }

    @Override // cn.damai.homepage.request.IHomeFeedReq
    public void setOffset(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1662975458")) {
            ipChange.ipc$dispatch("-1662975458", new Object[]{this, str});
            return;
        }
        this.offset = str + "";
    }

    @Override // cn.damai.homepage.request.IHomeFeedReq
    public void setPageNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "983151607")) {
            ipChange.ipc$dispatch("983151607", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.pageNum = i;
        }
    }
}
