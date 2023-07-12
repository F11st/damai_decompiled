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
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.HNInvoiceTrans;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m62;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class HNInvoiceDetailLogisticsViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private TextView b;
    private View c;
    private View d;
    private View e;
    private ImageView f;
    private int g;
    private int h;
    private Context i;

    public HNInvoiceDetailLogisticsViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.order_hn_invoice_detail_express, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        b(this.itemView);
        this.i = context;
        this.g = m62.a(context, 18.0f);
        this.h = m62.a(context, 9.0f);
    }

    private void b(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1421433699")) {
            ipChange.ipc$dispatch("1421433699", new Object[]{this, view});
            return;
        }
        this.a = (TextView) view.findViewById(R$id.tv_express_info);
        this.b = (TextView) view.findViewById(R$id.tv_express_time);
        this.f = (ImageView) view.findViewById(R$id.iv_express_state);
        this.c = view.findViewById(R$id.express_line);
        this.d = view.findViewById(R$id.express_line2);
        this.e = view.findViewById(R$id.express_line3);
    }

    public void a(HNInvoiceTrans hNInvoiceTrans, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "896465706")) {
            ipChange.ipc$dispatch("896465706", new Object[]{this, hNInvoiceTrans, Boolean.valueOf(z), Boolean.valueOf(z2)});
        } else if (hNInvoiceTrans == null) {
        } else {
            this.a.setText(hNInvoiceTrans.trackInfo);
            this.b.setText(hNInvoiceTrans.trackTime);
            if (z) {
                TextView textView = this.a;
                Context context = this.i;
                int i = R$color.color_111111;
                textView.setTextColor(ContextCompat.getColor(context, i));
                this.b.setTextColor(ContextCompat.getColor(this.i, i));
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f.getLayoutParams();
                int i2 = this.g;
                layoutParams.width = i2;
                layoutParams.height = i2;
                this.f.setLayoutParams(layoutParams);
                this.f.setImageResource(R$drawable.trade_invoice_express);
                if (z2) {
                    this.c.setVisibility(8);
                    this.d.setVisibility(8);
                } else {
                    this.c.setVisibility(8);
                    this.d.setVisibility(0);
                }
                this.e.setVisibility(8);
                return;
            }
            this.a.setTextColor(ContextCompat.getColor(this.i, R$color.color_888888));
            this.b.setTextColor(ContextCompat.getColor(this.i, R$color.color_AAAAAA));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f.getLayoutParams();
            int i3 = this.h;
            layoutParams2.width = i3;
            layoutParams2.height = i3;
            this.f.setLayoutParams(layoutParams2);
            this.f.setImageResource(R$drawable.trade_express_circle);
            if (z2) {
                this.e.setVisibility(0);
                this.c.setVisibility(8);
            } else {
                this.c.setVisibility(0);
                this.d.setVisibility(8);
            }
            this.d.setVisibility(8);
        }
    }
}
