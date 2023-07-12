package anet.channel.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.d */
/* loaded from: classes.dex */
public class C0227d {
    Map<String, ConnProtocol> a = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.d$a */
    /* loaded from: classes.dex */
    public static class C0228a {
        static C0227d a = new C0227d();
    }

    public static C0227d b() {
        return C0228a.a;
    }

    public ConnProtocol a(String str) {
        return this.a.get(str);
    }

    public void c(String str, ConnProtocol connProtocol) {
        if (connProtocol != null) {
            this.a.put(str, connProtocol);
            try {
                IStrategyInstance a = C0213a.a();
                if (a instanceof StrategyInstance) {
                    ((StrategyInstance) a).b.c.h(str, connProtocol);
                }
            } catch (Exception unused) {
            }
        }
    }
}
