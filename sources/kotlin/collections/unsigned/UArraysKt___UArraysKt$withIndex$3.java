package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.mr2;
import tb.nr2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class UArraysKt___UArraysKt$withIndex$3 extends Lambda implements Function0<Iterator<? extends mr2>> {
    final /* synthetic */ byte[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UArraysKt___UArraysKt$withIndex$3(byte[] bArr) {
        super(0);
        this.$this_withIndex = bArr;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Iterator<? extends mr2> invoke() {
        return nr2.a(this.$this_withIndex);
    }
}
