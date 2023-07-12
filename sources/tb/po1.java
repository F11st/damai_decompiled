package tb;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.common.user.C0529c;
import cn.damai.trade.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class po1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;

    /* compiled from: Taobao */
    /* renamed from: tb.po1$a */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC9560a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ Context b;
        final /* synthetic */ String c;

        View$OnClickListenerC9560a(po1 po1Var, String str, Context context, String str2) {
            this.a = str;
            this.b = context;
            this.c = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1397022719")) {
                ipChange.ipc$dispatch("1397022719", new Object[]{this, view});
                return;
            }
            C0529c.e().x(pp2.u().u1(this.a));
            mo1.k(this.b, this.c);
        }
    }

    public po1(View view) {
        TextView textView = (TextView) view.findViewById(R$id.tv_sell_detail);
        this.a = textView;
        textView.setVisibility(8);
    }

    public void a(Context context, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1633178880")) {
            ipChange.ipc$dispatch("1633178880", new Object[]{this, context, str, str2});
        } else if (context != null && !TextUtils.isEmpty(str)) {
            this.a.setVisibility(0);
            this.a.setOnClickListener(new View$OnClickListenerC9560a(this, str2, context, str));
        } else {
            this.a.setVisibility(8);
        }
    }
}
