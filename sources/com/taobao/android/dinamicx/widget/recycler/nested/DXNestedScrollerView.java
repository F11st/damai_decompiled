package com.taobao.android.dinamicx.widget.recycler.nested;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.recycler.RecyclerAdapter;
import com.taobao.android.dinamicx.widget.recycler.view.DXRecyclerView;
import tb.h00;
import tb.wt;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXNestedScrollerView extends FrameLayout implements NestedScrollingParent2, IDXNestedScrollingWrapper {
    private int childIndex;
    private int childScrollState;
    private float downY;
    private boolean fixVerticalScrollConflict;
    public boolean isDraggingToRefresh;
    private int mAction;
    private int mAxes;
    private RecyclerView mChildList;
    private int mListHeadY;
    private OnScrollListener mOnScrollListener;
    private RecyclerView mRootList;
    private int stickyHeight;
    private SparseIntArray tabHeightMap;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnScrollListener {
        void onScrollStateChanged(ViewGroup viewGroup, ViewGroup viewGroup2, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            DXNestedScrollerView.this.handlerRootScroll(i);
        }
    }

    public DXNestedScrollerView(@NonNull Context context) {
        super(context);
        this.fixVerticalScrollConflict = true;
        this.mListHeadY = 0;
        this.isDraggingToRefresh = false;
        this.childIndex = -1;
        this.mAction = -1;
        this.tabHeightMap = new SparseIntArray();
        this.stickyHeight = 0;
        this.childScrollState = 0;
    }

    private int getViewTop(View view, View view2) {
        if (view2 == null) {
            return Integer.MAX_VALUE;
        }
        if (view2.getParent() == view) {
            return view2.getTop();
        }
        if (view2.getParent() instanceof View) {
            return getViewTop(view, (View) view2.getParent());
        }
        return getViewTop(view, null);
    }

    private void handlerExposure() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerRootScroll(int i) {
        OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(this.mRootList, this.mChildList, i);
        }
    }

    private void handlerScrolled() {
        OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(this.mRootList, this.mChildList, 0);
        }
    }

    private void handlerScrolling(ViewGroup viewGroup) {
        int i = this.mAction;
        if (i == 2) {
            OnScrollListener onScrollListener = this.mOnScrollListener;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(this.mRootList, this.mChildList, 1);
            }
            if (viewGroup == null || viewGroup != this.mChildList) {
                return;
            }
            onChildScrollStateChange(1);
        } else if (i == 1) {
            OnScrollListener onScrollListener2 = this.mOnScrollListener;
            if (onScrollListener2 != null) {
                onScrollListener2.onScrollStateChanged(this.mRootList, this.mChildList, 2);
            }
            if (viewGroup == null || viewGroup != this.mChildList) {
                return;
            }
            onChildScrollStateChange(2);
        }
    }

    private boolean isOpenChildScrollStateChange() {
        DXRuntimeContext dXRuntimeContext;
        RecyclerView recyclerView = this.mChildList;
        if (recyclerView instanceof DXRecyclerView) {
            Object tag = ((DXRecyclerView) recyclerView).getTag(DXWidgetNode.TAG_WIDGET_NODE);
            if ((tag instanceof DXRecyclerLayout) && (dXRuntimeContext = ((DXRecyclerLayout) tag).getDXRuntimeContext()) != null) {
                return wt.q0(dXRuntimeContext.getBizType());
            }
            return false;
        }
        return false;
    }

    private boolean isReachTop(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return false;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if ((layoutManager instanceof StaggeredGridLayoutManager) && (adapter instanceof RecyclerAdapter)) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
            staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr);
            int i = iArr[0];
            int i2 = 0;
            while (i2 < layoutManager.getChildCount()) {
                View findViewByPosition = layoutManager.findViewByPosition(i2);
                DXWidgetNode h = ((RecyclerAdapter) adapter).h(i2);
                if (findViewByPosition != null && !(h instanceof h00)) {
                    return i <= i2 && findViewByPosition.getTop() == 0;
                }
                i2++;
            }
            return iArr[0] == 0;
        }
        return false;
    }

    private void onChildScrollStateChange(int i) {
        if (isOpenChildScrollStateChange() && this.childScrollState != i) {
            this.childScrollState = i;
            RecyclerView recyclerView = this.mChildList;
            if (recyclerView instanceof DXRecyclerView) {
                ((DXRecyclerView) recyclerView).onScrollStateChangedExtra(i);
            }
        }
    }

    private void onParentScrolling(int i, int i2, int[] iArr) {
        RecyclerView recyclerView;
        int i3 = this.stickyHeight;
        if (i != i3) {
            if (i < i3) {
                iArr[1] = i2;
                this.mRootList.scrollBy(0, i - i3);
            } else if (i2 > 0) {
                int i4 = i - i3;
                if (i4 >= i2) {
                    return;
                }
                iArr[1] = i2 - i4;
            } else if (i2 >= 0 || isReachTop(this.mChildList)) {
            } else {
                this.mRootList.scrollBy(0, i - this.stickyHeight);
                scrollBy(this.mChildList, i2);
                iArr[1] = i2;
            }
        } else if (i2 > 0 && (recyclerView = this.mChildList) != null) {
            if (recyclerView.canScrollVertically(i2)) {
                scrollBy(this.mChildList, i2);
                iArr[1] = i2;
                return;
            }
            RecyclerView recyclerView2 = this.mRootList;
            if (recyclerView2 != null) {
                recyclerView2.stopScroll();
            }
            this.mChildList.stopScroll();
            iArr[1] = i2;
        } else if (i2 < 0) {
            RecyclerView recyclerView3 = this.mChildList;
            if (recyclerView3 != null && !isReachTop(recyclerView3)) {
                iArr[1] = i2;
                scrollBy(this.mChildList, i2);
                return;
            }
            RecyclerView recyclerView4 = this.mChildList;
            if (recyclerView4 != null) {
                ViewCompat.stopNestedScroll(recyclerView4, 1);
            }
            ViewCompat.stopNestedScroll(this.mRootList, 1);
            onChildScrollStateChange(0);
        } else {
            RecyclerView recyclerView5 = this.mChildList;
            if (recyclerView5 != null) {
                ViewCompat.stopNestedScroll(recyclerView5, 1);
            }
            ViewCompat.stopNestedScroll(this.mRootList, 1);
        }
    }

    private void scrollBy(ViewGroup viewGroup, int i) {
        viewGroup.scrollBy(0, i);
        handlerScrolling(viewGroup);
        handlerExposure();
    }

    public void clearChildList() {
        this.mChildList = null;
    }

    public void dispatchChildScrollStateChange(int i) {
        int viewTop;
        if (isOpenChildScrollStateChange() && (viewTop = getViewTop(this.mRootList, this.mChildList)) != Integer.MAX_VALUE) {
            if (viewTop < this.stickyHeight) {
                onChildScrollStateChange(0);
            } else {
                onChildScrollStateChange(i);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.mAction = motionEvent.getAction();
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getChildIndex() {
        return this.childIndex;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mAxes;
    }

    public int getStickyHeight() {
        return this.stickyHeight;
    }

    public RecyclerView getmChildList() {
        return this.mChildList;
    }

    public RecyclerView getmRootList() {
        return this.mRootList;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.fixVerticalScrollConflict) {
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.downY = y;
            } else if (action == 2) {
                requestDisallowInterceptTouchEvent(this.mRootList.canScrollVertically(((int) (y - this.downY)) * (-1)));
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.isDraggingToRefresh) {
            return;
        }
        handlerExposure();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f, float f2, boolean z) {
        return super.onNestedFling(view, f, f2, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f, float f2) {
        return super.onNestedPreFling(view, f, f2);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull View view, int i, int i2, @NonNull int[] iArr, int i3) {
        int viewTop;
        RecyclerView recyclerView = this.mChildList;
        if (recyclerView == null || (viewTop = getViewTop(this.mRootList, recyclerView)) == Integer.MAX_VALUE || view != this.mRootList) {
            return;
        }
        onParentScrolling(viewTop, i2, iArr);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View view, int i, int i2, int i3, int i4, int i5) {
        if (i2 != 0 || i4 == 0) {
            return;
        }
        ViewCompat.stopNestedScroll(view, 1);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i, int i2) {
        this.mAxes = i;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@Nullable View view, @NonNull View view2, int i, int i2) {
        return (i != 2 || this.mRootList == null || this.mChildList == null) ? false : true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View view, int i) {
        this.mAxes = 0;
        if (i == 0) {
            handlerScrolled();
        }
        if (1 == i) {
            handlerScrolled();
        }
    }

    public void setChildIndex(int i) {
        this.childIndex = i;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.nested.IDXNestedScrollingWrapper
    public void setCurrentChild(ViewGroup viewGroup) {
        if (viewGroup != null) {
            this.mChildList = (RecyclerView) viewGroup;
        }
    }

    public void setFixVerticalScrollConflict(boolean z) {
        this.fixVerticalScrollConflict = z;
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.nested.IDXNestedScrollingWrapper
    public void setRoot(ViewGroup viewGroup) {
        RecyclerView recyclerView = (RecyclerView) viewGroup;
        this.mRootList = recyclerView;
        recyclerView.addOnScrollListener(new a());
    }

    public void setStickyHeight(int i) {
        this.stickyHeight = i;
    }

    public void stopAllScroll() {
        RecyclerView recyclerView = this.mChildList;
        if (recyclerView != null) {
            recyclerView.stopScroll();
        }
        RecyclerView recyclerView2 = this.mRootList;
        if (recyclerView2 != null) {
            recyclerView2.stopScroll();
        }
    }

    public DXNestedScrollerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fixVerticalScrollConflict = true;
        this.mListHeadY = 0;
        this.isDraggingToRefresh = false;
        this.childIndex = -1;
        this.mAction = -1;
        this.tabHeightMap = new SparseIntArray();
        this.stickyHeight = 0;
        this.childScrollState = 0;
    }

    public DXNestedScrollerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fixVerticalScrollConflict = true;
        this.mListHeadY = 0;
        this.isDraggingToRefresh = false;
        this.childIndex = -1;
        this.mAction = -1;
        this.tabHeightMap = new SparseIntArray();
        this.stickyHeight = 0;
        this.childScrollState = 0;
    }
}
