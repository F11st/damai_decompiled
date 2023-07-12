package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.banner.bean.PageBanner;
import cn.damai.commonbusiness.banner.request.OrderDetailBannerRequest;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ta.utdid2.device.UTDevice;
import java.util.HashMap;
import tb.pp2;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderDetailGuideViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private LinearLayout b;
    private ImageView c;

    public OrderDetailGuideViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.order_manager_list_guide, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.a = context;
        this.b = (LinearLayout) this.itemView.findViewById(R$id.ll_order_banner);
        this.c = (ImageView) this.itemView.findViewById(R$id.iv_order_banner);
        int i = DisplayMetrics.getwidthPixels(t60.b(this.a));
        this.c.setLayoutParams(new LinearLayout.LayoutParams(i, (i * 80) / 315));
    }

    public void d(final String str, final String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "520009100")) {
            ipChange.ipc$dispatch("520009100", new Object[]{this, str, str2});
            return;
        }
        OrderDetailBannerRequest orderDetailBannerRequest = new OrderDetailBannerRequest();
        orderDetailBannerRequest.visitorId = UTDevice.getUtdid(this.a);
        orderDetailBannerRequest.request(new DMMtopRequestListener<PageBanner>(PageBanner.class) { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailGuideViewHolder.1
            private static transient /* synthetic */ IpChange $ipChange;

            /* compiled from: Taobao */
            /* renamed from: cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailGuideViewHolder$1$a */
            /* loaded from: classes16.dex */
            public class View$OnClickListenerC2198a implements View.OnClickListener {
                private static transient /* synthetic */ IpChange $ipChange;

                View$OnClickListenerC2198a() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "2009192369")) {
                        ipChange.ipc$dispatch("2009192369", new Object[]{this, view});
                        return;
                    }
                    String str = (String) view.getTag();
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    C0529c e = C0529c.e();
                    pp2 u = pp2.u();
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    e.x(u.y(str, str2, str));
                    DMNav.from(OrderDetailGuideViewHolder.this.a).toUri(str);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str3, String str4) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1969082890")) {
                    ipChange2.ipc$dispatch("1969082890", new Object[]{this, str3, str4});
                } else {
                    OrderDetailGuideViewHolder.this.b.setVisibility(8);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(PageBanner pageBanner) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1532324414")) {
                    ipChange2.ipc$dispatch("-1532324414", new Object[]{this, pageBanner});
                } else if (pageBanner == null || TextUtils.isEmpty(pageBanner.picUrl) || TextUtils.isEmpty(pageBanner.schema)) {
                    OrderDetailGuideViewHolder.this.b.setVisibility(8);
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put("titlelabel", pageBanner.schema);
                    C0529c.e().G(OrderDetailGuideViewHolder.this.b, "bannerimg", "banners", pp2.ORDER_DETAL_PAGE, hashMap);
                    OrderDetailGuideViewHolder.this.b.setVisibility(0);
                    OrderDetailGuideViewHolder.this.c.setTag(pageBanner.schema);
                    DMImageCreator c = C0504a.b().c(pageBanner.picUrl);
                    int i = R$drawable.uikit_default_image_bg_grey;
                    c.i(i).c(i).g(OrderDetailGuideViewHolder.this.c);
                    OrderDetailGuideViewHolder.this.c.setOnClickListener(new View$OnClickListenerC2198a());
                }
            }
        });
    }

    public void e(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-265377847")) {
            ipChange.ipc$dispatch("-265377847", new Object[]{this, str, str2});
            return;
        }
        this.b.setVisibility(8);
        d(str, str2);
    }
}
