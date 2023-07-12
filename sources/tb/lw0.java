package tb;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class lw0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public abstract boolean a();

    public void b(Activity activity, Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1979202315")) {
            ipChange.ipc$dispatch("1979202315", new Object[]{this, activity, configuration});
        }
    }

    public void c(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1476931891")) {
            ipChange.ipc$dispatch("1476931891", new Object[]{this, Float.valueOf(f)});
        }
    }

    public void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1742658694")) {
            ipChange.ipc$dispatch("1742658694", new Object[]{this});
        }
    }

    public void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "813292312")) {
            ipChange.ipc$dispatch("813292312", new Object[]{this});
        }
    }

    public void f(Activity activity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "36403274")) {
            ipChange.ipc$dispatch("36403274", new Object[]{this, activity, view});
        }
    }

    public abstract boolean g();
}
