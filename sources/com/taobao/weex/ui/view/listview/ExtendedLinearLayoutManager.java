package com.taobao.weex.ui.view.listview;

import android.content.Context;
import android.graphics.PointF;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ExtendedLinearLayoutManager extends LinearLayoutManager {
    private OnSmoothScrollEndListener onScrollEndListener;
    private RecyclerView.SmoothScroller smoothScroller;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface OnSmoothScrollEndListener {
        void onStop();
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private class TopSnappedSmoothScroller extends LinearSmoothScroller {
        public TopSnappedSmoothScroller(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public PointF computeScrollVectorForPosition(int i) {
            return ExtendedLinearLayoutManager.this.computeScrollVectorForPosition(i);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected int getVerticalSnapPreference() {
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onStop() {
            super.onStop();
            if (ExtendedLinearLayoutManager.this.onScrollEndListener != null) {
                ExtendedLinearLayoutManager.this.onScrollEndListener.onStop();
                ExtendedLinearLayoutManager.this.onScrollEndListener = null;
            }
        }
    }

    public ExtendedLinearLayoutManager(Context context) {
        super(context, 1, false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            return super.scrollVerticallyBy(i, recycler, state);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void setOnScrollEndListener(OnSmoothScrollEndListener onSmoothScrollEndListener) {
        this.onScrollEndListener = onSmoothScrollEndListener;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        if (this.smoothScroller == null) {
            this.smoothScroller = new TopSnappedSmoothScroller(recyclerView.getContext());
        }
        this.smoothScroller.setTargetPosition(i);
        startSmoothScroll(this.smoothScroller);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return false;
    }

    public ExtendedLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }
}
