package cn.damai.category.ranksquare.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.ranksquare.bean.RankSquareDataHolder;
import cn.damai.category.ranksquare.ui.viewholder.RanKSquareBottomViewHolder;
import cn.damai.category.ranksquare.ui.viewholder.RankSquareListViewHolder;
import cn.damai.category.ranksquare.ui.viewholder.RankSquareLocalTitleViewHolder;
import cn.damai.category.ranksquare.ui.viewholder.RankSquareLocalViewHolder;
import cn.damai.category.ranksquare.ui.viewholder.RankSquareTitleViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RankSquareAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<RankSquareDataHolder> b;

    public RankSquareAdapter(Context context, List<RankSquareDataHolder> list) {
        this.a = context;
        this.b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "277820677") ? ((Integer) ipChange.ipc$dispatch("277820677", new Object[]{this})).intValue() : wh2.e(this.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1582310700") ? ((Integer) ipChange.ipc$dispatch("1582310700", new Object[]{this, Integer.valueOf(i)})).intValue() : this.b.get(i).mType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1496008916")) {
            ipChange.ipc$dispatch("1496008916", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            RankSquareDataHolder rankSquareDataHolder = this.b.get(i);
            int i2 = rankSquareDataHolder.mType;
            if (i2 == 0) {
                ((RankSquareTitleViewHolder) viewHolder).c(rankSquareDataHolder.rankSquareName, rankSquareDataHolder.rankSquareSubTitle, rankSquareDataHolder.fans, rankSquareDataHolder.id, rankSquareDataHolder.rankType, i);
            } else if (i2 == 1) {
                ((RankSquareListViewHolder) viewHolder).b(rankSquareDataHolder.mRankItem);
            } else if (i2 == 2) {
                ((RankSquareLocalTitleViewHolder) viewHolder).a(rankSquareDataHolder.rankSquareName, i);
            } else if (i2 != 3) {
            } else {
                ((RankSquareLocalViewHolder) viewHolder).e(rankSquareDataHolder.mLocalItemBeans, rankSquareDataHolder.mLocalRank);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-170620510")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-170620510", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(this.a);
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return null;
                        }
                        return new RanKSquareBottomViewHolder(from);
                    }
                    return new RankSquareLocalViewHolder(from);
                }
                return new RankSquareLocalTitleViewHolder(from);
            }
            return new RankSquareListViewHolder(from);
        }
        return new RankSquareTitleViewHolder(from);
    }
}
