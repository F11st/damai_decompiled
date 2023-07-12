package io.reactivex;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.operators.flowable.FlowableConcatMapPublisher;
import io.reactivex.internal.operators.flowable.FlowableFlatMapPublisher;
import io.reactivex.internal.operators.maybe.MaybeAmb;
import io.reactivex.internal.operators.maybe.MaybeCache;
import io.reactivex.internal.operators.maybe.MaybeCallbackObserver;
import io.reactivex.internal.operators.maybe.MaybeConcatArray;
import io.reactivex.internal.operators.maybe.MaybeConcatArrayDelayError;
import io.reactivex.internal.operators.maybe.MaybeConcatIterable;
import io.reactivex.internal.operators.maybe.MaybeContains;
import io.reactivex.internal.operators.maybe.MaybeCount;
import io.reactivex.internal.operators.maybe.MaybeCreate;
import io.reactivex.internal.operators.maybe.MaybeDefer;
import io.reactivex.internal.operators.maybe.MaybeDelay;
import io.reactivex.internal.operators.maybe.MaybeDelayOtherPublisher;
import io.reactivex.internal.operators.maybe.MaybeDelaySubscriptionOtherPublisher;
import io.reactivex.internal.operators.maybe.MaybeDetach;
import io.reactivex.internal.operators.maybe.MaybeDoAfterSuccess;
import io.reactivex.internal.operators.maybe.MaybeDoFinally;
import io.reactivex.internal.operators.maybe.MaybeDoOnEvent;
import io.reactivex.internal.operators.maybe.MaybeEmpty;
import io.reactivex.internal.operators.maybe.MaybeEqualSingle;
import io.reactivex.internal.operators.maybe.MaybeError;
import io.reactivex.internal.operators.maybe.MaybeErrorCallable;
import io.reactivex.internal.operators.maybe.MaybeFilter;
import io.reactivex.internal.operators.maybe.MaybeFlatMapBiSelector;
import io.reactivex.internal.operators.maybe.MaybeFlatMapCompletable;
import io.reactivex.internal.operators.maybe.MaybeFlatMapIterableFlowable;
import io.reactivex.internal.operators.maybe.MaybeFlatMapIterableObservable;
import io.reactivex.internal.operators.maybe.MaybeFlatMapNotification;
import io.reactivex.internal.operators.maybe.MaybeFlatMapSingle;
import io.reactivex.internal.operators.maybe.MaybeFlatMapSingleElement;
import io.reactivex.internal.operators.maybe.MaybeFlatten;
import io.reactivex.internal.operators.maybe.MaybeFromAction;
import io.reactivex.internal.operators.maybe.MaybeFromCallable;
import io.reactivex.internal.operators.maybe.MaybeFromCompletable;
import io.reactivex.internal.operators.maybe.MaybeFromFuture;
import io.reactivex.internal.operators.maybe.MaybeFromRunnable;
import io.reactivex.internal.operators.maybe.MaybeFromSingle;
import io.reactivex.internal.operators.maybe.MaybeHide;
import io.reactivex.internal.operators.maybe.MaybeIgnoreElementCompletable;
import io.reactivex.internal.operators.maybe.MaybeIsEmptySingle;
import io.reactivex.internal.operators.maybe.MaybeJust;
import io.reactivex.internal.operators.maybe.MaybeLift;
import io.reactivex.internal.operators.maybe.MaybeMap;
import io.reactivex.internal.operators.maybe.MaybeMergeArray;
import io.reactivex.internal.operators.maybe.MaybeNever;
import io.reactivex.internal.operators.maybe.MaybeObserveOn;
import io.reactivex.internal.operators.maybe.MaybeOnErrorComplete;
import io.reactivex.internal.operators.maybe.MaybeOnErrorNext;
import io.reactivex.internal.operators.maybe.MaybeOnErrorReturn;
import io.reactivex.internal.operators.maybe.MaybePeek;
import io.reactivex.internal.operators.maybe.MaybeSubscribeOn;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmpty;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmptySingle;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilMaybe;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilPublisher;
import io.reactivex.internal.operators.maybe.MaybeTimeoutMaybe;
import io.reactivex.internal.operators.maybe.MaybeTimeoutPublisher;
import io.reactivex.internal.operators.maybe.MaybeTimer;
import io.reactivex.internal.operators.maybe.MaybeToFlowable;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.maybe.MaybeToPublisher;
import io.reactivex.internal.operators.maybe.MaybeToSingle;
import io.reactivex.internal.operators.maybe.MaybeUnsafeCreate;
import io.reactivex.internal.operators.maybe.MaybeUnsubscribeOn;
import io.reactivex.internal.operators.maybe.MaybeUsing;
import io.reactivex.internal.operators.maybe.MaybeZipArray;
import io.reactivex.internal.operators.maybe.MaybeZipIterable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.C8162a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import tb.dg0;
import tb.i42;

