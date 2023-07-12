package tb;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.DropTakeSequence;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class dd0<T> implements Sequence<T>, DropTakeSequence<T> {
    @NotNull
    private final Sequence<T> a;
    private final int b;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a implements Iterator<T>, KMappedMarker {
        @NotNull
        private final Iterator<T> a;
        private int b;

        a(dd0<T> dd0Var) {
            this.a = ((dd0) dd0Var).a.iterator();
            this.b = ((dd0) dd0Var).b;
        }

        private final void a() {
            while (this.b > 0 && this.a.hasNext()) {
                this.a.next();
                this.b--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            return this.a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public dd0(@NotNull Sequence<? extends T> sequence, int i) {
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
        int i2 = this.b + i;
        return i2 < 0 ? new dd0(this, i) : new dd0(this.a, i2);
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    public Sequence<T> take(int i) {
        int i2 = this.b;
        int i3 = i2 + i;
        return i3 < 0 ? new wk2(this, i) : new li2(this.a, i2, i3);
    }
}
