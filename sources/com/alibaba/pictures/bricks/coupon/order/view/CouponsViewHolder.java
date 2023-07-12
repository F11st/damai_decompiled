package com.alibaba.pictures.bricks.coupon.order.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.coupon.order.bean.Good;
import com.alibaba.pictures.bricks.coupon.order.bean.GoodStatus;
import com.alibaba.pictures.bricks.coupon.order.view.CouponsViewHolder;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import io.flutter.wpkbridge.WPKFactory;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.qo1;
import tb.zn1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class CouponsViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private Context a;
    @NotNull
    private final LinearLayout b;
    @NotNull
    private final TextView c;
    @NotNull
    private final TextView d;
    @NotNull
    private final TextView e;
    @NotNull
    private final TextView f;
    @NotNull
    private final ImageView g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CouponsViewHolder(@NotNull View view, @NotNull Context context) {
        super(view);
        b41.i(view, "itemView");
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.a = context;
        View findViewById = view.findViewById(R$id.coupons_container);
        b41.h(findViewById, "itemView.findViewById(R.id.coupons_container)");
        this.b = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(R$id.tv_title);
        b41.h(findViewById2, "itemView.findViewById(R.id.tv_title)");
        this.c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R$id.tv_ext_btn);
        b41.h(findViewById3, "itemView.findViewById(R.id.tv_ext_btn)");
        this.d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R$id.tv_action_btn);
        b41.h(findViewById4, "itemView.findViewById(R.id.tv_action_btn)");
        this.e = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R$id.tv_des);
        b41.h(findViewById5, "itemView.findViewById(R.id.tv_des)");
        this.f = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R$id.right_arrow);
        b41.h(findViewById6, "itemView.findViewById(R.id.right_arrow)");
        this.g = (ImageView) findViewById6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(TrackInfo trackInfo, CouponsViewHolder couponsViewHolder, Good good, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1217423128")) {
            ipChange.ipc$dispatch("1217423128", new Object[]{trackInfo, couponsViewHolder, good, view});
            return;
        }
        b41.i(trackInfo, "$trackInfo");
        b41.i(couponsViewHolder, "this$0");
        qo1 qo1Var = qo1.INSTANCE;
        b41.h(view, AdvanceSetting.NETWORK_TYPE);
        qo1Var.k(view, zn1.a(trackInfo));
        List<String> detailUrlList = good.getDetailUrlList();
        couponsViewHolder.p(detailUrlList != null ? detailUrlList.get(0) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(TrackInfo trackInfo, CouponsViewHolder couponsViewHolder, Good good, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1520310519")) {
            ipChange.ipc$dispatch("1520310519", new Object[]{trackInfo, couponsViewHolder, good, view});
            return;
        }
        b41.i(trackInfo, "$trackInfo");
        b41.i(couponsViewHolder, "this$0");
        qo1 qo1Var = qo1.INSTANCE;
        b41.h(view, AdvanceSetting.NETWORK_TYPE);
        qo1Var.t(view, zn1.a(trackInfo), false);
        List<String> detailUrlList = good.getDetailUrlList();
        couponsViewHolder.p(detailUrlList != null ? detailUrlList.get(1) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(CouponsViewHolder couponsViewHolder, Good good, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "343995676")) {
            ipChange.ipc$dispatch("343995676", new Object[]{couponsViewHolder, good, view});
            return;
        }
        b41.i(couponsViewHolder, "this$0");
        List<String> detailUrlList = good.getDetailUrlList();
        couponsViewHolder.p(detailUrlList != null ? detailUrlList.get(1) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(CouponsViewHolder couponsViewHolder, Good good, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1598182789")) {
            ipChange.ipc$dispatch("-1598182789", new Object[]{couponsViewHolder, good, view});
            return;
        }
        b41.i(couponsViewHolder, "this$0");
        List<String> detailUrlList = good.getDetailUrlList();
        couponsViewHolder.p(detailUrlList != null ? detailUrlList.get(0) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(CouponsViewHolder couponsViewHolder, Good good, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "754606042")) {
            ipChange.ipc$dispatch("754606042", new Object[]{couponsViewHolder, good, view});
            return;
        }
        b41.i(couponsViewHolder, "this$0");
        List<String> detailUrlList = good.getDetailUrlList();
        couponsViewHolder.p(detailUrlList != null ? detailUrlList.get(0) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(CouponsViewHolder couponsViewHolder, Good good, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1187572423")) {
            ipChange.ipc$dispatch("-1187572423", new Object[]{couponsViewHolder, good, view});
            return;
        }
        b41.i(couponsViewHolder, "this$0");
        List<String> detailUrlList = good.getDetailUrlList();
        couponsViewHolder.p(detailUrlList != null ? detailUrlList.get(0) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(CouponsViewHolder couponsViewHolder, Good good, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1165216408")) {
            ipChange.ipc$dispatch("1165216408", new Object[]{couponsViewHolder, good, view});
            return;
        }
        b41.i(couponsViewHolder, "this$0");
        List<String> detailUrlList = good.getDetailUrlList();
        couponsViewHolder.p(detailUrlList != null ? detailUrlList.get(0) : null);
    }

    public final void h(@Nullable final Good good, @NotNull final TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1471630403")) {
            ipChange.ipc$dispatch("1471630403", new Object[]{this, good, trackInfo});
            return;
        }
        b41.i(trackInfo, "trackInfo");
        if (good != null) {
            this.b.setVisibility(0);
            this.c.setText(good.getTitle());
            List<String> detailUrlList = good.getDetailUrlList();
            if (detailUrlList != null) {
                String status = good.getStatus();
                if (b41.d(status, GoodStatus.USABLE.getStatus())) {
                    this.d.setVisibility(0);
                    this.e.setVisibility(0);
                    this.f.setVisibility(8);
                    this.g.setVisibility(8);
                    this.e.setText("到店使用");
                    if (detailUrlList.size() >= 2) {
                        qo1 qo1Var = qo1.INSTANCE;
                        qo1Var.l(this.d, zn1.a(trackInfo));
                        this.d.setOnClickListener(new View.OnClickListener() { // from class: tb.op
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                CouponsViewHolder.i(TrackInfo.this, this, good, view);
                            }
                        });
                        qo1Var.u(this.e, zn1.a(trackInfo), false);
                        this.e.setOnClickListener(new View.OnClickListener() { // from class: tb.pp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                CouponsViewHolder.j(TrackInfo.this, this, good, view);
                            }
                        });
                        this.b.setOnClickListener(new View.OnClickListener() { // from class: tb.jp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                CouponsViewHolder.k(CouponsViewHolder.this, good, view);
                            }
                        });
                        return;
                    }
                    this.d.setVisibility(8);
                    this.e.setVisibility(8);
                    return;
                } else if (b41.d(status, GoodStatus.REFUNDING.getStatus())) {
                    this.d.setVisibility(8);
                    this.e.setVisibility(8);
                    this.f.setVisibility(0);
                    this.g.setVisibility(0);
                    this.f.setText(good.getDesc());
                    if (detailUrlList.size() >= 1) {
                        this.b.setOnClickListener(new View.OnClickListener() { // from class: tb.np
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                CouponsViewHolder.l(CouponsViewHolder.this, good, view);
                            }
                        });
                        return;
                    } else {
                        this.g.setVisibility(8);
                        return;
                    }
                } else if (b41.d(status, GoodStatus.REFUNDED.getStatus())) {
                    this.d.setVisibility(8);
                    this.e.setVisibility(8);
                    this.f.setVisibility(0);
                    this.g.setVisibility(0);
                    this.f.setText(good.getDesc());
                    if (detailUrlList.size() >= 1) {
                        this.b.setOnClickListener(new View.OnClickListener() { // from class: tb.mp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                CouponsViewHolder.m(CouponsViewHolder.this, good, view);
                            }
                        });
                        return;
                    } else {
                        this.g.setVisibility(8);
                        return;
                    }
                } else if (b41.d(status, GoodStatus.USED.getStatus())) {
                    this.d.setVisibility(8);
                    this.e.setVisibility(0);
                    this.f.setVisibility(8);
                    this.g.setVisibility(8);
                    if (b41.d(good.getGoCommentButton(), Boolean.TRUE)) {
                        this.e.setText("去评价");
                    } else if (b41.d(good.getGoCommentButton(), Boolean.FALSE)) {
                        this.e.setText("看评价");
                    } else {
                        this.e.setVisibility(8);
                    }
                    if (detailUrlList.size() >= 1) {
                        this.e.setOnClickListener(new View.OnClickListener() { // from class: tb.lp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                CouponsViewHolder.n(CouponsViewHolder.this, good, view);
                            }
                        });
                        return;
                    } else {
                        this.e.setVisibility(8);
                        return;
                    }
                } else if (b41.d(status, GoodStatus.REFUND_FAILED.getStatus())) {
                    this.d.setVisibility(8);
                    this.e.setVisibility(8);
                    this.f.setVisibility(0);
                    this.g.setVisibility(0);
                    this.f.setText(good.getDesc());
                    if (detailUrlList.size() >= 1) {
                        this.b.setOnClickListener(new View.OnClickListener() { // from class: tb.kp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                CouponsViewHolder.o(CouponsViewHolder.this, good, view);
                            }
                        });
                        return;
                    } else {
                        this.g.setVisibility(8);
                        return;
                    }
                } else {
                    this.b.setVisibility(8);
                    return;
                }
            }
            this.d.setVisibility(8);
            this.e.setVisibility(8);
        }
    }

    public final void p(@Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "598483293")) {
            ipChange.ipc$dispatch("598483293", new Object[]{this, str});
            return;
        }
        if ((str == null || str.length() == 0) ? true : true) {
            return;
        }
        Action action = new Action();
        action.setActionType(1);
        action.setActionUrl(str);
        NavProviderProxy.getProxy().toUri(this.a, action);
    }
}
