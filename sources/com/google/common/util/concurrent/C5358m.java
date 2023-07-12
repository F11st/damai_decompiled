package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import com.taobao.orange.OConstant;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;

/* compiled from: Taobao */
@Beta
@GwtIncompatible
/* renamed from: com.google.common.util.concurrent.m */
/* loaded from: classes10.dex */
public final class C5358m {
    private final boolean a;
    private final ReentrantLock b;
    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private AbstractC5359a c;

    /* compiled from: Taobao */
    @Beta
    /* renamed from: com.google.common.util.concurrent.m$a */
    /* loaded from: classes10.dex */
    public static abstract class AbstractC5359a {
        @Weak
        final C5358m a;
        final Condition b;
        @GuardedBy("monitor.lock")
        int c = 0;
        @NullableDecl
        @GuardedBy("monitor.lock")
        AbstractC5359a d;

        /* JADX INFO: Access modifiers changed from: protected */
        public AbstractC5359a(C5358m c5358m) {
            this.a = (C5358m) du1.q(c5358m, "monitor");
            this.b = c5358m.b.newCondition();
        }

        public abstract boolean a();
    }

    public C5358m() {
        this(false);
    }

    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private boolean b(AbstractC5359a abstractC5359a, long j, boolean z) throws InterruptedException {
        boolean z2 = true;
        while (j > 0) {
            if (z2) {
                if (z) {
                    try {
                        p();
                    } finally {
                        if (!z2) {
                            e(abstractC5359a);
                        }
                    }
                }
                d(abstractC5359a);
                z2 = false;
            }
            j = abstractC5359a.b.awaitNanos(j);
            if (abstractC5359a.a()) {
                if (!z2) {
                    e(abstractC5359a);
                }
                return true;
            }
        }
        return false;
    }

    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private void c(AbstractC5359a abstractC5359a, boolean z) {
        if (z) {
            p();
        }
        d(abstractC5359a);
        do {
            try {
                abstractC5359a.b.awaitUninterruptibly();
            } finally {
                e(abstractC5359a);
            }
        } while (!abstractC5359a.a());
    }

    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private void d(AbstractC5359a abstractC5359a) {
        int i = abstractC5359a.c;
        abstractC5359a.c = i + 1;
        if (i == 0) {
            abstractC5359a.d = this.c;
            this.c = abstractC5359a;
        }
    }

    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private void e(AbstractC5359a abstractC5359a) {
        int i = abstractC5359a.c - 1;
        abstractC5359a.c = i;
        if (i == 0) {
            AbstractC5359a abstractC5359a2 = this.c;
            AbstractC5359a abstractC5359a3 = null;
            while (abstractC5359a2 != abstractC5359a) {
                abstractC5359a3 = abstractC5359a2;
                abstractC5359a2 = abstractC5359a2.d;
            }
            if (abstractC5359a3 == null) {
                this.c = abstractC5359a2.d;
            } else {
                abstractC5359a3.d = abstractC5359a2.d;
            }
            abstractC5359a2.d = null;
        }
    }

    private static long j(long j) {
        if (j <= 0) {
            return 0L;
        }
        long nanoTime = System.nanoTime();
        if (nanoTime == 0) {
            return 1L;
        }
        return nanoTime;
    }

    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private boolean l(AbstractC5359a abstractC5359a) {
        try {
            return abstractC5359a.a();
        } catch (Throwable th) {
            o();
            throw th;
        }
    }

    private static long n(long j, long j2) {
        if (j2 <= 0) {
            return 0L;
        }
        return j2 - (System.nanoTime() - j);
    }

    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private void o() {
        for (AbstractC5359a abstractC5359a = this.c; abstractC5359a != null; abstractC5359a = abstractC5359a.d) {
            abstractC5359a.b.signalAll();
        }
    }

    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private void p() {
        for (AbstractC5359a abstractC5359a = this.c; abstractC5359a != null; abstractC5359a = abstractC5359a.d) {
            if (l(abstractC5359a)) {
                abstractC5359a.b.signal();
                return;
            }
        }
    }

    private static long q(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        if (nanos <= 0) {
            return 0L;
        }
        if (nanos > 6917529027641081853L) {
            return 6917529027641081853L;
        }
        return nanos;
    }

    public void f() {
        this.b.lock();
    }

    public boolean g(AbstractC5359a abstractC5359a) {
        if (abstractC5359a.a == this) {
            ReentrantLock reentrantLock = this.b;
            reentrantLock.lock();
            try {
                boolean a = abstractC5359a.a();
                if (!a) {
                }
                return a;
            } finally {
                reentrantLock.unlock();
            }
        }
        throw new IllegalMonitorStateException();
    }

