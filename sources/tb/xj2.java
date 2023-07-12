package tb;

import android.content.Context;
import anet.channel.monitor.INetworkQualityChangeListener;
import anet.channel.monitor.NetworkSpeed;
import anetwork.channel.monitor.Monitor;
import com.taobao.phenix.loader.network.NetworkQualityListener;
import com.taobao.rxm.schedule.SchedulerSupplier;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class xj2 {
    private static boolean a;
    private static boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.xj2$a */
    /* loaded from: classes11.dex */
    public static class C9930a implements INetworkQualityChangeListener {
        C9930a() {
        }

        @Override // anet.channel.monitor.INetworkQualityChangeListener
        public void onNetworkQualityChanged(NetworkSpeed networkSpeed) {
            xt2.a("Network", "network speed detect: %K/s", Integer.valueOf((int) (Monitor.getNetSpeedValue() * 1024.0d)));
            SchedulerSupplier build = ur1.o().schedulerBuilder().build();
            if (build instanceof NetworkQualityListener) {
                ((NetworkQualityListener) build).onNetworkQualityChanged(networkSpeed == NetworkSpeed.Slow);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.xj2$b */
    /* loaded from: classes11.dex */
    public static class C9931b extends gy1 {
        C9931b() {
        }

        @Override // tb.gy1
        public boolean b(double d) {
            return d <= 30.0d;
        }
    }

    public static boolean a() {
        return b;
    }

    public static void b(Context context) {
        try {
            ur1.o().httpLoaderBuilder().with(new qh1(context));
            a = true;
            xt2.f("TBNetwork4Phenix", "http loader setup", new Object[0]);
        } catch (RuntimeException e) {
            xt2.c("TBNetwork4Phenix", "http loader setup error=%s", e);
        }
    }

    public static void c() {
        if (a) {
            Monitor.addListener(new C9930a(), new C9931b());
            xt2.f("TBNetwork4Phenix", "network quality monitor setup", new Object[0]);
        }
    }
}
