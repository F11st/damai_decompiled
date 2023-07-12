package com.alibaba.android.ultron.vfw.viewholder;

import android.view.ViewGroup;
import com.taobao.android.ultron.common.model.IDMComponent;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface IViewHolderProvider {
    void bindData(RecyclerViewHolder recyclerViewHolder, IDMComponent iDMComponent);

    RecyclerViewHolder createViewHolder(ViewGroup viewGroup, int i);

    void destroy();

    int getItemViewType(IDMComponent iDMComponent);
}
