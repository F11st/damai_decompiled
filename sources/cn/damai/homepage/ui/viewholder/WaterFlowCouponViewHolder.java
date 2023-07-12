package cn.damai.homepage.ui.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.h5container.h5url.VipUrlGetter;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.bean.WaterFlowRecommendItem;
import cn.damai.login.LoginManager;
import cn.damai.tetris.component.home.HomeData;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.nk;
import tb.py0;
import tb.t60;
import tb.vr;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WaterFlowCouponViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private String h;
    private ImageView i;
    private int j;
    private int k;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "54406446")) {
                ipChange.ipc$dispatch("54406446", new Object[]{this, view});
            } else {
                WaterFlowCouponViewHolder.this.vipClick(view);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2129270481")) {
                ipChange.ipc$dispatch("-2129270481", new Object[]{this, view});
            } else {
                WaterFlowCouponViewHolder.this.couponClick(view);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-17980112")) {
                ipChange.ipc$dispatch("-17980112", new Object[]{this, view});
            } else {
                WaterFlowCouponViewHolder.this.marktingClick(view);
            }
        }
    }

    public WaterFlowCouponViewHolder(String str, Context context) {
        super(LayoutInflater.from(context).inflate(R$layout.homepage_recommend_common_coupon, (ViewGroup) null));
        this.h = str;
        this.a = context;
        RelativeLayout relativeLayout = (RelativeLayout) this.itemView.findViewById(R$id.homepage_waterflow_coupon_layout);
        this.c = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_coupon_money);
        this.d = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_markting_price);
        this.e = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_coupon_title);
        this.f = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_coupon_subtitle);
        this.g = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_coupon_get_btn);
        this.b = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_coupon_rmb_symbol);
        this.i = (ImageView) this.itemView.findViewById(R$id.homepage_waterflow_coupon_image);
        int a2 = ((DisplayMetrics.getwidthPixels(t60.b(context)) - t60.a(context, 24.0f)) / 2) - t60.a(context, 4.5f);
        this.j = a2;
        this.k = (int) (((a2 * 214) * 1.0f) / 160.0f);
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        layoutParams.width = this.j;
        layoutParams.height = this.k;
        relativeLayout.setLayoutParams(layoutParams);
        this.itemView.setLayoutParams(new FrameLayout.LayoutParams(-1, ((int) (((this.j * 214) * 1.0f) / 160.0f)) + t60.a(context, 9.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void couponClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1443088838")) {
            ipChange.ipc$dispatch("-1443088838", new Object[]{this, view});
            return;
        }
        WaterFlowRecommendItem waterFlowRecommendItem = (WaterFlowRecommendItem) view.getTag();
        cn.damai.common.user.c.e().x(py0.I().M(this.h, waterFlowRecommendItem.projectId, waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, "", waterFlowRecommendItem.pageNum, waterFlowRecommendItem.index, waterFlowRecommendItem.title, waterFlowRecommendItem.schema));
        if (LoginManager.k().q()) {
            return;
        }
        LoginManager.k().v(this.a);
        HomeData.isClickRedPacket = true;
    }

    private void handleCouponView(WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-602969983")) {
            ipChange.ipc$dispatch("-602969983", new Object[]{this, waterFlowRecommendItem});
            return;
        }
        if (wh2.j(waterFlowRecommendItem.title)) {
            this.e.setVisibility(4);
        } else {
            this.e.setVisibility(0);
            this.e.setText(waterFlowRecommendItem.title);
            this.e.setTextColor(Color.parseColor("#FFF8D5"));
        }
        if (wh2.j(waterFlowRecommendItem.subTitle)) {
            this.f.setVisibility(4);
        } else {
            this.f.setVisibility(0);
            this.f.setText(waterFlowRecommendItem.subTitle);
            this.f.setTextColor(Color.parseColor("#FFF8D5"));
        }
        if (wh2.j(waterFlowRecommendItem.giftsAmount)) {
            this.c.setVisibility(8);
            this.b.setVisibility(8);
        } else {
            this.c.setVisibility(0);
            this.b.setVisibility(0);
            this.c.setText(waterFlowRecommendItem.giftsAmount);
        }
        this.d.setVisibility(4);
        this.i.setImageResource(R$drawable.homepage_recommend_coupon_bg);
        this.g.setBackgroundResource(R$drawable.homepage_recommend_coupon_btn_bg);
        this.g.setTextColor(Color.parseColor("#ffffff"));
        this.g.setText("立即领取");
        this.itemView.setTag(waterFlowRecommendItem);
        this.itemView.setOnClickListener(new b());
    }

    private void handleMarktingView(WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-963599722")) {
            ipChange.ipc$dispatch("-963599722", new Object[]{this, waterFlowRecommendItem});
            return;
        }
        this.e.setVisibility(4);
        this.f.setVisibility(4);
        this.c.setVisibility(4);
        this.b.setVisibility(4);
        this.d.setVisibility(4);
        if (this.i.getTag() instanceof vr) {
            ((vr) this.i.getTag()).cancel();
        }
        this.i.setImageDrawable(null);
        DMImageCreator f = cn.damai.common.image.a.b().f(waterFlowRecommendItem.pic, this.j, this.k);
        int i = R$drawable.uikit_default_image_bg_gradient;
        this.i.setTag(f.i(i).c(i).g(this.i));
        if (!wh2.j(waterFlowRecommendItem.buttonText)) {
            this.g.setText(waterFlowRecommendItem.buttonText);
            this.g.setTextColor(nk.a(waterFlowRecommendItem.textColor));
            if (!wh2.j(waterFlowRecommendItem.buttonColor1) && !wh2.j(waterFlowRecommendItem.buttonColor2)) {
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor(waterFlowRecommendItem.buttonColor1), Color.parseColor(waterFlowRecommendItem.buttonColor2)});
                gradientDrawable.setCornerRadius(t60.a(this.a, 15.0f));
                this.g.setBackground(gradientDrawable);
            } else {
                this.g.setBackgroundColor(nk.a(waterFlowRecommendItem.buttonColor1));
            }
            this.g.setVisibility(0);
        } else {
            this.g.setVisibility(4);
        }
        this.itemView.setTag(waterFlowRecommendItem);
        this.itemView.setOnClickListener(new c());
    }

    private void handleVipView(WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-721634306")) {
            ipChange.ipc$dispatch("-721634306", new Object[]{this, waterFlowRecommendItem});
            return;
        }
        if (wh2.j(waterFlowRecommendItem.name)) {
            this.e.setVisibility(4);
        } else {
            this.e.setVisibility(0);
            this.e.setText(waterFlowRecommendItem.name);
        }
        if (wh2.j(waterFlowRecommendItem.desc)) {
            this.f.setVisibility(4);
        } else {
            this.f.setVisibility(0);
            this.f.setText(waterFlowRecommendItem.desc);
        }
        if (wh2.j(waterFlowRecommendItem.price)) {
            this.d.setVisibility(4);
        } else {
            this.d.setVisibility(0);
            TextView textView = this.d;
            textView.setText("原价 ¥ " + waterFlowRecommendItem.price);
            this.d.getPaint().setFlags(16);
        }
        if (wh2.j(waterFlowRecommendItem.priceLow)) {
            this.c.setVisibility(4);
        } else {
            this.c.setVisibility(0);
            this.c.setText(waterFlowRecommendItem.priceLow);
        }
        this.i.setImageDrawable(null);
        this.i.setImageResource(R$drawable.homepage_recommend_vip_bg);
        this.g.setBackgroundResource(R$drawable.homepage_recommend_vip_btn_bg);
        this.g.setText("立即开通");
        this.g.setTextColor(Color.parseColor("#11172D"));
        this.itemView.setTag(waterFlowRecommendItem);
        this.itemView.setOnClickListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void marktingClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "546155333")) {
            ipChange.ipc$dispatch("546155333", new Object[]{this, view});
            return;
        }
        WaterFlowRecommendItem waterFlowRecommendItem = (WaterFlowRecommendItem) view.getTag();
        cn.damai.common.user.c.e().x(py0.I().M(this.h, waterFlowRecommendItem.projectId, waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, "", waterFlowRecommendItem.pageNum, waterFlowRecommendItem.index, waterFlowRecommendItem.title, waterFlowRecommendItem.schema));
        DMNav.from(this.a).toUri(waterFlowRecommendItem.schema);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vipClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1767366349")) {
            ipChange.ipc$dispatch("1767366349", new Object[]{this, view});
            return;
        }
        WaterFlowRecommendItem waterFlowRecommendItem = (WaterFlowRecommendItem) view.getTag();
        cn.damai.common.user.c.e().x(py0.I().M(this.h, waterFlowRecommendItem.projectId, waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, "", waterFlowRecommendItem.pageNum, waterFlowRecommendItem.index, waterFlowRecommendItem.title, waterFlowRecommendItem.schema));
        if (LoginManager.k().q()) {
            DMNav.from(this.a).toUri(VipUrlGetter.vipBuyUrl());
        } else {
            LoginManager.k().v(this.a);
        }
    }

    public void handleView(int i, WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1883640258")) {
            ipChange.ipc$dispatch("-1883640258", new Object[]{this, Integer.valueOf(i), waterFlowRecommendItem});
        } else if (waterFlowRecommendItem == null) {
        } else {
            if (i == 309) {
                handleVipView(waterFlowRecommendItem);
            } else if (i == 301) {
                handleCouponView(waterFlowRecommendItem);
            } else if (i == 302) {
                handleMarktingView(waterFlowRecommendItem);
            }
            py0.I().T(this.itemView, this.h, waterFlowRecommendItem.projectId, waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, "", waterFlowRecommendItem.index);
        }
    }
}
