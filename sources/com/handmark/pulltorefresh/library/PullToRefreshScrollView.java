package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.baseproject.ui.R$id;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class PullToRefreshScrollView extends PullToRefreshBase<ScrollView> {
    private ScrollView mScrollView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    @TargetApi(9)
    /* loaded from: classes10.dex */
    public final class InternalScrollViewSDK9 extends ScrollView {
        public InternalScrollViewSDK9(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private int getScrollRange() {
            if (getChildCount() > 0) {
                return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
            }
            return 0;
        }

        @Override // android.view.View
        protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            C5456a.c(PullToRefreshScrollView.this, i2, i4, getScrollRange(), z);
            return overScrollBy;
        }
    }

    public PullToRefreshScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean fullScroll(int i) {
        return this.mScrollView.fullScroll(i);
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    protected boolean isReadyForPullDown() {
        return ((ScrollView) this.mRefreshableView).getScrollY() == 0;
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    protected boolean isReadyForPullUp() {
        View childAt = ((ScrollView) this.mRefreshableView).getChildAt(0);
        return childAt != null && ((ScrollView) this.mRefreshableView).getScrollY() >= childAt.getHeight() - getHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public ScrollView createRefreshableView(Context context, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT >= 9) {
            this.mScrollView = new InternalScrollViewSDK9(context, attributeSet);
        } else {
            this.mScrollView = new ScrollView(context, attributeSet);
        }
        this.mScrollView.setId(R$id.scrollview);
        return this.mScrollView;
    }
}
