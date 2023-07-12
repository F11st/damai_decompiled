package tb;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class zj0<T, R, E> implements Sequence<E> {
    @NotNull
    private final Sequence<T> a;
    @NotNull
    private final Function1<T, R> b;
    @NotNull
    private final Function1<R, Iterator<E>> c;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a implements Iterator<E>, KMappedMarker {
        @NotNull
        private final Iterator<T> a;
        @Nullable
        private Iterator<? extends E> b;
        final /* synthetic */ zj0<T, R, E> c;

        a(zj0<T, R, E> zj0Var) {
            this.c = zj0Var;
            this.a = ((zj0) zj0Var).a.iterator();
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
            return true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final boolean a() {
            /*
                r5 = this;
                java.util.Iterator<? extends E> r0 = r5.b
                r1 = 1
                r2 = 0
                if (r0 == 0) goto Le
                boolean r0 = r0.hasNext()
                if (r0 != 0) goto Le
                r0 = 1
                goto Lf
            Le:
                r0 = 0
            Lf:
                if (r0 == 0) goto L14
                r0 = 0
                r5.b = r0
            L14:
                java.util.Iterator<? extends E> r0 = r5.b
                if (r0 != 0) goto L45
                java.util.Iterator<T> r0 = r5.a
                boolean r0 = r0.hasNext()
                if (r0 != 0) goto L21
                return r2
            L21:
                java.util.Iterator<T> r0 = r5.a
                java.lang.Object r0 = r0.next()
                tb.zj0<T, R, E> r3 = r5.c
                kotlin.jvm.functions.Function1 r3 = tb.zj0.a(r3)
                tb.zj0<T, R, E> r4 = r5.c
                kotlin.jvm.functions.Function1 r4 = tb.zj0.c(r4)
                java.lang.Object r0 = r4.invoke(r0)
                java.lang.Object r0 = r3.invoke(r0)
                java.util.Iterator r0 = (java.util.Iterator) r0
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L14
                r5.b = r0
            L45:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.zj0.a.a():boolean");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return a();
        }

        @Override // java.util.Iterator
        public E next() {
            if (a()) {
                Iterator<? extends E> it = this.b;
                b41.f(it);
                return it.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public zj0(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1, @NotNull Function1<? super R, ? extends Iterator<? extends E>> function12) {
        b41.i(sequence, "sequence");
        b41.i(function1, "transformer");
        b41.i(function12, "iterator");
        this.a = sequence;
        this.b = function1;
        this.c = function12;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<E> iterator() {
        return new a(this);
    }
}
