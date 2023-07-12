package com.alibaba.android.vlayout.layout;

import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
class FixLayoutHelper$1 implements Runnable {
    final /* synthetic */ C3298a this$0;
    final /* synthetic */ LayoutManagerHelper val$helper;
    final /* synthetic */ RecyclerView.Recycler val$recycler;

    FixLayoutHelper$1(C3298a c3298a, RecyclerView.Recycler recycler, LayoutManagerHelper layoutManagerHelper) {
        this.val$recycler = recycler;
        this.val$helper = layoutManagerHelper;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$recycler.getViewForPosition(C3298a.b(this.this$0));
        throw null;
    }
}
