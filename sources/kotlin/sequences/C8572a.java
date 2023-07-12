package kotlin.sequences;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import tb.ge0;

/* compiled from: Taobao */
/* renamed from: kotlin.sequences.a */
/* loaded from: classes3.dex */
final class C8572a implements DropTakeSequence, Sequence {
    @NotNull
    public static final C8572a INSTANCE = new C8572a();

    private C8572a() {
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    /* renamed from: a */
    public C8572a drop(int i) {
        return INSTANCE;
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    /* renamed from: b */
    public C8572a take(int i) {
        return INSTANCE;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator iterator() {
        return ge0.INSTANCE;
    }
}
