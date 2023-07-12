package tb;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class on extends cp2<String> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView d;

    public on(Context context) {
        super(context);
    }

    @Override // tb.cp2
    public int a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1518848753") ? ((Integer) ipChange.ipc$dispatch("1518848753", new Object[]{this})).intValue() : R$layout.live_content_detail_date;
    }

    @Override // tb.cp2
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1888989502")) {
            ipChange.ipc$dispatch("1888989502", new Object[]{this});
            return;
        }
        TextView textView = (TextView) this.b.findViewById(R$id.live_content_detail_date);
        this.d = textView;
        textView.setOnClickListener(this);
    }

    public void d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-137855250")) {
            ipChange.ipc$dispatch("-137855250", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
            c(false);
        } else {
            this.d.setText(str);
            c(true);
        }
    }
}
