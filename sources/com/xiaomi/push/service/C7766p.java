package com.xiaomi.push.service;

import android.content.Intent;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.service.XMPushService;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftNumBean;
import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.service.p */
/* loaded from: classes11.dex */
public class C7766p {
    private static long a;
    private static long b;
    private static long c;

    /* renamed from: a  reason: collision with other field name */
    private final C7767a f983a;

    /* renamed from: a  reason: collision with other field name */
    private final C7769c f984a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.p$a */
    /* loaded from: classes11.dex */
    public static final class C7767a {
        private final C7769c a;

        C7767a(C7769c c7769c) {
            this.a = c7769c;
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
    /* renamed from: com.xiaomi.push.service.p$b */
    /* loaded from: classes11.dex */
    public static abstract class AbstractRunnableC7768b implements Runnable {
        protected int a;

        public AbstractRunnableC7768b(int i) {
            this.a = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.p$c */
    /* loaded from: classes11.dex */
    public static final class C7769c extends Thread {

        /* renamed from: b  reason: collision with other field name */
        private boolean f987b;
        private boolean c;
        private volatile long a = 0;

        /* renamed from: a  reason: collision with other field name */
        private volatile boolean f986a = false;
        private long b = 50;

        /* renamed from: a  reason: collision with other field name */
        private C7770a f985a = new C7770a();

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: Taobao */
        /* renamed from: com.xiaomi.push.service.p$c$a */
        /* loaded from: classes11.dex */
        public static final class C7770a {
            private int a;

            /* renamed from: a  reason: collision with other field name */
            private C7771d[] f988a;
            private int b;
            private int c;

            private C7770a() {
                this.a = 256;
                this.f988a = new C7771d[256];
                this.b = 0;
                this.c = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int a(C7771d c7771d) {
                int i = 0;
                while (true) {
                    C7771d[] c7771dArr = this.f988a;
                    if (i >= c7771dArr.length) {
                        return -1;
                    }
                    if (c7771dArr[i] == c7771d) {
                        return i;
                    }
                    i++;
                }
            }

            private void b(C7771d c7771d) {
                Intent a;
                AbstractRunnableC7768b abstractRunnableC7768b = c7771d.f990a;
                int i = abstractRunnableC7768b.a;
                if (i == 8) {
                    XMPushService.C7701d c7701d = (XMPushService.C7701d) abstractRunnableC7768b;
                    if (c7701d.a().f364a != null) {
                        c7701d.a().f364a.f894b = System.currentTimeMillis();
                        c7701d.a().f364a.b = a(c7771d);
                    }
                } else if (i == 15 && (a = ((XMPushService.C7706i) abstractRunnableC7768b).a()) != null && "10".equals(a.getStringExtra("ext_chid"))) {
                    a.putExtra("enqueue", System.currentTimeMillis());
                    a.putExtra(GiftNumBean.KEY_NUM, a(c7771d));
                }
            }

            private void c() {
                int i = this.b - 1;
                int i2 = (i - 1) / 2;
                while (true) {
                    C7771d[] c7771dArr = this.f988a;
                    if (c7771dArr[i].f989a >= c7771dArr[i2].f989a) {
                        return;
                    }
                    C7771d c7771d = c7771dArr[i];
                    c7771dArr[i] = c7771dArr[i2];
                    c7771dArr[i2] = c7771d;
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
                        C7771d[] c7771dArr = this.f988a;
                        if (c7771dArr[i4].f989a < c7771dArr[i2].f989a) {
                            i2 = i4;
                        }
                    }
                    C7771d[] c7771dArr2 = this.f988a;
                    if (c7771dArr2[i].f989a < c7771dArr2[i2].f989a) {
                        return;
                    }
                    C7771d c7771d = c7771dArr2[i];
                    c7771dArr2[i] = c7771dArr2[i2];
                    c7771dArr2[i2] = c7771d;
                    int i5 = i2;
                    i2 = (i2 * 2) + 1;
                    i = i5;
                }
            }

            public C7771d a() {
                return this.f988a[0];
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m1233a() {
                this.f988a = new C7771d[this.a];
                this.b = 0;
            }

            public void a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    C7771d[] c7771dArr = this.f988a;
                    if (c7771dArr[i2].a == i) {
                        c7771dArr[i2].a();
                    }
                }
                b();
            }

            public void a(int i, AbstractRunnableC7768b abstractRunnableC7768b) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    C7771d[] c7771dArr = this.f988a;
                    if (c7771dArr[i2].f990a == abstractRunnableC7768b) {
                        c7771dArr[i2].a();
                    }
                }
                b();
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m1234a(C7771d c7771d) {
                C7771d[] c7771dArr = this.f988a;
                int length = c7771dArr.length;
                int i = this.b;
                if (length == i) {
                    C7771d[] c7771dArr2 = new C7771d[i * 2];
                    System.arraycopy(c7771dArr, 0, c7771dArr2, 0, i);
                    this.f988a = c7771dArr2;
                }
                C7771d[] c7771dArr3 = this.f988a;
                int i2 = this.b;
                this.b = i2 + 1;
                c7771dArr3[i2] = c7771d;
                c();
                b(c7771d);
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
                C7771d[] c7771dArr = this.f988a;
                int i3 = i2 - 1;
                this.b = i3;
                c7771dArr[i] = c7771dArr[i3];
                c7771dArr[i3] = null;
                c(i);
            }
        }

        C7769c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(C7771d c7771d) {
            this.f985a.m1234a(c7771d);
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
                long r0 = com.xiaomi.push.service.C7766p.a()     // Catch: java.lang.Throwable -> Lae
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
                int r1 = com.xiaomi.push.service.C7766p.C7769c.C7770a.a(r1, r2)     // Catch: java.lang.Throwable -> La8
                goto L70
            L6f:
                r1 = 0
            L70:
                boolean r6 = r2.f992a     // Catch: java.lang.Throwable -> La8
                if (r6 == 0) goto L7f
                com.xiaomi.push.service.p$c$a r1 = r10.f985a     // Catch: java.lang.Throwable -> La8
                int r2 = com.xiaomi.push.service.C7766p.C7769c.C7770a.a(r1, r2)     // Catch: java.lang.Throwable -> La8
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
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C7766p.C7769c.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.p$d */
    /* loaded from: classes11.dex */
    public static class C7771d {
        int a;

        /* renamed from: a  reason: collision with other field name */
        long f989a;

        /* renamed from: a  reason: collision with other field name */
        AbstractRunnableC7768b f990a;

        /* renamed from: a  reason: collision with other field name */
        final Object f991a = new Object();

        /* renamed from: a  reason: collision with other field name */
        boolean f992a;
        private long b;

        C7771d() {
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

    public C7766p() {
        this(false);
    }

    public C7766p(String str) {
        this(str, false);
    }

    public C7766p(String str, boolean z) {
        Objects.requireNonNull(str, "name == null");
        C7769c c7769c = new C7769c(str, z);
        this.f984a = c7769c;
        this.f983a = new C7767a(c7769c);
    }

    public C7766p(boolean z) {
        this("Timer-" + b(), z);
    }

    static synchronized long a() {
        long j;
        synchronized (C7766p.class) {
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
        synchronized (C7766p.class) {
            j = c;
            c = 1 + j;
        }
        return j;
    }

    private void b(AbstractRunnableC7768b abstractRunnableC7768b, long j) {
        synchronized (this.f984a) {
            if (this.f984a.f987b) {
                throw new IllegalStateException("Timer was canceled");
            }
            long a2 = j + a();
            if (a2 < 0) {
                throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
            }
            C7771d c7771d = new C7771d();
            c7771d.a = abstractRunnableC7768b.a;
            c7771d.f990a = abstractRunnableC7768b;
            c7771d.f989a = a2;
            this.f984a.a(c7771d);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1227a() {
        AbstractC7535b.m586a("quit. finalizer:" + this.f983a);
        this.f984a.a();
    }

    public void a(int i) {
        synchronized (this.f984a) {
            this.f984a.f985a.a(i);
        }
    }

    public void a(int i, AbstractRunnableC7768b abstractRunnableC7768b) {
        synchronized (this.f984a) {
            this.f984a.f985a.a(i, abstractRunnableC7768b);
        }
    }

    public void a(AbstractRunnableC7768b abstractRunnableC7768b) {
        if (AbstractC7535b.a() >= 1 || Thread.currentThread() == this.f984a) {
            abstractRunnableC7768b.run();
        } else {
            AbstractC7535b.d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
    }

    public void a(AbstractRunnableC7768b abstractRunnableC7768b, long j) {
        if (j >= 0) {
            b(abstractRunnableC7768b, j);
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
