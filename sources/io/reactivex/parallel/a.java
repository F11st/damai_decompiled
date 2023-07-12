package io.reactivex.parallel;

import io.reactivex.Scheduler;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.Beta;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.b;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.parallel.ParallelCollect;
import io.reactivex.internal.operators.parallel.ParallelConcatMap;
import io.reactivex.internal.operators.parallel.ParallelDoOnNextTry;
import io.reactivex.internal.operators.parallel.ParallelFilter;
import io.reactivex.internal.operators.parallel.ParallelFilterTry;
import io.reactivex.internal.operators.parallel.ParallelFlatMap;
import io.reactivex.internal.operators.parallel.ParallelFromArray;
import io.reactivex.internal.operators.parallel.ParallelFromPublisher;
import io.reactivex.internal.operators.parallel.ParallelJoin;
import io.reactivex.internal.operators.parallel.ParallelMap;
import io.reactivex.internal.operators.parallel.ParallelMapTry;
import io.reactivex.internal.operators.parallel.ParallelPeek;
import io.reactivex.internal.operators.parallel.ParallelReduce;
import io.reactivex.internal.operators.parallel.ParallelReduceFull;
import io.reactivex.internal.operators.parallel.ParallelRunOn;
import io.reactivex.internal.operators.parallel.ParallelSortedJoin;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.ListAddBiConsumer;
import io.reactivex.internal.util.MergerBiFunction;
import io.reactivex.internal.util.SorterFunction;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.dg0;
import tb.i42;

/* compiled from: Taobao */
@Beta
/* loaded from: classes3.dex */
public abstract class a<T> {
    @CheckReturnValue
    public static <T> a<T> from(@NonNull Publisher<? extends T> publisher) {
        return from(publisher, Runtime.getRuntime().availableProcessors(), b.bufferSize());
    }

    @CheckReturnValue
    @NonNull
    public static <T> a<T> fromArray(@NonNull Publisher<T>... publisherArr) {
        if (publisherArr.length != 0) {
            return i42.p(new ParallelFromArray(publisherArr));
        }
        throw new IllegalArgumentException("Zero publishers not supported");
    }

    @CheckReturnValue
    @Experimental
    @NonNull
    public final <R> R as(@NonNull ParallelFlowableConverter<T, R> parallelFlowableConverter) {
        return (R) ((ParallelFlowableConverter) ObjectHelper.requireNonNull(parallelFlowableConverter, "converter is null")).apply(this);
    }

    @CheckReturnValue
    @NonNull
    public final <C> a<C> collect(@NonNull Callable<? extends C> callable, @NonNull BiConsumer<? super C, ? super T> biConsumer) {
        ObjectHelper.requireNonNull(callable, "collectionSupplier is null");
        ObjectHelper.requireNonNull(biConsumer, "collector is null");
        return i42.p(new ParallelCollect(this, callable, biConsumer));
    }

    @CheckReturnValue
    @NonNull
    public final <U> a<U> compose(@NonNull ParallelTransformer<T, U> parallelTransformer) {
        return i42.p(((ParallelTransformer) ObjectHelper.requireNonNull(parallelTransformer, "composer is null")).apply(this));
    }

