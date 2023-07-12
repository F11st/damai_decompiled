package cn.damai.homepage.ui.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.baseview.RCRelativeLayoutView;
import cn.damai.category.ranking.ui.RankListFragment;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.util.DMRGBUtil;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.bean.WaterFlowRecommendItem;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.C9826vr;
import tb.cb1;
import tb.cs;
import tb.nk;
import tb.py0;
import tb.su0;
import tb.t60;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WaterFlowRankListViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private ImageView b;
    private ImageView c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private String h;
    private int i;
    private int j;
    private View.OnClickListener k;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.ui.viewholder.WaterFlowRankListViewHolder$a */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC1198a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1198a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "394112498")) {
                ipChange.ipc$dispatch("394112498", new Object[]{this, view});
                return;
            }
            WaterFlowRecommendItem waterFlowRecommendItem = (WaterFlowRecommendItem) view.getTag();
            C0529c e = C0529c.e();
            py0 I = py0.I();
            String str = WaterFlowRankListViewHolder.this.h;
            String str2 = waterFlowRecommendItem.projectId;
            String str3 = waterFlowRecommendItem.alg;
            String str4 = waterFlowRecommendItem.scm;
            String str5 = waterFlowRecommendItem.cardType;
            e.x(I.M(str, str2, str3, str4, str5, "5".equals(str5) ? waterFlowRecommendItem.id : waterFlowRecommendItem.detailedListId, waterFlowRecommendItem.pageNum, waterFlowRecommendItem.index, waterFlowRecommendItem.title, waterFlowRecommendItem.schema));
            Bundle bundle = new Bundle();
            if ("5".equals(waterFlowRecommendItem.cardType)) {
                long j = 0;
                try {
                    j = Long.parseLong(waterFlowRecommendItem.id);
                } catch (Exception e2) {
                    cb1.b("WaterFlowRankListViewHolder", e2.getMessage());
                }
                bundle.putLong(RankListFragment.KEY_RANK_ID, j);
                DMNav.from(WaterFlowRankListViewHolder.this.a).withExtras(bundle).toUri(NavUri.b(cs.C));
                return;
            }
            bundle.putString("id", waterFlowRecommendItem.detailedListId);
            DMNav.from(WaterFlowRankListViewHolder.this.a).withExtras(bundle).toUri(NavUri.b("detailed_list"));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.ui.viewholder.WaterFlowRankListViewHolder$b */
    /* loaded from: classes5.dex */
    public class C1199b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1199b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1097845925")) {
                ipChange.ipc$dispatch("1097845925", new Object[]{this, c0501d});
                return;
            }
            WaterFlowRankListViewHolder.this.b.setImageResource(R$drawable.uikit_default_image_bg_gradient);
            WaterFlowRankListViewHolder.this.render(Color.parseColor("#819ef2"));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.ui.viewholder.WaterFlowRankListViewHolder$c */
    /* loaded from: classes5.dex */
    public class C1200c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.homepage.ui.viewholder.WaterFlowRankListViewHolder$c$a */
        /* loaded from: classes5.dex */
        public class C1201a implements DMRGBUtil.OnFetchColorListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C1201a() {
            }

            @Override // cn.damai.commonbusiness.util.DMRGBUtil.OnFetchColorListener
            public void onFetchColor(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1247599547")) {
                    ipChange.ipc$dispatch("1247599547", new Object[]{this, Integer.valueOf(i)});
                } else {
                    WaterFlowRankListViewHolder.this.render(i);
                }
            }
        }

        C1200c(String str) {
            this.a = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-772870534")) {
                ipChange.ipc$dispatch("-772870534", new Object[]{this, c0502e});
                return;
            }
            WaterFlowRankListViewHolder.this.b.setImageDrawable(c0502e.a);
            Bitmap bitmap = c0502e.b;
            if (bitmap != null) {
                DMRGBUtil.h(bitmap, this.a, new C1201a());
            }
        }
    }

    public WaterFlowRankListViewHolder(String str, Context context) {
        super(LayoutInflater.from(context).inflate(R$layout.homepage_waterflow_recommend_ranklist, (ViewGroup) null));
        this.k = new View$OnClickListenerC1198a();
        this.h = str;
        this.a = context;
        RCRelativeLayoutView rCRelativeLayoutView = (RCRelativeLayoutView) this.itemView.findViewById(R$id.homepage_waterflow_rank_image_layout);
        this.b = (ImageView) this.itemView.findViewById(R$id.homepage_waterflow_rank_image);
        this.c = (ImageView) this.itemView.findViewById(R$id.homepage_water_flow_rank_gradient);
        this.d = (ImageView) this.itemView.findViewById(R$id.homepage_waterflow_recommend_ranklist_tag_img);
        this.e = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_rank_type);
        this.f = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_rank_title);
        this.g = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_rank_subtitle);
        int a = (DisplayMetrics.getwidthPixels(t60.b(context)) - t60.a(context, 24.0f)) / 2;
        this.i = a;
        this.j = (int) (((a * 393) * 1.0f) / 342.0f);
        ViewGroup.LayoutParams layoutParams = rCRelativeLayoutView.getLayoutParams();
        layoutParams.width = this.i;
        layoutParams.height = this.j;
        rCRelativeLayoutView.setLayoutParams(layoutParams);
        this.itemView.setLayoutParams(new FrameLayout.LayoutParams(-1, this.j + t60.a(context, 9.0f)));
        this.itemView.setOnClickListener(this.k);
    }

    public void handleView(WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "52955191")) {
            ipChange.ipc$dispatch("52955191", new Object[]{this, waterFlowRecommendItem});
        } else if (waterFlowRecommendItem == null) {
        } else {
            this.itemView.setTag(waterFlowRecommendItem);
            if (this.b.getTag() instanceof C9826vr) {
                ((C9826vr) this.b.getTag()).cancel();
            }
            String str = "5".equals(waterFlowRecommendItem.cardType) ? waterFlowRecommendItem.pic : waterFlowRecommendItem.backgroundPic;
            this.b.setTag(C0504a.b().f(str, this.i, this.j).n(new C1200c(str)).e(new C1199b()).f());
            this.d.setVisibility("5".equals(waterFlowRecommendItem.cardType) ? 0 : 8);
            if (wh2.j(waterFlowRecommendItem.title)) {
                this.f.setVisibility(4);
            } else {
                this.f.setVisibility(0);
                this.f.setText(waterFlowRecommendItem.title);
            }
            if (wh2.j(waterFlowRecommendItem.subTitle)) {
                this.g.setVisibility(4);
            } else {
                this.g.setVisibility(0);
                this.g.setText(waterFlowRecommendItem.subTitle);
            }
            if ("5".equals(waterFlowRecommendItem.cardType)) {
                this.e.setBackground(this.a.getResources().getDrawable(R$drawable.feed_card_rank_bang));
            } else {
                this.e.setBackground(this.a.getResources().getDrawable(R$drawable.feed_card_rank_mai));
            }
            py0 I = py0.I();
            View view = this.itemView;
            String str2 = this.h;
            String str3 = waterFlowRecommendItem.projectId;
            String str4 = waterFlowRecommendItem.alg;
            String str5 = waterFlowRecommendItem.scm;
            String str6 = waterFlowRecommendItem.cardType;
            I.T(view, str2, str3, str4, str5, str6, "5".equals(str6) ? waterFlowRecommendItem.id : waterFlowRecommendItem.detailedListId, waterFlowRecommendItem.index);
        }
    }

    public void render(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1469808539")) {
            ipChange.ipc$dispatch("-1469808539", new Object[]{this, Integer.valueOf(i)});
        } else {
            su0.b(this.c, GradientDrawable.Orientation.TOP_BOTTOM, 0.0f, new int[]{nk.c(1.0f, i), nk.c(0.8f, i), nk.c(0.4f, i), nk.c(0.0f, i), nk.c(0.0f, i)});
        }
    }
}
