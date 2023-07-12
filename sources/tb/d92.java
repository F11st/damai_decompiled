package tb;

import android.app.Activity;
import android.view.View;
import android.view.ViewStub;
import cn.damai.seat.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class d92 implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private ViewStub a;
    private View b;

    public d92(Activity activity, ViewStub viewStub) {
        this.a = viewStub;
    }

    private void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2134800803")) {
            ipChange.ipc$dispatch("-2134800803", new Object[]{this});
        } else if (this.b == null) {
            View inflate = this.a.inflate();
            this.b = inflate;
            inflate.findViewById(R$id.tb_seat_tip_close).setOnClickListener(this);
        }
    }

    private void c(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1957977574")) {
            ipChange.ipc$dispatch("1957977574", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        View view = this.b;
        if (view == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public void b(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "647960238")) {
            ipChange.ipc$dispatch("647960238", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            a();
            c(true);
        } else {
            c(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1598012300")) {
            ipChange.ipc$dispatch("-1598012300", new Object[]{this, view});
        } else {
            c(false);
        }
    }
}
