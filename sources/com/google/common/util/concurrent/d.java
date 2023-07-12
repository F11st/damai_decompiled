package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Sets;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Taobao */
@ReflectionSupport(ReflectionSupport.Level.FULL)
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
abstract class d {
    private static final b ATOMIC_HELPER;
    private static final Logger log = Logger.getLogger(d.class.getName());
    private volatile int remaining;
    private volatile Set<Throwable> seenExceptions = null;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static abstract class b {
        private b() {
        }

        abstract void a(d dVar, Set<Throwable> set, Set<Throwable> set2);

        abstract int b(d dVar);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static final class c extends b {
        final AtomicReferenceFieldUpdater<d, Set<Throwable>> a;
        final AtomicIntegerFieldUpdater<d> b;

        c(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicIntegerFieldUpdater;
        }

        @Override // com.google.common.util.concurrent.d.b
        void a(d dVar, Set<Throwable> set, Set<Throwable> set2) {
            this.a.compareAndSet(dVar, set, set2);
        }

        @Override // com.google.common.util.concurrent.d.b
        int b(d dVar) {
            return this.b.decrementAndGet(dVar);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.d$d  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static final class C0243d extends b {
        private C0243d() {
            super();
        }

        @Override // com.google.common.util.concurrent.d.b
        void a(d dVar, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (dVar) {
                if (dVar.seenExceptions == set) {
                    dVar.seenExceptions = set2;
                }
            }
        }

        @Override // com.google.common.util.concurrent.d.b
        int b(d dVar) {
            int i;
            synchronized (dVar) {
                d.access$310(dVar);
                i = dVar.remaining;
            }
            return i;
        }
    }

    static {
        b c0243d;
        Throwable th = null;
        try {
            c0243d = new c(AtomicReferenceFieldUpdater.newUpdater(d.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(d.class, "remaining"));
        } catch (Throwable th2) {
            c0243d = new C0243d();
            th = th2;
        }
        ATOMIC_HELPER = c0243d;
        if (th != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i) {
        this.remaining = i;
    }

    static /* synthetic */ int access$310(d dVar) {
        int i = dVar.remaining;
        dVar.remaining = i - 1;
        return i;
    }

    abstract void addInitialException(Set<Throwable> set);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int decrementRemainingAndGet() {
        return ATOMIC_HELPER.b(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<Throwable> getOrInitSeenExceptions() {
        Set<Throwable> set = this.seenExceptions;
        if (set == null) {
            Set<Throwable> c2 = Sets.c();
            addInitialException(c2);
            ATOMIC_HELPER.a(this, null, c2);
            return this.seenExceptions;
        }
        return set;
    }
}
