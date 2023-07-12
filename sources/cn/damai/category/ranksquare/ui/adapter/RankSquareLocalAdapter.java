package cn.damai.category.ranksquare.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.ranking.ui.RankListFragment;
import cn.damai.category.ranksquare.bean.RankSquareGroupItemBean;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.tag.DMCategroyTagView;
import cn.damai.uikit.view.RoundImageView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.m62;
import tb.wh2;
import tb.zy1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RankSquareLocalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<RankSquareGroupItemBean> b;
    private boolean c;
    private boolean d;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class RankSquareLocalItemHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private FrameLayout a;
        private RoundImageView b;
        private DMCategroyTagView c;
        private TextView d;
        private TextView e;
        private int f;

        /* compiled from: Taobao */
        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "745083368")) {
                    ipChange.ipc$dispatch("745083368", new Object[]{this, view});
                    return;
                }
                RankSquareGroupItemBean rankSquareGroupItemBean = (RankSquareGroupItemBean) view.getTag();
                if (rankSquareGroupItemBean == null) {
                    return;
                }
                if (rankSquareGroupItemBean.isLocalRank) {
                    c.e().x(zy1.f().l(rankSquareGroupItemBean.shortName, String.valueOf(rankSquareGroupItemBean.id), rankSquareGroupItemBean.index));
                } else {
                    c.e().x(zy1.f().n(rankSquareGroupItemBean.shortName, String.valueOf(rankSquareGroupItemBean.id), rankSquareGroupItemBean.index));
                }
                Bundle bundle = new Bundle();
                bundle.putLong(RankListFragment.KEY_RANK_ID, rankSquareGroupItemBean.id);
                DMNav.from(RankSquareLocalAdapter.this.a).withExtras(bundle).toUri(NavUri.b("ranking"));
            }
        }

        public RankSquareLocalItemHolder(LayoutInflater layoutInflater) {
            super(layoutInflater.inflate(R$layout.rank_square_local_item, (ViewGroup) null));
            this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            this.f = (((DisplayMetrics.getwidthPixels(m62.b(layoutInflater.getContext())) - m62.a(layoutInflater.getContext(), 102.0f)) / 3) * 4) / 3;
            b(this.itemView);
        }

        private void b(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "797008829")) {
                ipChange.ipc$dispatch("797008829", new Object[]{this, view});
                return;
            }
            this.a = (FrameLayout) view.findViewById(R$id.fl_image);
            RoundImageView roundImageView = (RoundImageView) view.findViewById(R$id.image_item);
            this.b = roundImageView;
            roundImageView.setBorderRadius(6);
            this.c = (DMCategroyTagView) view.findViewById(R$id.image_tag);
            this.d = (TextView) view.findViewById(R$id.tv_rank_title);
            this.e = (TextView) view.findViewById(R$id.tv_rank_subtitle);
            this.itemView.setOnClickListener(new a());
        }

        public void a(RankSquareGroupItemBean rankSquareGroupItemBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2121409190")) {
                ipChange.ipc$dispatch("-2121409190", new Object[]{this, rankSquareGroupItemBean});
            } else if (rankSquareGroupItemBean != null) {
                this.itemView.setTag(rankSquareGroupItemBean);
                this.d.setText(rankSquareGroupItemBean.shortName);
                this.e.setText(rankSquareGroupItemBean.shortDesc);
                DMCategroyTagView dMCategroyTagView = this.c;
                dMCategroyTagView.setTagName("共" + rankSquareGroupItemBean.total + "部");
                DMImageCreator e = cn.damai.common.image.a.b().e(wh2.e(rankSquareGroupItemBean.verticalPicList) > 0 ? rankSquareGroupItemBean.verticalPicList.get(0) : "");
                int i = R$drawable.uikit_default_image_bg_gradient;
                e.c(i).i(i).g(this.b);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.getLayoutParams();
                layoutParams.height = this.f;
                this.a.setLayoutParams(layoutParams);
                if (rankSquareGroupItemBean.isLocalRank) {
                    zy1.f().h(this.itemView, String.valueOf(rankSquareGroupItemBean.id), rankSquareGroupItemBean.index);
                } else {
                    zy1.f().i(this.itemView, String.valueOf(rankSquareGroupItemBean.id), rankSquareGroupItemBean.index);
                }
            }
        }
    }

    public RankSquareLocalAdapter(Context context) {
        this.a = context;
    }

    public void b(List<RankSquareGroupItemBean> list, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "262767696")) {
            ipChange.ipc$dispatch("262767696", new Object[]{this, list, Boolean.valueOf(z)});
            return;
        }
        this.d = z;
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.clear();
        this.b.addAll(list);
    }

    public void c(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2082924077")) {
            ipChange.ipc$dispatch("-2082924077", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.c = z;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1386514650")) {
            return ((Integer) ipChange.ipc$dispatch("1386514650", new Object[]{this})).intValue();
        }
        int e = wh2.e(this.b);
        if (this.c || e <= 9) {
            return e;
        }
        return 9;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "725452417")) {
            return ((Integer) ipChange.ipc$dispatch("725452417", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1039250465")) {
            ipChange.ipc$dispatch("-1039250465", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        RankSquareGroupItemBean rankSquareGroupItemBean = this.b.get(i);
        rankSquareGroupItemBean.index = i;
        rankSquareGroupItemBean.isLocalRank = this.d;
        ((RankSquareLocalItemHolder) viewHolder).a(rankSquareGroupItemBean);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-492734217") ? (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-492734217", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new RankSquareLocalItemHolder(LayoutInflater.from(this.a));
    }
}
