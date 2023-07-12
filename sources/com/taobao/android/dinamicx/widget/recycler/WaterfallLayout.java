package com.taobao.android.dinamicx.widget.recycler;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.android.dinamicx.widget.recycler.nested.DXNestedScrollerView;
import com.taobao.android.dinamicx.widget.recycler.refresh.TBAbsRefreshHeader;
import com.taobao.android.dinamicx.widget.recycler.refresh.TBSwipeRefreshLayout;
import com.taobao.android.dinamicx.widget.recycler.view.DXRecyclerView;
import tb.n00;
import tb.te;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WaterfallLayout implements IEleSectionHeightListener, TBSwipeRefreshLayout.OnChildScrollUpCallback {
    private TBAbsRefreshHeader A;
    private DXNestedScrollerView B;
    private boolean C;
    private n00 D;
    private int E;
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private String[] n;
    private String[] o;
    private TBSwipeRefreshLayout.OnPullRefreshListener p;
    private TBSwipeRefreshLayout.OnPushLoadMoreListener q;
    private RecyclerView.OnScrollListener r;
    private WaterfallLayoutRelativeLayout s;
    private StickyLayout t;
    private StickyItemDecoration u;
    private SpaceItemDecoration v;
    private RecyclerView.LayoutManager w;
    private RecyclerView x;
    private TBSwipeRefreshLayout y;
    public boolean z;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.recycler.WaterfallLayout$b */
    /* loaded from: classes12.dex */
    public static class C6509b {
        private int a = 1;
        private int b = -1;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;
        private boolean l;
        private boolean m;
        private String[] n;
        private String[] o;
        private boolean p;
        private TBAbsRefreshHeader q;
        private DXNestedScrollerView r;
        private boolean s;
        private boolean t;
        private int u;

        public WaterfallLayout a() {
            return new WaterfallLayout(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u);
        }

        public C6509b b(int i) {
            this.a = i;
            return this;
        }

        public C6509b c(int i) {
            this.c = i;
            return this;
        }

        public C6509b d(boolean z) {
            this.p = z;
            return this;
        }

        public C6509b e(DXNestedScrollerView dXNestedScrollerView) {
            this.r = dXNestedScrollerView;
            return this;
        }

        public C6509b f(boolean z) {
            this.s = z;
            return this;
        }

        public C6509b g(boolean z) {
            this.l = z;
            return this;
        }

        public C6509b h(int i) {
            this.d = i;
            return this;
        }

        public C6509b i(int i) {
            this.j = i;
            return this;
        }

        public C6509b j(int i) {
            this.k = i;
            return this;
        }

        public C6509b k(boolean z) {
            this.t = z;
            return this;
        }

        public C6509b l(String[] strArr) {
            this.n = strArr;
            return this;
        }

        public C6509b m(int i) {
            this.e = i;
            return this;
        }

        public C6509b n(TBAbsRefreshHeader tBAbsRefreshHeader) {
            this.q = tBAbsRefreshHeader;
            return this;
        }

        public C6509b o(int i) {
            this.u = i;
            return this;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.recycler.WaterfallLayout$c */
    /* loaded from: classes11.dex */
    public static class C6510c extends te {
        @Override // tb.te
        public boolean g() {
            return super.g() && !"VTR-AL00".equals(Build.getMODEL());
        }
    }

    public View a(Context context) {
        WaterfallLayoutRelativeLayout waterfallLayoutRelativeLayout = new WaterfallLayoutRelativeLayout(context);
        this.s = waterfallLayoutRelativeLayout;
        waterfallLayoutRelativeLayout.setTranslationY(-1.0f);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        marginLayoutParams.leftMargin = this.i;
        marginLayoutParams.rightMargin = this.j;
        this.s.setLayoutParams(marginLayoutParams);
        this.s.setPadding(this.e, this.g, this.f, this.h);
        TBSwipeRefreshLayout tBSwipeRefreshLayout = new TBSwipeRefreshLayout(context);
        this.y = tBSwipeRefreshLayout;
        tBSwipeRefreshLayout.setOnChildScrollUpCallback(this);
        TBAbsRefreshHeader tBAbsRefreshHeader = this.A;
        if (tBAbsRefreshHeader != null) {
            this.y.setHeaderView(tBAbsRefreshHeader);
        }
        if (this.k) {
            this.y.enablePullRefresh(true);
        }
        if (this.l) {
            this.y.enableLoadMore(true);
        }
        TBSwipeRefreshLayout.OnPushLoadMoreListener onPushLoadMoreListener = this.q;
        if (onPushLoadMoreListener != null) {
            this.y.setOnPushLoadMoreListener(onPushLoadMoreListener);
        }
        TBSwipeRefreshLayout.OnPullRefreshListener onPullRefreshListener = this.p;
        if (onPullRefreshListener != null) {
            this.y.setOnPullRefreshListener(onPullRefreshListener);
        }
        this.y.setLoadMoreTips(this.o);
        this.y.setRefreshTips(this.n);
        RecyclerView dXRecyclerView = new DXRecyclerView(context);
        StickyItemDecoration stickyItemDecoration = new StickyItemDecoration();
        this.u = stickyItemDecoration;
        dXRecyclerView.addItemDecoration(stickyItemDecoration);
        SpaceItemDecoration spaceItemDecoration = new SpaceItemDecoration(this.b, this.c, this.d, this.a, this.C);
        this.v = spaceItemDecoration;
        dXRecyclerView.addItemDecoration(spaceItemDecoration);
        this.x = dXRecyclerView;
        RecyclerView.OnScrollListener onScrollListener = this.r;
        if (onScrollListener != null) {
            dXRecyclerView.addOnScrollListener(onScrollListener);
        }
        g(dXRecyclerView, context);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.addView(dXRecyclerView);
        this.y.addView(frameLayout);
        this.s.addView(this.y, -1, -1);
        StickyLayout stickyLayout = new StickyLayout(context);
        this.t = stickyLayout;
        stickyLayout.setRecyclerView(this.x);
        frameLayout.addView(this.t, -1, -1);
        this.u.l(this.t);
        this.t.setHeightUpdateListener(this);
        DXNestedScrollerView dXNestedScrollerView = this.B;
        if (dXNestedScrollerView != null && dXNestedScrollerView.getmRootList() != null) {
            DXNestedScrollerView dXNestedScrollerView2 = this.B;
            if (dXNestedScrollerView2 != null && dXNestedScrollerView2.getmChildList() == null) {
                this.B.setCurrentChild(dXRecyclerView);
            }
            return this.s;
        }
        this.B.addView(this.s);
        this.B.setRoot(dXRecyclerView);
        return this.B;
    }

    public te b() {
        WaterfallLayoutRelativeLayout waterfallLayoutRelativeLayout = this.s;
        if (waterfallLayoutRelativeLayout != null) {
            return waterfallLayoutRelativeLayout.getCLipRadiusHandler();
        }
        return null;
    }

    public RecyclerView.OnScrollListener c() {
        return this.r;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBSwipeRefreshLayout.OnChildScrollUpCallback
    public boolean canChildScrollUp(TBSwipeRefreshLayout tBSwipeRefreshLayout) {
        return !this.z;
    }

    public n00 d() {
        return this.D;
    }

    public RecyclerView e() {
        return this.x;
    }

    public RecyclerView.LayoutManager f() {
        if (this.E == 0) {
            return new ScrollStaggeredGridLayoutManager(this.a, 0, this);
        }
        return new ScrollStaggeredGridLayoutManager(this.a, 1, this);
    }

    public void g(RecyclerView recyclerView, Context context) {
        this.x = recyclerView;
        recyclerView.setItemAnimator(null);
        recyclerView.setHasFixedSize(true);
        if (this.m) {
            recyclerView.setOverScrollMode(2);
        }
        this.w = f();
        recyclerView.setDescendantFocusability(131072);
        recyclerView.setLayoutManager(this.w);
        recyclerView.setClipToPadding(false);
        recyclerView.setSaveEnabled(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h(int r17, int r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, int r26, int r27, boolean r28, boolean r29, java.lang.String[] r30, java.lang.String[] r31, boolean r32, boolean r33) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.widget.recycler.WaterfallLayout.h(int, int, int, int, int, int, int, int, int, int, int, boolean, boolean, java.lang.String[], java.lang.String[], boolean, boolean):void");
    }

    public void i(BaseStickyAdapter baseStickyAdapter) {
        this.x.setAdapter(baseStickyAdapter);
        this.u.k(baseStickyAdapter);
    }

    public void j(C6510c c6510c) {
        WaterfallLayoutRelativeLayout waterfallLayoutRelativeLayout = this.s;
        if (waterfallLayoutRelativeLayout != null) {
            waterfallLayoutRelativeLayout.setClipRadiusHandler(c6510c);
        }
    }

    public void k(TBSwipeRefreshLayout.OnPullRefreshListener onPullRefreshListener) {
        this.p = onPullRefreshListener;
        TBSwipeRefreshLayout tBSwipeRefreshLayout = this.y;
        if (tBSwipeRefreshLayout != null) {
            tBSwipeRefreshLayout.setOnPullRefreshListener(onPullRefreshListener);
        }
    }

    public void l(RecyclerView.OnScrollListener onScrollListener) {
        this.r = onScrollListener;
        RecyclerView recyclerView = this.x;
        if (recyclerView != null) {
            recyclerView.clearOnScrollListeners();
            this.x.addOnScrollListener(onScrollListener);
        }
    }

    public void m(n00 n00Var) {
        this.D = n00Var;
        RecyclerView recyclerView = this.x;
        if (recyclerView != null) {
            recyclerView.setOnTouchListener(n00Var);
        }
    }

    public void n(boolean z) {
    }

    public void o(boolean z) {
        this.z = z;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.IEleSectionHeightListener
    public void onSectionHeightUpdated() {
        this.x.removeItemDecoration(this.u);
        this.x.addItemDecoration(this.u);
    }

    public void p() {
        TBSwipeRefreshLayout tBSwipeRefreshLayout = this.y;
        if (tBSwipeRefreshLayout != null) {
            tBSwipeRefreshLayout.setAutoRefreshing(true);
        }
    }

    public void q() {
        TBSwipeRefreshLayout tBSwipeRefreshLayout = this.y;
        if (tBSwipeRefreshLayout != null) {
            tBSwipeRefreshLayout.setRefreshing(false);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class WaterfallLayoutRelativeLayout extends RelativeLayout {
        private te cLipRadiusHandler;

        public WaterfallLayoutRelativeLayout(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas canvas) {
            te teVar = this.cLipRadiusHandler;
            if (teVar == null) {
                super.dispatchDraw(canvas);
            } else if (teVar.h()) {
                super.dispatchDraw(canvas);
            } else {
                this.cLipRadiusHandler.b(this, canvas);
                super.dispatchDraw(canvas);
                this.cLipRadiusHandler.a(this, canvas);
            }
        }

        public te getCLipRadiusHandler() {
            return this.cLipRadiusHandler;
        }

        public void setClipRadiusHandler(te teVar) {
            this.cLipRadiusHandler = teVar;
        }

        public WaterfallLayoutRelativeLayout(Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public WaterfallLayoutRelativeLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }
    }

    private WaterfallLayout(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, boolean z, boolean z2, String[] strArr, String[] strArr2, boolean z3, TBAbsRefreshHeader tBAbsRefreshHeader, DXNestedScrollerView dXNestedScrollerView, boolean z4, boolean z5, int i12) {
        this.a = 1;
        this.z = true;
        this.a = i;
        this.b = i3;
        this.c = i4;
        this.d = i5;
        this.e = i6;
        this.f = i7;
        this.g = i8;
        this.h = i9;
        this.i = i10;
        this.j = i11;
        this.k = z;
        this.l = z2;
        this.n = strArr;
        this.o = strArr2;
        this.m = z3;
        this.A = tBAbsRefreshHeader;
        this.B = dXNestedScrollerView;
        this.C = z4;
        this.E = i12;
    }
}
