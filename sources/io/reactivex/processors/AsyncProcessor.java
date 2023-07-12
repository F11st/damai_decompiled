package io.reactivex.processors;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;
import tb.i42;
import tb.mn0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class AsyncProcessor<T> extends mn0<T> {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class AsyncSubscription<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncProcessor<T> parent;

        AsyncSubscription(Subscriber<? super T> subscriber, AsyncProcessor<T> asyncProcessor) {
            super(subscriber);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            if (super.tryCancel()) {
                throw null;
            }
        }

        void onComplete() {
            if (isCancelled()) {
                return;
            }
            this.actual.onComplete();
        }

        void onError(Throwable th) {
            if (isCancelled()) {
                i42.u(th);
            } else {
                this.actual.onError(th);
            }
        }
    }
}
