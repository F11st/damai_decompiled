package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.InvoicesTransInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class InvoiceDetailDeliveryViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private TextView b;
    private TextView c;

    public InvoiceDetailDeliveryViewHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.order_invoice_detail_delivery, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        b(this.itemView);
    }

    private void b(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "817959786")) {
            ipChange.ipc$dispatch("817959786", new Object[]{this, view});
            return;
        }
        this.a = (TextView) view.findViewById(R$id.tv_delivery_num);
        this.b = (TextView) view.findViewById(R$id.tv_delivery_name);
        this.c = (TextView) view.findViewById(R$id.tv_delivery_state);
    }

    public void a(InvoicesTransInfo invoicesTransInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1713562574")) {
            ipChange.ipc$dispatch("1713562574", new Object[]{this, invoicesTransInfo});
        } else if (invoicesTransInfo == null) {
        } else {
            this.a.setText(invoicesTransInfo.expressNo);
            this.b.setText(invoicesTransInfo.expressName);
            this.c.setText(invoicesTransInfo.state);
        }
    }
}
