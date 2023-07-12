package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$color;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailAddressBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import tb.mo1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderDetailAddressViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private LinearLayout a;
    private LinearLayout b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private Context g;
    private View h;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailAddressViewHolder$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2197a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2197a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-293850468")) {
                ipChange.ipc$dispatch("-293850468", new Object[]{this, view});
                return;
            }
            mo1.c = false;
            mo1.i(OrderDetailAddressViewHolder.this.g);
        }
    }

    public OrderDetailAddressViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.order_detail_address_item, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.g = context;
        this.a = (LinearLayout) this.itemView.findViewById(R$id.address_container);
        this.h = this.itemView.findViewById(R$id.line);
        this.b = (LinearLayout) this.itemView.findViewById(R$id.address_ex);
        this.c = (TextView) this.itemView.findViewById(R$id.tv_contacts_name);
        this.d = (TextView) this.itemView.findViewById(R$id.address_ex_text);
        this.e = (TextView) this.itemView.findViewById(R$id.tv_address_full);
        this.f = (TextView) this.itemView.findViewById(R$id.modify_address_btn);
    }

    public void b(OrderDetailAddressBean orderDetailAddressBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1301047072")) {
            ipChange.ipc$dispatch("-1301047072", new Object[]{this, orderDetailAddressBean});
        } else if (orderDetailAddressBean == null) {
        } else {
            this.a.setBackgroundColor(ContextCompat.getColor(this.g, R$color.white));
            this.e.setText(orderDetailAddressBean.fullAddress);
            this.c.setText(orderDetailAddressBean.userName + AltriaXLaunchTime.SPACE + orderDetailAddressBean.mobilePhone);
            this.f.setVisibility(orderDetailAddressBean.modify ? 0 : 8);
            this.f.setOnClickListener(new View$OnClickListenerC2197a());
            if (!TextUtils.isEmpty(orderDetailAddressBean.consigneeAddressTip)) {
                this.h.setVisibility(0);
                this.b.setVisibility(0);
                this.d.setText(orderDetailAddressBean.consigneeAddressTip);
                return;
            }
            this.h.setVisibility(8);
            this.b.setVisibility(8);
        }
    }
}
