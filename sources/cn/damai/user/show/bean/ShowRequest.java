package cn.damai.user.show.bean;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.y72;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ShowRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String artistId;
    public String brandId;
    public String categoryId;
    public String distanceCityId;
    public String latitude;
    public String longitude;
    public String pageIndex;
    public String pageSize;
    public String repertoireId;
    public String venueId;
    public String cityId = "0";
    public String sourceType = "10";
    public String option = "1073742066";
    public String sortType = "3";
    public String channel = "10001";
    public String returnItemOption = "4";
    public String userId = z20.E();

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1372219286") ? (String) ipChange.ipc$dispatch("1372219286", new Object[]{this}) : y72.a;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "479828823")) {
            return ((Boolean) ipChange.ipc$dispatch("479828823", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1526076909")) {
            return ((Boolean) ipChange.ipc$dispatch("-1526076909", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-755011287") ? (String) ipChange.ipc$dispatch("-755011287", new Object[]{this}) : y72.b;
    }
}
