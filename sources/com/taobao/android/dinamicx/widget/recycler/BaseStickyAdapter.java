package com.taobao.android.dinamicx.widget.recycler;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class BaseStickyAdapter extends RecyclerView.Adapter implements IStickyAdapter {
    private List<Integer> a = new ArrayList();
    private List<Integer> b = new ArrayList();

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.recycler.BaseStickyAdapter$a */
    /* loaded from: classes11.dex */
    class C6503a extends RecyclerView.AdapterDataObserver {
        C6503a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            BaseStickyAdapter.this.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            BaseStickyAdapter.this.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            BaseStickyAdapter.this.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            BaseStickyAdapter.this.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            BaseStickyAdapter.this.c();
        }
    }

    public BaseStickyAdapter() {
        c();
    }

    public abstract void a(RecyclerView.ViewHolder viewHolder, int i);

    public void b() {
        registerAdapterDataObserver(new C6503a());
    }

    public void c() {
        this.a.clear();
        int itemCount = getItemCount();
        int i = -1;
        for (int i2 = 0; i2 < itemCount; i2++) {
            if (isSticky(i2)) {
                i = i2;
            }
            this.a.add(Integer.valueOf(i));
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.IStickyAdapter
    public List<Integer> getStickChangedList() {
        return this.b;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.IStickyAdapter
    public int getStickyPosition(int i) {
        List<Integer> list = this.a;
        if (list == null || i < 0 || i >= list.size()) {
            return -1;
        }
        return this.a.get(i).intValue();
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.IStickyAdapter
    public boolean hasPreSticky(int i) {
        return getStickyPosition(i) >= 0;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.IStickyAdapter
    public void onBindStickyHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (i < 0 || i >= getItemCount()) {
            return;
        }
        a(viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (isSticky(i)) {
            ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
            }
            if (layoutParams != null) {
                layoutParams.height = 0;
            }
            viewHolder.itemView.requestLayout();
            this.b.add(Integer.valueOf(i));
            return;
        }
        a(viewHolder, i);
    }
}
