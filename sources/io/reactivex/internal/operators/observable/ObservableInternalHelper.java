package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC8149d;
import io.reactivex.Emitter;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.SingleSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleToObservable;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import tb.bn;
import tb.i42;
import tb.ul1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ObservableInternalHelper {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class BufferedReplayCallable<T> implements Callable<bn<T>> {
        private final int bufferSize;
        private final AbstractC8149d<T> parent;

        BufferedReplayCallable(AbstractC8149d<T> abstractC8149d, int i) {
            this.parent = abstractC8149d;
            this.bufferSize = i;
        }

        @Override // java.util.concurrent.Callable
        public bn<T> call() {
            return this.parent.replay(this.bufferSize);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class BufferedTimedReplayCallable<T> implements Callable<bn<T>> {
        private final int bufferSize;
        private final AbstractC8149d<T> parent;
        private final Scheduler scheduler;
        private final long time;
        private final TimeUnit unit;

        BufferedTimedReplayCallable(AbstractC8149d<T> abstractC8149d, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.parent = abstractC8149d;
            this.bufferSize = i;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        @Override // java.util.concurrent.Callable
        public bn<T> call() {
            return this.parent.replay(this.bufferSize, this.time, this.unit, this.scheduler);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum ErrorMapperFilter implements Function<ul1<Object>, Throwable>, Predicate<ul1<Object>> {
        INSTANCE;

        @Override // io.reactivex.functions.Function
        public Throwable apply(ul1<Object> ul1Var) throws Exception {
            return ul1Var.d();
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(ul1<Object> ul1Var) throws Exception {
            return ul1Var.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class FlatMapIntoIterable<T, U> implements Function<T, ObservableSource<U>> {
        private final Function<? super T, ? extends Iterable<? extends U>> mapper;

        FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.mapper = function;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((FlatMapIntoIterable<T, U>) obj);
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource<U> apply(T t) throws Exception {
            return new ObservableFromIterable((Iterable) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null Iterable"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;
        private final T t;

        FlatMapWithCombinerInner(BiFunction<? super T, ? super U, ? extends R> biFunction, T t) {
            this.combiner = biFunction;
            this.t = t;
        }

        @Override // io.reactivex.functions.Function
        public R apply(U u) throws Exception {
            return this.combiner.apply((T) this.t, u);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, ObservableSource<R>> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;
        private final Function<? super T, ? extends ObservableSource<? extends U>> mapper;

        FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends ObservableSource<? extends U>> function) {
            this.combiner = biFunction;
            this.mapper = function;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((FlatMapWithCombinerOuter<T, R, U>) obj);
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource<R> apply(T t) throws Exception {
            return new ObservableMap((ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null ObservableSource"), new FlatMapWithCombinerInner(this.combiner, t));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class ItemDelayFunction<T, U> implements Function<T, ObservableSource<T>> {
        final Function<? super T, ? extends ObservableSource<U>> itemDelay;

        ItemDelayFunction(Function<? super T, ? extends ObservableSource<U>> function) {
            this.itemDelay = function;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((ItemDelayFunction<T, U>) obj);
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource<T> apply(T t) throws Exception {
            return new ObservableTake((ObservableSource) ObjectHelper.requireNonNull(this.itemDelay.apply(t), "The itemDelay returned a null ObservableSource"), 1L).map(Functions.justFunction(t)).defaultIfEmpty(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum MapToInt implements Function<Object, Object> {
        INSTANCE;

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) throws Exception {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class ObservableMapper<T, R> implements Function<T, AbstractC8149d<R>> {
        final Function<? super T, ? extends SingleSource<? extends R>> mapper;

        ObservableMapper(Function<? super T, ? extends SingleSource<? extends R>> function) {
            this.mapper = function;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((ObservableMapper<T, R>) obj);
        }

        @Override // io.reactivex.functions.Function
        public AbstractC8149d<R> apply(T t) throws Exception {
            return i42.n(new SingleToObservable((SingleSource) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null SingleSource")));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class ObserverOnComplete<T> implements Action {
        final Observer<T> observer;

        ObserverOnComplete(Observer<T> observer) {
            this.observer = observer;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            this.observer.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class ObserverOnError<T> implements Consumer<Throwable> {
        final Observer<T> observer;

        ObserverOnError(Observer<T> observer) {
            this.observer = observer;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) throws Exception {
            this.observer.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class ObserverOnNext<T> implements Consumer<T> {
        final Observer<T> observer;

        ObserverOnNext(Observer<T> observer) {
            this.observer = observer;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(T t) throws Exception {
            this.observer.onNext(t);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class RepeatWhenOuterHandler implements Function<AbstractC8149d<ul1<Object>>, ObservableSource<?>> {
        private final Function<? super AbstractC8149d<Object>, ? extends ObservableSource<?>> handler;

        RepeatWhenOuterHandler(Function<? super AbstractC8149d<Object>, ? extends ObservableSource<?>> function) {
            this.handler = function;
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource<?> apply(AbstractC8149d<ul1<Object>> abstractC8149d) throws Exception {
            return this.handler.apply(abstractC8149d.map(MapToInt.INSTANCE));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class ReplayCallable<T> implements Callable<bn<T>> {
        private final AbstractC8149d<T> parent;

        ReplayCallable(AbstractC8149d<T> abstractC8149d) {
            this.parent = abstractC8149d;
        }

        @Override // java.util.concurrent.Callable
        public bn<T> call() {
            return this.parent.replay();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class ReplayFunction<T, R> implements Function<AbstractC8149d<T>, ObservableSource<R>> {
        private final Scheduler scheduler;
        private final Function<? super AbstractC8149d<T>, ? extends ObservableSource<R>> selector;

        ReplayFunction(Function<? super AbstractC8149d<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
            this.selector = function;
            this.scheduler = scheduler;
        }

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((AbstractC8149d) ((AbstractC8149d) obj));
        }

        public ObservableSource<R> apply(AbstractC8149d<T> abstractC8149d) throws Exception {
            return AbstractC8149d.wrap((ObservableSource) ObjectHelper.requireNonNull(this.selector.apply(abstractC8149d), "The selector returned a null ObservableSource")).observeOn(this.scheduler);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class RetryWhenInner implements Function<AbstractC8149d<ul1<Object>>, ObservableSource<?>> {
        private final Function<? super AbstractC8149d<Throwable>, ? extends ObservableSource<?>> handler;

        RetryWhenInner(Function<? super AbstractC8149d<Throwable>, ? extends ObservableSource<?>> function) {
            this.handler = function;
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource<?> apply(AbstractC8149d<ul1<Object>> abstractC8149d) throws Exception {
            ErrorMapperFilter errorMapperFilter = ErrorMapperFilter.INSTANCE;
            return this.handler.apply(abstractC8149d.takeWhile(errorMapperFilter).map(errorMapperFilter));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class SimpleBiGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        final BiConsumer<S, Emitter<T>> consumer;

        SimpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
            this.consumer = biConsumer;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.BiFunction
        public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            return apply((SimpleBiGenerator<T, S>) obj, (Emitter) ((Emitter) obj2));
        }

        public S apply(S s, Emitter<T> emitter) throws Exception {
            this.consumer.accept(s, emitter);
            return s;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class SimpleGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        final Consumer<Emitter<T>> consumer;

        SimpleGenerator(Consumer<Emitter<T>> consumer) {
            this.consumer = consumer;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.BiFunction
        public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            return apply((SimpleGenerator<T, S>) obj, (Emitter) ((Emitter) obj2));
        }

        public S apply(S s, Emitter<T> emitter) throws Exception {
            this.consumer.accept(emitter);
            return s;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class TimedReplayCallable<T> implements Callable<bn<T>> {
        private final AbstractC8149d<T> parent;
        private final Scheduler scheduler;
        private final long time;
        private final TimeUnit unit;

        TimedReplayCallable(AbstractC8149d<T> abstractC8149d, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.parent = abstractC8149d;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        @Override // java.util.concurrent.Callable
        public bn<T> call() {
            return this.parent.replay(this.time, this.unit, this.scheduler);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class ZipIterableFunction<T, R> implements Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> {
        private final Function<? super Object[], ? extends R> zipper;

        ZipIterableFunction(Function<? super Object[], ? extends R> function) {
            this.zipper = function;
        }

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((List) ((List) obj));
        }

        public ObservableSource<? extends R> apply(List<ObservableSource<? extends T>> list) {
            return AbstractC8149d.zipIterable(list, this.zipper, false, AbstractC8149d.bufferSize());
        }
    }

    private ObservableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    private static <T, R> Function<T, AbstractC8149d<R>> convertSingleMapperToObservableMapper(Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return new ObservableMapper(function);
    }

    public static <T, U> Function<T, ObservableSource<U>> flatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new FlatMapIntoIterable(function);
    }

    public static <T, U, R> Function<T, ObservableSource<R>> flatMapWithCombiner(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new FlatMapWithCombinerOuter(biFunction, function);
    }

    public static <T, U> Function<T, ObservableSource<T>> itemDelay(Function<? super T, ? extends ObservableSource<U>> function) {
        return new ItemDelayFunction(function);
    }

    public static <T> Action observerOnComplete(Observer<T> observer) {
        return new ObserverOnComplete(observer);
    }

    public static <T> Consumer<Throwable> observerOnError(Observer<T> observer) {
        return new ObserverOnError(observer);
    }

    public static <T> Consumer<T> observerOnNext(Observer<T> observer) {
        return new ObserverOnNext(observer);
    }

    public static Function<AbstractC8149d<ul1<Object>>, ObservableSource<?>> repeatWhenHandler(Function<? super AbstractC8149d<Object>, ? extends ObservableSource<?>> function) {
        return new RepeatWhenOuterHandler(function);
    }

    public static <T> Callable<bn<T>> replayCallable(AbstractC8149d<T> abstractC8149d) {
        return new ReplayCallable(abstractC8149d);
    }

    public static <T, R> Function<AbstractC8149d<T>, ObservableSource<R>> replayFunction(Function<? super AbstractC8149d<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
        return new ReplayFunction(function, scheduler);
    }

    public static <T> Function<AbstractC8149d<ul1<Object>>, ObservableSource<?>> retryWhenHandler(Function<? super AbstractC8149d<Throwable>, ? extends ObservableSource<?>> function) {
        return new RetryWhenInner(function);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
        return new SimpleBiGenerator(biConsumer);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleGenerator(Consumer<Emitter<T>> consumer) {
        return new SimpleGenerator(consumer);
    }

    public static <T, R> AbstractC8149d<R> switchMapSingle(AbstractC8149d<T> abstractC8149d, Function<? super T, ? extends SingleSource<? extends R>> function) {
        return abstractC8149d.switchMap(convertSingleMapperToObservableMapper(function), 1);
    }

    public static <T, R> AbstractC8149d<R> switchMapSingleDelayError(AbstractC8149d<T> abstractC8149d, Function<? super T, ? extends SingleSource<? extends R>> function) {
        return abstractC8149d.switchMapDelayError(convertSingleMapperToObservableMapper(function), 1);
    }

    public static <T, R> Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> zipIterable(Function<? super Object[], ? extends R> function) {
        return new ZipIterableFunction(function);
    }

    public static <T> Callable<bn<T>> replayCallable(AbstractC8149d<T> abstractC8149d, int i) {
        return new BufferedReplayCallable(abstractC8149d, i);
    }

    public static <T> Callable<bn<T>> replayCallable(AbstractC8149d<T> abstractC8149d, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new BufferedTimedReplayCallable(abstractC8149d, i, j, timeUnit, scheduler);
    }

    public static <T> Callable<bn<T>> replayCallable(AbstractC8149d<T> abstractC8149d, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new TimedReplayCallable(abstractC8149d, j, timeUnit, scheduler);
    }
}
