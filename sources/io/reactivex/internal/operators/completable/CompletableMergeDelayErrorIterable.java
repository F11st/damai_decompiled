package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.a;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableMergeDelayErrorArray;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import tb.dg0;
import tb.jm;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class CompletableMergeDelayErrorIterable extends a {
    final Iterable<? extends CompletableSource> sources;

    public CompletableMergeDelayErrorIterable(Iterable<? extends CompletableSource> iterable) {
        this.sources = iterable;
    }

    @Override // io.reactivex.a
    public void subscribeActual(CompletableObserver completableObserver) {
        jm jmVar = new jm();
        completableObserver.onSubscribe(jmVar);
        try {
            Iterator it = (Iterator) ObjectHelper.requireNonNull(this.sources.iterator(), "The source iterator returned is null");
            AtomicInteger atomicInteger = new AtomicInteger(1);
            AtomicThrowable atomicThrowable = new AtomicThrowable();
            while (!jmVar.isDisposed()) {
                try {
                    if (it.hasNext()) {
                        if (jmVar.isDisposed()) {
                            return;
                        }
                        try {
                            CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(it.next(), "The iterator returned a null CompletableSource");
                            if (jmVar.isDisposed()) {
                                return;
                            }
                            atomicInteger.getAndIncrement();
                            completableSource.subscribe(new CompletableMergeDelayErrorArray.MergeInnerCompletableObserver(completableObserver, jmVar, atomicThrowable, atomicInteger));
                        } catch (Throwable th) {
                            dg0.b(th);
                            atomicThrowable.addThrowable(th);
                        }
                    }
                } catch (Throwable th2) {
                    dg0.b(th2);
                    atomicThrowable.addThrowable(th2);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    Throwable terminate = atomicThrowable.terminate();
                    if (terminate == null) {
                        completableObserver.onComplete();
                        return;
                    } else {
                        completableObserver.onError(terminate);
                        return;
                    }
                }
                return;
            }
        } catch (Throwable th3) {
            dg0.b(th3);
            completableObserver.onError(th3);
        }
    }
}
