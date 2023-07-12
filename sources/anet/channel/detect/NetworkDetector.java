package anet.channel.detect;

import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import com.alibaba.fastjson.JSONObject;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class NetworkDetector {
    private static HorseRaceDetector a = new HorseRaceDetector();
    private static ExceptionDetector b = new ExceptionDetector();
    private static MTUDetector c = new MTUDetector();
    private static AtomicBoolean d = new AtomicBoolean(false);

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface INetworkDiagnosisCallback {
        void onNetworkDiagnosisFinished(JSONObject jSONObject);
    }

    public static void a(RequestStatistic requestStatistic) {
        if (d.get()) {
            b.q(requestStatistic);
        }
    }

    public static int b() {
        int b2 = c.b();
        int s = b.s();
        if (b2 <= 0 || s <= 0) {
            return b2 > 0 ? b2 : s;
        }
        return Math.min(b2, s);
    }

    public static void c() {
        try {
            if (d.compareAndSet(false, true)) {
                ALog.f("awcn.NetworkDetector", "registerListener", null, new Object[0]);
                a.d();
                b.B();
                c.d();
            }
        } catch (Exception e) {
            ALog.d("awcn.NetworkDetector", "[registerListener]error", null, e, new Object[0]);
        }
    }
}
