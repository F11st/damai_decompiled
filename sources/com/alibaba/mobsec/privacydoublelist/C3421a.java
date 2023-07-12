package com.alibaba.mobsec.privacydoublelist;

import com.alibaba.mobsec.privacydoublelist.c.C3426a;
import com.alibaba.mobsec.privacydoublelist.e.C3438e;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.Invocation;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* renamed from: com.alibaba.mobsec.privacydoublelist.a */
/* loaded from: classes6.dex */
public class C3421a extends AopBridge {
    public static volatile C3421a b;
    public final Map<Invocation, Long> a = new ConcurrentHashMap();

    public static C3421a a() {
        if (b == null) {
            synchronized (C3421a.class) {
                if (b == null) {
                    b = new C3421a();
                }
            }
        }
        return b;
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public void callAfterBridge(Invocation invocation) {
        Long l = this.a.get(invocation);
        if (l != null) {
            C3438e.b().a(invocation, l.longValue() / 1000, false);
            this.a.remove(invocation);
        }
    }

    @Override // com.alibaba.wireless.security.aopsdk.AopBridge
    public boolean callBeforeBridge(Invocation invocation) {
        C3426a a = C3426a.a();
        C3426a.C3427a c3427a = a.a.get(invocation.getProxyName());
        if (c3427a != null) {
            boolean a2 = c3427a.a(invocation);
            if (a2) {
                this.a.put(invocation, Long.valueOf(System.currentTimeMillis()));
            }
            return a2;
        }
        this.a.put(invocation, Long.valueOf(System.currentTimeMillis()));
        return true;
    }
}
