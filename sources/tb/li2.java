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
public final class li2<T> implements Sequence<T>, DropTakeSequence<T> {
    @NotNull
    private final Sequence<T> a;
    private final int b;
    private final int c;

    /* compiled from: Taobao */
    /* renamed from: tb.li2$a */
    /* loaded from: classes3.dex */
    public static final class C9414a implements Iterator<T>, KMappedMarker {
        @NotNull
        private final Iterator<T> a;
        private int b;
        final /* synthetic */ li2<T> c;

        C9414a(li2<T> li2Var) {
            this.c = li2Var;
            this.a = ((li2) li2Var).a.iterator();
        }

        private final void a() {
            while (this.b < ((li2) this.c).b && this.a.hasNext()) {
                this.a.next();
                this.b++;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.b < ((li2) this.c).c && this.a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (this.b < ((li2) this.c).c) {
                this.b++;
                return this.a.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public li2(@NotNull Sequence<? extends T> sequence, int i, int i2) {
        b41.i(sequence, "sequence");
        this.a = sequence;
        this.b = i;
        this.c = i2;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i).toString());
        }
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i2).toString());
        }
        if (i2 >= i) {
            return;
        }
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i2 + " < " + i).toString());
    }

    private final int d() {
        return this.c - this.b;
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    public Sequence<T> drop(int i) {
        Sequence<T> e;
        if (i >= d()) {
            e = SequencesKt__SequencesKt.e();
            return e;
        }
        return new li2(this.a, this.b + i, this.c);
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new C9414a(this);
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    public Sequence<T> take(int i) {
        if (i >= d()) {
            return this;
        }
        Sequence<T> sequence = this.a;
        int i2 = this.b;
        return new li2(sequence, i2, i + i2);
    }
}
