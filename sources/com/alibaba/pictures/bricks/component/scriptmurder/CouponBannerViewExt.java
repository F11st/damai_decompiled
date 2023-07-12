package com.alibaba.pictures.bricks.component.scriptmurder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$id;
import com.alient.onearch.adapter.component.banner.base.BaseBannerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.r10;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class CouponBannerViewExt extends BaseBannerView {
    private static transient /* synthetic */ IpChange $ipChange;
    private int index;
    @NotNull
    private final View view;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@Nullable View view) {
            int i;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-430301624")) {
                ipChange.ipc$dispatch("-430301624", new Object[]{this, view});
                return;
            }
            P presenter = CouponBannerViewExt.this.getPresenter();
            b41.g(presenter, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.scriptmurder.CouponBannerPresenterExt");
            ((CouponBannerPresenterExt) presenter).disPatch(GenericBannerPresenterExt.MSG_BANNER_ATTACHED);
            CouponBannerViewExt couponBannerViewExt = CouponBannerViewExt.this;
            if (couponBannerViewExt.getIndex() - 1 >= 0) {
                i = CouponBannerViewExt.this.getIndex();
            } else {
                CouponBannerViewExt couponBannerViewExt2 = CouponBannerViewExt.this;
                int index = couponBannerViewExt2.getIndex();
                couponBannerViewExt2.setIndex(index - 1);
                i = index;
            }
            couponBannerViewExt.setIndex(i);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@Nullable View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1079496507")) {
                ipChange.ipc$dispatch("-1079496507", new Object[]{this, view});
                return;
            }
            P presenter = CouponBannerViewExt.this.getPresenter();
            b41.g(presenter, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.scriptmurder.CouponBannerPresenterExt");
            ((CouponBannerPresenterExt) presenter).disPatch(GenericBannerPresenterExt.MSG_BANNER_DETACHED);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CouponBannerViewExt(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        this.view = view;
    }

    public final int getIndex() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2109427759") ? ((Integer) ipChange.ipc$dispatch("2109427759", new Object[]{this})).intValue() : this.index;
    }

    @Override // com.alient.onearch.adapter.component.banner.base.BaseBannerContract.View
    @NotNull
    public RecyclerView getRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-464808801")) {
            return (RecyclerView) ipChange.ipc$dispatch("-464808801", new Object[]{this});
        }
        View findViewById = this.view.findViewById(R$id.coupon_top_banner_container);
        b41.g(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        return (RecyclerView) findViewById;
    }

    @NotNull
    public final View getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1086944569") ? (View) ipChange.ipc$dispatch("1086944569", new Object[]{this}) : this.view;
    }

    @Override // com.alient.onearch.adapter.component.banner.base.BaseBannerView, com.alient.onearch.adapter.component.banner.base.BaseBannerContract.View
    public void initRecyclerSettings(@Nullable RecyclerView.RecycledViewPool recycledViewPool, @Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "247761852")) {
            ipChange.ipc$dispatch("247761852", new Object[]{this, recycledViewPool, map});
            return;
        }
        super.initRecyclerSettings(recycledViewPool, map);
        this.view.addOnAttachStateChangeListener(new a());
    }

    public final void setIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1778193733")) {
            ipChange.ipc$dispatch("-1778193733", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.index = i;
        }
    }

    public final void updateImgLength(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-480829690")) {
            ipChange.ipc$dispatch("-480829690", new Object[]{this, str, str2});
            return;
        }
        b41.i(str, "size");
        b41.i(str2, "pos");
        try {
            if (Integer.parseInt(str) <= 1) {
                View findViewById = this.view.findViewById(R$id.coupon_img_count_info);
                if (findViewById == null) {
                    return;
                }
                findViewById.setVisibility(8);
                return;
            }
            View findViewById2 = this.view.findViewById(R$id.coupon_img_count_info);
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
            TextView textView = (TextView) this.view.findViewById(R$id.coupon_img_count_info_title);
            if (textView == null) {
                return;
            }
            textView.setText(str2 + r10.DIR + str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
