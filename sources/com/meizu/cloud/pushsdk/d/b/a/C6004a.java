package com.meizu.cloud.pushsdk.d.b.a;

import com.meizu.cloud.pushsdk.c.c.C5968i;
import com.meizu.cloud.pushsdk.d.a.InterfaceC5999a;
import com.meizu.cloud.pushsdk.d.b.AbstractC6002a;
import com.meizu.cloud.pushsdk.d.b.C6009e;
import com.meizu.cloud.pushsdk.d.b.C6011g;
import com.meizu.cloud.pushsdk.d.b.InterfaceC6010f;
import com.meizu.cloud.pushsdk.d.d.C6018a;
import com.meizu.cloud.pushsdk.d.d.C6020c;
import com.meizu.cloud.pushsdk.d.d.InterfaceC6021d;
import com.meizu.cloud.pushsdk.d.f.C6030c;
import com.meizu.cloud.pushsdk.d.f.C6032e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.d.b.a.a */
/* loaded from: classes10.dex */
public class C6004a extends AbstractC6002a {
    private final String h;
    private InterfaceC6021d i;
    private int j;

    public C6004a(AbstractC6002a.C6003a c6003a) {
        super(c6003a);
        String simpleName = C6004a.class.getSimpleName();
        this.h = simpleName;
        C6018a c6018a = new C6018a(this.a, this.e);
        this.i = c6018a;
        if (c6018a.a()) {
            return;
        }
        this.i = new C6020c(this.e);
        C6030c.a(simpleName, "init memory store", new Object[0]);
    }

