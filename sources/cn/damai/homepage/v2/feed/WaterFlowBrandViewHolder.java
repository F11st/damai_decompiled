package cn.damai.homepage.v2.feed;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.taobao.windvane.extra.uc.UCNetworkDelegate;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.blur.ImageBlurHelper;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.util.DMRGBUtil;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.bean.WaterFlowRecommendItem;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import tb.b21;
import tb.cs;
import tb.gi0;
import tb.su0;
import tb.t60;
import tb.ux0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WaterFlowBrandViewHolder extends BaseViewHolder<WaterFlowRecommendItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int imageViewHeight;
    private int imageViewWidth;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private ImageView mVenueBgImage;
    private ImageView mVenueBgShade;
    private TextView mVenueDesc;
    private View mVenueDescBottomDashLine;
    private View mVenueDescTopDashLine;
    private ImageView mVenueHeaderIcon;
    private ImageView mVenueHeaderVIcon;
    private TextView mVenueName;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "437945002")) {
                ipChange.ipc$dispatch("437945002", new Object[]{this, view});
                return;
            }
            WaterFlowRecommendItem waterFlowRecommendItem = (WaterFlowRecommendItem) view.getTag();
            ux0.i().m(ux0.g(WaterFlowBrandViewHolder.this.getComponentActions()), waterFlowRecommendItem.projectId, waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, waterFlowRecommendItem.brandId, WaterFlowBrandViewHolder.this.getData().getIndex());
            Bundle bundle = new Bundle();
            bundle.putString("userId", waterFlowRecommendItem.brandId);
            bundle.putString("usertype", "4");
            DMNav.from(WaterFlowBrandViewHolder.this.mContext).withExtras(bundle).toUri(NavUri.b(cs.Y));
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
            if (AndroidInstantRuntime.support(ipChange, "1555225949")) {
                ipChange.ipc$dispatch("1555225949", new Object[]{this, dVar});
                return;
            }
            WaterFlowBrandViewHolder.this.mVenueBgImage.setImageResource(R$drawable.homepage_waterflow_venues_default_bg);
            WaterFlowBrandViewHolder.this.mVenueBgShade.setImageResource(R$drawable.homepage_waterflow_venues_default_shade);
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
                if (AndroidInstantRuntime.support(ipChange, "443927043")) {
                    ipChange.ipc$dispatch("443927043", new Object[]{this, Integer.valueOf(i)});
                } else {
                    su0.a(WaterFlowBrandViewHolder.this.mVenueBgShade, GradientDrawable.Orientation.LEFT_RIGHT, t60.a(WaterFlowBrandViewHolder.this.mContext, 6.0f), i);
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
                if (AndroidInstantRuntime.support(ipChange, "402568606")) {
                    ipChange.ipc$dispatch("402568606", new Object[]{this, str, bitmap});
                } else {
                    WaterFlowBrandViewHolder.this.mVenueBgImage.setImageBitmap(bitmap);
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
            if (AndroidInstantRuntime.support(ipChange, "-1742695118")) {
                ipChange.ipc$dispatch("-1742695118", new Object[]{this, eVar});
            } else if (eVar == null || (bitmap = eVar.b) == null) {
                WaterFlowBrandViewHolder.this.mVenueBgImage.setImageResource(R$drawable.homepage_waterflow_venues_default_bg);
                WaterFlowBrandViewHolder.this.mVenueBgShade.setImageResource(R$drawable.homepage_waterflow_venues_default_shade);
            } else {
                DMRGBUtil.g(0.7f, bitmap, this.a.backgroundPic, new a());
                b21.c(WaterFlowBrandViewHolder.this.mContext, this.a.backgroundPic, eVar.b, new b());
            }
        }
    }

    public WaterFlowBrandViewHolder(View view) {
        super(view);
        this.mOnClickListener = new a();
        this.mContext = view.getContext();
        this.mVenueBgImage = (ImageView) this.itemView.findViewById(R$id.homepage_waterflow_venues_image);
        this.mVenueBgShade = (ImageView) this.itemView.findViewById(R$id.homepage_waterflow_venues_shade);
        this.mVenueHeaderIcon = (ImageView) this.itemView.findViewById(R$id.homepage_waterflow_venues_header_icon);
        this.mVenueHeaderVIcon = (ImageView) this.itemView.findViewById(R$id.homepage_waterflow_venues_header_v_icon);
        this.mVenueName = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_venues_name);
        View findViewById = this.itemView.findViewById(R$id.homepage_waterflow_venues_desc_top_dash);
        this.mVenueDescTopDashLine = findViewById;
        findViewById.setLayerType(1, null);
        this.mVenueDesc = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_venues_desc);
        View findViewById2 = this.itemView.findViewById(R$id.homepage_waterflow_venues_desc_bottom_dash);
        this.mVenueDescBottomDashLine = findViewById2;
        findViewById2.setLayerType(1, null);
        this.itemView.setOnClickListener(this.mOnClickListener);
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NonNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2136904435")) {
            ipChange.ipc$dispatch("-2136904435", new Object[]{this, iItem});
            return;
        }
        int a2 = gi0.INSTANCE.a(this.itemView.getContext());
        this.imageViewWidth = a2;
        int i = (int) (((a2 * UCNetworkDelegate.CHANGE_WEBVIEW_URL) * 1.0f) / 168.0f);
        this.imageViewHeight = i;
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, i + t60.a(this.mContext, 12.0f)));
        handleView(getValue());
    }

    public void handleView(WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1346834047")) {
            ipChange.ipc$dispatch("1346834047", new Object[]{this, waterFlowRecommendItem});
        } else if (waterFlowRecommendItem == null) {
        } else {
            cn.damai.common.image.a.b().f(waterFlowRecommendItem.backgroundPic, this.imageViewWidth, this.imageViewHeight).n(new c(waterFlowRecommendItem)).e(new b()).f();
            DMImageCreator f = cn.damai.common.image.a.b().f(waterFlowRecommendItem.pic, t60.a(this.mContext, 50.0f), t60.a(this.mContext, 50.0f));
            int i = R$drawable.uikit_user_default_icon_trans_white;
            f.i(i).c(i).g(this.mVenueHeaderIcon);
            this.mVenueName.setText(waterFlowRecommendItem.title);
            this.mVenueDesc.setText(waterFlowRecommendItem.subTitle);
            if (TextUtils.isEmpty(waterFlowRecommendItem.subTitle)) {
                this.mVenueDescTopDashLine.setVisibility(8);
                this.mVenueDescBottomDashLine.setVisibility(8);
            } else {
                this.mVenueDescTopDashLine.setVisibility(0);
                this.mVenueDescBottomDashLine.setVisibility(0);
            }
            this.itemView.setTag(waterFlowRecommendItem);
            ux0.i().k(ux0.g(getComponentActions()), this.itemView, waterFlowRecommendItem.projectId, waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, waterFlowRecommendItem.brandId, getData().getIndex());
        }
    }
}
