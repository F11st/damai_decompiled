package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$color;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.InvoiceExpressInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m62;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class InvoiceDetailLogisticsViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private TextView b;
    private View c;
    private View d;
    private View e;
    private View f;
    private ImageView g;
    private int h;
    private int i;
    private Context j;

    public InvoiceDetailLogisticsViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.order_invoice_detail_express, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        b(this.itemView);
        this.j = context;
        this.h = m62.a(context, 18.0f);
        this.i = m62.a(context, 9.0f);
    }

    private void b(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-838181911")) {
            ipChange.ipc$dispatch("-838181911", new Object[]{this, view});
            return;
        }
        this.a = (TextView) view.findViewById(R$id.tv_express_info);
        this.b = (TextView) view.findViewById(R$id.tv_express_time);
        this.g = (ImageView) view.findViewById(R$id.iv_express_state);
        this.c = view.findViewById(R$id.express_line);
        this.d = view.findViewById(R$id.express_line2);
        this.e = view.findViewById(R$id.express_line3);
        this.f = view.findViewById(R$id.line_bottom);
    }

    public void a(InvoiceExpressInfo invoiceExpressInfo, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1723480160")) {
            ipChange.ipc$dispatch("1723480160", new Object[]{this, invoiceExpressInfo, Boolean.valueOf(z), Boolean.valueOf(z2)});
        } else if (invoiceExpressInfo == null) {
        } else {
            this.a.setText(invoiceExpressInfo.desc);
            this.b.setText(invoiceExpressInfo.updateDate);
            if (z) {
                this.a.setTextColor(ContextCompat.getColor(this.j, R$color.color_333333));
                this.b.setTextColor(ContextCompat.getColor(this.j, R$color.color_151515));
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.g.getLayoutParams();
                int i = this.h;
                layoutParams.width = i;
                layoutParams.height = i;
                this.g.setLayoutParams(layoutParams);
                this.g.setImageResource(R$drawable.trade_invoice_express);
                if (z2) {
                    this.c.setVisibility(8);
                    this.d.setVisibility(8);
                    this.f.setVisibility(8);
                } else {
                    this.c.setVisibility(8);
                    this.d.setVisibility(0);
                    this.f.setVisibility(0);
                }
                this.e.setVisibility(8);
                return;
            }
            this.a.setTextColor(ContextCompat.getColor(this.j, R$color.color_999999));
            this.b.setTextColor(ContextCompat.getColor(this.j, R$color.color_cccccc));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.g.getLayoutParams();
            int i2 = this.i;
            layoutParams2.width = i2;
            layoutParams2.height = i2;
            this.g.setLayoutParams(layoutParams2);
            this.g.setImageResource(R$drawable.trade_express_circle);
            if (z2) {
                this.e.setVisibility(0);
                this.c.setVisibility(8);
                this.f.setVisibility(8);
            } else {
                this.c.setVisibility(0);
                this.d.setVisibility(8);
                this.f.setVisibility(0);
            }
            this.d.setVisibility(8);
        }
    }
}
