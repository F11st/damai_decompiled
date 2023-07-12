package kotlin.sequences;

import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.hq2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class SequencesKt___SequencesKt$zip$1 extends Lambda implements Function2<Object, Object, Pair<Object, Object>> {
    public static final SequencesKt___SequencesKt$zip$1 INSTANCE = new SequencesKt___SequencesKt$zip$1();

    SequencesKt___SequencesKt$zip$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    @NotNull
    public final Pair<Object, Object> invoke(Object obj, Object obj2) {
        return hq2.a(obj, obj2);
    }
}
