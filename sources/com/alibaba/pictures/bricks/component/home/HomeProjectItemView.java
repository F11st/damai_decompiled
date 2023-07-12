package com.alibaba.pictures.bricks.component.home;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.HomeProjectItemBean;
import com.alibaba.pictures.bricks.bean.HomeProjectItemBottomLeft;
import com.alibaba.pictures.bricks.bean.HomepageMarketTagBean;
import com.alibaba.pictures.bricks.component.home.HomeProjectItemContract;
import com.alibaba.pictures.bricks.component.home.HomeProjectItemView;
import com.alibaba.pictures.bricks.onearch.AbsView;
import com.alibaba.pictures.bricks.util.C3550a;
import com.alibaba.pictures.bricks.view.DMCategroyTagView;
import com.alibaba.pictures.bricks.view.DMDigitTextView;
import com.alibaba.pictures.bricks.view.RoundImageView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.ImageTicket;
import com.alient.oneservice.image.SuccessEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.s60;
import tb.vh2;
import tb.yz0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HomeProjectItemView extends AbsView<GenericItem<ItemValue>, HomeProjectItemModel, HomeProjectItemPresent> implements HomeProjectItemContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final View itemView;
    @Nullable
    private RoundImageView mItemImage;
    @Nullable
    private View mItemImageCover;
    @Nullable
    private DMDigitTextView mItemPrice;
    @Nullable
    private LinearLayout mItemPriceLayout;
    @Nullable
    private TextView mItemPriceUnknown;
    @Nullable
    private TextView mItemSubTitle;
    @Nullable
    private TextView mItemTagBottomLeft;
    @Nullable
    private DMCategroyTagView mItemTagTopRight;
    @Nullable
    private TextView mItemTitle;
    @Nullable
    private TextView mWantSeeBtn;
    @Nullable
    private FrameLayout tagsParent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeProjectItemView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.itemView = view;
        this.mItemImage = (RoundImageView) getItemView().findViewById(R$id.homepage_item_image_normal);
        this.mItemImageCover = getItemView().findViewById(R$id.homepage_item_image_normal_cover);
        this.mItemTitle = (TextView) getItemView().findViewById(R$id.homepage_project_item_title);
        this.mItemSubTitle = (TextView) getItemView().findViewById(R$id.homepage_item_subinfo);
        this.mItemPrice = (DMDigitTextView) getItemView().findViewById(R$id.homepage_item_price);
        this.mItemPriceUnknown = (TextView) getItemView().findViewById(R$id.homepage_item_price_unknown);
        this.mItemPriceLayout = (LinearLayout) getItemView().findViewById(R$id.homepage_item_price_layout);
        this.mItemTagTopRight = (DMCategroyTagView) getItemView().findViewById(R$id.homepage_item_image_tag);
        this.mItemTagBottomLeft = (TextView) getItemView().findViewById(R$id.homepage_item_bottom_left);
        this.tagsParent = (FrameLayout) getItemView().findViewById(R$id.homepage_item_tag_view);
        this.mWantSeeBtn = (TextView) getItemView().findViewById(R$id.tv_want_see_btn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-0  reason: not valid java name */
    public static final void m118bindView$lambda0(HomeProjectItemView homeProjectItemView, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1513739744")) {
            ipChange.ipc$dispatch("1513739744", new Object[]{homeProjectItemView, successEvent});
            return;
        }
        b41.i(homeProjectItemView, "this$0");
        if ((successEvent != null ? successEvent.drawable : null) != null) {
            RoundImageView roundImageView = homeProjectItemView.mItemImage;
            if (roundImageView != null) {
                roundImageView.setImageDrawable(successEvent.drawable);
                return;
            }
            return;
        }
        RoundImageView roundImageView2 = homeProjectItemView.mItemImage;
        if (roundImageView2 != null) {
            roundImageView2.setImageResource(R$drawable.bricks_uikit_default_image_bg_gradient);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-1  reason: not valid java name */
    public static final void m119bindView$lambda1(HomeProjectItemView homeProjectItemView, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1694814850")) {
            ipChange.ipc$dispatch("-1694814850", new Object[]{homeProjectItemView, failEvent});
            return;
        }
        b41.i(homeProjectItemView, "this$0");
        RoundImageView roundImageView = homeProjectItemView.mItemImage;
        if (roundImageView != null) {
            roundImageView.setImageResource(R$drawable.bricks_uikit_default_image_bg_gradient);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.home.HomeProjectItemContract.View
    public void bindView(@NotNull HomeProjectItemBean homeProjectItemBean) {
        String z;
        String z2;
        String z3;
        FrameLayout frameLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1425851976")) {
            ipChange.ipc$dispatch("-1425851976", new Object[]{this, homeProjectItemBean});
            return;
        }
        b41.i(homeProjectItemBean, "bean");
        RoundImageView roundImageView = this.mItemImage;
        if ((roundImageView != null ? roundImageView.getTag() : null) instanceof ImageTicket) {
            RoundImageView roundImageView2 = this.mItemImage;
            Object tag = roundImageView2 != null ? roundImageView2.getTag() : null;
            b41.g(tag, "null cannot be cast to non-null type com.alient.oneservice.image.ImageTicket");
            ((ImageTicket) tag).cancel();
        }
        if (!TextUtils.isEmpty(homeProjectItemBean.verticalPic)) {
            String str = homeProjectItemBean.verticalPic;
            s60 s60Var = s60.INSTANCE;
            Context context = getItemView().getContext();
            b41.h(context, "itemView.context");
            int b = s60Var.b(context, 98);
            Context context2 = getItemView().getContext();
            b41.h(context2, "itemView.context");
            String c = C3550a.c(str, b, s60Var.b(context2, 131));
            b41.h(c, "getImageUrl(\n           …x(itemView.context, 131))");
            ImageTicket load = ImageLoaderProviderProxy.getProxy().load(c, R$drawable.bricks_uikit_default_image_bg_gradient, new IImageSuccListener() { // from class: tb.vy0
                @Override // com.alient.oneservice.image.IImageSuccListener
                public final void onSuccess(SuccessEvent successEvent) {
                    HomeProjectItemView.m118bindView$lambda0(HomeProjectItemView.this, successEvent);
                }
            }, new IImageFailListener() { // from class: tb.uy0
                @Override // com.alient.oneservice.image.IImageFailListener
                public final void onFail(FailEvent failEvent) {
                    HomeProjectItemView.m119bindView$lambda1(HomeProjectItemView.this, failEvent);
                }
            });
            b41.h(load, "getProxy()\n             …      }\n                )");
            RoundImageView roundImageView3 = this.mItemImage;
            if (roundImageView3 != null) {
                roundImageView3.setTag(load);
            }
        }
        TextView textView = this.mItemTitle;
        if (textView != null) {
            textView.setText(homeProjectItemBean.name);
        }
        if (getSubTitleVisibility()) {
            TextView textView2 = this.mItemSubTitle;
            if (textView2 != null) {
                if (TextUtils.isEmpty(homeProjectItemBean.interestInfo)) {
                    textView2.setVisibility(4);
                } else {
                    textView2.setVisibility(0);
                    textView2.setText(homeProjectItemBean.interestInfo);
                }
            }
        } else {
            TextView textView3 = this.mItemSubTitle;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        }
        if (getPriceVisibility()) {
            LinearLayout linearLayout = this.mItemPriceLayout;
            if (linearLayout != null) {
                linearLayout.setVisibility(4);
            }
            TextView textView4 = this.mItemPriceUnknown;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            if (!TextUtils.isEmpty(homeProjectItemBean.priceLow) && !homeProjectItemBean.priceLow.equals("价格待定") && !homeProjectItemBean.priceLow.equals("待定")) {
                DMDigitTextView dMDigitTextView = this.mItemPrice;
                if (dMDigitTextView != null) {
                    dMDigitTextView.setText(homeProjectItemBean.priceLow);
                }
                LinearLayout linearLayout2 = this.mItemPriceLayout;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                TextView textView5 = this.mItemPriceUnknown;
                if (textView5 != null) {
                    textView5.setVisibility(8);
                }
            } else {
                LinearLayout linearLayout3 = this.mItemPriceLayout;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                }
                TextView textView6 = this.mItemPriceUnknown;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                }
            }
            if (homeProjectItemBean.gotTopTag() != null) {
                HomepageMarketTagBean gotTopTag = homeProjectItemBean.gotTopTag();
                if (!TextUtils.isEmpty(gotTopTag.shortTag) && (frameLayout = this.tagsParent) != null) {
                    if (frameLayout != null) {
                        frameLayout.setVisibility(0);
                    }
                    FrameLayout frameLayout2 = this.tagsParent;
                    if (frameLayout2 != null) {
                        frameLayout2.removeAllViews();
                    }
                    gotTopTag.addMarketTagView(this.tagsParent, true, true).setHasPandding(false);
                }
            } else {
                FrameLayout frameLayout3 = this.tagsParent;
                if (frameLayout3 != null) {
                    frameLayout3.removeAllViews();
                }
                FrameLayout frameLayout4 = this.tagsParent;
                if (frameLayout4 != null) {
                    frameLayout4.setVisibility(0);
                }
            }
        } else {
            LinearLayout linearLayout4 = this.mItemPriceLayout;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(8);
            }
            TextView textView7 = this.mItemPriceUnknown;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
        }
        DMCategroyTagView dMCategroyTagView = this.mItemTagTopRight;
        if (dMCategroyTagView != null) {
            dMCategroyTagView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(homeProjectItemBean.topRight)) {
            DMCategroyTagView dMCategroyTagView2 = this.mItemTagTopRight;
            if (dMCategroyTagView2 != null) {
                dMCategroyTagView2.setVisibility(0);
            }
            DMCategroyTagView dMCategroyTagView3 = this.mItemTagTopRight;
            if (dMCategroyTagView3 != null) {
                dMCategroyTagView3.setTagName(homeProjectItemBean.topRight);
            }
        }
        TextView textView8 = this.mItemTagBottomLeft;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        View view = this.mItemImageCover;
        if (view != null) {
            view.setVisibility(8);
        }
        HomeProjectItemBottomLeft homeProjectItemBottomLeft = homeProjectItemBean.bottomLeft;
        if (homeProjectItemBottomLeft != null && !TextUtils.isEmpty(homeProjectItemBottomLeft.value)) {
            TextView textView9 = this.mItemTagBottomLeft;
            if (textView9 != null) {
                textView9.setVisibility(0);
            }
            View view2 = this.mItemImageCover;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            if (homeProjectItemBottomLeft.isFormatAble()) {
                String str2 = homeProjectItemBottomLeft.value;
                b41.h(str2, "this.value");
                z2 = C8604o.z(str2, "<b>", "</dmtag><dmtag size=\"12\">", false, 4, null);
                z3 = C8604o.z(z2, "</b>", "</dmtag><dmtag size=\"10\">", false, 4, null);
                String str3 = "<dmtag size=\"10\">" + z3 + "</dmtag>";
                TextView textView10 = this.mItemTagBottomLeft;
                if (textView10 != null) {
                    textView10.setText(Html.fromHtml(str3, null, new yz0("dmtag", getItemView().getContext())));
                }
            } else {
                vh2 vh2Var = vh2.INSTANCE;
                String str4 = homeProjectItemBottomLeft.value;
                b41.h(str4, "this.value");
                String a = vh2Var.a(str4);
                String str5 = homeProjectItemBottomLeft.value;
                if (!TextUtils.isEmpty(a)) {
                    if (a != null) {
                        String str6 = homeProjectItemBottomLeft.value;
                        b41.h(str6, "this.value");
                        z = C8604o.z(str6, a, "</dmtag><dmtag size=\"12\">" + a + "</dmtag></dmtag><dmtag size=\"10\">", false, 4, null);
                        str5 = z;
                    } else {
                        str5 = null;
                    }
                }
                String str7 = "<dmtag size=\"10\">" + str5 + "</dmtag>";
                TextView textView11 = this.mItemTagBottomLeft;
                if (textView11 != null) {
                    textView11.setText(Html.fromHtml(str7, null, new yz0("dmtag", getItemView().getContext())));
                }
            }
        }
        if (getWantSeeVisibility()) {
            updateWantSeeBtn(homeProjectItemBean.followState());
            return;
        }
        TextView textView12 = this.mWantSeeBtn;
        if (textView12 == null) {
            return;
        }
        textView12.setVisibility(8);
    }

    @NotNull
    public View getItemView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-360423887") ? (View) ipChange.ipc$dispatch("-360423887", new Object[]{this}) : this.itemView;
    }

    @Nullable
    public final RoundImageView getMItemImage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "101264677") ? (RoundImageView) ipChange.ipc$dispatch("101264677", new Object[]{this}) : this.mItemImage;
    }

    @Nullable
    public final View getMItemImageCover() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-264783287") ? (View) ipChange.ipc$dispatch("-264783287", new Object[]{this}) : this.mItemImageCover;
    }

    @Nullable
    public final DMDigitTextView getMItemPrice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1426386889") ? (DMDigitTextView) ipChange.ipc$dispatch("-1426386889", new Object[]{this}) : this.mItemPrice;
    }

    @Nullable
    public final LinearLayout getMItemPriceLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1330821397") ? (LinearLayout) ipChange.ipc$dispatch("-1330821397", new Object[]{this}) : this.mItemPriceLayout;
    }

    @Nullable
    public final TextView getMItemPriceUnknown() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-868982026") ? (TextView) ipChange.ipc$dispatch("-868982026", new Object[]{this}) : this.mItemPriceUnknown;
    }

    @Nullable
    public final TextView getMItemSubTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1859494495") ? (TextView) ipChange.ipc$dispatch("1859494495", new Object[]{this}) : this.mItemSubTitle;
    }

    @Nullable
    public final TextView getMItemTagBottomLeft() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-949642833") ? (TextView) ipChange.ipc$dispatch("-949642833", new Object[]{this}) : this.mItemTagBottomLeft;
    }

    @Nullable
    public final DMCategroyTagView getMItemTagTopRight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1950898067") ? (DMCategroyTagView) ipChange.ipc$dispatch("1950898067", new Object[]{this}) : this.mItemTagTopRight;
    }

    @Nullable
    public final TextView getMItemTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-422945309") ? (TextView) ipChange.ipc$dispatch("-422945309", new Object[]{this}) : this.mItemTitle;
    }

    @Nullable
    public final TextView getMWantSeeBtn() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "728897233") ? (TextView) ipChange.ipc$dispatch("728897233", new Object[]{this}) : this.mWantSeeBtn;
    }

    public boolean getPriceVisibility() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-279749492")) {
            return ((Boolean) ipChange.ipc$dispatch("-279749492", new Object[]{this})).booleanValue();
        }
        return true;
    }

    public boolean getSubTitleVisibility() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1755135777")) {
            return ((Boolean) ipChange.ipc$dispatch("1755135777", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Nullable
    public final FrameLayout getTagsParent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "114000085") ? (FrameLayout) ipChange.ipc$dispatch("114000085", new Object[]{this}) : this.tagsParent;
    }

    public boolean getWantSeeVisibility() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2093839474")) {
            return ((Boolean) ipChange.ipc$dispatch("2093839474", new Object[]{this})).booleanValue();
        }
        return false;
    }

    public final void setMItemImage(@Nullable RoundImageView roundImageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "134253865")) {
            ipChange.ipc$dispatch("134253865", new Object[]{this, roundImageView});
        } else {
            this.mItemImage = roundImageView;
        }
    }

    public final void setMItemImageCover(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1366220257")) {
            ipChange.ipc$dispatch("-1366220257", new Object[]{this, view});
        } else {
            this.mItemImageCover = view;
        }
    }

    public final void setMItemPrice(@Nullable DMDigitTextView dMDigitTextView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "134994449")) {
            ipChange.ipc$dispatch("134994449", new Object[]{this, dMDigitTextView});
        } else {
            this.mItemPrice = dMDigitTextView;
        }
    }

    public final void setMItemPriceLayout(@Nullable LinearLayout linearLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-953333025")) {
            ipChange.ipc$dispatch("-953333025", new Object[]{this, linearLayout});
        } else {
            this.mItemPriceLayout = linearLayout;
        }
    }

    public final void setMItemPriceUnknown(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "361337462")) {
            ipChange.ipc$dispatch("361337462", new Object[]{this, textView});
        } else {
            this.mItemPriceUnknown = textView;
        }
    }

    public final void setMItemSubTitle(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "883268141")) {
            ipChange.ipc$dispatch("883268141", new Object[]{this, textView});
        } else {
            this.mItemSubTitle = textView;
        }
    }

    public final void setMItemTagBottomLeft(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-982330251")) {
            ipChange.ipc$dispatch("-982330251", new Object[]{this, textView});
        } else {
            this.mItemTagBottomLeft = textView;
        }
    }

    public final void setMItemTagTopRight(@Nullable DMCategroyTagView dMCategroyTagView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1293424061")) {
            ipChange.ipc$dispatch("1293424061", new Object[]{this, dMCategroyTagView});
        } else {
            this.mItemTagTopRight = dMCategroyTagView;
        }
    }

    public final void setMItemTitle(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "800416449")) {
            ipChange.ipc$dispatch("800416449", new Object[]{this, textView});
        } else {
            this.mItemTitle = textView;
        }
    }

    public final void setMWantSeeBtn(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1094795515")) {
            ipChange.ipc$dispatch("1094795515", new Object[]{this, textView});
        } else {
            this.mWantSeeBtn = textView;
        }
    }

    public final void setTagsParent(@Nullable FrameLayout frameLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1565334395")) {
            ipChange.ipc$dispatch("1565334395", new Object[]{this, frameLayout});
        } else {
            this.tagsParent = frameLayout;
        }
    }

    @Override // com.alibaba.pictures.bricks.component.home.HomeProjectItemContract.View
    public void updateWantSeeBtn(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1664652119")) {
            ipChange.ipc$dispatch("-1664652119", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        TextView textView = this.mWantSeeBtn;
        if (textView != null) {
            textView.setVisibility(0);
            if (z) {
                textView.setText("已想看");
                textView.setTextColor(Color.parseColor("#5F6672"));
                textView.setBackgroundResource(R$drawable.bricks_want_see_background);
                return;
            }
            textView.setText("想看");
            textView.setTextColor(Color.parseColor("#FFFFFF"));
            textView.setBackgroundResource(R$drawable.bricks_want_see_background_already);
        }
    }
}
