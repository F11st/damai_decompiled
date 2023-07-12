package tb;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.DropTakeSequence;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class wk2<T> implements Sequence<T>, DropTakeSequence<T> {
    @NotNull
    private final Sequence<T> a;
    private final int b;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a implements Iterator<T>, KMappedMarker {
        private int a;
        @NotNull
        private final Iterator<T> b;

        a(wk2<T> wk2Var) {
            this.a = ((wk2) wk2Var).b;
            this.b = ((wk2) wk2Var).a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a > 0 && this.b.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            int i = this.a;
            if (i != 0) {
                this.a = i - 1;
                return this.b.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public wk2(@NotNull Sequence<? extends T> sequence, int i) {
        b41.i(sequence, "sequence");
        this.a = sequence;
        this.b = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    public Sequence<T> drop(int i) {
        Sequence<T> e;
        int i2 = this.b;
        if (i >= i2) {
            e = SequencesKt__SequencesKt.e();
            return e;
        }
        return new li2(this.a, i, i2);
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    public Sequence<T> take(int i) {
        return i >= this.b ? this : new wk2(this.a, i);
    }
}
