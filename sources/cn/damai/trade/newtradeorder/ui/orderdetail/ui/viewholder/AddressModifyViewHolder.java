package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.trade.R$color;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderAddressModifyResult;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class AddressModifyViewHolder implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private View b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private View g;
    private DMIconFontTextView h;
    private DMIconFontTextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private View m;
    private OnDeliveryAddressClickListener n;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnDeliveryAddressClickListener {
        void onDeliveryAddressClick(String str);
    }

    public AddressModifyViewHolder(Context context, LinearLayout linearLayout, LayoutInflater layoutInflater) {
        this.a = context;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        View inflate = layoutInflater.inflate(R$layout.order_address_modify_item, (ViewGroup) null);
        inflate.setLayoutParams(layoutParams);
        c(inflate);
        linearLayout.addView(inflate);
    }

    private void c(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1200274190")) {
            ipChange.ipc$dispatch("1200274190", new Object[]{this, view});
            return;
        }
        this.b = view.findViewById(R$id.layout_address_content);
        this.c = (TextView) view.findViewById(R$id.tv_address_title);
        this.d = (TextView) view.findViewById(R$id.tv_address_freight_title);
        this.e = (TextView) view.findViewById(R$id.tv_freight_label);
        this.f = (TextView) view.findViewById(R$id.tv_freight);
        this.g = view.findViewById(R$id.layout_order_delivery_info);
        this.h = (DMIconFontTextView) view.findViewById(R$id.tv_order_address_arrow);
        this.i = (DMIconFontTextView) view.findViewById(R$id.order_address_indicator_iv);
        this.j = (TextView) view.findViewById(R$id.order_name_tv);
        this.k = (TextView) view.findViewById(R$id.order_phone_tv);
        this.l = (TextView) view.findViewById(R$id.order_detail_address_tv);
        this.m = view.findViewById(R$id.view_cover);
    }

    private void e(OrderAddressModifyResult.DeliveryInfo deliveryInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "792205604")) {
            ipChange.ipc$dispatch("792205604", new Object[]{this, deliveryInfo});
        } else if (deliveryInfo == null || deliveryInfo.address == null) {
        } else {
            this.f.setText(deliveryInfo.deliveryFee);
            this.j.setText(deliveryInfo.consignee);
            this.k.setText(deliveryInfo.phoneNumber);
            this.l.setText(deliveryInfo.address.fullAddress);
        }
    }

    public void a(OrderAddressModifyResult.DeliveryInfo deliveryInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-66260935")) {
            ipChange.ipc$dispatch("-66260935", new Object[]{this, deliveryInfo});
            return;
        }
        this.c.setText("新地址");
        this.d.setText("新地址运费");
        TextView textView = this.e;
        Resources resources = this.a.getResources();
        int i = R$color.main_color;
        textView.setTextColor(resources.getColor(i));
        this.f.setTextColor(this.a.getResources().getColor(i));
        this.g.setTag(deliveryInfo);
        this.g.setOnClickListener(this);
        this.h.setVisibility(0);
        e(deliveryInfo);
    }

    public void b(OrderAddressModifyResult.DeliveryInfo deliveryInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-422486415")) {
            ipChange.ipc$dispatch("-422486415", new Object[]{this, deliveryInfo});
            return;
        }
        this.c.setText("原地址");
        this.c.setAlpha(0.4f);
        this.d.setText("原地址运费");
        this.d.setAlpha(0.4f);
        TextView textView = this.e;
        Resources resources = this.a.getResources();
        int i = R$color.color_AAAAAA;
        textView.setTextColor(resources.getColor(i));
        this.e.setAlpha(0.4f);
        this.f.setTextColor(this.a.getResources().getColor(i));
        this.f.setAlpha(0.4f);
        this.i.setAlpha(0.4f);
        this.j.setAlpha(0.4f);
        this.k.setAlpha(0.4f);
        this.l.setAlpha(0.4f);
        this.h.setVisibility(4);
        e(deliveryInfo);
    }

    public void d(OnDeliveryAddressClickListener onDeliveryAddressClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-754999328")) {
            ipChange.ipc$dispatch("-754999328", new Object[]{this, onDeliveryAddressClickListener});
        } else {
            this.n = onDeliveryAddressClickListener;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "987230250")) {
            ipChange.ipc$dispatch("987230250", new Object[]{this, view});
        } else if (this.n == null || view.getTag() == null || !(view.getTag() instanceof OrderAddressModifyResult.DeliveryInfo)) {
        } else {
            OnDeliveryAddressClickListener onDeliveryAddressClickListener = this.n;
            onDeliveryAddressClickListener.onDeliveryAddressClick(((OrderAddressModifyResult.DeliveryInfo) view.getTag()).addressId + "");
        }
    }
}
