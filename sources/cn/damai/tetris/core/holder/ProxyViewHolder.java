package cn.damai.tetris.core.holder;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ProxyViewHolder<T extends RecyclerView.ViewHolder> extends BaseViewHolder {
    public T a;

    public ProxyViewHolder(T t) {
        super(t.itemView);
        this.a = t;
    }
}
