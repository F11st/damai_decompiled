package cn.damai.category.discountticket.request;

import androidx.annotation.Nullable;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.o90;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DiscountFirstPageRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String distanceCityId;

    public DiscountFirstPageRequest(@Nullable String str) {
        this.distanceCityId = o90.a(str);
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-716407819") ? (String) ipChange.ipc$dispatch("-716407819", new Object[]{this}) : "mtop.damai.wireless.search.discount.page";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-267176744")) {
            return ((Boolean) ipChange.ipc$dispatch("-267176744", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2138888364")) {
            return ((Boolean) ipChange.ipc$dispatch("-2138888364", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1451328904") ? (String) ipChange.ipc$dispatch("1451328904", new Object[]{this}) : "1.0";
    }
}
