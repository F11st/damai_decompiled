package com.taobao.weex.ui.view.listview.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IRecyclerAdapterListener<T extends RecyclerView.ViewHolder> {
    int getItemCount();

    long getItemId(int i);

    int getItemViewType(int i);

    void onBindViewHolder(T t, int i);

    T onCreateViewHolder(ViewGroup viewGroup, int i);

    boolean onFailedToRecycleView(T t);

    void onViewRecycled(T t);
}
