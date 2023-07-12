package com.taobao.android.dinamicx.view;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXLinearLayoutManager extends LinearLayoutManager {
    private boolean a;

    public DXLinearLayoutManager(Context context) {
        super(context);
        this.a = true;
    }

    public void a(boolean z) {
        this.a = z;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.a && super.canScrollHorizontally();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.a && super.canScrollVertically();
    }

    public DXLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
        this.a = true;
    }
}
