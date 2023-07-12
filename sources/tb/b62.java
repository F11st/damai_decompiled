package tb;

import android.util.Log;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class b62 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "ScanExecutor";
    private static ThreadPoolExecutor a;

    public static void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1052476966")) {
            ipChange.ipc$dispatch("-1052476966", new Object[0]);
            return;
        }
        ThreadPoolExecutor threadPoolExecutor = a;
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            a.shutdownNow();
            MPaasLogger.d("ScanExecutor", new String[]{"Shutdown Successfully : "});
            a = null;
        } catch (Exception unused) {
            MPaasLogger.e("ScanExecutor", new String[]{"Shutdown executor failed"});
        }
    }

    public static void b(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1852389883")) {
            ipChange.ipc$dispatch("1852389883", new Object[]{runnable});
            return;
        }
        ThreadPoolExecutor threadPoolExecutor = a;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(runnable);
        } else {
            Log.w("ScanExecutor", "Executor is dead", new Throwable());
        }
    }

    public static void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1470998034")) {
            ipChange.ipc$dispatch("-1470998034", new Object[0]);
            return;
        }
        a = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        MPaasLogger.d("ScanExecutor", new String[]{"Open Successfully"});
    }
}
