package cn.damai.trade.newtradeorder.ui.orderdetail.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.user.C0529c;
import cn.damai.trade.R$color;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailPayInfo;
import cn.damai.trade.newtradeorder.ui.orderdetail.model.OrderDetailPayViewModel;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.C9826vr;
import tb.pp2;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderDetailPayAdapter extends RecyclerView.Adapter<PayViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<OrderDetailPayInfo> a;
    private Context b;
    private OrderDetailPayViewModel c;
    private String d;
    private View.OnClickListener e = new View$OnClickListenerC2186a();
    DMIconFontTextView f;
    OrderDetailPayInfo g;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class PayViewHolder extends RecyclerView.ViewHolder {
        private View a;
        private ImageView b;
        private TextView c;
        private TextView d;
        private DMIconFontTextView e;

        public PayViewHolder(OrderDetailPayAdapter orderDetailPayAdapter, View view) {
            super(view);
            this.a = view;
            this.b = (ImageView) view.findViewById(R$id.iv_pay);
            this.c = (TextView) view.findViewById(R$id.tv_pay_title);
            this.d = (TextView) view.findViewById(R$id.text_promotion);
            DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) view.findViewById(R$id.cb_pay_check);
            this.e = dMIconFontTextView;
            dMIconFontTextView.setEnabled(false);
            this.e.setFocusable(false);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.orderdetail.ui.adapter.OrderDetailPayAdapter$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2186a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2186a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1820702850")) {
                ipChange.ipc$dispatch("-1820702850", new Object[]{this, view});
                return;
            }
            OrderDetailPayInfo orderDetailPayInfo = (OrderDetailPayInfo) view.getTag();
            if (orderDetailPayInfo == null) {
                return;
            }
            if (OrderDetailPayAdapter.this.c.isCoupon()) {
                C0529c.e().x(pp2.u().r(orderDetailPayInfo.payName, orderDetailPayInfo.mDemoIndex, OrderDetailPayAdapter.this.c.getProjectId(), OrderDetailPayAdapter.this.c.getOrderId()));
            }
            OrderDetailPayInfo orderDetailPayInfo2 = OrderDetailPayAdapter.this.g;
            if (orderDetailPayInfo2 != null) {
                String str = orderDetailPayInfo.payCode;
                if (str != null && str.equals(orderDetailPayInfo2.payCode) && orderDetailPayInfo.payName.equals(OrderDetailPayAdapter.this.g.payName)) {
                    return;
                }
                OrderDetailPayAdapter.this.g.isSelected = false;
            }
            OrderDetailPayAdapter orderDetailPayAdapter = OrderDetailPayAdapter.this;
            DMIconFontTextView dMIconFontTextView = orderDetailPayAdapter.f;
            if (dMIconFontTextView != null) {
                orderDetailPayAdapter.i(dMIconFontTextView);
            }
            orderDetailPayInfo.isSelected = true;
            OrderDetailPayAdapter orderDetailPayAdapter2 = OrderDetailPayAdapter.this;
            orderDetailPayAdapter2.g = orderDetailPayInfo;
            orderDetailPayAdapter2.f = (DMIconFontTextView) view.findViewById(R$id.cb_pay_check);
            OrderDetailPayAdapter orderDetailPayAdapter3 = OrderDetailPayAdapter.this;
            orderDetailPayAdapter3.f(orderDetailPayAdapter3.f);
            if (OrderDetailPayAdapter.this.c == null || OrderDetailPayAdapter.this.c.getPayChangeLiveData() == null) {
                return;
            }
            OrderDetailPayAdapter.this.c.getPayChangeLiveData().setValue(orderDetailPayInfo);
        }
    }

    public OrderDetailPayAdapter(FragmentActivity fragmentActivity, List<OrderDetailPayInfo> list) {
        this.a = list;
        this.b = fragmentActivity;
        OrderDetailPayViewModel orderDetailPayViewModel = (OrderDetailPayViewModel) ViewModelProviders.of(fragmentActivity).get(OrderDetailPayViewModel.class);
        this.c = orderDetailPayViewModel;
        if (orderDetailPayViewModel != null) {
            this.d = orderDetailPayViewModel.getOrderId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(DMIconFontTextView dMIconFontTextView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1893188986")) {
            ipChange.ipc$dispatch("-1893188986", new Object[]{this, dMIconFontTextView});
            return;
        }
        dMIconFontTextView.setText(R$string.iconfont_danxuanxuanzhong24);
        dMIconFontTextView.setTextColor(ContextCompat.getColor(this.b, R$color.color_FF2D79));
    }

    private void g(View view, String str, String str2, String str3, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-337066845")) {
            ipChange.ipc$dispatch("-337066845", new Object[]{this, view, str, str2, str3, Integer.valueOf(i)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("orderid", str);
        hashMap.put("item_id", str3);
        hashMap.put("titlelabel", str2);
        C0529c e = C0529c.e();
        e.G(view, "bottom", "pay_" + i, pp2.PROJECT_SCRIPTKILL_ORDRR_DETAILS_PAGE, hashMap);
    }

    private void h(View view, String str, String str2, String str3, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-171329055")) {
            ipChange.ipc$dispatch("-171329055", new Object[]{this, view, str, str2, str3, Integer.valueOf(i)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("orderid", str);
        hashMap.put("titlelabel", str2);
        hashMap.put("discount_name", str3);
        C0529c e = C0529c.e();
        e.G(view, "item_" + i, "order_info", pp2.ORDER_DETAL_PAGE, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(DMIconFontTextView dMIconFontTextView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-720549761")) {
            ipChange.ipc$dispatch("-720549761", new Object[]{this, dMIconFontTextView});
            return;
        }
        dMIconFontTextView.setText(R$string.iconfont_danxuanweixuanzhong24);
        dMIconFontTextView.setTextColor(ContextCompat.getColor(this.b, R$color.color_E0E0E0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onBindViewHolder(@NonNull PayViewHolder payViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-29193759")) {
            ipChange.ipc$dispatch("-29193759", new Object[]{this, payViewHolder, Integer.valueOf(i)});
            return;
        }
        OrderDetailPayInfo orderDetailPayInfo = this.a.get(i);
        if (orderDetailPayInfo == null) {
            return;
        }
        if (payViewHolder.b.getTag() instanceof C9826vr) {
            ((C9826vr) payViewHolder.b.getTag()).cancel();
        }
        DMImageCreator c = C0504a.b().c(orderDetailPayInfo.iconUrl);
        int i2 = R$drawable.uikit_user_default_icon;
        payViewHolder.b.setTag(c.i(i2).c(i2).g(payViewHolder.b));
        if (this.c.isCoupon()) {
            g(payViewHolder.c, this.d, orderDetailPayInfo.payName, this.c.getProjectId(), i);
        }
        TextView textView = payViewHolder.c;
        String str = orderDetailPayInfo.payName;
        if (str == null) {
            str = "";
        }
        textView.setText(str);
        if (TextUtils.isEmpty(orderDetailPayInfo.payTips)) {
            payViewHolder.d.setVisibility(8);
        } else {
            payViewHolder.d.setText(orderDetailPayInfo.payTips);
            payViewHolder.d.setVisibility(0);
            h(payViewHolder.d, this.d, orderDetailPayInfo.payName, orderDetailPayInfo.payTips, i);
        }
        if (orderDetailPayInfo.isSelected) {
            this.f = payViewHolder.e;
            this.g = orderDetailPayInfo;
            f(payViewHolder.e);
        } else {
            i(payViewHolder.e);
        }
        orderDetailPayInfo.mDemoIndex = i;
        payViewHolder.a.setTag(orderDetailPayInfo);
        payViewHolder.a.setOnClickListener(this.e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: e */
    public PayViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2082772917") ? (PayViewHolder) ipChange.ipc$dispatch("2082772917", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new PayViewHolder(this, LayoutInflater.from(this.b).inflate(R$layout.order_detail_pay_list, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1304771283") ? ((Integer) ipChange.ipc$dispatch("-1304771283", new Object[]{this})).intValue() : wh2.e(this.a);
    }
}
