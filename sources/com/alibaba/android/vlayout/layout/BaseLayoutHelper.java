package com.alibaba.android.vlayout.layout;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.AbstractC3289a;
import com.alibaba.android.vlayout.AbstractC3291c;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import tb.m81;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public abstract class BaseLayoutHelper extends AbstractC3303d {
    public static boolean DEBUG = false;
    private static final String TAG = "BaseLayoutHelper";
    int mBgColor;
    View mLayoutView;
    private LayoutViewBindListener mLayoutViewBindListener;
    private LayoutViewUnBindListener mLayoutViewUnBindListener;
    protected Rect mLayoutRegion = new Rect();
    float mAspectRatio = Float.NaN;
    private int mItemCount = 0;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface LayoutViewBindListener {
        void onBind(View view, BaseLayoutHelper baseLayoutHelper);
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface LayoutViewHelper {
        void onBindViewSuccess(View view, String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface LayoutViewUnBindListener {
        void onUnbind(View view, BaseLayoutHelper baseLayoutHelper);
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.vlayout.layout.BaseLayoutHelper$a */
    /* loaded from: classes6.dex */
    public static class C3297a implements LayoutViewBindListener, LayoutViewHelper, LayoutViewUnBindListener {
    }

    private int calGap(int i, int i2) {
        if (i < i2) {
            return i2 - i;
        }
        return 0;
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void adjustLayout(int i, int i2, LayoutManagerHelper layoutManagerHelper) {
        if (requireLayoutView()) {
            Rect rect = new Rect();
            AbstractC3291c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
            for (int i3 = 0; i3 < layoutManagerHelper.getChildCount(); i3++) {
                View childAt = layoutManagerHelper.getChildAt(i3);
                if (getRange().a(Integer.valueOf(layoutManagerHelper.getPosition(childAt)))) {
                    if (childAt.getVisibility() == 8) {
                        rect.setEmpty();
                    } else {
                        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                        if (layoutManagerHelper.getOrientation() == 1) {
                            rect.union(layoutManagerHelper.getDecoratedLeft(childAt) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, mainOrientationHelper.g(childAt), layoutManagerHelper.getDecoratedRight(childAt) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, mainOrientationHelper.d(childAt));
                        } else {
                            rect.union(mainOrientationHelper.g(childAt), layoutManagerHelper.getDecoratedTop(childAt) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, mainOrientationHelper.d(childAt), layoutManagerHelper.getDecoratedBottom(childAt) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                        }
                    }
                }
            }
            if (!rect.isEmpty()) {
                this.mLayoutRegion.set(rect.left - this.mPaddingLeft, rect.top - this.mPaddingTop, rect.right + this.mPaddingRight, rect.bottom + this.mPaddingBottom);
            } else {
                this.mLayoutRegion.setEmpty();
            }
            View view = this.mLayoutView;
            if (view != null) {
                Rect rect2 = this.mLayoutRegion;
                view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
            }
        }
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void afterLayout(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, int i3, LayoutManagerHelper layoutManagerHelper) {
        View view;
        if (DEBUG) {
            Log.d(TAG, "call afterLayout() on " + getClass().getSimpleName());
        }
        if (requireLayoutView()) {
            if (isValidScrolled(i3) && (view = this.mLayoutView) != null) {
                this.mLayoutRegion.union(view.getLeft(), this.mLayoutView.getTop(), this.mLayoutView.getRight(), this.mLayoutView.getBottom());
            }
            if (!this.mLayoutRegion.isEmpty()) {
                if (isValidScrolled(i3)) {
                    if (layoutManagerHelper.getOrientation() == 1) {
                        this.mLayoutRegion.offset(0, -i3);
                    } else {
                        this.mLayoutRegion.offset(-i3, 0);
                    }
                }
                int contentWidth = layoutManagerHelper.getContentWidth();
                int contentHeight = layoutManagerHelper.getContentHeight();
                if (layoutManagerHelper.getOrientation() != 1 ? this.mLayoutRegion.intersects((-contentWidth) / 4, 0, contentWidth + (contentWidth / 4), contentHeight) : this.mLayoutRegion.intersects(0, (-contentHeight) / 4, contentWidth, contentHeight + (contentHeight / 4))) {
                    if (this.mLayoutView == null) {
                        View generateLayoutView = layoutManagerHelper.generateLayoutView();
                        this.mLayoutView = generateLayoutView;
                        layoutManagerHelper.addOffFlowView(generateLayoutView, true);
                    }
                    if (layoutManagerHelper.getOrientation() == 1) {
                        this.mLayoutRegion.left = layoutManagerHelper.getPaddingLeft() + this.mMarginLeft;
                        this.mLayoutRegion.right = (layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingRight()) - this.mMarginRight;
                    } else {
                        this.mLayoutRegion.top = layoutManagerHelper.getPaddingTop() + this.mMarginTop;
                        this.mLayoutRegion.bottom = (layoutManagerHelper.getContentHeight() - layoutManagerHelper.getPaddingBottom()) - this.mMarginBottom;
                    }
                    bindLayoutView(this.mLayoutView);
                    return;
                }
                this.mLayoutRegion.set(0, 0, 0, 0);
                View view2 = this.mLayoutView;
                if (view2 != null) {
                    view2.layout(0, 0, 0, 0);
                }
            }
        }
        View view3 = this.mLayoutView;
        if (view3 != null) {
            LayoutViewUnBindListener layoutViewUnBindListener = this.mLayoutViewUnBindListener;
            if (layoutViewUnBindListener != null) {
                layoutViewUnBindListener.onUnbind(view3, this);
            }
            layoutManagerHelper.removeChildView(this.mLayoutView);
            this.mLayoutView = null;
        }
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void beforeLayout(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutManagerHelper layoutManagerHelper) {
        View view;
        if (DEBUG) {
            Log.d(TAG, "call beforeLayout() on " + getClass().getSimpleName());
        }
        if (requireLayoutView() || (view = this.mLayoutView) == null) {
            return;
        }
        LayoutViewUnBindListener layoutViewUnBindListener = this.mLayoutViewUnBindListener;
        if (layoutViewUnBindListener != null) {
            layoutViewUnBindListener.onUnbind(view, this);
        }
        layoutManagerHelper.removeChildView(this.mLayoutView);
        this.mLayoutView = null;
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void bindLayoutView(@NonNull View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.mLayoutRegion), 1073741824), View.MeasureSpec.makeMeasureSpec(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.mLayoutRegion), 1073741824));
        Rect rect = this.mLayoutRegion;
        view.layout(rect.left, rect.top, rect.right, rect.bottom);
        view.setBackgroundColor(this.mBgColor);
        LayoutViewBindListener layoutViewBindListener = this.mLayoutViewBindListener;
        if (layoutViewBindListener != null) {
            layoutViewBindListener.onBind(view, this);
        }
        this.mLayoutRegion.set(0, 0, 0, 0);
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public final void clear(LayoutManagerHelper layoutManagerHelper) {
        View view = this.mLayoutView;
        if (view != null) {
            LayoutViewUnBindListener layoutViewUnBindListener = this.mLayoutViewUnBindListener;
            if (layoutViewUnBindListener != null) {
                layoutViewUnBindListener.onUnbind(view, this);
            }
            layoutManagerHelper.removeChildView(this.mLayoutView);
            this.mLayoutView = null;
        }
        onClear(layoutManagerHelper);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int computeEndSpace(LayoutManagerHelper layoutManagerHelper, boolean z, boolean z2, boolean z3) {
        int i;
        int i2;
        if (z) {
            i = this.mMarginBottom;
            i2 = this.mPaddingBottom;
        } else {
            i = this.mMarginLeft;
            i2 = this.mPaddingLeft;
        }
        return i + i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int computeStartSpace(LayoutManagerHelper layoutManagerHelper, boolean z, boolean z2, boolean z3) {
        int i;
        int i2;
        int calGap;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        AbstractC3303d abstractC3303d = null;
        AbstractC3289a findNeighbourNonfixLayoutHelper = layoutManagerHelper instanceof VirtualLayoutManager ? ((VirtualLayoutManager) layoutManagerHelper).findNeighbourNonfixLayoutHelper(this, z2) : null;
        if (findNeighbourNonfixLayoutHelper != null && (findNeighbourNonfixLayoutHelper instanceof AbstractC3303d)) {
            abstractC3303d = findNeighbourNonfixLayoutHelper;
        }
        if (findNeighbourNonfixLayoutHelper == this) {
            return 0;
        }
        if (!z3) {
            if (z) {
                i8 = this.mMarginTop;
                i9 = this.mPaddingTop;
            } else {
                i8 = this.mMarginLeft;
                i9 = this.mPaddingLeft;
            }
            return i8 + i9;
        }
        if (abstractC3303d == null) {
            if (z) {
                i6 = this.mMarginTop;
                i7 = this.mPaddingTop;
            } else {
                i6 = this.mMarginLeft;
                i7 = this.mPaddingLeft;
            }
            calGap = i6 + i7;
        } else if (z) {
            if (z2) {
                i3 = abstractC3303d.mMarginBottom;
                i4 = this.mMarginTop;
            } else {
                i3 = abstractC3303d.mMarginTop;
                i4 = this.mMarginBottom;
            }
            calGap = calGap(i3, i4);
        } else {
            if (z2) {
                i = abstractC3303d.mMarginRight;
                i2 = this.mMarginLeft;
            } else {
                i = abstractC3303d.mMarginLeft;
                i2 = this.mMarginRight;
            }
            calGap = calGap(i, i2);
        }
        if (z) {
            i5 = z2 ? this.mPaddingTop : this.mPaddingBottom;
        } else {
            i5 = z2 ? this.mPaddingLeft : this.mPaddingRight;
        }
        return calGap + i5 + 0;
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void doLayout(RecyclerView.Recycler recycler, RecyclerView.State state, VirtualLayoutManager.C3287d c3287d, m81 m81Var, LayoutManagerHelper layoutManagerHelper) {
        layoutViews(recycler, state, c3287d, m81Var, layoutManagerHelper);
    }

    public float getAspectRatio() {
        return this.mAspectRatio;
    }

    public int getBgColor() {
        return this.mBgColor;
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public int getItemCount() {
        return this.mItemCount;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleStateOnResult(m81 m81Var, View view) {
        if (view == null) {
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        boolean z = true;
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            m81Var.c = true;
        }
        if (!m81Var.d && !view.isFocusable()) {
            z = false;
        }
        m81Var.d = z;
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public boolean isFixLayout() {
        return false;
    }

    protected boolean isValidScrolled(int i) {
        return (i == Integer.MAX_VALUE || i == Integer.MIN_VALUE) ? false : true;
    }

    protected void layoutChild(View view, int i, int i2, int i3, int i4, @NonNull LayoutManagerHelper layoutManagerHelper) {
        layoutChild(view, i, i2, i3, i4, layoutManagerHelper, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChildWithMargin(View view, int i, int i2, int i3, int i4, @NonNull LayoutManagerHelper layoutManagerHelper) {
        layoutChildWithMargin(view, i, i2, i3, i4, layoutManagerHelper, false);
    }

    public abstract void layoutViews(RecyclerView.Recycler recycler, RecyclerView.State state, VirtualLayoutManager.C3287d c3287d, m81 m81Var, LayoutManagerHelper layoutManagerHelper);

    @Nullable
    public final View nextView(RecyclerView.Recycler recycler, VirtualLayoutManager.C3287d c3287d, LayoutManagerHelper layoutManagerHelper, m81 m81Var) {
        View l = c3287d.l(recycler);
        if (l == null) {
            if (DEBUG && !c3287d.i()) {
                throw new RuntimeException("received null view when unexpected");
            }
            m81Var.b = true;
            return null;
        }
        layoutManagerHelper.addChildView(c3287d, l);
        return l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onClear(LayoutManagerHelper layoutManagerHelper) {
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public boolean requireLayoutView() {
        return (this.mBgColor == 0 && this.mLayoutViewBindListener == null) ? false : true;
    }

    public void setAspectRatio(float f) {
        this.mAspectRatio = f;
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void setItemCount(int i) {
        this.mItemCount = i;
    }

    public void setLayoutViewBindListener(LayoutViewBindListener layoutViewBindListener) {
        this.mLayoutViewBindListener = layoutViewBindListener;
    }

    public void setLayoutViewHelper(C3297a c3297a) {
        this.mLayoutViewBindListener = c3297a;
        this.mLayoutViewUnBindListener = c3297a;
    }

    public void setLayoutViewUnBindListener(LayoutViewUnBindListener layoutViewUnBindListener) {
        this.mLayoutViewUnBindListener = layoutViewUnBindListener;
    }

    protected void layoutChild(View view, int i, int i2, int i3, int i4, @NonNull LayoutManagerHelper layoutManagerHelper, boolean z) {
        layoutManagerHelper.layoutChild(view, i, i2, i3, i4);
        if (requireLayoutView()) {
            if (z) {
                this.mLayoutRegion.union((i - this.mPaddingLeft) - this.mMarginLeft, (i2 - this.mPaddingTop) - this.mMarginTop, i3 + this.mPaddingRight + this.mMarginRight, i4 + this.mPaddingBottom + this.mMarginBottom);
            } else {
                this.mLayoutRegion.union(i - this.mPaddingLeft, i2 - this.mPaddingTop, i3 + this.mPaddingRight, i4 + this.mPaddingBottom);
            }
        }
    }

    protected void layoutChildWithMargin(View view, int i, int i2, int i3, int i4, @NonNull LayoutManagerHelper layoutManagerHelper, boolean z) {
        layoutManagerHelper.layoutChildWithMargins(view, i, i2, i3, i4);
        if (requireLayoutView()) {
            if (z) {
                this.mLayoutRegion.union((i - this.mPaddingLeft) - this.mMarginLeft, (i2 - this.mPaddingTop) - this.mMarginTop, i3 + this.mPaddingRight + this.mMarginRight, i4 + this.mPaddingBottom + this.mMarginBottom);
            } else {
                this.mLayoutRegion.union(i - this.mPaddingLeft, i2 - this.mPaddingTop, i3 + this.mPaddingRight, i4 + this.mPaddingBottom);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleStateOnResult(m81 m81Var, View[] viewArr) {
        if (viewArr == null) {
            return;
        }
        for (View view : viewArr) {
            if (view != null) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                boolean z = true;
                if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                    m81Var.c = true;
                }
                if (!m81Var.d && !view.isFocusable()) {
                    z = false;
                }
                m81Var.d = z;
                if (z && m81Var.c) {
                    return;
                }
            }
        }
    }
}
