package com.alibaba.pictures.bricks.coupon.order.view;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.coupon.order.bean.Good;
import com.alibaba.pictures.bricks.coupon.order.bean.Goods;
import com.alibaba.pictures.bricks.coupon.order.view.GroupCouponsViewHolder;
import com.alient.oneservice.ut.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class GroupCouponsViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final TextView a;
    @NotNull
    private final CouponsListView b;
    @NotNull
    private final View c;
    @NotNull
    private final TextView d;
    @NotNull
    private final CouponsListViewAdapter e;
    private boolean f;
    @Nullable
    private Goods g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupCouponsViewHolder(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        View findViewById = view.findViewById(R$id.tv_des);
        b41.h(findViewById, "itemView.findViewById(R.id.tv_des)");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R$id.rl_coupons);
        b41.h(findViewById2, "itemView.findViewById(R.id.rl_coupons)");
        CouponsListView couponsListView = (CouponsListView) findViewById2;
        this.b = couponsListView;
        View findViewById3 = view.findViewById(R$id.sp_line2);
        b41.h(findViewById3, "itemView.findViewById(R.id.sp_line2)");
        this.c = findViewById3;
        View findViewById4 = view.findViewById(R$id.tv_show_all);
        b41.h(findViewById4, "itemView.findViewById(R.id.tv_show_all)");
        TextView textView = (TextView) findViewById4;
        this.d = textView;
        RecyclerView.Adapter adapter = couponsListView.getAdapter();
        b41.g(adapter, "null cannot be cast to non-null type com.alibaba.pictures.bricks.coupon.order.view.CouponsListViewAdapter");
        this.e = (CouponsListViewAdapter) adapter;
        textView.setOnClickListener(new View.OnClickListener() { // from class: tb.xu0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GroupCouponsViewHolder.b(GroupCouponsViewHolder.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GroupCouponsViewHolder groupCouponsViewHolder, View view) {
        List<Good> goodsList;
        String goodsAmount;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "204945682")) {
            ipChange.ipc$dispatch("204945682", new Object[]{groupCouponsViewHolder, view});
            return;
        }
        b41.i(groupCouponsViewHolder, "this$0");
        Goods goods = groupCouponsViewHolder.g;
        List<Good> goodsList2 = goods != null ? goods.getGoodsList() : null;
        Goods goods2 = groupCouponsViewHolder.g;
        Integer valueOf = (goods2 == null || (goodsAmount = goods2.getGoodsAmount()) == null) ? null : Integer.valueOf(Integer.parseInt(goodsAmount));
        if (!(goodsList2 == null || goodsList2.isEmpty()) && goodsList2.size() > 6) {
            if (groupCouponsViewHolder.f) {
                CouponsListViewAdapter couponsListViewAdapter = groupCouponsViewHolder.e;
                Goods goods3 = groupCouponsViewHolder.g;
                if (goods3 != null && (goodsList = goods3.getGoodsList()) != null) {
                    r0 = goodsList.subList(0, 6);
                }
                couponsListViewAdapter.setData(r0);
                groupCouponsViewHolder.d.setText("展开全部" + valueOf + "个劵码");
            } else {
                CouponsListViewAdapter couponsListViewAdapter2 = groupCouponsViewHolder.e;
                Goods goods4 = groupCouponsViewHolder.g;
                couponsListViewAdapter2.setData(goods4 != null ? goods4.getGoodsList() : null);
                groupCouponsViewHolder.d.setText("收起");
            }
        } else {
            CouponsListViewAdapter couponsListViewAdapter3 = groupCouponsViewHolder.e;
            Goods goods5 = groupCouponsViewHolder.g;
            couponsListViewAdapter3.setData(goods5 != null ? goods5.getGoodsList() : null);
            groupCouponsViewHolder.d.setVisibility(8);
        }
        groupCouponsViewHolder.f = !groupCouponsViewHolder.f;
    }

    public final void c(@Nullable Goods goods, @NotNull TrackInfo trackInfo) {
        String goodsAmount;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-674779763")) {
            ipChange.ipc$dispatch("-674779763", new Object[]{this, goods, trackInfo});
            return;
        }
        b41.i(trackInfo, "trackInfo");
        this.g = goods;
        this.e.c(trackInfo);
        if (goods != null) {
            this.a.setText(goods.getGoodsUseTitle());
            List<Good> goodsList = goods.getGoodsList();
            if (goodsList != null && goodsList.size() > 0) {
                this.b.setVisibility(0);
                r1 = null;
                Integer num = null;
                if (!this.f && goodsList.size() > 6) {
                    this.c.setVisibility(0);
                    this.e.setData(goodsList.subList(0, 6));
                    Goods goods2 = this.g;
                    if (goods2 != null && (goodsAmount = goods2.getGoodsAmount()) != null) {
                        num = Integer.valueOf(Integer.parseInt(goodsAmount));
                    }
                    this.d.setText("展开全部" + num + "个劵码");
                    this.d.setVisibility(0);
                    return;
                }
                this.c.setVisibility(8);
                CouponsListViewAdapter couponsListViewAdapter = this.e;
                Goods goods3 = this.g;
                couponsListViewAdapter.setData(goods3 != null ? goods3.getGoodsList() : null);
                return;
            }
            this.b.setVisibility(8);
            this.c.setVisibility(8);
        }
    }
}
