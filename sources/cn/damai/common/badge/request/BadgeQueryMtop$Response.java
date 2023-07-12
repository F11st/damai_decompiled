package cn.damai.common.badge.request;

import cn.damai.common.badge.bean.BadgeQueryResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class BadgeQueryMtop$Response extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    private BadgeQueryResponse data;

    public void setData(BadgeQueryResponse badgeQueryResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "388784691")) {
            ipChange.ipc$dispatch("388784691", new Object[]{this, badgeQueryResponse});
        } else {
            this.data = badgeQueryResponse;
        }
    }

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public BadgeQueryResponse getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2001940117") ? (BadgeQueryResponse) ipChange.ipc$dispatch("-2001940117", new Object[]{this}) : this.data;
    }
}
