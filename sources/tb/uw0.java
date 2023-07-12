package tb;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import cn.damai.trade.R$color;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.hn.HnInvoiceApplyInfoResult;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class uw0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private View b;
    private TextView c;
    private TextView d;

    public uw0(Context context, LayoutInflater layoutInflater) {
        this.a = context;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        View inflate = layoutInflater.inflate(R$layout.hn_order_create_invoice_order_info, (ViewGroup) null);
        this.b = inflate;
        inflate.setLayoutParams(layoutParams);
        b(this.b);
    }

    private void b(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-474398891")) {
            ipChange.ipc$dispatch("-474398891", new Object[]{this, view});
            return;
        }
        this.c = (TextView) view.findViewById(R$id.tv_order_number);
        this.d = (TextView) view.findViewById(R$id.tv_order_money);
    }

    public View a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-616157236") ? (View) ipChange.ipc$dispatch("-616157236", new Object[]{this}) : this.b;
    }

    public uw0 c(HnInvoiceApplyInfoResult hnInvoiceApplyInfoResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-475680490")) {
            return (uw0) ipChange.ipc$dispatch("-475680490", new Object[]{this, hnInvoiceApplyInfoResult});
        }
        if (hnInvoiceApplyInfoResult == null) {
            return this;
        }
        this.c.setText(hnInvoiceApplyInfoResult.orderId);
        String str = "¥" + hnInvoiceApplyInfoResult.amount + " (" + hnInvoiceApplyInfoResult.itemMessage + jn1.BRACKET_END_STR;
        SpannableString spannableString = new SpannableString(str);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ContextCompat.getColor(this.a, R$color.main_color));
        int indexOf = str.indexOf(jn1.BRACKET_START_STR);
        spannableString.setSpan(foregroundColorSpan, 0, indexOf, 17);
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(1.2f);
        spannableString.setSpan(relativeSizeSpan, 0, 1, 17);
        int indexOf2 = str.indexOf(".");
        if (indexOf2 >= 0) {
            spannableString.setSpan(relativeSizeSpan, indexOf2, indexOf, 33);
        }
        RelativeSizeSpan relativeSizeSpan2 = new RelativeSizeSpan(1.5f);
        if (indexOf2 >= 0) {
            spannableString.setSpan(relativeSizeSpan2, 1, indexOf2, 17);
        } else {
            spannableString.setSpan(relativeSizeSpan2, 1, indexOf, 17);
        }
        this.d.setText(spannableString);
        return this;
    }
}
