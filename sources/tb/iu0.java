package tb;

import cn.damai.common.util.executor.ConstrainedExecutorService;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class iu0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static iu0 b = null;
    private static String c = "GlobalExecutorService";
    private static int d = 20;
    private static int e = 150;
    private ConstrainedExecutorService a = ConstrainedExecutorService.d(c, d, e, Executors.newFixedThreadPool(d));

    private iu0() {
    }

    public static synchronized iu0 b() {
        synchronized (iu0.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1820756197")) {
                return (iu0) ipChange.ipc$dispatch("1820756197", new Object[0]);
            }
            if (b == null) {
                b = new iu0();
            }
            return b;
        }
    }

    public void a(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "708542063")) {
            ipChange.ipc$dispatch("708542063", new Object[]{this, runnable});
            return;
        }
        ConstrainedExecutorService constrainedExecutorService = this.a;
        if (constrainedExecutorService != null) {
            constrainedExecutorService.execute(runnable);
        }
    }
}
