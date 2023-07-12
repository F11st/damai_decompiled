package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;
import tb.du1;

/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public final class Callables {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.Callables$a */
    /* loaded from: classes10.dex */
    static class CallableC5309a<T> implements Callable<T> {
        final /* synthetic */ Supplier a;
        final /* synthetic */ Callable b;

        CallableC5309a(Supplier supplier, Callable callable) {
            this.a = supplier;
            this.b = callable;
        }

        @Override // java.util.concurrent.Callable
        public T call() throws Exception {
            Thread currentThread = Thread.currentThread();
            String name = currentThread.getName();
            boolean d = Callables.d((String) this.a.get(), currentThread);
            try {
                return (T) this.b.call();
            } finally {
                if (d) {
                    Callables.d(name, currentThread);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    public static Runnable b(final Runnable runnable, final Supplier<String> supplier) {
        du1.p(supplier);
        du1.p(runnable);
        return new Runnable() { // from class: com.google.common.util.concurrent.Callables.4
            @Override // java.lang.Runnable
            public void run() {
                Thread currentThread = Thread.currentThread();
                String name = currentThread.getName();
                boolean d = Callables.d((String) Supplier.this.get(), currentThread);
                try {
                    runnable.run();
                } finally {
                    if (d) {
                        Callables.d(name, currentThread);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    public static <T> Callable<T> c(Callable<T> callable, Supplier<String> supplier) {
        du1.p(supplier);
        du1.p(callable);
        return new CallableC5309a(supplier, callable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GwtIncompatible
    public static boolean d(String str, Thread thread) {
        try {
            thread.setName(str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
