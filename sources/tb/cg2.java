package tb;

import android.app.Application;
import android.content.Context;
import com.alibaba.motu.crashreporter.IUTCrashCaughtListener;
import com.alibaba.motu.crashreporter.MotuCrashReporter;
import com.taobao.pexode.Pexode;
import com.taobao.phenix.chain.ImageDecodingListener;
import com.taobao.phenix.compat.stat.NetworkAnalyzer;
import com.taobao.phenix.compat.stat.TBImageFlowMonitor;
import com.taobao.phenix.compat.stat.TBImageRetrieveABListener;
import com.taobao.rxm.schedule.PairingThrottlingScheduler;
import com.taobao.rxm.schedule.Scheduler;
import com.taobao.rxm.schedule.SchedulerSupplier;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class cg2 {
    public static boolean a;
    public static boolean b;
    public static long c;
    private static boolean d;
    private static final b e = new b(null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a implements IUTCrashCaughtListener {
        a() {
        }

        @Override // com.alibaba.motu.crashreporter.IUTCrashCaughtListener
        public Map<String, Object> onCrashCaught(Thread thread, Throwable th) {
            String a = cg2.e.a();
            if (a == null) {
                xt2.i("StatMonitor4Phenix", "crash happened, collect latest decoding failed", new Object[0]);
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("PHENIX_LATEST_DECODING", a);
            xt2.f("StatMonitor4Phenix", "crash happened, collect latest decoding urls=%s", a);
            return hashMap;
        }
    }

    private static void b() {
        if (a) {
            op0.a = "bizReqStart";
            op0.b = "bizReqProcessStart";
            op0.c = "bizRspProcessStart";
            op0.d = "bizRspCbDispatch";
            op0.e = "bizRspCbStart";
            op0.f = "bizRspCbEnd";
            op0.g = "bizFinish";
        }
    }

    public static boolean c() {
        return d;
    }

    public static void d(Context context, NetworkAnalyzer networkAnalyzer, int i, int i2) {
        e(context, networkAnalyzer, i, 100, i2, null);
    }

    public static void e(Context context, NetworkAnalyzer networkAnalyzer, int i, int i2, int i3, TBImageRetrieveABListener tBImageRetrieveABListener) {
        TBImageFlowMonitor tBImageFlowMonitor = new TBImageFlowMonitor(i, i2, networkAnalyzer, tBImageRetrieveABListener);
        c = System.currentTimeMillis();
        tBImageFlowMonitor.B(aj1.a());
        ((Application) context).registerActivityLifecycleCallbacks(aj1.a());
        tBImageFlowMonitor.C(new zj2(context));
        if (i3 > 0) {
            tBImageFlowMonitor.A(i3);
        }
        Pexode.r(tBImageFlowMonitor);
        ur1.o().y(tBImageFlowMonitor);
        SchedulerSupplier build = ur1.o().schedulerBuilder().build();
        if (build != null) {
            Scheduler forNetwork = build.forNetwork();
            if (forNetwork instanceof PairingThrottlingScheduler) {
                ((PairingThrottlingScheduler) forNetwork).f(tBImageFlowMonitor);
            }
        }
        ur1.o().x(e);
        MotuCrashReporter.getInstance().setCrashCaughtListener(new a());
        xt2.f("StatMonitor4Phenix", "init stat monitor with sampling=%d", Integer.valueOf(i));
        try {
            Class.forName("com.taobao.analysis.fulltrace.FullTraceAnalysis");
            a = true;
        } catch (Exception unused) {
            a = false;
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class b implements ImageDecodingListener {
        final Map<Long, String> a;

        private b() {
            this.a = new LinkedHashMap(2);
        }

        public String a() {
            String str;
            synchronized (this) {
                str = null;
                if (this.a.size() > 0) {
                    for (Map.Entry<Long, String> entry : this.a.entrySet()) {
                        str = str == null ? entry.getValue() : str + "," + entry.getValue();
                    }
                }
            }
            return str;
        }

        @Override // com.taobao.phenix.chain.ImageDecodingListener
        public synchronized void onDecodeFinish(long j, String str) {
            this.a.remove(Long.valueOf(j));
        }

        @Override // com.taobao.phenix.chain.ImageDecodingListener
        public void onDecodeStart(long j, String str) {
            synchronized (this) {
                if (this.a.size() > 5) {
                    this.a.clear();
                }
                this.a.put(Long.valueOf(j), str);
            }
            MotuCrashReporter.getInstance().addNativeHeaderInfo("PHENIX_LATEST_DECODING", a());
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }
}
