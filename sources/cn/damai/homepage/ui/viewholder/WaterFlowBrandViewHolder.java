package cn.damai.homepage.ui.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.taobao.windvane.extra.uc.UCNetworkDelegate;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.blur.ImageBlurHelper;
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
import tb.b21;
import tb.cs;
import tb.py0;
import tb.su0;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WaterFlowBrandViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private String b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private TextView f;
    private View g;
    private TextView h;
    private View i;
    private int j;
    private int k;
    private View.OnClickListener l;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.ui.viewholder.WaterFlowBrandViewHolder$a */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC1186a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1186a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1466371759")) {
                ipChange.ipc$dispatch("1466371759", new Object[]{this, view});
                return;
            }
            WaterFlowRecommendItem waterFlowRecommendItem = (WaterFlowRecommendItem) view.getTag();
            C0529c e = C0529c.e();
            py0 I = py0.I();
            String str = WaterFlowBrandViewHolder.this.b;
            String str2 = waterFlowRecommendItem.title;
            String str3 = waterFlowRecommendItem.schema;
            String str4 = waterFlowRecommendItem.projectId;
            String str5 = waterFlowRecommendItem.alg;
            String str6 = waterFlowRecommendItem.scm;
            String str7 = waterFlowRecommendItem.cardType;
            String str8 = waterFlowRecommendItem.brandId;
            e.x(I.O(str, str2, str3, str4, str5, str6, str7, str8, str8, "", waterFlowRecommendItem.pageNum, waterFlowRecommendItem.index));
            Bundle bundle = new Bundle();
            bundle.putString("userId", waterFlowRecommendItem.brandId);
            bundle.putString("usertype", "4");
            DMNav.from(WaterFlowBrandViewHolder.this.a).withExtras(bundle).toUri(NavUri.b(cs.Y));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.ui.viewholder.WaterFlowBrandViewHolder$b */
    /* loaded from: classes5.dex */
    public class C1187b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1187b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1870979042")) {
                ipChange.ipc$dispatch("1870979042", new Object[]{this, c0501d});
                return;
            }
            WaterFlowBrandViewHolder.this.c.setImageResource(R$drawable.homepage_waterflow_venues_default_bg);
            WaterFlowBrandViewHolder.this.d.setImageResource(R$drawable.homepage_waterflow_venues_default_shade);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.ui.viewholder.WaterFlowBrandViewHolder$c */
    /* loaded from: classes5.dex */
    public class C1188c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ WaterFlowRecommendItem a;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.homepage.ui.viewholder.WaterFlowBrandViewHolder$c$a */
        /* loaded from: classes5.dex */
        public class C1189a implements DMRGBUtil.OnFetchColorListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C1189a() {
            }

            @Override // cn.damai.commonbusiness.util.DMRGBUtil.OnFetchColorListener
            public void onFetchColor(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "635997982")) {
                    ipChange.ipc$dispatch("635997982", new Object[]{this, Integer.valueOf(i)});
                } else {
                    su0.a(WaterFlowBrandViewHolder.this.d, GradientDrawable.Orientation.LEFT_RIGHT, t60.a(WaterFlowBrandViewHolder.this.a, 6.0f), i);
                }
            }
        }

        /* compiled from: Taobao */
        /* renamed from: cn.damai.homepage.ui.viewholder.WaterFlowBrandViewHolder$c$b */
        /* loaded from: classes5.dex */
        public class C1190b implements ImageBlurHelper.BlurImageCallback {
            private static transient /* synthetic */ IpChange $ipChange;

            C1190b() {
            }

            @Override // cn.damai.common.image.blur.ImageBlurHelper.BlurImageCallback
            public void onBlurResult(String str, Bitmap bitmap) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1024583929")) {
                    ipChange.ipc$dispatch("1024583929", new Object[]{this, str, bitmap});
                } else {
                    WaterFlowBrandViewHolder.this.c.setImageBitmap(bitmap);
                }
            }
        }

        C1188c(WaterFlowRecommendItem waterFlowRecommendItem) {
            this.a = waterFlowRecommendItem;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "226877431")) {
                ipChange.ipc$dispatch("226877431", new Object[]{this, c0502e});
            } else if (c0502e == null || (bitmap = c0502e.b) == null) {
                WaterFlowBrandViewHolder.this.c.setImageResource(R$drawable.homepage_waterflow_venues_default_bg);
                WaterFlowBrandViewHolder.this.d.setImageResource(R$drawable.homepage_waterflow_venues_default_shade);
            } else {
                DMRGBUtil.g(0.7f, bitmap, this.a.backgroundPic, new C1189a());
                b21.c(WaterFlowBrandViewHolder.this.a, this.a.backgroundPic, c0502e.b, new C1190b());
            }
        }
    }

    public WaterFlowBrandViewHolder(String str, Context context) {
        super(LayoutInflater.from(context).inflate(R$layout.homepage_waterflow_recommend_venues, (ViewGroup) null));
        this.l = new View$OnClickListenerC1186a();
        this.b = str;
        this.a = context;
        this.c = (ImageView) this.itemView.findViewById(R$id.homepage_waterflow_venues_image);
        this.d = (ImageView) this.itemView.findViewById(R$id.homepage_waterflow_venues_shade);
        this.e = (ImageView) this.itemView.findViewById(R$id.homepage_waterflow_venues_header_icon);
        ImageView imageView = (ImageView) this.itemView.findViewById(R$id.homepage_waterflow_venues_header_v_icon);
        this.f = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_venues_name);
        View findViewById = this.itemView.findViewById(R$id.homepage_waterflow_venues_desc_top_dash);
        this.g = findViewById;
        findViewById.setLayerType(1, null);
        this.h = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_venues_desc);
        View findViewById2 = this.itemView.findViewById(R$id.homepage_waterflow_venues_desc_bottom_dash);
        this.i = findViewById2;
        findViewById2.setLayerType(1, null);
        int a = ((DisplayMetrics.getwidthPixels(t60.b(context)) - t60.a(context, 30.0f)) / 2) - t60.a(context, 12.0f);
        this.j = a;
        this.k = (int) (((a * UCNetworkDelegate.CHANGE_WEBVIEW_URL) * 1.0f) / 168.0f);
        new FrameLayout.LayoutParams(this.j, this.k);
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, this.k + t60.a(context, 12.0f)));
        this.itemView.setOnClickListener(this.l);
    }

    public void handleView(WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1749721958")) {
            ipChange.ipc$dispatch("-1749721958", new Object[]{this, waterFlowRecommendItem});
        } else if (waterFlowRecommendItem == null) {
        } else {
            C0504a.b().f(waterFlowRecommendItem.backgroundPic, this.j, this.k).n(new C1188c(waterFlowRecommendItem)).e(new C1187b()).f();
            DMImageCreator f = C0504a.b().f(waterFlowRecommendItem.pic, t60.a(this.a, 50.0f), t60.a(this.a, 50.0f));
            int i = R$drawable.uikit_user_default_icon_trans_white;
            f.i(i).c(i).g(this.e);
            this.f.setText(waterFlowRecommendItem.title);
            this.h.setText(waterFlowRecommendItem.subTitle);
            if (TextUtils.isEmpty(waterFlowRecommendItem.subTitle)) {
                this.g.setVisibility(8);
                this.i.setVisibility(8);
            } else {
                this.g.setVisibility(0);
                this.i.setVisibility(0);
            }
            this.itemView.setTag(waterFlowRecommendItem);
            py0 I = py0.I();
            View view = this.itemView;
            String str = this.b;
            String str2 = waterFlowRecommendItem.projectId;
            String str3 = waterFlowRecommendItem.alg;
            String str4 = waterFlowRecommendItem.scm;
            String str5 = waterFlowRecommendItem.cardType;
            String str6 = waterFlowRecommendItem.brandId;
            I.U(view, str, str2, str3, str4, str5, str6, str6, "", waterFlowRecommendItem.index, "", "");
        }
    }
}
