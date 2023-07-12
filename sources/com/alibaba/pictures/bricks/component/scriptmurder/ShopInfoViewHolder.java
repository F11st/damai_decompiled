package com.alibaba.pictures.bricks.component.scriptmurder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.ShopInfoBean;
import com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoViewHolder;
import com.alibaba.pictures.bricks.view.FiveStarView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.flexbox.FlexboxLayout;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ShopInfoViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private final TextView a;
    @Nullable
    private final ImageView b;
    @Nullable
    private final TextView c;
    @Nullable
    private final TextView d;
    @NotNull
    private final View e;
    @NotNull
    private final TextView f;
    private final View g;
    @Nullable
    private final FiveStarView h;
    private final TextView i;
    private final View j;
    @Nullable
    private final View k;
    @Nullable
    private final View l;
    @Nullable
    private final TextView m;
    private final FlexboxLayout n;
    @Nullable
    private final TextView o;
    @Nullable
    private final View p;
    @Nullable
    private final View q;
    @Nullable
    private OnShopInfoListener r;
    @Nullable
    private ShopInfoBean s;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface OnShopInfoListener {
        void onEvaluateEntranceBtnClick(@NotNull View view, @NotNull ShopInfoBean shopInfoBean);

        void onShopAuthBtnClick(@NotNull View view, @NotNull ShopInfoBean shopInfoBean);

        void onShopInfoEntranceClick(@NotNull View view, @NotNull ShopInfoBean shopInfoBean);

        void onShopInfoViewExpose(@NotNull View view, @NotNull ShopInfoBean shopInfoBean);

        void onShopMapBtnClick(@NotNull View view, @NotNull ShopInfoBean shopInfoBean);

        void onShopPhoneBtnClick(@NotNull View view, @NotNull ShopInfoBean shopInfoBean);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopInfoViewHolder(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.a = (TextView) view.findViewById(R$id.id_sm_shop_name);
        ImageView imageView = (ImageView) view.findViewById(R$id.id_sm_shop_auth);
        this.b = imageView;
        this.c = (TextView) view.findViewById(R$id.id_sm_shop_ext_info);
        this.d = (TextView) view.findViewById(R$id.id_sm_shop_ext_status);
        View findViewById = view.findViewById(R$id.id_sm_shop_open_evaluate_btn);
        b41.h(findViewById, "itemView.findViewById(R.…m_shop_open_evaluate_btn)");
        this.e = findViewById;
        View findViewById2 = view.findViewById(R$id.id_sm_shop_price_and_count);
        b41.h(findViewById2, "itemView.findViewById(R.…_sm_shop_price_and_count)");
        this.f = (TextView) findViewById2;
        this.g = view.findViewById(R$id.id_sm_score_ext_ui);
        this.h = (FiveStarView) view.findViewById(R$id.id_sm_shop_star_view);
        this.i = (TextView) view.findViewById(R$id.id_sm_shop_score_tv);
        this.j = view.findViewById(R$id.id_sm_shop_score_star_ui);
        View findViewById3 = view.findViewById(R$id.id_sm_shop_call_ui);
        this.k = findViewById3;
        View findViewById4 = view.findViewById(R$id.id_sm_shop_loc_ui);
        this.l = findViewById4;
        this.m = (TextView) view.findViewById(R$id.id_sm_shop_loc_distance);
        this.n = (FlexboxLayout) view.findViewById(R$id.id_sm_shop_tag_flex2);
        this.o = (TextView) view.findViewById(R$id.id_sm_shop_addr);
        View findViewById5 = view.findViewById(R$id.id_sm_shop_info_entrance);
        this.p = findViewById5;
        this.q = view.findViewById(R$id.id_sm_shop_entrance_arrow);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: tb.hc2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ShopInfoViewHolder.f(ShopInfoViewHolder.this, view2);
                }
            });
        }
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: tb.jc2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ShopInfoViewHolder.g(ShopInfoViewHolder.this, view2);
                }
            });
        }
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(new View.OnClickListener() { // from class: tb.ic2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ShopInfoViewHolder.h(ShopInfoViewHolder.this, view2);
                }
            });
        }
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(new View.OnClickListener() { // from class: tb.gc2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ShopInfoViewHolder.i(ShopInfoViewHolder.this, view2);
                }
            });
        }
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(new View.OnClickListener() { // from class: tb.fc2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ShopInfoViewHolder.j(ShopInfoViewHolder.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ShopInfoViewHolder shopInfoViewHolder, View view) {
        OnShopInfoListener onShopInfoListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-253854913")) {
            ipChange.ipc$dispatch("-253854913", new Object[]{shopInfoViewHolder, view});
            return;
        }
        b41.i(shopInfoViewHolder, "this$0");
        ShopInfoBean shopInfoBean = shopInfoViewHolder.s;
        if (shopInfoBean == null || (onShopInfoListener = shopInfoViewHolder.r) == null) {
            return;
        }
        b41.h(view, AdvanceSetting.NETWORK_TYPE);
        onShopInfoListener.onShopAuthBtnClick(view, shopInfoBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ShopInfoViewHolder shopInfoViewHolder, View view) {
        OnShopInfoListener onShopInfoListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1872829827")) {
            ipChange.ipc$dispatch("-1872829827", new Object[]{shopInfoViewHolder, view});
            return;
        }
        b41.i(shopInfoViewHolder, "this$0");
        ShopInfoBean shopInfoBean = shopInfoViewHolder.s;
        if (shopInfoBean == null || (onShopInfoListener = shopInfoViewHolder.r) == null) {
            return;
        }
        b41.h(view, AdvanceSetting.NETWORK_TYPE);
        onShopInfoListener.onEvaluateEntranceBtnClick(view, shopInfoBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ShopInfoViewHolder shopInfoViewHolder, View view) {
        OnShopInfoListener onShopInfoListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "803162555")) {
            ipChange.ipc$dispatch("803162555", new Object[]{shopInfoViewHolder, view});
            return;
        }
        b41.i(shopInfoViewHolder, "this$0");
        ShopInfoBean shopInfoBean = shopInfoViewHolder.s;
        if (shopInfoBean == null || (onShopInfoListener = shopInfoViewHolder.r) == null) {
            return;
        }
        b41.h(view, AdvanceSetting.NETWORK_TYPE);
        onShopInfoListener.onShopPhoneBtnClick(view, shopInfoBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ShopInfoViewHolder shopInfoViewHolder, View view) {
        OnShopInfoListener onShopInfoListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-815812359")) {
            ipChange.ipc$dispatch("-815812359", new Object[]{shopInfoViewHolder, view});
            return;
        }
        b41.i(shopInfoViewHolder, "this$0");
        ShopInfoBean shopInfoBean = shopInfoViewHolder.s;
        if (shopInfoBean == null || (onShopInfoListener = shopInfoViewHolder.r) == null) {
            return;
        }
        b41.h(view, AdvanceSetting.NETWORK_TYPE);
        onShopInfoListener.onShopMapBtnClick(view, shopInfoBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ShopInfoViewHolder shopInfoViewHolder, View view) {
        OnShopInfoListener onShopInfoListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1860180023")) {
            ipChange.ipc$dispatch("1860180023", new Object[]{shopInfoViewHolder, view});
            return;
        }
        b41.i(shopInfoViewHolder, "this$0");
        ShopInfoBean shopInfoBean = shopInfoViewHolder.s;
        if (shopInfoBean == null || (onShopInfoListener = shopInfoViewHolder.r) == null) {
            return;
        }
        b41.h(view, AdvanceSetting.NETWORK_TYPE);
        onShopInfoListener.onShopInfoEntranceClick(view, shopInfoBean);
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:194:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void k(@org.jetbrains.annotations.NotNull com.alibaba.pictures.bricks.bean.ShopInfoBean r15) {
        /*
            Method dump skipped, instructions count: 695
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoViewHolder.k(com.alibaba.pictures.bricks.bean.ShopInfoBean):void");
    }

    public final void l(@Nullable OnShopInfoListener onShopInfoListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-55228406")) {
            ipChange.ipc$dispatch("-55228406", new Object[]{this, onShopInfoListener});
        } else {
            this.r = onShopInfoListener;
        }
    }
}
