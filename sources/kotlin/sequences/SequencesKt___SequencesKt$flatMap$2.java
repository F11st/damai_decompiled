package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
/* synthetic */ class SequencesKt___SequencesKt$flatMap$2<R> extends FunctionReferenceImpl implements Function1<Sequence<? extends R>, Iterator<? extends R>> {
    public static final SequencesKt___SequencesKt$flatMap$2 INSTANCE = new SequencesKt___SequencesKt$flatMap$2();

    SequencesKt___SequencesKt$flatMap$2() {
        super(1, Sequence.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((Sequence) ((Sequence) obj));
    }

    @NotNull
    public final Iterator<R> invoke(@NotNull Sequence<? extends R> sequence) {
        b41.i(sequence, "p0");
        return (Iterator<? extends R>) sequence.iterator();
    }
}
