package kotlin.sequences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.dd0;
import tb.oj0;
import tb.up2;
import tb.xk2;
import tb.zj0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SequencesKt___SequencesKt extends g {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a<T> implements Iterable<T>, KMappedMarker {
        final /* synthetic */ Sequence a;

        public a(Sequence sequence) {
            this.a = sequence;
        }

        @Override // java.lang.Iterable
        @NotNull
        public Iterator<T> iterator() {
            return this.a.iterator();
        }
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C A(@NotNull Sequence<? extends T> sequence, @NotNull C c) {
        b41.i(sequence, "<this>");
        b41.i(c, "destination");
        for (T t : sequence) {
            c.add(t);
        }
        return c;
    }

    @NotNull
    public static <T> List<T> B(@NotNull Sequence<? extends T> sequence) {
        List C;
        List<T> n;
        b41.i(sequence, "<this>");
        C = C(sequence);
        n = m.n(C);
        return n;
    }

    @NotNull
    public static <T> List<T> C(@NotNull Sequence<? extends T> sequence) {
        b41.i(sequence, "<this>");
        return (List) A(sequence, new ArrayList());
    }

    @NotNull
    public static <T> Iterable<T> l(@NotNull Sequence<? extends T> sequence) {
        b41.i(sequence, "<this>");
        return new a(sequence);
    }

    public static <T> int m(@NotNull Sequence<? extends T> sequence) {
        b41.i(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next();
            i++;
            if (i < 0) {
                m.o();
            }
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <T> Sequence<T> n(@NotNull Sequence<? extends T> sequence, int i) {
        b41.i(sequence, "<this>");
        if (i >= 0) {
            return i == 0 ? sequence : sequence instanceof DropTakeSequence ? ((DropTakeSequence) sequence).drop(i) : new dd0(sequence, i);
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @NotNull
    public static <T> Sequence<T> o(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        b41.i(sequence, "<this>");
        b41.i(function1, "predicate");
        return new oj0(sequence, true, function1);
    }

    @NotNull
    public static <T> Sequence<T> p(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        b41.i(sequence, "<this>");
        b41.i(function1, "predicate");
        return new oj0(sequence, false, function1);
    }

    @NotNull
    public static <T> Sequence<T> q(@NotNull Sequence<? extends T> sequence) {
        Sequence<T> p;
        b41.i(sequence, "<this>");
        p = p(sequence, new Function1<T, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$filterNotNull$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@Nullable T t) {
                return Boolean.valueOf(t == null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return invoke((SequencesKt___SequencesKt$filterNotNull$1<T>) obj);
            }
        });
        b41.g(p, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return p;
    }

    public static <T> T r(@NotNull Sequence<? extends T> sequence) {
        b41.i(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    @Nullable
    public static <T> T s(@NotNull Sequence<? extends T> sequence) {
        b41.i(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    @NotNull
    public static <T, R> Sequence<R> t(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends Sequence<? extends R>> function1) {
        b41.i(sequence, "<this>");
        b41.i(function1, "transform");
        return new zj0(sequence, function1, SequencesKt___SequencesKt$flatMap$2.INSTANCE);
    }

    public static <T> T u(@NotNull Sequence<? extends T> sequence) {
        b41.i(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    @NotNull
    public static <T, R> Sequence<R> v(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1) {
        b41.i(sequence, "<this>");
        b41.i(function1, "transform");
        return new up2(sequence, function1);
    }

    @NotNull
    public static <T, R> Sequence<R> w(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1) {
        Sequence<R> q;
        b41.i(sequence, "<this>");
        b41.i(function1, "transform");
        q = q(new up2(sequence, function1));
        return q;
    }

    @NotNull
    public static <T> Sequence<T> x(@NotNull Sequence<? extends T> sequence, @NotNull Iterable<? extends T> iterable) {
        Sequence I;
        b41.i(sequence, "<this>");
        b41.i(iterable, "elements");
        I = CollectionsKt___CollectionsKt.I(iterable);
        return SequencesKt__SequencesKt.f(SequencesKt__SequencesKt.k(sequence, I));
    }

    @NotNull
    public static <T> Sequence<T> y(@NotNull Sequence<? extends T> sequence, T t) {
        b41.i(sequence, "<this>");
        return SequencesKt__SequencesKt.f(SequencesKt__SequencesKt.k(sequence, SequencesKt__SequencesKt.k(t)));
    }

    @NotNull
    public static <T> Sequence<T> z(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, Boolean> function1) {
        b41.i(sequence, "<this>");
        b41.i(function1, "predicate");
        return new xk2(sequence, function1);
    }
}
