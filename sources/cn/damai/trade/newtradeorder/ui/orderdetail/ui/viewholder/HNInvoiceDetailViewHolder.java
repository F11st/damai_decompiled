package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.HNDeliveryWay;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.HNInvoiceDetail;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.HNInvoiceStatusDTO;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.HNInvoiceTitleType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class HNInvoiceDetailViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private LinearLayout e;
    private TextView f;
    private TextView g;
    private LinearLayout h;
    private TextView i;
    private TextView j;
    private LinearLayout k;
    private TextView l;
    private TextView m;
    private LinearLayout n;
    private TextView o;
    private LinearLayout p;
    private TextView q;
    private LinearLayout r;
    private TextView s;
    private LinearLayout t;
    private TextView u;

    public HNInvoiceDetailViewHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.order_hn_invoice_detail_info, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        c(this.itemView);
        b(this.itemView);
    }

    private void b(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1212517549")) {
            ipChange.ipc$dispatch("-1212517549", new Object[]{this, view});
            return;
        }
        this.n = (LinearLayout) view.findViewById(R$id.rl_delivery_way);
        this.o = (TextView) view.findViewById(R$id.tv_invoice_delivery);
        this.p = (LinearLayout) view.findViewById(R$id.ll_delivery_name);
        this.q = (TextView) view.findViewById(R$id.tv_user_name);
        this.r = (LinearLayout) view.findViewById(R$id.ll_delivery_phone);
        this.s = (TextView) view.findViewById(R$id.tv_user_phone);
        this.t = (LinearLayout) view.findViewById(R$id.ll_delivery_address);
        this.u = (TextView) view.findViewById(R$id.tv_user_address);
    }

    private void c(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "903211076")) {
            ipChange.ipc$dispatch("903211076", new Object[]{this, view});
            return;
        }
        this.a = (TextView) view.findViewById(R$id.tv_invoice_type);
        this.b = (TextView) view.findViewById(R$id.tv_invoice_type_state);
        this.c = (TextView) view.findViewById(R$id.tv_invoice_tip);
        this.d = (TextView) view.findViewById(R$id.tv_invoice_title);
        this.e = (LinearLayout) view.findViewById(R$id.ll_company_title);
        this.f = (TextView) view.findViewById(R$id.tv_company_title_desc);
        this.g = (TextView) view.findViewById(R$id.tv_company_title);
        this.h = (LinearLayout) view.findViewById(R$id.ll_company_tax);
        this.i = (TextView) view.findViewById(R$id.tv_company_tax_desc);
        this.j = (TextView) view.findViewById(R$id.tv_company_tax);
        this.k = (LinearLayout) view.findViewById(R$id.ll_user_email);
        this.l = (TextView) view.findViewById(R$id.tv_user_email_desc);
        this.m = (TextView) view.findViewById(R$id.tv_user_email);
    }

    private void d(HNInvoiceTitleType hNInvoiceTitleType, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "839449042")) {
            ipChange.ipc$dispatch("839449042", new Object[]{this, hNInvoiceTitleType, str, str2, str3});
        } else if (hNInvoiceTitleType == null) {
        } else {
            this.e.setVisibility(0);
            this.h.setVisibility(0);
            this.k.setVisibility(0);
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            if (str3 == null) {
                str3 = "";
            }
            this.g.setText(str);
            this.j.setText(str2);
            this.m.setText(str3);
            int i = hNInvoiceTitleType.invoiceTitleType;
            if (i == 1) {
                this.f.setText("联系人:");
                this.i.setText("手机号:");
                this.l.setText("接收邮箱:");
            } else if (i != 2) {
            } else {
                this.f.setText("公司抬头:");
                this.i.setText("纳税识别号:");
                this.l.setText("接收邮箱:");
            }
        }
    }

    private void e(HNDeliveryWay hNDeliveryWay, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1154841053")) {
            ipChange.ipc$dispatch("-1154841053", new Object[]{this, hNDeliveryWay, str, str2, str3});
        } else if (hNDeliveryWay == null) {
        } else {
            this.o.setText(hNDeliveryWay.deliveryWayStr);
            if (str != null) {
                this.p.setVisibility(0);
                this.q.setText(str);
            } else {
                this.p.setVisibility(8);
            }
            if (str2 != null) {
                this.r.setVisibility(0);
                this.s.setText(str2);
            } else {
                this.r.setVisibility(8);
            }
            if (str3 != null) {
                this.t.setVisibility(0);
                this.u.setText(str3);
            } else {
                this.t.setVisibility(8);
            }
            this.n.setVisibility(0);
        }
    }

    private void f(HNInvoiceStatusDTO hNInvoiceStatusDTO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1765180544")) {
            ipChange.ipc$dispatch("1765180544", new Object[]{this, hNInvoiceStatusDTO});
        } else if (hNInvoiceStatusDTO == null) {
        } else {
            this.a.setText(hNInvoiceStatusDTO.invoiceTicketTypeStr);
            if (hNInvoiceStatusDTO.invoiceStatusStr != null) {
                this.b.setVisibility(0);
                this.b.setText(hNInvoiceStatusDTO.invoiceStatusStr);
            } else {
                this.b.setVisibility(8);
            }
            if (hNInvoiceStatusDTO.desc != null) {
                this.c.setVisibility(0);
                this.c.setText(hNInvoiceStatusDTO.desc);
                return;
            }
            this.c.setVisibility(0);
        }
    }

    private void g(HNInvoiceTitleType hNInvoiceTitleType, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1101747615")) {
            ipChange.ipc$dispatch("1101747615", new Object[]{this, hNInvoiceTitleType, str, str2});
        } else if (hNInvoiceTitleType == null) {
        } else {
            int i = hNInvoiceTitleType.invoiceTitleType;
            if (i == 1) {
                this.e.setVisibility(8);
                this.h.setVisibility(8);
                this.k.setVisibility(8);
            } else if (i != 2) {
            } else {
                this.k.setVisibility(8);
                this.e.setVisibility(0);
                this.h.setVisibility(0);
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                this.f.setText("公司抬头:");
                this.i.setText("纳税识别号:");
                this.g.setText(str);
                this.j.setText(str2);
            }
        }
    }

    public void a(HNInvoiceDetail hNInvoiceDetail) {
        HNInvoiceStatusDTO hNInvoiceStatusDTO;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1898864460")) {
            ipChange.ipc$dispatch("1898864460", new Object[]{this, hNInvoiceDetail});
        } else if (hNInvoiceDetail == null || (hNInvoiceStatusDTO = hNInvoiceDetail.invoiceStatusDTO) == null) {
        } else {
            int i = hNInvoiceStatusDTO.invoiceTicketType;
            f(hNInvoiceStatusDTO);
            HNInvoiceTitleType hNInvoiceTitleType = hNInvoiceDetail.invoiceTitleType;
            if (hNInvoiceTitleType == null) {
                return;
            }
            this.d.setText(hNInvoiceTitleType.invoiceTitleTypeStr);
            if (i == 2) {
                g(hNInvoiceTitleType, hNInvoiceDetail.title, hNInvoiceDetail.dutyParagraph);
                e(hNInvoiceDetail.deliveryWay, hNInvoiceDetail.consignee, hNInvoiceDetail.mobile, hNInvoiceDetail.address);
                return;
            }
            if (hNInvoiceTitleType.invoiceTitleType == 1) {
                d(hNInvoiceTitleType, hNInvoiceDetail.consignee, hNInvoiceDetail.mobile, hNInvoiceDetail.email);
            } else {
                d(hNInvoiceTitleType, hNInvoiceDetail.title, hNInvoiceDetail.dutyParagraph, hNInvoiceDetail.email);
            }
            this.n.setVisibility(8);
        }
    }
}
