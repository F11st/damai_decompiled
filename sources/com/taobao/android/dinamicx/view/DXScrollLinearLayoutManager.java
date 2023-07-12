package com.taobao.android.dinamicx.view;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXScrollLinearLayoutManager extends DXLinearLayoutManager {
    private float b;
    private float c;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.view.DXScrollLinearLayoutManager$a */
    /* loaded from: classes11.dex */
    class C6412a extends LinearSmoothScroller {
        C6412a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
            if (i5 != -1 && i5 != 0) {
                if (i5 != 1) {
                    return 0;
                }
                return i4 - i2;
            }
            return i3 - i;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return DXScrollLinearLayoutManager.this.c;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForScrolling(int i) {
            return super.calculateTimeForScrolling(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        @Nullable
        public PointF computeScrollVectorForPosition(int i) {
            return DXScrollLinearLayoutManager.this.computeScrollVectorForPosition(i);
        }
    }

    public DXScrollLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
        this.b = 160.0f;
        this.c = 1.0f;
    }

    public void c(int i) {
        if (i == 0) {
            this.c = 1.0f;
        } else {
            this.c = this.b / i;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, com.alibaba.android.vlayout.LayoutManagerHelper
    public void measureChildWithMargins(View view, int i, int i2) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        view.measure(RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally()), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i2, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically()));
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        C6412a c6412a = new C6412a(recyclerView.getContext());
        c6412a.setTargetPosition(i);
        startSmoothScroll(c6412a);
    }
}
