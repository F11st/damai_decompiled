package com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class StackLayoutManager extends RecyclerView.LayoutManager {
    private final ScrollOrientation a;
    private final C6532b b;
    private final C6531a c;
    private final int d;
    private int e;
    private boolean f;
    private final boolean g;
    private ScrollOrientation h;
    private final boolean i;
    private int j;
    private ItemChangedListener k;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface ItemChangedListener {
        void onItemChanged(int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum ScrollOrientation {
        RIGHT,
        LEFT,
        BOTTOM,
        TOP,
        NONE
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager$a */
    /* loaded from: classes11.dex */
    class C6528a extends RecyclerView.OnFlingListener {
        final /* synthetic */ RecyclerView a;

        C6528a(RecyclerView recyclerView) {
            this.a = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
        public boolean onFling(int i, int i2) {
            if (StackLayoutManager.this.g) {
                int i3 = C6530c.a[StackLayoutManager.this.a.ordinal()];
                if (i3 == 1 || i3 == 3) {
                    if (i > 0) {
                        StackLayoutManager.this.h = ScrollOrientation.LEFT;
                    } else if (i < 0) {
                        StackLayoutManager.this.h = ScrollOrientation.RIGHT;
                    } else {
                        StackLayoutManager.this.h = ScrollOrientation.NONE;
                    }
                    if (StackLayoutManager.this.e >= 1 && StackLayoutManager.this.e < StackLayoutManager.this.getWidth() * (StackLayoutManager.this.getItemCount() - 1)) {
                        StackLayoutManager.this.f = true;
                    }
                } else {
                    if (i2 > 0) {
                        StackLayoutManager.this.h = ScrollOrientation.TOP;
                    } else if (i2 < 0) {
                        StackLayoutManager.this.h = ScrollOrientation.BOTTOM;
                    } else {
                        StackLayoutManager.this.h = ScrollOrientation.NONE;
                    }
                    if (StackLayoutManager.this.e >= 1 && StackLayoutManager.this.e < StackLayoutManager.this.getHeight() * (StackLayoutManager.this.getItemCount() - 1)) {
                        StackLayoutManager.this.f = true;
                    }
                }
                StackLayoutManager.this.j(this.a);
            }
            return StackLayoutManager.this.g;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager$b */
    /* loaded from: classes11.dex */
    class C6529b extends RecyclerView.OnScrollListener {
        final /* synthetic */ RecyclerView a;

        C6529b(RecyclerView recyclerView) {
            this.a = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i != 0) {
                if (i == 1) {
                    StackLayoutManager.this.f = false;
                    return;
                }
                return;
            }
            StackLayoutManager stackLayoutManager = StackLayoutManager.this;
            stackLayoutManager.x(stackLayoutManager.getItemCount() > 0 ? StackLayoutManager.this.m() % StackLayoutManager.this.getItemCount() : StackLayoutManager.this.m());
            if (!StackLayoutManager.this.f) {
                StackLayoutManager.this.f = true;
                StackLayoutManager.this.j(this.a);
                return;
            }
            StackLayoutManager.this.f = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager$c */
    /* loaded from: classes12.dex */
    public static /* synthetic */ class C6530c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ScrollOrientation.values().length];
            a = iArr;
            try {
                iArr[ScrollOrientation.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ScrollOrientation.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ScrollOrientation.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ScrollOrientation.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public StackLayoutManager(C6534c c6534c) {
        this(c6534c.a, c6534c.b, c6534c.c, c6534c.d, c6534c.e, c6534c.f, c6534c.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(RecyclerView recyclerView) {
        if (!this.g || l() == 0.0f) {
            return;
        }
        this.f = true;
        v(k(m()), recyclerView, Boolean.TRUE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
        if (r1 != 4) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int k(int r6) {
        /*
            r5 = this;
            com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager$ScrollOrientation r0 = r5.h
            int[] r1 = com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager.C6530c.a
            com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager$ScrollOrientation r2 = r5.a
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 1
            if (r1 == r2) goto L19
            r3 = 2
            if (r1 == r3) goto L2f
            r3 = 3
            if (r1 == r3) goto L24
            r3 = 4
            if (r1 == r3) goto L3a
            goto L45
        L19:
            com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager$ScrollOrientation r1 = com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager.ScrollOrientation.LEFT
            if (r0 != r1) goto L1f
            int r6 = r6 + r2
            return r6
        L1f:
            com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager$ScrollOrientation r1 = com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager.ScrollOrientation.RIGHT
            if (r0 != r1) goto L24
            return r6
        L24:
            com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager$ScrollOrientation r1 = com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager.ScrollOrientation.RIGHT
            if (r0 != r1) goto L2a
            int r6 = r6 + r2
            return r6
        L2a:
            com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager$ScrollOrientation r1 = com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager.ScrollOrientation.LEFT
            if (r0 != r1) goto L2f
            return r6
        L2f:
            com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager$ScrollOrientation r1 = com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager.ScrollOrientation.TOP
            if (r0 != r1) goto L35
            int r6 = r6 + r2
            return r6
        L35:
            com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager$ScrollOrientation r1 = com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager.ScrollOrientation.BOTTOM
            if (r0 != r1) goto L3a
            return r6
        L3a:
            com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager$ScrollOrientation r1 = com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager.ScrollOrientation.BOTTOM
            if (r0 != r1) goto L40
            int r6 = r6 + r2
            return r6
        L40:
            com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager$ScrollOrientation r1 = com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager.ScrollOrientation.TOP
            if (r0 != r1) goto L45
            return r6
        L45:
            float r0 = r5.l()
            double r0 = (double) r0
            r2 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L51
            goto L53
        L51:
            int r6 = r6 + 1
        L53:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager.k(int):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int m() {
        double floor;
        double itemCount;
        double ceil;
        if (getWidth() == 0 || getHeight() == 0) {
            return 0;
        }
        int i = C6530c.a[this.a.ordinal()];
        if (i == 1) {
            floor = Math.floor((this.e * 1.0d) / getWidth());
        } else if (i != 2) {
            if (i != 3) {
                itemCount = getItemCount() - 1;
                ceil = Math.ceil((this.e * 1.0d) / getHeight());
            } else {
                itemCount = getItemCount() - 1;
                ceil = Math.ceil((this.e * 1.0d) / getWidth());
            }
            floor = itemCount - ceil;
        } else {
            floor = Math.floor((this.e * 1.0d) / getHeight());
        }
        return (int) floor;
    }

    private int n() {
        int m = m();
        if (this.i) {
            return m + this.d;
        }
        return Math.min(m + this.d, getItemCount() - 1);
    }

    private int o(int i) {
        int width;
        int itemCount;
        int width2;
        int i2 = C6530c.a[this.a.ordinal()];
        if (i2 == 1) {
            width = getWidth();
        } else if (i2 != 2) {
            if (i2 != 3) {
                itemCount = (getItemCount() - 1) - i;
                width2 = getHeight();
            } else {
                itemCount = (getItemCount() - 1) - i;
                width2 = getWidth();
            }
            return itemCount * width2;
        } else {
            width = getHeight();
        }
        return i * width;
    }

    private int p(int i) {
        int i2 = C6530c.a[this.a.ordinal()];
        if (i2 == 1 || i2 == 3) {
            return Math.max(Math.min(getWidth() * (getItemCount() - 1) * (this.i ? 500 : 1), i), 0);
        }
        return Math.max(Math.min(getHeight() * (getItemCount() - 1) * (this.i ? 500 : 1), i), 0);
    }

    private int q(int i, RecyclerView.Recycler recycler) {
        int i2 = this.e + i;
        int p = p(i2);
        this.e = p;
        int i3 = (p - i2) + i;
        if (i3 == 0) {
            return 0;
        }
        detachAndScrapAttachedViews(recycler);
        if (this.i) {
            s(recycler);
        } else {
            r(recycler);
        }
        return i3;
    }

    private void r(RecyclerView.Recycler recycler) {
        int m = m();
        int min = Math.min(n(), getItemCount() - 1);
        float l = l();
        for (int i = min; i >= m; i--) {
            View viewForPosition = recycler.getViewForPosition(i);
            if (viewForPosition != null) {
                addView(viewForPosition);
                measureChild(viewForPosition, 0, 0);
                int i2 = i - m;
                this.b.a(this, this.e, l, viewForPosition, i2, this.c);
                this.c.a(l, viewForPosition, i2);
            }
        }
        int i3 = m - 1;
        if (i3 >= 0) {
            t(recycler, recycler.getViewForPosition(i3));
        }
        int i4 = min + 1;
        if (i4 < getItemCount()) {
            t(recycler, recycler.getViewForPosition(i4));
        }
    }

    private void s(RecyclerView.Recycler recycler) {
        int m = m();
        int n = n();
        float l = l();
        for (int i = n; i >= m; i--) {
            View viewForPosition = recycler.getViewForPosition(i % getItemCount());
            if (viewForPosition != null) {
                addView(viewForPosition);
                measureChild(viewForPosition, 0, 0);
                int i2 = i - m;
                this.b.a(this, this.e, l, viewForPosition, i2, this.c);
                this.c.a(l, viewForPosition, i2);
            }
        }
        int i3 = m - 1;
        if (i3 >= 0) {
            t(recycler, recycler.getViewForPosition(i3 % getItemCount()));
        }
        int i4 = n + 1;
        if (i4 < getItemCount()) {
            t(recycler, recycler.getViewForPosition(i4 % getItemCount()));
        }
    }

    private void t(RecyclerView.Recycler recycler, View view) {
        if (view != null) {
            u(view);
            removeAndRecycleView(view, recycler);
        }
    }

    private void u(View view) {
        view.setRotationY(0.0f);
        view.setRotationX(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setAlpha(1.0f);
    }

    private void v(int i, RecyclerView recyclerView, Boolean bool) {
        int o = o(i);
        int i2 = C6530c.a[this.a.ordinal()];
        if (i2 != 1 && i2 != 3) {
            if (bool.booleanValue()) {
                recyclerView.smoothScrollBy(0, o - this.e);
            } else {
                recyclerView.scrollBy(0, o - this.e);
            }
        } else if (bool.booleanValue()) {
            recyclerView.smoothScrollBy(o - this.e, 0);
        } else {
            recyclerView.scrollBy(o - this.e, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i) {
        ItemChangedListener itemChangedListener = this.k;
        if (itemChangedListener == null || !this.g || i == this.j) {
            return;
        }
        this.j = i;
        itemChangedListener.onItemChanged(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        ScrollOrientation scrollOrientation = this.a;
        return scrollOrientation == ScrollOrientation.RIGHT || scrollOrientation == ScrollOrientation.LEFT;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        ScrollOrientation scrollOrientation = this.a;
        return scrollOrientation == ScrollOrientation.BOTTOM || scrollOrientation == ScrollOrientation.TOP;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public float l() {
        float width;
        int width2;
        if (getWidth() == 0 || getHeight() == 0) {
            return 0.0f;
        }
        int i = C6530c.a[this.a.ordinal()];
        if (i == 1) {
            width = (this.e % getWidth()) * 1.0f;
            width2 = getWidth();
        } else if (i != 2) {
            if (i != 3) {
                float height = 1.0f - (((this.e % getHeight()) * 1.0f) / getHeight());
                if (height == 1.0f) {
                    return 0.0f;
                }
                return height;
            }
            float width3 = 1.0f - (((this.e % getWidth()) * 1.0f) / getWidth());
            if (width3 == 1.0f) {
                return 0.0f;
            }
            return width3;
        } else {
            width = (this.e % getHeight()) * 1.0f;
            width2 = getHeight();
        }
        return width / width2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        recyclerView.setOnFlingListener(new C6528a(recyclerView));
        recyclerView.addOnScrollListener(new C6529b(recyclerView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        C6532b c6532b = this.b;
        if (c6532b == null) {
            return;
        }
        c6532b.g();
        removeAndRecycleAllViews(recycler);
        if (getItemCount() > 0) {
            this.e = p(this.e);
            if (this.i) {
                s(recycler);
            } else {
                r(recycler);
            }
        }
        x(getItemCount() > 0 ? m() % getItemCount() : m());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void requestLayout() {
        super.requestLayout();
        C6532b c6532b = this.b;
        if (c6532b != null) {
            c6532b.g();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return q(i, recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        if (i >= 0 && i < getItemCount()) {
            this.f = true;
            this.e = o(i);
            requestLayout();
            return;
        }
        throw new ArrayIndexOutOfBoundsException("$position is out of bound [0..$itemCount-1]");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return q(i, recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        super.smoothScrollToPosition(recyclerView, state, i);
        if (i >= 0 && i < getItemCount()) {
            this.f = true;
            v(i, recyclerView, Boolean.TRUE);
            return;
        }
        throw new ArrayIndexOutOfBoundsException("$position is out of bound [0..$itemCount-1]");
    }

    public void w(ItemChangedListener itemChangedListener) {
        this.k = itemChangedListener;
    }

    public StackLayoutManager(ScrollOrientation scrollOrientation, int i, float f, boolean z, boolean z2, float f2, float f3) {
        this.f = false;
        this.j = -1;
        this.a = scrollOrientation;
        this.d = i;
        this.i = z2 && (scrollOrientation == ScrollOrientation.LEFT || scrollOrientation == ScrollOrientation.TOP);
        this.g = z;
        this.b = new C6532b(scrollOrientation, i, f);
        this.c = new C6531a(scrollOrientation, i, f2, f3);
        int i2 = C6530c.a[scrollOrientation.ordinal()];
        if (i2 != 1 && i2 != 2) {
            this.e = Integer.MAX_VALUE;
        } else {
            this.e = 0;
        }
    }
}
