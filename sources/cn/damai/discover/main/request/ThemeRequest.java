package cn.damai.discover.main.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ThemeRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public int order;
    public String pageNo;
    public String pageSize = "15";
    public String themeId;

    public ThemeRequest(String str, int i, int i2) {
        this.themeId = str;
        this.pageNo = i + "";
        this.order = i2;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-976988287") ? (String) ipChange.ipc$dispatch("-976988287", new Object[]{this}) : "mtop.damai.wireless.discovery.theme.get";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1447637708")) {
            return ((Boolean) ipChange.ipc$dispatch("1447637708", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "825325640")) {
            return ((Boolean) ipChange.ipc$dispatch("825325640", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1190748436") ? (String) ipChange.ipc$dispatch("1190748436", new Object[]{this}) : "1.2";
    }
}
