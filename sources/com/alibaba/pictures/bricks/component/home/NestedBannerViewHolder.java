package com.alibaba.pictures.bricks.component.home;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.NestedBannerBean;
import com.alibaba.pictures.bricks.component.home.NestedBannerViewHolder;
import com.alient.oneservice.image.ImageLoaderProvider;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class NestedBannerViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final View a;
    @NotNull
    private final OnBannerListener b;
    @Nullable
    private NestedBannerBean c;
    private int d;
    private final ImageView e;
    private final ImageView f;
    private final ImageView g;
    private final ImageView h;
    private final TextView i;
    private final TextView j;
    private final TextView k;
    private final View l;
    private final View m;
    private final View n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedBannerViewHolder(@NotNull View view, @NotNull OnBannerListener onBannerListener) {
        super(view);
        b41.i(view, "targetView");
        b41.i(onBannerListener, "listener");
        this.a = view;
        this.b = onBannerListener;
        view.setTag(this);
        view.setOnClickListener(new View.OnClickListener() { // from class: tb.mj1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NestedBannerViewHolder.b(NestedBannerViewHolder.this, view2);
            }
        });
        this.e = (ImageView) view.findViewById(R$id.id_bricks_banner_super_img_bg);
        this.f = (ImageView) view.findViewById(R$id.id_bricks_banner_super_img1);
        this.g = (ImageView) view.findViewById(R$id.id_bricks_banner_super_img2);
        this.h = (ImageView) view.findViewById(R$id.id_bricks_banner_super_img3);
        this.i = (TextView) view.findViewById(R$id.id_bricks_banner_super_text1);
        this.j = (TextView) view.findViewById(R$id.id_bricks_banner_super_text2);
        this.k = (TextView) view.findViewById(R$id.id_bricks_banner_super_text3);
        this.l = view.findViewById(R$id.id_bricks_banner_super_gradient_bg);
        this.m = view.findViewById(R$id.id_bricks_banner_super_color_bg);
        this.n = view.findViewById(R$id.id_bricks_banner_sub_img_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(NestedBannerViewHolder nestedBannerViewHolder, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1273858817")) {
            ipChange.ipc$dispatch("-1273858817", new Object[]{nestedBannerViewHolder, view});
            return;
        }
        b41.i(nestedBannerViewHolder, "this$0");
        NestedBannerBean nestedBannerBean = nestedBannerViewHolder.c;
        if (nestedBannerBean != null) {
            OnBannerListener onBannerListener = nestedBannerViewHolder.b;
            b41.h(view, AdvanceSetting.NETWORK_TYPE);
            onBannerListener.onBannerItemClick(view, nestedBannerBean, nestedBannerViewHolder.d);
        }
    }

    private final void d(String str, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-617352818")) {
            ipChange.ipc$dispatch("-617352818", new Object[]{this, str, imageView});
            return;
        }
        try {
            ImageLoaderProvider proxy = ImageLoaderProviderProxy.getProxy();
            int i = R$drawable.bricks_default_image_bg_gradient;
            proxy.loadinto(str, imageView, i, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void e(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1353544987")) {
            ipChange.ipc$dispatch("-1353544987", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        int i = z ? 0 : 8;
        this.n.setVisibility(i);
        this.m.setVisibility(i);
        this.l.setVisibility(i);
    }

    public final void c(@NotNull NestedBannerBean nestedBannerBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2024435623")) {
            ipChange.ipc$dispatch("-2024435623", new Object[]{this, nestedBannerBean, Integer.valueOf(i)});
            return;
        }
        b41.i(nestedBannerBean, "bean");
        this.c = nestedBannerBean;
        this.d = i;
        if (nestedBannerBean.isSuperFrameBanner()) {
            e(true);
            String str = nestedBannerBean.subPic1;
            ImageView imageView = this.f;
            b41.h(imageView, "img1");
            d(str, imageView);
            String str2 = nestedBannerBean.subPic2;
            ImageView imageView2 = this.g;
            b41.h(imageView2, "img2");
            d(str2, imageView2);
            String str3 = nestedBannerBean.subPic3;
            ImageView imageView3 = this.h;
            b41.h(imageView3, "img3");
            d(str3, imageView3);
            this.i.setText(nestedBannerBean.subPicText1);
            this.j.setText(nestedBannerBean.subPicText2);
            this.k.setText(nestedBannerBean.subPicText3);
            int bgColor = nestedBannerBean.getBgColor();
            this.m.setBackgroundColor(bgColor);
            View view = this.l;
            if (!b41.d(view.getTag(), Integer.valueOf(bgColor)) || !(view.getBackground() instanceof GradientDrawable)) {
                view.setTag(Integer.valueOf(bgColor));
                GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                int[] iArr = {0, bgColor};
                wt2 wt2Var = wt2.INSTANCE;
                view.setBackground(new GradientDrawable(orientation, iArr));
            }
        } else {
            e(false);
        }
        String str4 = nestedBannerBean.picHigh;
        ImageView imageView4 = this.e;
        b41.h(imageView4, "bannerImg");
        d(str4, imageView4);
        NestedBannerBean nestedBannerBean2 = this.c;
        if (nestedBannerBean2 != null) {
            OnBannerListener onBannerListener = this.b;
            ImageView imageView5 = this.e;
            b41.h(imageView5, "bannerImg");
            onBannerListener.onBannerViewExpose(imageView5, nestedBannerBean2, this.d);
        }
    }
}
