package cn.damai.category.ranksquare.ui.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.category.ranking.ui.RankListFragment;
import cn.damai.category.ranksquare.bean.RankSquareListInfoBean;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.tetris.component.drama.viewholder.OnItemClickListener;
import cn.damai.tetris.component.online.viewholder.OnLinePosterView;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.uikit.nav.NavProxy;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cs;
import tb.ih2;
import tb.u12;
import tb.z20;
import tb.zy1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RankSquareHorizontalListViewHolder extends BaseViewHolderV2<RankSquareListInfoBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView c;
    private TextView d;
    private Context e;
    private OnItemClickListener<RankSquareListInfoBean> f;
    private FlowLayout g;
    private RelativeLayout h;
    private HeaderPicListViewHolder i;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RankSquareListInfoBean a;

        a(RankSquareListInfoBean rankSquareListInfoBean) {
            this.a = rankSquareListInfoBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "853208362")) {
                ipChange.ipc$dispatch("853208362", new Object[]{this, view});
            } else if (!TextUtils.isEmpty(this.a.schema)) {
                c.e().x(zy1.f().s());
                Bundle bundle = new Bundle();
                bundle.putString("cityId", z20.c());
                NavProxy.from(RankSquareHorizontalListViewHolder.this.e).withExtras(bundle).toUri(this.a.schema);
            } else if (Integer.parseInt(this.a.type) == 5) {
                Bundle bundle2 = new Bundle();
                bundle2.putLong(RankListFragment.KEY_RANK_ID, Long.parseLong(this.a.id));
                DMNav.from(RankSquareHorizontalListViewHolder.this.e).withExtras(bundle2).toUri(NavUri.b("rank"));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RankSquareListInfoBean a;
        final /* synthetic */ int b;

        b(RankSquareListInfoBean rankSquareListInfoBean, int i) {
            this.a = rankSquareListInfoBean;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1330468565")) {
                ipChange.ipc$dispatch("-1330468565", new Object[]{this, view});
            } else if (Integer.parseInt(this.a.type) == 6) {
                Bundle bundle = new Bundle();
                bundle.putString("themeId", this.a.itemList.get(this.b).id);
                DMNav.from(RankSquareHorizontalListViewHolder.this.e).withExtras(bundle).toUri(NavUri.b(cs.DISCOVER_THEME));
                c.e().x(zy1.f().r(this.a.itemList.get(this.b).id, this.b));
            } else if (Integer.parseInt(this.a.type) == 5) {
                c.e().x(zy1.f().p(this.a.itemList.get(this.b).id, this.b));
                Bundle bundle2 = new Bundle();
                bundle2.putString(RepertoireDetailFragment.REPERTOIREID, this.a.itemList.get(this.b).id);
                DMNav.from(RankSquareHorizontalListViewHolder.this.e).withExtras(bundle2).toUri(NavUri.b(u12.REPERTOITE));
            }
        }
    }

    public RankSquareHorizontalListViewHolder(Context context, ViewGroup viewGroup, OnItemClickListener<RankSquareListInfoBean> onItemClickListener) {
        super(LayoutInflater.from(context).inflate(R$layout.rank_square_hori_list_item, viewGroup, false));
        this.e = context;
        this.c = (TextView) this.itemView.findViewById(R$id.square_title);
        this.d = (TextView) this.itemView.findViewById(R$id.square_sub_title);
        this.g = (FlowLayout) this.itemView.findViewById(R$id.square_items);
        this.h = (RelativeLayout) this.itemView.findViewById(R$id.square_header);
        this.i = (HeaderPicListViewHolder) this.itemView.findViewById(R$id.square_piclist_view);
        this.f = onItemClickListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2
    /* renamed from: e */
    public void c(RankSquareListInfoBean rankSquareListInfoBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "34227002")) {
            ipChange.ipc$dispatch("34227002", new Object[]{this, rankSquareListInfoBean, Integer.valueOf(i)});
        } else if (rankSquareListInfoBean != null) {
            FlowLayout flowLayout = this.g;
            if (flowLayout != null) {
                flowLayout.removeAllViews();
            }
            this.c.setText(rankSquareListInfoBean.name);
            this.d.setText(rankSquareListInfoBean.description);
            this.h.setOnClickListener(new a(rankSquareListInfoBean));
            for (int i2 = 0; i2 < rankSquareListInfoBean.itemList.size(); i2++) {
                View inflate = LayoutInflater.from(this.e).inflate(R$layout.rank_square_pro_list_item, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R$id.squre_tv_rank_name);
                DMDigitTextView dMDigitTextView = (DMDigitTextView) inflate.findViewById(R$id.join_number);
                ImageView imageView = (ImageView) inflate.findViewById(R$id.icon_index);
                if (i2 == 0) {
                    imageView.setImageResource(R$drawable.rank_square_num_1);
                } else if (i2 == 1) {
                    imageView.setImageResource(R$drawable.rank_square_num_2);
                } else if (i2 == 2) {
                    imageView.setImageResource(R$drawable.rank_square_num_3);
                }
                inflate.setOnClickListener(new b(rankSquareListInfoBean, i2));
                OnLinePosterView onLinePosterView = (OnLinePosterView) inflate.findViewById(R$id.squre_image_project);
                OnLinePosterView onLinePosterView2 = (OnLinePosterView) inflate.findViewById(R$id.squre_image_theme);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.theme_price_layout);
                if (Integer.parseInt(rankSquareListInfoBean.type) == 6) {
                    linearLayout.setVisibility(8);
                    dMDigitTextView.setVisibility(0);
                    textView.setText(ih2.b(this.e, R$drawable.squre_title_icon, rankSquareListInfoBean.itemList.get(i2).name));
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("<font color=\"#FF993A\">" + rankSquareListInfoBean.itemList.get(i2).contentCount + "</font>人参与");
                    stringBuffer.append(" | ");
                    stringBuffer.append("<font color=\"#FF993A\">" + rankSquareListInfoBean.itemList.get(i2).ipvuv + "</font>人围观");
                    dMDigitTextView.setText(Html.fromHtml(stringBuffer.toString()));
                    onLinePosterView.setVisibility(8);
                    onLinePosterView2.setVisibility(0);
                    onLinePosterView2.setImageUrlForWebp(rankSquareListInfoBean.itemList.get(i2).headPic, 0, 0);
                } else if (Integer.parseInt(rankSquareListInfoBean.type) == 5) {
                    linearLayout.setVisibility(0);
                    dMDigitTextView.setVisibility(8);
                    textView.setText(rankSquareListInfoBean.itemList.get(i2).name);
                    onLinePosterView2.setVisibility(8);
                    onLinePosterView.setVisibility(0);
                    onLinePosterView.setImageUrlForWebp(rankSquareListInfoBean.itemList.get(i2).headPic, 0, 0);
                }
                this.g.addView(inflate);
            }
            this.i.setData(rankSquareListInfoBean.headPicList);
            if (Integer.parseInt(rankSquareListInfoBean.type) == 6) {
                this.h.setBackgroundResource(R$drawable.square_red_bg);
            } else {
                this.h.setBackgroundResource(R$drawable.square_blue_bg);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        T t;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1215674717")) {
            ipChange.ipc$dispatch("1215674717", new Object[]{this, view});
            return;
        }
        OnItemClickListener<RankSquareListInfoBean> onItemClickListener = this.f;
        if (onItemClickListener == null || (t = this.a) == 0) {
            return;
        }
        onItemClickListener.onItemClick((RankSquareListInfoBean) t, this.b);
    }
}
