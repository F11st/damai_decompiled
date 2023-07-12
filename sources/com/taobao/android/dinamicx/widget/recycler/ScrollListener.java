package com.taobao.android.dinamicx.widget.recycler;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import tb.hy;
import tb.i00;
import tb.nz;
import tb.wt;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ScrollListener extends RecyclerView.OnScrollListener {
    private DXRecyclerLayout a;
    private RecyclerView.OnScrollListener d;
    int e;
    int f;
    int b = 0;
    int c = -1;
    protected i00 g = new i00(5288751146867425108L);

    public ScrollListener(DXRecyclerLayout dXRecyclerLayout) {
        this.a = dXRecyclerLayout;
    }

    private int a() {
        RecyclerView recyclerView;
        View childAt;
        DXRecyclerLayout dXRecyclerLayout = this.a;
        if (dXRecyclerLayout == null || (recyclerView = dXRecyclerLayout.getRecyclerView()) == null || (childAt = recyclerView.getChildAt(0)) == null) {
            return -2;
        }
        return recyclerView.getChildAdapterPosition(childAt);
    }

    public void b() {
        this.b = 0;
        this.c = -1;
        this.e = 0;
        this.f = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        DXRecyclerLayout dXRecyclerLayout;
        DXRecyclerLayout dXRecyclerLayout2;
        if (this.b == 2 && i == 0) {
            recyclerView.scrollBy(0, this.c > 0 ? 1 : -1);
        }
        if (i == 0 && (dXRecyclerLayout2 = this.a) != null) {
            dXRecyclerLayout2.postEvent(new hy(2691126191158604142L));
            this.a.triggerScrollToWhenScrollByFinish(recyclerView);
            DXRootView rootView = this.a.getDXRuntimeContext().getRootView();
            DXRuntimeContext dXRuntimeContext = this.a.getDXRuntimeContext();
            if (dXRuntimeContext != null && wt.q0(dXRuntimeContext.getBizType()) && rootView != null && rootView.getDxNestedScrollerView() != null) {
                rootView.getDxNestedScrollerView().dispatchChildScrollStateChange(i);
            }
        }
        if (i == 1 && (dXRecyclerLayout = this.a) != null) {
            dXRecyclerLayout.postEvent(new hy(9144262755562405950L));
        }
        this.b = i;
        RecyclerView.OnScrollListener onScrollListener = this.d;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        int startReachedThreshold;
        int a;
        recyclerView.getLayoutManager();
        this.c = i2;
        if (i2 != 0 || i != 0) {
            this.f += i;
            this.e += i2;
        }
        this.g.f(i);
        this.g.g(i2);
        this.g.h(this.f);
        this.g.i(this.e);
        DXRecyclerLayout dXRecyclerLayout = this.a;
        if (dXRecyclerLayout != null) {
            this.g.k(dXRecyclerLayout.getUserId());
            this.g.j(this.a);
            this.a.postEvent(this.g);
        }
        RecyclerView.OnScrollListener onScrollListener = this.d;
        if (onScrollListener != null) {
            onScrollListener.onScrolled(recyclerView, i, i2);
        }
        if (i2 < 0 && (startReachedThreshold = this.a.getStartReachedThreshold()) >= 0 && (a = a()) >= 0 && a <= startReachedThreshold) {
            nz.b("ScrollListener", "滚动到顶部");
            this.a.postOnStartReachedEvent();
        }
        if (DinamicXEngine.x()) {
            nz.b("ScrollListener", "dx: " + i + " dy " + i2 + " offsetY " + this.e);
        }
    }
}
