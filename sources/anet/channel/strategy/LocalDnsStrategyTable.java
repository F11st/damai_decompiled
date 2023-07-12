package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.util.ALog;
import anet.channel.util.Inet64Util;
import com.taobao.accs.net.SmartHeartbeatImpl;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentHashMap;
import tb.C9708t9;
import tb.a5;
import tb.ab2;
import tb.lw2;
import tb.y90;
import tb.ym;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes.dex */
public class LocalDnsStrategyTable {
    final ConcurrentHashMap<String, List<IPConnStrategy>> a = new ConcurrentHashMap<>();
    final HashMap<String, Object> b = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.LocalDnsStrategyTable$a */
    /* loaded from: classes.dex */
    public class C0206a implements Comparator<IPConnStrategy> {
        C0206a(LocalDnsStrategyTable localDnsStrategyTable) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(IPConnStrategy iPConnStrategy, IPConnStrategy iPConnStrategy2) {
            return (lw2.c(iPConnStrategy2.ip) && lw2.d(iPConnStrategy.ip)) ? -1 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2) {
        List<IPConnStrategy> list = this.a.get(str);
        if (list == null || list.isEmpty()) {
            list = new LinkedList<>();
        }
        ConnProtocol a = C0227d.b().a(str);
        if (a != null) {
            list.add(IPConnStrategy.create(str2, !c(a) ? 80 : 443, a, 0, 0, 1, SmartHeartbeatImpl.FOREGROUND_INTERVAL));
        }
        list.add(IPConnStrategy.create(str2, 80, ConnProtocol.HTTP, 0, 0, 0, 0));
        list.add(IPConnStrategy.create(str2, 443, ConnProtocol.HTTPS, 0, 0, 0, 0));
        if (C9708t9.z()) {
            Collections.sort(list, new C0206a(this));
        }
        this.a.put(str, list);
    }

    private boolean c(ConnProtocol connProtocol) {
        return connProtocol.protocol.equalsIgnoreCase("https") || connProtocol.protocol.equalsIgnoreCase(ConnType.H2S) || !TextUtils.isEmpty(connProtocol.publicKey);
    }

