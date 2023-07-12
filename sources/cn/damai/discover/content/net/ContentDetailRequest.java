package cn.damai.discover.content.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ContentDetailRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String contentId;
    public Integer pageIndex = 1;
    public Integer pageSize = 30;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-104010782") ? (String) ipChange.ipc$dispatch("-104010782", new Object[]{this}) : ContentDetailApi.CONTENT_DETAIL_PAGE;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "467699851")) {
            return ((Boolean) ipChange.ipc$dispatch("467699851", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-297117113")) {
            return ((Boolean) ipChange.ipc$dispatch("-297117113", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2063725941") ? (String) ipChange.ipc$dispatch("2063725941", new Object[]{this}) : "1.4";
    }
}
