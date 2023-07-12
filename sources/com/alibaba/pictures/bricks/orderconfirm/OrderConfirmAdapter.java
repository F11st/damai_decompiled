package com.alibaba.pictures.bricks.orderconfirm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.gaiaxholder.NativeGaiaXViewHolder;
import com.alibaba.pictures.bricks.orderconfirm.bean.OrderCreateBean;
import com.alient.gaiax.container.util.UrlUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.util.LogUtil;
import com.youku.middlewareservice.provider.info.DeviceInfoProviderProxy;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hh1;
import tb.k50;
import tb.un1;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class OrderConfirmAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final int BUY_NUM_TYPE = 0;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final Map<Integer, Integer> f = new LinkedHashMap();
    @Nullable
    private OnEventListener a;
    @NotNull
    private final Context b;
    @Nullable
    private List<? extends OrderCreateBean> c;
    private int d;
    @Nullable
    private JSONObject e;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    public OrderConfirmAdapter(@NotNull Context context, @Nullable OnEventListener onEventListener) {
        b41.i(context, "mContext");
        this.a = onEventListener;
        this.b = context;
        this.d = 100;
    }

    private final int a(OrderCreateBean.GaiaxRender gaiaxRender) {
        Integer num;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1792178613")) {
            return ((Integer) ipChange.ipc$dispatch("-1792178613", new Object[]{this, gaiaxRender})).intValue();
        }
        String str = gaiaxRender.url;
        if (str != null) {
            int hashCode = str.hashCode();
            Map<Integer, Integer> map = f;
            Integer num2 = map.get(Integer.valueOf(hashCode));
            if (num2 == null) {
                num2 = Integer.valueOf(this.d);
                map.put(Integer.valueOf(hashCode), num2);
                this.d++;
            }
            num = Integer.valueOf(num2.intValue());
        } else {
            num = null;
        }
        b41.f(num);
        return num.intValue();
    }

    public final void b(@Nullable JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1770334883")) {
            ipChange.ipc$dispatch("1770334883", new Object[]{this, jSONObject});
        } else {
            this.e = jSONObject;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2044305914")) {
            return ((Integer) ipChange.ipc$dispatch("-2044305914", new Object[]{this})).intValue();
        }
        List<? extends OrderCreateBean> list = this.c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        OrderCreateBean orderCreateBean;
        wt2 wt2Var;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1916331437")) {
            return ((Integer) ipChange.ipc$dispatch("1916331437", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        List<? extends OrderCreateBean> list = this.c;
        if (list == null || (orderCreateBean = list.get(i)) == null) {
            return 0;
        }
        List<OrderCreateBean.GaiaxRender> list2 = orderCreateBean.render;
        if (list2 != null) {
            b41.h(list2, "render");
            OrderCreateBean.GaiaxRender gaiaxRender = (OrderCreateBean.GaiaxRender) k.P(list2);
            if (gaiaxRender != null) {
                b41.h(gaiaxRender, "first()");
                i2 = a(gaiaxRender);
                wt2Var = wt2.INSTANCE;
                if (wt2Var == null || !b41.d(orderCreateBean.templateId, "buy_info")) {
                    return i2;
                }
                return 0;
            }
        }
        wt2Var = null;
        i2 = 0;
        if (wt2Var == null) {
        }
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        List<OrderCreateBean.GaiaxRender> list;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1523206963")) {
            ipChange.ipc$dispatch("1523206963", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        b41.i(viewHolder, "holder");
        List<? extends OrderCreateBean> list2 = this.c;
        OrderCreateBean orderCreateBean = list2 != null ? list2.get(i) : null;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("onbinder start pos = ");
        sb.append(i);
        sb.append(" data = ");
        sb.append(orderCreateBean != null ? orderCreateBean.templateId : null);
        objArr[0] = sb.toString();
        LogUtil.e("OrderConfirmAdapter", objArr);
        if (viewHolder instanceof OrderPriceInfoViewHolder) {
            ((OrderPriceInfoViewHolder) viewHolder).f(orderCreateBean != null ? orderCreateBean.data : null);
        } else if (!(viewHolder instanceof NativeGaiaXViewHolder) || orderCreateBean == null || (list = orderCreateBean.render) == null) {
        } else {
            b41.h(list, "render");
            OrderCreateBean.GaiaxRender gaiaxRender = (OrderCreateBean.GaiaxRender) k.P(list);
            if (gaiaxRender != null) {
                b41.h(gaiaxRender, "first()");
                UrlUtil urlUtil = UrlUtil.INSTANCE;
                String str = gaiaxRender.url;
                b41.h(str, "url");
                String paramValue = urlUtil.getParamValue(str, hh1.DIMEN_BIZ);
                String str2 = gaiaxRender.url;
                b41.h(str2, "url");
                String paramValue2 = urlUtil.getParamValue(str2, "templateId");
                String str3 = gaiaxRender.url;
                b41.h(str3, "url");
                String paramValue3 = urlUtil.getParamValue(str3, "templateVersion");
                if (paramValue == null || paramValue.length() == 0) {
                    return;
                }
                if (paramValue2 == null || paramValue2.length() == 0) {
                    return;
                }
                if (paramValue3 != null && paramValue3.length() != 0) {
                    z = false;
                }
                if (z) {
                    return;
                }
                ((NativeGaiaXViewHolder) viewHolder).d(paramValue, paramValue2, paramValue3, DeviceInfoProviderProxy.getWindowWidth(), i, orderCreateBean.data);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "392273955")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("392273955", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        b41.i(viewGroup, "parent");
        LogUtil.e("OrderConfirmAdapter", "onCreate viewType=" + i);
        if (i == 0) {
            View inflate = LayoutInflater.from(this.b).inflate(R$layout.bricks_coupon_order_confirm_numprice_layout, viewGroup, false);
            b41.h(inflate, "item");
            return new OrderPriceInfoViewHolder(inflate, this.a, this.e);
        }
        Context context = this.b;
        return new NativeGaiaXViewHolder(context, new un1(context, this.a, this.e));
    }

    public final void setData(@Nullable List<? extends OrderCreateBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1505983958")) {
            ipChange.ipc$dispatch("1505983958", new Object[]{this, list});
            return;
        }
        this.c = list;
        notifyDataSetChanged();
    }
}
