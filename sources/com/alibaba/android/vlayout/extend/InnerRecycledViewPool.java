package com.alibaba.android.vlayout.extend;

import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Closeable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class InnerRecycledViewPool extends RecyclerView.RecycledViewPool {
    private static int d = 20;
    private RecyclerView.RecycledViewPool a;
    private SparseIntArray b;
    private SparseIntArray c;

    public InnerRecycledViewPool(RecyclerView.RecycledViewPool recycledViewPool) {
        this.b = new SparseIntArray();
        this.c = new SparseIntArray();
        this.a = recycledViewPool;
    }

    private void a(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        if (view instanceof Closeable) {
            try {
                ((Closeable) view).close();
            } catch (Exception e) {
                Log.w("InnerRecycledViewPool", Log.getStackTraceString(e), e);
            }
        }
        if (viewHolder instanceof Closeable) {
            try {
                ((Closeable) viewHolder).close();
            } catch (Exception e2) {
                Log.w("InnerRecycledViewPool", Log.getStackTraceString(e2), e2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public void clear() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            int keyAt = this.b.keyAt(i);
            RecyclerView.ViewHolder recycledView = this.a.getRecycledView(keyAt);
            while (recycledView != null) {
                a(recycledView);
                recycledView = this.a.getRecycledView(keyAt);
            }
        }
        this.b.clear();
        super.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public RecyclerView.ViewHolder getRecycledView(int i) {
        RecyclerView.ViewHolder recycledView = this.a.getRecycledView(i);
        if (recycledView != null) {
            int i2 = this.b.indexOfKey(i) >= 0 ? this.b.get(i) : 0;
            if (i2 > 0) {
                this.b.put(i, i2 - 1);
            }
        }
        return recycledView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public void putRecycledView(RecyclerView.ViewHolder viewHolder) {
        int itemViewType = viewHolder.getItemViewType();
        if (this.c.indexOfKey(itemViewType) < 0) {
            this.c.put(itemViewType, d);
            setMaxRecycledViews(itemViewType, d);
        }
        int i = this.b.indexOfKey(itemViewType) >= 0 ? this.b.get(itemViewType) : 0;
        if (this.c.get(itemViewType) > i) {
            this.a.putRecycledView(viewHolder);
            this.b.put(itemViewType, i + 1);
            return;
        }
        a(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public void setMaxRecycledViews(int i, int i2) {
        RecyclerView.ViewHolder recycledView = this.a.getRecycledView(i);
        while (recycledView != null) {
            a(recycledView);
            recycledView = this.a.getRecycledView(i);
        }
        this.c.put(i, i2);
        this.b.put(i, 0);
        this.a.setMaxRecycledViews(i, i2);
    }

    public InnerRecycledViewPool() {
        this(new RecyclerView.RecycledViewPool());
    }
}
