package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class b<T> implements Sequence<T> {
    @NotNull
    private final Function0<T> a;
    @NotNull
    private final Function1<T, T> b;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a implements Iterator<T>, KMappedMarker {
        @Nullable
        private T a;
        private int b = -2;
        final /* synthetic */ b<T> c;

        a(b<T> bVar) {
            this.c = bVar;
        }

        private final void a() {
            T t;
            if (this.b == -2) {
                t = (T) ((b) this.c).a.invoke();
            } else {
                Function1 function1 = ((b) this.c).b;
                T t2 = this.a;
                b41.f(t2);
                t = (T) function1.invoke(t2);
            }
            this.a = t;
            this.b = t == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b < 0) {
                a();
            }
            return this.b == 1;
        }

        @Override // java.util.Iterator
        @NotNull
        public T next() {
            if (this.b < 0) {
                a();
            }
            if (this.b != 0) {
                T t = this.a;
                b41.g(t, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
                this.b = -1;
                return t;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull Function0<? extends T> function0, @NotNull Function1<? super T, ? extends T> function1) {
        b41.i(function0, "getInitialValue");
        b41.i(function1, "getNextValue");
        this.a = function0;
        this.b = function1;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }
}
