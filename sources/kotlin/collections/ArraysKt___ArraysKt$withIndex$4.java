package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.s7;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class ArraysKt___ArraysKt$withIndex$4 extends Lambda implements Function0<Iterator<? extends Integer>> {
    final /* synthetic */ int[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ArraysKt___ArraysKt$withIndex$4(int[] iArr) {
        super(0);
        this.$this_withIndex = iArr;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Iterator<? extends Integer> invoke() {
        return s7.f(this.$this_withIndex);
    }
}
