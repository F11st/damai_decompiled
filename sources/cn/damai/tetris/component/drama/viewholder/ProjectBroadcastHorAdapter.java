package cn.damai.tetris.component.drama.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.drama.bean.ProjectShowBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.m62;
import tb.mu0;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ProjectBroadcastHorAdapter extends RecyclerView.Adapter<ProjectBroadCastViewHolder> implements OnItemClickListener<ProjectShowBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<ProjectShowBean> a;
    private int b = m62.a(mu0.a(), 21.0f);
    private int c = m62.a(mu0.a(), 4.0f);
    private OnItemBindListener<ProjectShowBean> d;

    public ProjectBroadcastHorAdapter(OnItemBindListener<ProjectShowBean> onItemBindListener) {
        this.d = onItemBindListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull ProjectBroadCastViewHolder projectBroadCastViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1816255191")) {
            ipChange.ipc$dispatch("-1816255191", new Object[]{this, projectBroadCastViewHolder, Integer.valueOf(i)});
            return;
        }
        ProjectShowBean projectShowBean = this.a.get(i);
        OnItemBindListener<ProjectShowBean> onItemBindListener = this.d;
        if (onItemBindListener != null) {
            onItemBindListener.exposeItem(projectBroadCastViewHolder.itemView, projectShowBean, i);
        }
        projectBroadCastViewHolder.a(projectShowBean, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: b */
    public ProjectBroadCastViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1588418643")) {
            return (ProjectBroadCastViewHolder) ipChange.ipc$dispatch("-1588418643", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        int e = wh2.e(this.a);
        int measuredWidth = viewGroup.getMeasuredWidth();
        View inflate = LayoutInflater.from(mu0.a()).inflate(R$layout.item_tetris_drama_coming, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        if (layoutParams != null) {
            int i2 = measuredWidth - (this.b * 2);
            layoutParams.width = i2;
            if (e > 1) {
                layoutParams.width = i2 - this.c;
            }
        }
        return new ProjectBroadCastViewHolder(inflate, this);
    }

    @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
    /* renamed from: c */
    public void onItemClick(ProjectShowBean projectShowBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1444556238")) {
            ipChange.ipc$dispatch("1444556238", new Object[]{this, projectShowBean, Integer.valueOf(i)});
            return;
        }
        OnItemBindListener<ProjectShowBean> onItemBindListener = this.d;
        if (onItemBindListener == null || projectShowBean == null) {
            return;
        }
        onItemBindListener.onItemClick(projectShowBean, i);
    }

    public void d(List<ProjectShowBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1042103910")) {
            ipChange.ipc$dispatch("-1042103910", new Object[]{this, list});
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "385705343")) {
            return ((Integer) ipChange.ipc$dispatch("385705343", new Object[]{this})).intValue();
        }
        List<ProjectShowBean> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
