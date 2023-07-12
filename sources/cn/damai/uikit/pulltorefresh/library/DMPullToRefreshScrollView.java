package cn.damai.uikit.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import cn.damai.uikit.R$id;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DMPullToRefreshScrollView extends PullToRefreshBase<DMScrollerView> {
    private static transient /* synthetic */ IpChange $ipChange;

    public DMPullToRefreshScrollView(Context context) {
        super(context);
    }

    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "417815849") ? (PullToRefreshBase.Orientation) ipChange.ipc$dispatch("417815849", new Object[]{this}) : PullToRefreshBase.Orientation.VERTICAL;
    }

    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    protected boolean isReadyForPullEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-135506913")) {
            return ((Boolean) ipChange.ipc$dispatch("-135506913", new Object[]{this})).booleanValue();
        }
        View childAt = getRefreshableView().getChildAt(0);
        return childAt != null && getRefreshableView().getScrollY() >= childAt.getHeight() - getHeight();
    }

    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    protected boolean isReadyForPullStart() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1728888072") ? ((Boolean) ipChange.ipc$dispatch("-1728888072", new Object[]{this})).booleanValue() : getRefreshableView().getScrollY() == 0;
    }

    public DMPullToRefreshScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public DMScrollerView createRefreshableView(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1334569790")) {
            return (DMScrollerView) ipChange.ipc$dispatch("-1334569790", new Object[]{this, context, attributeSet});
        }
        DMScrollerView dMScrollerView = new DMScrollerView(context, attributeSet);
        dMScrollerView.setId(R$id.dm_ptr_scroll_view);
        return dMScrollerView;
    }

    public DMPullToRefreshScrollView(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
    }
}