    @CheckReturnValue
    @NonNull
    public final <R> a<R> concatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function) {
        return concatMap(function, 2);
    }

    @CheckReturnValue
    @NonNull
    public final <R> a<R> concatMapDelayError(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z) {
        return concatMapDelayError(function, 2, z);
    }

    @CheckReturnValue
    @NonNull
    public final a<T> doAfterNext(@NonNull Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, "onAfterNext is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return i42.p(new ParallelPeek(this, emptyConsumer, consumer, emptyConsumer2, action, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    @CheckReturnValue
    @NonNull
    public final a<T> doAfterTerminated(@NonNull Action action) {
        ObjectHelper.requireNonNull(action, "onAfterTerminate is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return i42.p(new ParallelPeek(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action2, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action2));
    }

    @CheckReturnValue
    @NonNull
    public final a<T> doOnCancel(@NonNull Action action) {
        ObjectHelper.requireNonNull(action, "onCancel is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return i42.p(new ParallelPeek(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action2, action2, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    @CheckReturnValue
    @NonNull
    public final a<T> doOnComplete(@NonNull Action action) {
        ObjectHelper.requireNonNull(action, "onComplete is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return i42.p(new ParallelPeek(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action, action2, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action2));
    }

    @CheckReturnValue
    @NonNull
    public final a<T> doOnError(@NonNull Consumer<Throwable> consumer) {
        ObjectHelper.requireNonNull(consumer, "onError is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return i42.p(new ParallelPeek(this, emptyConsumer, emptyConsumer2, consumer, action, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    @CheckReturnValue
    @NonNull
    public final a<T> doOnNext(@NonNull Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return i42.p(new ParallelPeek(this, consumer, emptyConsumer, emptyConsumer2, action, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    @CheckReturnValue
    @NonNull
    public final a<T> doOnRequest(@NonNull LongConsumer longConsumer) {
        ObjectHelper.requireNonNull(longConsumer, "onRequest is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return i42.p(new ParallelPeek(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action, action, Functions.emptyConsumer(), longConsumer, action));
    }

    @CheckReturnValue
    @NonNull
    public final a<T> doOnSubscribe(@NonNull Consumer<? super Subscription> consumer) {
        ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return i42.p(new ParallelPeek(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action, action, consumer, Functions.EMPTY_LONG_CONSUMER, action));
    }

    @CheckReturnValue
    public final a<T> filter(@NonNull Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate");
        return i42.p(new ParallelFilter(this, predicate));
    }

    @CheckReturnValue
    @NonNull
    public final <R> a<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function) {
        return flatMap(function, false, Integer.MAX_VALUE, b.bufferSize());
    }

    @CheckReturnValue
    @NonNull
    public final <R> a<R> map(@NonNull Function<? super T, ? extends R> function) {
        ObjectHelper.requireNonNull(function, "mapper");
        return i42.p(new ParallelMap(this, function));
    }

    public abstract int parallelism();

    @CheckReturnValue
    @NonNull
    public final b<T> reduce(@NonNull BiFunction<T, T, T> biFunction) {
        ObjectHelper.requireNonNull(biFunction, "reducer");
        return i42.l(new ParallelReduceFull(this, biFunction));
    }

    @CheckReturnValue
    @NonNull
    public final a<T> runOn(@NonNull Scheduler scheduler) {
        return runOn(scheduler, b.bufferSize());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final b<T> sequential() {
        return sequential(b.bufferSize());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    @NonNull
    public final b<T> sequentialDelayError() {
        return sequentialDelayError(b.bufferSize());
    }

    @CheckReturnValue
    @NonNull
    public final b<T> sorted(@NonNull Comparator<? super T> comparator) {
        return sorted(comparator, 16);
    }

    public abstract void subscribe(@NonNull Subscriber<? super T>[] subscriberArr);

    @CheckReturnValue
    @NonNull
    public final <U> U to(@NonNull Function<? super a<T>, U> function) {
        try {
            return (U) ((Function) ObjectHelper.requireNonNull(function, "converter is null")).apply(this);
        } catch (Throwable th) {
            dg0.b(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @CheckReturnValue
    @NonNull
    public final b<List<T>> toSortedList(@NonNull Comparator<? super T> comparator) {
        return toSortedList(comparator, 16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean validate(@NonNull Subscriber<?>[] subscriberArr) {
        int parallelism = parallelism();
        if (subscriberArr.length != parallelism) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("parallelism = " + parallelism + ", subscribers = " + subscriberArr.length);
            for (Subscriber<?> subscriber : subscriberArr) {
                EmptySubscription.error(illegalArgumentException, subscriber);
            }
            return false;
        }
        return true;
    }

    @CheckReturnValue
    public static <T> a<T> from(@NonNull Publisher<? extends T> publisher, int i) {
        return from(publisher, i, b.bufferSize());
    }

    @CheckReturnValue
    @NonNull
    public final <R> a<R> concatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, int i) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        return i42.p(new ParallelConcatMap(this, function, i, ErrorMode.IMMEDIATE));
    }

    @CheckReturnValue
    @NonNull
    public final <R> a<R> concatMapDelayError(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, int i, boolean z) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        return i42.p(new ParallelConcatMap(this, function, i, z ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    @CheckReturnValue
    @NonNull
    public final <R> a<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z) {
        return flatMap(function, z, Integer.MAX_VALUE, b.bufferSize());
    }

    @CheckReturnValue
    @NonNull
    public final a<T> runOn(@NonNull Scheduler scheduler, int i) {
        ObjectHelper.requireNonNull(scheduler, "scheduler");
        ObjectHelper.verifyPositive(i, "prefetch");
        return i42.p(new ParallelRunOn(this, scheduler, i));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final b<T> sequential(int i) {
        ObjectHelper.verifyPositive(i, "prefetch");
        return i42.l(new ParallelJoin(this, i, false));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final b<T> sequentialDelayError(int i) {
        ObjectHelper.verifyPositive(i, "prefetch");
        return i42.l(new ParallelJoin(this, i, true));
    }

    @CheckReturnValue
    @NonNull
    public final b<T> sorted(@NonNull Comparator<? super T> comparator, int i) {
        ObjectHelper.requireNonNull(comparator, "comparator is null");
        ObjectHelper.verifyPositive(i, "capacityHint");
        return i42.l(new ParallelSortedJoin(reduce(Functions.createArrayList((i / parallelism()) + 1), ListAddBiConsumer.instance()).map(new SorterFunction(comparator)), comparator));
    }

    @CheckReturnValue
    @NonNull
    public final b<List<T>> toSortedList(@NonNull Comparator<? super T> comparator, int i) {
        ObjectHelper.requireNonNull(comparator, "comparator is null");
        ObjectHelper.verifyPositive(i, "capacityHint");
        return i42.l(reduce(Functions.createArrayList((i / parallelism()) + 1), ListAddBiConsumer.instance()).map(new SorterFunction(comparator)).reduce(new MergerBiFunction(comparator)));
    }

    @CheckReturnValue
    @NonNull
    public static <T> a<T> from(@NonNull Publisher<? extends T> publisher, int i, int i2) {
        ObjectHelper.requireNonNull(publisher, "source");
        ObjectHelper.verifyPositive(i, "parallelism");
        ObjectHelper.verifyPositive(i2, "prefetch");
        return i42.p(new ParallelFromPublisher(publisher, i, i2));
    }

    @CheckReturnValue
    @Experimental
    public final a<T> filter(@NonNull Predicate<? super T> predicate, @NonNull ParallelFailureHandling parallelFailureHandling) {
        ObjectHelper.requireNonNull(predicate, "predicate");
        ObjectHelper.requireNonNull(parallelFailureHandling, "errorHandler is null");
        return i42.p(new ParallelFilterTry(this, predicate, parallelFailureHandling));
    }

    @CheckReturnValue
    @NonNull
    public final <R> a<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z, int i) {
        return flatMap(function, z, i, b.bufferSize());
    }

    @CheckReturnValue
    @Experimental
    @NonNull
    public final <R> a<R> map(@NonNull Function<? super T, ? extends R> function, @NonNull ParallelFailureHandling parallelFailureHandling) {
        ObjectHelper.requireNonNull(function, "mapper");
        ObjectHelper.requireNonNull(parallelFailureHandling, "errorHandler is null");
        return i42.p(new ParallelMapTry(this, function, parallelFailureHandling));
    }

    @CheckReturnValue
    @NonNull
    public final <R> a<R> reduce(@NonNull Callable<R> callable, @NonNull BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(callable, "initialSupplier");
        ObjectHelper.requireNonNull(biFunction, "reducer");
        return i42.p(new ParallelReduce(this, callable, biFunction));
    }

    @CheckReturnValue
    @NonNull
    public final <R> a<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z, int i, int i2) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i, "maxConcurrency");
        ObjectHelper.verifyPositive(i2, "prefetch");
        return i42.p(new ParallelFlatMap(this, function, z, i, i2));
    }

    @CheckReturnValue
    @Experimental
    public final a<T> filter(@NonNull Predicate<? super T> predicate, @NonNull BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        ObjectHelper.requireNonNull(predicate, "predicate");
        ObjectHelper.requireNonNull(biFunction, "errorHandler is null");
        return i42.p(new ParallelFilterTry(this, predicate, biFunction));
    }

    @CheckReturnValue
    @Experimental
    @NonNull
    public final <R> a<R> map(@NonNull Function<? super T, ? extends R> function, @NonNull BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        ObjectHelper.requireNonNull(function, "mapper");
        ObjectHelper.requireNonNull(biFunction, "errorHandler is null");
        return i42.p(new ParallelMapTry(this, function, biFunction));
    }

    @CheckReturnValue
    @Experimental
    @NonNull
    public final a<T> doOnNext(@NonNull Consumer<? super T> consumer, @NonNull ParallelFailureHandling parallelFailureHandling) {
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        ObjectHelper.requireNonNull(parallelFailureHandling, "errorHandler is null");
        return i42.p(new ParallelDoOnNextTry(this, consumer, parallelFailureHandling));
    }

    @CheckReturnValue
    @Experimental
    @NonNull
    public final a<T> doOnNext(@NonNull Consumer<? super T> consumer, @NonNull BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        ObjectHelper.requireNonNull(biFunction, "errorHandler is null");
        return i42.p(new ParallelDoOnNextTry(this, consumer, biFunction));
    }
}
