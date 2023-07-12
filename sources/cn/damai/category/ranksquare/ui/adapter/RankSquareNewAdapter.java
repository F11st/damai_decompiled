package cn.damai.category.ranksquare.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.ranksquare.bean.RankSquareListInfoBean;
import cn.damai.category.ranksquare.ui.viewholder.RankSquareHorizontalListViewHolder;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.component.drama.viewholder.OnItemClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RankSquareNewAdapter extends RecyclerView.Adapter<RankSquareHorizontalListViewHolder> implements OnItemClickListener<RankSquareListInfoBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<RankSquareListInfoBean> a;
    private Context b;
    private OnItemBindListener<RankSquareListInfoBean> c;

    public RankSquareNewAdapter(Context context, List<RankSquareListInfoBean> list) {
        this.a = list;
        this.b = context;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull RankSquareHorizontalListViewHolder rankSquareHorizontalListViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-597911044")) {
            ipChange.ipc$dispatch("-597911044", new Object[]{this, rankSquareHorizontalListViewHolder, Integer.valueOf(i)});
            return;
        }
        RankSquareListInfoBean rankSquareListInfoBean = this.a.get(i);
        OnItemBindListener<RankSquareListInfoBean> onItemBindListener = this.c;
        if (onItemBindListener != null) {
            onItemBindListener.exposeItem(rankSquareHorizontalListViewHolder.itemView, rankSquareListInfoBean, i);
        }
        rankSquareHorizontalListViewHolder.a(rankSquareListInfoBean, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: b */
    public RankSquareHorizontalListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1894424762") ? (RankSquareHorizontalListViewHolder) ipChange.ipc$dispatch("1894424762", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new RankSquareHorizontalListViewHolder(this.b, viewGroup, this);
    }

    @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
    /* renamed from: c */
    public void onItemClick(RankSquareListInfoBean rankSquareListInfoBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "898782700")) {
            ipChange.ipc$dispatch("898782700", new Object[]{this, rankSquareListInfoBean, Integer.valueOf(i)});
            return;
        }
        OnItemBindListener<RankSquareListInfoBean> onItemBindListener = this.c;
        if (onItemBindListener != null && rankSquareListInfoBean != null) {
            onItemBindListener.onItemClick(rankSquareListInfoBean, i);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "925946949")) {
            return ((Integer) ipChange.ipc$dispatch("925946949", new Object[]{this})).intValue();
        }
        List<RankSquareListInfoBean> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
