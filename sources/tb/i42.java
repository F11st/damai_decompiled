package tb;

import io.reactivex.AbstractC8146a;
import io.reactivex.AbstractC8147b;
import io.reactivex.AbstractC8148c;
import io.reactivex.AbstractC8149d;
import io.reactivex.AbstractC8152e;
import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.Beta;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.parallel.AbstractC8161a;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class i42 {
    @Nullable
    static volatile Consumer<? super Throwable> a;
    @Nullable
    static volatile Function<? super Runnable, ? extends Runnable> b;
    @Nullable
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> c;
    @Nullable
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> d;
    @Nullable
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> e;
    @Nullable
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f;
    @Nullable
    static volatile Function<? super Scheduler, ? extends Scheduler> g;
    @Nullable
    static volatile Function<? super Scheduler, ? extends Scheduler> h;
    @Nullable
    static volatile Function<? super AbstractC8147b, ? extends AbstractC8147b> i;
    @Nullable
    static volatile Function<? super an, ? extends an> j;
    @Nullable
    static volatile Function<? super AbstractC8149d, ? extends AbstractC8149d> k;
    @Nullable
    static volatile Function<? super bn, ? extends bn> l;
    @Nullable
    static volatile Function<? super AbstractC8148c, ? extends AbstractC8148c> m;
    @Nullable
    static volatile Function<? super AbstractC8152e, ? extends AbstractC8152e> n;
    @Nullable
    static volatile Function<? super AbstractC8146a, ? extends AbstractC8146a> o;
    @Nullable
    static volatile Function<? super AbstractC8161a, ? extends AbstractC8161a> p;
    @Nullable
    static volatile BiFunction<? super AbstractC8147b, ? super Subscriber, ? extends Subscriber> q;
    @Nullable
    static volatile BiFunction<? super AbstractC8148c, ? super MaybeObserver, ? extends MaybeObserver> r;
    @Nullable
    static volatile BiFunction<? super AbstractC8149d, ? super Observer, ? extends Observer> s;
    @Nullable
    static volatile BiFunction<? super AbstractC8152e, ? super SingleObserver, ? extends SingleObserver> t;
    @Nullable
    static volatile BiFunction<? super AbstractC8146a, ? super CompletableObserver, ? extends CompletableObserver> u;
    @Nullable
    static volatile BooleanSupplier v;
    static volatile boolean w;

    @NonNull
    public static <T> SingleObserver<? super T> A(@NonNull AbstractC8152e<T> abstractC8152e, @NonNull SingleObserver<? super T> singleObserver) {
        BiFunction<? super AbstractC8152e, ? super SingleObserver, ? extends SingleObserver> biFunction = t;
        return biFunction != null ? (SingleObserver) a(biFunction, abstractC8152e, singleObserver) : singleObserver;
    }

    @NonNull
    public static <T> Subscriber<? super T> B(@NonNull AbstractC8147b<T> abstractC8147b, @NonNull Subscriber<? super T> subscriber) {
        BiFunction<? super AbstractC8147b, ? super Subscriber, ? extends Subscriber> biFunction = q;
        return biFunction != null ? (Subscriber) a(biFunction, abstractC8147b, subscriber) : subscriber;
    }

    static void C(@NonNull Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    @NonNull
    static <T, U, R> R a(@NonNull BiFunction<T, U, R> biFunction, @NonNull T t2, @NonNull U u2) {
        try {
            return biFunction.apply(t2, u2);
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @NonNull
    static <T, R> R b(@NonNull Function<T, R> function, @NonNull T t2) {
        try {
            return function.apply(t2);
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @NonNull
    static Scheduler c(@NonNull Function<? super Callable<Scheduler>, ? extends Scheduler> function, Callable<Scheduler> callable) {
        return (Scheduler) ObjectHelper.requireNonNull(b(function, callable), "Scheduler Callable result can't be null");
    }

    @NonNull
    static Scheduler d(@NonNull Callable<Scheduler> callable) {
        try {
            return (Scheduler) ObjectHelper.requireNonNull(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @NonNull
    public static Scheduler e(@NonNull Callable<Scheduler> callable) {
        ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = c;
        if (function == null) {
            return d(callable);
        }
        return c(function, callable);
    }

    @NonNull
    public static Scheduler f(@NonNull Callable<Scheduler> callable) {
        ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = e;
        if (function == null) {
            return d(callable);
        }
        return c(function, callable);
    }

    @NonNull
    public static Scheduler g(@NonNull Callable<Scheduler> callable) {
        ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = f;
        if (function == null) {
            return d(callable);
        }
        return c(function, callable);
    }

    @NonNull
    public static Scheduler h(@NonNull Callable<Scheduler> callable) {
        ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = d;
        if (function == null) {
            return d(callable);
        }
        return c(function, callable);
    }

    static boolean i(Throwable th) {
        return (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException);
    }

    public static boolean j() {
        return w;
    }

    @NonNull
    public static AbstractC8146a k(@NonNull AbstractC8146a abstractC8146a) {
        Function<? super AbstractC8146a, ? extends AbstractC8146a> function = o;
        return function != null ? (AbstractC8146a) b(function, abstractC8146a) : abstractC8146a;
    }

    @NonNull
    public static <T> AbstractC8147b<T> l(@NonNull AbstractC8147b<T> abstractC8147b) {
        Function<? super AbstractC8147b, ? extends AbstractC8147b> function = i;
        return function != null ? (AbstractC8147b) b(function, abstractC8147b) : abstractC8147b;
    }

    @NonNull
    public static <T> AbstractC8148c<T> m(@NonNull AbstractC8148c<T> abstractC8148c) {
        Function<? super AbstractC8148c, ? extends AbstractC8148c> function = m;
        return function != null ? (AbstractC8148c) b(function, abstractC8148c) : abstractC8148c;
    }

    @NonNull
    public static <T> AbstractC8149d<T> n(@NonNull AbstractC8149d<T> abstractC8149d) {
        Function<? super AbstractC8149d, ? extends AbstractC8149d> function = k;
        return function != null ? (AbstractC8149d) b(function, abstractC8149d) : abstractC8149d;
    }

    @NonNull
    public static <T> AbstractC8152e<T> o(@NonNull AbstractC8152e<T> abstractC8152e) {
        Function<? super AbstractC8152e, ? extends AbstractC8152e> function = n;
        return function != null ? (AbstractC8152e) b(function, abstractC8152e) : abstractC8152e;
    }

    @Beta
    @NonNull
    public static <T> AbstractC8161a<T> p(@NonNull AbstractC8161a<T> abstractC8161a) {
        Function<? super AbstractC8161a, ? extends AbstractC8161a> function = p;
        return function != null ? (AbstractC8161a) b(function, abstractC8161a) : abstractC8161a;
    }

    @NonNull
    public static <T> an<T> q(@NonNull an<T> anVar) {
        Function<? super an, ? extends an> function = j;
        return function != null ? (an) b(function, anVar) : anVar;
    }

    @NonNull
    public static <T> bn<T> r(@NonNull bn<T> bnVar) {
        Function<? super bn, ? extends bn> function = l;
        return function != null ? (bn) b(function, bnVar) : bnVar;
    }

    public static boolean s() {
        BooleanSupplier booleanSupplier = v;
        if (booleanSupplier != null) {
            try {
                return booleanSupplier.getAsBoolean();
            } catch (Throwable th) {
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
        return false;
    }

    @NonNull
    public static Scheduler t(@NonNull Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = g;
        return function == null ? scheduler : (Scheduler) b(function, scheduler);
    }

    public static void u(@NonNull Throwable th) {
        Consumer<? super Throwable> consumer = a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!i(th)) {
            th = new UndeliverableException(th);
        }
        if (consumer != null) {
            try {
                consumer.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                C(th2);
            }
        }
        th.printStackTrace();
        C(th);
    }

    @NonNull
    public static Runnable v(@NonNull Runnable runnable) {
        ObjectHelper.requireNonNull(runnable, "run is null");
        Function<? super Runnable, ? extends Runnable> function = b;
        return function == null ? runnable : (Runnable) b(function, runnable);
    }

    @NonNull
    public static Scheduler w(@NonNull Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = h;
        return function == null ? scheduler : (Scheduler) b(function, scheduler);
    }

    @NonNull
    public static CompletableObserver x(@NonNull AbstractC8146a abstractC8146a, @NonNull CompletableObserver completableObserver) {
        BiFunction<? super AbstractC8146a, ? super CompletableObserver, ? extends CompletableObserver> biFunction = u;
        return biFunction != null ? (CompletableObserver) a(biFunction, abstractC8146a, completableObserver) : completableObserver;
    }

    @NonNull
    public static <T> MaybeObserver<? super T> y(@NonNull AbstractC8148c<T> abstractC8148c, @NonNull MaybeObserver<? super T> maybeObserver) {
        BiFunction<? super AbstractC8148c, ? super MaybeObserver, ? extends MaybeObserver> biFunction = r;
        return biFunction != null ? (MaybeObserver) a(biFunction, abstractC8148c, maybeObserver) : maybeObserver;
    }

    @NonNull
    public static <T> Observer<? super T> z(@NonNull AbstractC8149d<T> abstractC8149d, @NonNull Observer<? super T> observer) {
        BiFunction<? super AbstractC8149d, ? super Observer, ? extends Observer> biFunction = s;
        return biFunction != null ? (Observer) a(biFunction, abstractC8149d, observer) : observer;
    }
}
