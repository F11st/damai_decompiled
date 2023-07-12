package cn.damai.tetris.component.rank.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.component.drama.viewholder.OnItemClickListener;
import cn.damai.tetris.component.rank.bean.RankSelectItemBean;
import cn.damai.tetris.component.rank.view.RankSelectItemViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class RankSelectAdapter extends RecyclerView.Adapter<RankSelectItemViewHolder> implements OnItemClickListener<RankSelectItemBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private final OnItemBindListener<RankSelectItemBean> a;
    @Nullable
    private List<RankSelectItemBean> b;

    public RankSelectAdapter(@Nullable OnItemBindListener<RankSelectItemBean> onItemBindListener) {
        this.a = onItemBindListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NotNull RankSelectItemViewHolder rankSelectItemViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-259299717")) {
            ipChange.ipc$dispatch("-259299717", new Object[]{this, rankSelectItemViewHolder, Integer.valueOf(i)});
            return;
        }
        b41.i(rankSelectItemViewHolder, "holder");
        List<RankSelectItemBean> list = this.b;
        b41.f(list);
        RankSelectItemBean rankSelectItemBean = list.get(i);
        OnItemBindListener<RankSelectItemBean> onItemBindListener = this.a;
        if (onItemBindListener != null) {
            onItemBindListener.exposeItem(rankSelectItemViewHolder.itemView, rankSelectItemBean, i);
        }
        rankSelectItemViewHolder.a(rankSelectItemBean, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: b */
    public RankSelectItemViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-142248869")) {
            return (RankSelectItemViewHolder) ipChange.ipc$dispatch("-142248869", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        b41.i(viewGroup, "parent");
        return new RankSelectItemViewHolder(mu0.a(), viewGroup, this);
    }

    @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
    /* renamed from: c */
    public void onItemClick(@Nullable RankSelectItemBean rankSelectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1374831578")) {
            ipChange.ipc$dispatch("1374831578", new Object[]{this, rankSelectItemBean, Integer.valueOf(i)});
            return;
        }
        OnItemBindListener<RankSelectItemBean> onItemBindListener = this.a;
        if (onItemBindListener == null || rankSelectItemBean == null) {
            return;
        }
        onItemBindListener.onItemClick(rankSelectItemBean, i);
    }

    public final void d(@Nullable List<RankSelectItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-344205682")) {
            ipChange.ipc$dispatch("-344205682", new Object[]{this, list});
            return;
        }
        this.b = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1988778867")) {
            return ((Integer) ipChange.ipc$dispatch("1988778867", new Object[]{this})).intValue();
        }
        List<RankSelectItemBean> list = this.b;
        if (list == null) {
            return 0;
        }
        b41.f(list);
        return list.size();
    }
}
