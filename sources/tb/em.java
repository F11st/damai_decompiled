package tb;

import anet.channel.Session;
import anet.channel.entity.ConnType;
import anet.channel.strategy.C0213a;
import anet.channel.strategy.IConnStrategy;
import anet.channel.util.ALog;
import anet.channel.util.Inet64Util;
import com.taobao.weex.annotation.JSMethod;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class em {
    public static final int IP_COMPLEX = 2;
    public static final int IP_DEGRADE = 1;

    public static long a() {
        return C9708t9.b();
    }

    public static List<zm> b(Session session, List<zm> list, int i) {
        if (i == 1) {
            return c(session, list);
        }
        return null;
    }

    private static List<zm> c(Session session, List<zm> list) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (session == null) {
            return arrayList;
        }
        try {
            boolean i = session.g().i();
            if (list != null && list.size() != 0) {
                ListIterator<zm> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    zm next = listIterator.next();
                    if (lw2.c(next.e()) && !(next.a().i() ^ i)) {
                        String d = next.d();
                        arrayList.add(new zm(d, "COMPLEX-" + next.h(), next.a));
                    }
                }
            }
            if (arrayList.isEmpty()) {
                List<IConnStrategy> ipv4ConnStrategyListByHost = C0213a.a().getIpv4ConnStrategyListByHost(session.k(), session.h().startsWith("https"), session.g().e());
                if (ipv4ConnStrategyListByHost.isEmpty()) {
                    return arrayList;
                }
                int i2 = 0;
                for (int i3 = 0; i3 < ipv4ConnStrategyListByHost.size(); i3++) {
                    IConnStrategy iConnStrategy = ipv4ConnStrategyListByHost.get(i3);
                    if (!(ConnType.l(iConnStrategy.getProtocol()).i() ^ i)) {
                        int retryTimes = iConnStrategy.getRetryTimes();
                        for (int i4 = 0; i4 <= retryTimes; i4++) {
                            i2++;
                            String h = session.h();
                            zm zmVar = new zm(h, "COMPLEX-" + session.r + JSMethod.NOT_SET + i2, iConnStrategy);
                            zmVar.d = i4;
                            zmVar.e = retryTimes;
                            arrayList.add(zmVar);
                        }
                    }
                }
            }
            str = null;
        } catch (Exception e) {
            str = null;
            ALog.d("awcn.ComplexUtils", "getIpDegradeList failed", null, e, new Object[0]);
        }
        ALog.c("awcn.ComplexUtils", "getIpDegradeList" + arrayList.toString(), str, new Object[0]);
        return arrayList;
    }

    public static boolean d(String str, String str2) {
        return C9708t9.p() && C9708t9.j(str) && Inet64Util.n() == 3 && lw2.d(str2);
    }
}
