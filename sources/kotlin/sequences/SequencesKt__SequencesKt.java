package kotlin.sequences;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Iterator;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.C9268in;
import tb.b41;
import tb.up2;
import tb.zj0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SequencesKt__SequencesKt extends C8579f {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Taobao */
    /* renamed from: kotlin.sequences.SequencesKt__SequencesKt$a */
    /* loaded from: classes3.dex */
    public static final class C8570a<T> implements Sequence<T> {
        final /* synthetic */ Iterator a;

        public C8570a(Iterator it) {
            this.a = it;
        }

        @Override // kotlin.sequences.Sequence
        @NotNull
        public Iterator<T> iterator() {
            return this.a;
        }
    }

    @NotNull
    public static <T> Sequence<T> c(@NotNull Iterator<? extends T> it) {
        b41.i(it, "<this>");
        return d(new C8570a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Sequence<T> d(@NotNull Sequence<? extends T> sequence) {
        b41.i(sequence, "<this>");
        return sequence instanceof C9268in ? sequence : new C9268in(sequence);
    }

    @NotNull
    public static <T> Sequence<T> e() {
        return C8572a.INSTANCE;
    }

    @NotNull
    public static final <T> Sequence<T> f(@NotNull Sequence<? extends Sequence<? extends T>> sequence) {
        b41.i(sequence, "<this>");
        return g(sequence, new Function1<Sequence<? extends T>, Iterator<? extends T>>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$flatten$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((Sequence) ((Sequence) obj));
            }

            @NotNull
            public final Iterator<T> invoke(@NotNull Sequence<? extends T> sequence2) {
                b41.i(sequence2, AdvanceSetting.NETWORK_TYPE);
                return (Iterator<? extends T>) sequence2.iterator();
            }
        });
    }

    private static final <T, R> Sequence<R> g(Sequence<? extends T> sequence, Function1<? super T, ? extends Iterator<? extends R>> function1) {
        if (sequence instanceof up2) {
            return ((up2) sequence).c(function1);
        }
        return new zj0(sequence, new Function1<T, T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$flatten$3
            @Override // kotlin.jvm.functions.Function1
            public final T invoke(T t) {
                return t;
            }
        }, function1);
    }

    @LowPriorityInOverloadResolution
    @NotNull
    public static <T> Sequence<T> h(@Nullable final T t, @NotNull Function1<? super T, ? extends T> function1) {
        b41.i(function1, "nextFunction");
        if (t == null) {
            return C8572a.INSTANCE;
        }
        return new C8573b(new Function0<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$generateSequence$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final T invoke() {
                return t;
            }
        }, function1);
    }

    @NotNull
    public static <T> Sequence<T> i(@NotNull final Function0<? extends T> function0) {
        b41.i(function0, "nextFunction");
        return d(new C8573b(function0, new Function1<T, T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$generateSequence$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final T invoke(@NotNull T t) {
                b41.i(t, AdvanceSetting.NETWORK_TYPE);
                return function0.invoke();
            }
        }));
    }

    @NotNull
    public static <T> Sequence<T> j(@NotNull Function0<? extends T> function0, @NotNull Function1<? super T, ? extends T> function1) {
        b41.i(function0, "seedFunction");
        b41.i(function1, "nextFunction");
        return new C8573b(function0, function1);
    }

    @NotNull
    public static final <T> Sequence<T> k(@NotNull T... tArr) {
        Sequence<T> o;
        Sequence<T> e;
        b41.i(tArr, "elements");
        if (tArr.length == 0) {
            e = e();
            return e;
        }
        o = ArraysKt___ArraysKt.o(tArr);
        return o;
    }
}
