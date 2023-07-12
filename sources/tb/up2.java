package tb;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class up2<T, R> implements Sequence<R> {
    @NotNull
    private final Sequence<T> a;
    @NotNull
    private final Function1<T, R> b;

    /* compiled from: Taobao */
    /* renamed from: tb.up2$a */
    /* loaded from: classes3.dex */
    public static final class C9783a implements Iterator<R>, KMappedMarker {
        @NotNull
        private final Iterator<T> a;
        final /* synthetic */ up2<T, R> b;

        C9783a(up2<T, R> up2Var) {
            this.b = up2Var;
            this.a = ((up2) up2Var).a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) ((up2) this.b).b.invoke(this.a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public up2(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1) {
        b41.i(sequence, "sequence");
        b41.i(function1, "transformer");
        this.a = sequence;
        this.b = function1;
    }

    @NotNull
    public final <E> Sequence<E> c(@NotNull Function1<? super R, ? extends Iterator<? extends E>> function1) {
        b41.i(function1, "iterator");
        return new zj0(this.a, this.b, function1);
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<R> iterator() {
        return new C9783a(this);
    }
}
