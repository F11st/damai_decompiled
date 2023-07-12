package cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnExtendInfoImageItemClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.viewholder.ProjectBookTitleViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.viewholder.ProjectExtendInfoViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectBlankViewHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.activity.ProjectDetailActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectBookingRegisterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<ProjectDataHolder> a = new ArrayList();
    private ProjectDetailActivity b;
    private OnExtendInfoImageItemClickListener c;

    public ProjectBookingRegisterAdapter(ProjectDetailActivity projectDetailActivity, long j) {
        this.b = projectDetailActivity;
    }

    public void a(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1995571872")) {
            ipChange.ipc$dispatch("1995571872", new Object[]{this, projectDataHolder});
            return;
        }
        this.a.clear();
        this.a.add(projectDataHolder);
        notifyDataSetChanged();
    }

    public void b(List<ProjectDataHolder> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-546402880")) {
            ipChange.ipc$dispatch("-546402880", new Object[]{this, list});
        } else if (list == null || list.isEmpty()) {
        } else {
            this.a.clear();
            this.a.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void c(OnExtendInfoImageItemClickListener onExtendInfoImageItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2966781")) {
            ipChange.ipc$dispatch("-2966781", new Object[]{this, onExtendInfoImageItemClickListener});
        } else {
            this.c = onExtendInfoImageItemClickListener;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-793300782") ? ((Integer) ipChange.ipc$dispatch("-793300782", new Object[]{this})).intValue() : wh2.e(this.a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1890880903") ? ((Integer) ipChange.ipc$dispatch("-1890880903", new Object[]{this, Integer.valueOf(i)})).intValue() : this.a.get(i).getModuleType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "504645863")) {
            ipChange.ipc$dispatch("504645863", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        ProjectDataHolder projectDataHolder = this.a.get(i);
        if (projectDataHolder == null) {
            return;
        }
        int moduleType = projectDataHolder.getModuleType();
        if (moduleType == 3) {
            ((ProjectExtendInfoViewHolder) viewHolder).h(projectDataHolder);
        } else if (moduleType == 6) {
            ((ProjectBookTitleViewHolder) viewHolder).a(projectDataHolder);
        } else if (moduleType != 15) {
        } else {
            ((ProjectBlankViewHolder) viewHolder).a(projectDataHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2083304687")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("2083304687", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        if (i != 3) {
            if (i != 6) {
                if (i != 15) {
                    return null;
                }
                return new ProjectBlankViewHolder(this.b, viewGroup);
            }
            return new ProjectBookTitleViewHolder(this.b, viewGroup);
        }
        return new ProjectExtendInfoViewHolder(this.b, viewGroup, this.c);
    }
}
