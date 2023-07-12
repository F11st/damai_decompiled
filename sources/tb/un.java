package tb;

import android.content.Context;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class un extends cp2<Boolean> {
    private static transient /* synthetic */ IpChange $ipChange;

    public un(Context context) {
        super(context);
    }

    @Override // tb.cp2
    public int a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "439758679") ? ((Integer) ipChange.ipc$dispatch("439758679", new Object[]{this})).intValue() : R$layout.live_content_detail_recommend_title;
    }

    @Override // tb.cp2
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1917073572")) {
            ipChange.ipc$dispatch("1917073572", new Object[]{this});
        }
    }

    public void d(Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "717714831")) {
            ipChange.ipc$dispatch("717714831", new Object[]{this, bool});
        } else {
            c(bool.booleanValue());
        }
    }
}
