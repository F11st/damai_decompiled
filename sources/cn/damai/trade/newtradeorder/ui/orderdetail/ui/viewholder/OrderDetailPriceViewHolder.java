package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailAmountDetail;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailPricesInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderDetailPriceViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private TextView b;
    private TextView c;
    private LinearLayout d;
    private LayoutInflater e;
    private Context f;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OrderDetailAmountDetail a;

        a(OrderDetailAmountDetail orderDetailAmountDetail) {
            this.a = orderDetailAmountDetail;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-497905551")) {
                ipChange.ipc$dispatch("-497905551", new Object[]{this, view});
            } else {
                OrderDetailPriceViewHolder.this.d(this.a.jumpUrl);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OrderDetailAmountDetail a;

        b(OrderDetailAmountDetail orderDetailAmountDetail) {
            this.a = orderDetailAmountDetail;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1613384818")) {
                ipChange.ipc$dispatch("1613384818", new Object[]{this, view});
            } else {
                OrderDetailPriceViewHolder.this.d(this.a.jumpUrl);
            }
        }
    }

    public OrderDetailPriceViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.order_detail_price, (ViewGroup) null));
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
        this.f = context;
        this.itemView.setLayoutParams(layoutParams);
        this.e = layoutInflater;
        c(this.itemView);
    }

    private void c(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "313457561")) {
            ipChange.ipc$dispatch("313457561", new Object[]{this, view});
            return;
        }
        this.a = view.findViewById(R$id.line_price_list);
        this.b = (TextView) view.findViewById(R$id.tv_pay_price);
        this.c = (TextView) view.findViewById(R$id.tv_pay_desc);
        this.d = (LinearLayout) view.findViewById(R$id.ll_price_list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2024365888")) {
            ipChange.ipc$dispatch("2024365888", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            DMNav.from(this.f).toUri(str);
        }
    }

    private void e(OrderDetailAmountDetail orderDetailAmountDetail, ImageView imageView, TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1932745577")) {
            ipChange.ipc$dispatch("-1932745577", new Object[]{this, orderDetailAmountDetail, imageView, textView});
            return;
        }
        if (!TextUtils.isEmpty(orderDetailAmountDetail.icon)) {
            imageView.setVisibility(0);
            DMImageCreator c = cn.damai.common.image.a.b().c(orderDetailAmountDetail.icon);
            int i = R$drawable.commonbusiness_help_gray_icon;
            c.i(i).c(i).g(imageView);
        } else {
            imageView.setVisibility(8);
        }
        textView.setOnClickListener(new a(orderDetailAmountDetail));
        imageView.setOnClickListener(new b(orderDetailAmountDetail));
    }

    public void b(OrderDetailPricesInfo orderDetailPricesInfo, List<OrderDetailAmountDetail> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1176108782")) {
            ipChange.ipc$dispatch("1176108782", new Object[]{this, orderDetailPricesInfo, list});
        } else if (orderDetailPricesInfo != null) {
            this.c.setText(orderDetailPricesInfo.displayAmountDesc);
            TextView textView = this.b;
            textView.setText("¥" + orderDetailPricesInfo.displayAmount);
            int e = wh2.e(list);
            if (e > 0) {
                this.a.setVisibility(0);
                this.d.setVisibility(0);
                this.d.removeAllViews();
                for (int i = 0; i < e; i++) {
                    View inflate = this.e.inflate(R$layout.order_detail_price_info, (ViewGroup) null);
                    TextView textView2 = (TextView) inflate.findViewById(R$id.tv_project_price_desc);
                    textView2.setText(list.get(i).desc);
                    ((TextView) inflate.findViewById(R$id.tv_project_price)).setText(list.get(i).amount);
                    e(list.get(i), (ImageView) inflate.findViewById(R$id.tv_project_price_icon), textView2);
                    this.d.addView(inflate);
                }
                return;
            }
            this.a.setVisibility(8);
            this.d.setVisibility(8);
        }
    }
}
