package tb;

import cn.damai.uikit.image.IImageLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* renamed from: tb.vr */
/* loaded from: classes4.dex */
public class C9826vr implements IImageLoader.ImageTicket {
    private static transient /* synthetic */ IpChange $ipChange;
    private ds1 a;

    public C9826vr(ds1 ds1Var) {
        this.a = ds1Var;
    }

    @Override // cn.damai.uikit.image.IImageLoader.ImageTicket
    public void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1572024260")) {
            ipChange.ipc$dispatch("1572024260", new Object[]{this});
        } else {
            this.a.cancel();
        }
    }
}
