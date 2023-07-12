package tb;

import android.view.View;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class lo2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private TextView b;

    public lo2(View view) {
        View findViewById = view.findViewById(R$id.online_card_title_layout);
        this.a = findViewById;
        this.b = (TextView) findViewById.findViewById(R$id.online_card_title);
    }

    public void a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-531370935")) {
            ipChange.ipc$dispatch("-531370935", new Object[]{this, str});
        } else {
            this.b.setText(str);
        }
    }

    public void b(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "674760767")) {
            ipChange.ipc$dispatch("674760767", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.a.setVisibility(z ? 0 : 8);
        }
    }
}
