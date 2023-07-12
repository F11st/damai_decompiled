package com.alibaba.mobsec.privacydoublelist;

import com.alibaba.mobsec.privacydoublelist.c.a;
import com.alibaba.mobsec.privacydoublelist.e.e;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.Invocation;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class a extends AopBridge {
    public static volatile a b;
    public final Map<Invocation, Long> a = new ConcurrentHashMap();

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public void callAfterBridge(Invocation invocation) {
        Long l = this.a.get(invocation);
        if (l != null) {
            e.b().a(invocation, l.longValue() / 1000, false);
            this.a.remove(invocation);
        }
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public boolean callBeforeBridge(Invocation invocation) {
        com.alibaba.mobsec.privacydoublelist.c.a a = com.alibaba.mobsec.privacydoublelist.c.a.a();
        a.C0146a c0146a = a.a.get(invocation.getProxyName());
        if (c0146a != null) {
            boolean a2 = c0146a.a(invocation);
            if (a2) {
                this.a.put(invocation, Long.valueOf(System.currentTimeMillis()));
            }
            return a2;
        }
        this.a.put(invocation, Long.valueOf(System.currentTimeMillis()));
        return true;
    }
}
