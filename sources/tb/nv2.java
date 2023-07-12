package tb;

import cn.damai.user.userhome.bean.MinepublishCheckBean;
import cn.damai.user.userhome.ut.UtForDynamic;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class nv2 implements UtForDynamic {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.user.userhome.ut.UtForDynamic
    public void onUt4PublishClick(MinepublishCheckBean minepublishCheckBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1502085322")) {
            ipChange.ipc$dispatch("1502085322", new Object[]{this, minepublishCheckBean});
        } else {
            cn.damai.common.user.c.e().x(vf1.x().d0());
        }
    }
}
