package com.alibaba.pictures.bricks.coupon.order.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.coupon.order.bean.Good;
import com.alient.oneservice.ut.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.zn1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class CouponsListViewAdapter extends RecyclerView.Adapter<CouponsViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private Context a;
    @Nullable
    private List<Good> b;
    @Nullable
    private TrackInfo c;

    public CouponsListViewAdapter(@NotNull Context context) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.a = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NotNull CouponsViewHolder couponsViewHolder, int i) {
        List<Good> list;
        Good good;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1641244281")) {
            ipChange.ipc$dispatch("-1641244281", new Object[]{this, couponsViewHolder, Integer.valueOf(i)});
            return;
        }
        b41.i(couponsViewHolder, "viewHolder");
        TrackInfo trackInfo = this.c;
        if (trackInfo == null || (list = this.b) == null || (good = list.get(i)) == null) {
            return;
        }
        couponsViewHolder.h(good, zn1.a(trackInfo));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: b */
    public CouponsViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1002310927")) {
            return (CouponsViewHolder) ipChange.ipc$dispatch("1002310927", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        b41.i(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.bricks_item_coupons_layout, viewGroup, false);
        b41.h(inflate, "from(parent.context)\n   …ns_layout, parent, false)");
        return new CouponsViewHolder(inflate, this.a);
    }

    public final void c(@Nullable TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "706327227")) {
            ipChange.ipc$dispatch("706327227", new Object[]{this, trackInfo});
        } else {
            this.c = trackInfo;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1086534501")) {
            return ((Integer) ipChange.ipc$dispatch("1086534501", new Object[]{this})).intValue();
        }
        List<Good> list = this.b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final void setData(@Nullable List<Good> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-819206377")) {
            ipChange.ipc$dispatch("-819206377", new Object[]{this, list});
        } else if (list == null || !(!list.isEmpty())) {
        } else {
            this.b = list;
            notifyDataSetChanged();
        }
    }
}
