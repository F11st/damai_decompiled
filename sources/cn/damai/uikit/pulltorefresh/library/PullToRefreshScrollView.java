package cn.damai.uikit.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import cn.damai.uikit.R$id;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PullToRefreshScrollView extends PullToRefreshBase<ScrollView> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    @TargetApi(9)
    /* loaded from: classes8.dex */
    public final class InternalScrollViewSDK9 extends ScrollView {
        private static transient /* synthetic */ IpChange $ipChange;

        public InternalScrollViewSDK9(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private int getScrollRange() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-376200501")) {
                return ((Integer) ipChange.ipc$dispatch("-376200501", new Object[]{this})).intValue();
            }
            if (getChildCount() > 0) {
                return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
            }
            return 0;
        }

        @Override // android.view.View
        protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "945489150")) {
                return ((Boolean) ipChange.ipc$dispatch("945489150", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z)})).booleanValue();
            }
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            b.c(PullToRefreshScrollView.this, i, i3, i2, i4, getScrollRange(), z);
            return overScrollBy;
        }
    }

    public PullToRefreshScrollView(Context context) {
        super(context);
    }

    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1875110354") ? (PullToRefreshBase.Orientation) ipChange.ipc$dispatch("1875110354", new Object[]{this}) : PullToRefreshBase.Orientation.VERTICAL;
    }

    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    protected boolean isReadyForPullEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-623537066")) {
            return ((Boolean) ipChange.ipc$dispatch("-623537066", new Object[]{this})).booleanValue();
        }
        View childAt = ((ScrollView) this.mRefreshableView).getChildAt(0);
        return childAt != null && ((ScrollView) this.mRefreshableView).getScrollY() >= childAt.getHeight() - getHeight();
    }

    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    protected boolean isReadyForPullStart() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1720537455") ? ((Boolean) ipChange.ipc$dispatch("1720537455", new Object[]{this})).booleanValue() : ((ScrollView) this.mRefreshableView).getScrollY() == 0;
    }

    public PullToRefreshScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public ScrollView createRefreshableView(Context context, AttributeSet attributeSet) {
        ScrollView scrollView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1409183380")) {
            return (ScrollView) ipChange.ipc$dispatch("1409183380", new Object[]{this, context, attributeSet});
        }
        if (Build.VERSION.SDK_INT >= 9) {
            scrollView = new InternalScrollViewSDK9(context, attributeSet);
        } else {
            scrollView = new ScrollView(context, attributeSet);
        }
        scrollView.setId(R$id.scrollview);
        return scrollView;
    }

    public PullToRefreshScrollView(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
    }

    public PullToRefreshScrollView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
    }
}
