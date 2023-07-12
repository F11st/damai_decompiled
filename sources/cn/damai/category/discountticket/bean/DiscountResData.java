package cn.damai.category.discountticket.bean;

import androidx.annotation.Nullable;
import cn.damai.category.discountticket.bean.biz.BannerBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DiscountResData {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<BannerBean> bannerData;
    public CommonDiscountData commonDiscountData;
    public HeaderData headerData;
    public NearDiscountData nearDiscountData;

    @Nullable
    public ProjectItemBean getFirstProject() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-27088562")) {
            return (ProjectItemBean) ipChange.ipc$dispatch("-27088562", new Object[]{this});
        }
        NearDiscountData nearDiscountData = this.nearDiscountData;
        if (nearDiscountData != null && wh2.e(nearDiscountData.nearDiscountItems) > 0) {
            return this.nearDiscountData.nearDiscountItems.get(0);
        }
        CommonDiscountData commonDiscountData = this.commonDiscountData;
        if (commonDiscountData == null || wh2.e(commonDiscountData.commonDiscountItems) <= 0) {
            return null;
        }
        return this.commonDiscountData.commonDiscountItems.get(0);
    }

    public int getUnNearProjectCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1385897053")) {
            return ((Integer) ipChange.ipc$dispatch("1385897053", new Object[]{this})).intValue();
        }
        CommonDiscountData commonDiscountData = this.commonDiscountData;
        if (commonDiscountData != null) {
            return wh2.e(commonDiscountData.commonDiscountItems);
        }
        return 0;
    }
}
