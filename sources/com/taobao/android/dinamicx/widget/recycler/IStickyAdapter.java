package com.taobao.android.dinamicx.widget.recycler;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IStickyAdapter {
    int getItemViewType(int i);

    List<Integer> getStickChangedList();

    int getStickyOffset(int i);

    int getStickyPosition(int i);

    boolean hasPreSticky(int i);

    boolean isSticky(int i);

    void onBindStickyHolder(RecyclerView.ViewHolder viewHolder, int i);

    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i);

    void onStickyChange(int i, boolean z);
}
