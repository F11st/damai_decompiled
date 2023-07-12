package com.alibaba.android.vlayout.layout;

import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
class FixLayoutHelper$1 implements Runnable {
    final /* synthetic */ a this$0;
    final /* synthetic */ LayoutManagerHelper val$helper;
    final /* synthetic */ RecyclerView.Recycler val$recycler;

    FixLayoutHelper$1(a aVar, RecyclerView.Recycler recycler, LayoutManagerHelper layoutManagerHelper) {
        this.val$recycler = recycler;
        this.val$helper = layoutManagerHelper;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$recycler.getViewForPosition(a.b(this.this$0));
        throw null;
    }
}
