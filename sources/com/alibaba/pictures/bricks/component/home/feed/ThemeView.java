package com.alibaba.pictures.bricks.component.home.feed;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.ThemeBean;
import com.alibaba.pictures.bricks.component.home.feed.ThemeContract;
import com.alibaba.pictures.bricks.onearch.AbsView;
import com.alibaba.pictures.bricks.view.BricksStrokeLinearLayout;
import com.alibaba.pictures.bricks.view.HWRatioLayout;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.e91;
import tb.gh2;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ThemeView extends AbsView<GenericItem<ItemValue>, ThemeModel, ThemePresent> implements ThemeContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private int cornerRadius;
    private int highLightPadding;
    private int highLightStrokeWidth;
    @NotNull
    private final View itemView;
    @NotNull
    private final View mBottomBgUi;
    @NotNull
    private final View mBottomUi;
    @NotNull
    private final int[] mColors;
    @NotNull
    private final HWRatioLayout mHwRatioLayout;
    @NotNull
    private final ImageView mPic;
    @NotNull
    private final View mPriceTag;
    @NotNull
    private final BricksStrokeLinearLayout mStrokeLinearLayout;
    @NotNull
    private final TextView mTitle;
    @NotNull
    private final View mTopShader;
    @NotNull
    private final View mVideoIcon;
    @NotNull
    private final TextView mWatch;
    @Nullable
    private ThemeBean temp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThemeView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.itemView = view;
        View findViewById = view.findViewById(R$id.theme_img_hw_ratio_layout);
        b41.h(findViewById, "itemView.findViewById(R.…heme_img_hw_ratio_layout)");
        this.mHwRatioLayout = (HWRatioLayout) findViewById;
        View findViewById2 = view.findViewById(R$id.theme_img);
        b41.h(findViewById2, "itemView.findViewById(R.id.theme_img)");
        this.mPic = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R$id.theme_title);
        b41.h(findViewById3, "itemView.findViewById(R.id.theme_title)");
        this.mTitle = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R$id.theme_watch_info);
        b41.h(findViewById4, "itemView.findViewById(R.id.theme_watch_info)");
        this.mWatch = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R$id.theme_price_tag);
        b41.h(findViewById5, "itemView.findViewById(R.id.theme_price_tag)");
        this.mPriceTag = findViewById5;
        View findViewById6 = view.findViewById(R$id.bottom_top_shader);
        b41.h(findViewById6, "itemView.findViewById(R.id.bottom_top_shader)");
        this.mTopShader = findViewById6;
        View findViewById7 = view.findViewById(R$id.bottom_end_layout);
        b41.h(findViewById7, "itemView.findViewById(R.id.bottom_end_layout)");
        this.mBottomUi = findViewById7;
        View findViewById8 = view.findViewById(R$id.bottom_bg_layout);
        b41.h(findViewById8, "itemView.findViewById(R.id.bottom_bg_layout)");
        this.mBottomBgUi = findViewById8;
        View findViewById9 = view.findViewById(R$id.video_icon);
        b41.h(findViewById9, "itemView.findViewById(R.id.video_icon)");
        this.mVideoIcon = findViewById9;
        View findViewById10 = view.findViewById(R$id.theme_img_hw_stroke_layout);
        b41.h(findViewById10, "itemView.findViewById(R.…eme_img_hw_stroke_layout)");
        this.mStrokeLinearLayout = (BricksStrokeLinearLayout) findViewById10;
        this.mColors = new int[]{Color.parseColor("#00000000"), Color.parseColor("#0a000000"), Color.parseColor("#1c000000"), Color.parseColor("#35000000"), Color.parseColor("#54000000"), Color.parseColor("#75000000"), Color.parseColor("#99000000"), Color.parseColor("#bc000000"), Color.parseColor("#dd000000"), Color.parseColor("#ff000000")};
    }

    private final Drawable newLinearGDrawable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "367343110")) {
            return (Drawable) ipChange.ipc$dispatch("367343110", new Object[]{this});
        }
        e91 e91Var = new e91();
        e91Var.b(this.mColors, null);
        return e91Var;
    }

    @Override // com.alibaba.pictures.bricks.component.home.feed.ThemeContract.View
    public void bindView(@NotNull ThemeBean themeBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-162969949")) {
            ipChange.ipc$dispatch("-162969949", new Object[]{this, themeBean});
            return;
        }
        b41.i(themeBean, "bean");
        s60 s60Var = s60.INSTANCE;
        Application application = AppInfoProviderProxy.getApplication();
        b41.h(application, "getApplication()");
        this.cornerRadius = s60Var.b(application, 6);
        Application application2 = AppInfoProviderProxy.getApplication();
        b41.h(application2, "getApplication()");
        this.highLightPadding = s60Var.b(application2, 3);
        Application application3 = AppInfoProviderProxy.getApplication();
        b41.h(application3, "getApplication()");
        this.highLightStrokeWidth = s60Var.b(application3, 3);
        this.temp = themeBean;
        b41.f(themeBean);
        if (themeBean.hwRatio > 0.0f) {
            HWRatioLayout hWRatioLayout = this.mHwRatioLayout;
            ThemeBean themeBean2 = this.temp;
            b41.f(themeBean2);
            hWRatioLayout.setHwRatio(themeBean2.hwRatio);
        } else {
            this.mHwRatioLayout.setHwRatio(1.0f);
        }
        this.itemView.setTag(this.temp);
        ThemeBean themeBean3 = this.temp;
        b41.f(themeBean3);
        if (themeBean3.highLight) {
            this.mTopShader.setBackground(null);
            this.mBottomBgUi.setBackgroundResource(R$drawable.bricks_icon_theme_bg);
            this.mBottomUi.setBackgroundColor(0);
            BricksStrokeLinearLayout bricksStrokeLinearLayout = this.mStrokeLinearLayout;
            int i = this.highLightPadding;
            bricksStrokeLinearLayout.setPadding(i, i, i, i);
            this.mStrokeLinearLayout.setCornerAndStroke(this.cornerRadius, this.highLightStrokeWidth, new int[]{Color.parseColor("#FF4E6E"), Color.parseColor("#FF833C")});
        } else {
            this.mTopShader.setBackground(newLinearGDrawable());
            this.mBottomBgUi.setBackground(null);
            this.mBottomUi.setBackgroundColor(-16777216);
            this.mStrokeLinearLayout.setPadding(0, 0, 0, 0);
            this.mStrokeLinearLayout.setCornerAndStroke(this.cornerRadius, 1, Color.parseColor("#26000000"));
        }
        ThemeBean themeBean4 = this.temp;
        b41.f(themeBean4);
        this.mVideoIcon.setVisibility(themeBean4.isShowVideoIcon() ? 0 : 8);
        ThemeBean themeBean5 = this.temp;
        b41.f(themeBean5);
        String str = themeBean5.pic;
        ImageView imageView = this.mPic;
        int i2 = R$drawable.bricks_uikit_default_image_bg_gradient_v2;
        ImageLoaderProviderProxy.loadinto(str, imageView, i2, i2);
        Context context = this.itemView.getContext();
        if (context == null) {
            TextView textView = this.mTitle;
            ThemeBean themeBean6 = this.temp;
            b41.f(themeBean6);
            textView.setText(themeBean6.name);
        } else {
            int i3 = R$drawable.bricks_icon_theme_title_prefix;
            ThemeBean themeBean7 = this.temp;
            b41.f(themeBean7);
            SpannableStringBuilder b = gh2.b(context, i3, themeBean7.name);
            b41.h(b, "insetImgSpan(context, R.…itle_prefix, temp!!.name)");
            this.mTitle.setText(b);
        }
        ThemeBean themeBean8 = this.temp;
        b41.f(themeBean8);
        String str2 = themeBean8.contentCount;
        ThemeBean themeBean9 = this.temp;
        b41.f(themeBean9);
        String a = gh2.a(str2, themeBean9.ipvuv);
        b41.h(a, "contentCountConcatIpUv(t…ntentCount, temp!!.ipvuv)");
        this.mWatch.setTextColor(Color.parseColor("#99FFFFFF"));
        this.mWatch.setText(a);
        View view = this.mPriceTag;
        ThemeBean themeBean10 = this.temp;
        b41.f(themeBean10);
        view.setVisibility(themeBean10.hasPrize() ? 0 : 8);
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1386693750") ? (View) ipChange.ipc$dispatch("-1386693750", new Object[]{this}) : this.itemView;
    }

    @Nullable
    public final ThemeBean getTemp() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1037516347") ? (ThemeBean) ipChange.ipc$dispatch("1037516347", new Object[]{this}) : this.temp;
    }

    public final void setTemp(@Nullable ThemeBean themeBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1861661711")) {
            ipChange.ipc$dispatch("-1861661711", new Object[]{this, themeBean});
        } else {
            this.temp = themeBean;
        }
    }
}