/* compiled from: Taobao */
/* renamed from: io.reactivex.c */
/* loaded from: classes3.dex */
public abstract class AbstractC8148c<T> implements MaybeSource<T> {
    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> AbstractC8148c<T> amb(Iterable<? extends MaybeSource<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return i42.m(new MaybeAmb(null, iterable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> AbstractC8148c<T> ambArray(MaybeSource<? extends T>... maybeSourceArr) {
        if (maybeSourceArr.length == 0) {
            return empty();
        }
        if (maybeSourceArr.length == 1) {
            return wrap(maybeSourceArr[0]);
        }
        return i42.m(new MaybeAmb(maybeSourceArr, null));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> concat(Iterable<? extends MaybeSource<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return i42.l(new MaybeConcatIterable(iterable));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> concatArray(MaybeSource<? extends T>... maybeSourceArr) {
        ObjectHelper.requireNonNull(maybeSourceArr, "sources is null");
        if (maybeSourceArr.length == 0) {
            return AbstractC8147b.empty();
        }
        if (maybeSourceArr.length == 1) {
            return i42.l(new MaybeToFlowable(maybeSourceArr[0]));
        }
        return i42.l(new MaybeConcatArray(maybeSourceArr));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> concatArrayDelayError(MaybeSource<? extends T>... maybeSourceArr) {
        if (maybeSourceArr.length == 0) {
            return AbstractC8147b.empty();
        }
        if (maybeSourceArr.length == 1) {
            return i42.l(new MaybeToFlowable(maybeSourceArr[0]));
        }
        return i42.l(new MaybeConcatArrayDelayError(maybeSourceArr));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> concatArrayEager(MaybeSource<? extends T>... maybeSourceArr) {
        return AbstractC8147b.fromArray(maybeSourceArr).concatMapEager(MaybeToPublisher.instance());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> concatDelayError(Iterable<? extends MaybeSource<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return AbstractC8147b.fromIterable(iterable).concatMapDelayError(MaybeToPublisher.instance());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> concatEager(Iterable<? extends MaybeSource<? extends T>> iterable) {
        return AbstractC8147b.fromIterable(iterable).concatMapEager(MaybeToPublisher.instance());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> AbstractC8148c<T> create(MaybeOnSubscribe<T> maybeOnSubscribe) {
        ObjectHelper.requireNonNull(maybeOnSubscribe, "onSubscribe is null");
        return i42.m(new MaybeCreate(maybeOnSubscribe));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> AbstractC8148c<T> defer(Callable<? extends MaybeSource<? extends T>> callable) {
        ObjectHelper.requireNonNull(callable, "maybeSupplier is null");
        return i42.m(new MaybeDefer(callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> AbstractC8148c<T> empty() {
        return i42.m(MaybeEmpty.INSTANCE);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> AbstractC8148c<T> error(Throwable th) {
        ObjectHelper.requireNonNull(th, "exception is null");
        return i42.m(new MaybeError(th));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> AbstractC8148c<T> fromAction(Action action) {
        ObjectHelper.requireNonNull(action, "run is null");
        return i42.m(new MaybeFromAction(action));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> AbstractC8148c<T> fromCallable(@NonNull Callable<? extends T> callable) {
        ObjectHelper.requireNonNull(callable, "callable is null");
        return i42.m(new MaybeFromCallable(callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> AbstractC8148c<T> fromCompletable(CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "completableSource is null");
        return i42.m(new MaybeFromCompletable(completableSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> AbstractC8148c<T> fromFuture(Future<? extends T> future) {
        ObjectHelper.requireNonNull(future, "future is null");
        return i42.m(new MaybeFromFuture(future, 0L, null));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> AbstractC8148c<T> fromRunnable(Runnable runnable) {
        ObjectHelper.requireNonNull(runnable, "run is null");
        return i42.m(new MaybeFromRunnable(runnable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> AbstractC8148c<T> fromSingle(SingleSource<T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "singleSource is null");
        return i42.m(new MaybeFromSingle(singleSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> AbstractC8148c<T> just(T t) {
        ObjectHelper.requireNonNull(t, "item is null");
        return i42.m(new MaybeJust(t));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> merge(Iterable<? extends MaybeSource<? extends T>> iterable) {
        return merge(AbstractC8147b.fromIterable(iterable));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> mergeArray(MaybeSource<? extends T>... maybeSourceArr) {
        ObjectHelper.requireNonNull(maybeSourceArr, "sources is null");
        if (maybeSourceArr.length == 0) {
            return AbstractC8147b.empty();
        }
        if (maybeSourceArr.length == 1) {
            return i42.l(new MaybeToFlowable(maybeSourceArr[0]));
        }
        return i42.l(new MaybeMergeArray(maybeSourceArr));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> mergeArrayDelayError(MaybeSource<? extends T>... maybeSourceArr) {
        if (maybeSourceArr.length == 0) {
            return AbstractC8147b.empty();
        }
        return AbstractC8147b.fromArray(maybeSourceArr).flatMap(MaybeToPublisher.instance(), true, maybeSourceArr.length);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> mergeDelayError(Iterable<? extends MaybeSource<? extends T>> iterable) {
        return AbstractC8147b.fromIterable(iterable).flatMap(MaybeToPublisher.instance(), true);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> AbstractC8148c<T> never() {
        return i42.m(MaybeNever.INSTANCE);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> AbstractC8152e<Boolean> sequenceEqual(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2) {
        return sequenceEqual(maybeSource, maybeSource2, ObjectHelper.equalsPredicate());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static AbstractC8148c<Long> timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, C8162a.a());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> AbstractC8148c<T> unsafeCreate(MaybeSource<T> maybeSource) {
        if (!(maybeSource instanceof AbstractC8148c)) {
            ObjectHelper.requireNonNull(maybeSource, "onSubscribe is null");
            return i42.m(new MaybeUnsafeCreate(maybeSource));
        }
        throw new IllegalArgumentException("unsafeCreate(Maybe) should be upgraded");
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, D> AbstractC8148c<T> using(Callable<? extends D> callable, Function<? super D, ? extends MaybeSource<? extends T>> function, Consumer<? super D> consumer) {
        return using(callable, function, consumer, true);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> AbstractC8148c<T> wrap(MaybeSource<T> maybeSource) {
        if (maybeSource instanceof AbstractC8148c) {
            return i42.m((AbstractC8148c) maybeSource);
        }
        ObjectHelper.requireNonNull(maybeSource, "onSubscribe is null");
        return i42.m(new MaybeUnsafeCreate(maybeSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> AbstractC8148c<R> zip(Iterable<? extends MaybeSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        ObjectHelper.requireNonNull(function, "zipper is null");
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return i42.m(new MaybeZipIterable(iterable, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> AbstractC8148c<R> zipArray(Function<? super Object[], ? extends R> function, MaybeSource<? extends T>... maybeSourceArr) {
        ObjectHelper.requireNonNull(maybeSourceArr, "sources is null");
        if (maybeSourceArr.length == 0) {
            return empty();
        }
        ObjectHelper.requireNonNull(function, "zipper is null");
        return i42.m(new MaybeZipArray(maybeSourceArr, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> ambWith(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "other is null");
        return ambArray(this, maybeSource);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final <R> R as(@NonNull MaybeConverter<T, ? extends R> maybeConverter) {
        return (R) ((MaybeConverter) ObjectHelper.requireNonNull(maybeConverter, "converter is null")).apply(this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingGet() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return (T) blockingMultiObserver.blockingGet();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> cache() {
        return i42.m(new MaybeCache(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> AbstractC8148c<U> cast(Class<? extends U> cls) {
        ObjectHelper.requireNonNull(cls, "clazz is null");
        return (AbstractC8148c<U>) map(Functions.castFunction(cls));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> AbstractC8148c<R> compose(MaybeTransformer<? super T, ? extends R> maybeTransformer) {
        return wrap(((MaybeTransformer) ObjectHelper.requireNonNull(maybeTransformer, "transformer is null")).apply(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> AbstractC8148c<R> concatMap(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return i42.m(new MaybeFlatten(this, function));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final AbstractC8147b<T> concatWith(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "other is null");
        return concat(this, maybeSource);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8152e<Boolean> contains(Object obj) {
        ObjectHelper.requireNonNull(obj, "item is null");
        return i42.o(new MaybeContains(this, obj));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8152e<Long> count() {
        return i42.o(new MaybeCount(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> defaultIfEmpty(T t) {
        ObjectHelper.requireNonNull(t, "item is null");
        return switchIfEmpty(just(t));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final AbstractC8148c<T> delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, C8162a.a());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <U> AbstractC8148c<T> delaySubscription(Publisher<U> publisher) {
        ObjectHelper.requireNonNull(publisher, "subscriptionIndicator is null");
        return i42.m(new MaybeDelaySubscriptionOtherPublisher(this, publisher));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> doAfterSuccess(Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, "doAfterSuccess is null");
        return i42.m(new MaybeDoAfterSuccess(this, consumer));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> doAfterTerminate(Action action) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return i42.m(new MaybePeek(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action2, (Action) ObjectHelper.requireNonNull(action, "onAfterTerminate is null"), action2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> doFinally(Action action) {
        ObjectHelper.requireNonNull(action, "onFinally is null");
        return i42.m(new MaybeDoFinally(this, action));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> doOnComplete(Action action) {
        Action action2 = Functions.EMPTY_ACTION;
        return i42.m(new MaybePeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), (Action) ObjectHelper.requireNonNull(action, "onComplete is null"), action2, action2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> doOnDispose(Action action) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Consumer emptyConsumer3 = Functions.emptyConsumer();
        Action action2 = Functions.EMPTY_ACTION;
        return i42.m(new MaybePeek(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action2, action2, (Action) ObjectHelper.requireNonNull(action, "onDispose is null")));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> doOnError(Consumer<? super Throwable> consumer) {
        Action action = Functions.EMPTY_ACTION;
        return i42.m(new MaybePeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), (Consumer) ObjectHelper.requireNonNull(consumer, "onError is null"), action, action, action));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> doOnEvent(BiConsumer<? super T, ? super Throwable> biConsumer) {
        ObjectHelper.requireNonNull(biConsumer, "onEvent is null");
        return i42.m(new MaybeDoOnEvent(this, biConsumer));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> doOnSubscribe(Consumer<? super Disposable> consumer) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Consumer emptyConsumer2 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return i42.m(new MaybePeek(this, (Consumer) ObjectHelper.requireNonNull(consumer, "onSubscribe is null"), emptyConsumer, emptyConsumer2, action, action, action));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> doOnSuccess(Consumer<? super T> consumer) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return i42.m(new MaybePeek(this, Functions.emptyConsumer(), (Consumer) ObjectHelper.requireNonNull(consumer, "onSubscribe is null"), emptyConsumer, action, action, action));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> filter(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return i42.m(new MaybeFilter(this, predicate));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> AbstractC8148c<R> flatMap(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return i42.m(new MaybeFlatten(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8146a flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return i42.k(new MaybeFlatMapCompletable(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> AbstractC8149d<R> flatMapObservable(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return toObservable().flatMap(function);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> AbstractC8147b<R> flatMapPublisher(Function<? super T, ? extends Publisher<? extends R>> function) {
        return toFlowable().flatMap(function);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> AbstractC8152e<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return i42.o(new MaybeFlatMapSingle(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> AbstractC8148c<R> flatMapSingleElement(Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return i42.m(new MaybeFlatMapSingleElement(this, function));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U> AbstractC8147b<U> flattenAsFlowable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return i42.l(new MaybeFlatMapIterableFlowable(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> AbstractC8149d<U> flattenAsObservable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return i42.n(new MaybeFlatMapIterableObservable(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> hide() {
        return i42.m(new MaybeHide(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8146a ignoreElement() {
        return i42.k(new MaybeIgnoreElementCompletable(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8152e<Boolean> isEmpty() {
        return i42.o(new MaybeIsEmptySingle(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> AbstractC8148c<R> lift(MaybeOperator<? extends R, ? super T> maybeOperator) {
        ObjectHelper.requireNonNull(maybeOperator, "onLift is null");
        return i42.m(new MaybeLift(this, maybeOperator));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> AbstractC8148c<R> map(Function<? super T, ? extends R> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return i42.m(new MaybeMap(this, function));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final AbstractC8147b<T> mergeWith(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "other is null");
        return merge(this, maybeSource);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final AbstractC8148c<T> observeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return i42.m(new MaybeObserveOn(this, scheduler));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> AbstractC8148c<U> ofType(Class<U> cls) {
        ObjectHelper.requireNonNull(cls, "clazz is null");
        return filter(Functions.isInstanceOf(cls)).cast(cls);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> onErrorComplete() {
        return onErrorComplete(Functions.alwaysTrue());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> onErrorResumeNext(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "next is null");
        return onErrorResumeNext(Functions.justFunction(maybeSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> onErrorReturn(Function<? super Throwable, ? extends T> function) {
        ObjectHelper.requireNonNull(function, "valueSupplier is null");
        return i42.m(new MaybeOnErrorReturn(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> onErrorReturnItem(T t) {
        ObjectHelper.requireNonNull(t, "item is null");
        return onErrorReturn(Functions.justFunction(t));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> onExceptionResumeNext(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "next is null");
        return i42.m(new MaybeOnErrorNext(this, Functions.justFunction(maybeSource), false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> onTerminateDetach() {
        return i42.m(new MaybeDetach(this));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final AbstractC8147b<T> repeat() {
        return repeat(AbsPerformance.LONG_NIL);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final AbstractC8147b<T> repeatUntil(BooleanSupplier booleanSupplier) {
        return toFlowable().repeatUntil(booleanSupplier);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final AbstractC8147b<T> repeatWhen(Function<? super AbstractC8147b<Object>, ? extends Publisher<?>> function) {
        return toFlowable().repeatWhen(function);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> retry() {
        return retry(AbsPerformance.LONG_NIL, Functions.alwaysTrue());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> retryUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.requireNonNull(booleanSupplier, "stop is null");
        return retry(AbsPerformance.LONG_NIL, Functions.predicateReverseFor(booleanSupplier));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> retryWhen(Function<? super AbstractC8147b<Throwable>, ? extends Publisher<?>> function) {
        return toFlowable().retryWhen(function).singleElement();
    }

    @SchedulerSupport("none")
    public final Disposable subscribe() {
        return subscribe(Functions.emptyConsumer(), Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    protected abstract void subscribeActual(MaybeObserver<? super T> maybeObserver);

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final AbstractC8148c<T> subscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return i42.m(new MaybeSubscribeOn(this, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <E extends MaybeObserver<? super T>> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> switchIfEmpty(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "other is null");
        return i42.m(new MaybeSwitchIfEmpty(this, maybeSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> AbstractC8148c<T> takeUntil(MaybeSource<U> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "other is null");
        return i42.m(new MaybeTakeUntilMaybe(this, maybeSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver<T> test() {
        TestObserver<T> testObserver = new TestObserver<>();
        subscribe(testObserver);
        return testObserver;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final AbstractC8148c<T> timeout(long j, TimeUnit timeUnit) {
        return timeout(j, timeUnit, C8162a.a());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> R to(Function<? super AbstractC8148c<T>, R> function) {
        try {
            return (R) ((Function) ObjectHelper.requireNonNull(function, "convert is null")).apply(this);
        } catch (Throwable th) {
            dg0.b(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final AbstractC8147b<T> toFlowable() {
        if (this instanceof FuseToFlowable) {
            return ((FuseToFlowable) this).fuseToFlowable();
        }
        return i42.l(new MaybeToFlowable(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8149d<T> toObservable() {
        if (this instanceof FuseToObservable) {
            return ((FuseToObservable) this).fuseToObservable();
        }
        return i42.n(new MaybeToObservable(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8152e<T> toSingle(T t) {
        ObjectHelper.requireNonNull(t, "defaultValue is null");
        return i42.o(new MaybeToSingle(this, t));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final AbstractC8148c<T> unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return i42.m(new MaybeUnsubscribeOn(this, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> AbstractC8148c<R> zipWith(MaybeSource<? extends U> maybeSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(maybeSource, "other is null");
        return zip(this, maybeSource, biFunction);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> concatEager(Publisher<? extends MaybeSource<? extends T>> publisher) {
        return AbstractC8147b.fromPublisher(publisher).concatMapEager(MaybeToPublisher.instance());
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> merge(Publisher<? extends MaybeSource<? extends T>> publisher) {
        return merge(publisher, Integer.MAX_VALUE);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> mergeDelayError(Publisher<? extends MaybeSource<? extends T>> publisher) {
        return AbstractC8147b.fromPublisher(publisher).flatMap(MaybeToPublisher.instance(), true);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> AbstractC8152e<Boolean> sequenceEqual(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, BiPredicate<? super T, ? super T> biPredicate) {
        ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        ObjectHelper.requireNonNull(biPredicate, "isEqual is null");
        return i42.o(new MaybeEqualSingle(maybeSource, maybeSource2, biPredicate));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static AbstractC8148c<Long> timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return i42.m(new MaybeTimer(Math.max(0L, j), timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, D> AbstractC8148c<T> using(Callable<? extends D> callable, Function<? super D, ? extends MaybeSource<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        ObjectHelper.requireNonNull(callable, "resourceSupplier is null");
        ObjectHelper.requireNonNull(function, "sourceSupplier is null");
        ObjectHelper.requireNonNull(consumer, "disposer is null");
        return i42.m(new MaybeUsing(callable, function, consumer, z));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final AbstractC8148c<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return i42.m(new MaybeDelay(this, Math.max(0L, j), timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> onErrorComplete(Predicate<? super Throwable> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return i42.m(new MaybeOnErrorComplete(this, predicate));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final AbstractC8147b<T> repeat(long j) {
        return toFlowable().repeat(j);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        return toFlowable().retry(biPredicate).singleElement();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> consumer) {
        return subscribe(consumer, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final AbstractC8148c<T> timeout(long j, TimeUnit timeUnit, MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "other is null");
        return timeout(j, timeUnit, C8162a.a(), maybeSource);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> concat(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2) {
        ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        return concatArray(maybeSource, maybeSource2);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> concatDelayError(Publisher<? extends MaybeSource<? extends T>> publisher) {
        return AbstractC8147b.fromPublisher(publisher).concatMapDelayError(MaybeToPublisher.instance());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> AbstractC8148c<T> error(Callable<? extends Throwable> callable) {
        ObjectHelper.requireNonNull(callable, "errorSupplier is null");
        return i42.m(new MaybeErrorCallable(callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> AbstractC8148c<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        ObjectHelper.requireNonNull(future, "future is null");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        return i42.m(new MaybeFromFuture(future, j, timeUnit));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> merge(Publisher<? extends MaybeSource<? extends T>> publisher, int i) {
        ObjectHelper.requireNonNull(publisher, "source is null");
        ObjectHelper.verifyPositive(i, "maxConcurrency");
        return i42.l(new FlowableFlatMapPublisher(publisher, MaybeToPublisher.instance(), false, i, AbstractC8147b.bufferSize()));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public static <T> AbstractC8147b<T> mergeDelayError(Publisher<? extends MaybeSource<? extends T>> publisher, int i) {
        return AbstractC8147b.fromPublisher(publisher).flatMap(MaybeToPublisher.instance(), true, i);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final AbstractC8148c<T> delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, C8162a.a());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> AbstractC8148c<R> flatMap(Function<? super T, ? extends MaybeSource<? extends R>> function, Function<? super Throwable, ? extends MaybeSource<? extends R>> function2, Callable<? extends MaybeSource<? extends R>> callable) {
        ObjectHelper.requireNonNull(function, "onSuccessMapper is null");
        ObjectHelper.requireNonNull(function2, "onErrorMapper is null");
        ObjectHelper.requireNonNull(callable, "onCompleteSupplier is null");
        return i42.m(new MaybeFlatMapNotification(this, function, function2, callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> onErrorResumeNext(Function<? super Throwable, ? extends MaybeSource<? extends T>> function) {
        ObjectHelper.requireNonNull(function, "resumeFunction is null");
        return i42.m(new MaybeOnErrorNext(this, function, true));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> retry(long j) {
        return retry(j, Functions.alwaysTrue());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return subscribe(consumer, consumer2, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final AbstractC8152e<T> switchIfEmpty(SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "other is null");
        return i42.o(new MaybeSwitchIfEmptySingle(this, singleSource));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <U> AbstractC8148c<T> takeUntil(Publisher<U> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return i42.m(new MaybeTakeUntilPublisher(this, publisher));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver<T> test(boolean z) {
        TestObserver<T> testObserver = new TestObserver<>();
        if (z) {
            testObserver.cancel();
        }
        subscribe(testObserver);
        return testObserver;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8152e<T> toSingle() {
        return i42.o(new MaybeToSingle(this, null));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> mergeDelayError(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2) {
        ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        return mergeArrayDelayError(maybeSource, maybeSource2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, R> AbstractC8148c<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        return zipArray(Functions.toFunction(biFunction), maybeSource, maybeSource2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingGet(T t) {
        ObjectHelper.requireNonNull(t, "defaultValue is null");
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return (T) blockingMultiObserver.blockingGet(t);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final AbstractC8148c<T> delaySubscription(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delaySubscription(AbstractC8147b.timer(j, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> retry(long j, Predicate<? super Throwable> predicate) {
        return toFlowable().retry(j, predicate).singleElement();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        ObjectHelper.requireNonNull(consumer, "onSuccess is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        return (Disposable) subscribeWith(new MaybeCallbackObserver(consumer, consumer2, action));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final AbstractC8148c<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler, MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "fallback is null");
        return timeout(timer(j, timeUnit, scheduler), maybeSource);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <U, V> AbstractC8148c<T> delay(Publisher<U> publisher) {
        ObjectHelper.requireNonNull(publisher, "delayIndicator is null");
        return i42.m(new MaybeDelayOtherPublisher(this, publisher));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final AbstractC8148c<T> retry(Predicate<? super Throwable> predicate) {
        return retry(AbsPerformance.LONG_NIL, predicate);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> concat(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, MaybeSource<? extends T> maybeSource3) {
        ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        return concatArray(maybeSource, maybeSource2, maybeSource3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> AbstractC8148c<T> merge(MaybeSource<? extends MaybeSource<? extends T>> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "source is null");
        return i42.m(new MaybeFlatten(maybeSource, Functions.identity()));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final AbstractC8148c<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout(timer(j, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> mergeDelayError(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, MaybeSource<? extends T> maybeSource3) {
        ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        return mergeArrayDelayError(maybeSource, maybeSource2, maybeSource3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, R> AbstractC8148c<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, MaybeSource<? extends T3> maybeSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        return zipArray(Functions.toFunction(function3), maybeSource, maybeSource2, maybeSource3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> AbstractC8148c<R> flatMap(Function<? super T, ? extends MaybeSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
        return i42.m(new MaybeFlatMapBiSelector(this, function, biFunction));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> AbstractC8148c<T> timeout(MaybeSource<U> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "timeoutIndicator is null");
        return i42.m(new MaybeTimeoutMaybe(this, maybeSource, null));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> merge(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2) {
        ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        return mergeArray(maybeSource, maybeSource2);
    }

    @Override // io.reactivex.MaybeSource
    @SchedulerSupport("none")
    public final void subscribe(MaybeObserver<? super T> maybeObserver) {
        ObjectHelper.requireNonNull(maybeObserver, "observer is null");
        MaybeObserver<? super T> y = i42.y(this, maybeObserver);
        ObjectHelper.requireNonNull(y, "observer returned by the RxJavaPlugins hook is null");
        try {
            subscribeActual(y);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            dg0.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> AbstractC8148c<T> timeout(MaybeSource<U> maybeSource, MaybeSource<? extends T> maybeSource2) {
        ObjectHelper.requireNonNull(maybeSource, "timeoutIndicator is null");
        ObjectHelper.requireNonNull(maybeSource2, "fallback is null");
        return i42.m(new MaybeTimeoutMaybe(this, maybeSource, maybeSource2));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> concat(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, MaybeSource<? extends T> maybeSource3, MaybeSource<? extends T> maybeSource4) {
        ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
        return concatArray(maybeSource, maybeSource2, maybeSource3, maybeSource4);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> merge(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, MaybeSource<? extends T> maybeSource3) {
        ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        return mergeArray(maybeSource, maybeSource2, maybeSource3);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> mergeDelayError(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, MaybeSource<? extends T> maybeSource3, MaybeSource<? extends T> maybeSource4) {
        ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
        return mergeArrayDelayError(maybeSource, maybeSource2, maybeSource3, maybeSource4);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, R> AbstractC8148c<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, MaybeSource<? extends T3> maybeSource3, MaybeSource<? extends T4> maybeSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
        return zipArray(Functions.toFunction(function4), maybeSource, maybeSource2, maybeSource3, maybeSource4);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <U> AbstractC8148c<T> timeout(Publisher<U> publisher) {
        ObjectHelper.requireNonNull(publisher, "timeoutIndicator is null");
        return i42.m(new MaybeTimeoutPublisher(this, publisher, null));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <U> AbstractC8148c<T> timeout(Publisher<U> publisher, MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(publisher, "timeoutIndicator is null");
        ObjectHelper.requireNonNull(maybeSource, "fallback is null");
        return i42.m(new MaybeTimeoutPublisher(this, publisher, maybeSource));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> concat(Publisher<? extends MaybeSource<? extends T>> publisher) {
        return concat(publisher, 2);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> merge(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, MaybeSource<? extends T> maybeSource3, MaybeSource<? extends T> maybeSource4) {
        ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
        return mergeArray(maybeSource, maybeSource2, maybeSource3, maybeSource4);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> AbstractC8147b<T> concat(Publisher<? extends MaybeSource<? extends T>> publisher, int i) {
        ObjectHelper.requireNonNull(publisher, "sources is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        return i42.l(new FlowableConcatMapPublisher(publisher, MaybeToPublisher.instance(), i, ErrorMode.IMMEDIATE));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, R> AbstractC8148c<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, MaybeSource<? extends T3> maybeSource3, MaybeSource<? extends T4> maybeSource4, MaybeSource<? extends T5> maybeSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
        ObjectHelper.requireNonNull(maybeSource5, "source5 is null");
        return zipArray(Functions.toFunction(function5), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, R> AbstractC8148c<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, MaybeSource<? extends T3> maybeSource3, MaybeSource<? extends T4> maybeSource4, MaybeSource<? extends T5> maybeSource5, MaybeSource<? extends T6> maybeSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
        ObjectHelper.requireNonNull(maybeSource5, "source5 is null");
        ObjectHelper.requireNonNull(maybeSource6, "source6 is null");
        return zipArray(Functions.toFunction(function6), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, R> AbstractC8148c<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, MaybeSource<? extends T3> maybeSource3, MaybeSource<? extends T4> maybeSource4, MaybeSource<? extends T5> maybeSource5, MaybeSource<? extends T6> maybeSource6, MaybeSource<? extends T7> maybeSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
        ObjectHelper.requireNonNull(maybeSource5, "source5 is null");
        ObjectHelper.requireNonNull(maybeSource6, "source6 is null");
        ObjectHelper.requireNonNull(maybeSource7, "source7 is null");
        return zipArray(Functions.toFunction(function7), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> AbstractC8148c<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, MaybeSource<? extends T3> maybeSource3, MaybeSource<? extends T4> maybeSource4, MaybeSource<? extends T5> maybeSource5, MaybeSource<? extends T6> maybeSource6, MaybeSource<? extends T7> maybeSource7, MaybeSource<? extends T8> maybeSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
        ObjectHelper.requireNonNull(maybeSource5, "source5 is null");
        ObjectHelper.requireNonNull(maybeSource6, "source6 is null");
        ObjectHelper.requireNonNull(maybeSource7, "source7 is null");
        ObjectHelper.requireNonNull(maybeSource8, "source8 is null");
        return zipArray(Functions.toFunction(function8), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7, maybeSource8);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> AbstractC8148c<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, MaybeSource<? extends T3> maybeSource3, MaybeSource<? extends T4> maybeSource4, MaybeSource<? extends T5> maybeSource5, MaybeSource<? extends T6> maybeSource6, MaybeSource<? extends T7> maybeSource7, MaybeSource<? extends T8> maybeSource8, MaybeSource<? extends T9> maybeSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
        ObjectHelper.requireNonNull(maybeSource5, "source5 is null");
        ObjectHelper.requireNonNull(maybeSource6, "source6 is null");
        ObjectHelper.requireNonNull(maybeSource7, "source7 is null");
        ObjectHelper.requireNonNull(maybeSource8, "source8 is null");
        ObjectHelper.requireNonNull(maybeSource9, "source9 is null");
        return zipArray(Functions.toFunction(function9), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7, maybeSource8, maybeSource9);
    }
}
