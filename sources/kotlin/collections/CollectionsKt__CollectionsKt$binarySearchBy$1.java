package kotlin.collections;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.ul;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class CollectionsKt__CollectionsKt$binarySearchBy$1 extends Lambda implements Function1<Object, Integer> {
    final /* synthetic */ Comparable $key;
    final /* synthetic */ Function1<Object, Comparable> $selector;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionsKt__CollectionsKt$binarySearchBy$1(Function1<Object, Comparable> function1, Comparable comparable) {
        super(1);
        this.$selector = function1;
        this.$key = comparable;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Integer invoke(Object obj) {
        int a;
        a = ul.a(this.$selector.invoke(obj), this.$key);
        return Integer.valueOf(a);
    }
}
