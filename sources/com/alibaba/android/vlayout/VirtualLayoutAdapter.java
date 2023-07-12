package com.alibaba.android.vlayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public abstract class VirtualLayoutAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    @NonNull
    protected VirtualLayoutManager mLayoutManager;

    public VirtualLayoutAdapter(@NonNull VirtualLayoutManager virtualLayoutManager) {
        this.mLayoutManager = virtualLayoutManager;
    }

    @NonNull
    public List<AbstractC3289a> getLayoutHelpers() {
        return this.mLayoutManager.getLayoutHelpers();
    }

    public void setLayoutHelpers(List<AbstractC3289a> list) {
        this.mLayoutManager.setLayoutHelpers(list);
    }
}
