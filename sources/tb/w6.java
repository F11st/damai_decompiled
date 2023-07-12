package tb;

import android.app.Activity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Stack;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes4.dex */
public class w6 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static Stack<Activity> a;
    private static volatile w6 b;

    private w6() {
    }

    public static w6 b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1294549834")) {
            return (w6) ipChange.ipc$dispatch("-1294549834", new Object[0]);
        }
        if (b == null) {
            synchronized (w6.class) {
                if (b == null) {
                    b = new w6();
                    a = new Stack<>();
                }
            }
        }
        return b;
    }

    public void a(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1392908060")) {
            ipChange.ipc$dispatch("1392908060", new Object[]{this, activity});
            return;
        }
        if (a == null) {
            a = new Stack<>();
        }
        a.add(activity);
    }

    public Activity c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-551957600")) {
            return (Activity) ipChange.ipc$dispatch("-551957600", new Object[]{this});
        }
        int size = a.size() - 2;
        if (size < 0) {
            return null;
        }
        return a.get(size);
    }

    public void d(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-900228177")) {
            ipChange.ipc$dispatch("-900228177", new Object[]{this, activity});
        } else if (activity != null) {
            a.remove(activity);
        }
    }
}
