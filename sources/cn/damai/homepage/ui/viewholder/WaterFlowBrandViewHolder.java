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
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.blur.ImageBlurHelper;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
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
    /* loaded from: classes14.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1466371759")) {
                ipChange.ipc$dispatch("1466371759", new Object[]{this, view});
                return;
            }
            WaterFlowRecommendItem waterFlowRecommendItem = (WaterFlowRecommendItem) view.getTag();
            cn.damai.common.user.c e = cn.damai.common.user.c.e();
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
    /* loaded from: classes5.dex */
    public class b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1870979042")) {
                ipChange.ipc$dispatch("1870979042", new Object[]{this, dVar});
                return;
            }
            WaterFlowBrandViewHolder.this.c.setImageResource(R$drawable.homepage_waterflow_venues_default_bg);
            WaterFlowBrandViewHolder.this.d.setImageResource(R$drawable.homepage_waterflow_venues_default_shade);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ WaterFlowRecommendItem a;

        /* compiled from: Taobao */
        /* loaded from: classes5.dex */
        public class a implements DMRGBUtil.OnFetchColorListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
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
        /* loaded from: classes5.dex */
        public class b implements ImageBlurHelper.BlurImageCallback {
            private static transient /* synthetic */ IpChange $ipChange;

            b() {
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

        c(WaterFlowRecommendItem waterFlowRecommendItem) {
            this.a = waterFlowRecommendItem;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "226877431")) {
                ipChange.ipc$dispatch("226877431", new Object[]{this, eVar});
            } else if (eVar == null || (bitmap = eVar.b) == null) {
                WaterFlowBrandViewHolder.this.c.setImageResource(R$drawable.homepage_waterflow_venues_default_bg);
                WaterFlowBrandViewHolder.this.d.setImageResource(R$drawable.homepage_waterflow_venues_default_shade);
            } else {
                DMRGBUtil.g(0.7f, bitmap, this.a.backgroundPic, new a());
                b21.c(WaterFlowBrandViewHolder.this.a, this.a.backgroundPic, eVar.b, new b());
            }
        }
    }

    public WaterFlowBrandViewHolder(String str, Context context) {
        super(LayoutInflater.from(context).inflate(R$layout.homepage_waterflow_recommend_venues, (ViewGroup) null));
        this.l = new a();
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
        int a2 = ((DisplayMetrics.getwidthPixels(t60.b(context)) - t60.a(context, 30.0f)) / 2) - t60.a(context, 12.0f);
        this.j = a2;
        this.k = (int) (((a2 * UCNetworkDelegate.CHANGE_WEBVIEW_URL) * 1.0f) / 168.0f);
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
            cn.damai.common.image.a.b().f(waterFlowRecommendItem.backgroundPic, this.j, this.k).n(new c(waterFlowRecommendItem)).e(new b()).f();
            DMImageCreator f = cn.damai.common.image.a.b().f(waterFlowRecommendItem.pic, t60.a(this.a, 50.0f), t60.a(this.a, 50.0f));
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
