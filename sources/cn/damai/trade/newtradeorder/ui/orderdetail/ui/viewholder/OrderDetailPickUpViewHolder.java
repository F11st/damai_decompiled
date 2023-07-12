package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.address.bean.DmPickupAddressBean;
import cn.damai.commonbusiness.address.bean.DmPickupAddressEntry;
import cn.damai.trade.R$color;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.ultron.secondpage.pickup.OrderDetailPickupAddressListActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.mo1;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderDetailPickUpViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private LinearLayout a;
    private LinearLayout b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private Context j;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DmPickupAddressBean a;

        a(DmPickupAddressBean dmPickupAddressBean) {
            this.a = dmPickupAddressBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1858972580")) {
                ipChange.ipc$dispatch("1858972580", new Object[]{this, view});
                return;
            }
            mo1.c = false;
            Bundle bundle = new Bundle();
            bundle.putSerializable(OrderDetailPickupAddressListActivity.DM_PICKUP_ADDRESS, this.a);
            DMNav.from(OrderDetailPickUpViewHolder.this.j).withExtras(bundle).toUri("damai://purchase_pickup_address_list");
        }
    }

    public OrderDetailPickUpViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.order_detail_delivery_pickup, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.j = context;
        c(this.itemView);
    }

    private void c(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-833456387")) {
            ipChange.ipc$dispatch("-833456387", new Object[]{this, view});
        } else if (view == null) {
        } else {
            this.a = (LinearLayout) view.findViewById(R$id.pick_up_container);
            this.b = (LinearLayout) view.findViewById(R$id.ll_self_company_count);
            this.c = (TextView) view.findViewById(R$id.tv_pickup_name);
            this.d = (TextView) view.findViewById(R$id.tv_pickup_tag);
            this.e = (TextView) view.findViewById(R$id.tv_pickup_location);
            this.f = (TextView) view.findViewById(R$id.tv_self_company_count);
            this.g = (TextView) view.findViewById(R$id.tv_self_company_address);
            this.h = (TextView) view.findViewById(R$id.tv_self_company_time);
            this.i = (TextView) view.findViewById(R$id.tv_self_company_phone);
        }
    }

    public void b(DmPickupAddressBean dmPickupAddressBean) {
        boolean z;
        String str;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "602336160")) {
            ipChange.ipc$dispatch("602336160", new Object[]{this, dmPickupAddressBean});
            return;
        }
        int e = dmPickupAddressBean != null ? wh2.e(dmPickupAddressBean.dmPickupAddressEntryList) : 0;
        if (e == 0) {
            return;
        }
        this.a.setBackgroundColor(ContextCompat.getColor(this.j, R$color.white));
        if (e > 1) {
            this.itemView.setOnClickListener(new a(dmPickupAddressBean));
            this.f.setText("共" + e + "个取票点");
            this.b.setVisibility(0);
        } else {
            this.itemView.setOnClickListener(null);
            this.b.setVisibility(8);
        }
        DmPickupAddressEntry dmPickupAddressEntry = dmPickupAddressBean.dmPickupAddressEntryList.get(0);
        if (dmPickupAddressEntry != null) {
            if (!TextUtils.isEmpty(dmPickupAddressEntry.tag)) {
                this.d.setText(dmPickupAddressEntry.tag);
                this.d.setVisibility(0);
                z = true;
            } else {
                this.d.setVisibility(8);
                z = false;
            }
            if (!TextUtils.isEmpty(dmPickupAddressEntry.distance)) {
                this.e.setText(dmPickupAddressEntry.distance);
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
                z2 = z;
            }
            if (TextUtils.isEmpty(dmPickupAddressEntry.name)) {
                this.c.setText("门店取票网点信息");
            } else if (z2) {
                if (dmPickupAddressEntry.name.length() > 10) {
                    str = dmPickupAddressEntry.name.substring(0, 10) + "...";
                } else {
                    str = dmPickupAddressEntry.name;
                }
                this.c.setText(str);
            } else {
                this.c.setText(dmPickupAddressEntry.name);
            }
            this.g.setText(dmPickupAddressEntry.address);
            if (!TextUtils.isEmpty(dmPickupAddressEntry.businessHours)) {
                this.h.setText("时间：" + dmPickupAddressEntry.businessHours);
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dmPickupAddressEntry.tel)) {
                this.i.setVisibility(0);
                this.i.setText("电话：" + dmPickupAddressEntry.tel);
                return;
            }
            this.i.setVisibility(8);
        }
    }
}
