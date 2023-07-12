package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailAddressBean;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailAudienceInfo;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailDeliveryInfo;
import cn.damai.uikit.flowlayout.FlowLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderDetailDeliveryViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private FlowLayout b;
    private View c;
    private RelativeLayout d;
    private TextView e;
    private View f;
    private LinearLayout g;
    private TextView h;
    private TextView i;
    private View j;
    private View k;
    private LinearLayout l;
    private LinearLayout m;
    private LinearLayout n;
    private LayoutInflater o;
    private Context p;

    public OrderDetailDeliveryViewHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.order_detail_delivery_item, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.o = layoutInflater;
        this.p = layoutInflater.getContext();
        b(this.itemView);
    }

    private void b(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-105614807")) {
            ipChange.ipc$dispatch("-105614807", new Object[]{this, view});
            return;
        }
        this.a = (TextView) view.findViewById(R$id.tv_delivery_type);
        this.b = (FlowLayout) view.findViewById(R$id.fl_delivery_tag);
        this.c = view.findViewById(R$id.line_contacts);
        this.d = (RelativeLayout) view.findViewById(R$id.ll_delivery_contacts);
        this.e = (TextView) view.findViewById(R$id.tv_delivery_user_name);
        this.f = view.findViewById(R$id.line_email);
        this.g = (LinearLayout) view.findViewById(R$id.ll_delivery_email);
        this.h = (TextView) view.findViewById(R$id.tv_delivery_email);
        this.j = view.findViewById(R$id.ll_contacts_line);
        this.l = (LinearLayout) view.findViewById(R$id.ll_contacts_container);
        this.n = (LinearLayout) view.findViewById(R$id.ll_order_contacts);
        this.k = view.findViewById(R$id.delivery_ex_line);
        this.m = (LinearLayout) view.findViewById(R$id.delivery_ex);
        this.i = (TextView) view.findViewById(R$id.delivery_exp_text);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        this.k.setVisibility(8);
        this.m.setVisibility(8);
    }

    private void c(List<OrderDetailAudienceInfo> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1228919909")) {
            ipChange.ipc$dispatch("-1228919909", new Object[]{this, list});
            return;
        }
        int e = wh2.e(list);
        if (e == 0) {
            this.l.setVisibility(8);
            this.j.setVisibility(8);
            return;
        }
        this.n.removeAllViews();
        int i = 0;
        while (i < e) {
            View inflate = this.o.inflate(R$layout.order_detail_audience_item, (ViewGroup) null);
            ((TextView) inflate.findViewById(R$id.tv_audience_name)).setText(list.get(i).name);
            if (!TextUtils.isEmpty(list.get(i).hashIdentityNumber)) {
                ((TextView) inflate.findViewById(R$id.tv_audience_type)).setText(list.get(i).typeName + AltriaXLaunchTime.SPACE + list.get(i).hashIdentityNumber);
            } else {
                ((TextView) inflate.findViewById(R$id.tv_audience_type)).setText(list.get(i).typeName);
            }
            inflate.findViewById(R$id.line).setVisibility(i != e + (-1) ? 0 : 8);
            this.n.addView(inflate);
            i++;
        }
        this.j.setVisibility(0);
        this.l.setVisibility(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailAddressBean r7, int r8) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailDeliveryViewHolder.$ipChange
            java.lang.String r1 = "-2089253663"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L1e
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r5] = r6
            r2[r4] = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            r2[r3] = r7
            r0.ipc$dispatch(r1, r2)
            return
        L1e:
            if (r7 != 0) goto L21
            return
        L21:
            r0 = 8
            if (r8 != r4) goto L2b
            android.widget.RelativeLayout r8 = r6.d
            r8.setVisibility(r0)
            goto L40
        L2b:
            java.lang.String r8 = r7.userName
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L42
            java.lang.String r8 = r7.mobilePhone
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L42
            android.widget.RelativeLayout r8 = r6.d
            r8.setVisibility(r0)
        L40:
            r8 = 0
            goto L65
        L42:
            android.widget.TextView r8 = r6.e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r7.userName
            r1.append(r2)
            java.lang.String r2 = "  "
            r1.append(r2)
            java.lang.String r2 = r7.mobilePhone
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r8.setText(r1)
            android.widget.RelativeLayout r8 = r6.d
            r8.setVisibility(r5)
            r8 = 1
        L65:
            java.lang.String r1 = r7.email
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L7b
            android.widget.TextView r8 = r6.h
            java.lang.String r7 = r7.email
            r8.setText(r7)
            android.widget.LinearLayout r7 = r6.g
            r7.setVisibility(r5)
            r8 = 2
            goto L80
        L7b:
            android.widget.LinearLayout r7 = r6.g
            r7.setVisibility(r0)
        L80:
            if (r8 == 0) goto L9d
            if (r8 == r4) goto L92
            if (r8 == r3) goto L87
            goto La7
        L87:
            android.view.View r7 = r6.c
            r7.setVisibility(r5)
            android.view.View r7 = r6.f
            r7.setVisibility(r5)
            goto La7
        L92:
            android.view.View r7 = r6.c
            r7.setVisibility(r5)
            android.view.View r7 = r6.f
            r7.setVisibility(r0)
            goto La7
        L9d:
            android.view.View r7 = r6.c
            r7.setVisibility(r0)
            android.view.View r7 = r6.f
            r7.setVisibility(r0)
        La7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailDeliveryViewHolder.d(cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailAddressBean, int):void");
    }

    public void a(OrderDetailDeliveryInfo orderDetailDeliveryInfo, OrderDetailAddressBean orderDetailAddressBean, List<OrderDetailAudienceInfo> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "245026030")) {
            ipChange.ipc$dispatch("245026030", new Object[]{this, orderDetailDeliveryInfo, orderDetailAddressBean, list, str});
        } else if (orderDetailDeliveryInfo != null) {
            this.a.setText(orderDetailDeliveryInfo.deliveryMethod);
            int e = wh2.e(orderDetailDeliveryInfo.tags);
            if (e > 0) {
                this.b.removeAllViews();
                for (int i = 0; i < e; i++) {
                    TextView textView = (TextView) LayoutInflater.from(this.p).inflate(R$layout.layout_order_detail_tag, (ViewGroup) null);
                    textView.setText(orderDetailDeliveryInfo.tags.get(i));
                    this.b.addView(textView);
                }
                this.b.setVisibility(0);
            } else {
                this.b.setVisibility(8);
            }
            d(orderDetailAddressBean, orderDetailDeliveryInfo.deliveryId);
            c(list);
            if (!TextUtils.isEmpty(str)) {
                this.k.setVisibility(0);
                this.m.setVisibility(0);
                this.i.setText(str);
                return;
            }
            this.k.setVisibility(8);
            this.m.setVisibility(8);
        }
    }
}
