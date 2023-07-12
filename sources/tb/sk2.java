package tb;

import android.content.Context;
import cn.damai.commonbusiness.tab.ITabView;
import cn.damai.commonbusiness.tab.TabItem;
import cn.damai.commonbusiness.tab.TabView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class sk2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public ITabView a(Context context, TabItem tabItem) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1923002228") ? (ITabView) ipChange.ipc$dispatch("-1923002228", new Object[]{this, context, tabItem}) : new TabView(context);
    }
}
