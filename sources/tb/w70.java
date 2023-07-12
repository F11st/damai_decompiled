package tb;

import anet.channel.detect.HttpStrategyDetector;
import anet.channel.detect.Ipv6Detector;
import anet.channel.quic.Http3ConnectionDetector;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class w70 {
    private static AtomicBoolean a = new AtomicBoolean(false);

    public static void a() {
        if (a.compareAndSet(false, true)) {
            if (hu0.j()) {
                if (t9.r()) {
                    Http3ConnectionDetector.l();
                }
                if (t9.v()) {
                    HttpStrategyDetector.g();
                }
            }
            Ipv6Detector.e();
        }
    }
}
