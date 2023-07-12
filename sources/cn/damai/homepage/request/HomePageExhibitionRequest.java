package cn.damai.homepage.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class HomePageExhibitionRequest extends DMBaseMtopRequest implements IHomeFeedReq, Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String HOME_API_HOMEPAGE_EXHIBITION_DYNAMIC = "mtop.damai.wireless.home.recommend.feed.get";
    public String apiVersion = "1.0";
    public String cityId;
    public String dispatchCardCode;
    public String groupId;
    public String offset;
    public int pageNo;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-651394010") ? (String) ipChange.ipc$dispatch("-651394010", new Object[]{this}) : HOME_API_HOMEPAGE_EXHIBITION_DYNAMIC;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-999034681")) {
            return ((Boolean) ipChange.ipc$dispatch("-999034681", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1079729277")) {
            return ((Boolean) ipChange.ipc$dispatch("-1079729277", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1516342713") ? (String) ipChange.ipc$dispatch("1516342713", new Object[]{this}) : this.apiVersion;
    }

    @Override // cn.damai.homepage.request.IHomeFeedReq
    public void setCityId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-660762525")) {
            ipChange.ipc$dispatch("-660762525", new Object[]{this, str});
        } else {
            this.cityId = str;
        }
    }

    @Override // cn.damai.homepage.request.IHomeFeedReq
    public void setLatitude(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1537936669")) {
            ipChange.ipc$dispatch("1537936669", new Object[]{this, str});
        }
    }

    @Override // cn.damai.homepage.request.IHomeFeedReq
    public void setLongitude(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "736268518")) {
            ipChange.ipc$dispatch("736268518", new Object[]{this, str});
        }
    }

    @Override // cn.damai.homepage.request.IHomeFeedReq
    public void setOffset(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-436650538")) {
            ipChange.ipc$dispatch("-436650538", new Object[]{this, str});
            return;
        }
        this.offset = str + "";
    }

    @Override // cn.damai.homepage.request.IHomeFeedReq
    public void setPageNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1045454767")) {
            ipChange.ipc$dispatch("1045454767", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.pageNo = i;
        }
    }
}
