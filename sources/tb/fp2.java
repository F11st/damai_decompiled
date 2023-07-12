package tb;

import android.text.Html;
import android.view.View;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class fp2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private TextView b;
    private TextView c;

    public fp2(View view) {
        this.a = view;
        this.b = (TextView) view.findViewById(R$id.tv_city_num);
        this.c = (TextView) view.findViewById(R$id.tv_city);
    }

    public void a(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1043781909")) {
            ipChange.ipc$dispatch("1043781909", new Object[]{this, Integer.valueOf(i), str});
            return;
        }
        this.b.setText(Html.fromHtml("<font color=\"#ff2d79\">" + i + "</font>个巡演城市"));
        this.c.setText(str);
    }

    public void b(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-513292028")) {
            ipChange.ipc$dispatch("-513292028", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(8);
        }
    }
}
