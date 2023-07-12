package tb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.hn.HnInvoiceApplyInfoResult;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.hn.HnInvoiceDeliverySupport;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ww0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private TextView b;

    public ww0(LayoutInflater layoutInflater) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        View inflate = layoutInflater.inflate(R$layout.hn_order_create_invoice_type, (ViewGroup) null);
        this.a = inflate;
        inflate.setLayoutParams(layoutParams);
        this.b = (TextView) this.a.findViewById(R$id.tv_invoice_type);
    }

    public View a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1970341112") ? (View) ipChange.ipc$dispatch("-1970341112", new Object[]{this}) : this.a;
    }

    public ww0 b(HnInvoiceApplyInfoResult hnInvoiceApplyInfoResult) {
        List<HnInvoiceDeliverySupport> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1009921550")) {
            return (ww0) ipChange.ipc$dispatch("1009921550", new Object[]{this, hnInvoiceApplyInfoResult});
        }
        if (hnInvoiceApplyInfoResult != null && (list = hnInvoiceApplyInfoResult.deliveryWaySupports) != null && !list.isEmpty()) {
            this.b.setText(hnInvoiceApplyInfoResult.deliveryWaySupports.get(0).invoiceTicketTypeDesc);
        }
        return this;
    }
}
