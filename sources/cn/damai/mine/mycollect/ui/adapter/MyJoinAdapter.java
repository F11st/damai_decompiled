package cn.damai.mine.mycollect.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.ranking.ui.RankListFragment;
import cn.damai.common.bean.RankBean;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.rank.CommonRankHolder;
import cn.damai.commonbusiness.rank.RankItemBean;
import cn.damai.mine.mycollect.bean.MyCollectDataHolder;
import cn.damai.mine.mycollect.ui.viewholder.MyCollectBottomViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.hi1;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MyJoinAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int BOTTOM = 1;
    public static final int COLLECTION = 0;
    private Context a;
    private View.OnLongClickListener b;
    private List<MyCollectDataHolder> c;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.mycollect.ui.adapter.MyJoinAdapter$a */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1442a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RankBean a;
        final /* synthetic */ RankBean b;
        final /* synthetic */ int c;

        View$OnClickListenerC1442a(RankBean rankBean, RankBean rankBean2, int i) {
            this.a = rankBean;
            this.b = rankBean2;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1045927645")) {
                ipChange.ipc$dispatch("-1045927645", new Object[]{this, view});
                return;
            }
            C0529c e = C0529c.e();
            hi1 m = hi1.m();
            RankBean rankBean = this.a;
            e.x(m.n(rankBean.name, rankBean.id, this.b.type, this.c));
            int i = this.b.type;
            if (i == 13) {
                Bundle bundle = new Bundle();
                bundle.putString(RankListFragment.KEY_RANK_ID, this.a.id);
                DMNav.from(MyJoinAdapter.this.a).withExtras(bundle).forResult(1000).toUri(NavUri.b("ranking"));
            } else if (i != 14) {
            } else {
                Bundle bundle2 = new Bundle();
                bundle2.putString("id", this.a.id);
                DMNav.from(MyJoinAdapter.this.a).withExtras(bundle2).forResult(1000).toUri(NavUri.b("detailed_list"));
            }
        }
    }

    public MyJoinAdapter(Context context, List<MyCollectDataHolder> list) {
        this.a = context;
        this.c = list;
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "885094267")) {
            ipChange.ipc$dispatch("885094267", new Object[]{this, onLongClickListener});
        } else {
            this.b = onLongClickListener;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-429731630") ? ((Integer) ipChange.ipc$dispatch("-429731630", new Object[]{this})).intValue() : wh2.e(this.c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1507388807") ? ((Integer) ipChange.ipc$dispatch("-1507388807", new Object[]{this, Integer.valueOf(i)})).intValue() : this.c.get(i).type;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        MyCollectDataHolder myCollectDataHolder;
        RankBean rankBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "547662055")) {
            ipChange.ipc$dispatch("547662055", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder == null || (myCollectDataHolder = this.c.get(i)) == null || myCollectDataHolder.type != 0 || (rankBean = myCollectDataHolder.mJoinBean) == null) {
        } else {
            RankItemBean rankItemBean = new RankItemBean();
            rankItemBean.pic = rankBean.bgPic;
            rankItemBean.shortName = rankBean.name;
            rankItemBean.shortDesc = rankBean.shortName;
            rankItemBean.followDesc = rankBean.ipvuv;
            rankItemBean.count = rankBean.count;
            rankItemBean.statusName = rankBean.statusName;
            rankItemBean.type = rankBean.type == 13 ? 1 : 2;
            ((CommonRankHolder) viewHolder).a(rankItemBean);
            viewHolder.itemView.setTag(Integer.valueOf(i));
            viewHolder.itemView.setOnLongClickListener(this.b);
            if (rankBean.isEnableClick()) {
                viewHolder.itemView.setOnClickListener(new View$OnClickListenerC1442a(rankBean, rankBean, i));
            } else {
                viewHolder.itemView.setOnClickListener(null);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-87534353")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-87534353", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(this.a);
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return new MyCollectBottomViewHolder(from);
        }
        return new CommonRankHolder(from);
    }
}
