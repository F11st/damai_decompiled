package tb;

import anet.channel.monitor.INetworkQualityChangeListener;
import anet.channel.monitor.NetworkSpeed;
import anet.channel.util.ALog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ea {
    private static volatile ea c;
    private Map<INetworkQualityChangeListener, gy1> a = new ConcurrentHashMap();
    private gy1 b = new gy1();

    private ea() {
    }

    public static ea b() {
        if (c == null) {
            synchronized (ea.class) {
                if (c == null) {
                    c = new ea();
                }
            }
        }
        return c;
    }

    public void a(INetworkQualityChangeListener iNetworkQualityChangeListener, gy1 gy1Var) {
        if (iNetworkQualityChangeListener == null) {
            ALog.e("BandWidthListenerHelp", "listener is null", null, new Object[0]);
        } else if (gy1Var == null) {
            this.b.c = System.currentTimeMillis();
            this.a.put(iNetworkQualityChangeListener, this.b);
        } else {
            gy1Var.c = System.currentTimeMillis();
            this.a.put(iNetworkQualityChangeListener, gy1Var);
        }
    }

    public void c(double d) {
        boolean b;
        for (Map.Entry<INetworkQualityChangeListener, gy1> entry : this.a.entrySet()) {
            INetworkQualityChangeListener key = entry.getKey();
            gy1 value = entry.getValue();
            if (key != null && value != null && !value.a() && value.d() != (b = value.b(d))) {
                value.e(b);
                key.onNetworkQualityChanged(b ? NetworkSpeed.Slow : NetworkSpeed.Fast);
            }
        }
    }

    public void d(INetworkQualityChangeListener iNetworkQualityChangeListener) {
        this.a.remove(iNetworkQualityChangeListener);
    }
}
