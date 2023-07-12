package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import tb.kb1;
import tb.kc1;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class LottieTask<T> {
    public static Executor e = Executors.newCachedThreadPool();
    private final Set<LottieListener<T>> a;
    private final Set<LottieListener<Throwable>> b;
    private final Handler c;
    @Nullable
    private volatile kc1<T> d;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    private class LottieFutureTask extends FutureTask<kc1<T>> {
        LottieFutureTask(Callable<kc1<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                LottieTask.this.l(get());
            } catch (InterruptedException | ExecutionException e) {
                LottieTask.this.l(new kc1(e));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieTask(Callable<kc1<T>> callable) {
        this(callable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(Throwable th) {
        ArrayList<LottieListener> arrayList = new ArrayList(this.b);
        if (arrayList.isEmpty()) {
            kb1.d("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        for (LottieListener lottieListener : arrayList) {
            lottieListener.onResult(th);
        }
    }

    private void h() {
        this.c.post(new Runnable() { // from class: com.airbnb.lottie.LottieTask.1
            @Override // java.lang.Runnable
            public void run() {
                if (LottieTask.this.d == null) {
                    return;
                }
                kc1 kc1Var = LottieTask.this.d;
                if (kc1Var.b() != null) {
                    LottieTask.this.i(kc1Var.b());
                } else {
                    LottieTask.this.g(kc1Var.a());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i(T t) {
        for (LottieListener lottieListener : new ArrayList(this.a)) {
            lottieListener.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(@Nullable kc1<T> kc1Var) {
        if (this.d == null) {
            this.d = kc1Var;
            h();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized LottieTask<T> e(LottieListener<Throwable> lottieListener) {
        if (this.d != null && this.d.a() != null) {
            lottieListener.onResult(this.d.a());
        }
        this.b.add(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> f(LottieListener<T> lottieListener) {
        if (this.d != null && this.d.b() != null) {
            lottieListener.onResult(this.d.b());
        }
        this.a.add(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> j(LottieListener<Throwable> lottieListener) {
        this.b.remove(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> k(LottieListener<T> lottieListener) {
        this.a.remove(lottieListener);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieTask(Callable<kc1<T>> callable, boolean z) {
        this.a = new LinkedHashSet(1);
        this.b = new LinkedHashSet(1);
        this.c = new Handler(Looper.getMainLooper());
        this.d = null;
        if (z) {
            try {
                l(callable.call());
                return;
            } catch (Throwable th) {
                l(new kc1<>(th));
                return;
            }
        }
        e.execute(new LottieFutureTask(callable));
    }
}
