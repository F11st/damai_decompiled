package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$color;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailProgressBean;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailProgressChild;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderDetailProgressViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private DMIconFontTextView b;
    private View c;
    private LinearLayout d;
    private TextView e;
    private LinearLayout f;
    private Context g;
    private LayoutInflater h;

    public OrderDetailProgressViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.order_detail_progress_item, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.g = context;
        this.h = layoutInflater;
        this.a = this.itemView.findViewById(R$id.oval);
        this.b = (DMIconFontTextView) this.itemView.findViewById(R$id.icon_oval);
        this.c = this.itemView.findViewById(R$id.line);
        this.d = (LinearLayout) this.itemView.findViewById(R$id.ll_progress_container);
        this.e = (TextView) this.itemView.findViewById(R$id.tv_nodeName);
        this.f = (LinearLayout) this.itemView.findViewById(R$id.ll_progress);
    }

    public void a(OrderDetailProgressBean orderDetailProgressBean, boolean z) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-123298735")) {
            ipChange.ipc$dispatch("-123298735", new Object[]{this, orderDetailProgressBean, Boolean.valueOf(z)});
        } else if (orderDetailProgressBean == null) {
        } else {
            this.e.setText(orderDetailProgressBean.nodeName);
            int i2 = orderDetailProgressBean.nodeStatus;
            if (i2 == 1) {
                this.b.setVisibility(8);
                this.a.setVisibility(0);
                this.a.setBackgroundResource(R$drawable.bg_border_oval_999);
                this.c.setBackgroundColor(ContextCompat.getColor(this.g, R$color.color_999999));
                this.e.setTextColor(ContextCompat.getColor(this.g, R$color.color_666666));
            } else if (i2 == 2) {
                this.b.setVisibility(0);
                this.a.setVisibility(8);
                this.c.setBackgroundColor(ContextCompat.getColor(this.g, R$color.color_FF2D79));
                this.e.setTextColor(ContextCompat.getColor(this.g, R$color.color_000000));
            } else if (i2 == 3) {
                this.b.setVisibility(8);
                this.a.setVisibility(0);
                this.a.setBackgroundResource(R$drawable.bg_border_oval_red);
                this.c.setBackgroundColor(ContextCompat.getColor(this.g, R$color.color_FF2D79));
                this.e.setTextColor(ContextCompat.getColor(this.g, R$color.color_999999));
            }
            this.c.setVisibility(!z ? 0 : 8);
            int e = wh2.e(orderDetailProgressBean.orderProgressItems);
            if (e <= 0 && TextUtils.isEmpty(orderDetailProgressBean.nodeName)) {
                this.d.setVisibility(8);
                return;
            }
            this.d.setVisibility(0);
            if (e > 0) {
                this.f.setVisibility(0);
                this.f.removeAllViews();
                int i3 = 0;
                while (i3 < e) {
                    OrderDetailProgressChild orderDetailProgressChild = orderDetailProgressBean.orderProgressItems.get(i3);
                    if (orderDetailProgressChild != null) {
                        View inflate = this.h.inflate(R$layout.order_detail_progress_child_item, (ViewGroup) null);
                        inflate.findViewById(R$id.line_item).setVisibility(i3 != 0 ? 0 : 8);
                        TextView textView = (TextView) inflate.findViewById(R$id.tv_itemText);
                        TextView textView2 = (TextView) inflate.findViewById(R$id.tv_itemData);
                        View findViewById = inflate.findViewById(R$id.line_center);
                        if (TextUtils.isEmpty(orderDetailProgressChild.itemText)) {
                            textView.setVisibility(8);
                            i = 0;
                        } else {
                            textView.setText(orderDetailProgressChild.itemText);
                            textView.setVisibility(0);
                            i = 1;
                        }
                        if (TextUtils.isEmpty(orderDetailProgressChild.itemDate)) {
                            textView2.setVisibility(8);
                        } else {
                            i++;
                            textView2.setVisibility(0);
                            textView2.setText(orderDetailProgressChild.itemDate);
                            if (orderDetailProgressChild.getHighLight()) {
                                Context context = this.g;
                                int i4 = R$color.color_000000;
                                textView.setTextColor(ContextCompat.getColor(context, i4));
                                textView2.setTextColor(ContextCompat.getColor(this.g, i4));
                            } else if (orderDetailProgressBean.noStartNode()) {
                                Context context2 = this.g;
                                int i5 = R$color.color_666666;
                                textView.setTextColor(ContextCompat.getColor(context2, i5));
                                textView2.setTextColor(ContextCompat.getColor(this.g, i5));
                            } else {
                                Context context3 = this.g;
                                int i6 = R$color.color_999999;
                                textView.setTextColor(ContextCompat.getColor(context3, i6));
                                textView2.setTextColor(ContextCompat.getColor(this.g, i6));
                            }
                        }
                        if (i > 1) {
                            findViewById.setVisibility(0);
                        } else {
                            findViewById.setVisibility(8);
                        }
                        this.f.addView(inflate);
                    }
                    i3++;
                }
                return;
            }
            this.f.setVisibility(8);
        }
    }
}
