package cn.damai.baseview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class EmptyViewHolder extends RecyclerView.ViewHolder {
    public EmptyViewHolder(Context context) {
        super(new View(context));
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    }
}
