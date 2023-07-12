package tb;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import cn.damai.common.user.C0529c;
import cn.damai.trade.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class bo1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;

    /* compiled from: Taobao */
    /* renamed from: tb.bo1$a */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC8969a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        View$OnClickListenerC8969a(bo1 bo1Var, String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1928548376")) {
                ipChange.ipc$dispatch("-1928548376", new Object[]{this, view});
                return;
            }
            C0529c.e().x(pp2.u().s1(this.a));
            xr.c(mo1.NOTIFY_CANCEL_SELL, "");
        }
    }

    public bo1(View view) {
        TextView textView = (TextView) view.findViewById(R$id.tv_cancel_sell);
        this.a = textView;
        textView.setVisibility(8);
    }

    public void a(Context context, boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-585565093")) {
            ipChange.ipc$dispatch("-585565093", new Object[]{this, context, Boolean.valueOf(z), str});
        } else if (context != null && z) {
            this.a.setVisibility(0);
            this.a.setOnClickListener(new View$OnClickListenerC8969a(this, str));
        } else {
            this.a.setVisibility(8);
        }
    }
}
