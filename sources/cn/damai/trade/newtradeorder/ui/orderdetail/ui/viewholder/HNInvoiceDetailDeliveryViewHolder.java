package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class HNInvoiceDetailDeliveryViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private TextView b;

    public HNInvoiceDetailDeliveryViewHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.order_hn_invoice_detail_delivery, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        b(this.itemView);
    }

    private void b(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "752303280")) {
            ipChange.ipc$dispatch("752303280", new Object[]{this, view});
            return;
        }
        this.a = (TextView) view.findViewById(R$id.tv_delivery_num);
        this.b = (TextView) view.findViewById(R$id.tv_delivery_name);
    }

    public void a(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-379134296")) {
            ipChange.ipc$dispatch("-379134296", new Object[]{this, str, str2, str3});
        } else if (str == null || str2 == null || str3 == null) {
        } else {
            this.a.setText(str);
            this.b.setText(str2);
        }
    }
}
