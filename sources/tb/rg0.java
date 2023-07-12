package tb;

import android.app.Activity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class rg0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static ArrayList<Activity> a = new ArrayList<>();

    public static void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1203644402")) {
            ipChange.ipc$dispatch("-1203644402", new Object[0]);
            return;
        }
        Iterator<Activity> it = a.iterator();
        while (it.hasNext()) {
            it.next().finish();
        }
    }
}