    public void h(AbstractC5359a abstractC5359a) {
        if (abstractC5359a.a == this) {
            ReentrantLock reentrantLock = this.b;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            reentrantLock.lock();
            try {
                if (abstractC5359a.a()) {
                    return;
                }
                c(abstractC5359a, isHeldByCurrentThread);
                return;
            } catch (Throwable th) {
                m();
                throw th;
            }
        }
        throw new IllegalMonitorStateException();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b A[Catch: all -> 0x0073, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0073, blocks: (B:5:0x0013, B:7:0x001a, B:24:0x004b, B:11:0x0023, B:13:0x0028, B:15:0x0030, B:20:0x003b, B:22:0x0045, B:21:0x0041), top: B:45:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean i(com.google.common.util.concurrent.C5358m.AbstractC5359a r12, long r13, java.util.concurrent.TimeUnit r15) {
        /*
            r11 = this;
            long r13 = q(r13, r15)
            com.google.common.util.concurrent.m r15 = r12.a
            if (r15 != r11) goto L7e
            java.util.concurrent.locks.ReentrantLock r15 = r11.b
            boolean r0 = r15.isHeldByCurrentThread()
            boolean r1 = java.lang.Thread.interrupted()
            r2 = 1
            boolean r3 = r11.a     // Catch: java.lang.Throwable -> L73
            r4 = 0
            r5 = 0
            if (r3 != 0) goto L23
            boolean r3 = r15.tryLock()     // Catch: java.lang.Throwable -> L73
            if (r3 != 0) goto L21
            goto L23
        L21:
            r7 = r5
            goto L30
        L23:
            long r7 = j(r13)     // Catch: java.lang.Throwable -> L73
            r9 = r13
        L28:
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.InterruptedException -> L6a java.lang.Throwable -> L73
            boolean r3 = r15.tryLock(r9, r3)     // Catch: java.lang.InterruptedException -> L6a java.lang.Throwable -> L73
            if (r3 == 0) goto L60
        L30:
            boolean r3 = r12.a()     // Catch: java.lang.Throwable -> L58 java.lang.InterruptedException -> L5d
            if (r3 == 0) goto L37
            goto L49
        L37:
            int r3 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r3 != 0) goto L41
            long r7 = j(r13)     // Catch: java.lang.Throwable -> L58 java.lang.InterruptedException -> L5d
            r9 = r13
            goto L45
        L41:
            long r9 = n(r7, r13)     // Catch: java.lang.Throwable -> L58 java.lang.InterruptedException -> L5d
        L45:
            boolean r2 = r11.b(r12, r9, r0)     // Catch: java.lang.Throwable -> L58 java.lang.InterruptedException -> L5d
        L49:
            if (r2 != 0) goto L4e
            r15.unlock()     // Catch: java.lang.Throwable -> L73
        L4e:
            if (r1 == 0) goto L57
            java.lang.Thread r12 = java.lang.Thread.currentThread()
            r12.interrupt()
        L57:
            return r2
        L58:
            r12 = move-exception
            r15.unlock()     // Catch: java.lang.Throwable -> L73
            throw r12     // Catch: java.lang.Throwable -> L73
        L5d:
            r0 = 0
            r1 = 1
            goto L30
        L60:
            if (r1 == 0) goto L69
            java.lang.Thread r12 = java.lang.Thread.currentThread()
            r12.interrupt()
        L69:
            return r4
        L6a:
            long r9 = n(r7, r13)     // Catch: java.lang.Throwable -> L70
            r1 = 1
            goto L28
        L70:
            r12 = move-exception
            r1 = 1
            goto L74
        L73:
            r12 = move-exception
        L74:
            if (r1 == 0) goto L7d
            java.lang.Thread r13 = java.lang.Thread.currentThread()
            r13.interrupt()
        L7d:
            throw r12
        L7e:
            java.lang.IllegalMonitorStateException r12 = new java.lang.IllegalMonitorStateException
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.C5358m.i(com.google.common.util.concurrent.m$a, long, java.util.concurrent.TimeUnit):boolean");
    }

    public boolean k() {
        return this.b.isHeldByCurrentThread();
    }

    public void m() {
        ReentrantLock reentrantLock = this.b;
        try {
            if (reentrantLock.getHoldCount() == 1) {
                p();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public C5358m(boolean z) {
        this.c = null;
        this.a = z;
        this.b = new ReentrantLock(z);
    }
}
