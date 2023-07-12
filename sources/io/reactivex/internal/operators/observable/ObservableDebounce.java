package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import tb.dg0;
import tb.i42;
import tb.ra2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ObservableDebounce<T, U> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super T, ? extends ObservableSource<U>> debounceSelector;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class DebounceObserver<T, U> implements Observer<T>, Disposable {
        final Observer<? super T> actual;
        final Function<? super T, ? extends ObservableSource<U>> debounceSelector;
        final AtomicReference<Disposable> debouncer = new AtomicReference<>();
        boolean done;
        volatile long index;
        Disposable s;

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        static final class DebounceInnerObserver<T, U> extends b<U> {
            boolean done;
            final long index;
            final AtomicBoolean once = new AtomicBoolean();
            final DebounceObserver<T, U> parent;
            final T value;

            DebounceInnerObserver(DebounceObserver<T, U> debounceObserver, long j, T t) {
                this.parent = debounceObserver;
                this.index = j;
                this.value = t;
            }

            void emit() {
                if (this.once.compareAndSet(false, true)) {
                    this.parent.emit(this.index, this.value);
                }
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                if (this.done) {
                    return;
                }
                this.done = true;
                emit();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                if (this.done) {
                    i42.u(th);
                    return;
                }
                this.done = true;
                this.parent.onError(th);
            }

            @Override // io.reactivex.Observer
            public void onNext(U u) {
                if (this.done) {
                    return;
                }
                this.done = true;
                dispose();
                emit();
            }
        }

        DebounceObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<U>> function) {
            this.actual = observer;
            this.debounceSelector = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.s.dispose();
            DisposableHelper.dispose(this.debouncer);
        }

        void emit(long j, T t) {
            if (j == this.index) {
                this.actual.onNext(t);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            Disposable disposable = this.debouncer.get();
            if (disposable != DisposableHelper.DISPOSED) {
                ((DebounceInnerObserver) disposable).emit();
                DisposableHelper.dispose(this.debouncer);
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.debouncer);
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j = this.index + 1;
            this.index = j;
            Disposable disposable = this.debouncer.get();
            if (disposable != null) {
                disposable.dispose();
            }
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.debounceSelector.apply(t), "The ObservableSource supplied is null");
                DebounceInnerObserver debounceInnerObserver = new DebounceInnerObserver(this, j, t);
                if (this.debouncer.compareAndSet(disposable, debounceInnerObserver)) {
                    observableSource.subscribe(debounceInnerObserver);
                }
            } catch (Throwable th) {
                dg0.b(th);
                dispose();
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableDebounce(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<U>> function) {
        super(observableSource);
        this.debounceSelector = function;
    }

    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DebounceObserver(new ra2(observer), this.debounceSelector));
    }
}
