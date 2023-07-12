package cn.damai.search.ui.viewholder;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s72;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchHeadAccountViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private s72 a;

    public SearchHeadAccountViewHolder(Context context, View view) {
        super(view);
        s72 s72Var = new s72();
        this.a = s72Var;
        s72Var.j(context, view);
    }

    public void a(@Nullable BaccountInfo baccountInfo, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2015080584")) {
            ipChange.ipc$dispatch("2015080584", new Object[]{this, baccountInfo, Boolean.valueOf(z)});
        } else if (baccountInfo == null) {
            this.itemView.setVisibility(8);
        } else {
            this.itemView.setVisibility(0);
            this.a.i(baccountInfo, z, true);
        }
    }
}
