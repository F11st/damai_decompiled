package kotlin.sequences;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import tb.ge0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class a implements DropTakeSequence, Sequence {
    @NotNull
    public static final a INSTANCE = new a();

    private a() {
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    /* renamed from: a */
    public a drop(int i) {
        return INSTANCE;
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    /* renamed from: b */
    public a take(int i) {
        return INSTANCE;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator iterator() {
        return ge0.INSTANCE;
    }
}
