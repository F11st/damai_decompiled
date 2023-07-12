package com.alibaba.pictures.bricks.orderresult;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.gaiaxholder.NativeGaiaXViewHolder;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.bean.DmCouponPaySuccessBean;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.bean.PayResultDataHolder;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.viewholder.RecommendTitleViewHolder;
import com.alient.gaiax.container.util.UrlUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXGlobalEventReceiver;
import com.youku.gaiax.api.data.EventParams;
import com.youku.middlewareservice.provider.info.DeviceInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ap2;
import tb.b41;
import tb.gp;
import tb.hh1;
import tb.kz1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class CouponPayResultAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Context a;
    @Nullable
    private final String b;
    @Nullable
    private ArrayList<PayResultDataHolder> c;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a extends gp {
        private static transient /* synthetic */ IpChange $ipChange;

        a(Context context, String str) {
            super(context, str);
        }

        @Override // tb.gp, tb.xi1
        public void e(@NotNull EventParams eventParams, @NotNull JSONObject jSONObject, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1245603644")) {
                ipChange.ipc$dispatch("-1245603644", new Object[]{this, eventParams, jSONObject, Integer.valueOf(i)});
                return;
            }
            b41.i(eventParams, WXGlobalEventReceiver.EVENT_PARAMS);
            b41.i(jSONObject, "data");
            super.e(eventParams, jSONObject, i);
        }

        @Override // tb.gp, tb.xi1
        public void f(@NotNull View view, @NotNull JSONObject jSONObject, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2113984766")) {
                ipChange.ipc$dispatch("2113984766", new Object[]{this, view, jSONObject, Integer.valueOf(i)});
                return;
            }
            b41.i(view, "itemView");
            b41.i(jSONObject, "data");
            super.f(view, jSONObject, i);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class b extends kz1 {
        private static transient /* synthetic */ IpChange $ipChange;

        b(Context context) {
            super(context);
        }

        @Override // tb.kz1, tb.xi1
        public void f(@NotNull View view, @NotNull JSONObject jSONObject, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1072167331")) {
                ipChange.ipc$dispatch("-1072167331", new Object[]{this, view, jSONObject, Integer.valueOf(i)});
                return;
            }
            b41.i(view, "itemView");
            b41.i(jSONObject, "data");
            super.f(view, jSONObject, i);
        }
    }

    public CouponPayResultAdapter(@NotNull Context context, @Nullable String str) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.a = context;
        this.b = str;
    }

    public final void a(@NotNull ArrayList<PayResultDataHolder> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1472994003")) {
            ipChange.ipc$dispatch("-1472994003", new Object[]{this, arrayList});
            return;
        }
        b41.i(arrayList, "list");
        this.c = arrayList;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1135400538")) {
            return ((Integer) ipChange.ipc$dispatch("1135400538", new Object[]{this})).intValue();
        }
        ArrayList<PayResultDataHolder> arrayList = this.c;
        if (arrayList == null) {
            return 0;
        }
        b41.f(arrayList);
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        PayResultDataHolder payResultDataHolder;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1671228415")) {
            return ((Integer) ipChange.ipc$dispatch("-1671228415", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        ArrayList<PayResultDataHolder> arrayList = this.c;
        return (arrayList == null || (payResultDataHolder = arrayList.get(i)) == null) ? super.getItemViewType(i) : payResultDataHolder.getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, @SuppressLint({"RecyclerView"}) int i) {
        List<DmCouponPaySuccessBean.GaiaxRender> list;
        DmCouponPaySuccessBean.GaiaxRender gaiaxRender;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1307079073")) {
            ipChange.ipc$dispatch("-1307079073", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        b41.i(viewHolder, "holder");
        ArrayList<PayResultDataHolder> arrayList = this.c;
        PayResultDataHolder payResultDataHolder = arrayList != null ? arrayList.get(i) : null;
        Integer valueOf = payResultDataHolder != null ? Integer.valueOf(payResultDataHolder.getType()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            DmCouponPaySuccessBean mPayResponse = payResultDataHolder.getMPayResponse();
            if (mPayResponse == null || (list = mPayResponse.render) == null || (gaiaxRender = (DmCouponPaySuccessBean.GaiaxRender) k.P(list)) == null) {
                return;
            }
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
            ap2 ap2Var = ap2.INSTANCE;
            JSONObject i2 = ap2Var.i(ap2Var.k(payResultDataHolder.getMPayResponse()));
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
            ((NativeGaiaXViewHolder) viewHolder).d(paramValue, paramValue2, paramValue3, DeviceInfoProviderProxy.getWindowWidth(), i, i2);
        } else if (valueOf != null && valueOf.intValue() == 2) {
            ((NativeGaiaXViewHolder) viewHolder).d("damai", kz1.TEMPLATE_ID, "4", DeviceInfoProviderProxy.getWindowWidth(), i, payResultDataHolder.getMRecommendResponse());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-758118793")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-758118793", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        b41.i(viewGroup, "parent");
        if (i == 0) {
            Context context = this.a;
            return new NativeGaiaXViewHolder(context, new a(context, this.b));
        } else if (i != 1) {
            Context context2 = this.a;
            return new NativeGaiaXViewHolder(context2, new b(context2));
        } else {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.bricks_coupon_order_result_recommend_title, viewGroup, false);
            b41.h(inflate, "from(parent.context).inf…, false\n                )");
            return new RecommendTitleViewHolder(inflate);
        }
    }
}
