package cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.user.C0529c;
import cn.damai.trade.R$id;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailRefundPopWindowBean;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity.OrderDetailActivity;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cb1;
import tb.mo1;
import tb.pp2;
import tb.r30;
import tb.t60;
import tb.xr;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailRefundView {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private LinearLayout b;
    private Context c;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailRefundView$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2215a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ boolean b;
        final /* synthetic */ String c;
        final /* synthetic */ Context d;

        View$OnClickListenerC2215a(OrderDetailRefundView orderDetailRefundView, String str, boolean z, String str2, Context context) {
            this.a = str;
            this.b = z;
            this.c = str2;
            this.d = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1696086388")) {
                ipChange.ipc$dispatch("1696086388", new Object[]{this, view});
                return;
            }
            C0529c.e().x(pp2.u().I(this.a));
            if (this.b) {
                xr.c(mo1.REFUND_CHECK_SERVICE, this.c);
                return;
            }
            Context context = this.d;
            if (context != null) {
                mo1.k(context, this.c);
            }
        }
    }

    public OrderDetailRefundView(Context context, View view) {
        this.c = context;
        this.b = (LinearLayout) view.findViewById(R$id.ll_tv_refund);
        this.a = (TextView) view.findViewById(R$id.tv_refund);
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) view.findViewById(R$id.tv_refund_icon);
        this.b.setVisibility(8);
    }

    private void c(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "211273098")) {
            ipChange.ipc$dispatch("211273098", new Object[]{this, str});
        } else {
            this.a.post(new Runnable() { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.ui.viewholder.OrderDetailRefundView.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "197643739")) {
                        ipChange2.ipc$dispatch("197643739", new Object[]{this});
                        return;
                    }
                    int[] iArr = new int[2];
                    OrderDetailRefundView.this.b.getLocationOnScreen(iArr);
                    float f = iArr[1];
                    int i = iArr[0];
                    cb1.b("OrderDetailRefundView", "showPop y = " + f);
                    float a = f + ((float) t60.a(OrderDetailRefundView.this.c, 27.0f));
                    OrderDetailRefundPopWindowBean orderDetailRefundPopWindowBean = new OrderDetailRefundPopWindowBean();
                    orderDetailRefundPopWindowBean.content = str;
                    orderDetailRefundPopWindowBean.parent = OrderDetailRefundView.this.b;
                    orderDetailRefundPopWindowBean.xlocation = DisplayMetrics.getwidthPixels(t60.b(OrderDetailRefundView.this.c)) - t60.a(OrderDetailRefundView.this.c, 15.0f);
                    orderDetailRefundPopWindowBean.ylocation = (int) a;
                    xr.c(OrderDetailActivity.REFUND_POPWINDPW, orderDetailRefundPopWindowBean);
                }
            });
        }
    }

    public void d(Context context, boolean z, String str, String str2, String str3, String str4, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1422079339")) {
            ipChange.ipc$dispatch("-1422079339", new Object[]{this, context, Boolean.valueOf(z), str, str2, str3, str4, Boolean.valueOf(z2)});
        } else if (z && !TextUtils.isEmpty(str)) {
            this.a.setText(str4);
            this.b.setVisibility(0);
            this.a.setOnClickListener(new View$OnClickListenerC2215a(this, str3, z2, str, context));
            if (mo1.c(str2)) {
                z20.T(OrderDetailActivity.REFUND_POPWINDPW, r30.a("yyyyMMdd"));
                c(str2);
            }
        } else {
            this.b.setVisibility(8);
        }
    }
}
