package cn.damai.seat.helper;

import android.app.Activity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class a {
    private static transient /* synthetic */ IpChange $ipChange;
    protected Activity a;

    public a(Activity activity) {
        this.a = activity;
    }

    public boolean a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "509201189")) {
            return ((Boolean) ipChange.ipc$dispatch("509201189", new Object[]{this})).booleanValue();
        }
        Activity activity = this.a;
        return (activity == null || activity.isFinishing()) ? false : true;
    }
}
