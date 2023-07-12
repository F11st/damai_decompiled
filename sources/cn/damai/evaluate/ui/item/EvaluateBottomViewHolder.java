package cn.damai.evaluate.ui.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.comment.R$layout;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class EvaluateBottomViewHolder extends RecyclerView.ViewHolder {
    public EvaluateBottomViewHolder(Context context) {
        super(LayoutInflater.from(context).inflate(R$layout.evaluate_item_bottom_view, (ViewGroup) null));
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }
}
