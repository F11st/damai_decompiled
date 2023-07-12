package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.cs2;
import tb.ds2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class UArraysKt___UArraysKt$withIndex$2 extends Lambda implements Function0<Iterator<? extends cs2>> {
    final /* synthetic */ long[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UArraysKt___UArraysKt$withIndex$2(long[] jArr) {
        super(0);
        this.$this_withIndex = jArr;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Iterator<? extends cs2> invoke() {
        return ds2.a(this.$this_withIndex);
    }
}
