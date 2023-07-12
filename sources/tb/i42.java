package tb;

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
    static volatile Function<? super io.reactivex.b, ? extends io.reactivex.b> i;
    @Nullable
    static volatile Function<? super an, ? extends an> j;
    @Nullable
    static volatile Function<? super io.reactivex.d, ? extends io.reactivex.d> k;
    @Nullable
    static volatile Function<? super bn, ? extends bn> l;
    @Nullable
    static volatile Function<? super io.reactivex.c, ? extends io.reactivex.c> m;
    @Nullable
    static volatile Function<? super io.reactivex.e, ? extends io.reactivex.e> n;
    @Nullable
    static volatile Function<? super io.reactivex.a, ? extends io.reactivex.a> o;
    @Nullable
    static volatile Function<? super io.reactivex.parallel.a, ? extends io.reactivex.parallel.a> p;
    @Nullable
    static volatile BiFunction<? super io.reactivex.b, ? super Subscriber, ? extends Subscriber> q;
    @Nullable
    static volatile BiFunction<? super io.reactivex.c, ? super MaybeObserver, ? extends MaybeObserver> r;
    @Nullable
    static volatile BiFunction<? super io.reactivex.d, ? super Observer, ? extends Observer> s;
    @Nullable
    static volatile BiFunction<? super io.reactivex.e, ? super SingleObserver, ? extends SingleObserver> t;
    @Nullable
    static volatile BiFunction<? super io.reactivex.a, ? super CompletableObserver, ? extends CompletableObserver> u;
    @Nullable
    static volatile BooleanSupplier v;
    static volatile boolean w;

    @NonNull
    public static <T> SingleObserver<? super T> A(@NonNull io.reactivex.e<T> eVar, @NonNull SingleObserver<? super T> singleObserver) {
        BiFunction<? super io.reactivex.e, ? super SingleObserver, ? extends SingleObserver> biFunction = t;
        return biFunction != null ? (SingleObserver) a(biFunction, eVar, singleObserver) : singleObserver;
    }

    @NonNull
    public static <T> Subscriber<? super T> B(@NonNull io.reactivex.b<T> bVar, @NonNull Subscriber<? super T> subscriber) {
        BiFunction<? super io.reactivex.b, ? super Subscriber, ? extends Subscriber> biFunction = q;
        return biFunction != null ? (Subscriber) a(biFunction, bVar, subscriber) : subscriber;
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
    public static io.reactivex.a k(@NonNull io.reactivex.a aVar) {
        Function<? super io.reactivex.a, ? extends io.reactivex.a> function = o;
        return function != null ? (io.reactivex.a) b(function, aVar) : aVar;
    }

    @NonNull
    public static <T> io.reactivex.b<T> l(@NonNull io.reactivex.b<T> bVar) {
        Function<? super io.reactivex.b, ? extends io.reactivex.b> function = i;
        return function != null ? (io.reactivex.b) b(function, bVar) : bVar;
    }

    @NonNull
    public static <T> io.reactivex.c<T> m(@NonNull io.reactivex.c<T> cVar) {
        Function<? super io.reactivex.c, ? extends io.reactivex.c> function = m;
        return function != null ? (io.reactivex.c) b(function, cVar) : cVar;
    }

    @NonNull
    public static <T> io.reactivex.d<T> n(@NonNull io.reactivex.d<T> dVar) {
        Function<? super io.reactivex.d, ? extends io.reactivex.d> function = k;
        return function != null ? (io.reactivex.d) b(function, dVar) : dVar;
    }

    @NonNull
    public static <T> io.reactivex.e<T> o(@NonNull io.reactivex.e<T> eVar) {
        Function<? super io.reactivex.e, ? extends io.reactivex.e> function = n;
        return function != null ? (io.reactivex.e) b(function, eVar) : eVar;
    }

    @Beta
    @NonNull
    public static <T> io.reactivex.parallel.a<T> p(@NonNull io.reactivex.parallel.a<T> aVar) {
        Function<? super io.reactivex.parallel.a, ? extends io.reactivex.parallel.a> function = p;
        return function != null ? (io.reactivex.parallel.a) b(function, aVar) : aVar;
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
    public static CompletableObserver x(@NonNull io.reactivex.a aVar, @NonNull CompletableObserver completableObserver) {
        BiFunction<? super io.reactivex.a, ? super CompletableObserver, ? extends CompletableObserver> biFunction = u;
        return biFunction != null ? (CompletableObserver) a(biFunction, aVar, completableObserver) : completableObserver;
    }

    @NonNull
    public static <T> MaybeObserver<? super T> y(@NonNull io.reactivex.c<T> cVar, @NonNull MaybeObserver<? super T> maybeObserver) {
        BiFunction<? super io.reactivex.c, ? super MaybeObserver, ? extends MaybeObserver> biFunction = r;
        return biFunction != null ? (MaybeObserver) a(biFunction, cVar, maybeObserver) : maybeObserver;
    }

    @NonNull
    public static <T> Observer<? super T> z(@NonNull io.reactivex.d<T> dVar, @NonNull Observer<? super T> observer) {
        BiFunction<? super io.reactivex.d, ? super Observer, ? extends Observer> biFunction = s;
        return biFunction != null ? (Observer) a(biFunction, dVar, observer) : observer;
    }
}
