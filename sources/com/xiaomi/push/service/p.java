package com.xiaomi.push.service;

import android.content.Intent;
import android.os.SystemClock;
import com.xiaomi.push.service.XMPushService;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftNumBean;
import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class p {
    private static long a;
    private static long b;
    private static long c;

    /* renamed from: a  reason: collision with other field name */
    private final a f983a;

    /* renamed from: a  reason: collision with other field name */
    private final c f984a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class a {
        private final c a;

        a(c cVar) {
            this.a = cVar;
        }

        protected void finalize() {
            try {
                synchronized (this.a) {
                    this.a.c = true;
                    this.a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static abstract class b implements Runnable {
        protected int a;

        public b(int i) {
            this.a = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class c extends Thread {

        /* renamed from: b  reason: collision with other field name */
        private boolean f987b;
        private boolean c;
        private volatile long a = 0;

        /* renamed from: a  reason: collision with other field name */
        private volatile boolean f986a = false;
        private long b = 50;

        /* renamed from: a  reason: collision with other field name */
        private a f985a = new a();

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: Taobao */
        /* loaded from: classes11.dex */
        public static final class a {
            private int a;

            /* renamed from: a  reason: collision with other field name */
            private d[] f988a;
            private int b;
            private int c;

            private a() {
                this.a = 256;
                this.f988a = new d[256];
                this.b = 0;
                this.c = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int a(d dVar) {
                int i = 0;
                while (true) {
                    d[] dVarArr = this.f988a;
                    if (i >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i] == dVar) {
                        return i;
                    }
                    i++;
                }
            }

            private void b(d dVar) {
                Intent a;
                b bVar = dVar.f990a;
                int i = bVar.a;
                if (i == 8) {
                    XMPushService.d dVar2 = (XMPushService.d) bVar;
                    if (dVar2.a().f364a != null) {
                        dVar2.a().f364a.f894b = System.currentTimeMillis();
                        dVar2.a().f364a.b = a(dVar);
                    }
                } else if (i == 15 && (a = ((XMPushService.i) bVar).a()) != null && "10".equals(a.getStringExtra("ext_chid"))) {
                    a.putExtra("enqueue", System.currentTimeMillis());
                    a.putExtra(GiftNumBean.KEY_NUM, a(dVar));
                }
            }

            private void c() {
                int i = this.b - 1;
                int i2 = (i - 1) / 2;
                while (true) {
                    d[] dVarArr = this.f988a;
                    if (dVarArr[i].f989a >= dVarArr[i2].f989a) {
                        return;
                    }
                    d dVar = dVarArr[i];
                    dVarArr[i] = dVarArr[i2];
                    dVarArr[i2] = dVar;
                    int i3 = i2;
                    i2 = (i2 - 1) / 2;
                    i = i3;
                }
            }

            private void c(int i) {
                int i2 = (i * 2) + 1;
                while (true) {
                    int i3 = this.b;
                    if (i2 >= i3 || i3 <= 0) {
                        return;
                    }
                    int i4 = i2 + 1;
                    if (i4 < i3) {
                        d[] dVarArr = this.f988a;
                        if (dVarArr[i4].f989a < dVarArr[i2].f989a) {
                            i2 = i4;
                        }
                    }
                    d[] dVarArr2 = this.f988a;
                    if (dVarArr2[i].f989a < dVarArr2[i2].f989a) {
                        return;
                    }
                    d dVar = dVarArr2[i];
                    dVarArr2[i] = dVarArr2[i2];
                    dVarArr2[i2] = dVar;
                    int i5 = i2;
                    i2 = (i2 * 2) + 1;
                    i = i5;
                }
            }

            public d a() {
                return this.f988a[0];
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m1233a() {
                this.f988a = new d[this.a];
                this.b = 0;
            }

            public void a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    d[] dVarArr = this.f988a;
                    if (dVarArr[i2].a == i) {
                        dVarArr[i2].a();
                    }
                }
                b();
            }

            public void a(int i, b bVar) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    d[] dVarArr = this.f988a;
                    if (dVarArr[i2].f990a == bVar) {
                        dVarArr[i2].a();
                    }
                }
                b();
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m1234a(d dVar) {
                d[] dVarArr = this.f988a;
                int length = dVarArr.length;
                int i = this.b;
                if (length == i) {
                    d[] dVarArr2 = new d[i * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i);
                    this.f988a = dVarArr2;
                }
                d[] dVarArr3 = this.f988a;
                int i2 = this.b;
                this.b = i2 + 1;
                dVarArr3[i2] = dVar;
                c();
                b(dVar);
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m1235a() {
                return this.b == 0;
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m1236a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f988a[i2].a == i) {
                        return true;
                    }
                }
                return false;
            }

            public void b() {
                int i = 0;
                while (i < this.b) {
                    if (this.f988a[i].f992a) {
                        this.c++;
                        b(i);
                        i--;
                    }
                    i++;
                }
            }

            public void b(int i) {
                int i2;
                if (i < 0 || i >= (i2 = this.b)) {
                    return;
                }
                d[] dVarArr = this.f988a;
                int i3 = i2 - 1;
                this.b = i3;
                dVarArr[i] = dVarArr[i3];
                dVarArr[i3] = null;
                c(i);
            }
        }

        c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d dVar) {
            this.f985a.m1234a(dVar);
            notify();
        }

        public synchronized void a() {
            this.f987b = true;
            this.f985a.m1233a();
            notify();
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m1232a() {
            return this.f986a && SystemClock.uptimeMillis() - this.a > 600000;
        }

        /* JADX WARN: Code restructure failed: missing block: B:50:0x008e, code lost:
            r10.a = android.os.SystemClock.uptimeMillis();
            r10.f986a = true;
            r2.f990a.run();
            r10.f986a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x009f, code lost:
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00a0, code lost:
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00a1, code lost:
            r10.f987b = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00a4, code lost:
            throw r1;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r10 = this;
            L0:
                monitor-enter(r10)
                boolean r0 = r10.f987b     // Catch: java.lang.Throwable -> Lae
                if (r0 == 0) goto L7
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lae
                return
            L7:
                com.xiaomi.push.service.p$c$a r0 = r10.f985a     // Catch: java.lang.Throwable -> Lae
                boolean r0 = r0.m1235a()     // Catch: java.lang.Throwable -> Lae
                if (r0 == 0) goto L1a
                boolean r0 = r10.c     // Catch: java.lang.Throwable -> Lae
                if (r0 == 0) goto L15
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lae
                return
            L15:
                r10.wait()     // Catch: java.lang.InterruptedException -> L18 java.lang.Throwable -> Lae
            L18:
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lae
                goto L0
            L1a:
                long r0 = com.xiaomi.push.service.p.a()     // Catch: java.lang.Throwable -> Lae
                com.xiaomi.push.service.p$c$a r2 = r10.f985a     // Catch: java.lang.Throwable -> Lae
                com.xiaomi.push.service.p$d r2 = r2.a()     // Catch: java.lang.Throwable -> Lae
                java.lang.Object r3 = r2.f991a     // Catch: java.lang.Throwable -> Lae
                monitor-enter(r3)     // Catch: java.lang.Throwable -> Lae
                boolean r4 = r2.f992a     // Catch: java.lang.Throwable -> Lab
                r5 = 0
                if (r4 == 0) goto L33
                com.xiaomi.push.service.p$c$a r0 = r10.f985a     // Catch: java.lang.Throwable -> Lab
                r0.b(r5)     // Catch: java.lang.Throwable -> Lab
                monitor-exit(r3)     // Catch: java.lang.Throwable -> Lab
                goto L18
            L33:
                long r6 = r2.f989a     // Catch: java.lang.Throwable -> Lab
                long r6 = r6 - r0
                monitor-exit(r3)     // Catch: java.lang.Throwable -> Lab
                r0 = 50
                r3 = 0
                int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                if (r8 <= 0) goto L55
                long r2 = r10.b     // Catch: java.lang.Throwable -> Lae
                int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r4 <= 0) goto L46
                r6 = r2
            L46:
                long r2 = r2 + r0
                r10.b = r2     // Catch: java.lang.Throwable -> Lae
                r0 = 500(0x1f4, double:2.47E-321)
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 <= 0) goto L51
                r10.b = r0     // Catch: java.lang.Throwable -> Lae
            L51:
                r10.wait(r6)     // Catch: java.lang.InterruptedException -> L18 java.lang.Throwable -> Lae
                goto L18
            L55:
                r10.b = r0     // Catch: java.lang.Throwable -> Lae
                java.lang.Object r0 = r2.f991a     // Catch: java.lang.Throwable -> Lae
                monitor-enter(r0)     // Catch: java.lang.Throwable -> Lae
                com.xiaomi.push.service.p$c$a r1 = r10.f985a     // Catch: java.lang.Throwable -> La8
                com.xiaomi.push.service.p$d r1 = r1.a()     // Catch: java.lang.Throwable -> La8
                long r6 = r1.f989a     // Catch: java.lang.Throwable -> La8
                long r8 = r2.f989a     // Catch: java.lang.Throwable -> La8
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 == 0) goto L6f
                com.xiaomi.push.service.p$c$a r1 = r10.f985a     // Catch: java.lang.Throwable -> La8
                int r1 = com.xiaomi.push.service.p.c.a.a(r1, r2)     // Catch: java.lang.Throwable -> La8
                goto L70
            L6f:
                r1 = 0
            L70:
                boolean r6 = r2.f992a     // Catch: java.lang.Throwable -> La8
                if (r6 == 0) goto L7f
                com.xiaomi.push.service.p$c$a r1 = r10.f985a     // Catch: java.lang.Throwable -> La8
                int r2 = com.xiaomi.push.service.p.c.a.a(r1, r2)     // Catch: java.lang.Throwable -> La8
                r1.b(r2)     // Catch: java.lang.Throwable -> La8
                monitor-exit(r0)     // Catch: java.lang.Throwable -> La8
                goto L18
            L7f:
                long r6 = r2.f989a     // Catch: java.lang.Throwable -> La8
                r2.a(r6)     // Catch: java.lang.Throwable -> La8
                com.xiaomi.push.service.p$c$a r6 = r10.f985a     // Catch: java.lang.Throwable -> La8
                r6.b(r1)     // Catch: java.lang.Throwable -> La8
                r2.f989a = r3     // Catch: java.lang.Throwable -> La8
                monitor-exit(r0)     // Catch: java.lang.Throwable -> La8
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lae
                r0 = 1
                long r3 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> L9f
                r10.a = r3     // Catch: java.lang.Throwable -> L9f
                r10.f986a = r0     // Catch: java.lang.Throwable -> L9f
                com.xiaomi.push.service.p$b r1 = r2.f990a     // Catch: java.lang.Throwable -> L9f
                r1.run()     // Catch: java.lang.Throwable -> L9f
                r10.f986a = r5     // Catch: java.lang.Throwable -> L9f
                goto L0
            L9f:
                r1 = move-exception
                monitor-enter(r10)
                r10.f987b = r0     // Catch: java.lang.Throwable -> La5
                monitor-exit(r10)     // Catch: java.lang.Throwable -> La5
                throw r1
            La5:
                r0 = move-exception
                monitor-exit(r10)     // Catch: java.lang.Throwable -> La5
                throw r0
            La8:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> La8
                throw r1     // Catch: java.lang.Throwable -> Lae
            Lab:
                r0 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> Lab
                throw r0     // Catch: java.lang.Throwable -> Lae
            Lae:
                r0 = move-exception
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lae
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.p.c.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class d {
        int a;

        /* renamed from: a  reason: collision with other field name */
        long f989a;

        /* renamed from: a  reason: collision with other field name */
        b f990a;

        /* renamed from: a  reason: collision with other field name */
        final Object f991a = new Object();

        /* renamed from: a  reason: collision with other field name */
        boolean f992a;
        private long b;

        d() {
        }

        void a(long j) {
            synchronized (this.f991a) {
                this.b = j;
            }
        }

        public boolean a() {
            boolean z;
            synchronized (this.f991a) {
                z = !this.f992a && this.f989a > 0;
                this.f992a = true;
            }
            return z;
        }
    }

    static {
        long elapsedRealtime = SystemClock.elapsedRealtime() > 0 ? SystemClock.elapsedRealtime() : 0L;
        a = elapsedRealtime;
        b = elapsedRealtime;
    }

    public p() {
        this(false);
    }

    public p(String str) {
        this(str, false);
    }

    public p(String str, boolean z) {
        Objects.requireNonNull(str, "name == null");
        c cVar = new c(str, z);
        this.f984a = cVar;
        this.f983a = new a(cVar);
    }

    public p(boolean z) {
        this("Timer-" + b(), z);
    }

    static synchronized long a() {
        long j;
        synchronized (p.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = b;
            if (elapsedRealtime > j2) {
                a += elapsedRealtime - j2;
            }
            b = elapsedRealtime;
            j = a;
        }
        return j;
    }

    private static synchronized long b() {
        long j;
        synchronized (p.class) {
            j = c;
            c = 1 + j;
        }
        return j;
    }

    private void b(b bVar, long j) {
        synchronized (this.f984a) {
            if (this.f984a.f987b) {
                throw new IllegalStateException("Timer was canceled");
            }
            long a2 = j + a();
            if (a2 < 0) {
                throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
            }
            d dVar = new d();
            dVar.a = bVar.a;
            dVar.f990a = bVar;
            dVar.f989a = a2;
            this.f984a.a(dVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1227a() {
        com.xiaomi.channel.commonutils.logger.b.m586a("quit. finalizer:" + this.f983a);
        this.f984a.a();
    }

    public void a(int i) {
        synchronized (this.f984a) {
            this.f984a.f985a.a(i);
        }
    }

    public void a(int i, b bVar) {
        synchronized (this.f984a) {
            this.f984a.f985a.a(i, bVar);
        }
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() >= 1 || Thread.currentThread() == this.f984a) {
            bVar.run();
        } else {
            com.xiaomi.channel.commonutils.logger.b.d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
    }

    public void a(b bVar, long j) {
        if (j >= 0) {
            b(bVar, j);
            return;
        }
        throw new IllegalArgumentException("delay < 0: " + j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1228a() {
        return this.f984a.m1232a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1229a(int i) {
        boolean m1236a;
        synchronized (this.f984a) {
            m1236a = this.f984a.f985a.m1236a(i);
        }
        return m1236a;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m1230b() {
        synchronized (this.f984a) {
            this.f984a.f985a.m1233a();
        }
    }
}