    private LinkedList<C6011g> a(LinkedList<C6009e> linkedList) {
        LinkedList<C6011g> linkedList2 = new LinkedList<>();
        LinkedList linkedList3 = new LinkedList();
        Iterator<C6009e> it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList3.add(C6005b.a(b(it.next().a())));
        }
        C6030c.b(this.h, "Request Futures: %s", Integer.valueOf(linkedList3.size()));
        for (int i = 0; i < linkedList3.size(); i++) {
            int i2 = -1;
            try {
                i2 = ((Integer) ((Future) linkedList3.get(i)).get(5L, TimeUnit.SECONDS)).intValue();
            } catch (InterruptedException e) {
                C6030c.a(this.h, "Request Future was interrupted: %s", e.getMessage());
            } catch (ExecutionException e2) {
                C6030c.a(this.h, "Request Future failed: %s", e2.getMessage());
            } catch (TimeoutException e3) {
                C6030c.a(this.h, "Request Future had a timeout: %s", e3.getMessage());
            }
            if (linkedList.get(i).c()) {
                linkedList2.add(new C6011g(true, linkedList.get(i).b()));
            } else {
                linkedList2.add(new C6011g(a(i2), linkedList.get(i).b()));
            }
        }
        return linkedList2;
    }

    private Callable<Boolean> a(final Long l) {
        return new Callable<Boolean>() { // from class: com.meizu.cloud.pushsdk.d.b.a.a.3
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                return Boolean.valueOf(C6004a.this.i.a(l.longValue()));
            }
        };
    }

    private LinkedList<Boolean> b(LinkedList<Long> linkedList) {
        boolean z;
        LinkedList<Boolean> linkedList2 = new LinkedList<>();
        LinkedList linkedList3 = new LinkedList();
        Iterator<Long> it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList3.add(C6005b.a(a(it.next())));
        }
        C6030c.b(this.h, "Removal Futures: %s", Integer.valueOf(linkedList3.size()));
        for (int i = 0; i < linkedList3.size(); i++) {
            try {
                z = ((Boolean) ((Future) linkedList3.get(i)).get(5L, TimeUnit.SECONDS)).booleanValue();
            } catch (InterruptedException e) {
                C6030c.a(this.h, "Removal Future was interrupted: %s", e.getMessage());
                z = false;
                linkedList2.add(Boolean.valueOf(z));
            } catch (ExecutionException e2) {
                C6030c.a(this.h, "Removal Future failed: %s", e2.getMessage());
                z = false;
                linkedList2.add(Boolean.valueOf(z));
            } catch (TimeoutException e3) {
                C6030c.a(this.h, "Removal Future had a timeout: %s", e3.getMessage());
                z = false;
                linkedList2.add(Boolean.valueOf(z));
            }
            linkedList2.add(Boolean.valueOf(z));
        }
        return linkedList2;
    }

    private Callable<Integer> b(final C5968i c5968i) {
        return new Callable<Integer>() { // from class: com.meizu.cloud.pushsdk.d.b.a.a.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Integer call() {
                return Integer.valueOf(C6004a.this.a(c5968i));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (C6032e.a(this.a)) {
            if (this.i.c() > 0) {
                this.j = 0;
                LinkedList<C6011g> a = a(a(this.i.d()));
                C6030c.c(this.h, "Processing emitter results.", new Object[0]);
                LinkedList<Long> linkedList = new LinkedList<>();
                Iterator<C6011g> it = a.iterator();
                int i = 0;
                int i2 = 0;
                while (it.hasNext()) {
                    C6011g next = it.next();
                    if (next.a()) {
                        linkedList.addAll(next.b());
                        i += next.b().size();
                    } else {
                        i2 += next.b().size();
                        C6030c.a(this.h, "Request sending failed but we will retry later.", new Object[0]);
                    }
                }
                b(linkedList);
                C6030c.b(this.h, "Success Count: %s", Integer.valueOf(i));
                C6030c.b(this.h, "Failure Count: %s", Integer.valueOf(i2));
                InterfaceC6010f interfaceC6010f = this.b;
                if (interfaceC6010f != null) {
                    if (i2 != 0) {
                        interfaceC6010f.a(i, i2);
                    } else {
                        interfaceC6010f.a(i);
                    }
                }
                if (i2 > 0 && i == 0) {
                    if (C6032e.a(this.a)) {
                        C6030c.a(this.h, "Ensure collector path is valid: %s", b());
                    }
                    C6030c.a(this.h, "Emitter loop stopping: failures.", new Object[0]);
                }
            } else {
                int i3 = this.j;
                if (i3 >= this.d) {
                    C6030c.a(this.h, "Emitter loop stopping: empty limit reached.", new Object[0]);
                    this.g.compareAndSet(true, false);
                    InterfaceC6010f interfaceC6010f2 = this.b;
                    if (interfaceC6010f2 != null) {
                        interfaceC6010f2.a(true);
                        return;
                    }
                    return;
                }
                this.j = i3 + 1;
                String str = this.h;
                C6030c.a(str, "Emitter database empty: " + this.j, new Object[0]);
                try {
                    this.f.sleep(this.c);
                } catch (InterruptedException e) {
                    String str2 = this.h;
                    C6030c.a(str2, "Emitter thread sleep interrupted: " + e.toString(), new Object[0]);
                }
            }
            c();
            return;
        }
        C6030c.a(this.h, "Emitter loop stopping: emitter offline.", new Object[0]);
        this.g.compareAndSet(true, false);
    }

    @Override // com.meizu.cloud.pushsdk.d.b.AbstractC6002a
    public void a() {
        C6005b.a(new Runnable() { // from class: com.meizu.cloud.pushsdk.d.b.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (((AbstractC6002a) C6004a.this).g.compareAndSet(false, true)) {
                    C6004a.this.c();
                }
            }
        });
    }

    @Override // com.meizu.cloud.pushsdk.d.b.AbstractC6002a
    public void a(InterfaceC5999a interfaceC5999a, boolean z) {
        this.i.a(interfaceC5999a);
        String str = this.h;
        C6030c.a(str, "isRunning " + this.g + " attemptEmit " + z, new Object[0]);
        if (!z) {
            try {
                this.f.sleep(1L);
            } catch (InterruptedException e) {
                String str2 = this.h;
                C6030c.a(str2, "Emitter add thread sleep interrupted: " + e.toString(), new Object[0]);
            }
        }
        if (this.g.compareAndSet(false, true)) {
            c();
        }
    }
}
