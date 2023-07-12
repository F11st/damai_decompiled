package tb;

import anet.channel.strategy.IConnStrategy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class d01 {

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class a {
        final IConnStrategy a;

        a(IConnStrategy iConnStrategy) {
            this.a = iConnStrategy;
        }

        public boolean a() {
            String str = this.a.getProtocol().protocol;
            return (str.equalsIgnoreCase("http") || str.equalsIgnoreCase("https")) ? false : true;
        }

        public String b() {
            return this.a.getIp();
        }

        public int c() {
            return this.a.getPort();
        }

        public String d() {
            return this.a.getProtocol().protocol;
        }

        public String toString() {
            return this.a.toString();
        }
    }

    public static ArrayList<a> a(String str) {
        return b(str, true);
    }

    public static ArrayList<a> b(String str, boolean z) {
        List<IConnStrategy> connStrategyListByHost = anet.channel.strategy.a.a().getConnStrategyListByHost(str);
        if (connStrategyListByHost.isEmpty()) {
            return null;
        }
        ArrayList<a> arrayList = new ArrayList<>(connStrategyListByHost.size());
        for (IConnStrategy iConnStrategy : connStrategyListByHost) {
            if (z || iConnStrategy.getIpSource() != 1) {
                arrayList.add(new a(iConnStrategy));
            }
        }
        return arrayList;
    }
}
