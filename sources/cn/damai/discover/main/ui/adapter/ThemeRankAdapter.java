package cn.damai.discover.main.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.a;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2;
import cn.damai.discover.main.ui.bean.RankUserBean;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.m62;
import tb.vr;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ThemeRankAdapter extends RecyclerView.Adapter<RankVh> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<RankUserBean> a;
    private Context b;
    private OnItemBindListener<RankUserBean> c;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class RankVh extends BaseViewHolderV2<RankUserBean> implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView c;
        private TextView d;
        private View e;
        private TextView f;
        private ImageView g;
        private ImageView h;
        private int i;

        public RankVh(Context context, ViewGroup viewGroup) {
            super(BaseViewHolder.b(context, viewGroup, R$layout.item_theme_rank_user));
            this.i = m62.a(context, 40.0f);
            this.h = (ImageView) this.itemView.findViewById(R$id.rank_user_icon);
            this.g = (ImageView) this.itemView.findViewById(R$id.rank_user_mask);
            this.f = (TextView) this.itemView.findViewById(R$id.rank_user_num);
            this.e = this.itemView.findViewById(R$id.rank_user_me_tag);
            this.d = (TextView) this.itemView.findViewById(R$id.rank_user_name);
            this.c = (TextView) this.itemView.findViewById(R$id.rank_user_extra);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2
        /* renamed from: d */
        public void c(RankUserBean rankUserBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1268530959")) {
                ipChange.ipc$dispatch("1268530959", new Object[]{this, rankUserBean, Integer.valueOf(i)});
            } else if (rankUserBean == null) {
            } else {
                this.h.setImageResource(R$drawable.icon_rank_head_default);
                Object tag = this.h.getTag();
                if (tag instanceof vr) {
                    ((vr) tag).cancel();
                }
                vr vrVar = null;
                String str = rankUserBean.headPic;
                if (!TextUtils.isEmpty(str)) {
                    a b = a.b();
                    int i2 = this.i;
                    vrVar = b.f(str, i2, i2).g(this.h);
                }
                this.h.setTag(vrVar);
                this.e.setVisibility(rankUserBean.isCurrentLoginUser ? 0 : 8);
                this.d.setText(rankUserBean.nickName);
                this.g.setImageResource(rankUserBean.getMaskDrawableRid());
                this.f.setText(rankUserBean.getRankNum());
                this.c.setText(rankUserBean.countDisplay);
                this.itemView.setOnClickListener(this);
                if (ThemeRankAdapter.this.c != null) {
                    ThemeRankAdapter.this.c.exposeItem(this.itemView, (RankUserBean) this.a, i);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            T t;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "692062246")) {
                ipChange.ipc$dispatch("692062246", new Object[]{this, view});
            } else if (ThemeRankAdapter.this.c == null || (t = this.a) == 0 || !((RankUserBean) t).isValidUser()) {
            } else {
                ThemeRankAdapter.this.c.onItemClick((RankUserBean) this.a, this.b);
            }
        }
    }

    public ThemeRankAdapter(Context context, OnItemBindListener<RankUserBean> onItemBindListener) {
        this.b = context;
        this.c = onItemBindListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public void onBindViewHolder(@NonNull RankVh rankVh, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-453867124")) {
            ipChange.ipc$dispatch("-453867124", new Object[]{this, rankVh, Integer.valueOf(i)});
        } else {
            rankVh.a(this.a.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: c */
    public RankVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "619133866") ? (RankVh) ipChange.ipc$dispatch("619133866", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new RankVh(this.b, viewGroup);
    }

    public void d(List<RankUserBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "88771175")) {
            ipChange.ipc$dispatch("88771175", new Object[]{this, list});
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-239707508")) {
            return ((Integer) ipChange.ipc$dispatch("-239707508", new Object[]{this})).intValue();
        }
        List<RankUserBean> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
