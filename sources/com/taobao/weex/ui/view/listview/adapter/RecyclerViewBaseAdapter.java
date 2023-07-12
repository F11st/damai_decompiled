package com.taobao.weex.ui.view.listview.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class RecyclerViewBaseAdapter<T extends ListBaseViewHolder> extends RecyclerView.Adapter<T> {
    private IRecyclerAdapterListener iRecyclerAdapterListener;

    public RecyclerViewBaseAdapter(IRecyclerAdapterListener iRecyclerAdapterListener) {
        this.iRecyclerAdapterListener = iRecyclerAdapterListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IRecyclerAdapterListener iRecyclerAdapterListener = this.iRecyclerAdapterListener;
        if (iRecyclerAdapterListener != null) {
            return iRecyclerAdapterListener.getItemCount();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.iRecyclerAdapterListener.getItemId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IRecyclerAdapterListener iRecyclerAdapterListener = this.iRecyclerAdapterListener;
        return iRecyclerAdapterListener != null ? iRecyclerAdapterListener.getItemViewType(i) : i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((RecyclerViewBaseAdapter<T>) ((ListBaseViewHolder) viewHolder), i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return onFailedToRecycleView((RecyclerViewBaseAdapter<T>) ((ListBaseViewHolder) viewHolder));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        onViewAttachedToWindow((RecyclerViewBaseAdapter<T>) ((ListBaseViewHolder) viewHolder));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        onViewDetachedFromWindow((RecyclerViewBaseAdapter<T>) ((ListBaseViewHolder) viewHolder));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        onViewRecycled((RecyclerViewBaseAdapter<T>) ((ListBaseViewHolder) viewHolder));
    }

    public void onBindViewHolder(T t, int i) {
        IRecyclerAdapterListener iRecyclerAdapterListener = this.iRecyclerAdapterListener;
        if (iRecyclerAdapterListener != null) {
            iRecyclerAdapterListener.onBindViewHolder(t, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public T onCreateViewHolder(ViewGroup viewGroup, int i) {
        IRecyclerAdapterListener iRecyclerAdapterListener = this.iRecyclerAdapterListener;
        if (iRecyclerAdapterListener != null) {
            return (T) iRecyclerAdapterListener.onCreateViewHolder(viewGroup, i);
        }
        return null;
    }

    public boolean onFailedToRecycleView(T t) {
        IRecyclerAdapterListener iRecyclerAdapterListener = this.iRecyclerAdapterListener;
        if (iRecyclerAdapterListener != null) {
            return iRecyclerAdapterListener.onFailedToRecycleView(t);
        }
        return super.onFailedToRecycleView((RecyclerViewBaseAdapter<T>) t);
    }

    public void onViewAttachedToWindow(T t) {
        ViewGroup.LayoutParams layoutParams;
        super.onViewAttachedToWindow((RecyclerViewBaseAdapter<T>) t);
        if (t == null || !t.isFullSpan() || (layoutParams = t.itemView.getLayoutParams()) == null || !(layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            return;
        }
        ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
    }

    public void onViewDetachedFromWindow(T t) {
        super.onViewDetachedFromWindow((RecyclerViewBaseAdapter<T>) t);
        if (t != null) {
            t.setComponentUsing(false);
        }
    }

    public void onViewRecycled(T t) {
        IRecyclerAdapterListener iRecyclerAdapterListener = this.iRecyclerAdapterListener;
        if (iRecyclerAdapterListener != null) {
            iRecyclerAdapterListener.onViewRecycled(t);
        }
        super.onViewRecycled((RecyclerViewBaseAdapter<T>) t);
    }
}
