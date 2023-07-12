package cn.damai.homepage.ui.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.discover.viewholder.ImgTicketWrap;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.bean.WaterFlowRecommendItem;
import cn.damai.tetris.component.discover.bean.ThemeBean;
import cn.damai.tetris.component.girl.mvp.HWRatioLayout;
import cn.damai.uikit.view.StrokeLinearLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cs;
import tb.f91;
import tb.ih2;
import tb.m62;
import tb.mu0;
import tb.py0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WaterFlowThemeViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private HWRatioLayout a;
    private ImageView b;
    private TextView c;
    private TextView d;
    private View e;
    private Context f;
    private View g;
    private View h;
    private View i;
    private String j;
    private View k;
    private StrokeLinearLayout l;
    public ThemeBean m;
    private int n;
    private int o;
    private int p;
    private View.OnClickListener q;
    private int[] r;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1002742287")) {
                ipChange.ipc$dispatch("-1002742287", new Object[]{this, view});
                return;
            }
            ThemeBean themeBean = (ThemeBean) view.getTag();
            if (themeBean != null) {
                Bundle bundle = new Bundle();
                bundle.putString("themeId", themeBean.id);
                DMNav.from(WaterFlowThemeViewHolder.this.f).withExtras(bundle).toUri(NavUri.b(cs.DISCOVER_THEME));
                py0.I().Q(themeBean.id, themeBean.pos);
            }
        }
    }

    public WaterFlowThemeViewHolder(String str, Context context) {
        super(LayoutInflater.from(context).inflate(R$layout.homepage_waterflow_recommend_theme, (ViewGroup) null));
        this.q = new a();
        this.r = new int[]{Color.parseColor("#00000000"), Color.parseColor("#0a000000"), Color.parseColor("#1c000000"), Color.parseColor("#35000000"), Color.parseColor("#54000000"), Color.parseColor("#75000000"), Color.parseColor("#99000000"), Color.parseColor("#bc000000"), Color.parseColor("#dd000000"), Color.parseColor("#ff000000")};
        this.j = str;
        this.f = context;
        this.b = (ImageView) this.itemView.findViewById(R$id.theme_img);
        this.c = (TextView) this.itemView.findViewById(R$id.theme_title);
        this.d = (TextView) this.itemView.findViewById(R$id.theme_watch_info);
        this.a = (HWRatioLayout) this.itemView.findViewById(R$id.theme_img_hw_ratio_layout);
        this.e = this.itemView.findViewById(R$id.theme_price_tag);
        this.h = this.itemView.findViewById(R$id.bottom_end_layout);
        this.g = this.itemView.findViewById(R$id.bottom_top_shader);
        this.i = this.itemView.findViewById(R$id.bottom_bg_layout);
        this.k = this.itemView.findViewById(R$id.video_icon);
        this.l = (StrokeLinearLayout) this.itemView.findViewById(R$id.theme_img_hw_stroke_layout);
        this.p = m62.a(mu0.a(), 6.0f);
        this.n = m62.a(mu0.a(), 3.0f);
        this.o = m62.a(mu0.a(), 3.0f);
        this.itemView.setOnClickListener(this.q);
    }

    private Drawable c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1319293863")) {
            return (Drawable) ipChange.ipc$dispatch("1319293863", new Object[]{this});
        }
        f91 f91Var = new f91();
        f91Var.b(this.r, null);
        return f91Var;
    }

    public void b(WaterFlowRecommendItem waterFlowRecommendItem, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-627418773")) {
            ipChange.ipc$dispatch("-627418773", new Object[]{this, waterFlowRecommendItem, Integer.valueOf(i)});
        } else if (waterFlowRecommendItem != null) {
            ThemeBean themeBean = waterFlowRecommendItem.themeCard;
            this.m = themeBean;
            themeBean.pos = i;
            if (themeBean != null) {
                float f = themeBean.hwRatio;
                if (f > 0.0f) {
                    this.a.setHwRatio(f);
                } else {
                    this.a.setHwRatio(1.0f);
                }
                this.itemView.setTag(this.m);
                if (this.m.highLight) {
                    this.g.setBackground(null);
                    this.i.setBackgroundResource(R$drawable.icon_theme_bg);
                    this.h.setBackgroundColor(0);
                    StrokeLinearLayout strokeLinearLayout = this.l;
                    int i2 = this.n;
                    strokeLinearLayout.setPadding(i2, i2, i2, i2);
                    this.l.setCornerAndStroke(this.p, this.o, new int[]{Color.parseColor("#FF4E6E"), Color.parseColor("#FF833C")});
                } else {
                    this.g.setBackground(c());
                    this.i.setBackground(null);
                    this.h.setBackgroundColor(-16777216);
                    this.l.setPadding(0, 0, 0, 0);
                    this.l.setCornerAndStroke(this.p, 1, Color.parseColor("#26000000"));
                }
                this.k.setVisibility(this.m.isShowVideoIcon() ? 0 : 8);
                ImgTicketWrap.c(this.b, this.m.pic, R$drawable.uikit_default_image_bg_gradient_v2, null);
                Context context = this.itemView.getContext();
                if (context == null) {
                    this.c.setText(this.m.name);
                } else {
                    this.c.setText(ih2.b(context, R$drawable.icon_theme_title_prefix, this.m.name));
                }
                ThemeBean themeBean2 = this.m;
                String a2 = ih2.a(themeBean2.contentCount, themeBean2.ipvuv);
                this.d.setTextColor(Color.parseColor("#99FFFFFF"));
                this.d.setText(a2);
                this.e.setVisibility(this.m.hasPrize() ? 0 : 8);
                py0 I = py0.I();
                View view = this.itemView;
                String str = this.j;
                String str2 = waterFlowRecommendItem.projectId;
                ThemeBean themeBean3 = this.m;
                I.V(view, str, str2, "", themeBean3.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, "", "", "", waterFlowRecommendItem.index, themeBean3.id, "theme");
            }
        }
    }
}
