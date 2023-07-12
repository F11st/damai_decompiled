package com.huawei.hms.framework.network.grs.g;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.InterfaceC5560b;
import com.huawei.hms.framework.network.grs.e.C5564a;
import com.huawei.hms.framework.network.grs.e.C5566c;
import com.huawei.hms.framework.network.grs.g.k.C5589b;
import com.huawei.hms.framework.network.grs.g.k.C5590c;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.framework.network.grs.g.h */
/* loaded from: classes10.dex */
public class C5583h {
    private final ExecutorService a = ExecutorsUtils.newCachedThreadPool("GRS_RequestController-Task");
    private final Map<String, C5589b> b = new ConcurrentHashMap(16);
    private final Object c = new Object();
    private C5564a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.framework.network.grs.g.h$a */
    /* loaded from: classes10.dex */
    public class CallableC5584a implements Callable<C5578d> {
        final /* synthetic */ C5590c a;
        final /* synthetic */ String b;
        final /* synthetic */ C5566c c;

        CallableC5584a(C5590c c5590c, String str, C5566c c5566c) {
            this.a = c5590c;
            this.b = str;
            this.c = c5566c;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public C5578d call() {
            return new C5576c(this.a, C5583h.this.d).a(C5583h.this.a, this.b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.framework.network.grs.g.h$b */
    /* loaded from: classes10.dex */
    public class RunnableC5585b implements Runnable {
        final /* synthetic */ C5590c a;
        final /* synthetic */ String b;
        final /* synthetic */ C5566c c;
        final /* synthetic */ InterfaceC5560b d;

        RunnableC5585b(C5590c c5590c, String str, C5566c c5566c, InterfaceC5560b interfaceC5560b) {
            this.a = c5590c;
            this.b = str;
            this.c = c5566c;
            this.d = interfaceC5560b;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5583h c5583h = C5583h.this;
            c5583h.a(c5583h.a(this.a, this.b, this.c), this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C5578d c5578d, InterfaceC5560b interfaceC5560b) {
        if (interfaceC5560b != null) {
            if (c5578d == null) {
                Logger.v("RequestController", "GrsResponse is null");
                interfaceC5560b.a();
                return;
            }
            Logger.v("RequestController", "GrsResponse is not null");
            interfaceC5560b.a(c5578d);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0069, code lost:
        if (r2.a() != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006d, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.framework.network.grs.g.C5578d a(com.huawei.hms.framework.network.grs.g.k.C5590c r7, java.lang.String r8, com.huawei.hms.framework.network.grs.e.C5566c r9) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "request to server with service name is: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "RequestController"
            com.huawei.hms.framework.common.Logger.d(r1, r0)
            com.huawei.hms.framework.network.grs.GrsBaseInfo r0 = r7.b()
            android.content.Context r1 = r7.a()
            r2 = 1
            java.lang.String r0 = r0.getGrsParasKey(r2, r2, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "request spUrlKey: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "RequestController"
            com.huawei.hms.framework.common.Logger.v(r2, r1)
            java.lang.Object r1 = r6.c
            monitor-enter(r1)
            android.content.Context r2 = r7.a()     // Catch: java.lang.Throwable -> La7
            boolean r2 = com.huawei.hms.framework.common.NetworkUtil.isNetworkAvailable(r2)     // Catch: java.lang.Throwable -> La7
            r3 = 0
            if (r2 != 0) goto L49
            monitor-exit(r1)     // Catch: java.lang.Throwable -> La7
            return r3
        L49:
            com.huawei.hms.framework.network.grs.h.d$a r2 = com.huawei.hms.framework.network.grs.h.C5595d.a(r0)     // Catch: java.lang.Throwable -> La7
            java.util.Map<java.lang.String, com.huawei.hms.framework.network.grs.g.k.b> r4 = r6.b     // Catch: java.lang.Throwable -> La7
            java.lang.Object r4 = r4.get(r0)     // Catch: java.lang.Throwable -> La7
            com.huawei.hms.framework.network.grs.g.k.b r4 = (com.huawei.hms.framework.network.grs.g.k.C5589b) r4     // Catch: java.lang.Throwable -> La7
            if (r4 == 0) goto L63
            boolean r5 = r4.b()     // Catch: java.lang.Throwable -> La7
            if (r5 != 0) goto L5e
            goto L63
        L5e:
            java.util.concurrent.Future r7 = r4.a()     // Catch: java.lang.Throwable -> La7
            goto L8a
        L63:
            if (r2 == 0) goto L6e
            boolean r2 = r2.a()     // Catch: java.lang.Throwable -> La7
            if (r2 != 0) goto L6c
            goto L6e
        L6c:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> La7
            return r3
        L6e:
            java.lang.String r2 = "RequestController"
            java.lang.String r4 = "hitGrsRequestBean == null or request block is released."
            com.huawei.hms.framework.common.Logger.d(r2, r4)     // Catch: java.lang.Throwable -> La7
            java.util.concurrent.ExecutorService r2 = r6.a     // Catch: java.lang.Throwable -> La7
            com.huawei.hms.framework.network.grs.g.h$a r4 = new com.huawei.hms.framework.network.grs.g.h$a     // Catch: java.lang.Throwable -> La7
            r4.<init>(r7, r8, r9)     // Catch: java.lang.Throwable -> La7
            java.util.concurrent.Future r7 = r2.submit(r4)     // Catch: java.lang.Throwable -> La7
            java.util.Map<java.lang.String, com.huawei.hms.framework.network.grs.g.k.b> r8 = r6.b     // Catch: java.lang.Throwable -> La7
            com.huawei.hms.framework.network.grs.g.k.b r9 = new com.huawei.hms.framework.network.grs.g.k.b     // Catch: java.lang.Throwable -> La7
            r9.<init>(r7)     // Catch: java.lang.Throwable -> La7
            r8.put(r0, r9)     // Catch: java.lang.Throwable -> La7
        L8a:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> La7
            java.lang.Object r7 = r7.get()     // Catch: java.lang.InterruptedException -> L92 java.util.concurrent.ExecutionException -> L98 java.util.concurrent.CancellationException -> L9e
            com.huawei.hms.framework.network.grs.g.d r7 = (com.huawei.hms.framework.network.grs.g.C5578d) r7     // Catch: java.lang.InterruptedException -> L92 java.util.concurrent.ExecutionException -> L98 java.util.concurrent.CancellationException -> L9e
            return r7
        L92:
            r7 = move-exception
            java.lang.String r8 = "RequestController"
            java.lang.String r9 = "when check result, find InterruptedException, check others"
            goto La3
        L98:
            r7 = move-exception
            java.lang.String r8 = "RequestController"
            java.lang.String r9 = "when check result, find ExecutionException, check others"
            goto La3
        L9e:
            r7 = move-exception
            java.lang.String r8 = "RequestController"
            java.lang.String r9 = "when check result, find CancellationException, check others"
        La3:
            com.huawei.hms.framework.common.Logger.w(r8, r9, r7)
            return r3
        La7:
            r7 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> La7
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.C5583h.a(com.huawei.hms.framework.network.grs.g.k.c, java.lang.String, com.huawei.hms.framework.network.grs.e.c):com.huawei.hms.framework.network.grs.g.d");
    }

    public void a(C5564a c5564a) {
        this.d = c5564a;
    }

    public void a(C5590c c5590c, InterfaceC5560b interfaceC5560b, String str, C5566c c5566c) {
        this.a.execute(new RunnableC5585b(c5590c, str, c5566c, interfaceC5560b));
    }

    public void a(String str) {
        synchronized (this.c) {
            this.b.remove(str);
        }
    }
}
