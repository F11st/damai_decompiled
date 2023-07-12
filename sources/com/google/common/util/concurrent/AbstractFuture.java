package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.C4844i;
import com.google.common.util.concurrent.internal.AbstractC5351a;
import com.google.common.util.concurrent.internal.C5352b;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.j2objc.annotations.ReflectionSupport;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;
import tb.du1;
import tb.jn1;

/* compiled from: Taobao */
@ReflectionSupport(ReflectionSupport.Level.FULL)
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public abstract class AbstractFuture<V> extends AbstractC5351a implements ListenableFuture<V> {
    private static final AbstractC5295b ATOMIC_HELPER;
    private static final Object NULL;
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    @NullableDecl
    private volatile C5297d listeners;
    @NullableDecl
    private volatile Object value;
    @NullableDecl
    private volatile C5303i waiters;
    private static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger log = Logger.getLogger(AbstractFuture.class.getName());

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class Failure {
        static final Failure b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.common.util.concurrent.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable a;

        Failure(Throwable th) {
            this.a = (Throwable) du1.p(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class SetFuture<V> implements Runnable {
        final ListenableFuture<? extends V> future;
        final AbstractFuture<V> owner;

        SetFuture(AbstractFuture<V> abstractFuture, ListenableFuture<? extends V> listenableFuture) {
            this.owner = abstractFuture;
            this.future = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((AbstractFuture) this.owner).value != this) {
                return;
            }
            if (AbstractFuture.ATOMIC_HELPER.b(this.owner, this, AbstractFuture.getFutureValue(this.future))) {
                AbstractFuture.complete(this.owner);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface Trusted<V> extends ListenableFuture<V> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.AbstractFuture$b */
    /* loaded from: classes10.dex */
    public static abstract class AbstractC5295b {
        private AbstractC5295b() {
        }

        abstract boolean a(AbstractFuture<?> abstractFuture, C5297d c5297d, C5297d c5297d2);

        abstract boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        abstract boolean c(AbstractFuture<?> abstractFuture, C5303i c5303i, C5303i c5303i2);

        abstract void d(C5303i c5303i, C5303i c5303i2);

        abstract void e(C5303i c5303i, Thread thread);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.AbstractFuture$c */
    /* loaded from: classes10.dex */
    public static final class C5296c {
        static final C5296c c;
        static final C5296c d;
        final boolean a;
        @NullableDecl
        final Throwable b;

        static {
            if (AbstractFuture.GENERATE_CANCELLATION_CAUSES) {
                d = null;
                c = null;
                return;
            }
            d = new C5296c(false, null);
            c = new C5296c(true, null);
        }

        C5296c(boolean z, @NullableDecl Throwable th) {
            this.a = z;
            this.b = th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.AbstractFuture$d */
    /* loaded from: classes10.dex */
    public static final class C5297d {
        static final C5297d d = new C5297d(null, null);
        final Runnable a;
        final Executor b;
        @NullableDecl
        C5297d c;

        C5297d(Runnable runnable, Executor executor) {
            this.a = runnable;
            this.b = executor;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.AbstractFuture$e */
    /* loaded from: classes10.dex */
    private static final class C5298e extends AbstractC5295b {
        final AtomicReferenceFieldUpdater<C5303i, Thread> a;
        final AtomicReferenceFieldUpdater<C5303i, C5303i> b;
        final AtomicReferenceFieldUpdater<AbstractFuture, C5303i> c;
        final AtomicReferenceFieldUpdater<AbstractFuture, C5297d> d;
        final AtomicReferenceFieldUpdater<AbstractFuture, Object> e;

        C5298e(AtomicReferenceFieldUpdater<C5303i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<C5303i, C5303i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, C5303i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, C5297d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AbstractC5295b
        boolean a(AbstractFuture<?> abstractFuture, C5297d c5297d, C5297d c5297d2) {
            return this.d.compareAndSet(abstractFuture, c5297d, c5297d2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AbstractC5295b
        boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return this.e.compareAndSet(abstractFuture, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AbstractC5295b
        boolean c(AbstractFuture<?> abstractFuture, C5303i c5303i, C5303i c5303i2) {
            return this.c.compareAndSet(abstractFuture, c5303i, c5303i2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AbstractC5295b
        void d(C5303i c5303i, C5303i c5303i2) {
            this.b.lazySet(c5303i, c5303i2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AbstractC5295b
        void e(C5303i c5303i, Thread thread) {
            this.a.lazySet(c5303i, thread);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.AbstractFuture$f */
    /* loaded from: classes10.dex */
    private static final class C5299f extends AbstractC5295b {
        private C5299f() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AbstractC5295b
        boolean a(AbstractFuture<?> abstractFuture, C5297d c5297d, C5297d c5297d2) {
            synchronized (abstractFuture) {
                if (((AbstractFuture) abstractFuture).listeners == c5297d) {
                    ((AbstractFuture) abstractFuture).listeners = c5297d2;
                    return true;
                }
                return false;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AbstractC5295b
        boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                if (((AbstractFuture) abstractFuture).value == obj) {
                    ((AbstractFuture) abstractFuture).value = obj2;
                    return true;
                }
                return false;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AbstractC5295b
        boolean c(AbstractFuture<?> abstractFuture, C5303i c5303i, C5303i c5303i2) {
            synchronized (abstractFuture) {
                if (((AbstractFuture) abstractFuture).waiters == c5303i) {
                    ((AbstractFuture) abstractFuture).waiters = c5303i2;
                    return true;
                }
                return false;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AbstractC5295b
        void d(C5303i c5303i, C5303i c5303i2) {
            c5303i.b = c5303i2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AbstractC5295b
        void e(C5303i c5303i, Thread thread) {
            c5303i.a = thread;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.AbstractFuture$g */
    /* loaded from: classes10.dex */
    static abstract class AbstractC5300g<V> extends AbstractFuture<V> implements Trusted<V> {
        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.ListenableFuture
        public final void addListener(Runnable runnable, Executor executor) {
            super.addListener(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final boolean cancel(boolean z) {
            return super.cancel(z);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final V get() throws InterruptedException, ExecutionException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) super.get(j, timeUnit);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.AbstractFuture$h */
    /* loaded from: classes10.dex */
    private static final class C5301h extends AbstractC5295b {
        static final Unsafe a;
        static final long b;
        static final long c;
        static final long d;
        static final long e;
        static final long f;

        /* compiled from: Taobao */
        /* renamed from: com.google.common.util.concurrent.AbstractFuture$h$a */
        /* loaded from: classes10.dex */
        static class C5302a implements PrivilegedExceptionAction<Unsafe> {
            C5302a() {
            }

            @Override // java.security.PrivilegedExceptionAction
            /* renamed from: a */
            public Unsafe run() throws Exception {
                Field[] declaredFields;
                for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    unsafe = (Unsafe) AccessController.doPrivileged(new C5302a());
                }
                try {
                    c = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("waiters"));
                    b = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("listeners"));
                    d = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("value"));
                    e = unsafe.objectFieldOffset(C5303i.class.getDeclaredField("a"));
                    f = unsafe.objectFieldOffset(C5303i.class.getDeclaredField("b"));
                    a = unsafe;
                } catch (Exception e2) {
                    C4844i.f(e2);
                    throw new RuntimeException(e2);
                }
            } catch (PrivilegedActionException e3) {
                throw new RuntimeException("Could not initialize intrinsics", e3.getCause());
            }
        }

        private C5301h() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AbstractC5295b
        boolean a(AbstractFuture<?> abstractFuture, C5297d c5297d, C5297d c5297d2) {
            return a.compareAndSwapObject(abstractFuture, b, c5297d, c5297d2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AbstractC5295b
        boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return a.compareAndSwapObject(abstractFuture, d, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AbstractC5295b
        boolean c(AbstractFuture<?> abstractFuture, C5303i c5303i, C5303i c5303i2) {
            return a.compareAndSwapObject(abstractFuture, c, c5303i, c5303i2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AbstractC5295b
        void d(C5303i c5303i, C5303i c5303i2) {
            a.putObject(c5303i, f, c5303i2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AbstractC5295b
        void e(C5303i c5303i, Thread thread) {
            a.putObject(c5303i, e, thread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.AbstractFuture$i */
    /* loaded from: classes10.dex */
    public static final class C5303i {
        static final C5303i c = new C5303i(false);
        @NullableDecl
        volatile Thread a;
        @NullableDecl
        volatile C5303i b;

        C5303i(boolean z) {
        }

        void a(C5303i c5303i) {
            AbstractFuture.ATOMIC_HELPER.d(this, c5303i);
        }

        void b() {
            Thread thread = this.a;
            if (thread != null) {
                this.a = null;
                LockSupport.unpark(thread);
            }
        }

        C5303i() {
            AbstractFuture.ATOMIC_HELPER.e(this, Thread.currentThread());
        }
    }

    static {
        AbstractC5295b c5299f;
        Throwable th = null;
        try {
            c5299f = new C5301h();
            th = null;
        } catch (Throwable th2) {
            th = th2;
            try {
                c5299f = new C5298e(AtomicReferenceFieldUpdater.newUpdater(C5303i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(C5303i.class, C5303i.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, C5303i.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, C5297d.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "value"));
            } catch (Throwable th3) {
                c5299f = new C5299f();
                th = th3;
            }
        }
        ATOMIC_HELPER = c5299f;
        if (th != null) {
            Logger logger = log;
            Level level = Level.SEVERE;
            logger.log(level, "UnsafeAtomicHelper is broken!", th);
            logger.log(level, "SafeAtomicHelper is broken!", th);
        }
        NULL = new Object();
    }

    private void addDoneString(StringBuilder sb) {
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb.append("SUCCESS, result=[");
            sb.append(userObjectToString(uninterruptibly));
            sb.append(jn1.ARRAY_END_STR);
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append(jn1.ARRAY_END_STR);
        }
    }

    private static CancellationException cancellationExceptionWithCause(@NullableDecl String str, @NullableDecl Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    private C5297d clearListeners(C5297d c5297d) {
        C5297d c5297d2;
        do {
            c5297d2 = this.listeners;
        } while (!ATOMIC_HELPER.a(this, c5297d2, C5297d.d));
        C5297d c5297d3 = c5297d;
        C5297d c5297d4 = c5297d2;
        while (c5297d4 != null) {
            C5297d c5297d5 = c5297d4.c;
            c5297d4.c = c5297d3;
            c5297d3 = c5297d4;
            c5297d4 = c5297d5;
        }
        return c5297d3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.google.common.util.concurrent.AbstractFuture$b] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.common.util.concurrent.AbstractFuture<?>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.google.common.util.concurrent.AbstractFuture] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.google.common.util.concurrent.AbstractFuture<V>, com.google.common.util.concurrent.AbstractFuture] */
    public static void complete(AbstractFuture<?> abstractFuture) {
        C5297d c5297d = null;
        while (true) {
            abstractFuture.releaseWaiters();
            abstractFuture.afterDone();
            C5297d clearListeners = abstractFuture.clearListeners(c5297d);
            while (clearListeners != null) {
                c5297d = clearListeners.c;
                Runnable runnable = clearListeners.a;
                if (runnable instanceof SetFuture) {
                    SetFuture setFuture = (SetFuture) runnable;
                    abstractFuture = setFuture.owner;
                    if (((AbstractFuture) abstractFuture).value == setFuture) {
                        if (ATOMIC_HELPER.b(abstractFuture, setFuture, getFutureValue(setFuture.future))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    executeListener(runnable, clearListeners.b);
                }
                clearListeners = c5297d;
            }
            return;
        }
    }

    private static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = log;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V getDoneValue(Object obj) throws ExecutionException {
        if (!(obj instanceof C5296c)) {
            if (!(obj instanceof Failure)) {
                if (obj == NULL) {
                    return null;
                }
                return obj;
            }
            throw new ExecutionException(((Failure) obj).a);
        }
        throw cancellationExceptionWithCause("Task was cancelled.", ((C5296c) obj).b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getFutureValue(ListenableFuture<?> listenableFuture) {
        Throwable a;
        if (listenableFuture instanceof Trusted) {
            Object obj = ((AbstractFuture) listenableFuture).value;
            if (obj instanceof C5296c) {
                C5296c c5296c = (C5296c) obj;
                return c5296c.a ? c5296c.b != null ? new C5296c(false, c5296c.b) : C5296c.d : obj;
            }
            return obj;
        } else if ((listenableFuture instanceof AbstractC5351a) && (a = C5352b.a((AbstractC5351a) listenableFuture)) != null) {
            return new Failure(a);
        } else {
            boolean isCancelled = listenableFuture.isCancelled();
            if ((!GENERATE_CANCELLATION_CAUSES) & isCancelled) {
                return C5296c.d;
            }
            try {
                Object uninterruptibly = getUninterruptibly(listenableFuture);
                if (!isCancelled) {
                    return uninterruptibly == null ? NULL : uninterruptibly;
                }
                return new C5296c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture));
            } catch (CancellationException e) {
                if (!isCancelled) {
                    return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e));
                }
                return new C5296c(false, e);
            } catch (ExecutionException e2) {
                if (isCancelled) {
                    return new C5296c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture, e2));
                }
                return new Failure(e2.getCause());
            } catch (Throwable th) {
                return new Failure(th);
            }
        }
    }

    private static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    private void releaseWaiters() {
        C5303i c5303i;
        do {
            c5303i = this.waiters;
        } while (!ATOMIC_HELPER.c(this, c5303i, C5303i.c));
        while (c5303i != null) {
            c5303i.b();
            c5303i = c5303i.b;
        }
    }

    private void removeWaiter(C5303i c5303i) {
        c5303i.a = null;
        while (true) {
            C5303i c5303i2 = this.waiters;
            if (c5303i2 == C5303i.c) {
                return;
            }
            C5303i c5303i3 = null;
            while (c5303i2 != null) {
                C5303i c5303i4 = c5303i2.b;
                if (c5303i2.a != null) {
                    c5303i3 = c5303i2;
                } else if (c5303i3 != null) {
                    c5303i3.b = c5303i4;
                    if (c5303i3.a == null) {
                        break;
                    }
                } else if (!ATOMIC_HELPER.c(this, c5303i2, c5303i4)) {
                    break;
                }
                c5303i2 = c5303i4;
            }
            return;
        }
    }

    private String userObjectToString(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        C5297d c5297d;
        du1.q(runnable, "Runnable was null.");
        du1.q(executor, "Executor was null.");
        if (!isDone() && (c5297d = this.listeners) != C5297d.d) {
            C5297d c5297d2 = new C5297d(runnable, executor);
            do {
                c5297d2.c = c5297d;
                if (ATOMIC_HELPER.a(this, c5297d, c5297d2)) {
                    return;
                }
                c5297d = this.listeners;
            } while (c5297d != C5297d.d);
            executeListener(runnable, executor);
        }
        executeListener(runnable, executor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Beta
    @ForOverride
    public void afterDone() {
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public boolean cancel(boolean z) {
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof SetFuture)) {
            return false;
        }
        C5296c c5296c = GENERATE_CANCELLATION_CAUSES ? new C5296c(z, new CancellationException("Future.cancel() was called.")) : z ? C5296c.c : C5296c.d;
        boolean z2 = false;
        AbstractFuture<V> abstractFuture = this;
        while (true) {
            if (ATOMIC_HELPER.b(abstractFuture, obj, c5296c)) {
                if (z) {
                    abstractFuture.interruptTask();
                }
                complete(abstractFuture);
                if (!(obj instanceof SetFuture)) {
                    return true;
                }
                ListenableFuture<? extends V> listenableFuture = ((SetFuture) obj).future;
                if (listenableFuture instanceof Trusted) {
                    abstractFuture = (AbstractFuture) listenableFuture;
                    obj = abstractFuture.value;
                    if (!(obj == null) && !(obj instanceof SetFuture)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    listenableFuture.cancel(z);
                    return true;
                }
            } else {
                obj = abstractFuture.value;
                if (!(obj instanceof SetFuture)) {
                    return z2;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public V get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        Locale locale;
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            if ((obj != null) & (!(obj instanceof SetFuture))) {
                return getDoneValue(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                C5303i c5303i = this.waiters;
                if (c5303i != C5303i.c) {
                    C5303i c5303i2 = new C5303i();
                    do {
                        c5303i2.a(c5303i);
                        if (ATOMIC_HELPER.c(this, c5303i, c5303i2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
                                        return getDoneValue(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    removeWaiter(c5303i2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            removeWaiter(c5303i2);
                        } else {
                            c5303i = this.waiters;
                        }
                    } while (c5303i != C5303i.c);
                    return getDoneValue(this.value);
                }
                return getDoneValue(this.value);
            }
            while (nanos > 0) {
                Object obj3 = this.value;
                if ((obj3 != null) & (!(obj3 instanceof SetFuture))) {
                    return getDoneValue(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractFuture = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String str = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j2 = -nanos;
                long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
                long nanos2 = j2 - timeUnit.toNanos(convert);
                int i = (convert > 0L ? 1 : (convert == 0L ? 0 : -1));
                boolean z = i == 0 || nanos2 > 1000;
                if (i > 0) {
                    String str3 = str2 + convert + " " + lowerCase;
                    if (z) {
                        str3 = str3 + ",";
                    }
                    str2 = str3 + " ";
                }
                if (z) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + abstractFuture);
        }
        throw new InterruptedException();
    }

    protected void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.value instanceof C5296c;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.value;
        return (!(obj instanceof SetFuture)) & (obj != null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void maybePropagateCancellationTo(@NullableDecl Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NullableDecl
    public String pendingToString() {
        Object obj = this.value;
        if (obj instanceof SetFuture) {
            return "setFuture=[" + userObjectToString(((SetFuture) obj).future) + jn1.ARRAY_END_STR;
        } else if (this instanceof ScheduledFuture) {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CanIgnoreReturnValue
    public boolean set(@NullableDecl V v) {
        if (v == null) {
            v = (V) NULL;
        }
        if (ATOMIC_HELPER.b(this, null, v)) {
            complete(this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CanIgnoreReturnValue
    public boolean setException(Throwable th) {
        if (ATOMIC_HELPER.b(this, null, new Failure((Throwable) du1.p(th)))) {
            complete(this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CanIgnoreReturnValue
    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        Failure failure;
        du1.p(listenableFuture);
        Object obj = this.value;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (ATOMIC_HELPER.b(this, null, getFutureValue(listenableFuture))) {
                    complete(this);
                    return true;
                }
                return false;
            }
            SetFuture setFuture = new SetFuture(this, listenableFuture);
            if (ATOMIC_HELPER.b(this, null, setFuture)) {
                try {
                    listenableFuture.addListener(setFuture, DirectExecutor.INSTANCE);
                } catch (Throwable th) {
                    try {
                        failure = new Failure(th);
                    } catch (Throwable unused) {
                        failure = Failure.b;
                    }
                    ATOMIC_HELPER.b(this, setFuture, failure);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof C5296c) {
            listenableFuture.cancel(((C5296c) obj).a);
        }
        return false;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            addDoneString(sb);
        } else {
            try {
                str = pendingToString();
            } catch (RuntimeException e) {
                str = "Exception thrown from implementation: " + e.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append(jn1.ARRAY_END_STR);
            } else if (isDone()) {
                addDoneString(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append(jn1.ARRAY_END_STR);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.internal.AbstractC5351a
    @NullableDecl
    public final Throwable tryInternalFastPathGetFailure() {
        if (this instanceof Trusted) {
            Object obj = this.value;
            if (obj instanceof Failure) {
                return ((Failure) obj).a;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean wasInterrupted() {
        Object obj = this.value;
        return (obj instanceof C5296c) && ((C5296c) obj).a;
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
                return getDoneValue(obj2);
            }
            C5303i c5303i = this.waiters;
            if (c5303i != C5303i.c) {
                C5303i c5303i2 = new C5303i();
                do {
                    c5303i2.a(c5303i);
                    if (ATOMIC_HELPER.c(this, c5303i, c5303i2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                removeWaiter(c5303i2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return getDoneValue(obj);
                    }
                    c5303i = this.waiters;
                } while (c5303i != C5303i.c);
                return getDoneValue(this.value);
            }
            return getDoneValue(this.value);
        }
        throw new InterruptedException();
    }
}
