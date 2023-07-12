package io.reactivex.internal.disposables;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.NotificationLite;
import tb.i42;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ObserverFullArbiter<T> extends FullArbiterPad1 implements Disposable {
    final Observer<? super T> actual;
    volatile boolean cancelled;
    final SpscLinkedArrayQueue<Object> queue;
    Disposable resource;
    volatile Disposable s = EmptyDisposable.INSTANCE;

    public ObserverFullArbiter(Observer<? super T> observer, Disposable disposable, int i) {
        this.actual = observer;
        this.resource = disposable;
        this.queue = new SpscLinkedArrayQueue<>(i);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        disposeResource();
    }

    void disposeResource() {
        Disposable disposable = this.resource;
        this.resource = null;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    void drain() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
        Observer<? super T> observer = this.actual;
        int i = 1;
        while (true) {
            Object poll = spscLinkedArrayQueue.poll();
            if (poll == null) {
                i = this.wip.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                Object poll2 = spscLinkedArrayQueue.poll();
                if (poll == this.s) {
                    if (NotificationLite.isDisposable(poll2)) {
                        Disposable disposable = NotificationLite.getDisposable(poll2);
                        this.s.dispose();
                        if (!this.cancelled) {
                            this.s = disposable;
                        } else {
                            disposable.dispose();
                        }
                    } else if (NotificationLite.isError(poll2)) {
                        spscLinkedArrayQueue.clear();
                        disposeResource();
                        Throwable error = NotificationLite.getError(poll2);
                        if (!this.cancelled) {
                            this.cancelled = true;
                            observer.onError(error);
                        } else {
                            i42.u(error);
                        }
                    } else if (NotificationLite.isComplete(poll2)) {
                        spscLinkedArrayQueue.clear();
                        disposeResource();
                        if (!this.cancelled) {
                            this.cancelled = true;
                            observer.onComplete();
                        }
                    } else {
                        observer.onNext((Object) NotificationLite.getValue(poll2));
                    }
                }
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        Disposable disposable = this.resource;
        return disposable != null ? disposable.isDisposed() : this.cancelled;
    }

    public void onComplete(Disposable disposable) {
        this.queue.offer(disposable, NotificationLite.complete());
        drain();
    }

    public void onError(Throwable th, Disposable disposable) {
        if (this.cancelled) {
            i42.u(th);
            return;
        }
        this.queue.offer(disposable, NotificationLite.error(th));
        drain();
    }

    public boolean onNext(T t, Disposable disposable) {
        if (this.cancelled) {
            return false;
        }
        this.queue.offer(disposable, NotificationLite.next(t));
        drain();
        return true;
    }

    public boolean setDisposable(Disposable disposable) {
        if (this.cancelled) {
            return false;
        }
        this.queue.offer(this.s, NotificationLite.disposable(disposable));
        drain();
        return true;
    }
}
