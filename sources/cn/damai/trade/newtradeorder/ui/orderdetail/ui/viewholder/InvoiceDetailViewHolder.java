package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.InvoiceDetailInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class InvoiceDetailViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private TextView b;
    private LinearLayout c;
    private TextView d;
    private LinearLayout e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;

    public InvoiceDetailViewHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.order_invoice_detail_info, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        b(this.itemView);
    }

    private void b(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1674110722")) {
            ipChange.ipc$dispatch("-1674110722", new Object[]{this, view});
            return;
        }
        this.a = (TextView) view.findViewById(R$id.tv_invoice_type);
        this.b = (TextView) view.findViewById(R$id.tv_invoice_title);
        this.c = (LinearLayout) view.findViewById(R$id.ll_invoice_company_name);
        this.d = (TextView) view.findViewById(R$id.tv_company_name);
        this.e = (LinearLayout) view.findViewById(R$id.ll_invoice_company_tax);
        this.f = (TextView) view.findViewById(R$id.tv_company_tax);
        this.g = (TextView) view.findViewById(R$id.tv_invoice_delivery_way);
        this.h = (TextView) view.findViewById(R$id.tv_invoice_delivery_user_key);
        this.i = (TextView) view.findViewById(R$id.tv_invoice_delivery_user_value);
        this.j = (TextView) view.findViewById(R$id.tv_invoice_delivery_phone_value);
        this.k = (TextView) view.findViewById(R$id.tv_invoice_delivery_address_key);
        this.l = (TextView) view.findViewById(R$id.tv_invoice_delivery_address_value);
        this.m = (TextView) view.findViewById(R$id.tv_invoice_state);
    }

    public void a(InvoiceDetailInfo invoiceDetailInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "624084926")) {
            ipChange.ipc$dispatch("624084926", new Object[]{this, invoiceDetailInfo});
        } else if (invoiceDetailInfo == null) {
        } else {
            this.a.setText(invoiceDetailInfo.typeMess);
            this.b.setText(invoiceDetailInfo.typeName);
            if ("2".equals(invoiceDetailInfo.typeId)) {
                this.c.setVisibility(0);
                this.e.setVisibility(0);
                this.d.setText(invoiceDetailInfo.companyName);
                this.f.setText(invoiceDetailInfo.companyTax);
            } else {
                this.c.setVisibility(8);
                this.e.setVisibility(8);
            }
            this.g.setText(invoiceDetailInfo.transName);
            if ("1".equals(invoiceDetailInfo.transId)) {
                this.h.setText("收件人名：");
                this.k.setText("收件地址：");
            } else {
                this.h.setText("自取人名：");
                this.k.setText("自取地址：");
            }
            this.i.setText(invoiceDetailInfo.name);
            this.j.setText(invoiceDetailInfo.phone);
            this.l.setText(invoiceDetailInfo.addressInfo);
            this.m.setText(invoiceDetailInfo.state);
        }
    }
}
