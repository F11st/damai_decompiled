package tb;

import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@SinceKotlin(version = "1.3")
@ExperimentalStdlibApi
/* loaded from: classes3.dex */
public abstract class o1<B extends CoroutineContext.Element, E extends B> implements CoroutineContext.Key<E> {
    @NotNull
    private final Function1<CoroutineContext.Element, E> a;
    @NotNull
    private final CoroutineContext.Key<?> b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.functions.Function1<? super kotlin.coroutines.CoroutineContext$Element, ? extends E extends B>, java.lang.Object, kotlin.jvm.functions.Function1<kotlin.coroutines.CoroutineContext$Element, E extends B>] */
    public o1(@NotNull CoroutineContext.Key<B> key, @NotNull Function1<? super CoroutineContext.Element, ? extends E> function1) {
        b41.i(key, "baseKey");
        b41.i(function1, "safeCast");
        this.a = function1;
        this.b = key instanceof o1 ? (CoroutineContext.Key<B>) ((o1) key).b : key;
    }

    public final boolean a(@NotNull CoroutineContext.Key<?> key) {
        b41.i(key, "key");
        return key == this || this.b == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/CoroutineContext$Element;)TE; */
    @Nullable
    public final CoroutineContext.Element b(@NotNull CoroutineContext.Element element) {
        b41.i(element, "element");
        return (CoroutineContext.Element) this.a.invoke(element);
    }
}
