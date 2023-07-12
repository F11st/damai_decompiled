package tb;

import cn.damai.user.userhome.bean.MinepublishCheckBean;
import cn.damai.user.userhome.ut.UtForDynamic;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class gl1 implements UtForDynamic {
    private static transient /* synthetic */ IpChange $ipChange;
    private UtForDynamic a;

    public void a(UtForDynamic utForDynamic) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-209473478")) {
            ipChange.ipc$dispatch("-209473478", new Object[]{this, utForDynamic});
        } else {
            this.a = utForDynamic;
        }
    }

    @Override // cn.damai.user.userhome.ut.UtForDynamic
    public void onUt4PublishClick(MinepublishCheckBean minepublishCheckBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1158940245")) {
            ipChange.ipc$dispatch("1158940245", new Object[]{this, minepublishCheckBean});
            return;
        }
        UtForDynamic utForDynamic = this.a;
        if (utForDynamic != null) {
            utForDynamic.onUt4PublishClick(minepublishCheckBean);
        }
    }
}
