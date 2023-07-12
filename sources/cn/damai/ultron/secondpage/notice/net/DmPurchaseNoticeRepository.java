package cn.damai.ultron.secondpage.notice.net;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.ultron.secondpage.notice.bean.DmNoteListBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.y20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DmPurchaseNoticeRepository extends y20 {
    private static transient /* synthetic */ IpChange $ipChange;

    public void queryPurchaseNoticeInfo(String str, DMMtopRequestListener<DmNoteListBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2119319017")) {
            ipChange.ipc$dispatch("-2119319017", new Object[]{this, str, dMMtopRequestListener});
            return;
        }
        DmPurchaseNoticeRequest dmPurchaseNoticeRequest = new DmPurchaseNoticeRequest();
        dmPurchaseNoticeRequest.itemId = str;
        dmPurchaseNoticeRequest.request(dMMtopRequestListener);
    }
}
