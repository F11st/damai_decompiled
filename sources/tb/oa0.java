package tb;

import cn.damai.ultron.net.UltronPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class oa0 extends ib {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // tb.ib
    protected void h(np2 np2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1659552825")) {
            ipChange.ipc$dispatch("1659552825", new Object[]{this, np2Var});
        } else {
            ((UltronPresenter) this.c).createOrderValidateSuccess();
        }
    }
}