    private void i(final String str, final Object obj) {
        a5.d(new Runnable() { // from class: anet.channel.strategy.LocalDnsStrategyTable.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        if (Inet64Util.n() != 3) {
                            LocalDnsStrategyTable.this.b(str, InetAddress.getByName(str).getHostAddress());
                        } else {
                            boolean z = false;
                            boolean z2 = false;
                            for (InetAddress inetAddress : InetAddress.getAllByName(str)) {
                                String hostAddress = inetAddress.getHostAddress();
                                if (!z && lw2.d(hostAddress)) {
                                    LocalDnsStrategyTable.this.b(str, hostAddress);
                                    z = true;
                                } else if (!z2 && lw2.c(hostAddress)) {
                                    LocalDnsStrategyTable.this.b(str, hostAddress);
                                    z2 = true;
                                }
                                if (z2 && z) {
                                    break;
                                }
                            }
                        }
                        if (ALog.g(1)) {
                            String str2 = str;
                            ALog.c("awcn.LocalDnsStrategyTable", "resolve ip by local dns", null, "host", str2, "list", LocalDnsStrategyTable.this.a.get(str2));
                        }
                        synchronized (LocalDnsStrategyTable.this.b) {
                            LocalDnsStrategyTable.this.b.remove(str);
                        }
                        synchronized (obj) {
                            obj.notifyAll();
                        }
                    } catch (Exception unused) {
                        ALog.e("awcn.LocalDnsStrategyTable", "resolve ip by local dns failed", null, "host", str);
                        if (ALog.g(1)) {
                            String str3 = str;
                            ALog.c("awcn.LocalDnsStrategyTable", "resolve ip by local dns", null, "host", str3, "list", LocalDnsStrategyTable.this.a.get(str3));
                        }
                        synchronized (LocalDnsStrategyTable.this.b) {
                            LocalDnsStrategyTable.this.b.remove(str);
                            synchronized (obj) {
                                obj.notifyAll();
                            }
                        }
                    }
                } catch (Throwable th) {
                    if (ALog.g(1)) {
                        String str4 = str;
                        ALog.c("awcn.LocalDnsStrategyTable", "resolve ip by local dns", null, "host", str4, "list", LocalDnsStrategyTable.this.a.get(str4));
                    }
                    synchronized (LocalDnsStrategyTable.this.b) {
                        LocalDnsStrategyTable.this.b.remove(str);
                        synchronized (obj) {
                            obj.notifyAll();
                            throw th;
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str, IConnStrategy iConnStrategy, ym ymVar) {
        List<IPConnStrategy> list;
        if (ymVar.a || TextUtils.isEmpty(str) || ymVar.b || (list = this.a.get(str)) == null || list == Collections.EMPTY_LIST) {
            return;
        }
        Iterator<IPConnStrategy> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == iConnStrategy) {
                it.remove();
            }
        }
        if (list.isEmpty()) {
            this.a.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List e(String str) {
        Object obj;
        if (!TextUtils.isEmpty(str) && lw2.a(str) && !y90.a().equalsIgnoreCase(str)) {
            if (ALog.g(1)) {
                ALog.c("awcn.LocalDnsStrategyTable", "try resolve ip with local dns", null, "host", str);
            }
            List list = Collections.EMPTY_LIST;
            if (!this.a.containsKey(str)) {
                synchronized (this.b) {
                    if (!this.b.containsKey(str)) {
                        obj = new Object();
                        this.b.put(str, obj);
                        i(str, obj);
                    } else {
                        obj = this.b.get(str);
                    }
                }
                if (obj != null) {
                    try {
                        synchronized (obj) {
                            obj.wait(500L);
                        }
                    } catch (InterruptedException unused) {
                    }
                }
            }
            List<IPConnStrategy> list2 = this.a.get(str);
            if (list2 != null && list2 != Collections.EMPTY_LIST) {
                list = new ArrayList(list2);
            }
            ALog.f("awcn.LocalDnsStrategyTable", "get local strategy", null, "strategyList", list2);
            return list;
        }
        return Collections.EMPTY_LIST;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List f(String str, boolean z, int i) {
        List e = e(str);
        ListIterator listIterator = e.listIterator();
        while (listIterator.hasNext()) {
            IPConnStrategy iPConnStrategy = (IPConnStrategy) listIterator.next();
            if (lw2.d(iPConnStrategy.getIp())) {
                listIterator.remove();
            } else {
                ConnType l = ConnType.l(iPConnStrategy.getProtocol());
                if (l == null) {
                    listIterator.remove();
                } else if (l.k() != z || (i != ab2.c && l.e() != i)) {
                    listIterator.remove();
                }
            }
        }
        return e;
    }

    public List<IConnStrategy> g(String str) {
        List<IConnStrategy> list = Collections.EMPTY_LIST;
        List<IPConnStrategy> list2 = this.a.get(str);
        if (list2 != null && list2.size() != 0) {
            list = new ArrayList<>(list2);
        }
        ALog.f("awcn.LocalDnsStrategyTable", "queryWithoutWait local strategy", null, "strategyList", list2);
        return list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str, ConnProtocol connProtocol) {
        List<IPConnStrategy> list = this.a.get(str);
        if (list == null || list.isEmpty()) {
            return;
        }
        for (IPConnStrategy iPConnStrategy : list) {
            if (iPConnStrategy.getProtocol().equals(connProtocol)) {
                return;
            }
        }
        list.add(IPConnStrategy.create(list.get(0).getIp(), !c(connProtocol) ? 80 : 443, connProtocol, 0, 0, 1, SmartHeartbeatImpl.FOREGROUND_INTERVAL));
        ALog.f("awcn.LocalDnsStrategyTable", "setProtocolForHost", null, "strategyList", list);
    }
}
