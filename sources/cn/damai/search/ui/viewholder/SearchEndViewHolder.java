package cn.damai.search.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$layout;
import tb.m62;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchEndViewHolder extends RecyclerView.ViewHolder {
    public SearchEndViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.search_list_end, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, m62.a(context, 21.0f)));
    }
}
