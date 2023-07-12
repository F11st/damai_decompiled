package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTour;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectTourViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.pp2;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectTourAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<ProjectTour> b;
    private String c;
    private int d;

    public ProjectTourAdapter(Context context, List<ProjectTour> list, long j, int i) {
        this.a = context;
        this.b = list;
        this.c = String.valueOf(j);
        this.d = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2052874236") ? ((Integer) ipChange.ipc$dispatch("2052874236", new Object[]{this})).intValue() : wh2.e(this.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1997601955")) {
            return ((Integer) ipChange.ipc$dispatch("1997601955", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1740302467")) {
            ipChange.ipc$dispatch("-1740302467", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            ((ProjectTourViewHolder) viewHolder).c(this.c, this.b.get(i), this.d, i);
            pp2.u().l2(viewHolder.itemView, this.c, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-835298535")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-835298535", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        Context context = this.a;
        return new ProjectTourViewHolder(context, LayoutInflater.from(context));
    }
}
