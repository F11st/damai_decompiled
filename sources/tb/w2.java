package tb;

import android.app.Activity;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ScrollView;
import cn.damai.baseview.PullScrollView;
import cn.damai.baseview.abcpullrefresh.actionbarcompat.PullToRefreshLayout;
import cn.damai.baseview.abcpullrefresh.library.C0278a;
import cn.damai.baseview.abcpullrefresh.library.listeners.OnLoadMoreListener;
import cn.damai.baseview.abcpullrefresh.library.listeners.OnRefreshListener;
import cn.damai.baseview.pull.lib.PullUpLoadRefresh;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class w2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public w2 a(Activity activity, PullToRefreshLayout pullToRefreshLayout, View view, OnRefreshListener onRefreshListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "676182465")) {
            return (w2) ipChange.ipc$dispatch("676182465", new Object[]{this, activity, pullToRefreshLayout, view, onRefreshListener});
        }
        C0278a.a(activity).d(view).b(onRefreshListener).c(pullToRefreshLayout);
        return this;
    }

    public void b(Activity activity, PullToRefreshLayout pullToRefreshLayout, View view, OnLoadMoreListener onLoadMoreListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-167335471")) {
            ipChange.ipc$dispatch("-167335471", new Object[]{this, activity, pullToRefreshLayout, view, onLoadMoreListener});
        } else if (view instanceof ListView) {
            new PullUpLoadRefresh().g(onLoadMoreListener).getScrollListener((ListView) view);
        } else if (view instanceof GridView) {
            new PullUpLoadRefresh().g(onLoadMoreListener).getScrollListener((GridView) view);
        } else if (view instanceof ScrollView) {
            new PullUpLoadRefresh().g(onLoadMoreListener).getScrollListener((PullScrollView) view);
        }
    }
}
