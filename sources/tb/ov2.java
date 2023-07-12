package tb;

import cn.damai.common.user.C0529c;
import cn.damai.user.userhome.bean.MinepublishCheckBean;
import cn.damai.user.userhome.ut.UtForDynamic;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ov2 implements UtForDynamic {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.user.userhome.ut.UtForDynamic
    public void onUt4PublishClick(MinepublishCheckBean minepublishCheckBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1264288643")) {
            ipChange.ipc$dispatch("1264288643", new Object[]{this, minepublishCheckBean});
        } else {
            C0529c.e().x(iv2.j().k());
        }
    }
}
