package tb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import cn.damai.trade.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class vw0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;

    public vw0(LayoutInflater layoutInflater) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        View inflate = layoutInflater.inflate(R$layout.hn_order_create_invoice_pay_info, (ViewGroup) null);
        this.a = inflate;
        inflate.setLayoutParams(layoutParams);
    }

    public View a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1470154254") ? (View) ipChange.ipc$dispatch("-1470154254", new Object[]{this}) : this.a;
    }
}
