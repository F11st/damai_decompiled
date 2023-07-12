package io.reactivex;

import com.alimm.xadsdk.base.expose.MonitorType;
import com.alimm.xadsdk.base.ut.AdUtConstants;
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
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.observers.BlockingFirstObserver;
import io.reactivex.internal.observers.BlockingLastObserver;
import io.reactivex.internal.observers.ForEachWhileObserver;
import io.reactivex.internal.observers.FutureObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.flowable.FlowableFromObservable;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.internal.operators.observable.BlockingObservableIterable;
import io.reactivex.internal.operators.observable.BlockingObservableLatest;
import io.reactivex.internal.operators.observable.BlockingObservableMostRecent;
import io.reactivex.internal.operators.observable.BlockingObservableNext;
import io.reactivex.internal.operators.observable.ObservableAllSingle;
import io.reactivex.internal.operators.observable.ObservableAmb;
import io.reactivex.internal.operators.observable.ObservableAnySingle;
import io.reactivex.internal.operators.observable.ObservableBlockingSubscribe;
import io.reactivex.internal.operators.observable.ObservableBuffer;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary;
import io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableBufferExactBoundary;
import io.reactivex.internal.operators.observable.ObservableBufferTimed;
import io.reactivex.internal.operators.observable.ObservableCache;
import io.reactivex.internal.operators.observable.ObservableCollectSingle;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableConcatMapCompletable;
import io.reactivex.internal.operators.observable.ObservableConcatMapEager;
import io.reactivex.internal.operators.observable.ObservableConcatWithCompletable;
import io.reactivex.internal.operators.observable.ObservableConcatWithMaybe;
import io.reactivex.internal.operators.observable.ObservableConcatWithSingle;
import io.reactivex.internal.operators.observable.ObservableCountSingle;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableDebounce;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.internal.operators.observable.ObservableDefer;
import io.reactivex.internal.operators.observable.ObservableDelay;
import io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther;
import io.reactivex.internal.operators.observable.ObservableDematerialize;
import io.reactivex.internal.operators.observable.ObservableDetach;
import io.reactivex.internal.operators.observable.ObservableDistinct;
import io.reactivex.internal.operators.observable.ObservableDistinctUntilChanged;
import io.reactivex.internal.operators.observable.ObservableDoAfterNext;
import io.reactivex.internal.operators.observable.ObservableDoFinally;
import io.reactivex.internal.operators.observable.ObservableDoOnEach;
import io.reactivex.internal.operators.observable.ObservableDoOnLifecycle;
import io.reactivex.internal.operators.observable.ObservableElementAtMaybe;
import io.reactivex.internal.operators.observable.ObservableElementAtSingle;
import io.reactivex.internal.operators.observable.ObservableEmpty;
import io.reactivex.internal.operators.observable.ObservableError;
import io.reactivex.internal.operators.observable.ObservableFilter;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.observable.ObservableFlatMapMaybe;
import io.reactivex.internal.operators.observable.ObservableFlatMapSingle;
import io.reactivex.internal.operators.observable.ObservableFlattenIterable;
import io.reactivex.internal.operators.observable.ObservableFromArray;
import io.reactivex.internal.operators.observable.ObservableFromCallable;
import io.reactivex.internal.operators.observable.ObservableFromFuture;
import io.reactivex.internal.operators.observable.ObservableFromIterable;
import io.reactivex.internal.operators.observable.ObservableFromPublisher;
import io.reactivex.internal.operators.observable.ObservableFromUnsafeSource;
import io.reactivex.internal.operators.observable.ObservableGenerate;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.operators.observable.ObservableHide;
import io.reactivex.internal.operators.observable.ObservableIgnoreElements;
import io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable;
import io.reactivex.internal.operators.observable.ObservableInternalHelper;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableIntervalRange;
import io.reactivex.internal.operators.observable.ObservableJoin;
import io.reactivex.internal.operators.observable.ObservableJust;
import io.reactivex.internal.operators.observable.ObservableLastMaybe;
import io.reactivex.internal.operators.observable.ObservableLastSingle;
import io.reactivex.internal.operators.observable.ObservableLift;
import io.reactivex.internal.operators.observable.ObservableMap;
import io.reactivex.internal.operators.observable.ObservableMapNotification;
import io.reactivex.internal.operators.observable.ObservableMaterialize;
import io.reactivex.internal.operators.observable.ObservableMergeWithCompletable;
import io.reactivex.internal.operators.observable.ObservableMergeWithMaybe;
import io.reactivex.internal.operators.observable.ObservableMergeWithSingle;
import io.reactivex.internal.operators.observable.ObservableNever;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservableOnErrorNext;
import io.reactivex.internal.operators.observable.ObservableOnErrorReturn;
import io.reactivex.internal.operators.observable.ObservablePublish;
import io.reactivex.internal.operators.observable.ObservablePublishSelector;
import io.reactivex.internal.operators.observable.ObservableRange;
import io.reactivex.internal.operators.observable.ObservableRangeLong;
import io.reactivex.internal.operators.observable.ObservableReduceMaybe;
import io.reactivex.internal.operators.observable.ObservableReduceSeedSingle;
import io.reactivex.internal.operators.observable.ObservableReduceWithSingle;
import io.reactivex.internal.operators.observable.ObservableRepeat;
import io.reactivex.internal.operators.observable.ObservableRepeatUntil;
import io.reactivex.internal.operators.observable.ObservableRepeatWhen;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.operators.observable.ObservableRetryBiPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryWhen;
import io.reactivex.internal.operators.observable.ObservableSampleTimed;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.ObservableScan;
import io.reactivex.internal.operators.observable.ObservableScanSeed;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle;
import io.reactivex.internal.operators.observable.ObservableSerialized;
import io.reactivex.internal.operators.observable.ObservableSingleMaybe;
import io.reactivex.internal.operators.observable.ObservableSingleSingle;
import io.reactivex.internal.operators.observable.ObservableSkip;
import io.reactivex.internal.operators.observable.ObservableSkipLast;
import io.reactivex.internal.operators.observable.ObservableSkipLastTimed;
import io.reactivex.internal.operators.observable.ObservableSkipUntil;
import io.reactivex.internal.operators.observable.ObservableSkipWhile;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableSwitchIfEmpty;
import io.reactivex.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.internal.operators.observable.ObservableTake;
import io.reactivex.internal.operators.observable.ObservableTakeLast;
import io.reactivex.internal.operators.observable.ObservableTakeLastOne;
import io.reactivex.internal.operators.observable.ObservableTakeLastTimed;
import io.reactivex.internal.operators.observable.ObservableTakeUntil;
import io.reactivex.internal.operators.observable.ObservableTakeUntilPredicate;
import io.reactivex.internal.operators.observable.ObservableTakeWhile;
import io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed;
import io.reactivex.internal.operators.observable.ObservableTimeInterval;
import io.reactivex.internal.operators.observable.ObservableTimeout;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.internal.operators.observable.ObservableTimer;
import io.reactivex.internal.operators.observable.ObservableToList;
import io.reactivex.internal.operators.observable.ObservableToListSingle;
import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn;
import io.reactivex.internal.operators.observable.ObservableUsing;
import io.reactivex.internal.operators.observable.ObservableWindow;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableWindowTimed;
import io.reactivex.internal.operators.observable.ObservableWithLatestFrom;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany;
import io.reactivex.internal.operators.observable.ObservableZip;
import io.reactivex.internal.operators.observable.ObservableZipIterable;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.observers.TestObserver;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import tb.bn;
import tb.dg0;
import tb.i42;
import tb.io2;
import tb.r52;
import tb.ul1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class d<T> implements ObservableSource<T> {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BackpressureStrategy.values().length];
            a = iArr;
            try {
                iArr[BackpressureStrategy.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BackpressureStrategy.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BackpressureStrategy.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BackpressureStrategy.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> amb(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return i42.n(new ObservableAmb(null, iterable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> ambArray(ObservableSource<? extends T>... observableSourceArr) {
        ObjectHelper.requireNonNull(observableSourceArr, "sources is null");
        int length = observableSourceArr.length;
        if (length == 0) {
            return empty();
        }
        if (length == 1) {
            return wrap(observableSourceArr[0]);
        }
        return i42.n(new ObservableAmb(observableSourceArr, null));
    }

    public static int bufferSize() {
        return b.bufferSize();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> d<R> combineLatest(Function<? super Object[], ? extends R> function, int i, ObservableSource<? extends T>... observableSourceArr) {
        return combineLatest(observableSourceArr, function, i);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> d<R> combineLatestDelayError(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function) {
        return combineLatestDelayError(observableSourceArr, function, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> concat(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(Functions.identity(), bufferSize(), false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> concatArray(ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        if (observableSourceArr.length == 1) {
            return wrap(observableSourceArr[0]);
        }
        return i42.n(new ObservableConcatMap(fromArray(observableSourceArr), Functions.identity(), bufferSize(), ErrorMode.BOUNDARY));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> concatArrayDelayError(ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        if (observableSourceArr.length == 1) {
            return wrap(observableSourceArr[0]);
        }
        return concatDelayError(fromArray(observableSourceArr));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> concatArrayEager(ObservableSource<? extends T>... observableSourceArr) {
        return concatArrayEager(bufferSize(), bufferSize(), observableSourceArr);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> concatDelayError(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return concatDelayError(fromIterable(iterable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concatEager(observableSource, bufferSize(), bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> create(ObservableOnSubscribe<T> observableOnSubscribe) {
        ObjectHelper.requireNonNull(observableOnSubscribe, "source is null");
        return i42.n(new ObservableCreate(observableOnSubscribe));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> defer(Callable<? extends ObservableSource<? extends T>> callable) {
        ObjectHelper.requireNonNull(callable, "supplier is null");
        return i42.n(new ObservableDefer(callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    private d<T> doOnEach(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        ObjectHelper.requireNonNull(action2, "onAfterTerminate is null");
        return i42.n(new ObservableDoOnEach(this, consumer, consumer2, action, action2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> empty() {
        return i42.n(ObservableEmpty.INSTANCE);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> error(Callable<? extends Throwable> callable) {
        ObjectHelper.requireNonNull(callable, "errorSupplier is null");
        return i42.n(new ObservableError(callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> fromArray(T... tArr) {
        ObjectHelper.requireNonNull(tArr, "items is null");
        if (tArr.length == 0) {
            return empty();
        }
        if (tArr.length == 1) {
            return just(tArr[0]);
        }
        return i42.n(new ObservableFromArray(tArr));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> fromCallable(Callable<? extends T> callable) {
        ObjectHelper.requireNonNull(callable, "supplier is null");
        return i42.n(new ObservableFromCallable(callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> fromFuture(Future<? extends T> future) {
        ObjectHelper.requireNonNull(future, "future is null");
        return i42.n(new ObservableFromFuture(future, 0L, null));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> fromIterable(Iterable<? extends T> iterable) {
        ObjectHelper.requireNonNull(iterable, "source is null");
        return i42.n(new ObservableFromIterable(iterable));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static <T> d<T> fromPublisher(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, "publisher is null");
        return i42.n(new ObservableFromPublisher(publisher));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> generate(Consumer<Emitter<T>> consumer) {
        ObjectHelper.requireNonNull(consumer, "generator  is null");
        return generate(Functions.nullSupplier(), ObservableInternalHelper.simpleGenerator(consumer), Functions.emptyConsumer());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static d<Long> interval(long j, long j2, TimeUnit timeUnit) {
        return interval(j, j2, timeUnit, io.reactivex.schedulers.a.a());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static d<Long> intervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit) {
        return intervalRange(j, j2, j3, j4, timeUnit, io.reactivex.schedulers.a.a());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> just(T t) {
        ObjectHelper.requireNonNull(t, "The item is null");
        return i42.n(new ObservableJust(t));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).flatMap(Functions.identity(), false, i, i2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> mergeArray(int i, int i2, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.identity(), false, i, i2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> mergeArrayDelayError(int i, int i2, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.identity(), true, i, i2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.identity(), true);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> never() {
        return i42.n(ObservableNever.INSTANCE);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static d<Integer> range(int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i2);
        } else if (i2 == 0) {
            return empty();
        } else {
            if (i2 == 1) {
                return just(Integer.valueOf(i));
            }
            if (i + (i2 - 1) <= 2147483647L) {
                return i42.n(new ObservableRange(i, i2));
            }
            throw new IllegalArgumentException("Integer overflow");
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static d<Long> rangeLong(long j, long j2) {
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j2);
        } else if (i == 0) {
            return empty();
        } else {
            if (j2 == 1) {
                return just(Long.valueOf(j));
            }
            long j3 = (j2 - 1) + j;
            if (j > 0 && j3 < 0) {
                throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
            }
            return i42.n(new ObservableRangeLong(j, j2));
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> e<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        return sequenceEqual(observableSource, observableSource2, ObjectHelper.equalsPredicate(), bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i) {
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return i42.n(new ObservableSwitchMap(observableSource, Functions.identity(), i, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return switchOnNextDelayError(observableSource, bufferSize());
    }

    private d<T> timeout0(long j, TimeUnit timeUnit, ObservableSource<? extends T> observableSource, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "timeUnit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return i42.n(new ObservableTimeoutTimed(this, j, timeUnit, scheduler, observableSource));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static d<Long> timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, io.reactivex.schedulers.a.a());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> unsafeCreate(ObservableSource<T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "source is null");
        ObjectHelper.requireNonNull(observableSource, "onSubscribe is null");
        if (!(observableSource instanceof d)) {
            return i42.n(new ObservableFromUnsafeSource(observableSource));
        }
        throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, D> d<T> using(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer) {
        return using(callable, function, consumer, true);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> wrap(ObservableSource<T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "source is null");
        if (observableSource instanceof d) {
            return i42.n((d) observableSource);
        }
        return i42.n(new ObservableFromUnsafeSource(observableSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> d<R> zip(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        ObjectHelper.requireNonNull(function, "zipper is null");
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return i42.n(new ObservableZip(null, iterable, function, bufferSize(), false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> d<R> zipArray(Function<? super Object[], ? extends R> function, boolean z, int i, ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        ObjectHelper.requireNonNull(function, "zipper is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return i42.n(new ObservableZip(observableSourceArr, null, function, i, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> d<R> zipIterable(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, boolean z, int i) {
        ObjectHelper.requireNonNull(function, "zipper is null");
        ObjectHelper.requireNonNull(iterable, "sources is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return i42.n(new ObservableZip(null, iterable, function, i, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<Boolean> all(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return i42.o(new ObservableAllSingle(this, predicate));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> ambWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return ambArray(this, observableSource);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<Boolean> any(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return i42.o(new ObservableAnySingle(this, predicate));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final <R> R as(@NonNull ObservableConverter<T, ? extends R> observableConverter) {
        return (R) ((ObservableConverter) ObjectHelper.requireNonNull(observableConverter, "converter is null")).apply(this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingFirst() {
        BlockingFirstObserver blockingFirstObserver = new BlockingFirstObserver();
        subscribe(blockingFirstObserver);
        T blockingGet = blockingFirstObserver.blockingGet();
        if (blockingGet != null) {
            return blockingGet;
        }
        throw new NoSuchElementException();
    }

    @SchedulerSupport("none")
    public final void blockingForEach(Consumer<? super T> consumer) {
        Iterator<T> it = blockingIterable().iterator();
        while (it.hasNext()) {
            try {
                consumer.accept(it.next());
            } catch (Throwable th) {
                dg0.b(th);
                ((Disposable) it).dispose();
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingLast() {
        BlockingLastObserver blockingLastObserver = new BlockingLastObserver();
        subscribe(blockingLastObserver);
        T blockingGet = blockingLastObserver.blockingGet();
        if (blockingGet != null) {
            return blockingGet;
        }
        throw new NoSuchElementException();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable<T> blockingLatest() {
        return new BlockingObservableLatest(this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable<T> blockingMostRecent(T t) {
        return new BlockingObservableMostRecent(this, t);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable<T> blockingNext() {
        return new BlockingObservableNext(this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingSingle() {
        T blockingGet = singleElement().blockingGet();
        if (blockingGet != null) {
            return blockingGet;
        }
        throw new NoSuchElementException();
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe() {
        ObservableBlockingSubscribe.subscribe(this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<List<T>> buffer(int i) {
        return buffer(i, i);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> cache() {
        return ObservableCache.from(this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> cacheWithInitialCapacity(int i) {
        return ObservableCache.from(this, i);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> d<U> cast(Class<U> cls) {
        ObjectHelper.requireNonNull(cls, "clazz is null");
        return (d<U>) map(Functions.castFunction(cls));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> e<U> collect(Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        ObjectHelper.requireNonNull(callable, "initialValueSupplier is null");
        ObjectHelper.requireNonNull(biConsumer, "collector is null");
        return i42.o(new ObservableCollectSingle(this, callable, biConsumer));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> e<U> collectInto(U u, BiConsumer<? super U, ? super T> biConsumer) {
        ObjectHelper.requireNonNull(u, "initialValue is null");
        return collect(Functions.justCallable(u), biConsumer);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> compose(ObservableTransformer<? super T, ? extends R> observableTransformer) {
        return wrap(((ObservableTransformer) ObjectHelper.requireNonNull(observableTransformer, "composer is null")).apply(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMap(function, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final io.reactivex.a concatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        return concatMapCompletable(function, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMapDelayError(function, bufferSize(), true);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMapEager(function, Integer.MAX_VALUE, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z) {
        return concatMapEagerDelayError(function, Integer.MAX_VALUE, bufferSize(), z);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> d<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return i42.n(new ObservableFlattenIterable(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> concatWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return concat(this, observableSource);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<Boolean> contains(Object obj) {
        ObjectHelper.requireNonNull(obj, "element is null");
        return any(Functions.equalsWith(obj));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<Long> count() {
        return i42.o(new ObservableCountSingle(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> d<T> debounce(Function<? super T, ? extends ObservableSource<U>> function) {
        ObjectHelper.requireNonNull(function, "debounceSelector is null");
        return i42.n(new ObservableDebounce(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> defaultIfEmpty(T t) {
        ObjectHelper.requireNonNull(t, "defaultItem is null");
        return switchIfEmpty(just(t));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> d<T> delay(Function<? super T, ? extends ObservableSource<U>> function) {
        ObjectHelper.requireNonNull(function, "itemDelay is null");
        return (d<T>) flatMap(ObservableInternalHelper.itemDelay(function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> d<T> delaySubscription(ObservableSource<U> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return i42.n(new ObservableDelaySubscriptionOther(this, observableSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T2> d<T2> dematerialize() {
        return i42.n(new ObservableDematerialize(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> distinct() {
        return distinct(Functions.identity(), Functions.createHashSet());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> distinctUntilChanged() {
        return distinctUntilChanged(Functions.identity());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> doAfterNext(Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, "onAfterNext is null");
        return i42.n(new ObservableDoAfterNext(this, consumer));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> doAfterTerminate(Action action) {
        ObjectHelper.requireNonNull(action, "onFinally is null");
        return doOnEach(Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, action);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> doFinally(Action action) {
        ObjectHelper.requireNonNull(action, "onFinally is null");
        return i42.n(new ObservableDoFinally(this, action));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> doOnComplete(Action action) {
        return doOnEach(Functions.emptyConsumer(), Functions.emptyConsumer(), action, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> doOnDispose(Action action) {
        return doOnLifecycle(Functions.emptyConsumer(), action);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> doOnError(Consumer<? super Throwable> consumer) {
        Consumer<? super T> emptyConsumer = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return doOnEach(emptyConsumer, consumer, action, action);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> doOnLifecycle(Consumer<? super Disposable> consumer, Action action) {
        ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
        ObjectHelper.requireNonNull(action, "onDispose is null");
        return i42.n(new ObservableDoOnLifecycle(this, consumer, action));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> doOnNext(Consumer<? super T> consumer) {
        Consumer<? super Throwable> emptyConsumer = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return doOnEach(consumer, emptyConsumer, action, action);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> doOnSubscribe(Consumer<? super Disposable> consumer) {
        return doOnLifecycle(consumer, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> doOnTerminate(Action action) {
        ObjectHelper.requireNonNull(action, "onTerminate is null");
        return doOnEach(Functions.emptyConsumer(), Functions.actionConsumer(action), action, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final c<T> elementAt(long j) {
        if (j >= 0) {
            return i42.m(new ObservableElementAtMaybe(this, j));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> elementAtOrError(long j) {
        if (j >= 0) {
            return i42.o(new ObservableElementAtSingle(this, j, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> filter(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return i42.n(new ObservableFilter(this, predicate));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> first(T t) {
        return elementAt(0L, t);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final c<T> firstElement() {
        return elementAt(0L);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> firstOrError() {
        return elementAtOrError(0L);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return flatMap((Function) function, false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final io.reactivex.a flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        return flatMapCompletable(function, false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> d<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return i42.n(new ObservableFlattenIterable(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return flatMapMaybe(function, false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return flatMapSingle(function, false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable forEach(Consumer<? super T> consumer) {
        return subscribe(consumer);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable forEachWhile(Predicate<? super T> predicate) {
        return forEachWhile(predicate, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> d<io.reactivex.observables.a<K, T>> groupBy(Function<? super T, ? extends K> function) {
        return (d<io.reactivex.observables.a<K, T>>) groupBy(function, Functions.identity(), false, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <TRight, TLeftEnd, TRightEnd, R> d<R> groupJoin(ObservableSource<? extends TRight> observableSource, Function<? super T, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super T, ? super d<TRight>, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        ObjectHelper.requireNonNull(function, "leftEnd is null");
        ObjectHelper.requireNonNull(function2, "rightEnd is null");
        ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
        return i42.n(new ObservableGroupJoin(this, observableSource, function, function2, biFunction));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> hide() {
        return i42.n(new ObservableHide(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final io.reactivex.a ignoreElements() {
        return i42.k(new ObservableIgnoreElementsCompletable(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<Boolean> isEmpty() {
        return all(Functions.alwaysFalse());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <TRight, TLeftEnd, TRightEnd, R> d<R> join(ObservableSource<? extends TRight> observableSource, Function<? super T, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super T, ? super TRight, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        ObjectHelper.requireNonNull(function, "leftEnd is null");
        ObjectHelper.requireNonNull(function2, "rightEnd is null");
        ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
        return i42.n(new ObservableJoin(this, observableSource, function, function2, biFunction));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> last(T t) {
        ObjectHelper.requireNonNull(t, "defaultItem is null");
        return i42.o(new ObservableLastSingle(this, t));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final c<T> lastElement() {
        return i42.m(new ObservableLastMaybe(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> lastOrError() {
        return i42.o(new ObservableLastSingle(this, null));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> lift(ObservableOperator<? extends R, ? super T> observableOperator) {
        ObjectHelper.requireNonNull(observableOperator, "onLift is null");
        return i42.n(new ObservableLift(this, observableOperator));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> map(Function<? super T, ? extends R> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return i42.n(new ObservableMap(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<ul1<T>> materialize() {
        return i42.n(new ObservableMaterialize(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> mergeWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return merge(this, observableSource);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> observeOn(Scheduler scheduler) {
        return observeOn(scheduler, false, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> d<U> ofType(Class<U> cls) {
        ObjectHelper.requireNonNull(cls, "clazz is null");
        return filter(Functions.isInstanceOf(cls)).cast(cls);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> onErrorResumeNext(Function<? super Throwable, ? extends ObservableSource<? extends T>> function) {
        ObjectHelper.requireNonNull(function, "resumeFunction is null");
        return i42.n(new ObservableOnErrorNext(this, function, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> onErrorReturn(Function<? super Throwable, ? extends T> function) {
        ObjectHelper.requireNonNull(function, "valueSupplier is null");
        return i42.n(new ObservableOnErrorReturn(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> onErrorReturnItem(T t) {
        ObjectHelper.requireNonNull(t, "item is null");
        return onErrorReturn(Functions.justFunction(t));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> onExceptionResumeNext(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "next is null");
        return i42.n(new ObservableOnErrorNext(this, Functions.justFunction(observableSource), true));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> onTerminateDetach() {
        return i42.n(new ObservableDetach(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final bn<T> publish() {
        return ObservablePublish.create(this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final c<T> reduce(BiFunction<T, T, T> biFunction) {
        ObjectHelper.requireNonNull(biFunction, "reducer is null");
        return i42.m(new ObservableReduceMaybe(this, biFunction));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> e<R> reduceWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(callable, "seedSupplier is null");
        ObjectHelper.requireNonNull(biFunction, "reducer is null");
        return i42.o(new ObservableReduceWithSingle(this, callable, biFunction));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> repeat() {
        return repeat(AbsPerformance.LONG_NIL);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> repeatUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.requireNonNull(booleanSupplier, "stop is null");
        return i42.n(new ObservableRepeatUntil(this, booleanSupplier));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> repeatWhen(Function<? super d<Object>, ? extends ObservableSource<?>> function) {
        ObjectHelper.requireNonNull(function, "handler is null");
        return i42.n(new ObservableRepeatWhen(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final bn<T> replay() {
        return ObservableReplay.createFrom(this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> retry() {
        return retry(AbsPerformance.LONG_NIL, Functions.alwaysTrue());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> retryUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.requireNonNull(booleanSupplier, "stop is null");
        return retry(AbsPerformance.LONG_NIL, Functions.predicateReverseFor(booleanSupplier));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> retryWhen(Function<? super d<Throwable>, ? extends ObservableSource<?>> function) {
        ObjectHelper.requireNonNull(function, "handler is null");
        return i42.n(new ObservableRetryWhen(this, function));
    }

    @SchedulerSupport("none")
    public final void safeSubscribe(Observer<? super T> observer) {
        ObjectHelper.requireNonNull(observer, "s is null");
        if (observer instanceof r52) {
            subscribe(observer);
        } else {
            subscribe(new r52(observer));
        }
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final d<T> sample(long j, TimeUnit timeUnit) {
        return sample(j, timeUnit, io.reactivex.schedulers.a.a());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> scan(BiFunction<T, T, T> biFunction) {
        ObjectHelper.requireNonNull(biFunction, "accumulator is null");
        return i42.n(new ObservableScan(this, biFunction));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> scanWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(callable, "seedSupplier is null");
        ObjectHelper.requireNonNull(biFunction, "accumulator is null");
        return i42.n(new ObservableScanSeed(this, callable, biFunction));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> serialize() {
        return i42.n(new ObservableSerialized(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> share() {
        return publish().refCount();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> single(T t) {
        ObjectHelper.requireNonNull(t, "defaultItem is null");
        return i42.o(new ObservableSingleSingle(this, t));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final c<T> singleElement() {
        return i42.m(new ObservableSingleMaybe(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> singleOrError() {
        return i42.o(new ObservableSingleSingle(this, null));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> skip(long j) {
        if (j <= 0) {
            return i42.n(this);
        }
        return i42.n(new ObservableSkip(this, j));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> skipLast(int i) {
        if (i >= 0) {
            if (i == 0) {
                return i42.n(this);
            }
            return i42.n(new ObservableSkipLast(this, i));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + i);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> d<T> skipUntil(ObservableSource<U> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return i42.n(new ObservableSkipUntil(this, observableSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> skipWhile(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return i42.n(new ObservableSkipWhile(this, predicate));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> sorted() {
        return toList().toObservable().map(Functions.listSorter(Functions.naturalComparator())).flatMapIterable(Functions.identity());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> startWith(Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> startWithArray(T... tArr) {
        d fromArray = fromArray(tArr);
        if (fromArray == empty()) {
            return i42.n(this);
        }
        return concatArray(fromArray, this);
    }

    @SchedulerSupport("none")
    public final Disposable subscribe() {
        return subscribe(Functions.emptyConsumer(), Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, Functions.emptyConsumer());
    }

    protected abstract void subscribeActual(Observer<? super T> observer);

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> subscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return i42.n(new ObservableSubscribeOn(this, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <E extends Observer<? super T>> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> switchIfEmpty(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return i42.n(new ObservableSwitchIfEmpty(this, observableSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return switchMap(function, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return switchMapDelayError(function, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    @NonNull
    public final <R> d<R> switchMapSingle(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        return ObservableInternalHelper.switchMapSingle(this, function);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    @NonNull
    public final <R> d<R> switchMapSingleDelayError(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        return ObservableInternalHelper.switchMapSingleDelayError(this, function);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> take(long j) {
        if (j >= 0) {
            return i42.n(new ObservableTake(this, j));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> takeLast(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + i);
        } else if (i == 0) {
            return i42.n(new ObservableIgnoreElements(this));
        } else {
            if (i == 1) {
                return i42.n(new ObservableTakeLastOne(this));
            }
            return i42.n(new ObservableTakeLast(this, i));
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> d<T> takeUntil(ObservableSource<U> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return i42.n(new ObservableTakeUntil(this, observableSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> takeWhile(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return i42.n(new ObservableTakeWhile(this, predicate));
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
    public final d<T> throttleFirst(long j, TimeUnit timeUnit) {
        return throttleFirst(j, timeUnit, io.reactivex.schedulers.a.a());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final d<T> throttleLast(long j, TimeUnit timeUnit) {
        return sample(j, timeUnit);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final d<T> throttleWithTimeout(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<io2<T>> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, io.reactivex.schedulers.a.a());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <V> d<T> timeout(Function<? super T, ? extends ObservableSource<V>> function) {
        return timeout0(null, function, null);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<io2<T>> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, io.reactivex.schedulers.a.a());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> R to(Function<? super d<T>, R> function) {
        try {
            return (R) ((Function) ObjectHelper.requireNonNull(function, "converter is null")).apply(this);
        } catch (Throwable th) {
            dg0.b(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final b<T> toFlowable(BackpressureStrategy backpressureStrategy) {
        FlowableFromObservable flowableFromObservable = new FlowableFromObservable(this);
        int i = a.a[backpressureStrategy.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return flowableFromObservable.onBackpressureBuffer();
                    }
                    return i42.l(new FlowableOnBackpressureError(flowableFromObservable));
                }
                return flowableFromObservable;
            }
            return flowableFromObservable.onBackpressureLatest();
        }
        return flowableFromObservable.onBackpressureDrop();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Future<T> toFuture() {
        return (Future) subscribeWith(new FutureObserver());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<List<T>> toList() {
        return toList(16);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> e<Map<K, T>> toMap(Function<? super T, ? extends K> function) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        return (e<Map<K, T>>) collect(HashMapSupplier.asCallable(), Functions.toMapKeySelector(function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> e<Map<K, Collection<T>>> toMultimap(Function<? super T, ? extends K> function) {
        return (e<Map<K, Collection<T>>>) toMultimap(function, Functions.identity(), HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<List<T>> toSortedList() {
        return toSortedList(Functions.naturalOrder());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return i42.n(new ObservableUnsubscribeOn(this, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<d<T>> window(long j) {
        return window(j, j, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> d<R> withLatestFrom(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        ObjectHelper.requireNonNull(biFunction, "combiner is null");
        return i42.n(new ObservableWithLatestFrom(this, biFunction, observableSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> d<R> zipWith(Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(iterable, "other is null");
        ObjectHelper.requireNonNull(biFunction, "zipper is null");
        return i42.n(new ObservableZipIterable(this, iterable, biFunction));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> d<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return combineLatest(iterable, function, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> d<R> combineLatestDelayError(Function<? super Object[], ? extends R> function, int i, ObservableSource<? extends T>... observableSourceArr) {
        return combineLatestDelayError(observableSourceArr, function, i);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> concatArrayEager(int i, int i2, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).concatMapEagerDelayError(Functions.identity(), i, i2, false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i, int i2) {
        ObjectHelper.requireNonNull(Integer.valueOf(i), "maxConcurrency is null");
        ObjectHelper.requireNonNull(Integer.valueOf(i2), "prefetch is null");
        return wrap(observableSource).concatMapEager(Functions.identity(), i, i2);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static d<Long> interval(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return i42.n(new ObservableInterval(Math.max(0L, j), Math.max(0L, j2), timeUnit, scheduler));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static d<Long> intervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, Scheduler scheduler) {
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j2);
        } else if (i == 0) {
            return empty().delay(j3, timeUnit, scheduler);
        } else {
            long j5 = j + (j2 - 1);
            if (j > 0 && j5 < 0) {
                throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
            }
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return i42.n(new ObservableIntervalRange(j, j5, Math.max(0L, j3), Math.max(0L, j4), timeUnit, scheduler));
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.identity());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> mergeArray(ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.identity(), observableSourceArr.length);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> mergeArrayDelayError(ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.identity(), true, observableSourceArr.length);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).flatMap(Functions.identity(), true, i, i2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> e<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
        return sequenceEqual(observableSource, observableSource2, biPredicate, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i) {
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        return i42.n(new ObservableSwitchMap(observableSource, Functions.identity(), i, true));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static d<Long> timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return i42.n(new ObservableTimer(Math.max(j, 0L), timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, D> d<T> using(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        ObjectHelper.requireNonNull(callable, "resourceSupplier is null");
        ObjectHelper.requireNonNull(function, "sourceSupplier is null");
        ObjectHelper.requireNonNull(consumer, "disposer is null");
        return i42.n(new ObservableUsing(callable, function, consumer, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable<T> blockingIterable(int i) {
        ObjectHelper.verifyPositive(i, "bufferSize");
        return new BlockingObservableIterable(this, i);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer) {
        ObservableBlockingSubscribe.subscribe(this, consumer, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<List<T>> buffer(int i, int i2) {
        return (d<List<T>>) buffer(i, i2, ArrayListSupplier.asCallable());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call == null) {
                return empty();
            }
            return ObservableScalarXMap.scalarXMap(call, function);
        }
        return i42.n(new ObservableConcatMap(this, function, i, ErrorMode.IMMEDIATE));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final io.reactivex.a concatMapCompletable(Function<? super T, ? extends CompletableSource> function, int i) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i, "capacityHint");
        return i42.k(new ObservableConcatMapCompletable(this, function, i));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i, boolean z) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call == null) {
                return empty();
            }
            return ObservableScalarXMap.scalarXMap(call, function);
        }
        return i42.n(new ObservableConcatMap(this, function, i, z ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> function, int i, int i2) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i, "maxConcurrency");
        ObjectHelper.verifyPositive(i2, "prefetch");
        return i42.n(new ObservableConcatMapEager(this, function, ErrorMode.IMMEDIATE, i, i2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i, int i2, boolean z) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i, "maxConcurrency");
        ObjectHelper.verifyPositive(i2, "prefetch");
        return i42.n(new ObservableConcatMapEager(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i, i2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> d<T> distinct(Function<? super T, K> function) {
        return distinct(function, Functions.createHashSet());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> d<T> distinctUntilChanged(Function<? super T, K> function) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        return i42.n(new ObservableDistinctUntilChanged(this, function, ObjectHelper.equalsPredicate()));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z) {
        return flatMap(function, z, Integer.MAX_VALUE);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final io.reactivex.a flatMapCompletable(Function<? super T, ? extends CompletableSource> function, boolean z) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return i42.k(new ObservableFlatMapCompletableCompletable(this, function, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return i42.n(new ObservableFlatMapMaybe(this, function, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return i42.n(new ObservableFlatMapSingle(this, function, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer) {
        return forEachWhile(predicate, consumer, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> d<io.reactivex.observables.a<K, T>> groupBy(Function<? super T, ? extends K> function, boolean z) {
        return (d<io.reactivex.observables.a<K, T>>) groupBy(function, Functions.identity(), z, bufferSize());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> observeOn(Scheduler scheduler, boolean z) {
        return observeOn(scheduler, z, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> publish(Function<? super d<T>, ? extends ObservableSource<R>> function) {
        ObjectHelper.requireNonNull(function, "selector is null");
        return i42.n(new ObservablePublishSelector(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> repeat(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i == 0) {
                return empty();
            }
            return i42.n(new ObservableRepeat(this, j));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> replay(Function<? super d<T>, ? extends ObservableSource<R>> function) {
        ObjectHelper.requireNonNull(function, "selector is null");
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this), function);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        ObjectHelper.requireNonNull(biPredicate, "predicate is null");
        return i42.n(new ObservableRetryBiPredicate(this, biPredicate));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final d<T> sample(long j, TimeUnit timeUnit, boolean z) {
        return sample(j, timeUnit, io.reactivex.schedulers.a.a(), z);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> sorted(Comparator<? super T> comparator) {
        ObjectHelper.requireNonNull(comparator, "sortFunction is null");
        return toList().toObservable().map(Functions.listSorter(comparator)).flatMapIterable(Functions.identity());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> startWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return concatArray(observableSource, this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> consumer) {
        return subscribe(consumer, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, Functions.emptyConsumer());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call == null) {
                return empty();
            }
            return ObservableScalarXMap.scalarXMap(call, function);
        }
        return i42.n(new ObservableSwitchMap(this, function, i, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call == null) {
                return empty();
            }
            return ObservableScalarXMap.scalarXMap(call, function);
        }
        return i42.n(new ObservableSwitchMap(this, function, i, true));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> throttleFirst(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return i42.n(new ObservableThrottleFirstTimed(this, j, timeUnit, scheduler));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> throttleLast(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return sample(j, timeUnit, scheduler);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> throttleWithTimeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return debounce(j, timeUnit, scheduler);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<io2<T>> timeInterval(Scheduler scheduler) {
        return timeInterval(TimeUnit.MILLISECONDS, scheduler);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <V> d<T> timeout(Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return timeout0(null, function, observableSource);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<io2<T>> timestamp(Scheduler scheduler) {
        return timestamp(TimeUnit.MILLISECONDS, scheduler);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<List<T>> toList(int i) {
        ObjectHelper.verifyPositive(i, "capacityHint");
        return i42.o(new ObservableToListSingle(this, i));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<List<T>> toSortedList(Comparator<? super T> comparator) {
        ObjectHelper.requireNonNull(comparator, "comparator is null");
        return (e<List<T>>) toList().map(Functions.listSorter(comparator));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<d<T>> window(long j, long j2) {
        return window(j, j2, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> d<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        ObjectHelper.requireNonNull(function, "combiner is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return i42.n(new ObservableCombineLatest(null, iterable, function, i << 1, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> d<R> combineLatestDelayError(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function, int i) {
        ObjectHelper.verifyPositive(i, "bufferSize");
        ObjectHelper.requireNonNull(function, "combiner is null");
        if (observableSourceArr.length == 0) {
            return empty();
        }
        return i42.n(new ObservableCombineLatest(observableSourceArr, null, function, i << 1, true));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> concat(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concat(observableSource, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concatDelayError(observableSource, bufferSize(), true);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> error(Throwable th) {
        ObjectHelper.requireNonNull(th, "e is null");
        return error(Functions.justCallable(th));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        ObjectHelper.requireNonNull(future, "future is null");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        return i42.n(new ObservableFromFuture(future, j, timeUnit));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> just(T t, T t2) {
        ObjectHelper.requireNonNull(t, "The first item is null");
        ObjectHelper.requireNonNull(t2, "The second item is null");
        return fromArray(t, t2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable, int i) {
        return fromIterable(iterable).flatMap(Functions.identity(), i);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, int i) {
        return fromIterable(iterable).flatMap(Functions.identity(), true, i);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> e<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(biPredicate, "isEqual is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return i42.o(new ObservableSequenceEqualSingle(observableSource, observableSource2, biPredicate, i));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingSingle(T t) {
        return single(t).blockingGet();
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        ObservableBlockingSubscribe.subscribe(this, consumer, consumer2, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U extends Collection<? super T>> d<U> buffer(int i, int i2, Callable<U> callable) {
        ObjectHelper.verifyPositive(i, AdUtConstants.XAD_UT_ARG_COUNT);
        ObjectHelper.verifyPositive(i2, MonitorType.SKIP);
        ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        return i42.n(new ObservableBuffer(this, i, i2, callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> d<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, int i) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        return (d<U>) concatMap(ObservableInternalHelper.flatMapIntoIterable(function), i);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final d<T> concatWith(@NonNull SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "other is null");
        return i42.n(new ObservableConcatWithSingle(this, singleSource));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final d<T> debounce(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit, io.reactivex.schedulers.a.a());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final d<T> delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, io.reactivex.schedulers.a.a(), false);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final d<T> delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, io.reactivex.schedulers.a.a());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> d<T> distinct(Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        ObjectHelper.requireNonNull(callable, "collectionSupplier is null");
        return i42.n(new ObservableDistinct(this, function, callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<T> elementAt(long j, T t) {
        if (j >= 0) {
            ObjectHelper.requireNonNull(t, "defaultItem is null");
            return i42.o(new ObservableElementAtSingle(this, j, t));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z, int i) {
        return flatMap(function, z, i, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> d<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
        return (d<V>) flatMap(ObservableInternalHelper.flatMapIntoIterable(function), biFunction, false, bufferSize(), bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer, Action action) {
        ObjectHelper.requireNonNull(predicate, "onNext is null");
        ObjectHelper.requireNonNull(consumer, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        ForEachWhileObserver forEachWhileObserver = new ForEachWhileObserver(predicate, consumer, action);
        subscribe(forEachWhileObserver);
        return forEachWhileObserver;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> d<io.reactivex.observables.a<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return groupBy(function, function2, false, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final d<T> mergeWith(@NonNull SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "other is null");
        return i42.n(new ObservableMergeWithSingle(this, singleSource));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> observeOn(Scheduler scheduler, boolean z, int i) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return i42.n(new ObservableObserveOn(this, scheduler, z, i));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> onErrorResumeNext(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "next is null");
        return onErrorResumeNext(Functions.justFunction(observableSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> e<R> reduce(R r, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(r, "seed is null");
        ObjectHelper.requireNonNull(biFunction, "reducer is null");
        return i42.o(new ObservableReduceSeedSingle(this, r, biFunction));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> sample(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return i42.n(new ObservableSampleTimed(this, j, timeUnit, scheduler, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> scan(R r, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(r, "seed is null");
        return scanWith(Functions.justCallable(r), biFunction);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final d<T> skip(long j, TimeUnit timeUnit) {
        return skipUntil(timer(j, timeUnit));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return subscribe(consumer, consumer2, Functions.EMPTY_ACTION, Functions.emptyConsumer());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> take(long j, TimeUnit timeUnit) {
        return takeUntil(timer(j, timeUnit));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> takeUntil(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return i42.n(new ObservableTakeUntilPredicate(this, predicate));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver<T> test(boolean z) {
        TestObserver<T> testObserver = new TestObserver<>();
        if (z) {
            testObserver.dispose();
        }
        subscribe(testObserver);
        return testObserver;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<io2<T>> timeInterval(TimeUnit timeUnit) {
        return timeInterval(timeUnit, io.reactivex.schedulers.a.a());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<io2<T>> timestamp(TimeUnit timeUnit) {
        return timestamp(timeUnit, io.reactivex.schedulers.a.a());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> e<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        ObjectHelper.requireNonNull(function2, "valueSelector is null");
        return (e<Map<K, V>>) collect(HashMapSupplier.asCallable(), Functions.toMapKeyValueSelector(function, function2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<d<T>> window(long j, long j2, int i) {
        ObjectHelper.verifyPositive(j, AdUtConstants.XAD_UT_ARG_COUNT);
        ObjectHelper.verifyPositive(j2, MonitorType.SKIP);
        ObjectHelper.verifyPositive(i, "bufferSize");
        return i42.n(new ObservableWindow(this, j, j2, i));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> concat(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i) {
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        return i42.n(new ObservableConcatMap(observableSource, Functions.identity(), i, ErrorMode.IMMEDIATE));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i, boolean z) {
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        ObjectHelper.verifyPositive(i, "prefetch is null");
        return i42.n(new ObservableConcatMap(observableSource, Functions.identity(), i, z ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> merge(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        return i42.n(new ObservableFlatMap(observableSource, Functions.identity(), false, Integer.MAX_VALUE, bufferSize()));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        return i42.n(new ObservableFlatMap(observableSource, Functions.identity(), true, Integer.MAX_VALUE, bufferSize()));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return switchOnNext(observableSource, bufferSize());
    }

    private <U, V> d<T> timeout0(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.requireNonNull(function, "itemTimeoutIndicator is null");
        return i42.n(new ObservableTimeout(this, observableSource, function, observableSource2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> d<R> zip(ObservableSource<? extends ObservableSource<? extends T>> observableSource, Function<? super Object[], ? extends R> function) {
        ObjectHelper.requireNonNull(function, "zipper is null");
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        return i42.n(new ObservableToList(observableSource, 16).flatMap(ObservableInternalHelper.zipIterable(function)));
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        ObservableBlockingSubscribe.subscribe(this, consumer, consumer2, action);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> debounce(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return i42.n(new ObservableDebounceTimed(this, j, timeUnit, scheduler));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final d<T> delay(long j, TimeUnit timeUnit, boolean z) {
        return delay(j, timeUnit, io.reactivex.schedulers.a.a(), z);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> delaySubscription(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delaySubscription(timer(j, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> distinctUntilChanged(BiPredicate<? super T, ? super T> biPredicate) {
        ObjectHelper.requireNonNull(biPredicate, "comparer is null");
        return i42.n(new ObservableDistinctUntilChanged(this, Functions.identity(), biPredicate));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z, int i, int i2) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i, "maxConcurrency");
        ObjectHelper.verifyPositive(i2, "bufferSize");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call == null) {
                return empty();
            }
            return ObservableScalarXMap.scalarXMap(call, function);
        }
        return i42.n(new ObservableFlatMap(this, function, z, i, i2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> d<io.reactivex.observables.a<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z) {
        return groupBy(function, function2, z, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> replay(Function<? super d<T>, ? extends ObservableSource<R>> function, int i) {
        ObjectHelper.requireNonNull(function, "selector is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, i), function);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> retry(long j) {
        return retry(j, Functions.alwaysTrue());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> skip(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return skipUntil(timer(j, timeUnit, scheduler));
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final d<T> skipLast(long j, TimeUnit timeUnit) {
        return skipLast(j, timeUnit, io.reactivex.schedulers.a.c(), false, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> startWith(T t) {
        ObjectHelper.requireNonNull(t, "item is null");
        return concatArray(just(t), this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        return subscribe(consumer, consumer2, action, Functions.emptyConsumer());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> take(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return takeUntil(timer(j, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<io2<T>> timeInterval(TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return i42.n(new ObservableTimeInterval(this, timeUnit, scheduler));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final d<T> timeout(long j, TimeUnit timeUnit) {
        return timeout0(j, timeUnit, null, io.reactivex.schedulers.a.a());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<io2<T>> timestamp(TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return (d<io2<T>>) map(Functions.timestampWith(timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U extends Collection<? super T>> e<U> toList(Callable<U> callable) {
        ObjectHelper.requireNonNull(callable, "collectionSupplier is null");
        return i42.o(new ObservableToListSingle(this, callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<List<T>> toSortedList(Comparator<? super T> comparator, int i) {
        ObjectHelper.requireNonNull(comparator, "comparator is null");
        return (e<List<T>>) toList(i).map(Functions.listSorter(comparator));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, R> d<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, Function3<? super T, ? super T1, ? super T2, R> function3) {
        ObjectHelper.requireNonNull(observableSource, "o1 is null");
        ObjectHelper.requireNonNull(observableSource2, "o2 is null");
        ObjectHelper.requireNonNull(function3, "combiner is null");
        return withLatestFrom(new ObservableSource[]{observableSource, observableSource2}, Functions.toFunction(function3));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> d<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return zip(this, observableSource, biFunction);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> concatEager(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return concatEager(iterable, bufferSize(), bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, S> d<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer) {
        ObjectHelper.requireNonNull(biConsumer, "generator  is null");
        return generate(callable, ObservableInternalHelper.simpleBiGenerator(biConsumer), Functions.emptyConsumer());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static d<Long> interval(long j, TimeUnit timeUnit) {
        return interval(j, j, timeUnit, io.reactivex.schedulers.a.a());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingFirst(T t) {
        BlockingFirstObserver blockingFirstObserver = new BlockingFirstObserver();
        subscribe(blockingFirstObserver);
        T blockingGet = blockingFirstObserver.blockingGet();
        return blockingGet != null ? blockingGet : t;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingLast(T t) {
        BlockingLastObserver blockingLastObserver = new BlockingLastObserver();
        subscribe(blockingLastObserver);
        T blockingGet = blockingLastObserver.blockingGet();
        return blockingGet != null ? blockingGet : t;
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Observer<? super T> observer) {
        ObservableBlockingSubscribe.subscribe(this, observer);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final d<T> concatWith(@NonNull MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "other is null");
        return i42.n(new ObservableConcatWithMaybe(this, maybeSource));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delay(j, timeUnit, scheduler, false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> d<io.reactivex.observables.a<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z, int i) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        ObjectHelper.requireNonNull(function2, "valueSelector is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return i42.n(new ObservableGroupBy(this, function, function2, i, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final d<T> mergeWith(@NonNull MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "other is null");
        return i42.n(new ObservableMergeWithMaybe(this, maybeSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> retry(long j, Predicate<? super Throwable> predicate) {
        if (j >= 0) {
            ObjectHelper.requireNonNull(predicate, "predicate is null");
            return i42.n(new ObservableRetryPredicate(this, j, predicate));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j);
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final d<T> skipLast(long j, TimeUnit timeUnit, boolean z) {
        return skipLast(j, timeUnit, io.reactivex.schedulers.a.c(), z, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Disposable> consumer3) {
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        ObjectHelper.requireNonNull(consumer3, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(consumer, consumer2, action, consumer3);
        subscribe(lambdaObserver);
        return lambdaObserver;
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final d<T> takeLast(long j, long j2, TimeUnit timeUnit) {
        return takeLast(j, j2, timeUnit, io.reactivex.schedulers.a.c(), false, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final d<T> timeout(long j, TimeUnit timeUnit, ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return timeout0(j, timeUnit, observableSource, io.reactivex.schedulers.a.a());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> e<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return toMultimap(function, function2, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> concatEager(Iterable<? extends ObservableSource<? extends T>> iterable, int i, int i2) {
        ObjectHelper.requireNonNull(Integer.valueOf(i), "maxConcurrency is null");
        ObjectHelper.requireNonNull(Integer.valueOf(i2), "prefetch is null");
        return fromIterable(iterable).concatMapEagerDelayError(Functions.identity(), i, i2, false);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static <T> d<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return fromFuture(future, j, timeUnit).subscribeOn(scheduler);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static d<Long> interval(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return interval(j, j, timeUnit, scheduler);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> just(T t, T t2, T t3) {
        ObjectHelper.requireNonNull(t, "The first item is null");
        ObjectHelper.requireNonNull(t2, "The second item is null");
        ObjectHelper.requireNonNull(t3, "The third item is null");
        return fromArray(t, t2, t3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> merge(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i) {
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        ObjectHelper.verifyPositive(i, "maxConcurrency");
        return i42.n(new ObservableFlatMap(observableSource, Functions.identity(), false, i, bufferSize()));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i) {
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        ObjectHelper.verifyPositive(i, "maxConcurrency");
        return i42.n(new ObservableFlatMap(observableSource, Functions.identity(), true, i, bufferSize()));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return i42.n(new ObservableDelay(this, j, timeUnit, scheduler, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> doOnEach(Consumer<? super ul1<T>> consumer) {
        ObjectHelper.requireNonNull(consumer, "consumer is null");
        return doOnEach(Functions.notificationOnNext(consumer), Functions.notificationOnError(consumer), Functions.notificationOnComplete(consumer), Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> sample(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return i42.n(new ObservableSampleTimed(this, j, timeUnit, scheduler, z));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> skipLast(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return skipLast(j, timeUnit, scheduler, false, bufferSize());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> takeLast(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return takeLast(j, j2, timeUnit, scheduler, false, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> e<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, V>> callable) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        ObjectHelper.requireNonNull(function2, "valueSelector is null");
        ObjectHelper.requireNonNull(callable, "mapSupplier is null");
        return (e<Map<K, V>>) collect(callable, Functions.toMapKeyValueSelector(function, function2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final e<List<T>> toSortedList(int i) {
        return toSortedList(Functions.naturalOrder(), i);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> d<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        return zip(this, observableSource, biFunction, z);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> d<R> combineLatest(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function) {
        return combineLatest(observableSourceArr, function, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return concatArray(observableSource, observableSource2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, S> d<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer, Consumer<? super S> consumer) {
        ObjectHelper.requireNonNull(biConsumer, "generator  is null");
        return generate(callable, ObservableInternalHelper.simpleBiGenerator(biConsumer), consumer);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U extends Collection<? super T>> d<U> buffer(int i, Callable<U> callable) {
        return buffer(i, i, callable);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final d<T> concatWith(@NonNull CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "other is null");
        return i42.n(new ObservableConcatWithCompletable(this, completableSource));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final d<T> mergeWith(@NonNull CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "other is null");
        return i42.n(new ObservableMergeWithCompletable(this, completableSource));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final <R> d<R> replay(Function<? super d<T>, ? extends ObservableSource<R>> function, int i, long j, TimeUnit timeUnit) {
        return replay(function, i, j, timeUnit, io.reactivex.schedulers.a.a());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> skipLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return skipLast(j, timeUnit, scheduler, z, bufferSize());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> takeLast(long j, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        if (j >= 0) {
            return i42.n(new ObservableTakeLastTimed(this, j, j2, timeUnit, scheduler, i, z));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + j);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler, ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return timeout0(j, timeUnit, observableSource, scheduler);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final d<d<T>> window(long j, long j2, TimeUnit timeUnit) {
        return window(j, j2, timeUnit, io.reactivex.schedulers.a.a(), bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> d<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i) {
        return zip(this, observableSource, biFunction, z, i);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> d<R> combineLatest(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function, int i) {
        ObjectHelper.requireNonNull(observableSourceArr, "sources is null");
        if (observableSourceArr.length == 0) {
            return empty();
        }
        ObjectHelper.requireNonNull(function, "combiner is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return i42.n(new ObservableCombineLatest(observableSourceArr, null, function, i << 1, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> d<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return combineLatestDelayError(iterable, function, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> e<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, int i) {
        return sequenceEqual(observableSource, observableSource2, ObjectHelper.equalsPredicate(), i);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final d<List<T>> buffer(long j, long j2, TimeUnit timeUnit) {
        return (d<List<T>>) buffer(j, j2, timeUnit, io.reactivex.schedulers.a.a(), ArrayListSupplier.asCallable());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final <R> d<R> replay(Function<? super d<T>, ? extends ObservableSource<R>> function, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(function, "selector is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, i, j, timeUnit, scheduler), function);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> retry(Predicate<? super Throwable> predicate) {
        return retry(AbsPerformance.LONG_NIL, predicate);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> skipLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return i42.n(new ObservableSkipLastTimed(this, j, timeUnit, scheduler, i << 1, z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> e<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, Collection<V>>> callable, Function<? super K, ? extends Collection<? super V>> function3) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        ObjectHelper.requireNonNull(function2, "valueSelector is null");
        ObjectHelper.requireNonNull(callable, "mapSupplier is null");
        ObjectHelper.requireNonNull(function3, "collectionFactory is null");
        return (e<Map<K, Collection<V>>>) collect(callable, Functions.toMultimapKeyValueSelector(function, function2, function3));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<d<T>> window(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return window(j, j2, timeUnit, scheduler, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> d<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        ObjectHelper.requireNonNull(function, "combiner is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return i42.n(new ObservableCombineLatest(null, iterable, function, i << 1, true));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static <T> d<T> fromFuture(Future<? extends T> future, Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return fromFuture(future).subscribeOn(scheduler);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, S> d<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction) {
        return generate(callable, biFunction, Functions.emptyConsumer());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return fromArray(observableSource, observableSource2).flatMap(Functions.identity(), false, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return fromArray(observableSource, observableSource2).flatMap(Functions.identity(), true, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, R> d<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return zipArray(Functions.toFunction(biFunction), false, bufferSize(), observableSource, observableSource2);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<List<T>> buffer(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return (d<List<T>>) buffer(j, j2, timeUnit, scheduler, ArrayListSupplier.asCallable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> d<T> delay(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function) {
        return delaySubscription(observableSource).delay(function);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> d<T> sample(ObservableSource<U> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "sampler is null");
        return i42.n(new ObservableSampleWithObservable(this, observableSource, false));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout0(j, timeUnit, null, scheduler);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<d<T>> window(long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i) {
        ObjectHelper.verifyPositive(j, "timespan");
        ObjectHelper.verifyPositive(j2, "timeskip");
        ObjectHelper.verifyPositive(i, "bufferSize");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        return i42.n(new ObservableWindowTimed(this, j, j2, timeUnit, scheduler, AbsPerformance.LONG_NIL, i, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, R> d<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, ObservableSource<T3> observableSource3, Function4<? super T, ? super T1, ? super T2, ? super T3, R> function4) {
        ObjectHelper.requireNonNull(observableSource, "o1 is null");
        ObjectHelper.requireNonNull(observableSource2, "o2 is null");
        ObjectHelper.requireNonNull(observableSource3, "o3 is null");
        ObjectHelper.requireNonNull(function4, "combiner is null");
        return withLatestFrom(new ObservableSource[]{observableSource, observableSource2, observableSource3}, Functions.toFunction(function4));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        return concatArray(observableSource, observableSource2, observableSource3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, S> d<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        ObjectHelper.requireNonNull(callable, "initialState is null");
        ObjectHelper.requireNonNull(biFunction, "generator  is null");
        ObjectHelper.requireNonNull(consumer, "disposeState is null");
        return i42.n(new ObservableGenerate(callable, biFunction, consumer));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> just(T t, T t2, T t3, T t4) {
        ObjectHelper.requireNonNull(t, "The first item is null");
        ObjectHelper.requireNonNull(t2, "The second item is null");
        ObjectHelper.requireNonNull(t3, "The third item is null");
        ObjectHelper.requireNonNull(t4, "The fourth item is null");
        return fromArray(t, t2, t3, t4);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final <U extends Collection<? super T>> d<U> buffer(long j, long j2, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        return i42.n(new ObservableBufferTimed(this, j, j2, timeUnit, scheduler, callable, Integer.MAX_VALUE, false));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> d<T> timeout(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function) {
        ObjectHelper.requireNonNull(observableSource, "firstTimeoutIndicator is null");
        return timeout0(observableSource, function, null);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final d<T> doOnEach(Observer<? super T> observer) {
        ObjectHelper.requireNonNull(observer, "observer is null");
        return doOnEach(ObservableInternalHelper.observerOnNext(observer), ObservableInternalHelper.observerOnError(observer), ObservableInternalHelper.observerOnComplete(observer), Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> d<T> sample(ObservableSource<U> observableSource, boolean z) {
        ObjectHelper.requireNonNull(observableSource, "sampler is null");
        return i42.n(new ObservableSampleWithObservable(this, observableSource, z));
    }

    @Override // io.reactivex.ObservableSource
    @SchedulerSupport("none")
    public final void subscribe(Observer<? super T> observer) {
        ObjectHelper.requireNonNull(observer, "observer is null");
        try {
            Observer<? super T> z = i42.z(this, observer);
            ObjectHelper.requireNonNull(z, "Plugin returned null Observer");
            subscribeActual(z);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            dg0.b(th);
            i42.u(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        return fromArray(observableSource, observableSource2, observableSource3).flatMap(Functions.identity(), false, 3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        return fromArray(observableSource, observableSource2, observableSource3).flatMap(Functions.identity(), true, 3);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, R> d<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return zipArray(Functions.toFunction(biFunction), z, bufferSize(), observableSource, observableSource2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
        ObjectHelper.requireNonNull(function, "onNextMapper is null");
        ObjectHelper.requireNonNull(function2, "onErrorMapper is null");
        ObjectHelper.requireNonNull(callable, "onCompleteSupplier is null");
        return merge(new ObservableMapNotification(this, function, function2, callable));
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final d<T> takeLast(long j, TimeUnit timeUnit) {
        return takeLast(j, timeUnit, io.reactivex.schedulers.a.c(), false, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> d<T> timeout(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.requireNonNull(observableSource, "firstTimeoutIndicator is null");
        ObjectHelper.requireNonNull(observableSource2, "other is null");
        return timeout0(observableSource, function, observableSource2);
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final d<T> takeLast(long j, TimeUnit timeUnit, boolean z) {
        return takeLast(j, timeUnit, io.reactivex.schedulers.a.c(), z, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> e<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<Map<K, Collection<V>>> callable) {
        return toMultimap(function, function2, callable, ArrayListSupplier.asFunction());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, R> d<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return combineLatest(Functions.toFunction(biFunction), bufferSize(), observableSource, observableSource2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        return concatArray(observableSource, observableSource2, observableSource3, observableSource4);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final d<List<T>> buffer(long j, TimeUnit timeUnit) {
        return buffer(j, timeUnit, io.reactivex.schedulers.a.a(), Integer.MAX_VALUE);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final <R> d<R> replay(Function<? super d<T>, ? extends ObservableSource<R>> function, int i, Scheduler scheduler) {
        ObjectHelper.requireNonNull(function, "selector is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, i), ObservableInternalHelper.replayFunction(function, scheduler));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> takeLast(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return takeLast(j, timeUnit, scheduler, false, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> just(T t, T t2, T t3, T t4, T t5) {
        ObjectHelper.requireNonNull(t, "The first item is null");
        ObjectHelper.requireNonNull(t2, "The second item is null");
        ObjectHelper.requireNonNull(t3, "The third item is null");
        ObjectHelper.requireNonNull(t4, "The fourth item is null");
        ObjectHelper.requireNonNull(t5, "The fifth item is null");
        return fromArray(t, t2, t3, t4, t5);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, R> d<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z, int i) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return zipArray(Functions.toFunction(biFunction), z, i, observableSource, observableSource2);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final d<List<T>> buffer(long j, TimeUnit timeUnit, int i) {
        return buffer(j, timeUnit, io.reactivex.schedulers.a.a(), i);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> takeLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return takeLast(j, timeUnit, scheduler, z, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final d<d<T>> window(long j, TimeUnit timeUnit) {
        return window(j, timeUnit, io.reactivex.schedulers.a.a(), (long) AbsPerformance.LONG_NIL, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, T4, R> d<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, ObservableSource<T3> observableSource3, ObservableSource<T4> observableSource4, Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> function5) {
        ObjectHelper.requireNonNull(observableSource, "o1 is null");
        ObjectHelper.requireNonNull(observableSource2, "o2 is null");
        ObjectHelper.requireNonNull(observableSource3, "o3 is null");
        ObjectHelper.requireNonNull(observableSource4, "o4 is null");
        ObjectHelper.requireNonNull(function5, "combiner is null");
        return withLatestFrom(new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4}, Functions.toFunction(function5));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        return fromArray(observableSource, observableSource2, observableSource3, observableSource4).flatMap(Functions.identity(), false, 4);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        return fromArray(observableSource, observableSource2, observableSource3, observableSource4).flatMap(Functions.identity(), true, 4);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<List<T>> buffer(long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        return (d<List<T>>) buffer(j, timeUnit, scheduler, i, ArrayListSupplier.asCallable(), false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, Function<Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable, int i) {
        ObjectHelper.requireNonNull(function, "onNextMapper is null");
        ObjectHelper.requireNonNull(function2, "onErrorMapper is null");
        ObjectHelper.requireNonNull(callable, "onCompleteSupplier is null");
        return merge(new ObservableMapNotification(this, function, function2, callable), i);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<T> takeLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i) {
        return takeLast(AbsPerformance.LONG_NIL, j, timeUnit, scheduler, z, i);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final d<d<T>> window(long j, TimeUnit timeUnit, long j2) {
        return window(j, timeUnit, io.reactivex.schedulers.a.a(), j2, false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, R> d<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        return combineLatest(Functions.toFunction(function3), bufferSize(), observableSource, observableSource2, observableSource3);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final <U extends Collection<? super T>> d<U> buffer(long j, TimeUnit timeUnit, Scheduler scheduler, int i, Callable<U> callable, boolean z) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        ObjectHelper.verifyPositive(i, AdUtConstants.XAD_UT_ARG_COUNT);
        return i42.n(new ObservableBufferTimed(this, j, j, timeUnit, scheduler, callable, i, z));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final d<d<T>> window(long j, TimeUnit timeUnit, long j2, boolean z) {
        return window(j, timeUnit, io.reactivex.schedulers.a.a(), j2, z);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, R> d<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        return zipArray(Functions.toFunction(function3), false, bufferSize(), observableSource, observableSource2, observableSource3);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<d<T>> window(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return window(j, timeUnit, scheduler, (long) AbsPerformance.LONG_NIL, false);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<d<T>> window(long j, TimeUnit timeUnit, Scheduler scheduler, long j2) {
        return window(j, timeUnit, scheduler, j2, false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i) {
        return flatMap((Function) function, false, i, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final <R> d<R> replay(Function<? super d<T>, ? extends ObservableSource<R>> function, long j, TimeUnit timeUnit) {
        return replay(function, j, timeUnit, io.reactivex.schedulers.a.a());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<d<T>> window(long j, TimeUnit timeUnit, Scheduler scheduler, long j2, boolean z) {
        return window(j, timeUnit, scheduler, j2, z, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, R> d<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        return combineLatest(Functions.toFunction(function4), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> just(T t, T t2, T t3, T t4, T t5, T t6) {
        ObjectHelper.requireNonNull(t, "The first item is null");
        ObjectHelper.requireNonNull(t2, "The second item is null");
        ObjectHelper.requireNonNull(t3, "The third item is null");
        ObjectHelper.requireNonNull(t4, "The fourth item is null");
        ObjectHelper.requireNonNull(t5, "The fifth item is null");
        ObjectHelper.requireNonNull(t6, "The sixth item is null");
        return fromArray(t, t2, t3, t4, t5, t6);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> d<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return flatMap(function, biFunction, false, bufferSize(), bufferSize());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final <R> d<R> replay(Function<? super d<T>, ? extends ObservableSource<R>> function, long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(function, "selector is null");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, j, timeUnit, scheduler), function);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<d<T>> window(long j, TimeUnit timeUnit, Scheduler scheduler, long j2, boolean z, int i) {
        ObjectHelper.verifyPositive(i, "bufferSize");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.verifyPositive(j2, AdUtConstants.XAD_UT_ARG_COUNT);
        return i42.n(new ObservableWindowTimed(this, j, j, timeUnit, scheduler, j2, i, z));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, R> d<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        return zipArray(Functions.toFunction(function4), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final d<List<T>> buffer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return (d<List<T>>) buffer(j, timeUnit, scheduler, Integer.MAX_VALUE, ArrayListSupplier.asCallable(), false);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> d<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        return flatMap(function, biFunction, z, bufferSize(), bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> withLatestFrom(ObservableSource<?>[] observableSourceArr, Function<? super Object[], R> function) {
        ObjectHelper.requireNonNull(observableSourceArr, "others is null");
        ObjectHelper.requireNonNull(function, "combiner is null");
        return i42.n(new ObservableWithLatestFromMany(this, observableSourceArr, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <TOpening, TClosing> d<List<T>> buffer(ObservableSource<? extends TOpening> observableSource, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> function) {
        return (d<List<T>>) buffer(observableSource, function, ArrayListSupplier.asCallable());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> d<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i) {
        return flatMap(function, biFunction, z, i, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <TOpening, TClosing, U extends Collection<? super T>> d<U> buffer(ObservableSource<? extends TOpening> observableSource, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> function, Callable<U> callable) {
        ObjectHelper.requireNonNull(observableSource, "openingIndicator is null");
        ObjectHelper.requireNonNull(function, "closingIndicator is null");
        ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        return i42.n(new ObservableBufferBoundary(this, observableSource, function, callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> d<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i, int i2) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.requireNonNull(biFunction, "combiner is null");
        return flatMap(ObservableInternalHelper.flatMapWithCombiner(function, biFunction), z, i, i2);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final <R> d<R> replay(Function<? super d<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
        ObjectHelper.requireNonNull(function, "selector is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this), ObservableInternalHelper.replayFunction(function, scheduler));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> d<R> withLatestFrom(Iterable<? extends ObservableSource<?>> iterable, Function<? super Object[], R> function) {
        ObjectHelper.requireNonNull(iterable, "others is null");
        ObjectHelper.requireNonNull(function, "combiner is null");
        return i42.n(new ObservableWithLatestFromMany(this, iterable, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, R> d<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        return combineLatest(Functions.toFunction(function5), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> d<d<T>> window(ObservableSource<B> observableSource) {
        return window(observableSource, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, R> d<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        return zipArray(Functions.toFunction(function5), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> d<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, int i) {
        return flatMap(function, biFunction, false, i, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> d<d<T>> window(ObservableSource<B> observableSource, int i) {
        ObjectHelper.requireNonNull(observableSource, "boundary is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return i42.n(new ObservableWindowBoundary(this, observableSource, i));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        ObjectHelper.requireNonNull(t, "The first item is null");
        ObjectHelper.requireNonNull(t2, "The second item is null");
        ObjectHelper.requireNonNull(t3, "The third item is null");
        ObjectHelper.requireNonNull(t4, "The fourth item is null");
        ObjectHelper.requireNonNull(t5, "The fifth item is null");
        ObjectHelper.requireNonNull(t6, "The sixth item is null");
        ObjectHelper.requireNonNull(t7, "The seventh item is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> d<List<T>> buffer(ObservableSource<B> observableSource) {
        return (d<List<T>>) buffer(observableSource, ArrayListSupplier.asCallable());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> d<List<T>> buffer(ObservableSource<B> observableSource, int i) {
        ObjectHelper.verifyPositive(i, "initialCapacity");
        return (d<List<T>>) buffer(observableSource, Functions.createArrayList(i));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final bn<T> replay(int i) {
        ObjectHelper.verifyPositive(i, "bufferSize");
        return ObservableReplay.create(this, i);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> d<d<T>> window(ObservableSource<U> observableSource, Function<? super U, ? extends ObservableSource<V>> function) {
        return window(observableSource, function, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B, U extends Collection<? super T>> d<U> buffer(ObservableSource<B> observableSource, Callable<U> callable) {
        ObjectHelper.requireNonNull(observableSource, "boundary is null");
        ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        return i42.n(new ObservableBufferExactBoundary(this, observableSource, callable));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> d<d<T>> window(ObservableSource<U> observableSource, Function<? super U, ? extends ObservableSource<V>> function, int i) {
        ObjectHelper.requireNonNull(observableSource, "openingIndicator is null");
        ObjectHelper.requireNonNull(function, "closingIndicator is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return i42.n(new ObservableWindowBoundarySelector(this, observableSource, function, i));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, R> d<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        return combineLatest(Functions.toFunction(function6), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final bn<T> replay(int i, long j, TimeUnit timeUnit) {
        return replay(i, j, timeUnit, io.reactivex.schedulers.a.a());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, R> d<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        return zipArray(Functions.toFunction(function6), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final bn<T> replay(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.verifyPositive(i, "bufferSize");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.create(this, j, timeUnit, scheduler, i);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> d<List<T>> buffer(Callable<? extends ObservableSource<B>> callable) {
        return (d<List<T>>) buffer(callable, ArrayListSupplier.asCallable());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B, U extends Collection<? super T>> d<U> buffer(Callable<? extends ObservableSource<B>> callable, Callable<U> callable2) {
        ObjectHelper.requireNonNull(callable, "boundarySupplier is null");
        ObjectHelper.requireNonNull(callable2, "bufferSupplier is null");
        return i42.n(new ObservableBufferBoundarySupplier(this, callable, callable2));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> d<d<T>> window(Callable<? extends ObservableSource<B>> callable) {
        return window(callable, bufferSize());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        ObjectHelper.requireNonNull(t, "The first item is null");
        ObjectHelper.requireNonNull(t2, "The second item is null");
        ObjectHelper.requireNonNull(t3, "The third item is null");
        ObjectHelper.requireNonNull(t4, "The fourth item is null");
        ObjectHelper.requireNonNull(t5, "The fifth item is null");
        ObjectHelper.requireNonNull(t6, "The sixth item is null");
        ObjectHelper.requireNonNull(t7, "The seventh item is null");
        ObjectHelper.requireNonNull(t8, "The eighth item is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> d<d<T>> window(Callable<? extends ObservableSource<B>> callable, int i) {
        ObjectHelper.requireNonNull(callable, "boundary is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return i42.n(new ObservableWindowBoundarySupplier(this, callable, i));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final bn<T> replay(int i, Scheduler scheduler) {
        ObjectHelper.verifyPositive(i, "bufferSize");
        return ObservableReplay.observeOn(replay(i), scheduler);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, R> d<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        ObjectHelper.requireNonNull(observableSource7, "source7 is null");
        return combineLatest(Functions.toFunction(function7), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final bn<T> replay(long j, TimeUnit timeUnit) {
        return replay(j, timeUnit, io.reactivex.schedulers.a.a());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, R> d<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        ObjectHelper.requireNonNull(observableSource7, "source7 is null");
        return zipArray(Functions.toFunction(function7), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final bn<T> replay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.create(this, j, timeUnit, scheduler);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final bn<T> replay(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.observeOn(replay(), scheduler);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        ObjectHelper.requireNonNull(t, "The first item is null");
        ObjectHelper.requireNonNull(t2, "The second item is null");
        ObjectHelper.requireNonNull(t3, "The third item is null");
        ObjectHelper.requireNonNull(t4, "The fourth item is null");
        ObjectHelper.requireNonNull(t5, "The fifth item is null");
        ObjectHelper.requireNonNull(t6, "The sixth item is null");
        ObjectHelper.requireNonNull(t7, "The seventh item is null");
        ObjectHelper.requireNonNull(t8, "The eighth item is null");
        ObjectHelper.requireNonNull(t9, "The ninth item is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> d<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        ObjectHelper.requireNonNull(observableSource7, "source7 is null");
        ObjectHelper.requireNonNull(observableSource8, "source8 is null");
        return combineLatest(Functions.toFunction(function8), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> d<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        ObjectHelper.requireNonNull(observableSource7, "source7 is null");
        ObjectHelper.requireNonNull(observableSource8, "source8 is null");
        return zipArray(Functions.toFunction(function8), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> d<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        ObjectHelper.requireNonNull(t, "The first item is null");
        ObjectHelper.requireNonNull(t2, "The second item is null");
        ObjectHelper.requireNonNull(t3, "The third item is null");
        ObjectHelper.requireNonNull(t4, "The fourth item is null");
        ObjectHelper.requireNonNull(t5, "The fifth item is null");
        ObjectHelper.requireNonNull(t6, "The sixth item is null");
        ObjectHelper.requireNonNull(t7, "The seventh item is null");
        ObjectHelper.requireNonNull(t8, "The eighth item is null");
        ObjectHelper.requireNonNull(t9, "The ninth item is null");
        ObjectHelper.requireNonNull(t10, "The tenth item is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9, t10);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> d<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, ObservableSource<? extends T9> observableSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        ObjectHelper.requireNonNull(observableSource7, "source7 is null");
        ObjectHelper.requireNonNull(observableSource8, "source8 is null");
        ObjectHelper.requireNonNull(observableSource9, "source9 is null");
        return combineLatest(Functions.toFunction(function9), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> d<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, ObservableSource<? extends T9> observableSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        ObjectHelper.requireNonNull(observableSource7, "source7 is null");
        ObjectHelper.requireNonNull(observableSource8, "source8 is null");
        ObjectHelper.requireNonNull(observableSource9, "source9 is null");
        return zipArray(Functions.toFunction(function9), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9);
    }
}
