package tb;

import com.alibaba.android.ultron.trade.presenter.IPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.datamodel.imp.DMComponent;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class za0 extends ib {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // tb.ib
    protected void h(np2 np2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1165418531")) {
            ipChange.ipc$dispatch("-1165418531", new Object[]{this, np2Var});
        } else if (np2Var == null) {
        } else {
            DMComponent dMComponent = (DMComponent) np2Var.e("data");
            IPresenter iPresenter = this.c;
            if (iPresenter == null || ((com.taobao.android.ultron.datamodel.imp.a) iPresenter.getDataContext()) == null) {
                return;
            }
            this.c.getDataManager().respondToLinkage(dMComponent);
        }
    }
}
