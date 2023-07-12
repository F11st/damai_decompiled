package com.alibaba.android.vlayout;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.VirtualLayoutManager;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface LayoutManagerHelper {
    void addBackgroundView(View view, boolean z);

    void addChildView(View view, int i);

    void addChildView(VirtualLayoutManager.C3287d c3287d, View view);

    void addChildView(VirtualLayoutManager.C3287d c3287d, View view, int i);

    void addFixedView(View view);

    void addOffFlowView(View view, boolean z);

    int findFirstVisibleItemPosition();

    int findLastVisibleItemPosition();

    AbstractC3289a findLayoutHelperByPosition(int i);

    @Nullable
    View findViewByPosition(int i);

    View generateLayoutView();

    @Nullable
    View getChildAt(int i);

    int getChildCount();

    int getChildMeasureSpec(int i, int i2, boolean z);

    RecyclerView.ViewHolder getChildViewHolder(View view);

    int getContentHeight();

    int getContentWidth();

    int getDecoratedBottom(View view);

    int getDecoratedLeft(View view);

    int getDecoratedRight(View view);

    int getDecoratedTop(View view);

    AbstractC3291c getMainOrientationHelper();

    int getOrientation();

    int getPaddingBottom();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingTop();

    int getPosition(View view);

    RecyclerView getRecyclerView();

    boolean getReverseLayout();

    AbstractC3291c getSecondaryOrientationHelper();

    void hideView(View view);

    boolean isDoLayoutRTL();

    boolean isEnableMarginOverLap();

    boolean isViewHolderUpdated(View view);

    void layoutChild(View view, int i, int i2, int i3, int i4);

    void layoutChildWithMargins(View view, int i, int i2, int i3, int i4);

    void measureChild(View view, int i, int i2);

    void measureChildWithMargins(View view, int i, int i2);

    void recycleView(View view);

    void removeChildView(View view);

    void showView(View view);
}
