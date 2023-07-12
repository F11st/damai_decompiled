package cn.damai.commonbusiness.contacts.manager;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.contacts.bean.PurchaserListBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.by1;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class PurchaserManager$1 extends DMMtopRequestListener<PurchaserListBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ by1 this$0;
    final /* synthetic */ PurchaserListener val$purchaserListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PurchaserManager$1(by1 by1Var, Class cls, PurchaserListener purchaserListener) {
        super(cls);
        this.val$purchaserListener = purchaserListener;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "58959666")) {
            ipChange.ipc$dispatch("58959666", new Object[]{this, str, str2});
        } else {
            this.val$purchaserListener.onPurchaserListFail(str, str2);
        }
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onSuccess(PurchaserListBean purchaserListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1710370051")) {
            ipChange.ipc$dispatch("1710370051", new Object[]{this, purchaserListBean});
        } else {
            this.val$purchaserListener.onPurchaserListSuccess(purchaserListBean);
        }
    }
}
