package kotlin.coroutines;

import io.flutter.wpkbridge.WPKFactory;
import kotlin.SinceKotlin;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@SinceKotlin(version = "1.3")
/* loaded from: classes3.dex */
public interface CoroutineContext {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        @NotNull
        public static CoroutineContext a(@NotNull CoroutineContext coroutineContext, @NotNull CoroutineContext coroutineContext2) {
            b41.i(coroutineContext2, WPKFactory.INIT_KEY_CONTEXT);
            return coroutineContext2 == EmptyCoroutineContext.INSTANCE ? coroutineContext : (CoroutineContext) coroutineContext2.fold(coroutineContext, new Function2<CoroutineContext, Element, CoroutineContext>() { // from class: kotlin.coroutines.CoroutineContext$plus$1
                @Override // kotlin.jvm.functions.Function2
                @NotNull
                public final CoroutineContext invoke(@NotNull CoroutineContext coroutineContext3, @NotNull CoroutineContext.Element element) {
                    CombinedContext combinedContext;
                    b41.i(coroutineContext3, "acc");
                    b41.i(element, "element");
                    CoroutineContext minusKey = coroutineContext3.minusKey(element.getKey());
                    EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
                    if (minusKey == emptyCoroutineContext) {
                        return element;
                    }
                    ContinuationInterceptor.b bVar = ContinuationInterceptor.Key;
                    ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) minusKey.get(bVar);
                    if (continuationInterceptor == null) {
                        combinedContext = new CombinedContext(minusKey, element);
                    } else {
                        CoroutineContext minusKey2 = minusKey.minusKey(bVar);
                        if (minusKey2 == emptyCoroutineContext) {
                            return new CombinedContext(element, continuationInterceptor);
                        }
                        combinedContext = new CombinedContext(new CombinedContext(minusKey2, element), continuationInterceptor);
                    }
                    return combinedContext;
                }
            });
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface Element extends CoroutineContext {

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public static final class a {
            public static <R> R a(@NotNull Element element, R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2) {
                b41.i(function2, "operation");
                return function2.invoke(r, element);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Nullable
            public static <E extends Element> E b(@NotNull Element element, @NotNull Key<E> key) {
                b41.i(key, "key");
                if (b41.d(element.getKey(), key)) {
                    b41.g(element, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                    return element;
                }
                return null;
            }

            @NotNull
            public static CoroutineContext c(@NotNull Element element, @NotNull Key<?> key) {
                b41.i(key, "key");
                return b41.d(element.getKey(), key) ? EmptyCoroutineContext.INSTANCE : element;
            }

            @NotNull
            public static CoroutineContext d(@NotNull Element element, @NotNull CoroutineContext coroutineContext) {
                b41.i(coroutineContext, WPKFactory.INIT_KEY_CONTEXT);
                return DefaultImpls.a(element, coroutineContext);
            }
        }

        @Override // kotlin.coroutines.CoroutineContext
        <R> R fold(R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2);

        @Override // kotlin.coroutines.CoroutineContext
        @Nullable
        <E extends Element> E get(@NotNull Key<E> key);

        @NotNull
        Key<?> getKey();

        @Override // kotlin.coroutines.CoroutineContext
        @NotNull
        CoroutineContext minusKey(@NotNull Key<?> key);
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface Key<E extends Element> {
    }

    <R> R fold(R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2);

    @Nullable
    <E extends Element> E get(@NotNull Key<E> key);

    @NotNull
    CoroutineContext minusKey(@NotNull Key<?> key);

    @NotNull
    CoroutineContext plus(@NotNull CoroutineContext coroutineContext);
}
