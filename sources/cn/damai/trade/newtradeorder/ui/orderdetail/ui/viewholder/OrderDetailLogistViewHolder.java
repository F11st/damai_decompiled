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
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailStatusBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.mo1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderDetailLogistViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private LinearLayout a;
    private TextView b;
    private TextView c;
    private Context d;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailLogistViewHolder$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2201a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        View$OnClickListenerC2201a(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-937653042")) {
                ipChange.ipc$dispatch("-937653042", new Object[]{this, view});
            } else {
                mo1.d(OrderDetailLogistViewHolder.this.d, this.a, false);
            }
        }
    }

    public OrderDetailLogistViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.order_detail_delivery_logist, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.d = context;
        c(this.itemView);
    }

    private void c(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2052945853")) {
            ipChange.ipc$dispatch("2052945853", new Object[]{this, view});
            return;
        }
        this.a = (LinearLayout) view.findViewById(R$id.ll_delivery_logist);
        this.b = (TextView) view.findViewById(R$id.tv_logist_address);
        this.c = (TextView) view.findViewById(R$id.tv_logist_time);
    }

    public void b(OrderDetailStatusBean orderDetailStatusBean, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1046522814")) {
            ipChange.ipc$dispatch("-1046522814", new Object[]{this, orderDetailStatusBean, str});
        } else if (orderDetailStatusBean == null || TextUtils.isEmpty(orderDetailStatusBean.logisticsDesc) || TextUtils.isEmpty(orderDetailStatusBean.logisticsTimeStr)) {
        } else {
            this.a.setBackgroundColor(ContextCompat.getColor(this.d, R$color.white));
            this.b.setText(orderDetailStatusBean.logisticsDesc);
            this.c.setText(orderDetailStatusBean.logisticsTimeStr);
            this.a.setOnClickListener(new View$OnClickListenerC2201a(str));
        }
    }
}
