package cn.damai.category.ranksquare.ui.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.ranksquare.bean.RankSquareListItemBean;
import cn.damai.common.image.C0504a;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0529c;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.uikit.view.RoundImageView;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m62;
import tb.u12;
import tb.zy1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RankSquareListViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private View b;
    private RoundImageView c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private LinearLayout g;
    private TextView h;
    private DMDigitTextView i;
    private int j;
    private int k;
    private Context l;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.ranksquare.ui.viewholder.RankSquareListViewHolder$a */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0435a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0435a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RankSquareListItemBean rankSquareListItemBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-637058842")) {
                ipChange.ipc$dispatch("-637058842", new Object[]{this, view});
            } else if (RankSquareListViewHolder.this.l == null || (rankSquareListItemBean = (RankSquareListItemBean) view.getTag()) == null) {
            } else {
                C0529c.e().x(zy1.f().p(rankSquareListItemBean.id, rankSquareListItemBean.index));
                Bundle bundle = new Bundle();
                bundle.putString(RepertoireDetailFragment.REPERTOIREID, rankSquareListItemBean.id);
                DMNav.from(RankSquareListViewHolder.this.l).withExtras(bundle).toUri(NavUri.b(u12.REPERTOITE));
            }
        }
    }

    public RankSquareListViewHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.rank_square_list_item, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.l = layoutInflater.getContext();
        this.j = m62.a(layoutInflater.getContext(), 48.0f);
        this.k = m62.a(layoutInflater.getContext(), 64.0f);
        c(this.itemView);
    }

    private void c(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-771597057")) {
            ipChange.ipc$dispatch("-771597057", new Object[]{this, view});
            return;
        }
        this.a = view.findViewById(R$id.top);
        this.b = view.findViewById(R$id.bottom);
        RoundImageView roundImageView = (RoundImageView) view.findViewById(R$id.image_project);
        this.c = roundImageView;
        roundImageView.setBorderRadius(6);
        this.d = (ImageView) view.findViewById(R$id.icon_index);
        this.e = (TextView) view.findViewById(R$id.tv_rank_name);
        this.f = (TextView) view.findViewById(R$id.tv_rank_desc);
        this.g = (LinearLayout) view.findViewById(R$id.ll_price);
        this.i = (DMDigitTextView) view.findViewById(R$id.tv_money_mark_unknown);
        this.h = (TextView) view.findViewById(R$id.tv_money);
        view.setOnClickListener(new View$OnClickListenerC0435a());
    }

    public void b(RankSquareListItemBean rankSquareListItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1728390479")) {
            ipChange.ipc$dispatch("-1728390479", new Object[]{this, rankSquareListItemBean});
        } else if (rankSquareListItemBean == null) {
        } else {
            this.itemView.setTag(rankSquareListItemBean);
            int i = rankSquareListItemBean.index;
            if (i == 0) {
                this.d.setImageResource(R$drawable.rank_square_num_1);
            } else if (i == 1) {
                this.d.setImageResource(R$drawable.rank_square_num_2);
            } else if (i == 2) {
                this.d.setImageResource(R$drawable.rank_square_num_3);
            }
            C0504a.b().f(rankSquareListItemBean.headPic, this.j, this.k).c(R$drawable.uikit_default_image_bg_gradient).g(this.c);
            this.b.setVisibility(rankSquareListItemBean.showBottomLine ? 0 : 8);
            this.a.setVisibility(rankSquareListItemBean.showTopLine ? 0 : 8);
            this.e.setText(rankSquareListItemBean.name);
            this.f.setText(rankSquareListItemBean.subHead);
            if (!TextUtils.isEmpty(rankSquareListItemBean.price) && !"价格待定".equals(rankSquareListItemBean.price) && !"待定".equals(rankSquareListItemBean.price)) {
                this.g.setVisibility(0);
                this.h.setText(rankSquareListItemBean.price);
                this.i.setVisibility(8);
            } else {
                this.g.setVisibility(8);
                this.i.setVisibility(0);
            }
            zy1.f().k(this.itemView, rankSquareListItemBean.id, rankSquareListItemBean.index);
        }
    }
}
