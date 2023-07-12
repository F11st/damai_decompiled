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
/* renamed from: com.google.common.util.concurrent.d */
/* loaded from: classes10.dex */
abstract class AbstractC5339d {
    private static final AbstractC5341b ATOMIC_HELPER;
    private static final Logger log = Logger.getLogger(AbstractC5339d.class.getName());
    private volatile int remaining;
    private volatile Set<Throwable> seenExceptions = null;

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.d$b */
    /* loaded from: classes10.dex */
    private static abstract class AbstractC5341b {
        private AbstractC5341b() {
        }

        abstract void a(AbstractC5339d abstractC5339d, Set<Throwable> set, Set<Throwable> set2);

        abstract int b(AbstractC5339d abstractC5339d);
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.d$c */
    /* loaded from: classes10.dex */
    private static final class C5342c extends AbstractC5341b {
        final AtomicReferenceFieldUpdater<AbstractC5339d, Set<Throwable>> a;
        final AtomicIntegerFieldUpdater<AbstractC5339d> b;

        C5342c(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicIntegerFieldUpdater;
        }

        @Override // com.google.common.util.concurrent.AbstractC5339d.AbstractC5341b
        void a(AbstractC5339d abstractC5339d, Set<Throwable> set, Set<Throwable> set2) {
            this.a.compareAndSet(abstractC5339d, set, set2);
        }

        @Override // com.google.common.util.concurrent.AbstractC5339d.AbstractC5341b
        int b(AbstractC5339d abstractC5339d) {
            return this.b.decrementAndGet(abstractC5339d);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.d$d */
    /* loaded from: classes10.dex */
    private static final class C5343d extends AbstractC5341b {
        private C5343d() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractC5339d.AbstractC5341b
        void a(AbstractC5339d abstractC5339d, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (abstractC5339d) {
                if (abstractC5339d.seenExceptions == set) {
                    abstractC5339d.seenExceptions = set2;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractC5339d.AbstractC5341b
        int b(AbstractC5339d abstractC5339d) {
            int i;
            synchronized (abstractC5339d) {
                AbstractC5339d.access$310(abstractC5339d);
                i = abstractC5339d.remaining;
            }
            return i;
        }
    }

    static {
        AbstractC5341b c5343d;
        Throwable th = null;
        try {
            c5343d = new C5342c(AtomicReferenceFieldUpdater.newUpdater(AbstractC5339d.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(AbstractC5339d.class, "remaining"));
        } catch (Throwable th2) {
            c5343d = new C5343d();
            th = th2;
        }
        ATOMIC_HELPER = c5343d;
        if (th != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC5339d(int i) {
        this.remaining = i;
    }

    static /* synthetic */ int access$310(AbstractC5339d abstractC5339d) {
        int i = abstractC5339d.remaining;
        abstractC5339d.remaining = i - 1;
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
            Set<Throwable> c = Sets.c();
            addInitialException(c);
            ATOMIC_HELPER.a(this, null, c);
            return this.seenExceptions;
        }
        return set;
    }
}
