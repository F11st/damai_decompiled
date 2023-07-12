package cn.damai.tetris.component.online.viewholder;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.component.drama.viewholder.OnItemClickListener;
import cn.damai.tetris.component.online.bean.ProjectInfoBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class OnlineProListRecycleAdapter extends RecyclerView.Adapter<OnLineProListViewHolder> implements OnItemClickListener<ProjectInfoBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<ProjectInfoBean> a;
    private OnItemBindListener<ProjectInfoBean> b;

    public OnlineProListRecycleAdapter(OnItemBindListener<ProjectInfoBean> onItemBindListener) {
        this.b = onItemBindListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull OnLineProListViewHolder onLineProListViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-966174383")) {
            ipChange.ipc$dispatch("-966174383", new Object[]{this, onLineProListViewHolder, Integer.valueOf(i)});
            return;
        }
        ProjectInfoBean projectInfoBean = this.a.get(i);
        OnItemBindListener<ProjectInfoBean> onItemBindListener = this.b;
        if (onItemBindListener != null) {
            onItemBindListener.exposeItem(onLineProListViewHolder.itemView, projectInfoBean, i);
        }
        onLineProListViewHolder.a(projectInfoBean, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: b */
    public OnLineProListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1442735237") ? (OnLineProListViewHolder) ipChange.ipc$dispatch("1442735237", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new OnLineProListViewHolder(mu0.a(), viewGroup, this);
    }

    @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
    /* renamed from: c */
    public void onItemClick(ProjectInfoBean projectInfoBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-89376901")) {
            ipChange.ipc$dispatch("-89376901", new Object[]{this, projectInfoBean, Integer.valueOf(i)});
            return;
        }
        OnItemBindListener<ProjectInfoBean> onItemBindListener = this.b;
        if (onItemBindListener == null || projectInfoBean == null) {
            return;
        }
        onItemBindListener.onItemClick(projectInfoBean, i);
    }

    public void d(List<ProjectInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1453719018")) {
            ipChange.ipc$dispatch("1453719018", new Object[]{this, list});
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-922696241")) {
            return ((Integer) ipChange.ipc$dispatch("-922696241", new Object[]{this})).intValue();
        }
        List<ProjectInfoBean> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
