package cn.damai.search.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.r72;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchAccountViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private r72 a;

    public SearchAccountViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.search_list_artist, (ViewGroup) null));
        r72 r72Var = new r72();
        this.a = r72Var;
        r72Var.c(context, this.itemView);
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    public void a(BaccountInfo baccountInfo, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1590574028")) {
            ipChange.ipc$dispatch("1590574028", new Object[]{this, baccountInfo, Boolean.valueOf(z), Boolean.valueOf(z2)});
        } else if (baccountInfo == null) {
        } else {
            this.a.b(baccountInfo, z, z2);
        }
    }
}
