package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0529c;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cs;
import tb.pp2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderDetailInvoiceViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private DMIconFontTextView b;
    private TextView c;
    private Context d;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailInvoiceViewHolder$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2199a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        View$OnClickListenerC2199a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1889032107")) {
                ipChange.ipc$dispatch("-1889032107", new Object[]{this, view});
                return;
            }
            C0529c.e().x(pp2.u().j1(this.a, this.b));
            Bundle bundle = new Bundle();
            bundle.putString("orderId", this.b);
            bundle.putString("projectId", this.a);
            DMNav.from(OrderDetailInvoiceViewHolder.this.d).withExtras(bundle).forResult(1005).toUri(NavUri.b(cs.k));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailInvoiceViewHolder$b */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2200b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        View$OnClickListenerC2200b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "222258262")) {
                ipChange.ipc$dispatch("222258262", new Object[]{this, view});
                return;
            }
            C0529c.e().x(pp2.u().k1(this.a, this.b));
            Bundle bundle = new Bundle();
            bundle.putString("orderId", this.b);
            DMNav.from(OrderDetailInvoiceViewHolder.this.d).withExtras(bundle).toUri(NavUri.b(cs.l));
        }
    }

    public OrderDetailInvoiceViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.order_detail_invoice_item, (ViewGroup) null));
        this.d = context;
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.a = (TextView) this.itemView.findViewById(R$id.tv_invoice_state);
        this.b = (DMIconFontTextView) this.itemView.findViewById(R$id.tv_invoice_state_more);
        this.c = (TextView) this.itemView.findViewById(R$id.tv_invoice_tip);
    }

    public void b(String str, String str2, int i, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2078579743")) {
            ipChange.ipc$dispatch("2078579743", new Object[]{this, str, str2, Integer.valueOf(i), str3, str4});
        } else if (i == 1) {
            this.a.setVisibility(8);
            this.b.setVisibility(8);
            this.c.setVisibility(0);
            this.c.setText(str4);
            this.itemView.setClickable(false);
            this.itemView.setOnClickListener(null);
        } else if (i == 2) {
            this.b.setVisibility(0);
            this.a.setVisibility(0);
            this.a.setText(str3);
            this.c.setVisibility(8);
            this.itemView.setClickable(true);
            this.itemView.setOnClickListener(new View$OnClickListenerC2199a(str2, str));
        } else if (i == 3 || i == 4) {
            this.b.setVisibility(0);
            this.a.setVisibility(0);
            this.c.setVisibility(0);
            this.a.setText(str3);
            this.c.setText(str4);
            this.itemView.setClickable(true);
            this.itemView.setOnClickListener(new View$OnClickListenerC2200b(str2, str));
        } else if (i != 5) {
        } else {
            this.b.setVisibility(8);
            this.a.setVisibility(0);
            this.c.setVisibility(0);
            this.a.setText(str3);
            this.c.setText(str4);
            this.itemView.setClickable(false);
            this.itemView.setOnClickListener(null);
        }
    }
}
