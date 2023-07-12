package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.i32;
import tb.n40;
import tb.pa2;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class c<T> extends pa2<T> implements Iterator<T>, Continuation<wt2>, KMappedMarker {
    private int a;
    @Nullable
    private T b;
    @Nullable
    private Iterator<? extends T> c;
    @Nullable
    private Continuation<? super wt2> d;

    private final Throwable d() {
        int i = this.a;
        if (i != 4) {
            if (i != 5) {
                return new IllegalStateException("Unexpected state of the iterator: " + this.a);
            }
            return new IllegalStateException("Iterator has failed.");
        }
        return new NoSuchElementException();
    }

    private final T e() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // tb.pa2
    @Nullable
    public Object a(T t, @NotNull Continuation<? super wt2> continuation) {
        Object d;
        Object d2;
        Object d3;
        this.b = t;
        this.a = 3;
        this.d = continuation;
        d = kotlin.coroutines.intrinsics.b.d();
        d2 = kotlin.coroutines.intrinsics.b.d();
        if (d == d2) {
            n40.c(continuation);
        }
        d3 = kotlin.coroutines.intrinsics.b.d();
        return d == d3 ? d : wt2.INSTANCE;
    }

    @Override // tb.pa2
    @Nullable
    public Object b(@NotNull Iterator<? extends T> it, @NotNull Continuation<? super wt2> continuation) {
        Object d;
        Object d2;
        Object d3;
        if (it.hasNext()) {
            this.c = it;
            this.a = 2;
            this.d = continuation;
            d = kotlin.coroutines.intrinsics.b.d();
            d2 = kotlin.coroutines.intrinsics.b.d();
            if (d == d2) {
                n40.c(continuation);
            }
            d3 = kotlin.coroutines.intrinsics.b.d();
            return d == d3 ? d : wt2.INSTANCE;
        }
        return wt2.INSTANCE;
    }

    public final void f(@Nullable Continuation<? super wt2> continuation) {
        this.d = continuation;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw d();
                }
                Iterator<? extends T> it = this.c;
                b41.f(it);
                if (it.hasNext()) {
                    this.a = 2;
                    return true;
                }
                this.c = null;
            }
            this.a = 5;
            Continuation<? super wt2> continuation = this.d;
            b41.f(continuation);
            this.d = null;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m1271constructorimpl(wt2.INSTANCE));
        }
    }

    @Override // java.util.Iterator
    public T next() {
        int i = this.a;
        if (i == 0 || i == 1) {
            return e();
        }
        if (i == 2) {
            this.a = 1;
            Iterator<? extends T> it = this.c;
            b41.f(it);
            return it.next();
        } else if (i == 3) {
            this.a = 0;
            T t = this.b;
            this.b = null;
            return t;
        } else {
            throw d();
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
        i32.b(obj);
        this.a = 4;
    }
}
