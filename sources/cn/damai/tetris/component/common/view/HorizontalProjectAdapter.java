package cn.damai.tetris.component.common.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.viewholder.HorizontalProjectViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HorizontalProjectAdapter extends RecyclerView.Adapter<HorizontalProjectViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<ProjectItemBean> b;
    private View.OnClickListener c;

    public HorizontalProjectAdapter(Context context, View.OnClickListener onClickListener) {
        this.a = context;
        this.c = onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(HorizontalProjectViewHolder horizontalProjectViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "664867645")) {
            ipChange.ipc$dispatch("664867645", new Object[]{this, horizontalProjectViewHolder, Integer.valueOf(i)});
        } else if (horizontalProjectViewHolder != null) {
            horizontalProjectViewHolder.a(this.b.get(i));
            horizontalProjectViewHolder.itemView.setTag(this.b.get(i));
            horizontalProjectViewHolder.itemView.setTag(R$id.project_index_id, Integer.valueOf(i));
            horizontalProjectViewHolder.itemView.setOnClickListener(this.c);
            if (horizontalProjectViewHolder.itemView.getLayoutParams() == null) {
                horizontalProjectViewHolder.itemView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            horizontalProjectViewHolder.itemView.getLayoutParams().width = q60.a(horizontalProjectViewHolder.itemView.getContext(), 317.0f);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public HorizontalProjectViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1307114009") ? (HorizontalProjectViewHolder) ipChange.ipc$dispatch("1307114009", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new HorizontalProjectViewHolder(LayoutInflater.from(this.a));
    }

    public void c(List<ProjectItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "808995648")) {
            ipChange.ipc$dispatch("808995648", new Object[]{this, list});
        } else if (list == null || list.size() <= 0) {
        } else {
            this.b = list;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1586890449")) {
            return ((Integer) ipChange.ipc$dispatch("-1586890449", new Object[]{this})).intValue();
        }
        List<ProjectItemBean> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
