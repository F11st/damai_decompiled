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
public final class oj0<T> implements Sequence<T> {
    @NotNull
    private final Sequence<T> a;
    private final boolean b;
    @NotNull
    private final Function1<T, Boolean> c;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a implements Iterator<T>, KMappedMarker {
        @NotNull
        private final Iterator<T> a;
        private int b = -1;
        @Nullable
        private T c;
        final /* synthetic */ oj0<T> d;

        a(oj0<T> oj0Var) {
            this.d = oj0Var;
            this.a = ((oj0) oj0Var).a.iterator();
        }

        private final void a() {
            while (this.a.hasNext()) {
                T next = this.a.next();
                if (((Boolean) ((oj0) this.d).c.invoke(next)).booleanValue() == ((oj0) this.d).b) {
                    this.c = next;
                    this.b = 1;
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
    public oj0(@NotNull Sequence<? extends T> sequence, boolean z, @NotNull Function1<? super T, Boolean> function1) {
        b41.i(sequence, "sequence");
        b41.i(function1, "predicate");
        this.a = sequence;
        this.b = z;
        this.c = function1;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }
}
