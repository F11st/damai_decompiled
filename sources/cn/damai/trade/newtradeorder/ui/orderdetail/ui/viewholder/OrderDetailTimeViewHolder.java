package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.pp2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderDetailTimeViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private TextView b;
    private LinearLayout c;
    private LayoutInflater d;
    private Context e;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-347963819")) {
                ipChange.ipc$dispatch("-347963819", new Object[]{this, view});
                return;
            }
            String str = (String) view.getTag();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ((ClipboardManager) OrderDetailTimeViewHolder.this.e.getSystemService("clipboard")).setText(str);
            ToastUtil.i("已成功复制到剪切板");
            c.e().x(pp2.u().B(z20.E(), str));
        }
    }

    public OrderDetailTimeViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.order_detail_time_item, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.d = layoutInflater;
        this.e = context;
        c(this.itemView);
    }

    private void c(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1732102736")) {
            ipChange.ipc$dispatch("-1732102736", new Object[]{this, view});
            return;
        }
        this.a = (TextView) view.findViewById(R$id.tv_order_id);
        this.b = (TextView) view.findViewById(R$id.tv_order_copy_id);
        this.c = (LinearLayout) view.findViewById(R$id.ll_order_time_container);
        this.b.setOnClickListener(new a());
    }

    public void b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1697925782")) {
            ipChange.ipc$dispatch("-1697925782", new Object[]{this, str, str2, str3, str4, str5, str6, str7});
            return;
        }
        this.b.setTag(str);
        TextView textView = this.a;
        textView.setText("订单编号：" + str);
        this.c.removeAllViews();
        if (!TextUtils.isEmpty(str2)) {
            View inflate = this.d.inflate(R$layout.order_detail_time_txt_item, (ViewGroup) null);
            ((TextView) inflate.findViewById(R$id.tv_order_time)).setText("创建时间：" + str2);
            this.c.addView(inflate);
        }
        if (!TextUtils.isEmpty(str3)) {
            View inflate2 = this.d.inflate(R$layout.order_detail_time_txt_item, (ViewGroup) null);
            ((TextView) inflate2.findViewById(R$id.tv_order_time)).setText("付款时间：" + str3);
            this.c.addView(inflate2);
        }
        if (!TextUtils.isEmpty(str4)) {
            View inflate3 = this.d.inflate(R$layout.order_detail_time_txt_item, (ViewGroup) null);
            ((TextView) inflate3.findViewById(R$id.tv_order_time)).setText("支付方式：" + str4);
            this.c.addView(inflate3);
        }
        if (!TextUtils.isEmpty(str5)) {
            View inflate4 = this.d.inflate(R$layout.order_detail_time_txt_item, (ViewGroup) null);
            ((TextView) inflate4.findViewById(R$id.tv_order_time)).setText("支付流水号：" + str5);
            this.c.addView(inflate4);
        }
        if (!TextUtils.isEmpty(str6)) {
            View inflate5 = this.d.inflate(R$layout.order_detail_time_txt_item, (ViewGroup) null);
            ((TextView) inflate5.findViewById(R$id.tv_order_time)).setText("发货时间：" + str6);
            this.c.addView(inflate5);
        }
        if (!TextUtils.isEmpty(str7)) {
            View inflate6 = this.d.inflate(R$layout.order_detail_time_txt_item, (ViewGroup) null);
            ((TextView) inflate6.findViewById(R$id.tv_order_time)).setText("成交时间：" + str7);
            this.c.addView(inflate6);
        }
        LinearLayout linearLayout = this.c;
        linearLayout.setVisibility(linearLayout.getChildCount() <= 0 ? 8 : 0);
    }
}
