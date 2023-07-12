package cn.damai.search.ui.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.search.bean.SearchDataHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchRecViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;

    public SearchRecViewHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.search_list_recommend_title, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        TextView textView = (TextView) this.itemView.findViewById(R$id.tv_title);
        this.a = textView;
        textView.setText("为你推荐");
    }

    public void a(SearchDataHolder searchDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-533706080")) {
            ipChange.ipc$dispatch("-533706080", new Object[]{this, searchDataHolder});
        } else if (searchDataHolder == null) {
        } else {
            this.a.setText(searchDataHolder.isNoteFeed ? "Feel·感受现场" : "为你推荐");
        }
    }
}
