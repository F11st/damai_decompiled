package com.alibaba.android.vlayout;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public abstract class c {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    protected final ExposeLinearLayoutManagerEx a;
    private int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class a extends c {
        a(ExposeLinearLayoutManagerEx exposeLinearLayoutManagerEx) {
            super(exposeLinearLayoutManagerEx, null);
        }

        @Override // com.alibaba.android.vlayout.c
        public int d(View view) {
            return !this.a.isEnableMarginOverLap() ? this.a.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin : this.a.getDecoratedRight(view);
        }

        @Override // com.alibaba.android.vlayout.c
        public int e(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !this.a.isEnableMarginOverLap() ? this.a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : this.a.getDecoratedMeasuredWidth(view);
        }

        @Override // com.alibaba.android.vlayout.c
        public int f(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // com.alibaba.android.vlayout.c
        public int g(View view) {
            return !this.a.isEnableMarginOverLap() ? this.a.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin : this.a.getDecoratedLeft(view);
        }

        @Override // com.alibaba.android.vlayout.c
        public int h() {
            return this.a.getWidth();
        }

        @Override // com.alibaba.android.vlayout.c
        public int i() {
            return this.a.getWidth() - this.a.getPaddingRight();
        }

        @Override // com.alibaba.android.vlayout.c
        public int j() {
            return this.a.getPaddingRight();
        }

        @Override // com.alibaba.android.vlayout.c
        public int k() {
            return this.a.getPaddingLeft();
        }

        @Override // com.alibaba.android.vlayout.c
        public int l() {
            return (this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight();
        }

        @Override // com.alibaba.android.vlayout.c
        public void n(int i) {
            this.a.offsetChildrenHorizontal(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class b extends c {
        b(ExposeLinearLayoutManagerEx exposeLinearLayoutManagerEx) {
            super(exposeLinearLayoutManagerEx, null);
        }

        @Override // com.alibaba.android.vlayout.c
        public int d(View view) {
            return !this.a.isEnableMarginOverLap() ? this.a.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin : this.a.getDecoratedBottom(view);
        }

        @Override // com.alibaba.android.vlayout.c
        public int e(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !this.a.isEnableMarginOverLap() ? this.a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : this.a.getDecoratedMeasuredHeight(view);
        }

        @Override // com.alibaba.android.vlayout.c
        public int f(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // com.alibaba.android.vlayout.c
        public int g(View view) {
            return !this.a.isEnableMarginOverLap() ? this.a.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin : this.a.getDecoratedTop(view);
        }

        @Override // com.alibaba.android.vlayout.c
        public int h() {
            return this.a.getHeight();
        }

        @Override // com.alibaba.android.vlayout.c
        public int i() {
            return this.a.getHeight() - this.a.getPaddingBottom();
        }

        @Override // com.alibaba.android.vlayout.c
        public int j() {
            return this.a.getPaddingBottom();
        }

        @Override // com.alibaba.android.vlayout.c
        public int k() {
            return this.a.getPaddingTop();
        }

        @Override // com.alibaba.android.vlayout.c
        public int l() {
            return (this.a.getHeight() - this.a.getPaddingTop()) - this.a.getPaddingBottom();
        }

        @Override // com.alibaba.android.vlayout.c
        public void n(int i) {
            this.a.offsetChildrenVertical(i);
        }
    }

    /* synthetic */ c(ExposeLinearLayoutManagerEx exposeLinearLayoutManagerEx, a aVar) {
        this(exposeLinearLayoutManagerEx);
    }

    public static c a(ExposeLinearLayoutManagerEx exposeLinearLayoutManagerEx) {
        return new a(exposeLinearLayoutManagerEx);
    }

    public static c b(ExposeLinearLayoutManagerEx exposeLinearLayoutManagerEx, int i) {
        if (i != 0) {
            if (i == 1) {
                return c(exposeLinearLayoutManagerEx);
            }
            throw new IllegalArgumentException("invalid orientation");
        }
        return a(exposeLinearLayoutManagerEx);
    }

    public static c c(ExposeLinearLayoutManagerEx exposeLinearLayoutManagerEx) {
        return new b(exposeLinearLayoutManagerEx);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public int m() {
        if (Integer.MIN_VALUE == this.b) {
            return 0;
        }
        return l() - this.b;
    }

    public abstract void n(int i);

    public void o() {
        this.b = l();
    }

    private c(ExposeLinearLayoutManagerEx exposeLinearLayoutManagerEx) {
        this.b = Integer.MIN_VALUE;
        this.a = exposeLinearLayoutManagerEx;
    }
}
