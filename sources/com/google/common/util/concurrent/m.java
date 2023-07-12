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
/* loaded from: classes10.dex */
public final class m {
    private final boolean a;
    private final ReentrantLock b;
    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private a c;

    /* compiled from: Taobao */
    @Beta
    /* loaded from: classes10.dex */
    public static abstract class a {
        @Weak
        final m a;
        final Condition b;
        @GuardedBy("monitor.lock")
        int c = 0;
        @NullableDecl
        @GuardedBy("monitor.lock")
        a d;

        /* JADX INFO: Access modifiers changed from: protected */
        public a(m mVar) {
            this.a = (m) du1.q(mVar, "monitor");
            this.b = mVar.b.newCondition();
        }

        public abstract boolean a();
    }

    public m() {
        this(false);
    }

    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private boolean b(a aVar, long j, boolean z) throws InterruptedException {
        boolean z2 = true;
        while (j > 0) {
            if (z2) {
                if (z) {
                    try {
                        p();
                    } finally {
                        if (!z2) {
                            e(aVar);
                        }
                    }
                }
                d(aVar);
                z2 = false;
            }
            j = aVar.b.awaitNanos(j);
            if (aVar.a()) {
                if (!z2) {
                    e(aVar);
                }
                return true;
            }
        }
        return false;
    }

    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private void c(a aVar, boolean z) {
        if (z) {
            p();
        }
        d(aVar);
        do {
            try {
                aVar.b.awaitUninterruptibly();
            } finally {
                e(aVar);
            }
        } while (!aVar.a());
    }

    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private void d(a aVar) {
        int i = aVar.c;
        aVar.c = i + 1;
        if (i == 0) {
            aVar.d = this.c;
            this.c = aVar;
        }
    }

    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private void e(a aVar) {
        int i = aVar.c - 1;
        aVar.c = i;
        if (i == 0) {
            a aVar2 = this.c;
            a aVar3 = null;
            while (aVar2 != aVar) {
                aVar3 = aVar2;
                aVar2 = aVar2.d;
            }
            if (aVar3 == null) {
                this.c = aVar2.d;
            } else {
                aVar3.d = aVar2.d;
            }
            aVar2.d = null;
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
    private boolean l(a aVar) {
        try {
            return aVar.a();
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
        for (a aVar = this.c; aVar != null; aVar = aVar.d) {
            aVar.b.signalAll();
        }
    }

    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private void p() {
        for (a aVar = this.c; aVar != null; aVar = aVar.d) {
            if (l(aVar)) {
                aVar.b.signal();
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

    public boolean g(a aVar) {
        if (aVar.a == this) {
            ReentrantLock reentrantLock = this.b;
            reentrantLock.lock();
            try {
                boolean a2 = aVar.a();
                if (!a2) {
                }
                return a2;
            } finally {
                reentrantLock.unlock();
            }
        }
        throw new IllegalMonitorStateException();
    }

    public void h(a aVar) {
        if (aVar.a == this) {
            ReentrantLock reentrantLock = this.b;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            reentrantLock.lock();
            try {
                if (aVar.a()) {
                    return;
                }
                c(aVar, isHeldByCurrentThread);
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
    public boolean i(com.google.common.util.concurrent.m.a r12, long r13, java.util.concurrent.TimeUnit r15) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.m.i(com.google.common.util.concurrent.m$a, long, java.util.concurrent.TimeUnit):boolean");
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

    public m(boolean z) {
        this.c = null;
        this.a = z;
        this.b = new ReentrantLock(z);
    }
}
