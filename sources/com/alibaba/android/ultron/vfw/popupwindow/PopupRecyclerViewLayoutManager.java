package com.alibaba.android.ultron.vfw.popupwindow;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class PopupRecyclerViewLayoutManager extends LinearLayoutManager {
    boolean a;

    public PopupRecyclerViewLayoutManager(Context context) {
        super(context);
        this.a = true;
    }

    public void a(boolean z) {
        this.a = z;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.a && super.canScrollVertically();
    }
}
