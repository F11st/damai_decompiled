package tb;

import android.content.Context;
import cn.damai.commonbusiness.tab.ITabView;
import cn.damai.commonbusiness.tab.TabItem;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a30 extends sk2 {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // tb.sk2
    public ITabView a(Context context, TabItem tabItem) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-829342926") ? (ITabView) ipChange.ipc$dispatch("-829342926", new Object[]{this, context, tabItem}) : super.a(context, tabItem);
    }
}
