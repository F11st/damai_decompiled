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
public final class xk2<T> implements Sequence<T> {
    @NotNull
    private final Sequence<T> a;
    @NotNull
    private final Function1<T, Boolean> b;

    /* compiled from: Taobao */
    /* renamed from: tb.xk2$a */
    /* loaded from: classes3.dex */
    public static final class C9932a implements Iterator<T>, KMappedMarker {
        @NotNull
        private final Iterator<T> a;
        private int b = -1;
        @Nullable
        private T c;
        final /* synthetic */ xk2<T> d;

        C9932a(xk2<T> xk2Var) {
            this.d = xk2Var;
            this.a = ((xk2) xk2Var).a.iterator();
        }

        private final void a() {
            if (this.a.hasNext()) {
                T next = this.a.next();
                if (((Boolean) ((xk2) this.d).b.invoke(next)).booleanValue()) {
                    this.b = 1;
                    this.c = next;
                    return;
                }
            }
            this.b = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b == -1) {
                a();
            }
            return this.b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.b == -1) {
                a();
            }
            if (this.b != 0) {
                T t = this.c;
                this.c = null;
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
    public xk2(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        b41.i(sequence, "sequence");
        b41.i(function1, "predicate");
        this.a = sequence;
        this.b = function1;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new C9932a(this);
    }
}
