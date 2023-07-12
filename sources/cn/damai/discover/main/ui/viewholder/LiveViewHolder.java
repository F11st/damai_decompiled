package cn.damai.discover.main.ui.viewholder;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public abstract class LiveViewHolder<E> extends RecyclerView.ViewHolder {
    protected Context a;
    protected View b;

    public LiveViewHolder(View view) {
        super(view);
        this.b = view;
        this.a = view.getContext();
    }
}
