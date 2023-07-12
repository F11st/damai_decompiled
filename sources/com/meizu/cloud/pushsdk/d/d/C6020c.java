package com.meizu.cloud.pushsdk.d.d;

import com.meizu.cloud.pushsdk.d.a.C6001c;
import com.meizu.cloud.pushsdk.d.a.InterfaceC5999a;
import com.meizu.cloud.pushsdk.d.b.C6007c;
import com.meizu.cloud.pushsdk.d.f.C6030c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.d.d.c */
/* loaded from: classes10.dex */
public class C6020c implements InterfaceC6021d {
    private final int a;
    private final AtomicLong b = new AtomicLong(0);
    private final Map<Long, byte[]> c = new ConcurrentHashMap();
    private final List<Long> d = new CopyOnWriteArrayList();

    public C6020c(int i) {
        this.a = i;
    }

    @Override // com.meizu.cloud.pushsdk.d.d.InterfaceC6021d
    public void a(InterfaceC5999a interfaceC5999a) {
        b(interfaceC5999a);
    }

    @Override // com.meizu.cloud.pushsdk.d.d.InterfaceC6021d
    public boolean a() {
        return true;
    }

    @Override // com.meizu.cloud.pushsdk.d.d.InterfaceC6021d
    public boolean a(long j) {
        return this.d.remove(Long.valueOf(j)) && this.c.remove(Long.valueOf(j)) != null;
    }

    public long b(InterfaceC5999a interfaceC5999a) {
        byte[] a = C6018a.a(interfaceC5999a.a());
        long andIncrement = this.b.getAndIncrement();
        this.d.add(Long.valueOf(andIncrement));
        this.c.put(Long.valueOf(andIncrement), a);
        return andIncrement;
    }

    @Override // com.meizu.cloud.pushsdk.d.d.InterfaceC6021d
    public long c() {
        return this.d.size();
    }

    @Override // com.meizu.cloud.pushsdk.d.d.InterfaceC6021d
    public C6007c d() {
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        int c = (int) c();
        int i = this.a;
        if (c > i) {
            c = i;
        }
        for (int i2 = 0; i2 < c; i2++) {
            Long l = this.d.get(i2);
            if (l != null) {
                C6001c c6001c = new C6001c();
                c6001c.a(C6018a.a(this.c.get(l)));
                C6030c.c("MemoryStore", " current key " + l + " payload " + c6001c, new Object[0]);
                linkedList.add(l);
                arrayList.add(c6001c);
            }
        }
        return new C6007c(arrayList, linkedList);
    }
}
