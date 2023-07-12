package tb;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.seatbiz.common.bean.OrderPrice;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.SkuBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.request.DengjiRequest;
import cn.damai.commonbusiness.seatbiz.sku.qilin.request.SkuRequest;
import cn.damai.commonbusiness.seatbiz.sku.qilin.request.SuanjiaRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class sd2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public void a(DengjiRequest dengjiRequest, DMMtopRequestListener<FollowDataBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "552426188")) {
            ipChange.ipc$dispatch("552426188", new Object[]{this, dengjiRequest, dMMtopRequestListener});
        } else {
            dengjiRequest.request(dMMtopRequestListener);
        }
    }

    public void b(SkuRequest skuRequest, DMMtopResultRequestListener<SkuBean> dMMtopResultRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1621511641")) {
            ipChange.ipc$dispatch("1621511641", new Object[]{this, skuRequest, dMMtopResultRequestListener});
        } else {
            skuRequest.request(dMMtopResultRequestListener);
        }
    }

    public void c(SuanjiaRequest suanjiaRequest, DMMtopRequestListener<OrderPrice> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1575945168")) {
            ipChange.ipc$dispatch("-1575945168", new Object[]{this, suanjiaRequest, dMMtopRequestListener});
        } else {
            suanjiaRequest.request(dMMtopRequestListener);
        }
    }
}
